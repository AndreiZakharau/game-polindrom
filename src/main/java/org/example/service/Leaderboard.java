package org.example.service;

import java.util.ArrayList;
import java.util.List;
import org.example.entity.Player;

public class Leaderboard {

  private final List<Player> players;

  public Leaderboard() {
    players = new ArrayList<>();
  }

  public void updatePoints(String playerName, int points) {
    Player player = getPlayer(playerName);
    if (player != null) {
      player.updatePoints(points);
    } else {
      players.add(new Player(playerName, points));
    }
    sortPlayers();
  }

  public List<Player> getTopPlayers(int numberOfPlayers) {
    int size = Math.min(players.size(), numberOfPlayers);
    return players.subList(0, size);
  }

  private Player getPlayer(String playerName) {
    for (Player player : players) {
      if (player.getUsername().equals(playerName)) {
        return player;
      }
    }
    return null;
  }

  private void sortPlayers() {
    players.sort((u1, u2) -> Integer.compare(u2.getPoints(), u1.getPoints()));
  }
}
