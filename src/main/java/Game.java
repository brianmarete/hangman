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

  public String getCondensedCurrentGuess() {
    String guess = this.mCurrentGuess.toString();
    return guess.replace(" ", "");
  }

  public String getFormalCurrentGuess() {
    return "Current Guess: " + this.mCurrentGuess.toString();
  }

  public StringBuilder initializeCurrentGuess(String word) {
    StringBuilder current = new StringBuilder();
    
    /* 
     * The output for this method should consist of alternating
     * underscores and spaces eg "_ _ _ _". The number of underscores
     * should be equal to the length of the passed in word. To do this 
     * we need to append alternating "_" and " " to the StringBuilder object
     * using a loop that will run for twice the length of the passed in word
     * because the output will consist of an equal number of underscores and spaces.
     * */
    for (int i = 0; i < word.length() * 2; i++) {
      (i % 2 == 0) ? current.append("_") : current.append(" ");
    }

    return current;
   }
}
