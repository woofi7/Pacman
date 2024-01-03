package ca.qc.bdeb.c37.tp3.pacman.View;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Screen {
    protected List<GuiElement> elements = new ArrayList<GuiElement>();
    protected Font pacmanFont = new Font("pacfont", Font.TRUETYPE_FONT, 45);
    protected Font menuFont = new Font("Arial", Font.BOLD, 15);
    protected int largeurEcran;
    protected int hauteurEcran;
    protected FontRenderContext fontRenderContext;
    protected Graphics2D g2d;
    protected boolean hasBaclground;
    public ImageObserver imageObserver;

    public Screen(int largeurEcran, int hauteurEcran, ImageObserver imageObserver) {
        this.imageObserver = imageObserver;
        this.hasBaclground = true;
        this.largeurEcran = largeurEcran;
        this.hauteurEcran = hauteurEcran;
    }

    public void init() {
        updateScreen();
    }

    private void drawDefaultBackground() {
        g2d.setColor(new Color(0, 32, 48, 230));
        g2d.fillRect(0, 0, largeurEcran, hauteurEcran);
    }

    public void draw(Graphics2D g2d) {
        this.g2d = g2d;
        this.fontRenderContext = g2d.getFontRenderContext();
        if (this.hasBaclground) {
            drawDefaultBackground();
        }
        for(GuiElement element: elements) {
            element.draw(this, g2d);
        }
    }

    public void addElement(GuiElement element) {
        this.elements.add(element);
    }

    public void clearElements() {
        this.elements.clear();
    }

    public void setScreenSize(int largeur, int hauteur) {
        this.largeurEcran = largeur;
        this.hauteurEcran = hauteur;
        updateScreen();
    }

    public abstract void updateScreen();
}
