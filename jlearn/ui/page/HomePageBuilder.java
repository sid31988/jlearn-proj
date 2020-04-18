package jlearn.ui.page;

import jlearn.ui.page.components.PageSection;

public class HomePageBuilder {
    public static Page buildPage(int width, int height) {
        Page.Builder homePageBuilder = Page.Builder.newInstance();
        homePageBuilder.withDimensions(width, height).withGridSize(2, 1);
        homePageBuilder.withSection("Header", "Welcome to JLearn!!!", 2, 1);
        homePageBuilder.withSection("Body", 2, -1);
        homePageBuilder.withSection("Footer", 2, 1);
        homePageBuilder.withSection("UserInput", 2, 1);

        Page homePage = homePageBuilder.build();
        
        PageSection body = homePage.getPageSection("Body");
        body.addLine("This is learning portal made for Java learners");
        body.addLine("Kindly select from the options below: ");
        body.addLine("1. About Java");
        body.addLine("2. Identifiers");

        PageSection footer = homePage.getPageSection("Footer");
        footer.addLine("Rendering page 1 of 1");
        footer.addLine("Rendering page 1 of 1");

        PageSection userInput = homePage.getPageSection("UserInput");
        userInput.addLine("Please mention your input here... ");

        return homePage;
    }
}