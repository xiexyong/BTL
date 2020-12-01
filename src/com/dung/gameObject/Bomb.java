package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;
import com.dung.userinterface.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Bomb extends ParticularObject {
    GamePanel gamePanel;


    GameWorld gameWorld;

    BufferedImage image;

    public int bomb1Active = 0;

    public long timeBomb1;

    private Animation explosion;

    public Bomb(float x, float y, GameWorld gameWorld) {
        super(x, y, 40, 40, gameWorld);
        setPosX(gameWorld.bomberman.getPosX());
        setPosY(gameWorld.bomberman.getPosY());
        this.gameWorld = gameWorld;

        explosion = CacheDataLoader.getInstance().getAnimation("idBoom");

        try {
            image = ImageIO.read(new File("data/bomb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    float x = -1;
    float y = -1;

    long timeDeath = 0;

    public void draw(Graphics2D g2) {
        int demve = 1;
        int demanimation = 1;

        long beginnTime = 0;

        long dtTime = System.nanoTime() - gameWorld.bomb1.timeBomb1;


        if (gameWorld.bomb1.getPosX() > 0 && gameWorld.bomb1.getPosY() > 0) {
            if (bomb1Active == 1 && gameWorld.getNumberBomb() == 1 && demve == 1) {
                g2.drawImage(image, (int) x - 15, (int) y - 20, null);
            }
        }

        if(gameWorld.bomberman.Death==1 && gameWorld.bomberman.somangsong>0){
            gameWorld.bomberman.setPosX(60);
            gameWorld.bomberman.setPosY(60);
            gameWorld.bomberman.Death=0;
            gameWorld.bomberman.somangsong--;
            gameWorld.bomberman.setDirection(DOWN_DIR);

            for(int i = 0;i< gameWorld.backgroundMap.backMap.length;i++)
                for(int j = 0;j<gameWorld.backgroundMap.backMap[0].length;j++) {
                    gameWorld.backgroundMap.backMap[i][j] = gameWorld.backgroundMap.backupMap[i][j];
                }
        }

        if (x >= 0 && y >= 0 && gameWorld.bomberman.somangsong >0 && gameWorld.bomberman.Death==0 ) {
            if (dtTime > 2000 * 1000000) {
                demve = 0;
                gameWorld.bomb1.setPosX(0);
                gameWorld.bomb1.setPosY(0);
                if (demanimation == 1) {

                    explosion.Update(System.nanoTime());


                    //System.out.println(x+  "     " +y);

                    int[][] vungno = new int[5][2];

                    vungno[0][0] =(int) (x - 40 -20)/40;  vungno[2][0] =(int) (x-20)/40;
                    vungno[0][1] = (int)(y-20)/40;         vungno[2][1] = (int)(y - 40 -20)/40;
                    vungno[1][0] = (int)(x + 40 -20)/40;  vungno[3][0] = (int)(x-20)/40;
                    vungno[1][1] = (int)(y-20)/40;         vungno[3][1] = (int)(y + 40-20)/40;
                    vungno[4][0] = (int)(x-20)/40;
                    vungno[4][1] = (int)(y-20)/40;


                    for(int j=0; j<gameWorld.physicalMap.phys_map.length; j++)
                    {
                        for(int i=0; i<gameWorld.physicalMap.phys_map[0].length; i++)
                        {
                            //System.out.println((int)x-40+  "     " +(int)y);
                            //System.out.println(vungno[0][0]+  "     " +i +"       "+ vungno[0][1]+  "     "+j);
                            if(vungno[4][0]==i && vungno[4][1]==j && gameWorld.physicalMap.phys_map[j][i]!=1) {
                                explosion.draw((int) x, (int) y, g2);
                                gameWorld.physicalMap.phys_map[j][i]=0;
                                if((int)gameWorld.bomberman.getPosX()/40==i&&(int)gameWorld.bomberman.getPosY()/40==j){
                                    gameWorld.bomberman.Death=1;
                                    timeDeath = System.nanoTime();
                                }
                            }
                            if(vungno[0][0]==i && vungno[0][1]==j && gameWorld.physicalMap.phys_map[j][i]!=1){
                                explosion.draw((int)x - 40, (int)y, g2);
                                gameWorld.physicalMap.phys_map[j][i]=0;
                                if((int)gameWorld.bomberman.getPosX()/40==i&&(int)gameWorld.bomberman.getPosY()/40==j){
                                    gameWorld.bomberman.Death=1;
                                    timeDeath = System.nanoTime();
                                }
                            //System.out.println(x-40+  "     " +y);
                            }

                            if(vungno[1][0]==i && vungno[1][1]==j && gameWorld.physicalMap.phys_map[j][i]!=1){
                                explosion.draw((int) x + 40, (int) y, g2);
                            gameWorld.physicalMap.phys_map[j][i]=0;
                                if((int)gameWorld.bomberman.getPosX()/40==i&&(int)gameWorld.bomberman.getPosY()/40==j){
                                    gameWorld.bomberman.Death=1;
                                    timeDeath = System.nanoTime();
                                }
                            }

                            if(vungno[2][0]==i && vungno[2][1]==j &&  gameWorld.physicalMap.phys_map[j][i]!=1) {
                                explosion.draw((int) x, (int) y - 40, g2);
                                gameWorld.physicalMap.phys_map[j][i] = 0;
                                if((int)gameWorld.bomberman.getPosX()/40==i&&(int)gameWorld.bomberman.getPosY()/40==j){
                                    gameWorld.bomberman.Death=1;
                                    timeDeath = System.nanoTime();
                                }
                            }

                            if(vungno[3][0]==i && vungno[3][1]==j && gameWorld.physicalMap.phys_map[j][i]!=1) {
                                explosion.draw((int) x, (int) y + 40, g2);
                                gameWorld.physicalMap.phys_map[j][i] = 0;
                                if((int)gameWorld.bomberman.getPosX()/40==i&&(int)gameWorld.bomberman.getPosY()/40==j){
                                    gameWorld.bomberman.Death=1;
                                    timeDeath = System.nanoTime();
                                }
                            }


                        }

                    }


                }
                if (explosion.isLastFrame()) {
                    explosion.reset();
                    x = -1;
                    y = -1;
                    bomb1Active = 0;
                }
                //System.out.println(bomb1.timeBomb1);
                //System.out.println(System.nanoTime());
            }
            //System.out.println(gameWorld.bomb1.getPosX() + "   " + gameWorld.bomb1.getPosY() +"     "+x+"      "+y);
            gameWorld.bomberman.setMakeBomb(0);


        }


    }


        @Override
        public void Update () {
            if (gameWorld.bomberman.getMakeBomb() == 1 && bomb1Active == 0 && gameWorld.getNumberBomb() == 1) {
                gameWorld.bomb1.setPosX(gameWorld.bomberman.getPosX());
                gameWorld.bomb1.setPosY(gameWorld.bomberman.getPosY());


                x = gameWorld.bomb1.getPosX();

                y = gameWorld.bomb1.getPosY();

                Rectangle obom = new Rectangle();
                obom.x = (int) x;
                obom.y = (int) y;
                obom.width = 40;
                obom.height = 40;

                if (getGameWorld().physicalMap.haveCollisionWithNull(obom) != null) {
                    Rectangle rect = getGameWorld().physicalMap.haveCollisionWithNull(obom);
                    x = rect.x;
                    y = rect.y;
                    //System.out.println(x+  "     " +y);

                }


                bomb1Active = 1;
                timeBomb1 = System.nanoTime();

            }



    }
}