package ca.qc.bdeb.c37.tp3.pacman.Controller;

import ca.qc.bdeb.c37.tp3.pacman.Model.GhostModel;

public class ControllerGhost {
    private final Controller controller;
    private GhostModel model;

    ControllerGhost(Controller controller) {
        this.controller = controller;
    }

    void initStart(GhostModel model) {
        this.model = model;
    }

    void initPartie() {
        model.setNbGhosts(4);

        model.initVariables();
    }

    public void resetGhost(){
        for (int i = 0; i < model.getNbGhosts(); i++) {
            setGhostPos(i, controller.getGhostStartX() * 24, controller.getGhostStartY() * 24);
        }
    }

    public void setGhostDirection(int indice, int x, int y) {
        model.getGhostDirectionX()[indice] = x;
        model.getGhostDirectionY()[indice] = y;
    }

    public void setDirection(int indice, int x, int y) {
        model.getDirectionX()[indice] = x;
        model.getDirectionY()[indice] = y;
    }

    public void setGhostPos(int indice, int x, int y) {
        model.getGhostX()[indice] = x;
        model.getGhostY()[indice] = y;
    }

    public void checkPacman(int ghost, int x, int y) {
        int pacmanX = controller.getPacmanModel().getPacmanX();
        int pacmanY = controller.getPacmanModel().getPacmanY();

        if (pacmanX > x - 12 && pacmanX < x + 12 && pacmanY > y - 12 && pacmanY < y + 12 && controller.enJeu()) {
            controller.getPacman().mort(ghost);
        }
    }

    public int getNbGhosts() {
        return model.getNbGhosts();
    }

    public int[] getGhostX() {
        return model.getGhostX();
    }
    public int[] getGhostY() {
        return model.getGhostY();
    }

    public int[] getGhostDirectionX() {
        return model.getGhostDirectionX();
    }

    public int[] getGhostDirectionY() {
        return model.getGhostDirectionY();
    }

    public int[] getDirectionX() {
        return model.getDirectionX();
    }

    public int[] getDirectionY() {
        return model.getDirectionY();
    }

    void mort(int ghost) {
        setGhostPos(ghost, -100, -100);
    }
}
