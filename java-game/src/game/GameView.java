package game;


import city.cs.engine.UserView;
import city.cs.engine.World;
//import sun.lwawt.macosx.CPrinterGraphics;

import javax.swing.*;
import java.awt.*;


public class GameView extends UserView {
    private Knight knight;
    private Game game;

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(currentLevel.getBackground(), 0, 0, this);
        //super.paintBackground(g);
    }

    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);

       /* if (game.isGameOver()) {
            g.drawString("GameOver", this.getWidth() / 2, this.getHeight() / 2);
        }*/




        g.setColor(Color.white);
        g.scale(1.5, 1.5);
        /*g.drawString("W for jump",110,230);
        g.drawString("A + D for left and right",80,250);*/
        g.setStroke(new BasicStroke(2));
        g.drawRect(10, 10, 50, 25);
        g.setFont(new Font("Consolas", Font.BOLD, 14));
        g.drawString("" + currentLevel.getKnight().getCoins(), 35, 27);
        g.drawImage(new ImageIcon("data/coin.png").getImage(), 5, 5, 35, 35, this);
        g.setFont(new Font("Consolas", Font.BOLD, 14));
        g.drawString("=" + currentLevel.getKnight().getLives(), 500, 22);
        g.drawImage(new ImageIcon("data/heart.png").getImage(), 475, 3, 35, 35, this);
        g.setFont(new Font("Consolas", Font.BOLD, 14));
        g.drawString("SCORE = " + currentLevel.getKnight().getScore(), 250, 22);

    }


    public void setWorld(World w){

        super.setWorld(w);
        currentLevel = (GameLevel) w;
    }

    GameLevel currentLevel;

    public GameView(Game game, GameLevel w, int width, int height, Knight k) {
        super(w, width, height);
        knight = k;
        currentLevel = w;
        this.game = game;



    }

}





