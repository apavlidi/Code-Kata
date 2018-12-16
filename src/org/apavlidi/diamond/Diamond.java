package org.apavlidi.diamond;

public class Diamond {

    private static final int CHAR_POSITION_A = 65;

    public String print(char character) {
        int charPosition = (int) character - 64;
        int currentCharacterPos = 0;
        int spacesInside = 1;
        StringBuilder diamondString = new StringBuilder();

        for (int i = 0; i < charPosition; i++) {
            currentCharacterPos += 1;
            diamondString.append(retrieveSpaces(currentCharacterPos, charPosition));

            if (isNotFirstLetter(i)) {
                diamondString.append(getLine(spacesInside, i));
                spacesInside += 2;
            } else {
                diamondString.append(getCharacter(CHAR_POSITION_A + i));
                diamondString.append("\n");
            }
        }

        currentCharacterPos = charPosition;
        spacesInside -= 4;
        for (int i = charPosition - 2; i > -1; i--) {
            currentCharacterPos--;
            diamondString.append(retrieveSpaces(currentCharacterPos, charPosition));

            if (isNotFirstLetter(i)) {
                diamondString.append(getLine(spacesInside, i));
                spacesInside -= 2;
            } else {
                diamondString.append(getCharacter(CHAR_POSITION_A + i));
            }
        }

        return diamondString.toString();
    }

    private String getLine(int spacesInside, int index) {
        String rowString = "";
        rowString += getCharacter(CHAR_POSITION_A + index);

        rowString += retrieveSpaces(0, spacesInside);

        rowString += getCharacter(CHAR_POSITION_A + index);
        rowString += "\n";
        return rowString;
    }

    private boolean isNotFirstLetter(int i) {
        return i != 0;
    }

    private String retrieveSpaces(int startPoint, int length) {
        StringBuilder spaces = new StringBuilder();

        for (int j = startPoint; j < length; j++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    private String getCharacter(int charPosition) {
        return String.valueOf((char) (charPosition));
    }


}
