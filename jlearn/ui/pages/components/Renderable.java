package jlearn.ui.pages.components;

public abstract class Renderable {
    protected int width;
    protected int height;

    public Renderable(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void render();
}