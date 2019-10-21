package org.apavlidi.fizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FizzBuzzShould {

    @Test
    public void is_Fizz_if_divisible_by_3() {
        assertEquals(FizzBuzz.printNumber(9), FizzBuzz.FIZZ);
    }

    @Test
    public void is_Buzz_if_divisible_by_5() {
        assertEquals(FizzBuzz.printNumber(10), FizzBuzz.BUZZ);
    }

    @Test
    public void is_FizzBuzz_if_divisible_by_3_and_5() {
        assertEquals(FizzBuzz.printNumber(15), FizzBuzz.FIZZ_BUZZ);
    }

    @Test
    public void is_number_if_not_divisible_by_3_or_5_or_both() {
        assertEquals(FizzBuzz.printNumber(11), String.valueOf(11));
    }

}