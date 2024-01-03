package ca.qc.bdeb.c37.tp3.pacman.Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Nicolas
 */
public class Images {

    private final Image ghost1;
    private final Image ghost2;
    private final Image ghost3;
    private final Image ghost4;
    private final Image ghost5;
    private final Image pacman1;
    private final Image image_menu;

    private final Image pacman2haut;
    private final Image pacman2bas;
    private final Image pacman2gauche;
    private final Image pacman2droite;

    private final Image pacman3haut;
    private final Image pacman3bas;
    private final Image pacman3gauche;
    private final Image pacman3droite;

    private final Image pacman4haut;
    private final Image pacman4bas;
    private final Image pacman4gauche;
    private final Image pacman4droite;

    public Images() {
        ghost1 = new ImageIcon("images/ghost1.png").getImage();
        ghost2 = new ImageIcon("images/ghost2.png").getImage();
        ghost3 = new ImageIcon("images/ghost3.png").getImage();
        ghost4 = new ImageIcon("images/ghost4.png").getImage();
        ghost5 = new ImageIcon("images/ghost5.png").getImage();
        pacman1 = new ImageIcon("images/pacman.png").getImage();
        pacman2haut = new ImageIcon("images/up1.png").getImage();
        pacman3haut = new ImageIcon("images/up2.png").getImage();
        pacman4haut = new ImageIcon("images/up3.png").getImage();
        pacman2bas = new ImageIcon("images/down1.png").getImage();
        pacman3bas = new ImageIcon("images/down2.png").getImage();
        pacman4bas = new ImageIcon("images/down3.png").getImage();
        pacman2gauche = new ImageIcon("images/left1.png").getImage();
        pacman3gauche = new ImageIcon("images/left2.png").getImage();
        pacman4gauche = new ImageIcon("images/left3.png").getImage();
        pacman2droite = new ImageIcon("images/right1.png").getImage();
        pacman3droite = new ImageIcon("images/right2.png").getImage();
        pacman4droite = new ImageIcon("images/right3.png").getImage();
        image_menu = new ImageIcon("images/image_menu.png").getImage();
    }

    public Image getGhost1() {
        return ghost1;
    }

    public Image getGhost2() {
        return ghost2;
    }

    public Image getGhost3() {
        return ghost3;
    }

    public Image getGhost4() {
        return ghost4;
    }

    public Image getGhost5() {
        return ghost5;
    }

    public Image getPacman1() {
        return pacman1;
    }

    public Image getPacman2haut() {
        return pacman2haut;
    }

    public Image getPacman2bas() {
        return pacman2bas;
    }

    public Image getPacman2gauche() {
        return pacman2gauche;
    }

    public Image getPacman2droite() {
        return pacman2droite;
    }

    public Image getPacman3haut() {
        return pacman3haut;
    }

    public Image getPacman3bas() {
        return pacman3bas;
    }

    public Image getPacman3gauche() {
        return pacman3gauche;
    }

    public Image getPacman3droite() {
        return pacman3droite;
    }

    public Image getPacman4haut() {
        return pacman4haut;
    }

    public Image getPacman4bas() {
        return pacman4bas;
    }

    public Image getPacman4gauche() {
        return pacman4gauche;
    }

    public Image getPacman4droite() {
        return pacman4droite;
    }

    public Image getImage_menu() {
        return image_menu;
    }
}
