package ca.qc.bdeb.c37.tp3.pacman.Model;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;

/**
 *
 * @author Nicolas
 */
public class GhostModel {
    private final Controller controller;

    private int nbGhosts;

    private int[] ghostX;
    private int[] ghostY;

    private int[] ghostDirectionX;
    private int[] ghostDirectionY;

    private int[] directionX;
    private int[] directionY;

    public GhostModel(Controller controller) {
        this.controller = controller;
        directionX = new int[5];
        directionY = new int[5];
    }

    public void initVariables() {
        ghostX = new int[nbGhosts];
        ghostDirectionX = new int[nbGhosts];
        ghostY = new int[nbGhosts];
        ghostDirectionY = new int[nbGhosts];

        for (int i = 0; i < nbGhosts; i++) {
            ghostX[i] = controller.getGhostStartX() * 24;
            ghostY[i] = controller.getGhostStartY() * 24;
        }
    }

    public int getNbGhosts() {
        return nbGhosts;
    }

    public void setNbGhosts(int nbGhosts) {
        this.nbGhosts = nbGhosts;
    }

    public int[] getGhostX() {
        return ghostX;
    }

    public int[] getGhostY() {
        return ghostY;
    }

    public int[] getGhostDirectionX() {
        return ghostDirectionX;
    }

    public int[] getGhostDirectionY() {
        return ghostDirectionY;
    }

    public int[] getDirectionX() {
        return directionX;
    }

    public int[] getDirectionY() {
        return directionY;
    }
}
