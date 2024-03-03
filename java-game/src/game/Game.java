package game;

import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {

    private boolean gameOver;
    private SoundClip gameMusic;
    GameLevel currentLevel;
    GameView view;
    KnightController controller;
    private boolean menuVisible;
    private ControlPanel controlPanel;
    private JFrame frame;

    /**
     * Initialise a new Game.
     */
    public Game() {

        gameOver = false;
        menuVisible = false;

        //1. make an empty game world
        currentLevel = new Level1(this);

        try {
            gameMusic = new SoundClip("data/level1.mp3");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
        // ...

        // UserView view = new UserView(world, 500, 500);
        view = new GameView(this, currentLevel, 800, 600, currentLevel.getKnight());

        //Keyboard Interaction
        view.addMouseListener(new GiveFocus(view));
        controller = new KnightController(this, currentLevel.getKnight());
        view.addKeyListener(controller);


        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);

        //3. create a Java window (frame) and add the game
        //   view to it
        frame = new JFrame("City Game");
        frame.add(view);

        controlPanel = new ControlPanel(this);
        //frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(currentLevel, 500, 500);

        // start our game world simulation!
        currentLevel.start();

        currentLevel.addStepListener((StepListener) new Tracker(view, currentLevel.getKnight()));
    }

    public void endGame() {

        if (currentLevel instanceof Level1)
            System.exit(0);
        else if (currentLevel instanceof Level2)
            System.exit(0);
    }

    public void goToNextLevel() {

        if (currentLevel instanceof Level1) {
            currentLevel.stop();

            Knight prevKnight = currentLevel.getKnight();

            currentLevel = new Level2(this);

            Knight newKnight = currentLevel.getKnight();
            newKnight.setScore(prevKnight.getScore());
            newKnight.setLives(prevKnight.getLives());
            newKnight.setCoins(prevKnight.getCoins());

            view.setWorld(currentLevel);
            controller.updateKnight(currentLevel.getKnight());
            currentLevel.addStepListener((StepListener) new Tracker(view, currentLevel.getKnight()));
            currentLevel.start();
            currentLevel.addStepListener((StepListener) new Tracker(view, currentLevel.getKnight()));
            //view.addKeyListener(new KnightController(currentLevel.getKnight()));

        } else if (currentLevel instanceof Level2) {
            currentLevel.stop();
            Knight prevKnight = currentLevel.getKnight();
            currentLevel = new Level3(this);
            Knight newKnight = currentLevel.getKnight();
            newKnight.setScore(prevKnight.getScore());
            newKnight.setLives(prevKnight.getLives());
            newKnight.setCoins(prevKnight.getCoins());
            view.setWorld(currentLevel);
            controller.updateKnight(currentLevel.getKnight());
            currentLevel.addStepListener((StepListener) new Tracker(view, currentLevel.getKnight()));
            currentLevel.start();
            currentLevel.addStepListener((StepListener) new Tracker(view, currentLevel.getKnight()));
        } else if (currentLevel instanceof Level3) {
            System.out.println("Game done");
            System.exit(0);
        }
    }



    public void setGameOver(boolean over) {
        gameOver = over;
        currentLevel.stop();
        view.repaint();
    }



    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();

    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void toggleMenu(){
        if (menuVisible){
            //hide menu
            frame.remove(controlPanel.getMainPanel());
            menuVisible = false;
            frame.pack();
            //currentLevel.start();
        }
        else {
            //show menu
            frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);
            menuVisible = true;
            frame.pack();
            //currentLevel.stop();
        }
    }
}
