package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWorld {

    public Bomberman bomberman;
    public PhysicalMap physicalMap ;
    public BackgroundMap backgroundMap;
    public Bomb bomb1;



    private int numberBomb = 1;


    public int getNumberBomb() {
        return numberBomb;
    }

    public void setNumberBomb(int numberBomb) {
        this.numberBomb = numberBomb;
    }

    public void Update(){
        bomberman.update();
        bomb1.Update();
    }


    public GameWorld(){
        bomberman = new Bomberman(60,60,this);
        physicalMap = new PhysicalMap(0,0,this);
        backgroundMap = new BackgroundMap(0,0 ,this);
        bomb1 = new Bomb(0,0,this);




    }



    public void Render(Graphics2D g2){
        backgroundMap.draw(g2);
        bomb1.draw(g2);
        bomberman.draw(g2);
    }



}
