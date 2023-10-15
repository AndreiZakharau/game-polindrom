package org.example.entity;

import java.util.Objects;

public class Player {

  private String username;
  private int points;

  public Player(String username, int points) {
    this.username = username;
    this.points = points;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return points == player.points && username.equals(player.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, points);
  }

  @Override
  public String toString() {
    return "Player{" +
        "username='" + username + '\'' +
        ", points=" + points +
        '}';
  }

  public void updatePoints(int points) {
    this.points += points;
  }
}
