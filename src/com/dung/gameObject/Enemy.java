package com.dung.gameObject;

import java.awt.*;

public class Enemy extends Human {

    private float speedX;
    private float speedY;

    GameWorld gameWorld;



    public Enemy(float posX, float posY, GameWorld gameWorld) {
        super(posX, posY, 35,40, gameWorld);
        setPosX(posX);
        setPosY(posY);
        this.gameWorld = gameWorld;

    }

    public void update(){
        super.Update();
    }

    public void draw(Graphics2D g2) {

    }
}
