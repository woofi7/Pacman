package ca.qc.bdeb.c37.tp3.pacman.View;

import java.awt.*;

/**
 * Created by Nicolas on 03/12/2016.
 */
public class GuiImage extends GuiElement {
    private final Image image;

    GuiImage(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Screen screen, Graphics2D g2d) {
        int posX = this.x - image.getWidth(screen.imageObserver) / 2;
        int posY = this.y - image.getHeight(screen.imageObserver) / 2;
        g2d.drawImage(image, posX, posY, screen.imageObserver);
    }
}
