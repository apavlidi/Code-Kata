package org.apavlidi.leapyear;

public class Year {

    private int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
        return isDevidedBy(4) && !(isNotDevidedBy(100) && isDevidedBy(400));
    }

    private boolean isNotDevidedBy(int number) {
        return year % number != 0;
    }

    private boolean isDevidedBy(int number) {
        return year % number == 0;
    }
}
