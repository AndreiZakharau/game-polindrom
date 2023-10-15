package org.example.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.example.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeaderboardTest {

  private Leaderboard leaderboard;

  @BeforeEach
  void setUp() {
    leaderboard = new Leaderboard();
  }

  @Test
  public void testUpdatePointsForNewPlayer() {

    leaderboard.updatePoints("Player1", 10);

    List<Player> topPlayers = leaderboard.getTopPlayers(3);
    assertEquals(1, topPlayers.size());
    assertEquals("Player1", topPlayers.get(0).getUsername());
    assertEquals(10, topPlayers.get(0).getPoints());
  }

  @Test
  public void testUpdatePointsForExistingPlayer() {

    leaderboard.updatePoints("Player1", 10);
    leaderboard.updatePoints("Player1", 5);

    List<Player> topPlayers = leaderboard.getTopPlayers(3);
    assertEquals(1, topPlayers.size());
    assertEquals("Player1", topPlayers.get(0).getUsername());
    assertEquals(15, topPlayers.get(0).getPoints());
  }

  @Test
  public void testGetTopPlayers() {

    leaderboard.updatePoints("Player1", 10);
    leaderboard.updatePoints("Player2", 5);
    leaderboard.updatePoints("Player3", 15);

    List<Player> topPlayers = leaderboard.getTopPlayers(2);
    assertEquals(2, topPlayers.size());
    assertEquals("Player3", topPlayers.get(0).getUsername());
    assertEquals(15, topPlayers.get(0).getPoints());
    assertEquals("Player1", topPlayers.get(1).getUsername());
    assertEquals(10, topPlayers.get(1).getPoints());
  }
}