package game;

import java.io.*;

public class GameSaverLoader {

    public static void save (GameLevel level, String fileName) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);

            writer.write(level.getLevelName() + "," + level.getKnight().getCoins() + "," + level.getKnight().getLives() + "," + level.getKnight().getScore()) ;



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

   /* public static GameLevel load(String fileName, Game game) throws IOException {

        FileReader fr = null;
        BufferedReader reader = null;
        try {

            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            GameLevel level;

            if (line.equals("Level1")){
                level = new Level1(game);
                level.getKnight().setCoins();
                level.getKnight().setLives();
                level.getKnight().setScore();

            }if (line.equals("Level2")){
                level.getKnight().setCoins();
                level.getKnight().setLives();
                level.getKnight().setScore();

            }if (line.equals("Level3")){
                level.getKnight().setCoins();
                level.getKnight().setLives();
                level.getKnight().setScore();
            }
            line = reader.readLine();
            while (line != null) {

                String[] tokens = line.split(",");

                if (tokens[])

                line = reader.readLine();
            }
            System.out.println("...done.");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

    }*/
}
