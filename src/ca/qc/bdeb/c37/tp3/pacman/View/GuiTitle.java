package ca.qc.bdeb.c37.tp3.pacman.View;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Nicolas on 03/12/2016.
 */
public class GuiTitle extends GuiElement{
    private String title;

    public GuiTitle(int x, int y, String title) {
        super(x, y);
        this.title = title;
    }

    @Override
    public void draw(Screen screen, Graphics2D g2d) {
        Rectangle2D stringBounds = screen.pacmanFont.getStringBounds(title, screen.fontRenderContext);
        int posX = this.x - (int) stringBounds.getWidth() / 2;
        int posY = this.y - (int) stringBounds.getHeight() / 2;

        g2d.setFont(screen.pacmanFont);
        g2d.setColor(Color.black);
        g2d.drawString(title.toLowerCase(), posX, posY);
        g2d.setColor(Color.white);
        g2d.drawString(title.toUpperCase(), posX, posY);
    }
}
