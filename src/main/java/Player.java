import java.util.List;
import java.util.ArrayList;

public class Player {
  private int mCurrentTry;
  private List<Character> mPreviousGuesses;
  private Game mGame;

  public Player (Game game) {
    this.mGame = game;
    this.mCurrentTry = 0;
    this.mPreviousGuesses = new ArrayList<>();
  }

  public int getCurrentTry() {
    return this.mCurrentTry;
  }

  public boolean hasPreviouslyGuessed(char guess) {
    return this.mPreviousGuesses.contains(guess);
  }

  public boolean didWeLose() {
    return (this.mCurrentTry >= Game.MAX_GUESSES);
  }

  /* 
   * I could have put this method in the game class because it only uses
   * methods in that class but I put it here so I can check if an 
   * individual player object has won a game. Plus "player.didWeWin(game)"
   * reads better to me.
   * */
  public boolean didWeWin(Game game) {
    String guess = game.getCondensedCurrentGuess();
    return guess.equals(game.getMysteryWord());
  }

}
