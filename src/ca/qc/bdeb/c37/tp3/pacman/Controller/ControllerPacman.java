package ca.qc.bdeb.c37.tp3.pacman.Controller;

import ca.qc.bdeb.c37.tp3.pacman.Model.NiveauModel;
import ca.qc.bdeb.c37.tp3.pacman.Model.PacmanModel;

import javax.swing.*;

/**
 *
 * @author 1535216
 */
public class ControllerPacman {
    private final Controller controller;
    private PacmanModel model;

    ControllerPacman(Controller controller) {
        this.controller = controller;
    }

    void initStart(PacmanModel model) {
        this.model = model;

        model.setPowerUp(new Timer(3500, controller.getNiveauView()));
        model.getPowerUp().setRepeats(false);
        model.setVitesse(4);
    }

    void initPartie() {
        model.setVies(3);

        setPacmanDirection(0, 0);
        setPacmanVue(-1, 0);
        setPacmanDeplacement(0, 0);
    }

    private void demarrerPowerUp() {
        if (!model.getPowerUp().isRunning()) {
            model.getPowerUp().start();
        }
        else {
            model.getPowerUp().restart();
        }
    }

    public void deplacerHaut() {
        if (controller.getNiveauModel().getTimer().isRunning()) {
            model.setDeplacementX(0);
            model.setDeplacementY(-1);
        } else {
            controller.monterMenu();
        }
    }

    public void deplacerBas() {
        if (controller.getNiveauModel().getTimer().isRunning()) {
            model.setDeplacementX(0);
            model.setDeplacementY(1);
        } else {
            controller.descendreMenu();
        }
    }

    public void deplacerDroite() {
        if (controller.getNiveauModel().getTimer().isRunning()) {
            model.setDeplacementX(1);
            model.setDeplacementY(0);
        }
    }

    public void deplacerGauche() {
        if (controller.getNiveauModel().getTimer().isRunning()) {
            model.setDeplacementX(-1);
            model.setDeplacementY(0);
        }
    }
    public void gestionPoints(int position) {
        NiveauModel niveauModel = controller.getNiveauModel();
        if (niveauModel.getDonneesFenetre()[position] == 1) {
            controller.setScore(controller.getScore() + controller.getScoreMultiplier());
        niveauModel.setDonneesFenetre(position);
        }
        if (niveauModel.getDonneesFenetre()[position] == 2) {
            controller.setScoreMultiplier(2);
            model.setVitesse(8);
            niveauModel.setDonneesFenetre(position);
            demarrerPowerUp();
        }
    }

    public boolean pacmanSurCase() {
        int taille = controller.getNiveauModel().getTailleCase();
        return model.getPacmanX() % taille == 0 && model.getPacmanY() % taille == 0;
    }


    public void vitessePowerUp() {
        if (!model.getPowerUp().isRunning() && model.getVitesse() == 8) {
            model.setVitesse(4);
            controller.setScoreMultiplier(1);
        }
    }

    void mort(int ghost) {
        if (model.getPowerUp().isRunning()) {
            controller.getGhost().mort(ghost);

        }
        else {
            model.setVies(model.getVies() - 1);

            if (model.getVies() == 0) {
                controller.getNiveauModel().setEnJeu(false);
            }

            controller.getPacman().setPacmanPos(controller.getPacmanStartX() * controller.getNiveauModel().getTailleCase(), controller.getPacmanStartY() * controller.getNiveauModel().getTailleCase());
        }
    }

    public void setPacmanDirection(int x, int y) {
        model.setPacmanDirectionX(x);
        model.setPacmanDirectionY(y);
    }

    public void setPacmanVue(int x, int y) {
        model.setPacmanVueX(x);
        model.setPacmanVueY(y);
    }

    public void setPacmanPos(int x, int y) {
        model.setPacmanX(x);
        model.setPacmanY(y);
    }

    private void setPacmanDeplacement(int x, int y) {
        model.setDeplacementX(x);
        model.setDeplacementY(y);
    }

    public int getNbVies() {
        return model.getVies();
    }

    public int getVitesse() {
        return model.getVitesse();
    }

    public int getDeplacementY() {
        return model.getDeplacementY();
    }

    public int getDeplacementX() {
        return model.getDeplacementX();
    }

    public int getPacmanX() {
        return model.getPacmanX();
    }

    public int getPacmanY() {
        return model.getPacmanY();
    }

    public int getDirectionX() {
        return model.getPacmanDirectionX();
    }

    public int getDirectionY() {
        return model.getPacmanDirectionY();
    }

    public int getPacmanVueX() {
        return model.getPacmanVueX();
    }

    public int getPacmanVueY() {
        return model.getPacmanVueY();
    }
}
