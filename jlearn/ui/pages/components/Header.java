package jlearn.ui.pages.components;

import java.util.List;
import jlearn.util.StringHelper;
import jlearn.ui.util.UiHelper;

public class Header extends Renderable {
    public String title;
    private List<String> lines;

    public Header(String title, int width, int height) {
        super(width, height);
        this.title = title;
        this.lines = StringHelper.wrapText(this.title, 4, this.width);
        this.height = this.height >= this.lines.size() ? this.height : this.lines.size();
    }

    public void render() {
        UiHelper.printLn(this.width);
        for (String line : lines)
            UiHelper.printLn(line, this.width);
        UiHelper.printLn(this.width);
    }
}