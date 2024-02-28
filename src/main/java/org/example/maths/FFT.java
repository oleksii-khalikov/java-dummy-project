package org.example.maths;

import java.util.ArrayList;
import java.util.Collections;

public class FFT {

    static class Complex {

        private double real, img;

        public Complex() {
            real = 0;
            img = 0;
        }

        public Complex(double r, double i) {
            real = r;
            img = i;
        }

        public double getReal() {
            return real;
        }

        public double getImaginary() {
            return img;
        }

        public Complex add(Complex z) {
            Complex temp = new Complex();
            temp.real = this.real + z.real;
            temp.img = this.img + z.img;
            return temp;
        }

        public Complex subtract(Complex z) {
            Complex temp = new Complex();
            temp.real = this.real - z.real;
            temp.img = this.img - z.img;
            return temp;
        }

        public Complex multiply(Complex z) {
            Complex temp = new Complex();
            temp.real = this.real * z.real - this.img * z.img;
            temp.img = this.real * z.img + this.img * z.real;
            return temp;
        }

        public Complex multiply(double n) {
            Complex temp = new Complex();
            temp.real = this.real * n;
            temp.img = this.img * n;
            return temp;
        }

        public Complex conjugate() {
            Complex temp = new Complex();
            temp.real = this.real;
            temp.img = -this.img;
            return temp;
        }

        public double abs() {
            return Math.hypot(this.real, this.img);
        }

        public Complex divide(Complex z) {
            Complex temp = new Complex();
            double d = z.abs() * z.abs();
            d = (double) Math.round(d * 1000000000d) / 1000000000d;
            temp.real = (this.real * z.real + this.img * z.img) / (d);
            temp.img = (this.img * z.real - this.real * z.img) / (d);
            return temp;
        }

        public Complex divide(double n) {
            Complex temp = new Complex();
            temp.real = this.real / n;
            temp.img = this.img / n;
            return temp;
        }
    }

    public static ArrayList<Complex> fft(ArrayList<Complex> x, boolean inverse) {
        paddingPowerOfTwo(x);
        int N = x.size();
        int log2N = findLog2(N);
        x = fftBitReversal(N, log2N, x);
        int direction = inverse ? -1 : 1;

        for (int len = 2; len <= N; len *= 2) {
            double angle = -2 * Math.PI / len * direction;
            Complex wlen = new Complex(Math.cos(angle), Math.sin(angle));
            for (int i = 0; i < N; i += len) {
                Complex w = new Complex(1, 0);
                for (int j = 0; j < len / 2; j++) {
                    Complex u = x.get(i + j);
                    Complex v = w.multiply(x.get(i + j + len / 2));
                    x.set(i + j, u.add(v));
                    x.set(i + j + len / 2, u.subtract(v));
                    w = w.multiply(wlen);
                }
            }
        }
        x = inverseFFT(N, inverse, x);
        return x;
    }

    public static int findLog2(int N) {
        int log2N = 0;
        while ((1 << log2N) < N) {
            log2N++;
        }
        return log2N;
    }

    public static ArrayList<Complex> fftBitReversal(int N, int log2N, ArrayList<Complex> x) {
        int reverse;
        for (int i = 0; i < N; i++) {
            reverse = reverseBits(i, log2N);
            if (i < reverse) {
                Collections.swap(x, i, reverse);
            }
        }
        return x;
    }

    public static ArrayList<Complex> inverseFFT(int N, boolean inverse, ArrayList<Complex> x) {
        if (inverse) {
            for (int i = 0; i < x.size(); i++) {
                Complex z = x.get(i);
                x.set(i, z.divide(N));
            }
        }
        return x;
    }

    private static int reverseBits(int num, int log2N) {
        int reversed = 0;
        for (int i = 0; i < log2N; i++) {
            if ((num & (1 << i)) != 0) {
                reversed |= 1 << (log2N - 1 - i);
            }
        }
        return reversed;
    }

    private static void paddingPowerOfTwo(ArrayList<Complex> x) {
        int n = 1;
        int oldSize = x.size();
        while (n < oldSize) {
            n *= 2;
        }
        for (int i = 0; i < n - oldSize; i++) {
            x.add(new Complex());
        }
    }
}
