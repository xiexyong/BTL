package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;
import com.dung.sound.GameSound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Bomb extends ParticularObject {

    GameWorld gameWorld;

    BufferedImage image;

    private Animation explosion,explosion1,explosion2;

    private int demDraw = 0,demDraw1 = 0,demDraw2 = 0;
    private int demAnimation = 0,demAnimation1 = 0,demAnimation2 = 0;

    public int numberBomb = 1;
    private int b1Activate = 0, b2Activate = 0;

    Rectangle obom = new Rectangle();
    Rectangle obom1 = new Rectangle();
    Rectangle obom2 = new Rectangle();


    private long timeBomb,timeBomb1,timeBomb2;


    public Bomb(float x, float y, GameWorld gameWorld) {
        super(x, y, 40, 40, gameWorld);

        this.gameWorld = gameWorld;

        explosion = CacheDataLoader.getInstance().getAnimation("idBoom");
        explosion1 = CacheDataLoader.getInstance().getAnimation("idBoom");
        explosion2 = CacheDataLoader.getInstance().getAnimation("idBoom");

        try {
            image = ImageIO.read(new File("data/bomb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    int dem = 0;

    public void draw(Graphics2D g2) {


        if (numberBomb == 1) {
        if (demDraw == 1 && demAnimation == 0) {
            g2.drawImage(image, obom.x - 20, obom.y - 20, null);
        }

        if (demAnimation == 1 && demDraw == 0) {
            explosion.Update(System.nanoTime());

            for(int i = 0; i < gameWorld.physicalMap.phys_map[0].length ; i++){
                for(int j = 0; j < gameWorld.physicalMap.phys_map.length ; j++){
                    if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom.x/40 && j==obom.y/40 ){
                        gameWorld.physicalMap.phys_map[j][i] = 0;
                        explosion.draw(obom.x, obom.y, g2);
                        if(i==(int)gameWorld.bomberman.getPosX()/40&&j==(int)gameWorld.bomberman.getPosY()/40)
                        {
                            gameWorld.bomberman.Death=1;
                            gameWorld.bomberman.timeDie = System.currentTimeMillis();
                            gameWorld.bomberman.setPosX(-30);
                            gameWorld.bomberman.setPosY(-30);
                        }
                        if(i==(int)gameWorld.enemy.getPosX()/40&&j==(int)gameWorld.enemy.getPosY()/40)
                        {
                            gameWorld.enemy.Death=1;
                            gameWorld.enemy.setPosX(-300);
                            gameWorld.enemy.setPosY(-300);
                        }
                        if(i==(int)gameWorld.enemy1.getPosX()/40&&j==(int)gameWorld.enemy1.getPosY()/40)
                        {
                            gameWorld.enemy1.Death=1;
                            gameWorld.enemy1.setPosX(-300);
                            gameWorld.enemy1.setPosY(-300);
                        }
                        if(i==(int)gameWorld.enemy2.getPosX()/40&&j==(int)gameWorld.enemy2.getPosY()/40)
                        {
                            gameWorld.enemy2.Death=1;
                            gameWorld.enemy2.setPosX(-300);
                            gameWorld.enemy2.setPosY(-300);
                        }
                        if(i==(int)gameWorld.enemy3.getPosX()/40&&j==(int)gameWorld.enemy3.getPosY()/40)
                        {
                            gameWorld.enemy3.Death=1;
                            gameWorld.enemy3.setPosX(-300);
                            gameWorld.enemy3.setPosY(-300);
                        }
                        if(i==(int)gameWorld.enemy4.getPosX()/40&&j==(int)gameWorld.enemy4.getPosY()/40)
                        {
                            gameWorld.enemy4.Death=1;
                            gameWorld.enemy4.setPosX(-300);
                            gameWorld.enemy4.setPosY(-300);
                        }

                    }

                    if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==(obom.x-40)/40 && j==obom.y/40 ){
                        gameWorld.physicalMap.phys_map[j][i] = 0;
                        explosion.draw(obom.x -40, obom.y, g2);

                        if((obom.x-40)/40==(int)gameWorld.bomberman.getPosX()/40&&obom.y/40==(int)gameWorld.bomberman.getPosY()/40)
                        {
                            gameWorld.bomberman.Death=1;
                            gameWorld.bomberman.timeDie = System.currentTimeMillis();
                            gameWorld.bomberman.setPosX(-30);
                            gameWorld.bomberman.setPosY(-30);
                        }
                        if((obom.x-40)/40==(int)gameWorld.enemy.getPosX()/40&&obom.y/40==(int)gameWorld.enemy.getPosY()/40)
                        {
                            gameWorld.enemy.Death=1;
                            gameWorld.enemy.setPosX(-300);
                            gameWorld.enemy.setPosY(-300);
                        }
                        if((obom.x-40)/40==(int)gameWorld.enemy1.getPosX()/40&&obom.y/40==(int)gameWorld.enemy1.getPosY()/40)
                        {
                            gameWorld.enemy1.Death=1;
                            gameWorld.enemy1.setPosX(-300);
                            gameWorld.enemy1.setPosY(-300);
                        }
                        if((obom.x-40)/40==(int)gameWorld.enemy2.getPosX()/40&&obom.y/40==(int)gameWorld.enemy2.getPosY()/40)
                        {
                            gameWorld.enemy2.Death=1;
                            gameWorld.enemy2.setPosX(-300);
                            gameWorld.enemy2.setPosY(-300);
                        }
                        if((obom.x-40)/40==(int)gameWorld.enemy3.getPosX()/40&&obom.y/40==(int)gameWorld.enemy3.getPosY()/40)
                        {
                            gameWorld.enemy3.Death=1;
                            gameWorld.enemy3.setPosX(-300);
                            gameWorld.enemy3.setPosY(-300);
                        }
                        if((obom.x-40)/40==(int)gameWorld.enemy4.getPosX()/40&&obom.y/40==(int)gameWorld.enemy4.getPosY()/40)
                        {
                            gameWorld.enemy4.Death=1;
                            gameWorld.enemy4.setPosX(-300);
                            gameWorld.enemy4.setPosY(-300);
                        }
                    }

                    if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom.x/40 +1 && j==obom.y/40 ){
                        gameWorld.physicalMap.phys_map[j][i] = 0;
                        explosion.draw(obom.x +40, obom.y, g2);
                        if((obom.x+40)/40==(int)gameWorld.bomberman.getPosX()/40&&obom.y/40==(int)gameWorld.bomberman.getPosY()/40)
                        {
                            gameWorld.bomberman.Death=1;
                            gameWorld.bomberman.timeDie = System.currentTimeMillis();
                            gameWorld.bomberman.setPosX(-30);
                            gameWorld.bomberman.setPosY(-30);
                        }
                        if((obom.x+40)/40==(int)gameWorld.enemy1.getPosX()/40&&obom.y/40==(int)gameWorld.enemy1.getPosY()/40)
                        {
                            gameWorld.enemy1.Death=1;
                            gameWorld.enemy1.setPosX(-300);
                            gameWorld.enemy1.setPosY(-300);
                        }
                        if((obom.x+40)/40==(int)gameWorld.enemy2.getPosX()/40&&obom.y/40==(int)gameWorld.enemy2.getPosY()/40)
                        {
                            gameWorld.enemy2.Death=1;
                            gameWorld.enemy2.setPosX(-300);
                            gameWorld.enemy2.setPosY(-300);
                        }
                        if((obom.x+40)/40==(int)gameWorld.enemy3.getPosX()/40&&obom.y/40==(int)gameWorld.enemy3.getPosY()/40)
                        {
                            gameWorld.enemy3.Death=1;
                            gameWorld.enemy3.setPosX(-300);
                            gameWorld.enemy3.setPosY(-300);
                        }
                        if((obom.x+40)/40==(int)gameWorld.enemy4.getPosX()/40&&obom.y/40==(int)gameWorld.enemy4.getPosY()/40)
                        {
                            gameWorld.enemy4.Death=1;
                            gameWorld.enemy4.setPosX(-300);
                            gameWorld.enemy4.setPosY(-300);
                        }
                        if((obom.x+40)/40==(int)gameWorld.enemy.getPosX()/40&&obom.y/40==(int)gameWorld.enemy.getPosY()/40)
                        {
                            gameWorld.enemy.Death=1;
                            gameWorld.enemy.setPosX(-300);
                            gameWorld.enemy.setPosY(-300);
                        }
                    }

                    if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom.x/40 && j==obom.y/40 +1 ){
                        gameWorld.physicalMap.phys_map[j][i] = 0;
                        explosion.draw(obom.x, obom.y +40, g2);
                        if((obom.x)/40==(int)gameWorld.bomberman.getPosX()/40&&obom.y/40+1==(int)gameWorld.bomberman.getPosY()/40)
                        {
                            gameWorld.bomberman.Death=1;
                            gameWorld.bomberman.timeDie = System.currentTimeMillis();
                            gameWorld.bomberman.setPosX(-30);
                            gameWorld.bomberman.setPosY(-30);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom.y/40+1==(int)gameWorld.enemy.getPosY()/40)
                        {
                            gameWorld.enemy.Death=1;
                            gameWorld.enemy.setPosX(-300);
                            gameWorld.enemy.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom.y/40+1==(int)gameWorld.enemy1.getPosY()/40)
                        {
                            gameWorld.enemy1.Death=1;
                            gameWorld.enemy1.setPosX(-300);
                            gameWorld.enemy1.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom.y/40+1==(int)gameWorld.enemy2.getPosY()/40)
                        {
                            gameWorld.enemy2.Death=1;
                            gameWorld.enemy2.setPosX(-300);
                            gameWorld.enemy2.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom.y/40+1==(int)gameWorld.enemy3.getPosY()/40)
                        {
                            gameWorld.enemy3.Death=1;
                            gameWorld.enemy3.setPosX(-300);
                            gameWorld.enemy3.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom.y/40+1==(int)gameWorld.enemy4.getPosY()/40)
                        {
                            gameWorld.enemy4.Death=1;
                            gameWorld.enemy4.setPosX(-300);
                            gameWorld.enemy4.setPosY(-300);
                        }
                    }

                    if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom.x/40 && j==obom.y/40 -1 ){
                        gameWorld.physicalMap.phys_map[j][i] = 0;
                        explosion.draw(obom.x, obom.y -40, g2);
                        if((obom.x)/40==(int)gameWorld.bomberman.getPosX()/40&&obom.y/40-1==(int)gameWorld.bomberman.getPosY()/40)
                        {
                            gameWorld.bomberman.Death=1;
                            gameWorld.bomberman.timeDie = System.currentTimeMillis();
                            gameWorld.bomberman.setPosX(-30);
                            gameWorld.bomberman.setPosY(-30);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom.y/40-1==(int)gameWorld.enemy.getPosY()/40)
                        {
                            gameWorld.enemy.Death=1;
                            gameWorld.enemy.setPosX(-300);
                            gameWorld.enemy.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom.y/40-1==(int)gameWorld.enemy1.getPosY()/40)
                        {
                            gameWorld.enemy1.Death=1;
                            gameWorld.enemy1.setPosX(-300);
                            gameWorld.enemy1.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom.y/40-1==(int)gameWorld.enemy2.getPosY()/40)
                        {
                            gameWorld.enemy2.Death=1;
                            gameWorld.enemy2.setPosX(-300);
                            gameWorld.enemy2.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom.y/40-1==(int)gameWorld.enemy3.getPosY()/40)
                        {
                            gameWorld.enemy3.Death=1;
                            gameWorld.enemy3.setPosX(-300);
                            gameWorld.enemy3.setPosY(-300);
                        }
                        if((obom.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom.y/40-1==(int)gameWorld.enemy4.getPosY()/40)
                        {
                            gameWorld.enemy4.Death=1;
                            gameWorld.enemy4.setPosX(-300);
                            gameWorld.enemy4.setPosY(-300);
                        }
                    }


                }}


            if (explosion.isLastFrame()) {
                explosion.reset();
                demAnimation = 0;
                demDraw = 0;
            }
        }


    }

    if (numberBomb == 2 ) {
            if (demDraw1 == 1 && demAnimation1 == 0) {
                g2.drawImage(image, obom1.x - 20, obom1.y - 20, null);
            }



            if (demAnimation1 == 1 && demDraw1 == 0) {
                explosion1.Update(System.nanoTime());

                for(int i = 0; i < gameWorld.physicalMap.phys_map[0].length ; i++){
                    for(int j = 0; j < gameWorld.physicalMap.phys_map.length ; j++){
                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom1.x/40 && j==obom1.y/40 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion1.draw(obom1.x, obom1.y, g2);
                            if(i==(int)gameWorld.bomberman.getPosX()/40&&j==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }

                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom1.x/40 + 1 && j==obom1.y/40 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion1.draw(obom1.x + 40, obom1.y, g2);
                            if((obom1.x+40)/40==(int)gameWorld.bomberman.getPosX()/40&&obom1.y/40==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom1.x+40)/40==(int)gameWorld.enemy.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom1.x+40)/40==(int)gameWorld.enemy1.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom1.x+40)/40==(int)gameWorld.enemy2.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom1.x+40)/40==(int)gameWorld.enemy3.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom1.x+40)/40==(int)gameWorld.enemy4.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }

                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom1.x/40 -1 && j==obom1.y/40 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion1.draw(obom1.x - 40, obom1.y, g2);
                            if((obom1.x-40)/40==(int)gameWorld.bomberman.getPosX()/40&&obom1.y/40==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom1.x-40)/40==(int)gameWorld.enemy.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom1.x-40)/40==(int)gameWorld.enemy1.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom1.x-40)/40==(int)gameWorld.enemy2.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom1.x-40)/40==(int)gameWorld.enemy3.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom1.x-40)/40==(int)gameWorld.enemy4.getPosX()/40&&obom1.y/40==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }

                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom1.x/40 && j==obom1.y/40 +1 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion1.draw(obom1.x, obom1.y +40, g2);
                            if((obom1.x)/40==(int)gameWorld.bomberman.getPosX()/40&&obom1.y/40+1==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom1.y/40+1==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom1.y/40+1==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom1.y/40+1==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom1.y/40+1==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom1.y/40+1==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }

                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom1.x/40 && j==obom1.y/40 -1 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion1.draw(obom1.x, obom1.y -40, g2);
                            if((obom1.x)/40==(int)gameWorld.bomberman.getPosX()/40&&obom1.y/40-1==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom1.y/40-1==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom1.y/40-1==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom1.y/40-1==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom1.y/40-1==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom1.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom1.y/40-1==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }
                    }}


            }

            if (explosion1.isLastFrame()) {
                explosion1.reset();
                b1Activate = 0;
                demAnimation1 = 0;
                demDraw1 = 0;
            }
    }
    if (numberBomb == 2 ) {
            if (demDraw2 == 1 && demAnimation2 == 0) {
                g2.drawImage(image, obom2.x - 20, obom2.y - 20, null);
            }
            if (demAnimation2 == 1 && demDraw2 == 0) {
                explosion2.Update(System.nanoTime());
                for(int i = 0; i < gameWorld.physicalMap.phys_map[0].length ; i++){
                    for(int j = 0; j < gameWorld.physicalMap.phys_map.length ; j++){
                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom2.x/40 && j==obom2.y/40 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion2.draw(obom2.x, obom2.y, g2);
                            if((obom2.x)/40==(int)gameWorld.bomberman.getPosX()/40&&obom2.y/40==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }

                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom2.x/40 + 1 && j==obom2.y/40 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion2.draw(obom2.x + 40, obom2.y, g2);
                            if((obom2.x)/40+1==(int)gameWorld.bomberman.getPosX()/40&&obom2.y/40==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom2.x)/40+1==(int)gameWorld.enemy.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom2.x)/40+1==(int)gameWorld.enemy1.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom2.x)/40+1==(int)gameWorld.enemy2.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom2.x)/40+1==(int)gameWorld.enemy3.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom2.x)/40+1==(int)gameWorld.enemy4.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }


                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom2.x/40 -1 && j==obom2.y/40 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion2.draw(obom2.x - 40, obom2.y, g2);
                            if((obom2.x)/40-1==(int)gameWorld.bomberman.getPosX()/40&&obom2.y/40==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom2.x)/40-1==(int)gameWorld.enemy.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom2.x)/40-1==(int)gameWorld.enemy1.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom2.x)/40-1==(int)gameWorld.enemy2.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom2.x)/40-1==(int)gameWorld.enemy3.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom2.x)/40-1==(int)gameWorld.enemy4.getPosX()/40&&obom2.y/40==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }

                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom2.x/40 && j==obom2.y/40 +1 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion2.draw(obom2.x, obom2.y +40, g2);
                            if((obom2.x)/40==(int)gameWorld.bomberman.getPosX()/40&&obom2.y/40+1==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom2.y/40+1==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom2.y/40+1==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom2.y/40+1==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom2.y/40+1==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom2.y/40+1==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }

                        if((gameWorld.physicalMap.phys_map[j][i] > 1 ||gameWorld.physicalMap.phys_map[j][i] == 0 ) && i==obom2.x/40 && j==obom2.y/40 -1 ){
                            gameWorld.physicalMap.phys_map[j][i] = 0;
                            explosion2.draw(obom2.x, obom2.y -40, g2);
                            if((obom2.x)/40+1==(int)gameWorld.bomberman.getPosX()/40&&obom2.y/40-1==(int)gameWorld.bomberman.getPosY()/40)
                            {
                                gameWorld.bomberman.Death=1;
                                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                                gameWorld.bomberman.setPosX(-30);
                                gameWorld.bomberman.setPosY(-30);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy.getPosX()/40&&obom2.y/40-1==(int)gameWorld.enemy.getPosY()/40)
                            {
                                gameWorld.enemy.Death=1;
                                gameWorld.enemy.setPosX(-300);
                                gameWorld.enemy.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy1.getPosX()/40&&obom2.y/40-1==(int)gameWorld.enemy1.getPosY()/40)
                            {
                                gameWorld.enemy1.Death=1;
                                gameWorld.enemy1.setPosX(-300);
                                gameWorld.enemy1.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy2.getPosX()/40&&obom2.y/40-1==(int)gameWorld.enemy2.getPosY()/40)
                            {
                                gameWorld.enemy2.Death=1;
                                gameWorld.enemy2.setPosX(-300);
                                gameWorld.enemy2.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy3.getPosX()/40&&obom2.y/40-1==(int)gameWorld.enemy3.getPosY()/40)
                            {
                                gameWorld.enemy3.Death=1;
                                gameWorld.enemy3.setPosX(-300);
                                gameWorld.enemy3.setPosY(-300);
                            }
                            if((obom2.x)/40==(int)gameWorld.enemy4.getPosX()/40&&obom2.y/40-1==(int)gameWorld.enemy4.getPosY()/40)
                            {
                                gameWorld.enemy4.Death=1;
                                gameWorld.enemy4.setPosX(-300);
                                gameWorld.enemy4.setPosY(-300);
                            }
                        }
                    }}
            }

            if (explosion2.isLastFrame()) {
                explosion2.reset();
                b2Activate = 0;
                demAnimation2 = 0;
                demDraw2 = 0;
            }

    }

    }


        @Override
        public void Update () {
            if (gameWorld.bomberman.getMakeBomb() == 1  && numberBomb == 1 && demAnimation == 0 && demDraw == 0) {
                gameWorld.bomb1.setPosX(gameWorld.bomberman.getPosX());
                gameWorld.bomb1.setPosY(gameWorld.bomberman.getPosY());

                gameWorld.bomberman.setMakeBomb(0);
                obom.x = (int) gameWorld.bomb1.getPosX();
                obom.y = (int) gameWorld.bomb1.getPosY();
                obom.width = 40;
                obom.height = 40;


                if (getGameWorld().physicalMap.haveCollisionWithNull(obom) != null) {
                    Rectangle rect = getGameWorld().physicalMap.haveCollisionWithNull(obom);
                    obom.x = rect.x;
                    obom.y = rect.y;
                }


                timeBomb = System.currentTimeMillis();
                demDraw = 1;


            }
            if ( demDraw == 1 && demAnimation ==0 && (System.currentTimeMillis() - timeBomb) > 2000 && (System.currentTimeMillis() - timeBomb) < 3000){
                demDraw = 0;
                demAnimation = 1;

            }
            if ( demDraw1 == 1 && demAnimation1 ==0 && (System.currentTimeMillis() - timeBomb1) > 2000 && (System.currentTimeMillis() - timeBomb1) < 3000){
                demDraw1 = 0;
                demAnimation1 = 1;

            }
            if (demDraw2 == 1 && demAnimation2 ==0 && (System.currentTimeMillis() - timeBomb2) > 2000 && (System.currentTimeMillis() - timeBomb2) < 3000){
                demDraw2 = 0;
                demAnimation2 = 1;

            }

            if (gameWorld.bomberman.getMakeBomb() == 1  && numberBomb == 2 && demDraw1 == 0 && b1Activate == 0) {

                    gameWorld.bomb1.setPosX(gameWorld.bomberman.getPosX());
                    gameWorld.bomb1.setPosY(gameWorld.bomberman.getPosY());

                    gameWorld.bomberman.setMakeBomb(0);
                    obom1.x = (int) gameWorld.bomb1.getPosX();
                    obom1.y = (int) gameWorld.bomb1.getPosY();
                    obom1.width = 40;
                    obom1.height = 40;
                    b1Activate = 1;


                    if (getGameWorld().physicalMap.haveCollisionWithNull(obom1) != null) {
                        Rectangle rect = getGameWorld().physicalMap.haveCollisionWithNull(obom1);
                        obom1.x = rect.x;
                        obom1.y = rect.y;
                    }

                    timeBomb1 = System.currentTimeMillis();
                    demDraw1 = 1;


            }

            if (gameWorld.bomberman.getMakeBomb() == 1  && numberBomb == 2 && demDraw1 == 1 && demDraw2 == 0 && b2Activate == 0) {

                gameWorld.bomb1.setPosX(gameWorld.bomberman.getPosX());
                gameWorld.bomb1.setPosY(gameWorld.bomberman.getPosY());

                gameWorld.bomberman.setMakeBomb(0);
                obom2.x = (int) gameWorld.bomb1.getPosX();
                obom2.y = (int) gameWorld.bomb1.getPosY();
                obom2.width = 40;
                obom2.height = 40;

                b2Activate = 1;


                if (getGameWorld().physicalMap.haveCollisionWithNull(obom2) != null) {
                    Rectangle rect = getGameWorld().physicalMap.haveCollisionWithNull(obom2);
                    obom2.x = rect.x;
                    obom2.y = rect.y;

                }

                timeBomb2 = System.currentTimeMillis();
                demDraw2 = 1;

            }
            if((int)gameWorld.bomberman.getPosX()/40==(int)gameWorld.enemy.getPosX()/40 && (int)gameWorld.bomberman.getPosY()/40==(int)gameWorld.enemy.getPosY()/40) {
                gameWorld.bomberman.Death = 1;
                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                gameWorld.bomberman.setPosX(-30);
                gameWorld.bomberman.setPosY(-30);
            }
            if((int)gameWorld.bomberman.getPosX()/40==(int)gameWorld.enemy1.getPosX()/40 && (int)gameWorld.bomberman.getPosY()/40==(int)gameWorld.enemy1.getPosY()/40) {
                gameWorld.bomberman.Death = 1;
                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                gameWorld.bomberman.setPosX(-30);
                gameWorld.bomberman.setPosY(-30);
            }
            if((int)gameWorld.bomberman.getPosX()/40==(int)gameWorld.enemy2.getPosX()/40 && (int)gameWorld.bomberman.getPosY()/40==(int)gameWorld.enemy2.getPosY()/40) {
                gameWorld.bomberman.Death = 1;
                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                gameWorld.bomberman.setPosX(-30);
                gameWorld.bomberman.setPosY(-30);
            }
            if((int)gameWorld.bomberman.getPosX()/40==(int)gameWorld.enemy3.getPosX()/40 && (int)gameWorld.bomberman.getPosY()/40==(int)gameWorld.enemy3.getPosY()/40) {
                gameWorld.bomberman.Death = 1;
                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                gameWorld.bomberman.setPosX(-30);
                gameWorld.bomberman.setPosY(-30);
            }
            if((int)gameWorld.bomberman.getPosX()/40==(int)gameWorld.enemy4.getPosX()/40 && (int)gameWorld.bomberman.getPosY()/40==(int)gameWorld.enemy4.getPosY()/40) {
                gameWorld.bomberman.Death = 1;
                gameWorld.bomberman.timeDie = System.currentTimeMillis();
                gameWorld.bomberman.setPosX(-30);
                gameWorld.bomberman.setPosY(-30);
            }
            if(gameWorld.bomberman.Death==1 && System.currentTimeMillis()-gameWorld.bomberman.timeDie>1300&&System.currentTimeMillis()-gameWorld.bomberman.timeDie<2000){
                gameWorld.bomberman.Death=0;
                gameWorld.bomberman.setPosX(60);
                gameWorld.bomberman.setPosY(60);
                gameWorld.bomberman.setDirection(DOWN_DIR);
                gameWorld.bomberman.somangsong--;
                gameWorld.bomberman.itemSpeed=0;
                gameWorld.bomb1.numberBomb=1;
                GameSound.instance.getAudio(GameSound.BOMBER_DIE).play();
            }

        }
}