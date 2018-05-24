package com.brianmarete;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

class Dictionary {

  private Random randomGenerator = new Random();
  private List<String> wordList = new ArrayList<>();
  private URI dictionaryPath;

  public Dictionary() {
    try {
      initializeWordList();
    } catch(IOException|URISyntaxException e) {
      System.out.println("Couldn't open dictionary file");
    }
  }

  public String getRandomWord() {
    int index = randomGenerator.nextInt(wordList.size());
    return wordList.get(index);
  }

  public void initializeWordList() throws IOException, URISyntaxException {
    dictionaryPath = this.getClass().getClassLoader().getResource("dictionary.txt").toURI();

    try (Stream<String> stream = Files.lines(Paths.get(dictionaryPath))) {
      wordList = stream.map(String::toUpperCase).collect(Collectors.toList());
    }
  }
}
