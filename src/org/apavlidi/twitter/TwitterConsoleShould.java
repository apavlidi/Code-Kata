package org.apavlidi.twitter;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterConsoleShould {

  private TwitterConsole twitterConsole;

  @Mock
  private TwitterService twitterService;

  @Before
  public void initialise() {
    twitterConsole = new TwitterConsole(twitterService);
  }

  @Test
  public void publish_post_to_personal_timeline() {
    twitterConsole.command("Alice -> I love the weather today");

    verify(twitterService).execute("Alice -> I love the weather today");
  }

}