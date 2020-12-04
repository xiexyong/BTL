package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;
import com.dung.effect.FrameImage;

import java.awt.*;
import java.io.IOException;
import java.nio.CharBuffer;

public class Bomberman extends Human {

    private float speedX;
    private float speedY;

    GameWorld gameWorld;

    private Animation idHumanU, idHumanD, idHumanL, idHumanR;

    private int makeBomb = 0;

    public int somangsong = 3;

    public int Death = 0;

    @Override
    public String toString() {
        return "" + somangsong ;
    }


    public int getMakeBomb() {
        return makeBomb;
    }

    public void setMakeBomb(int makeBomb) {
        this.makeBomb = makeBomb;
    }

    public Bomberman(float posX, float posY, GameWorld gameWorld) {
        super(posX,posY,20,30,gameWorld);
        setPosX(posX);
        setPosY(posY);
        this.gameWorld = gameWorld;

        idHumanD = CacheDataLoader.getInstance().getAnimation("idHumanD");
        idHumanU = CacheDataLoader.getInstance().getAnimation("idHumanU");
        idHumanL = CacheDataLoader.getInstance().getAnimation("idHumanL");
        idHumanR = CacheDataLoader.getInstance().getAnimation("idHumanR");


    }

    public void update(){
        super.Update();
    }

    public void draw(Graphics2D g2){

        if(getDirection() == RIGHT_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanR.Update(System.nanoTime());
            idHumanR.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }
        if(getDirection() == RIGHT_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            idHumanR.Update(0);
            idHumanR.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }
        if(getDirection() == LEFT_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanL.Update(System.nanoTime());
            idHumanL.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2),
                    g2);
        }
        if(getDirection() == LEFT_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            idHumanL.Update(0);
            idHumanL.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }
        if(getDirection() == UP_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanU.Update(System.nanoTime());
            idHumanU.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2),
                    g2);
        }
        if(getDirection() == UP_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            idHumanU.Update(0);
            idHumanU.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }
        if(getDirection() == DOWN_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanD.Update(System.nanoTime());
            idHumanD.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2),
                    g2);
        }
        if(getDirection() == DOWN_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            idHumanD.Update(0);
            idHumanD.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }

    }


    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }




}
