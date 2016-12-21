package model.settings;


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
}
