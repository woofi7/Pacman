package ca.qc.bdeb.c37.tp3.pacman.View;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;
import ca.qc.bdeb.c37.tp3.pacman.Controller.ControllerPacman;
import ca.qc.bdeb.c37.tp3.pacman.Model.Images;
import ca.qc.bdeb.c37.tp3.pacman.Model.NiveauModel;

import java.awt.Graphics2D;

/**
 *
 * @author Nicolas
 */
public class PacmanView {
    private final ControllerPacman pacman;

    private final NiveauModel niveauModel;
    private final NiveauView niveauView;
    private final Images images;

    private int pacmanAnimCompteur = 2;
    private int pacmanAnimDirection = 1;
    private int pacmanAnimPosition = 0;

    public PacmanView(Controller controller, ControllerPacman pacman) {
        this.pacman = pacman;

        niveauModel = controller.getNiveauModel();
        niveauView = controller.getNiveauView();
        images = controller.getImages();
    }

    public void deplacerPacman() {

        pacman.vitessePowerUp();

        if (pacman.pacmanSurCase()) {
            int tailleCase = niveauModel.getTailleCase();
            int nbCases = niveauModel.getNbCases();
            int prochain;
            int position = pacman.getPacmanX() / tailleCase + nbCases * (pacman.getPacmanY() / tailleCase);
            int deplacementX = pacman.getDeplacementX();
            int deplacementY = pacman.getDeplacementY();

            pacman.gestionPoints(position);

            pacman.setPacmanDirection(deplacementX, deplacementY);
            pacman.setPacmanVue(deplacementX, deplacementY);

            //Gauche
            if (deplacementX == -1 && deplacementY == 0) {
                prochain = niveauModel.getPointsNiveau()[position - 1];
            } //Droite
            else if (deplacementX == 1 && deplacementY == 0) {
                prochain = niveauModel.getPointsNiveau()[position + 1];
            } //Haut
            else if (deplacementX == 0 && deplacementY == -1) {
                prochain = niveauModel.getPointsNiveau()[position - nbCases];
            } //Bas
            else {
                prochain = niveauModel.getPointsNiveau()[position + nbCases];
            }

            if (prochain == 0) {
                pacman.setPacmanDirection(0, 0);
            }
        }

        pacman.setPacmanPos(pacman.getPacmanX() + pacman.getDirectionX() * pacman.getVitesse(),
                pacman.getPacmanY() + pacman.getDirectionY() * pacman.getVitesse());

    }

    public void dessinerPacman(Graphics2D g2d) {
        if (pacman.getPacmanVueX() == -1) {
            drawPacnanGauche(g2d);
        } else if (pacman.getPacmanVueX() == 1) {
            drawPacmanDroite(g2d);
        } else if (pacman.getPacmanVueY() == -1) {
            drawPacmanHaut(g2d);
        } else {
            drawPacmanBas(g2d);
        }
    }

    private void drawPacnanGauche(Graphics2D g2d) {
        int x = pacman.getPacmanX() + 1;
        int y = pacman.getPacmanY() + 1;
        switch (pacmanAnimPosition) {
            case 1:
                g2d.drawImage(images.getPacman2gauche(), x, y, niveauView);
                break;
            case 2:
                g2d.drawImage(images.getPacman3gauche(), x, y, niveauView);
                break;
            case 3:
                g2d.drawImage(images.getPacman4gauche(), x, y, niveauView);
                break;
            default:
                g2d.drawImage(images.getPacman1(), x, y, niveauView);
                break;
        }
    }

    private void drawPacmanDroite(Graphics2D g2d) {
        int x = pacman.getPacmanX() + 1;
        int y = pacman.getPacmanY() + 1;
        switch (pacmanAnimPosition) {
            case 1:
                g2d.drawImage(images.getPacman2droite(), x, y, niveauView);
                break;
            case 2:
                g2d.drawImage(images.getPacman3droite(), x, y, niveauView);
                break;
            case 3:
                g2d.drawImage(images.getPacman4droite(), x, y, niveauView);
                break;
            default:
                g2d.drawImage(images.getPacman1(), x, y, niveauView);
                break;
        }
    }

    private void drawPacmanHaut(Graphics2D g2d) {
        int x = pacman.getPacmanX() + 1;
        int y = pacman.getPacmanY() + 1;
        switch (pacmanAnimPosition) {
            case 1:
                g2d.drawImage(images.getPacman2haut(), x, y, niveauView);
                break;
            case 2:
                g2d.drawImage(images.getPacman3haut(), x, y, niveauView);
                break;
            case 3:
                g2d.drawImage(images.getPacman4haut(), x, y, niveauView);
                break;
            default:
                g2d.drawImage(images.getPacman1(), x, y, niveauView);
                break;
        }
    }

    private void drawPacmanBas(Graphics2D g2d) {
        int x = pacman.getPacmanX() + 1;
        int y = pacman.getPacmanY() + 1;
        switch (pacmanAnimPosition) {
            case 1:
                g2d.drawImage(images.getPacman2bas(), x, y, niveauView);
                break;
            case 2:
                g2d.drawImage(images.getPacman3bas(), x, y, niveauView);
                break;
            case 3:
                g2d.drawImage(images.getPacman4bas(), x, y, niveauView);
                break;
            default:
                g2d.drawImage(images.getPacman1(), x, y, niveauView);
                break;
        }
    }

    public void calculerAnimation() {
        pacmanAnimCompteur--;

        if (pacmanAnimCompteur <= 0) {
            pacmanAnimCompteur = 2;
            pacmanAnimPosition = pacmanAnimPosition + pacmanAnimDirection;

            if (pacmanAnimPosition == 3 || pacmanAnimPosition == 0) {
                pacmanAnimDirection = -pacmanAnimDirection;
            }
        }
    }
}
