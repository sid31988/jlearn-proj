package jlearn;

import jlearn.ui.*;

public class Main {
    private static void validateArgs(String[] args) throws IllegalArgumentException {
        switch (args.length) {
            case 0:
                throw new IllegalArgumentException("Missing terminal width");
            case 1:
                throw new IllegalArgumentException("Missing terminal height");
            case 2:
                throw new IllegalArgumentException("Missing terminal name");
            default:
                break;
        }
    }

    public static void main(String[] args) {
        try {
            validateArgs(args);
            UiController uiController = new UiController(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
            uiController.render();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}