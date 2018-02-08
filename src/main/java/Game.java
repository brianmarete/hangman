public class Game {
  private String mMysteryWord;
  private StringBuilder mCurrentGuess; // I used StringBuilder because it is mutable
  public static final int MAX_GUESSES = 6;

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
      current.append((i % 2 == 0) ? "_" : " ");
    }

    return current;
   }

  public boolean gameOver(Player player) {
    return (player.didWeWin(this) || player.didWeLose());
  }

  public boolean checkGuess(char guess) {
    boolean isItAGoodGuess = false;

    for (int i = 0; i < this.mMysteryWord.length(); i++) {
      if (this.mMysteryWord.charAt(i) == guess) {
        /*
         * A character at index i in the mystery word corresponds with
         * the character at index i * 2 in the current guess.
         * So if the player's guess is correct, we need to change the character
         * at index i * 2 of the current guess as to "reveal" the character.
         * */
        this.mCurrentGuess.setCharAt(i * 2, guess);
        isItAGoodGuess = true;
      }
    }

    return isItAGoodGuess;
  }

  public String drawPicture(Player player) {
    switch(player.getCurrentTry()){
      case 0: return drawPost();
      case 1: return drawHead();
      case 2: return drawBody();
      case 3: return drawOneArm();
      case 4: return drawSecondArm();
      case 5: return drawFirstLeg();
      default: return drawFullPerson();
    }
  }

  public String drawPost() {
    return " - - - - -\n"+
       "|        |\n"+
       "|        \n" +
       "|       \n"+
       "|        \n" +
       "|       \n" +
       "|\n" +
       "|\n";
  }

  public String drawHead() {
    return " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|       \n"+
         "|        \n" +
         "|       \n" +
         "|\n" +
        "|\n";
  }

  public String drawBody() {
     return " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|        | \n"+
         "|        |\n" +
         "|        \n" +
         "|\n" +
        "|\n";
  }

  public String drawOneArm() {
    return   " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|      / |  \n"+
         "|        |\n" +
         "|        \n" +
         "|\n" +
        "|\n";
  }

  public String drawSecondArm() {
   return  " - - - - -\n"+
       "|        |\n"+
       "|        O\n" +
       "|      / | \\ \n"+
       "|        |\n" +
       "|        \n" +
       "|\n" +
      "|\n";
  }

  public String drawFirstLeg() {
   return   " - - - - -\n"+
       "|        |\n"+
       "|        O\n" +
       "|      / | \\ \n"+
       "|        |\n" +
       "|       / \n" +
       "|\n" +
      "|\n";
  }

  public String drawFullPerson() {
    return   " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|      / | \\ \n"+
         "|        |\n" +
         "|       / \\ \n" +
         "|\n" +
        "|\n";
  }

}
