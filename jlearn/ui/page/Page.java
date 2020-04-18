package jlearn.ui.page;

import jlearn.ui.page.components.*;
import java.util.HashMap;

public class Page extends ComponentBase {
    public GridSize gridSize;

    private Page(Builder builder) {
        super(null, builder.width, builder.height);
        this.gridSize = builder.gridSize;
        this.children = builder.children;
        for (ComponentBase componentBase : this.children.values())
            componentBase.setParent(this);
    }

    public PageSection getPageSection(String name) {
        return (PageSection) this.children.get(name);
    }

    public static class GridSize {
        int rows;
        int cols;

        private GridSize(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
        }
    }

    public static class Builder {
        public int width;
        public int height;
        public HashMap<String, ComponentBase> children;
        public GridSize gridSize;

        private Builder() {
            this.children = new HashMap<String, ComponentBase>();
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder withDimensions(int width, int height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public Builder withGridSize(int rows, int cols) {
            this.gridSize = new GridSize(rows, cols);
            return this;
        }

        public Builder withSection(String name, int rowSpan, int colSpan) {
            PageSection pageSection = new PageSection(rowSpan, colSpan);
            this.children.put(name, pageSection);
            return this;
        }

        public Builder withSection(String name, String content, int rowSpan, int colSpan) {
            PageSection pageSection = new PageSection(content, rowSpan, colSpan);
            this.children.put(name, pageSection);
            return this;
        }

        public Page build() {
            return new Page(this);
        }
    }
}