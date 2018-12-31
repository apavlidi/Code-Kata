package org.apavlidi.fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzShould {

    @Test
    public void return_fizz_when_number_is_3() {
        assertEquals(FizzBuzz.convert(3), "Fizz");
    }

    @Test
    public void return_fizz_when_number_is_6() {
        assertEquals(FizzBuzz.convert(6), "Fizz");
    }

    @Test
    public void return_buzz_when_number_is_5() {
        assertEquals(FizzBuzz.convert(5), "Buzz");
    }

    @Test
    public void return_buzz_when_number_is_10() {
        assertEquals(FizzBuzz.convert(10), "Buzz");
    }

    @Test
    public void return_same_number_when_number_is_not_divisible_by_3_or_5() {
        assertEquals(FizzBuzz.convert(11), "11");
    }

    @Test
    public void return_fizzBuzz_when_number_is_divisible_by_3_and_5() {
        assertEquals(FizzBuzz.convert(15), "FizzBuzz");
    }

}
