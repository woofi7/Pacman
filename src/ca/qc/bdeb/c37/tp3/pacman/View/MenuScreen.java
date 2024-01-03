package ca.qc.bdeb.c37.tp3.pacman.View;

import java.awt.*;
import java.awt.image.ImageObserver;

public class MenuScreen extends Screen{
    public MenuScreen(int largeurEcran, int hauteurEcran, ImageObserver imageObserver) {
        super(largeurEcran, hauteurEcran, imageObserver);
    }

    @Override
    public void updateScreen() {
        this.clearElements();
        this.addElement(new GuiTitle(this.largeurEcran / 2, this.hauteurEcran / 6,  "menu"));
        this.addElement(new GuiText(this.largeurEcran / 2, this.hauteurEcran / 2, "Appuyer sur 'D' pour démarrer"));
        GuiButton exitButton = new GuiButton(this::monCodePourQuiter);
    }
    void monCodePourQuiter() {

    }
}
