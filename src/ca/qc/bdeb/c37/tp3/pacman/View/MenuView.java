/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.tp3.pacman.View;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;
import ca.qc.bdeb.c37.tp3.pacman.Controller.GameStateEnum;
import ca.qc.bdeb.c37.tp3.pacman.Controller.MenuEnum;
import ca.qc.bdeb.c37.tp3.pacman.Model.MenuModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author 1535216
 */
public class MenuView {
    private final Controller controller;
    private final MenuModel menuModel;
    private Screen currentScreen;

    public MenuView(Controller controller) {
        this.controller = controller;

        menuModel = controller.getMenuModel();

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PAC-FONT.TTF")));
        } catch (FontFormatException | IOException ignored) {}
    }

    public void setCurrentScreen(Screen screen) {
        this.currentScreen = screen;
    }

    public void onChangeGameState(GameStateEnum gameState) {
        switch (gameState) {
            case Home: {
                HomeScreen homeScreen = new HomeScreen(controller.getLargeurFenetre()
                        , controller.getHauteurFenetre()
                        , controller.getImages().getImage_menu()
                        , controller.getNiveauView());
                homeScreen.init();
                setCurrentScreen(homeScreen);
            }
            case InGame: {
                setCurrentScreen(null);
            }
            case Menu: {
                onChangeMenu(MenuEnum.Main);
            }
        }
    }


    public void onChangeMenu(MenuEnum menu) {
        switch (menu) {
            case Main: {
                MenuScreen menuScreen = new MenuScreen(controller.getLargeurFenetre()
                        , controller.getHauteurFenetre()
                        , controller.getNiveauView());
                menuScreen.init();
                setCurrentScreen(menuScreen);
            }
        }
    }
    public void afficherMenu(Graphics2D g2d, int indice) {
        if (this.currentScreen != null)  {
            this.currentScreen.draw(g2d);
        }
        switch (indice) {
            case 1:
                afficherMenuPrincipal(g2d);
                break;
            case 2:
                afficherMenuScore(g2d);
                break;
            case 3:
                afficherMenuChoixNiveau(g2d);
                break;
            case 4:
                afficherMenuPropos(g2d);
                break;
            case 5:
                afficherMenuParametres(g2d);
                break;
            case 6:
                controller.redemarrer();
                break;
            case 7:
                controller.arreter();
                break;
        }
    }

    private void afficherMenuPrincipal(Graphics2D g2d) {
        String[] messages = {"Score", "Choix du niveau", "À propos", "Paramètres", "Redémarrer", "Quitter"};

        drawTitle(g2d, "menu");
        drawMenu(g2d,messages);
    }

    private void afficherMenuScore(Graphics2D g2d) {
        drawTitle(g2d, "score");
    }

    private void afficherMenuChoixNiveau(Graphics2D g2d) {
        String[] messages = controller.getTitreNiveau();

        drawTitle(g2d, "Niveaux");
        drawMenu(g2d, messages);
    }

    private void afficherMenuParametres(Graphics2D g2d) {
        drawTitle(g2d, "parametre");
    }

    private void afficherMenuPropos(Graphics2D g2d) {
        Font fontMenu = new Font("Arial", Font.BOLD, 15);
        FontMetrics metr = controller.getNiveauView().getFontMetrics(fontMenu);
        int scrsize = controller.getLargeurFenetre();

        drawTitle(g2d, "A propos");

        String message1 = "Pacman créé par";
        String message2 = "Nicolas Signori et Alex Gravel";
        String message3 = "Version 1.5.0";

        g2d.setFont(fontMenu);
        g2d.drawString(message1, (scrsize - metr.stringWidth(message1)) / 2, scrsize / 3 + 50);
        g2d.drawString(message2, (scrsize - metr.stringWidth(message2)) / 2, scrsize / 3 + 70);
        g2d.drawString(message3, (scrsize - metr.stringWidth(message3)) / 2, scrsize / 3 + 110);
    }

    private void drawMenu(Graphics2D g2d,  String[] messages) {
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = controller.getNiveauView().getFontMetrics(small);
        int scrsize = controller.getLargeurFenetre();
        int hauteur = -100;

        for (int i = 0; i < messages.length; i++) {
            String message = messages[i];
            g2d.setColor(Color.black);
            g2d.fillRect(scrsize / 3, scrsize / 2 + hauteur, scrsize / 3, 30);
            g2d.setColor(Color.white);
            g2d.drawRect(scrsize / 3, scrsize / 2 + hauteur, scrsize / 3, 30);

            if (menuModel.getMenuOption(i)) {
                g2d.setColor(Color.red);
            }
            else {
                g2d.setColor(Color.white);
            }
            g2d.setFont(small);
            g2d.drawString(message, (scrsize - metr.stringWidth(message)) / 2, scrsize / 2 + 20 + hauteur);

            hauteur+= 50;
        }
    }

    private void drawTitle(Graphics2D g2d, String titre) {
        int scrsize = controller.getLargeurFenetre();
        Font fontMenu = new Font("pacfont", Font.TRUETYPE_FONT, 45);
        FontMetrics metr = controller.getNiveauView().getFontMetrics(fontMenu);

        g2d.setColor(new Color(0, 32, 48, 230));
        g2d.fillRect(0, 0, scrsize, scrsize + 30);

        g2d.setFont(fontMenu);
        g2d.setColor(Color.black);
        g2d.drawString(titre.toLowerCase(), (scrsize - metr.stringWidth(titre)) / 2, scrsize / 4 - 30);
        g2d.setColor(Color.white);
        g2d.drawString(titre.toUpperCase(), (scrsize - metr.stringWidth(titre)) / 2, scrsize / 4 - 30);
    }
}
