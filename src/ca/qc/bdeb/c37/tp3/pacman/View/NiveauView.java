package ca.qc.bdeb.c37.tp3.pacman.View;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;
import ca.qc.bdeb.c37.tp3.pacman.Controller.ControllerPacman;
import ca.qc.bdeb.c37.tp3.pacman.Controller.GameStateEnum;
import ca.qc.bdeb.c37.tp3.pacman.Model.Images;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas
 */
public class NiveauView extends JPanel implements ActionListener {
    private final Controller controller;
    private final ControllerPacman pacman;

    private final Images images;

    private final Font fontScore = new Font("Arial", Font.BOLD, 15);
    private final Color couleurMurs = new Color(65, 105, 225);
    private final Color couleurPoints = Color.white;
    private final Color couleurPowerUp = Color.green;
    private final Color couleurScore = new Color(96, 128, 255);
    private final Color couleurBackground = Color.black;

    private int largeurFenetre;

    public NiveauView(Controller controller) {
        this.controller = controller;
        this.pacman = controller.getPacman();

        images = controller.getImages();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        controller.initPartie();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerJeu(g);
    }

    public void init() {
        largeurFenetre = 24 * controller.getNbCases();
        addKeyListener(controller.gererClavier());
        setFocusable(true);
        setBackground(couleurBackground);
        setDoubleBuffered(true);
    }

    private void dessinerJeu(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(couleurBackground);
        g2d.fillRect(0, 0, controller.getDimensions().width, controller.getDimensions().height);

        dessinerNiveau(g2d);
        dessinerScore(g2d);
        controller.animerPacman();
        controller.gererMode(g2d);

        g2d.drawImage(null, 5, 5, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    private void dessinerNiveau(Graphics2D g2d) {
        int i = 0;
        int taille = controller.getTailleCase();
        int ptsFenetre[] = controller.getDonneesFenetre();
        int typeCaseTab[] = controller.getDonneesNiveau();

        for (int y = 0; y < largeurFenetre; y += taille) {
            for (int x = 0; x < largeurFenetre; x += taille) {
                int typeCase = typeCaseTab[i];

                g2d.setColor(couleurMurs);
                g2d.setStroke(new BasicStroke(2));

                //Mur gauche
                if (typeCase == 5 || typeCase == 4 || typeCase == 3 || typeCase == 2) {
                    g2d.drawLine(x, y, x, y + taille - 1);
                }

                //Mur haut
                if (typeCase == 5 || typeCase == 6 || typeCase == 7 || typeCase == 10) {
                    g2d.drawLine(x, y, x + taille - 1, y);
                }

                //Mur droite
                if (typeCase == 10 || typeCase == 11 || typeCase == 4 || typeCase == 12) {
                    g2d.drawLine(x + taille - 1, y, x + taille - 1,y + taille - 1);
                }

                //Mur bas
                if (typeCase == 12 || typeCase == 13 || typeCase == 2 || typeCase == 8 || typeCase == 6 || typeCase == 9) {
                    g2d.drawLine(x, y + taille - 1, x + taille - 1,y + taille - 1);
                }

                //Points
                if (ptsFenetre[i] == 1) {
                    g2d.setColor(couleurPoints);
                    g2d.fillRect(x + 11, y + 11, 2, 2);
                }
                else if (ptsFenetre[i] == 2) {
                    g2d.setColor(couleurPowerUp);
                    g2d.fillRect(x + 8, y + 8, 8, 8);
                }

                i++;
            }
        }
    }

    private void dessinerScore(Graphics2D g) {
        String message = "Score: " + controller.getScore();
        g.setFont(fontScore);
        g.setColor(couleurScore);
        g.drawString(message, largeurFenetre / 2 + 100, largeurFenetre + 16);

        for (int i = 0; i < pacman.getNbVies(); i++) {
            g.drawImage(images.getPacman3droite(), i * 28 + 20, largeurFenetre + 1, this);
        }
    }

    public int getLargeurFenetre() {
        return largeurFenetre;
    }
}
