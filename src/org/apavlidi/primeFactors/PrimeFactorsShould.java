package org.apavlidi.primeFactors;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeFactorsShould {

    @Test
    public void testOne() {
        assertEquals(list(), PrimeFactors.generate(1));
    }

    @Test
    public void testTwo() {
        assertEquals(list(2), PrimeFactors.generate(2));
    }

    @Test
    public void testThree() {
        assertEquals(list(3), PrimeFactors.generate(3));
    }

    @Test
    public void testFour() {
        assertEquals(list(2, 2), PrimeFactors.generate(4));
    }

    @Test
    public void testSixth() {
        assertEquals(list(2, 3), PrimeFactors.generate(6));
    }

    @Test
    public void testEight() {
        assertEquals(list(2, 2, 2), PrimeFactors.generate(8));
    }

    @Test
    public void testNine() {
        assertEquals(list(3, 3), PrimeFactors.generate(9));
    }


    private List<Integer> list(int... factorNumbers) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        for (int factorNumber : factorNumbers) {
            listOfNumbers.add(factorNumber);
        }

        return listOfNumbers;
    }

}
