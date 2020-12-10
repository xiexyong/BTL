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
    public Enemy enemy,enemy1,enemy2,enemy3,enemy4;


    BufferedImage tileWin,tileNotWin;

    public void Update(){
        bomberman.update();
        bomb1.Update();
    }


    public GameWorld(){
        bomberman = new Bomberman(60,60,this);

        physicalMap = new PhysicalMap(0,0,this);
        backgroundMap = new BackgroundMap(0,0 ,this);
        bomb1 = new Bomb(0,0,this);
        enemy = new Enemy(60,180,this);
        enemy1 = new Enemy(300,100,this);
        enemy2 = new Enemy(300,460,this);
        enemy3 = new Enemy(600,460,this);
        enemy4 = new Enemy(540,100,this);

        try {
            tileWin = ImageIO.read(new File("data/tilewin.png"));
            tileNotWin = ImageIO.read(new File("data/tilenotwin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void Render(Graphics2D g2){
        backgroundMap.draw(g2);


        if(enemy.getPosX()<0&&enemy.getPosY()<0&& enemy1.getPosX()<0&&enemy1.getPosY()<0&&enemy2.getPosX()<0&&enemy2.getPosY()<0&&enemy3.getPosX()<0&&enemy3.getPosY()<0&&enemy4.getPosX()<0&&enemy4.getPosY()<0)
        {
            g2.drawImage(tileWin,880,350,null);
        }
        if(bomberman.somangsong<1)
        {
            g2.drawImage(tileNotWin,880,350,null);
        }



        bomb1.draw(g2);
        enemy.draw(g2);
        enemy1.draw(g2);
        enemy2.draw(g2);
        enemy3.draw(g2);
        enemy4.draw(g2);
        bomberman.draw(g2);

    }



}
