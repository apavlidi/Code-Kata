package org.apavlidi.bank.src.main.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {


  public String getCurrentDate() {
    LocalDate today = today();
    return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  protected LocalDate today() {
    return LocalDate.now();
  }
}
