package org.apavlidi.bank.src.main.java;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {


  private List<Transaction> transactions = new ArrayList<>();
  private Clock clock;

  public TransactionRepository(Clock clock) {
    this.clock = clock;
  }

  public void addDeposit(int amount) {
    transactions.add(new Transaction(clock.getCurrentDate(), amount));
  }

  public void addWithdrawal(int amount) {
    transactions.add(new Transaction(clock.getCurrentDate(), -amount));
  }

  public List<Transaction> allStatements() {
    return transactions;
  }
}
