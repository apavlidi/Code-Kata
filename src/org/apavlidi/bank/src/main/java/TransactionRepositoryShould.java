package org.apavlidi.bank.src.main.java;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

  public static final String TODAY = "01/04/2014";

  @Mock
  private Clock clock;

  private TransactionRepository transactionRepository;

  @Before
  public void initialise() {
    transactionRepository = new TransactionRepository(clock);
    given(clock.getCurrentDate()).willReturn(TODAY);
  }

  @Test
  public void create_and_store_a_deposit_transaction() {
    transactionRepository.addDeposit(100);

    List<Transaction> transactions = transactionRepository.allStatements();

    assertThat(transactions.size(), is(1));
    assertThat(transactions.get(0), is(transaction(TODAY, 100)));

  }

  @Test
  public void create_and_store_a_withdrawal_transaction() {
    transactionRepository.addWithdrawal(100);

    List<Transaction> transactions = transactionRepository.allStatements();

    assertThat(transactions.size(), is(1));
    assertThat(transactions.get(0), is(transaction(TODAY, -100)));

  }

  private Transaction transaction(String date, int amount) {
    return new Transaction(date, amount);
  }

}