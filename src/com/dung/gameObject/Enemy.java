package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.awt.*;
import java.util.Random;


public class Enemy extends Human {
    Rectangle oEnemy = new Rectangle((int)getPosX(),(int)getPosY(),40,40);
    public int Death = 0;
    Rectangle enemi = new Rectangle();

    private float speedX  ;
    private float speedY ;


    GameWorld gameWorld;

    private Animation idEnemyU, idEnemyD, idEnemyL, idEnemyR;




    public Enemy(float posX, float posY, GameWorld gameWorld) {
        super(posX, posY, 40,40, gameWorld);
        setPosX(posX);
        setPosY(posY);
        this.gameWorld = gameWorld;

        idEnemyD = CacheDataLoader.getInstance().getAnimation("idEnemyD");
        idEnemyU = CacheDataLoader.getInstance().getAnimation("idEnemyU");
        idEnemyL = CacheDataLoader.getInstance().getAnimation("idEnemyL");
        idEnemyR = CacheDataLoader.getInstance().getAnimation("idEnemyR");


    }

    public void update(){ super.Update();

    }
    int dem = 0;

    public void draw(Graphics2D g2) {

        Random random = new Random();
        int numberDir;





        if(getDirectionEnemy() == RIGHT_DIR ){
            setPosX(getPosX()+1);
            idEnemyR.Update(System.nanoTime());
            idEnemyR.draw((int) (getPosX()), (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idEnemyR.getCurrentImage().getHeight()/2), g2);
        }

        if(getDirectionEnemy() == LEFT_DIR ){
            setPosX(getPosX()-1);
            idEnemyL.Update(System.nanoTime());
            idEnemyL.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idEnemyL.getCurrentImage().getHeight()/2),
                    g2);
        }

        if(getDirectionEnemy() == UP_DIR){
            setPosY(getPosY()-1);
            idEnemyU.Update(System.nanoTime());
            idEnemyU.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idEnemyU.getCurrentImage().getHeight()/2),
                    g2);
        }

        if(getDirectionEnemy() == DOWN_DIR){
             setPosY(getPosY()+1);
            idEnemyD.Update(System.nanoTime());
            idEnemyD.draw((int) (getPosX()),
                    (int) getPosY()  + (getBoundForCollisionWithMap().height/2 - idEnemyD.getCurrentImage().getHeight()/2),
                    g2);

        }




        if(getDirectionEnemy() == LEFT_DIR &&
                getGameWorld().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap())!=null){

            Rectangle rectLeftWall = getGameWorld().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap());
            setPosX(rectLeftWall.x + rectLeftWall.width + getWidth()/2);
            {
                numberDir = random.nextInt(4)+1;
                if(numberDir==1) setDirectionEnemy(UP_DIR);
                if(numberDir==2) setDirectionEnemy(DOWN_DIR);
                if(numberDir==3) setDirectionEnemy(LEFT_DIR);
                if(numberDir==4) setDirectionEnemy(RIGHT_DIR);
            }
        }
        if(getDirectionEnemy() == RIGHT_DIR &&
                getGameWorld().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap())!=null){

            Rectangle rectRightWall = getGameWorld().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap());
            setPosX(rectRightWall.x - getWidth()/2);
            {
                numberDir = random.nextInt(4)+1;
                if(numberDir==1) setDirectionEnemy(UP_DIR);
                if(numberDir==2) setDirectionEnemy(DOWN_DIR);
                if(numberDir==3) setDirectionEnemy(LEFT_DIR);
                if(numberDir==4) setDirectionEnemy(RIGHT_DIR);
            }
        }



        if(getDirectionEnemy() == UP_DIR &&
                getGameWorld().physicalMap.haveCollisionWithTop(getBoundForCollisionWithMap())!=null){

            Rectangle rectUpWall = getGameWorld().physicalMap.haveCollisionWithTop(getBoundForCollisionWithMap());
            setPosY(rectUpWall.y + rectUpWall.height + getHeight()/2);
            {
                numberDir = random.nextInt(4)+1;
                if(numberDir==1) setDirectionEnemy(UP_DIR);
                if(numberDir==2) setDirectionEnemy(DOWN_DIR);
                if(numberDir==3) setDirectionEnemy(LEFT_DIR);
                if(numberDir==4) setDirectionEnemy(RIGHT_DIR);
            }
        }

        if(getDirectionEnemy() == DOWN_DIR &&
                getGameWorld().physicalMap.haveCollisionWithLand(getBoundForCollisionWithMap())!=null ){

            Rectangle rectDownWall = getGameWorld().physicalMap.haveCollisionWithLand(getBoundForCollisionWithMap());
            setPosY(rectDownWall.y - getHeight()/2);
            {
                numberDir = random.nextInt(4)+1;
                if(numberDir==1) setDirectionEnemy(UP_DIR);
                if(numberDir==2) setDirectionEnemy(DOWN_DIR);
                if(numberDir==3) setDirectionEnemy(LEFT_DIR);
                if(numberDir==4) setDirectionEnemy(RIGHT_DIR);
            }

        }

        oEnemy.x =(int) getPosX();
        oEnemy.y =(int) getPosY();



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
