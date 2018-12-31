package org.apavlidi.fizzBuzz;

public class FizzBuzz {
    public static String convert(int number) {
        if ((isDivisibleBy(number, 3)) && (isDivisibleBy(number, 5)))
            return "FizzBuzz";
        if (isDivisibleBy(number, 3))
            return "Fizz";
        if (isDivisibleBy(number, 5))
            return "Buzz";
        return Integer.toString(number);
    }

    private static boolean isDivisibleBy(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
}
