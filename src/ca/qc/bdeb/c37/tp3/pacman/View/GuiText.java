package ca.qc.bdeb.c37.tp3.pacman.View;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Nicolas on 03/12/2016.
 */
public class GuiText extends GuiElement {
    private String text;

    public GuiText(int x, int y, String text) {
        super(x, y);
        this.text = text;
    }

    @Override
    public void draw(Screen screen, Graphics2D g2d) {
        Rectangle2D stringBounds = screen.menuFont.getStringBounds(text, screen.fontRenderContext);
        int posX = this.x - (int) stringBounds.getWidth() / 2;
        int posY = this.y - (int) stringBounds.getHeight() / 2;

        g2d.setFont(screen.menuFont);
        g2d.setColor(Color.white);
        g2d.drawString(text, posX, posY);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
