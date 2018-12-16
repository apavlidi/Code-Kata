package Diamond;

public class Diamond {

    private static final int CHAR_POSITION_A = 65;

    public String print(char character) {
        int charPosition = (int) character - 64;
        int currentCharacterPos = 0;
        int spacesInside = 1;
        String diamondString = "";

        for (int i = 0; i < charPosition; i++) {
            currentCharacterPos += 1;
            diamondString += retrieveSpaces(currentCharacterPos, charPosition);

            if (isNotFirstLetter(i)) {
                diamondString += getLine(spacesInside, i);
                spacesInside += 2;
            } else {
                diamondString += getCharacter(CHAR_POSITION_A + i);
                diamondString += "\n";
            }
        }

        currentCharacterPos = charPosition;
        spacesInside -= 4;
        for (int i = charPosition - 2; i > -1; i--) {
            currentCharacterPos--;
            diamondString += retrieveSpaces(currentCharacterPos, charPosition);

            if (isNotFirstLetter(i)) {
                diamondString += getLine(spacesInside, i);
                spacesInside -= 2;
            } else {
                diamondString += getCharacter(CHAR_POSITION_A + i);
            }
        }

        return diamondString;
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
        String spaces = "";
        for (int j = startPoint; j < length; j++) {
            spaces += " ";
        }
        return spaces;
    }

    private String getCharacter(int charPosition) {
        return String.valueOf((char) (charPosition));
    }


}
