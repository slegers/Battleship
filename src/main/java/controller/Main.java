package controller;

/**
 * Created by yanice on 18/11/16.
 */
public class Main {
    public static void main(String[] args) {
       int som = 0;
        for(int i = 1; i < 17; i++){
        som  += i;
}
System.out.print(som/4);
        BattleshipController controller = new BattleshipController();
    }
}
