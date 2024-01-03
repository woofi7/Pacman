package ca.qc.bdeb.c37.tp3.pacman.Controller;

import ca.qc.bdeb.c37.tp3.pacman.Model.*;
import ca.qc.bdeb.c37.tp3.pacman.View.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author 1535216
 */
public class Controller {
    private final ControllerPacman pacman;
    private final ControllerGhost ghost;

    private final Images imagesModel;
    private final ScoreBoardModel scoreBoardModel;
    private final MenuModel menuModel;
    private final MenuView menuView;

    private final NiveauModel niveauModel;
    private final NiveauView niveauView;

    private final PacmanModel pacmanModel;
    private final PacmanView pacmanView;

    private final GhostModel ghostModel;
    private final GhostView ghostView;

    public GameStateEnum gameState;
    public MenuEnum curentMenu;

    public Controller() {
        pacman = new ControllerPacman(this);
        ghost = new ControllerGhost(this);

        imagesModel = new Images();

        scoreBoardModel = new ScoreBoardModel();

        menuModel = new MenuModel();
        menuView = new MenuView(this);

        ghostModel = new GhostModel(this);
        pacmanModel = new PacmanModel();
        niveauModel = new NiveauModel(this);

        ghost.initStart(ghostModel);
        pacman.initStart(pacmanModel);

        niveauView = new NiveauView(this);
        ghostView = new GhostView(this, ghost);
        pacmanView = new PacmanView(this, pacman);

        niveauModel.initVariables();
        niveauView.init();
    }

    public void init() {
        this.setGameState(GameStateEnum.Home);
    }

    public void setGameState(GameStateEnum gameState) {
        if (this.gameState == gameState) {
            return;
        }

        this.gameState = gameState;
        menuView.onChangeGameState(this.gameState);
    }

    public KeyListener gererClavier() {
        return new GestionTouches(this);
    }

    public ControllerPacman getPacman() {
        return pacman;
    }

    public ControllerGhost getGhost() {
        return ghost;
    }

    public NiveauView getNiveauView() {
        return niveauView;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }
    public PacmanModel getPacmanModel() {
        return pacmanModel;
    }

    public GhostModel getGhostModel() {
        return ghostModel;
    }

    public NiveauModel getNiveauModel() {
        return niveauModel;
    }

    public Images getImages() {
        return imagesModel;
    }

    public void initPartie() {
        pacman.initPartie();
        ghost.initPartie();
        scoreBoardModel.setScore(0);

        niveauModel.initNiveau();
    }

    public void demarrerPartie() {
        niveauModel.setEnJeu(true);
        initPartie();
    }

    public void redemarrer() {
        demarrerPartie();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_P);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void arreter() {
        System.exit(0);
    }

    public void pause() {
        if (niveauModel.getTimer().isRunning()) {
            niveauModel.setPause(true);
        } else {
            niveauModel.setPause(false);
            menuModel.resetMenu();
            niveauModel.getTimer().start();
        }
    }

    public void gererMode(Graphics2D g2d) {
        if (niveauModel.getPause()) {
            menuView.afficherMenu(g2d, menuModel.getMenuIndice());
            niveauModel.getTimer().stop();
        }
        else if (enJeu()) {
            jouer(g2d);
        }
        else {
            menuView.afficherMenu(g2d, 0);
        }
    }

    public void animerPacman() {
        pacmanView.calculerAnimation();
    }

    private void jouer(Graphics2D g2d) {
        pacmanView.deplacerPacman();
        pacmanView.dessinerPacman(g2d);
        ghostView.moveGhosts(g2d);
        niveauModel.verifierGagner();
    }


    public void menuChoix() {
        if (!niveauModel.getTimer().isRunning()) {
            menuModel.menuChoix();
            niveauModel.setPause(false);
            niveauModel.getTimer().start();
            niveauModel.setPause(true);
        }
    }

    void monterMenu() {
        menuModel.monterMenu();
        niveauModel.setPause(false);
        niveauModel.getTimer().start();
        niveauModel.setPause(true);
    }

    void descendreMenu() {
        menuModel.descendreMenu();
        niveauModel.setPause(false);
        niveauModel.getTimer().start();
        niveauModel.setPause(true);
    }

    int getScoreMultiplier() {
        return scoreBoardModel.getScoreMultiplier();
    }

    void setScoreMultiplier(int multiplier) {
        scoreBoardModel.setScoreMultiplier(multiplier);
    }

    public int getScore() {
        return scoreBoardModel.getScore();
    }

    public void setScore(int score) {
        scoreBoardModel.setScore(score);
    }

    public int getNbCases() {
        return niveauModel.getNbCases();
    }

    public Dimension getDimensions() {
        return niveauModel.getDimensions();
    }

    public int getTailleCase() {
        return niveauModel.getTailleCase();
    }

    public int[] getDonneesFenetre() {
        return niveauModel.getDonneesFenetre();
    }

    public int[] getDonneesNiveau() {
        return niveauModel.getDonneesNiveau();
    }

    public int getLargeurFenetre() {
        return niveauView.getLargeurFenetre();
    }
    public int getHauteurFenetre() {
        return niveauView.getLargeurFenetre() + 30;
    }

    public boolean enJeu() {
        return niveauModel.getEnJeu();
    }

    public int getGhostStartX() {
        return niveauModel.getGhostStartX();
    }

    public int getGhostStartY() {
        return niveauModel.getGhostStartY();
    }
    public int getPacmanStartX() {
        return niveauModel.getPacmanStartX();
    }

    public int getPacmanStartY() {
        return niveauModel.getPacmanStartY();
    }

    public String[] getTitreNiveau() {
        return niveauModel.getTitreNiveau();
    }
}
