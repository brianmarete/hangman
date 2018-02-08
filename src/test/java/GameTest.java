import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {

  Game testGame;
  Player testPlayer;
  @Before
  public void setUp() {
    testGame = new Game("MOVIE");
    testPlayer = new Player(testGame);
  }

  @Test
  public void getMysteryWord_itReturnsTheMysteryWord_MOVIE() {
    assertEquals("MOVIE", testGame.getMysteryWord());
  }

  @Test
  public void drawPicture_itShouldDrawAPost_String() {
    String expected = " - - - - -\n"+
       "|        |\n"+
       "|        \n" +
       "|       \n"+
       "|        \n" +
       "|       \n" +
       "|\n" +
       "|\n";

    assertEquals(expected, testGame.drawPicture(testPlayer));
  }

  @Test
  public void drawPicture_itShouldDrawAPostAndHead_String() {
    testPlayer.playGuess('Q');
    String expected = " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|       \n"+
         "|        \n" +
         "|       \n" +
         "|\n" +
        "|\n";

    assertEquals(expected, testGame.drawPicture(testPlayer));
  }

  @Test
  public void drawPicture_itShouldDrawPostHeadBody_String() {
    testPlayer.playGuess('Q');
    testPlayer.playGuess('U');
    String expected = " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|        | \n"+
         "|        |\n" +
         "|        \n" +
         "|\n" +
        "|\n";

    assertEquals(expected, testGame.drawPicture(testPlayer));
  }

  @Test
  public void drawPicture_itShouldDrawPostHeadBodyOneArm_String() {
    testPlayer.playGuess('Q');
    testPlayer.playGuess('U');
    testPlayer.playGuess('X');
    String expected = " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|      / |  \n"+
         "|        |\n" +
         "|        \n" +
         "|\n" +
        "|\n";

    assertEquals(expected, testGame.drawPicture(testPlayer));
  }

  @Test
  public void drawPicture_itShouldDrawPostHeadBodyBothArms_String() {
   testPlayer.playGuess('Q');
    testPlayer.playGuess('U');
    testPlayer.playGuess('X');
    testPlayer.playGuess('T');
    String expected = " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|      / | \\ \n"+
         "|        |\n" +
         "|        \n" +
         "|\n" +
        "|\n";

    assertEquals(expected, testGame.drawPicture(testPlayer));
  }

  @Test
  public void drawPicture_itShouldDrawPostHeadBodyBothArmsOneLeg_String() {
    testPlayer.playGuess('Q');
    testPlayer.playGuess('U');
    testPlayer.playGuess('X');
    testPlayer.playGuess('T');
    testPlayer.playGuess('F');
    String expected = " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|      / | \\ \n"+
         "|        |\n" +
         "|       / \n" +
         "|\n" +
        "|\n";

    assertEquals(expected, testGame.drawPicture(testPlayer));
  }

  @Test
  public void drawPicture_itShouldDrawFullPicture_String() {
    testPlayer.playGuess('Q');
    testPlayer.playGuess('U');
    testPlayer.playGuess('X');
    testPlayer.playGuess('T');
    testPlayer.playGuess('F');
    testPlayer.playGuess('L');
    String expected = " - - - - -\n"+
         "|        |\n"+
         "|        O\n" +
         "|      / | \\ \n"+
         "|        |\n" +
         "|       / \\ \n" +
         "|\n" +
        "|\n";

    assertEquals(expected, testGame.drawPicture(testPlayer));
  }

  @Test
  public void getFormalCurrentGuess_itShouldReturnCorrectNumberOfBlanksAndSpacesAtTheStart_String() {
    String expected = "Current Guess: _ _ _ _ _ ";
    assertEquals(expected, testGame.getFormalCurrentGuess());
  }

  @Test
  public void getFormalCurrentGuess_itShouldReturnCorrectNumberOfBlanksAndSpacesAfterGuess_String() {
    testPlayer.playGuess('M');
    String expected = "Current Guess: M _ _ _ _ ";
    assertEquals(expected, testGame.getFormalCurrentGuess());
  }

  @Test
  public void checkGuess_itShouldReturnTrueForCorrectInput_true() {
    assertTrue(testGame.checkGuess('M'));
    assertTrue(testGame.checkGuess('O'));
    assertTrue(testGame.checkGuess('V'));
    assertTrue(testGame.checkGuess('I'));
    assertTrue(testGame.checkGuess('E'));
  }

  @Test
  public void checkGuess_itShouldReturnFalsForIncorrectInput_false() {
    assertFalse(testGame.checkGuess('Q'));
    assertFalse(testGame.checkGuess('1'));
    assertFalse(testGame.checkGuess('+'));
    assertFalse(testGame.checkGuess(' '));
  }


}
