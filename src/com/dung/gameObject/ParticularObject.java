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

    public static int getUpDir() {
        return UP_DIR;
    }

    public static int getDownDir() {
        return DOWN_DIR;
    }

    private int LAND_DIR = 0;

    public int getLAND_DIR() {
        return LAND_DIR;
    }

    public void setLAND_DIR(int LAND_DIR) {
        this.LAND_DIR = LAND_DIR;
    }

    public static final int ALIVE = 1;
    public static final int DEATH = 0;

    private int state = ALIVE;

    private float width ;
    private float height ;
    private float speedX = 1;
    private float speedY = 1;

    private int direction;

    private int teamType;


    public ParticularObject(float x, float y, float width, float height, GameWorld gameWorld){

        // posX and posY are the middle coordinate of the object
        super(x, y, gameWorld);
        setWidth(width);
        setHeight(height);

        direction = RIGHT_DIR;

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

    public static int getALIVE() {
        return ALIVE;
    }

    public static int getDEATH() {
        return DEATH;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public int getTeamType() {
        return teamType;
    }

    public void setTeamType(int teamType) {
        this.teamType = teamType;
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
