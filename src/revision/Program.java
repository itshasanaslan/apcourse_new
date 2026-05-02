package revision;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        int x = 5;

        int fOfx = factorial(x);


    }

    public static void hey() {
        Warrior w1 = new Warrior("Camelot", 90, 7);
        Warrior w2 = new Warrior("Arthur", 100, 7);
        Warrior w3 = new Warrior();
        Game game = new Game();

    }


 


    public static int factorial(int n) {
        // base case
        if (n == 0 || n == 1)
            return 1;






        return n * factorial(n - 1);
    }

}
