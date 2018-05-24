package com.brianmarete;

import java.util.Scanner;

public class App {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    boolean continuePlaying = true;
    Dictionary dictionary = new Dictionary();

    while(continuePlaying) {
      Game hangman = new Game(dictionary.getRandomWord());
      Player player = new Player(hangman);

      System.out.println("\n" + hangman.drawPicture(player) + "\n");

      do {
        System.out.println(hangman.getFormalCurrentGuess());

        System.out.println("Tries left: " + (Game.MAX_GUESSES - player.getCurrentTry()));
        System.out.print("\nEnter a character you think is in the word: ");
        char guess = (sc.next().toUpperCase()).charAt(0);

        while (player.hasPreviouslyGuessed(guess)) {
          System.out.print("\nTry again, you've already guessed that character: ");
          guess = (sc.next().toUpperCase()).charAt(0);
        }

        if (player.playGuess(guess)) {
          System.out.println("\nCorrect!");
        } else {
          System.out.println("\nIncorrect!");
        }

        System.out.println("\n" + hangman.drawPicture(player) + "\n");
      } while (!hangman.gameOver(player));

      if (player.didWeWin(hangman)) {
        System.out.println("\nCongrats! You guessed the right word! " + hangman.getMysteryWord());
      } else if (player.didWeLose()) {
        System.out.println("\nSorry, you lost. The word was " + hangman.getMysteryWord() + ".");
      }

      System.out.print("\nDo you want to play another game? (Y/N): ");
      char response = (sc.next().toUpperCase()).charAt(0);
      continuePlaying = (response == 'Y');
    }
  }
}
