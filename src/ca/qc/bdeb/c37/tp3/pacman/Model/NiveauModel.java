package ca.qc.bdeb.c37.tp3.pacman.Model;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;
import ca.qc.bdeb.c37.tp3.pacman.Controller.GameStateEnum;

import java.awt.Dimension;
import java.io.*;
import javax.swing.Timer;

/**
 *
 * @author Nicolas
 */
public class NiveauModel {
    private final Controller controller;

    private final String[] fichiersNiveau = {"level1.txt", "level2.txt"};
    private final int tailleCase;

    private int levelNum = 0;
    private String[] titreNiveau;
    private int[][] pointsNiveau;
    private int[][] donneesNiveau;
    private int[] donneesFenetre;
    private int[] pacmanStartX;
    private int[] pacmanStartY;
    private int[] ghostStartX;
    private int[] ghostStartY;

    private int nbCases;

    private Dimension dimensions;
    private Timer timer;

    private boolean pause = false;
    private boolean enJeu = false;

    public NiveauModel(Controller controller) {
        this.controller = controller;
        this.tailleCase = 24;

        titreNiveau = new String[fichiersNiveau.length];
        pacmanStartX = new int[fichiersNiveau.length];
        pacmanStartY = new int[fichiersNiveau.length];
        ghostStartX = new int[fichiersNiveau.length];
        ghostStartY = new int[fichiersNiveau.length];
        pointsNiveau = new int[fichiersNiveau.length][];
        donneesNiveau = new int[fichiersNiveau.length][];

        for (int i = 0; i < fichiersNiveau.length; i++) {
            try {
                loadLevel(fichiersNiveau[i], i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadLevel(String filename, int i) throws IOException {
        BufferedReader inputReader;
        inputReader = new BufferedReader(new FileReader(filename));
        String pos[];

        titreNiveau[i] = inputReader.readLine();
        int size = Integer.parseInt(inputReader.readLine());

        pos = inputReader.readLine().split(";");
        pacmanStartX[i] = Integer.parseInt(pos[0]);
        pacmanStartY[i] = Integer.parseInt(pos[1]);
        pos = inputReader.readLine().split(";");
        ghostStartX[i] = Integer.parseInt(pos[0]);
        ghostStartY[i] = Integer.parseInt(pos[1]);

        pointsNiveau[i] = readArray(inputReader, size);
        donneesNiveau[i] = readArray(inputReader, size);
    }

    private static int[] readArray(BufferedReader inputReader, int size) throws IOException {
        int[] tab = new int[size];
        int indice = 0;

        for (int i = 0; i < Math.sqrt(size); i++) {
            String ligne = inputReader.readLine();

            String[] nombres = ligne.split(";");

            for (int j = 0; j < nombres.length - 1; j++) {
                tab[indice] = Integer.parseInt(nombres[j].trim());

                indice++;
                if (indice == size) {
                    break;
                }
            }
        }

        return tab;
    }

    public void initVariables() {
        nbCases = (int) Math.sqrt(donneesNiveau[levelNum].length);
        donneesFenetre = new int[donneesNiveau[levelNum].length];
        dimensions = new Dimension(400, 400);

        timer = new Timer(40, controller.getNiveauView());
        timer.start();
    }

    public void initNiveau() {
        System.arraycopy(pointsNiveau[levelNum], 0, donneesFenetre, 0, nbCases * nbCases);

        controller.getPacman().setPacmanPos(pacmanStartX[levelNum] * tailleCase, pacmanStartY[levelNum] * tailleCase);
        controller.getGhost().resetGhost();
    }

    public void verifierGagner() {
        int i = 0;
        boolean gagne = true;

        while (i < nbCases * nbCases) {
            if (donneesFenetre[i] == 1) {
                gagne = false;
                break;
            }
            i++;
        }

        if (gagne) {
            controller.setScore(controller.getScore() + 50);
            initNiveau();
        }
    }

    public int[] getPointsNiveau() {
        return pointsNiveau[levelNum];
    }

    public int[] getDonneesNiveau() {
        return donneesNiveau[levelNum];
    }

    public boolean getEnJeu() {
        return enJeu;
    }

    public void setEnJeu(boolean enJeu) {
        this.enJeu = enJeu;
    }

    public int[] getDonneesFenetre() {
        return donneesFenetre;
    }

    public void setDonneesFenetre(int position) {
        this.donneesFenetre[position] = 0;
    }

    public int getTailleCase() {
        return tailleCase;
    }

    public int getNbCases() {
        return nbCases;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean getPause() {
        return pause;
    }

    public int getPacmanStartX() {
        return pacmanStartX[levelNum];
    }

    public int getPacmanStartY() {
        return pacmanStartY[levelNum];
    }

    public int getGhostStartX() {
        return ghostStartX[levelNum];
    }

    public int getGhostStartY() {
        return ghostStartY[levelNum];
    }

    public String[] getTitreNiveau() {
        return titreNiveau;
    }
}
