package org.apavlidi.twitter;

public class Client {

  public static void main(String[] args) {
    TwitterRepository twitterRepository = new TwitterRepository();
    Console console = new Console();
    StatementPrinter statementPrinter = new StatementPrinter(console);
    TwitterService twitterService = new TwitterService(twitterRepository,statementPrinter);
    TwitterConsole twitterConsole = new TwitterConsole(twitterService);
    twitterConsole.command("Alice -> I love the weather today");
    twitterConsole.command("Bob -> Damn! We lost!");
    twitterConsole.command("Bob -> Good game though.");
    twitterConsole.command("Charlie -> I'm in New York today! Anyone wants to have a coffee");
    twitterConsole.command("Charlie follows Alice");
    twitterConsole.command("Charlie wall");
    twitterConsole.command("Charlie follows Bob");
    twitterConsole.command("Charlie wall");
  }
}
