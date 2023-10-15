package org.example.service;

import java.util.ArrayList;
import java.util.List;
import org.example.entity.Player;

public class Game {

  private final Leaderboard leaderboard;
  private final List<String> playerPhrases;

  public Game() {
    leaderboard = new Leaderboard();
    playerPhrases = new ArrayList<>();
  }

  public void play(String phrase, int numberOfPlayers, String playerName) {
    if (!playerPhrases.contains(phrase)) {
      playerPhrases.add(phrase);
      if (isPalindrome(phrase)) {
        int points = calculatePoints(phrase);
        leaderboard.updatePoints(playerName, points);
      }
      displayLeaderboard(numberOfPlayers);
    }
  }

  private boolean isPalindrome(String phrase) {

    if (!phrase.isEmpty()) {
      phrase = phrase.replaceAll(" ", "");
      StringBuilder reversLine = new StringBuilder(phrase);
      if (phrase.equalsIgnoreCase(reversLine.reverse().toString())) {
        return true;
      }
    }
    return false;
  }

  private int calculatePoints(String phrase) {

    return phrase.length();
  }

  private List<Player> displayLeaderboard(int numberOfPlayers) {

    return leaderboard.getTopPlayers(numberOfPlayers);
  }
}
