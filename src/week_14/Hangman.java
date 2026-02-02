package week_14;

import java.util.Scanner;

public class Hangman {
    private String hiddenWord;
    private int maxAttempt = 6; 
    private char [] letters;  // [_ _ _ _ _ _ _ _]
    private int currentAttempts = 0; 

    public Hangman(String hiddenWord) {
        this.hiddenWord = hiddenWord.toLowerCase();
        this.letters = new char[hiddenWord.length()];
        
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '_';
        }
    }

    public String getHiddenWord(){
        return this.hiddenWord.toLowerCase();
    }
    
    public boolean letterExists(char e){
        boolean found = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == e) {
                letters[i] = e; 
                found = true;
            }
        }
        return found;
    }


    private boolean isFinished() {
        for (char c : letters) {
            if (c == '_') return false;
        }
        return true;
    }

    public static void run(){
        Hangman h = new Hangman("hello");
        Scanner s = new Scanner(System.in);
        
        System.out.println("Welcome to Hangman!");

        while (h.currentAttempts < h.maxAttempt && !h.isFinished()) {
            System.out.print("\nCurrent word: ");
            for (char c : h.letters) System.out.print(c + " ");
            
            System.out.print("\nTake a guess: ");
            String guessStr = s.next().toLowerCase();

            if (guessStr.length() == 1) {
                char guess = guessStr.charAt(0);
                if (h.letterExists(guess)) {
                    System.out.println("Yes! '" + guess + "' is in the word.");
                } else {
                    h.currentAttempts++;
                    System.out.println("No luck. Attempts used: " + h.currentAttempts + "/" + h.maxAttempt);
                }
            }
        }

        if (h.isFinished()) {
            System.out.println("\nYou got it! The word was: " + h.getHiddenWord());
        } else {
            System.out.println("\nGame Over. The word was: " + h.getHiddenWord());
        }
    }


}