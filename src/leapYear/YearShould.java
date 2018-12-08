package leapYear;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class YearShould {

    @Test
    public void
    not_a_leap_year_if_not_divisible_by_4() {
        assertEquals(isLeapYear(2017), false);

    }

    @Test
    public void
    is_a_leap_year_if_divisible_by_4_but_not_by_100() {
        assertEquals(isLeapYear(2016), true);

    }

    @Test
    public void
    not_a_leap_year_if_divisible_by_100_but_not_by_400() {
        assertEquals(isLeapYear(1700), false);

    }

    @Test
    public void
    is_a_leap_year_if_divisible_by_400() {
        assertEquals(isLeapYear(2000), true);
    }

    private boolean isLeapYear(int year) {
        return new Year(year).isLeapYear();
    }

}
