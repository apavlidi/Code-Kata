package org.apavlidi.twitter;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceShould {

  @Mock
  private TwitterRepository twitterRepository;

  @Mock
  private StatementPrinter statementPrinter;

  private TwitterService twitterService;

  @Before
  public void initialise() {
    twitterService = new TwitterService(twitterRepository, statementPrinter);
  }

  @Test
  public void identify_a_publish_command() {
    twitterService.execute("Alice -> I love the weather today");

    verify(twitterRepository).publish("Alice", "I love the weather today");
  }

  @Test
  public void identify_a_read_command() {
    twitterService.execute("Alice");

    verify(twitterRepository).read("Alice");
  }

  @Test
  public void identify_a_wall_command() {
    twitterService.execute("Charlie wall");

    verify(twitterRepository).wall("Charlie");
  }

  @Test
  public void identify_a_follow_command() {
    twitterService.execute("Charlie follows Bob");

    verify(twitterRepository).follow("Charlie", "Bob");
  }

  @Test
  public void print_timeline_of_a_user() {
    twitterService.execute("Alice -> I love the weather today");
    twitterService.execute("Alice");

    verify(statementPrinter).printTimeline(new Timeline("Alice",
        twitterRepository.read("Alice")));
  }

  @Test
  public void print_a_wall_of_a_user() {
    twitterService.execute("Alice -> I love the weather today");
    twitterService.execute("Charlie -> I'm in New York today! Anyone wants to have a coffee?");
    twitterService.execute("Charlie follows Alice");
    twitterService.execute("Charlie wall");

    verify(statementPrinter).printWall(twitterRepository.wall("Charlie"));
  }

}