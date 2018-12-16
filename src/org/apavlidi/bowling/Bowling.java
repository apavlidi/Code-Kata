package org.apavlidi.bowling;

public class Bowling {

    private static final int NORMAL_FRAMES = 18;
    private static final String SPARE_SYMBOL = "/";
    private static final String STRIKE_SYMBOL = "X";
    private static final String MISS_SYMBOL = "-";

    public int score(String allRoles) {
        int score = 0;
        for (int i = 0; i < allRoles.length(); i++) {
            String currentRole = allRoles.substring(i, i + 1);
            score += scoreForRoll(allRoles.substring(i, i + 1)) - spareDiff(allRoles, currentRole, i) + bonus(allRoles, currentRole, i);
        }
        return score;
    }

    private int bonus(String allRoles, String currentRole, int index) {
        int nextRollScore = scoreForRoll(getNextRoll(allRoles, index));
        if (isLastFrame(allRoles, index))
            return 0;
        if (currentRole.equals(SPARE_SYMBOL))
            return nextRollScore;
        if (currentRole.equals(STRIKE_SYMBOL)) {
            String nextRoleString = getNextRoll(allRoles, index + 1);
            return nextRollScore + scoreForRoll(nextRoleString) - spareDiff(allRoles, nextRoleString, index + 2);
        }
        return 0;
    }

    private boolean isLastFrame(String allRoles, int index) {
        int frames = 0;
        for (int i = 0; i < index; i++) {
            if (allRoles.substring(i, i + 1).equals(STRIKE_SYMBOL))
                frames += 2;
            else
                frames += 1;
        }
        return (NORMAL_FRAMES <= frames);
    }

    private String getNextRoll(String allRoles, int index) {
        if (index < allRoles.length() - 1)
            return allRoles.substring(index + 1, index + 2);
        return MISS_SYMBOL;
    }

    private int spareDiff(String allRoles, String roll, int index) {
        if (roll.equals(SPARE_SYMBOL))
            return scoreForRoll(getPreviousRoll(allRoles, index));
        return 0;
    }

    private String getPreviousRoll(String allRoles, int index) {
        if (index > 0)
            return allRoles.substring(index - 1, index);
        return MISS_SYMBOL;
    }

    private int scoreForRoll(String roll) {
        if (roll.equals(MISS_SYMBOL)) return 0;
        if (roll.equals(SPARE_SYMBOL)) return 10;
        if (roll.equals(STRIKE_SYMBOL)) return 10;
        return Integer.parseInt(roll);
    }
}
