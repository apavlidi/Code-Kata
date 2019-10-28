package org.apavlidi.twitter;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SocialNetworkShould {

  @Mock
  private Console console;

  private TwitterConsole twitterConsole;
  private TwitterService twitterService;
  private TwitterRepository twitterRepository;
  private StatementPrinter statmentPrinter;

  @Before
  public void initialise() {
    statmentPrinter = new StatementPrinter(console);
    twitterRepository = new TwitterRepository();
    twitterService = new TwitterService(twitterRepository, statmentPrinter);
    twitterConsole = new TwitterConsole(twitterService);
  }

  @Test
  public void publish_on_personal_timeline() {
    twitterConsole.command("Alice -> I love the weather today");
    twitterConsole.command("Alice");

    verify(console).print("I love the weather today");
  }

  @Test
  public void read_on_other_user_timeline() {
    twitterConsole.command("Alice -> I love the weather today");
    twitterConsole.command("Bob -> Damn! We lost!");
    twitterConsole.command("Bob -> Good game though.");
    twitterConsole.command("Alice");
    twitterConsole.command("Bob");

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).print("I love the weather today");
    inOrder.verify(console).print("Damn! We lost!");
    inOrder.verify(console).print("Good game though.");
  }


  @Test
  public void read_all_followers_timelines() {
    twitterConsole.command("Alice -> I love the weather today");
    twitterConsole.command("Bob -> Damn! We lost!");
    twitterConsole.command("Bob -> Good game though.");
    twitterConsole.command("Charlie -> I'm in New York today! Anyone wants to have a coffee?");
    twitterConsole.command("Charlie follows Alice");
    twitterConsole.command("Charlie wall");
    twitterConsole.command("Charlie follows Bob");
    twitterConsole.command("Charlie wall");


    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).print("I love the weather today");
    inOrder.verify(console).print("I'm in New York today! Anyone wants to have a coffee?");
    inOrder.verify(console).print("I love the weather today");
    inOrder.verify(console).print("I'm in New York today! Anyone wants to have a coffee?");
    inOrder.verify(console).print("Damn! We lost!");
    inOrder.verify(console).print("Good game though.");
  }
}
