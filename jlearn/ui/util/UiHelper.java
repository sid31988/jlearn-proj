package jlearn.ui.util;

import jlearn.util.StringHelper;;

public class UiHelper {
    public static final char BORDER_CHAR = '#';

    public static final void printLn(int width) {
        for (int i = 0; i < width; i++)
            System.out.print(UiHelper.BORDER_CHAR);
        System.out.println("");
    }

    public static final void printLn(String text, int width) {
        int rightPadLength = width - text.length() - 4;
        System.out.println(String.format("%c %s %c", UiHelper.BORDER_CHAR,
                StringHelper.rightPad(text, rightPadLength, ' '), UiHelper.BORDER_CHAR));
    }
}