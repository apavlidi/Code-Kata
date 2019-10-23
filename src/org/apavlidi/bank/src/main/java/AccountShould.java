package org.apavlidi.bank.src.main.java;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

  public static final String TODAY = "01/04/2014";

  @Mock
  private TransactionRepository transactionRepository;

  @Mock
  private StatementPrinter statementPrinter;

  private Account account;

  @Before
  public void initialise() {
    account = new Account(transactionRepository, statementPrinter);
  }

  @Test
  public void store_a_deposit_transaction() {
    account.deposit(100);
    verify(transactionRepository).addDeposit(100);
  }

  @Test
  public void store_a_withdrawal_transaction() {
    account.withdrawal(100);
    verify(transactionRepository).addDeposit(-100);
  }

  @Test
  public void print_transaction_statement() {
    List<Transaction> transactions = Collections.singletonList(new Transaction(TODAY, 100));
    given(transactionRepository.allStatements()).willReturn(transactions);

    account.printStatement();

    verify(statementPrinter).print(transactions);
  }

}