package org.apavlidi.wordWrap;

public class Wrapper {

    public static String wrap(String s, int col) {
        return new Wrapper(col).wrap(s);
    }

    private int column;

    Wrapper(int column) {
        this.column = column;
    }

    public String wrap(String text) {
        if (text.length() <= column)
            return text;
        int space = text.substring(0, column).lastIndexOf(" ");
        if (space != -1)
            return breakLine(text, space, 1);
        else if (text.indexOf(" ") == column)
            return breakLine(text, column, 1);
        else
            return breakLine(text, column, 0);
    }

    private String breakLine(String text, int pos, int gap) {
        return text.substring(0, pos) + "\n" + wrap(text.substring(pos + gap), column);
    }

}