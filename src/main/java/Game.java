public class Game {
  private String mMysteryWord;
  private StringBuilder mCurrentGuess; // I used StringBuilder because it is mutable
  private static final int MAX_GUESSES = 6;

  public Game(String word) {
    this.mMysteryWord = word;
    this.mCurrentGuess = initializeCurrentGuess(this.mMysteryWord);
  }

  public String getMysteryWord() {
    return this.mMysteryWord;
  }
}
