package ca.qc.bdeb.c37.tp3.pacman.Model;

/**
 *
 * @author Nicolas
 */
public class MenuModel {
    private final String[] messagesMenu = {"Score", "Choix du niveau", "À propos", "Paramètres", "Redémarrer", "Quitter"};
    private int indiceMenu = 0;
    private int menuNum = 1;

    public MenuModel() {
    }

    public String[] getMenuMessage() {
        return messagesMenu;
    }

    public boolean getMenuOption(int i) {
        return indiceMenu == i;
    }

    public int getMenuIndice() {
        return menuNum;
    }

    public void monterMenu() {
        indiceMenu--;
        if (indiceMenu < 0) {
            indiceMenu  = messagesMenu.length - 1;
        }
    }

    public void descendreMenu() {
        indiceMenu++;
        if (indiceMenu >= messagesMenu.length) {
            indiceMenu = 0;
        }
    }

    public void menuChoix() {
        this.menuNum = indiceMenu + 2;
    }

    public void resetMenu() {
        indiceMenu = 0;
        menuNum = 1;
    }


}
