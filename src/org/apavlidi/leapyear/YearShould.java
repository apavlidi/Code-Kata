package org.apavlidi.leapyear;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class YearShould {

    @Test
    public void
    not_a_leap_year_if_not_divisible_by_4() {
        assertFalse(isLeapYear(1997));
    }

    @Test
    public void
    a_leap_year_if_divisible_by_4() {
        assertTrue(isLeapYear(1996));
    }

    @Test
    public void
    not_a_leap_year_if_divisible_by_100_but_not_by_400() {
        assertFalse
            (isLeapYear(1800));
    }

    @Test
    public void
    is_a_leap_year_if_divisible_by_400() {
        assertTrue(isLeapYear(1600));
    }

    private boolean isLeapYear(int year) {
        return new Year(year).isLeapYear();
    }

}
