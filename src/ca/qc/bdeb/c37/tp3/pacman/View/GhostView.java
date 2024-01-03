package ca.qc.bdeb.c37.tp3.pacman.View;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;
import ca.qc.bdeb.c37.tp3.pacman.Controller.ControllerGhost;
import ca.qc.bdeb.c37.tp3.pacman.Model.Images;
import ca.qc.bdeb.c37.tp3.pacman.Model.NiveauModel;
import java.awt.Graphics2D;

/**
 *
 * @author Nicolas
 */
public class GhostView {
    private final Controller controller;
    private final ControllerGhost model;

    private final Images images;
    private final NiveauModel niveauModel;

    public GhostView(Controller controller, ControllerGhost model) {
        this.controller = controller;
        this.model = model;

        niveauModel = controller.getNiveauModel();
        images = controller.getImages();
    }

    public void moveGhosts(Graphics2D g2d) {
        int taille = niveauModel.getTailleCase();
        int nbCases = niveauModel.getNbCases();
        int position;
        int direction;
        int prochain;

        for (int ghost = 0; ghost < model.getNbGhosts(); ghost++) {
            if (model.getGhostX()[ghost] % taille == 0
                    && model.getGhostY()[ghost] % taille == 0) {
                position = model.getGhostX()[ghost] / taille +
                        nbCases * (model.getGhostY()[ghost] / taille);

                direction = 0;

                //Gauche
                if (model.getGhostDirectionX()[ghost] != 1) {
                    prochain = niveauModel.getPointsNiveau()[position - 1];
                    model.setDirection(direction, -1, 0);
                    direction++;
                    direction = checkNextDirection(direction, prochain);
                } //Bas
                if (model.getGhostDirectionY()[ghost] != 1) {
                    prochain = niveauModel.getPointsNiveau()[position - nbCases];
                    model.setDirection(direction, 0, -1);
                    direction++;
                    direction = checkNextDirection(direction, prochain);
                } //Droite
                if (model.getGhostDirectionX()[ghost] != -1){
                    prochain = niveauModel.getPointsNiveau()[position + 1];
                    model.setDirection(direction, 1, 0);
                    direction++;
                    direction = checkNextDirection(direction, prochain);
                } //Haut
                if (model.getGhostDirectionY()[ghost] != -1){
                    prochain = niveauModel.getPointsNiveau()[position + nbCases];
                    model.setDirection(direction, 0, 1);
                    direction++;
                    direction = checkNextDirection(direction, prochain);
                }


                if (direction != 0) {
                    direction = (int) (Math.random() * direction);

                    if (direction > 4) {
                        direction = 4;
                    }

                    model.setGhostDirection(ghost, model.getDirectionX()[direction], model.getDirectionY()[direction]);
                }
            }

            int x = model.getGhostX()[ghost] + model.getGhostDirectionX()[ghost] * 3;
            int y = model.getGhostY()[ghost] + model.getGhostDirectionY()[ghost] * 3;

            model.setGhostPos(ghost,  x, y);
            drawGhost(g2d, ghost, x + 1, y + 1);

            model.checkPacman(ghost, x, y);
        }
    }

    private int checkNextDirection(int count, int prochain) {
        if (prochain == 0) {
            model.setDirection(count, 0, 0);

            if (count != 0) {
                count--;
            }
        } else {
            model.setDirection(count, -model.getDirectionX()[count], -model.getDirectionY()[count]);
        }
        return count;
    }

    private void drawGhost(Graphics2D g2d,int ghost, int x, int y) {
        if (controller.getPacmanModel().getPowerUp().isRunning()) {
            g2d.drawImage(images.getGhost5(), x, y, controller.getNiveauView());
        }
        else {
            switch (ghost) {
                case 0:
                    g2d.drawImage(images.getGhost1(), x, y, controller.getNiveauView());
                    break;
                case 1:
                    g2d.drawImage(images.getGhost2(), x, y, controller.getNiveauView());
                    break;
                case 2:
                    g2d.drawImage(images.getGhost3(), x, y, controller.getNiveauView());
                    break;
                case 3:
                    g2d.drawImage(images.getGhost4(), x, y, controller.getNiveauView());
                    break;
            }
        }
    }
}
