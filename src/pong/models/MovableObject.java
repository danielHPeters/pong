package pong.models;

import pong.interfaces.IVector2I;
import pong.interfaces.Moveable;

/**
 * Abstract class which defines movable game objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
abstract class MovableObject extends GameObject implements Moveable {
  protected int speed;
  protected int maxSpeed;
  protected IVector2I startLocation;
  protected IVector2I velocity;
  protected IVector2I acceleration;
  protected boolean up;
  protected boolean down;
  protected boolean left;
  protected boolean right;

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setUp(boolean up) {
    this.up = up;
  }

  public void setDown(boolean down) {
    this.down = down;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }

  public void setRight(boolean right) {
    this.right = right;
  }

  @Override
  public void moveUp() {
    location.setY(location.getY() - speed);
  }

  @Override
  public void moveDown() {
    location.setY(location.getY() + speed);
  }

  @Override
  public void moveLeft() {
    location.setX(location.getX() - speed);
  }

  @Override
  public void moveRight() {
    location.setX(location.getX() + speed);
  }

  /**
   * Resets the object to its original coordinates.
   */
  @Override
  public void resetPosition() {
    location.set(startLocation);
    velocity = new Vector2I(1, 1);
  }

  public IVector2I getVelocity() {
    return velocity;
  }

  public IVector2I getAcceleration() {
    return acceleration;
  }
}
