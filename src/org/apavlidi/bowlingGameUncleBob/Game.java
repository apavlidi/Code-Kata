package org.apavlidi.bowlingGameUncleBob;

public class Game {

  public static final int MAX_FRAMES = 10;
  private int[] rolls = new int[21];
  private int currentRole;
  private int score;

  public void roll(int pins) {
    rolls[currentRole++] = pins;
  }

  public int score() {
    int currentRole = 0;

    for (int i = 0; i < MAX_FRAMES; i++) {
      if (isStrike(currentRole)) {
        currentRole = calculateStrike(currentRole);
      } else if (isSpare(currentRole)) {
        currentRole = calculateSpare(currentRole);
      } else {
        currentRole = calculateNormalRolls(currentRole);
      }
    }

    return score;
  }

  private int calculateNormalRolls(int currentRole) {
    score += rolls[currentRole] + rolls[currentRole + 1];
    return increaseRollsForFrame(currentRole);
  }

  private int calculateSpare(int currentRole) {
    score += 10 + nextRollForSpare(currentRole);
    return increaseRollsForFrame(currentRole);
  }

  private int calculateStrike(int currentRole) {
    score += 10 + nextTwoRollsForStrike(currentRole);
    return currentRole + 1;
  }

  private int increaseRollsForFrame(int currentRole) {
    return currentRole + 2;
  }

  private int nextTwoRollsForStrike(int currentRole) {
    return rolls[currentRole + 1] + rolls[currentRole + 2];
  }

  private int nextRollForSpare(int currentRole) {
    return rolls[currentRole + 2];
  }

  private boolean isSpare(int currentRole) {
    return rolls[currentRole] + rolls[currentRole + 1] == 10;
  }

  private boolean isStrike(int currentRole) {
    return rolls[currentRole] == 10;
  }
}
