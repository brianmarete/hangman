import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {

    Game testGame;
    Player testPlayer;

    @Before
    public void setUp() {
        testGame = new Game("MOVIE");
        testPlayer = new Player(testGame);
    }

    @Test
    public void getCurrentTry_itInstantiatesCorrectly_0() {
        assertEquals(0, testPlayer.getCurrentTry());
    }

    @Test
    public void playGuess_itReturnsTrueIfPlayerGuessesCorrectly_true() {
        assertTrue(testPlayer.playGuess('M'));
    }

    @Test
    public void getCurrentTry_itIncrementsAfterPlayerGuessesWrongCharacter_1() {
        testPlayer.playGuess('Q');
        assertEquals(1, testPlayer.getCurrentTry());
    }
    
    @Test
    public void hasPreviouslyGuessed_itShouldIncludeCharactersPreviouslyGuessed_true() {
        testPlayer.playGuess('Q');
        assertTrue(testPlayer.hasPreviouslyGuessed('Q'));
    }
   

      
}


