package org.apavlidi.twitter;

public class TwitterConsole {

  private TwitterService twitterService;

  public TwitterConsole(TwitterService twitterService) {
    this.twitterService = twitterService;
  }

  public void command(String command) {
    twitterService.execute(command);
  }
}
