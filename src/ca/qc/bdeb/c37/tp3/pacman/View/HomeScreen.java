package ca.qc.bdeb.c37.tp3.pacman.View;

import java.awt.*;
import java.awt.image.ImageObserver;

public class HomeScreen extends Screen{
    private Image imageStart;
    public HomeScreen(int largeurEcran, int hauteurEcran, Image imageStart, ImageObserver imageObserver) {
        super(largeurEcran, hauteurEcran, imageObserver);
        this.imageStart = imageStart;
    }

    @Override
    public void updateScreen() {
        this.clearElements();
        this.addElement(new GuiTitle(this.largeurEcran / 2, this.hauteurEcran / 6,  "pacman"));
        this.addElement(new GuiText(this.largeurEcran / 2, this.hauteurEcran / 2, "Appuyer sur 'D' pour démarrer"));
        this.addElement(new GuiImage(this.largeurEcran / 2, 3 * this.hauteurEcran / 4, imageStart));
    }
}
