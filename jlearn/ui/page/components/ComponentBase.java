package jlearn.ui.page.components;

import java.util.HashMap;

public class ComponentBase {
    public String content;
    public int rowSpan;
    public int colSpan;
    public int absoluteWidth;
    public int absoluteHeight;
    public ComponentBase parent;
    public HashMap<String, ComponentBase> children;
    public int totalRowSpan;
    public int totalColSpan;

    public ComponentBase(String content, int rowSpan, int colSpan) {
        this.content = content;
        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
        this.children = new HashMap<String, ComponentBase>();
    }

    public ComponentBase(int rowSpan, int colSpan) {
        this.content = null;
        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
    }

    public void setParent(ComponentBase parent) {
        this.parent = parent;
    }

    public void appendChild(String name, ComponentBase child) {
        this.children.put(name, child);
        if (child.rowSpan != -1)
            this.totalRowSpan += child.rowSpan;
        if (child.colSpan != -1)
            this.totalColSpan += child.colSpan;
        child.setParent(this);
    }

    // public void render() {
    // this.lines = StringHelper.wrapText(this.content, 4, this.parent.width);
    // this.absoluteHeight = this.absoluteHeight >= this.lines.size() ?
    // this.absoluteHeight : this.lines.size();
    // UiHelper.printLn(this.parent.width);
    // for (String line : lines)
    // UiHelper.printLn(line, this.parent.width);
    // UiHelper.printLn(this.parent.width);
    // }
}