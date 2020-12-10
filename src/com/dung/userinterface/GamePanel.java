package com.dung.userinterface;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;
import com.dung.effect.FrameImage;
import com.dung.gameObject.Bomberman;
import com.dung.gameObject.GameWorld;
import com.dung.gameObject.PhysicalMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class GamePanel extends JPanel implements Runnable, KeyListener  {

    private Thread thread;

    private boolean isRunning;

    private InputManager inputManager;

    private GameWorld gameWorld;

    private long timeEnd;


    Animation animation1;
    FrameImage frame1;

    BufferedImage image;
    BufferedImage subImage;

    private BufferedImage bufferedImage;
    private  Graphics2D bufG2D;


    public GamePanel(){

        gameWorld = new GameWorld();
        inputManager = new InputManager(gameWorld);
        bufferedImage = new BufferedImage(GameFrame.s_width,GameFrame.s_height,BufferedImage.TYPE_INT_ARGB);

    }
    @Override
    public void paint(Graphics g){

        g.drawImage(bufferedImage,0,0,this);



    }

    public void UpdateGame(){
        gameWorld.Update();
    }

    public void RenderGame(){
        if(bufferedImage == null){
            bufferedImage = new BufferedImage(GameFrame.s_width,GameFrame.s_height,BufferedImage.TYPE_INT_ARGB);

        }
        else {
            bufG2D = (Graphics2D) bufferedImage.getGraphics();


        }
        if(bufG2D != null){
            bufG2D.setColor(Color.gray);
            bufG2D.fillRect(0,0,GameFrame.s_width,GameFrame.s_height);

            //draw game here

            gameWorld.Render(bufG2D);




            
        }




    }

    public void startGame(){
        if(thread == null){
            isRunning = true;
            thread = new Thread(this);
            thread.start();

        }
    }
    @Override
    public void run() {
        long FPS = 60;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        beginTime = System.nanoTime();

        while(isRunning){

            UpdateGame();
            RenderGame();
            repaint();

//            animation1.Update(System.nanoTime());
//            repaint();

                long deltaTime = System.nanoTime() - beginTime;
                sleepTime = period - deltaTime;

            try {
                if (sleepTime>0) Thread.sleep(sleepTime/1000000);
               // else Thread.sleep(sleepTime/2000000);
            } catch (InterruptedException e) { }
            beginTime = System.nanoTime();

            if(gameWorld.bomberman.somangsong<1) break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManager.processKeyReleased(e.getKeyCode());
    }
}