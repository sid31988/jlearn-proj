package jlearn.ui.pages;

import jlearn.ui.pages.components.*;

public class Page extends Renderable {
    public Header header;

    public Page(String title, int width, int height) {
        super(width, height);
        this.header = new Header(title, width, height);
    }

    public void render() {
        this.header.render();
    }
}