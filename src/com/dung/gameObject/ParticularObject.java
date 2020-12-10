package com.dung.gameObject;

import com.dung.effect.Animation;

import java.awt.*;

public abstract  class ParticularObject extends GameObject  {
    public static final int LEAGUE_TEAM = 1;
    public static final int ENEMY_TEAM = 4;

    public static final int LEFT_DIR = -1;
    public static final int RIGHT_DIR = 1;
    public static final int UP_DIR = 2;
    public static final int DOWN_DIR = -2;




    private float width ;
    private float height ;
    private float speedX ;
    private float speedY ;

    private int direction;
    private int directionEnemy;

    public int getDirectionEnemy() {
        return directionEnemy;
    }

    public void setDirectionEnemy(int directionEnemy) {
        this.directionEnemy = directionEnemy;
    }

    public ParticularObject(float x, float y, float width, float height, GameWorld gameWorld){

        // posX and posY are the middle coordinate of the object
        super(x, y, gameWorld);
        setWidth(width);
        setHeight(height);

        direction = DOWN_DIR;
        directionEnemy = DOWN_DIR;


    }
    public static int getLeagueTeam() {
        return LEAGUE_TEAM;
    }

    public static int getEnemyTeam() {
        return ENEMY_TEAM;
    }

    public static int getLeftDir() {
        return LEFT_DIR;
    }

    public static int getRightDir() {
        return RIGHT_DIR;
    }


    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    public Rectangle getBoundForCollisionWithMap(){
        Rectangle bound = new Rectangle();
        bound.x = (int) (getPosX() - (getWidth()/2));
        bound.y = (int) (getPosY() - (getHeight()/2));
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }


    @Override
    public void Update() {

    }

    public void drawBoundForCollisionWithMap(Graphics2D g2){
        Rectangle rect = getBoundForCollisionWithMap();
        g2.setColor(Color.BLUE);
        g2.fillRect(rect.x, rect.y, rect.width, rect.height);
    }


    public abstract void draw(Graphics2D g2);

}
