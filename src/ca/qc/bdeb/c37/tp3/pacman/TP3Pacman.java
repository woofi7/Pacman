package ca.qc.bdeb.c37.tp3.pacman;

import ca.qc.bdeb.c37.tp3.pacman.Controller.Controller;

import javax.swing.*;

/**
 *
 * @author Nicolas
 */
public class TP3Pacman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.init();
        
        JFrame frame = new JFrame();
        
        frame.add(controller.getNiveauView());
        frame.setTitle("Pacman");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 470);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
