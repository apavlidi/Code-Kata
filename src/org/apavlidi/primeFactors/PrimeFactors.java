package org.apavlidi.primeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {


    public static List<Integer> generate(int number) {
        ArrayList<Integer> primeFactors = new ArrayList<>();

        for (int canditate = 2; number > 1; canditate++)
            for (; number % canditate == 0; number /= canditate) {
                primeFactors.add(canditate);
            }

        return primeFactors;
    }
}
