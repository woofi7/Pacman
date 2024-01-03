package ca.qc.bdeb.c37.tp3.pacman.View;

import java.awt.*;

/**
 * Created by Nicolas on 03/12/2016.
 */
public abstract class GuiElement {
    protected int x;
    protected int y;

    GuiElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Screen screen, Graphics2D g2d);
}
