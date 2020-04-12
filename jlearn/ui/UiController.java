package jlearn.ui;

import jlearn.ui.util.*;
import jlearn.ui.pages.*;

public class UiController {
    private Page homePage;

    public UiController() {
        this.homePage = new Page("Welcome to JLearn!!!", 100, 1);
    }
    
    public void render() {
        UiHelper.clearScreen();
        this.homePage.render();
    }
}