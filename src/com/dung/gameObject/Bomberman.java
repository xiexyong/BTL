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
    private FrameImage idHumanU1, idHumanD1, idHumanL1, idHumanR1;

    public Bomberman(float posX, float posY, GameWorld gameWorld) {
        super(posX,posY,30,30,gameWorld);
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
        /*g2.setColor(Color.red);
        g2.fillRect((int) (getPosX() - getWidth()/2),(int) (getPosY() - getHeight()/2), 15,15 );

        g2.setColor(Color.black);
        g2.fillRect((int)(getPosX()), (int) (getPosY()), 2, 2 );*/
        drawBoundForCollisionWithMap(g2);

        long x;

        if(getDirection() == RIGHT_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanR.Update(System.nanoTime());
            idHumanR.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
            //idHumanR1.draw(g2,(int) getPosX(), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2));

        }
        if(getDirection() == RIGHT_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            //idHumanR.Update(System.nanoTime());
            idHumanR.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }
        if(getDirection() == LEFT_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanL.Update(System.nanoTime());
            //idHumanR.setCurrentFrame(idHumanL.getCurrentFrame());
            idHumanL.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2),
                    g2);
        }
        if(getDirection() == LEFT_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            //idHumanR.Update(System.nanoTime());
            idHumanL.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }
        if(getDirection() == UP_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanU.Update(System.nanoTime());
            //idHumanR.setCurrentFrame(idHumanL.getCurrentFrame());
            idHumanU.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2),
                    g2);
        }
        if(getDirection() == UP_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            //idHumanR.Update(System.nanoTime());
            idHumanU.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2), g2);
        }
        if(getDirection() == DOWN_DIR && gameWorld.bomberman.getLAND_DIR()==0){
            idHumanD.Update(System.nanoTime());
            //idHumanR.setCurrentFrame(idHumanL.getCurrentFrame());
            idHumanD.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idHumanR.getCurrentImage().getHeight()/2),
                    g2);
        }
        if(getDirection() == DOWN_DIR && gameWorld.bomberman.getLAND_DIR()==1){
            //idHumanR.Update(System.nanoTime());
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
