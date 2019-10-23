package org.apavlidi.bank.src.main.java;

import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

  private static final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
  private StatementPrinter statementPrinter;
  @Mock
  private Console console;

  @Before
  public void initialise() {
    statementPrinter = new StatementPrinter(console);
  }

  @Test
  public void always_print_the_header() {
    statementPrinter.print(NO_TRANSACTIONS);

    verify(console).printLine("DATE       | AMOUNT  | BALANCE");
  }

  @Test
  public void print_transaction_statement_in_reverse_chronogical_order() {
    statementPrinter.print(Arrays.asList(
        new Transaction("01/04/2014", 1000),
        new Transaction("02/04/2014", -100),
        new Transaction("10/04/2014", 500)));

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).printLine("DATE       | AMOUNT  | BALANCE");
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");

  }

}