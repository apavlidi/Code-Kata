package org.apavlidi.stringCalculator;

public class StringCalculator {

  public static final String NEW_LINE = "\\n";
  public static final String DEFAULT_DELIMITER = ",|\n";
  public static final String CUSTOM_DELIMITER_PREFIX = "//[";
  public static final String CUSTOM_DELIMITER_SUFFIX = "]";
  private String delimiter;

  public StringCalculator() {
    delimiter = DEFAULT_DELIMITER;
  }

  public int add(String numbers) {
    numbers = retrieveDelimiter(numbers);
    return addNumbers(numbers.split(delimiter));
  }

  private int addNumbers(String[] split) {
    checkForNegatives(split);
    int sum = 0;
    for (String num : split) {
      int parsedNumber = Integer.parseInt(num);
      if (parsedNumber > 1000) {
        continue;
      }
      sum += parsedNumber;
    }
    return sum;
  }


  private void checkForNegatives(String[] split) {
    boolean error = false;
    StringBuilder customMessage = new StringBuilder();
    for (String num : split) {
      if (Integer.parseInt(num) < 0) {
        error = true;
        customMessage.append(num);
      }
    }

    if (error) {
      throw new NegativeNotAllowed(customMessage.toString());
    }
  }

  private String retrieveDelimiter(String numbers) {
    if (customDelimiter(numbers)) {
      determineTypeOfDelimiter(numbers);
      numbers = removeDelimiterDeclaration(numbers);
    }
    return numbers;
  }

  private String removeDelimiterDeclaration(String numbers) {
    numbers = numbers.substring(numbers.indexOf(NEW_LINE) + NEW_LINE.length());
    return numbers;
  }

  private void determineTypeOfDelimiter(String numbers) {
    if (numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) {
      delimiter = numbers.substring(CUSTOM_DELIMITER_PREFIX.length(),
          numbers.indexOf(CUSTOM_DELIMITER_SUFFIX));
      delimiter = delimiter.replace("*", "\\*");
    } else {
      delimiter = numbers.substring(2, numbers.indexOf(NEW_LINE));
    }
  }

  private boolean customDelimiter(String numbers) {
    return numbers.length() > 2 && numbers.startsWith("//");
  }
}
