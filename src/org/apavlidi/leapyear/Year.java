package org.apavlidi.leapyear;

public class Year {

  private int year;

  public Year(int year) {
    this.year = year;
  }

  public boolean isLeapYear() {
    return isDividedBy(4) && !(isDividedBy(100) && isNotDividedBy(400));
  }

  private boolean isNotDividedBy(int number) {
    return year % number != 0;
  }

  private boolean isDividedBy(int number) {
    return year % number == 0;
  }
}
