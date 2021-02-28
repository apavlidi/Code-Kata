package org.apavlidi.tennis;

import java.util.Map;

public class TennisGame1 implements TennisGame {

  public static final String SEPERATOR = "-";
  private int player1Score = 0;
    private int player2Score = 0;
    private final Map<Integer, String> draw;
    private final Map<Integer, String> score;
    public static final String ADVANTAGE = "Advantage player";
    public static final String WIN = "Win for player";

    public TennisGame1() {
        draw = Map.of(
            0, "Love-All",
            1, "Fifteen-All",
            2, "Thirty-All",
            3, "Deuce",
            4, "Deuce"
        );
        score = Map.of(
            0, "Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty"
        );
    }


    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return draw();
        }

        if (player1Score >= 4 || player2Score >= 4) {
            return winOrWinning();
        }

        return totalScore();
    }

  private String totalScore() {
    return playerScore(player1Score) + SEPERATOR + playerScore(player2Score);
  }

  private String playerScore(int scoreNumber) {
        return score.get(scoreNumber);
    }

    private String winOrWinning() {
        int scoreDiff = player1Score - player2Score;
        if (scoreDiff == 1) {
            return ADVANTAGE + "1";
        } else if (scoreDiff == -1) {
            return ADVANTAGE + "2";
        } else if (scoreDiff >= 2) {
            return WIN + "1";
        }
        return WIN + "2";
    }

    private String draw() {
        return draw.get(player1Score);
    }
}
