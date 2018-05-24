package com.brianmarete;

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
        testPlayer.playGuess('M');
        assertEquals(1, testPlayer.getCurrentTry());
    }

    @Test
    public void hasPreviouslyGuessed_itShouldIncludeCharactersPreviouslyGuessed_true() {
        testPlayer.playGuess('Q');
        testPlayer.playGuess('M');
        assertTrue(testPlayer.hasPreviouslyGuessed('Q'));
        assertTrue(testPlayer.hasPreviouslyGuessed('M'));
    }

    @Test
    public void didWeLose_itShouldReturnTrueIfPlayerGuessesIncorrectlySixTimes_true() {
       // First guess is correct but the rest are incorrect
        testPlayer.playGuess('M');
        testPlayer.playGuess('Q');
        testPlayer.playGuess('U');
        testPlayer.playGuess('B');
        testPlayer.playGuess('T');
        testPlayer.playGuess('Z');
        testPlayer.playGuess('P');
        assertTrue(testPlayer.didWeLose());
    }

    @Test
    public void didWeWin_itShouldReturnTrueIfPlayerGuessesAllCorrectLetters_true() {
        testPlayer.playGuess('M');
        testPlayer.playGuess('O');
        testPlayer.playGuess('V');
        testPlayer.playGuess('I');
        testPlayer.playGuess('E');
        assertTrue(testPlayer.didWeWin(testGame));
    }
}


