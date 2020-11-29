package com.dung.gameObject;

import com.dung.effect.CacheDataLoader;
import com.dung.userinterface.GameFrame;

import java.awt.*;

public class BackgroundMap extends GameObject {

    public int[][] map;
    private int tileSize;

    public BackgroundMap(float x, float y, GameWorld gameWorld) {
        super(x, y, gameWorld);
        map = CacheDataLoader.getInstance().getBackgroundMap();
        tileSize = 30;
    }

    @Override
    public void Update() {}

    public void draw(Graphics2D g2){

        g2.setColor(Color.RED);
        for(int i = 0;i< map.length;i++)
            for(int j = 0;j<map[0].length;j++)
                if(map[i][j]!=0 && j*tileSize  > -30 && j*tileSize  < GameFrame.s_width
                        && i*tileSize > -30 && i*tileSize < GameFrame.s_height){
                    g2.drawImage(CacheDataLoader.getInstance().getFrameImage("idWall"+map[i][j]).getImage(), (int) getPosX() + j*tileSize - (int) camera.getPosX(),
                            (int) getPosY() + i*tileSize , null);
                }

    }

}
