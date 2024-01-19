package org.example;

import java.util.Calendar;

public class MyDate {
    private Calendar calendar;

    public MyDate() {
        this.calendar = Calendar.getInstance();
    }

    public MyDate(long milliseconds) {
        this.calendar = Calendar.getInstance();
        this.calendar.setTimeInMillis(milliseconds);
    }

    public MyDate(int year, int month, int day) {
        this.calendar = Calendar.getInstance();
        this.calendar.set(year, month - 1, day);
    }

    public boolean after(MyDate myDate) {
        return this.calendar.after(myDate.calendar);
    }

    public boolean before(MyDate myDate) {
        return this.calendar.before(myDate.calendar);
    }

    public int compareTo(MyDate myDate) {
        return this.calendar.compareTo(myDate.calendar);
    }

    public long getTime() {
        return this.calendar.getTimeInMillis();
    }

    public void setTime(long time) {
        this.calendar.setTimeInMillis(time);
    }
}
