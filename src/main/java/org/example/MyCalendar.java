package org.example;

import java.util.Calendar;
import java.util.Date;

public class MyCalendar extends Date {
    public MyCalendar() {
        super();
    }

    public int get(int field) {
        switch (field) {
            case Calendar.YEAR:
                return getYear() + 1900;
            case Calendar.MONTH:
                return getMonth();
            case Calendar.DATE:
                return getDate();
            // Add cases for other fields as needed
            default:
                throw new IllegalArgumentException("Invalid field");
        }
    }

    public void set(int field, int value) {
        switch (field) {
            case Calendar.YEAR:
                setYear(value - 1900);
                break;
            case Calendar.MONTH:
                setMonth(value);
                break;
            case Calendar.DATE:
                setDate(value);
                break;
            // Add cases for other fields as needed
            default:
                throw new IllegalArgumentException("Invalid field");
        }
    }

    public void add(int field, int amount) {
        long time = getTime();
        switch (field) {
            case Calendar.YEAR:
                setTime(time + (amount * 365 * 24 * 60 * 60 * 1000L));
                break;
            case Calendar.MONTH:
                setTime(time + (amount * 30 * 24 * 60 * 60 * 1000L));
                break;
            case Calendar.DATE:
                setTime(time + (amount * 24 * 60 * 60 * 1000L));
                break;
            // Add cases for other fields as needed
            default:
                throw new IllegalArgumentException("Invalid field");
        }
    }
}
