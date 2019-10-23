package org.apavlidi.bank.test.java.acceptance;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

import org.apavlidi.bank.src.main.java.Account;
import org.apavlidi.bank.src.main.java.Clock;
import org.apavlidi.bank.src.main.java.Console;
import org.apavlidi.bank.src.main.java.StatementPrinter;
import org.apavlidi.bank.src.main.java.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

  @Mock
  private Console console;

  @Mock
  private Clock clock;

  private Account account;
  private TransactionRepository transactionRepository;
  private StatementPrinter statementPrinter;

  @Before
  public void initialise() {
    statementPrinter = new StatementPrinter(console);
    transactionRepository = new TransactionRepository(clock);
    account = new Account(transactionRepository, statementPrinter);
  }

  @Test
  public void print_statement_containing_all_transactions() {
    given(clock.getCurrentDate()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");

    account.deposit(1000);
    account.withdrawal(100);
    account.deposit(500);

    account.printStatement();

    InOrder inOrder = inOrder(console);
    inOrder.verify(console).printLine("DATE       | AMOUNT  | BALANCE");
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");


  }

}
