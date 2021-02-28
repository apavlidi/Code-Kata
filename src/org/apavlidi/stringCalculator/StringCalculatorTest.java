package org.apavlidi.stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  public void returns_same_number_when_passed_only_one_number() {
    assertEquals(0, new StringCalculator().add("0"));
  }

  @Test
  public void returns_the_sum_of_two_numbers() {
    assertEquals(4, new StringCalculator().add("1,3"));
  }

  @Test
  public void handles_new_lines_as_commas() {
    assertEquals(6, new StringCalculator().add("1\n2,3"));
  }

  @Test
  public void handles_custom_delimiter() {
    assertEquals(3, new StringCalculator().add("//;\\n1;2"));
  }

  @Test
  public void throws_NegativesNotAllowed_when_passing_negative_number() {
    assertThrows(NegativeNotAllowed.class, () -> new StringCalculator().add("-1"));
  }

  @Test
  public void throws_NegativesNotAllowed_with_numbers_as_a_message_when_passing_negative_number() {
    Exception exception  = assertThrows(NegativeNotAllowed.class, () -> new StringCalculator().add("-1,-3"));
    assertEquals(exception.getMessage(), "-1-3");
  }

  @Test
  public void ignores_numbers_bigger_than_1000() {
    assertEquals(1, new StringCalculator().add("1,1001"));
  }

  @Test
  public void handles_custom_delimiter2() {
    assertEquals(6, new StringCalculator().add("//[***]\\n1***2***3"));
  }

}
