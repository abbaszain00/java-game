package game;

import city.cs.engine.CircleShape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton quitButton;

    private Game game;
    public ControlPanel(Game game){
        this.game = game;


        pauseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.currentLevel.stop();



            }
        });
        resumeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.currentLevel.start();

            }
        });
        quitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.endGame();
            }
        });
    }

    public JPanel getMainPanel(){
        return  mainPanel;
    }
}
