package ca.qc.bdeb.c37.tp3.pacman.View;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;
import ca.qc.bdeb.c37.tp3.pacman.Controller.ControllerPacman;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Nicolas
 */
public class GestionTouches extends KeyAdapter {
    private final Controller controller;
    private final ControllerPacman pacman;

    public GestionTouches(Controller controller) {
        this.controller = controller;
        this.pacman = controller.getPacman();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (controller.enJeu()) {
            switch (key) {
                case KeyEvent.VK_LEFT:
                case 'a':
                case 'A':
                    pacman.deplacerGauche();
                    break;
                case KeyEvent.VK_RIGHT:
                case 'd':
                case 'D':
                    pacman.deplacerDroite();
                    break;
                case KeyEvent.VK_UP:
                case 'w':
                case 'W':
                    pacman.deplacerHaut();
                    break;
                case KeyEvent.VK_DOWN:
                case 's':
                case 'S':
                    pacman.deplacerBas();
                    break;
                case KeyEvent.VK_ESCAPE:
                case 'p':
                case 'P':
                    controller.pause();
                    break;
                case KeyEvent.VK_ENTER:
                    controller.menuChoix();
                    break;
                default:
                    break;
            }
        } else if (key == 'D' || key == 'd') {
            controller.demarrerPartie();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
