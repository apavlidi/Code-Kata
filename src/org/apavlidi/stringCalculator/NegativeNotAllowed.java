package org.apavlidi.stringCalculator;

public class NegativeNotAllowed extends RuntimeException {

  private String negativeNumbers;

  public NegativeNotAllowed(String negativeNumbers) {

    this.negativeNumbers = negativeNumbers;
  }

  @Override
  public String getMessage() {
    return negativeNumbers;
  }
}
