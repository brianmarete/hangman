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

}
