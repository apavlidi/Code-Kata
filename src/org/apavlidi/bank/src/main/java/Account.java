package org.apavlidi.bank.src.main.java;

public class Account {

  private TransactionRepository transactionRepository;
  private StatementPrinter statementPrinter;

  public Account(TransactionRepository transactionRepository,
      StatementPrinter statementPrinter) {
    this.transactionRepository = transactionRepository;
    this.statementPrinter = statementPrinter;
  }

  public void deposit(int amount) {
    transactionRepository.addDeposit(amount);
  }

  public void withdrawal(int amount) {
    transactionRepository.addWithdrawal(amount);
  }

  public void printStatement() {
    statementPrinter.print(transactionRepository.allStatements());
  }

}
