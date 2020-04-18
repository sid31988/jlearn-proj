package jlearn.ui;

import jlearn.ui.page.HomePageBuilder;
import jlearn.ui.page.Page;
import jlearn.ui.page.components.ComponentBase;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UiController {
    private Page homePage;
    public int width;
    public int height;

    public UiController(int width, int height, String terminalName) throws IllegalArgumentException {
        this.width = width;
        this.height = height;
        this.homePage = HomePageBuilder.buildPage(width, height);
    }

    public void render() {
        this.calculateAbsoluteSize(this.homePage);
    }

    public List<ComponentBase> sortChildrenByRowSpan(ComponentBase component) {
        List<ComponentBase> children = new ArrayList<ComponentBase>(component.children.values());
        Collections.sort(children, new Comparator<ComponentBase>() {
            public int compare(ComponentBase left, ComponentBase right) {
                if (left.rowSpan > right.rowSpan)
                    return 1;
                else if (left.rowSpan == right.rowSpan)
                    return 0;
                else
                    return -1;
            }
        });
        return children;
    }

    public List<ComponentBase> sortChildrenByColSpan(ComponentBase component) {
        List<ComponentBase> children = new ArrayList<ComponentBase>(component.children.values());
        Collections.sort(children, new Comparator<ComponentBase>() {
            public int compare(ComponentBase left, ComponentBase right) {
                if (left.colSpan > right.colSpan)
                    return 1;
                else if (left.colSpan == right.colSpan)
                    return 0;
                else
                    return -1;
            }
        });
        return children;
    }

    public void calculateAbsoluteWidth(ComponentBase component) {
        List<ComponentBase> childrenByRowSpan = this.sortChildrenByRowSpan(component);
        int remainingAbsoluteWidth = component.absoluteWidth;
        int spanAbsoluteWidth = remainingAbsoluteWidth / component.totalRowSpan;
        int numberOfChildren = childrenByRowSpan.size();
        for (int i = 1; i <= numberOfChildren; i++) {
            ComponentBase childComponent = childrenByRowSpan.get(i - 1);
            if (childComponent.rowSpan != -1)
                childComponent.absoluteWidth = spanAbsoluteWidth * childComponent.rowSpan;
            else {
                if (numberOfChildren - i > 1) {
                    childComponent.absoluteWidth = remainingAbsoluteWidth / (numberOfChildren - i);
                }
            }
            remainingAbsoluteWidth -= childComponent.absoluteWidth;
        }
    }

    public void calculateAbsoluteHeight(ComponentBase component) {
        List<ComponentBase> childrenByRowSpan = this.sortChildrenByRowSpan(component);
        int remainingAbsoluteHeight = component.absoluteHeight;
        int spanAbsoluteHeight = remainingAbsoluteHeight / component.totalRowSpan;
        int numberOfChildren = childrenByRowSpan.size();
        for (int i = 1; i <= numberOfChildren; i++) {
            ComponentBase childComponent = childrenByRowSpan.get(i - 1);
            if (childComponent.rowSpan != -1)
                childComponent.absoluteHeight = spanAbsoluteHeight * childComponent.rowSpan;
            else {
                if (numberOfChildren - i > 1) {
                    childComponent.absoluteHeight = remainingAbsoluteHeight / (numberOfChildren - i);
                }
            }
            remainingAbsoluteHeight -= childComponent.absoluteHeight;
        }
    }

    public void calculateAbsoluteSize(ComponentBase component) {
        this.calculateAbsoluteWidth(component);
        this.calculateAbsoluteHeight(component);
        for (ComponentBase childComponent : component.children.values()) {
            this.calculateAbsoluteSize(childComponent);
        }
    }
}