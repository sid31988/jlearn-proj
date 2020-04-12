package jlearn.ui.util;

import java.io.IOException;
import jlearn.util.StringHelper;;

public class UiHelper {
    public static final char BORDER_CHAR = '#';

    public static final void printLn(int width) {
        for(int i = 0; i < width; i++)
            System.out.print(UiHelper.BORDER_CHAR);
        System.out.println("");
    }

    public static final void printLn(String text, int width) {
        int rightPadLength = width - text.length() - 4;
        System.out.println(String.format("%c %s %c", UiHelper.BORDER_CHAR, StringHelper.rightPad(text, rightPadLength, ' '), UiHelper.BORDER_CHAR)); 
    }

    public static final void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }
}