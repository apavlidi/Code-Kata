package org.apavlidi.twitter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TwitterRepositoryShould {


  private TwitterRepository twitterRepository;

  @Before
  public void initialise() {
    twitterRepository = new TwitterRepository();
  }

  @Test
  public void create_a_post_from_a_user() {
    twitterRepository.publish("Alice", "I love the weather today");

    assertThat(twitterRepository.timeline("Alice").size(), is(1));
    assertThat(twitterRepository.timeline("Alice").get(0), is("I love the weather today"));
  }

  @Test
  public void read_posts_from_another_user() {
    twitterRepository.publish("Alice", "I love the weather today");
    twitterRepository.read("Alice");

    assertThat(twitterRepository.read("Alice").size(), is(1));
    assertThat(twitterRepository.timeline("Alice").get(0), is("I love the weather today"));
  }

  @Test
  public void create_add_a_follow_to_a_user() {
    twitterRepository.follow("Charlie", "Alice");

    assertThat(twitterRepository.followers("Charlie").size(), is(1));
    assertThat(twitterRepository.followers("Charlie"), is(Collections.singletonList("Alice")));
  }

  @Test
  public void return_timelines_of_followed_users() {
    twitterRepository.publish("Alice", "I love the weather today");
    twitterRepository.publish("Charlie", "Hello there");
    twitterRepository.follow("Charlie", "Alice");

    List<Timeline> timelines = twitterRepository.wall("Charlie");

    assertThat(timelines.size(), is(2));
    assertThat(timelines.get(0), is(new Timeline("Alice",
        Collections.singletonList("I love the weather today"))));
    assertThat(timelines.get(1), is(new Timeline("Charlie",
        Collections.singletonList("Hello there"))));
  }


}