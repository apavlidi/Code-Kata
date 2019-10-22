package org.apavlidi.romanNumerals;

import static org.apavlidi.romanNumerals.RomanNumeralConverter.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class RomanNumeralConverterShould {

  @Test
  public void convert_decimal_to_roman_numeral() {
    assertThat(convert(1), is("I"));
    assertThat(convert(2), is("II"));
    assertThat(convert(3), is("III"));
    assertThat(convert(4), is("IV"));
    assertThat(convert(5), is("V"));
    assertThat(convert(6), is("VI"));
    assertThat(convert(8), is("VIII"));
    assertThat(convert(9), is("IX"));
    assertThat(convert(10), is("X"));
    assertThat(convert(11), is("XI"));
    assertThat(convert(20), is("XX"));
    assertThat(convert(30), is("XXX"));
    assertThat(convert(50), is("L"));
    assertThat(convert(40), is("XL"));
    assertThat(convert(60), is("LX"));
    assertThat(convert(70), is("LXX"));
    assertThat(convert(100), is("C"));
    assertThat(convert(2019), is("MMXIX"));
    assertThat(convert(3724), is("MMMDCCXXIV"));
    assertThat(convert(3724), is("MMMDCCXXIV"));
    assertThat(convert(3949), is("MMMCMXLIX"));
  }

}
