package org.apavlidi.fizzBuzz;

public class FizzBuzz {

    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static String printNumber(int number) {
        if (isDivisibleBy(number, 3) && isDivisibleBy(number, 5)) {
            return FIZZ_BUZZ;
        } else if (isDivisibleBy(number, 3)) {
            return FIZZ;
        } else if (isDivisibleBy(number, 5)) {
            return BUZZ;
        }
        return Integer.toString(number);
    }

    private static boolean isDivisibleBy(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
}