import java.util.Random;

class Dictionary {

  Random randomGenerator = new Random();
  String[][] words ={
    {"cow", "chicken", "pizza", "bread", "stones","sticks", "leaves", "letters", "alphabet", "soup", "hungry", "tired", "sleepy", "noisy", "caring", "friends", "month", "day", "light"},
    {"lyrics", "songs", "ballads", "shapes", "triangle", "circle", "medicine", "six", "seven", "flower", "rose", "petal"
},
    { " specification", " structure", " lexical", " likewise", " management", " manipulate", " mathematics", " hotjava", " vertex", " unsigned", " traditional"
    }};

  public String getRandomWord(int difficultyLevel) {
    int length = words[difficultyLevel].length;
    return words[difficultyLevel][randomGenerator.nextInt(length)];
  }
}
