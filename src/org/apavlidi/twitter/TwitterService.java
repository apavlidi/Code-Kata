package org.apavlidi.twitter;

import java.util.Arrays;
import java.util.List;

public class TwitterService {

  public static final String PUBLISH_CHAR = "->";
  public static final String FOLLOWS_CHAR = "follows";
  private TwitterRepository twitterRepository;
  private StatementPrinter statementPrinter;

  public TwitterService(TwitterRepository twitterRepository,
      StatementPrinter statementPrinter) {
    this.twitterRepository = twitterRepository;
    this.statementPrinter = statementPrinter;
  }

  public void execute(String command) {
    List<String> commandParts = Arrays.asList(command.split(" "));
    String username = commandParts.get(0);

    if (commandParts.contains(PUBLISH_CHAR)) {
      String message = getMessageFromPublishCommand(commandParts);
      twitterRepository.publish(username, message);
    } else if (commandParts.size() == 2) {
      statementPrinter.printWall(twitterRepository.wall(username));
    } else if (commandParts.contains(FOLLOWS_CHAR)) {
      String usernameToBeFollowed = commandParts.get(2);
      twitterRepository.follow(username, usernameToBeFollowed);
    } else {
      statementPrinter.printTimeline(new Timeline(username, twitterRepository.read(command)));
    }
  }

  private String getMessageFromPublishCommand(List<String> commandParts) {
    String command = String.join(" ", commandParts);
    int publishCharPosition = command.indexOf(PUBLISH_CHAR);
    return command.substring(publishCharPosition + 3);
  }
}
