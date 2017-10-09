package pong;

import java.util.ArrayList;
import java.util.List;

import pong.configuration.Settings;
import pong.models.Ball;
import pong.models.GameArea;
import pong.models.Player;

/**
 * Game state holding game objects information.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class GameState {
  private boolean playing;
  private boolean paused;
  private final GameArea area;
  private final Ball ball;
  private final Settings config;
  private final List<Player> players;

  /**
   * Creates a new initial game state.
   *
   * @param config default app settings
   */
  public GameState(Settings config) {
    this.config = config;
    this.area = new GameArea(config.getWidth() - 10, config.getHeight() - 80);
    Player pl1 = new Player(2 * 5, area.getHeight() / 2, config.getPlayerSpeed(), area);
    Player pl2 = new Player(
        config.getWidth() - 4 * 5, area.getHeight() / 2, config.getPlayerSpeed(), area);
    this.players = new ArrayList<>();
    this.players.add(pl1);
    this.players.add(pl2);
    this.ball = new Ball(config.getWidth() / 2, config.getHeight() / 2, config.getBallSpeed());
    this.playing = true;
    this.paused = false;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public GameArea getArea() {
    return area;
  }

  public Ball getBall() {
    return ball;
  }

  public boolean isPlaying() {
    return playing;
  }

  public void setPlaying(boolean playing) {
    this.playing = playing;
  }

  public void pauseToggle() {
    paused = !paused;
  }

  public boolean isPaused() {
    return paused;
  }

  public Settings getConfig() {
    return config;
  }

  public void resetGameObjects() {
    ball.resetPosition();
    players.forEach(player -> player.resetPosition());
  }

  private void resetScores() {
    players.forEach(player -> player.resetScore());
  }

  /**
   * Restart game.
   */
  public void restart() {
    resetGameObjects();
    resetScores();
    setPlaying(true);
  }
}
