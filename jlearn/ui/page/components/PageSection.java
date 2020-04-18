package jlearn.ui.page.components;

import java.util.List;
import java.util.ArrayList;
import jlearn.util.StringHelper;;

public class PageSection extends ComponentBase {
    public List<String> lines;

    public PageSection(String content, int rowSpan, int colSpan) {
        super(content, rowSpan, colSpan);
        this.lines = new ArrayList<String>();
        this.addLine(content);
    }

    public PageSection(int rowSpan, int colSpan) {
        super(null, rowSpan, colSpan);
        this.lines = new ArrayList<String>();
    }

    public PageSection addLine(String line) {
        List<String> lines = StringHelper.wrapText(this.content, 4, this.parent.absoluteWidth);
        for (String adjustedLine : lines)
            this.lines.add(adjustedLine);
        return this;
    }
}