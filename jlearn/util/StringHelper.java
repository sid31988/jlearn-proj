package jlearn.util;

import java.util.List;
import java.util.ArrayList;

public class StringHelper {
    public static final List<String> wrapText(String text, int margin, int wrapLength) {
        List<String> lines = new ArrayList<String>();
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String possibleLine = line.toString() + " " + words[i];
            if (possibleLine.length() + margin > wrapLength) {
                lines.add(line.toString());
                line = new StringBuilder();
            }
            line.append(" ");
            line.append(words[i]);
        }
        if (line.length() > 0)
            lines.add(line.toString());
        return lines;
    }

    public static final String rightPad(String text, int padLength, char padChar) {
        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = 0; i < padLength; i++)
            stringBuilder.append(padChar);
        return stringBuilder.toString();
    }
}