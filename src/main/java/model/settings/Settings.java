package model.settings;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

class Settings {
    private static volatile Settings settings;
    private static boolean done = true;
    private int length, height;
    private String namePlayer1, namePlayer2,attackStrategy,placeStrategy;
    private boolean gameIsStarted = false;
    private final int maxScore = 19;
    private final int maxShips = 5;
    private Settings() {

    }

    public static synchronized Settings getSettings() {
        if (done) {
            done = false;
            settings = new Settings();
        }
        return settings;
    }

    public void setLength(int length) {

        this.length = length;


    }

    public int getLength() {
        return length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setNamePlayer1(String name) {
        this.namePlayer1 = name;
    }

    public String getNamePlayer1() {
        return namePlayer1;
    }

    public String getNamePlayer2() {
        return namePlayer2;
    }

    public void setNamePlayer2(String name) {
        this.namePlayer2 = name;
    }

    public void setGameIsStarted(){
        gameIsStarted = true;
    }
    public boolean getGameIsStarted(){
        return gameIsStarted;
    }

    public void setAttackStrategy(String attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setPlaceStrategy(String placeStrategy) {
        this.placeStrategy = placeStrategy;
    }

    public String getAttackStrategy() {
        return attackStrategy;
    }

    public String getPlaceStrategy() {
        return placeStrategy;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getMaxShips() {
        return maxShips;
    }

    public void savePropertiesFile() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("files/config.properties");

            // set the properties value
            prop.setProperty("length", length+"");
            prop.setProperty("height", height+"");
            prop.setProperty("namePlayer1", namePlayer1);
            prop.setProperty("namePlayer2", namePlayer2);
            prop.setProperty("attackStrategy", attackStrategy);
            prop.setProperty("placeStrategy", placeStrategy);
            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
