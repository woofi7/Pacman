package ca.qc.bdeb.c37.tp3.pacman.Model;

import javax.swing.Timer;

/**
 *
 * @author Nicolas
 */
public class PacmanModel {
    private int deplacementX;
    private int deplacementY;

    private int pacmanDirectionX;
    private int pacmanDirectionY;

    private int pacmanVueX;
    private int pacmanVueY;

    private int pacmanX;
    private int pacmanY;

    private int vies;
    private int vitesse;

    private Timer powerUp;

    public PacmanModel() {
    }

    public int getDeplacementX() {
        return deplacementX;
    }

    public void setDeplacementX(int deplacementX) {
        this.deplacementX = deplacementX;
    }

    public int getDeplacementY() {
        return deplacementY;
    }

    public void setDeplacementY(int deplacementY) {
        this.deplacementY = deplacementY;
    }

    public int getPacmanDirectionX() {
        return pacmanDirectionX;
    }

    public void setPacmanDirectionX(int pacmanDirectionX) {
        this.pacmanDirectionX = pacmanDirectionX;
    }

    public int getPacmanDirectionY() {
        return pacmanDirectionY;
    }

    public void setPacmanDirectionY(int pacmanDirectionY) {
        this.pacmanDirectionY = pacmanDirectionY;
    }

    public int getPacmanVueX() {
        return pacmanVueX;
    }

    public void setPacmanVueX(int pacmanVueX) {
        this.pacmanVueX = pacmanVueX;
    }

    public int getPacmanVueY() {
        return pacmanVueY;
    }

    public void setPacmanVueY(int pacmanVueY) {
        this.pacmanVueY = pacmanVueY;
    }

    public int getPacmanX() {
        return pacmanX;
    }

    public void setPacmanX(int pacmanX) {
        this.pacmanX = pacmanX;
    }

    public int getPacmanY() {
        return pacmanY;
    }

    public void setPacmanY(int pacmanY) {
        this.pacmanY = pacmanY;
    }

    public int getVies() {
        return vies;
    }

    public void setVies(int vies) {
        this.vies = vies;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public Timer getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(Timer powerUp) {
        this.powerUp = powerUp;
    }
}
