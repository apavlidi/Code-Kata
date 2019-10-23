package org.apavlidi.bank.src.main.java;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class StatementPrinter {

  public static final String DELIMITER = " | ";
  private Console console;
  private String HEADER = "DATE       | AMOUNT  | BALANCE";
  private DecimalFormat decimalFormat = new DecimalFormat("#.00");

  public StatementPrinter(Console console) {
    this.console = console;
  }

  public void print(List<Transaction> transactions) {
    printHeader();
    int balance = 0;

    List<String> result = new ArrayList<>();
    for (Transaction transaction : transactions) {
      balance += transaction.getAmount();
      result.add(transaction.getDate()
          + DELIMITER
          + decimalFormat.format(transaction.getAmount())
          + DELIMITER
          + decimalFormat.format(balance));
    }

    printReverse(result);
  }

  private void printReverse(List<String> result) {
    for (int i = result.size() - 1; i >= 0; i--) {
      console.printLine(result.get(i));
    }
  }

  private void printHeader() {
    console.printLine(HEADER);
  }
}
