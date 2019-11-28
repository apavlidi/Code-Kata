package org.apavlidi.bowlingGameUncleBob;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameShould {

  private Game game;

  @Before
  public void initialise() {
    game = new Game();
  }

  @Test
  public void calculate_score_for_a_single_roll() {
    game.roll(0);

    assertThat(game.score(), is(0));
  }

  @Test
  public void calculate_score_for_whole_game() {
    getRolls(20, 1);

    assertThat(game.score(), is(20));
  }

  @Test
  public void calculate_score_for_gutter_game() {
    getRolls(20, 0);

    assertThat(game.score(), is(0));
  }

  @Test
  public void calculate_score_with_one_spare() {
    game.roll(5);
    game.roll(5);
    game.roll(3);
    getRolls(17, 0);

    assertThat(game.score(), is(16));
  }

  @Test
  public void calculate_score_with_one_strike() {
    game.roll(10);
    game.roll(2);
    game.roll(2);
    getRolls(16, 0);

    assertThat(game.score(), is(18));
  }

  @Test
  public void calculate_score_for_perfect_game() {
    getRolls(12, 10);

    assertThat(game.score(), is(300));
  }

  private void getRolls(int rolls, int pins) {
    for (int i = 0; i < rolls; i++) {
      game.roll(pins);
    }
  }

}
