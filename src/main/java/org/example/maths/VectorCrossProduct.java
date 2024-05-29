package org.example.maths;

public class VectorCrossProduct {

    int x;
    int y;
    int z;

    VectorCrossProduct() {
        x = 0;
        y = 0;
        z = 0;
    }

    VectorCrossProduct(int _x, int _y, int _z) {
        x = _x;
        y = _y;
        z = _z;
    }

    double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    int dotProduct(VectorCrossProduct b) {
        return x * b.x + y * b.y + z * b.z;
    }

    VectorCrossProduct crossProduct(VectorCrossProduct b) {
        VectorCrossProduct product = new VectorCrossProduct();
        product.x = (y * b.z) - (z * b.y);
        product.y = -((x * b.z) - (z * b.x));
        product.z = (x * b.y) - (y * b.x);
        return product;
    }

    void displayVector() {
        System.out.println("x : " + x + "\ty : " + y + "\tz : " + z);
    }


}
