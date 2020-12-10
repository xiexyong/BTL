package com.dung.gameObject;

import java.awt.*;

public abstract class Human extends ParticularObject{

    public int itemSpeed = 0;

    public Human(float posX, float posY, float width, float height, GameWorld gameWorld) {
        super(posX, posY, width, height, gameWorld);
    }

    @Override
    public void Update(){
        super.Update();
        if(itemSpeed==1){
            setPosX(getPosX() + getSpeedX()*2);
            setPosY(getPosY() + getSpeedY()*2);
        }
        else {
                setPosX(getPosX() + getSpeedX());
                setPosY(getPosY() + getSpeedY());
        }
                if(getDirection() == LEFT_DIR &&
                        getGameWorld().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap())!=null){

                    Rectangle rectLeftWall = getGameWorld().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap());
                    setPosX(rectLeftWall.x + rectLeftWall.width + getWidth()/2);

                }
                if(getDirection() == RIGHT_DIR &&
                        getGameWorld().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap())!=null){

                    Rectangle rectRightWall = getGameWorld().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap());
                    setPosX(rectRightWall.x - getWidth()/2);

                }



            if(getDirection() == UP_DIR &&
                    getGameWorld().physicalMap.haveCollisionWithTop(getBoundForCollisionWithMap())!=null){

                Rectangle rectUpWall = getGameWorld().physicalMap.haveCollisionWithTop(getBoundForCollisionWithMap());
                setPosY(rectUpWall.y + rectUpWall.height + getHeight()/2);

            }
            if(getDirection() == DOWN_DIR &&
                    getGameWorld().physicalMap.haveCollisionWithLand(getBoundForCollisionWithMap())!=null){

                Rectangle rectDownWall = getGameWorld().physicalMap.haveCollisionWithLand(getBoundForCollisionWithMap());
                setPosY(rectDownWall.y - getHeight()/2);

            }






    }

}