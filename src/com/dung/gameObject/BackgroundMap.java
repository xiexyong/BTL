package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;
import com.dung.userinterface.GameFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class BackgroundMap extends GameObject {

    public int[][] backMap;
    public int[][] backupMap;
    private int tileSize;

    private GameWorld gameWorld;

    BufferedImage imagetile, imagemang0,imagemang1,imagemang2,imagemang3;
    BufferedImage image, subImage1, subImage0, imageDirt,subImage2 , subImageDirt , subImage5,subImage6, subImage7 ;

    public BackgroundMap(float x, float y, GameWorld gameWorld) {
        super(x, y, gameWorld);
        backMap = CacheDataLoader.getInstance().getBackgroundMap();
        backupMap = backMap;
        tileSize = 40;
        this.gameWorld = gameWorld;
        try {
            image = ImageIO.read(new File("data/Wall1.png"));
            imageDirt = ImageIO.read(new File("data/Dirt.png"));
            imagetile = ImageIO.read(new File("data/tile.png"));

            imagemang0 = ImageIO.read(new File("data/mang0.png"));
            imagemang1 = ImageIO.read(new File("data/mang1.png"));
            imagemang2 = ImageIO.read(new File("data/mang2.png"));
            imagemang3 = ImageIO.read(new File("data/mang3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        subImage1 = image.getSubimage(120,120,40,40);
        subImage0 = image.getSubimage(120,0,40,40);
        subImage2 = image.getSubimage(80,120,40,40);
        subImage5 = imageDirt.getSubimage(0,480,40,40);
        subImage6 = imageDirt.getSubimage(40,440,40,40);
        subImage7 = imageDirt.getSubimage(120,440,40,40);
        subImageDirt = imageDirt.getSubimage(40,40,40,40);
    }




    @Override
    public void Update() {
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        for(int i = 0;i< backMap.length;i++)
            for(int j = 0;j<backMap[0].length;j++) {
                if(backMap[i][j]==1) g2.drawImage(subImage1, (int) getPosX() + j * tileSize,
                        (int) getPosY() + i * tileSize, null);
                if(backMap[i][j]==0) g2.drawImage(subImageDirt, (int) getPosX() + j * tileSize,
                        (int) getPosY() + i * tileSize, null);
                if(backMap[i][j]==2) g2.drawImage(subImage0, (int) getPosX() + j * tileSize,
                        (int) getPosY() + i * tileSize, null);
                if(backMap[i][j]==3) g2.drawImage(subImage2, (int) getPosX() + j * tileSize,
                        (int) getPosY() + i * tileSize, null);

                if(backMap[i][j]==5) {
                    g2.drawImage(subImageDirt, (int) getPosX() + j * tileSize,
                            (int) getPosY() + i * tileSize, null);
                    g2.drawImage(subImage5, (int) getPosX() + j * tileSize,
                            (int) getPosY() + i * tileSize, null);
                }
                if(backMap[i][j]==6) {
                    g2.drawImage(subImageDirt, (int) getPosX() + j * tileSize,
                            (int) getPosY() + i * tileSize, null);
                    g2.drawImage(subImage6, (int) getPosX() + j * tileSize,
                            (int) getPosY() + i * tileSize, null);
                }
                if(backMap[i][j]==7) {
                    g2.drawImage(subImageDirt, (int) getPosX() + j * tileSize,
                            (int) getPosY() + i * tileSize, null);
                    g2.drawImage(subImage7, (int) getPosX() + j * tileSize,
                            (int) getPosY() + i * tileSize, null);
                }


            }
        g2.drawImage(imagetile,885,0,220,550,null);
            if(gameWorld.bomberman.somangsong==3){
                g2.drawImage(imagemang3,880+150,300,null);
            }
        if(gameWorld.bomberman.somangsong==2){
            g2.drawImage(imagemang2,880+150,300,null);
        }
        if(gameWorld.bomberman.somangsong==1){
            g2.drawImage(imagemang1,880+150,300,null);
        }
        if(gameWorld.bomberman.somangsong==0){
            g2.drawImage(imagemang0,880+150,300,null);
        }

        //ex.draw(30,30,g2);
    }

}
