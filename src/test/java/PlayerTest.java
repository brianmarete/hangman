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
  public void Player_itInstantiatesCorrectly_true() {
    assertEquals(0, testPlayer.getCurrentTry());
  }
}


