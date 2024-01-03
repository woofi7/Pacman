package ca.qc.bdeb.c37.tp3.pacman.View;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * Created by Nicolas on 04/12/2016.
 */

interface ButtonEvent {
    void onClick();
}

public class GuiButton {
    public ButtonEvent action;

    public GuiButton(ButtonEvent event) {
        this.action = event;
    }

    public void onClick() {
        this.action.onClick();
    }
}
