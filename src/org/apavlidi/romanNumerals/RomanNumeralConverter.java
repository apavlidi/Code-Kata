package org.apavlidi.romanNumerals;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

  public static String convert(int decimal) {
    StringBuilder result = new StringBuilder();
    Map<String, Integer> romanNumerals = initializeRomanNumerals();

    for (String roman : romanNumerals.keySet()) {
      while (decimal >= romanNumerals.get(roman)) {
        result.append(roman);
        decimal -= romanNumerals.get(roman);
      }
    }

    return result.toString();
  }

  private static LinkedHashMap<String, Integer> initializeRomanNumerals() {
    return new LinkedHashMap<String, Integer>() {{
      put("M", 1000);
      put("CM", 900);
      put("D", 500);
      put("CD", 400);
      put("C", 100);
      put("XC", 90);
      put("L", 50);
      put("XL", 40);
      put("X", 10);
      put("IX", 9);
      put("V", 5);
      put("IV", 4);
      put("I", 1);
    }};
  }

}
