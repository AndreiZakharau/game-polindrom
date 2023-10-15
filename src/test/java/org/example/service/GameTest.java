package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.example.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

  private Game game;

  @BeforeEach
  public void setUp() {
    game = new Game();
  }

  @Test
  public void testPlay() {
    game.play("madam", "Alice");
    List<Player> topPlayers = game.displayLeaderboard(1);
    assertEquals(1, topPlayers.size());
    assertEquals("Alice", topPlayers.get(0).getUsername());
    assertEquals(5, topPlayers.get(0).getPoints());
  }

  @Test
  public void testPlayWithExistingPhrase() {
    game.play("madam", "Alice");
    game.play("madam", "Bob");
    List<Player> topPlayers = game.displayLeaderboard(1);
    assertEquals(1, topPlayers.size());
    assertEquals("Alice", topPlayers.get(0).getUsername());
    assertEquals(5, topPlayers.get(0).getPoints());
  }

  @Test
  public void testPlayWithNotPalindromePhrase() {
    game.play("hello", "Alice");
    List<Player> topPlayers = game.displayLeaderboard(1);
    assertEquals(0, topPlayers.size());
  }

  @Test
  public void testDisplayLeaderboard() {
    game.play("madam", "Alice");
    game.play("racecar", "Bob");
    game.play("level", "Charlie");
    List<Player> topPlayers = game.displayLeaderboard(2);
    assertEquals(2, topPlayers.size());
    assertEquals("Alice", topPlayers.get(0).getUsername());
    assertEquals("Bob", topPlayers.get(1).getUsername());
  }

}