/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.gameObjcects;

/**
 *
 * @author d.peters
 */
public class Ball extends MovableObject {
    
    public Ball(int xPos, int yPos) {
        this.UP = true;
        this.RIGHT = false;
        this.x = xPos;
        this.y = yPos;
        this.speed = 5;
        this.width = 8;
        this.height = 8;
        this.speed = 5;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return width;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.width = size;
        this.height = size;
    }

    /**
     *
     * @param panelWidth
     */
    public void moveHor(int panelWidth) {
        if (this.RIGHT) {
            moveRight();
            if (this.x >= (panelWidth - this.getSize())) {
                this.RIGHT = false;
            }
        } else {
            moveLeft();
            if (this.x <= 0) {
                this.RIGHT = true;
            }
        }
    }

    /**
     *
     * @param panelHeight
     */
    public void moveVert(int panelHeight) {
        if (this.UP) {
            moveUp();
            if (this.y <= 0) {
                this.UP = false;
            }
        } else {
            moveDown();
            if (this.y >= (panelHeight - this.getSize())) {
                this.UP = true;
            }
        }
    }

    public void changeVertDir() {
        if (this.RIGHT == true) {
            this.RIGHT = false;
        } else {
            this.RIGHT = true;
        }
    }
    
    public boolean collision(Player pl1, Player pl2){
        boolean coll = false;
        if (pl1.getBounds().intersects(this.getBounds()) ||
                pl2.getBounds().intersects(this.getBounds())){
            coll = true;
        }
        return coll;
    }
}
