package com.dung.userinterface;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private Thread thread;

    private boolean isRunning;
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(0,0,GameFrame.s_width,GameFrame.s_height);

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
        long FPS = 120;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        beginTime = System.nanoTime();
        int a = 1;
        while(isRunning){
                System.out.println("a = "+(a++));
                long deltaTime = System.nanoTime() - beginTime;
                sleepTime = period - deltaTime;
            try {
                if (sleepTime>0) Thread.sleep(sleepTime/1000000);
                else Thread.sleep(sleepTime/2000000);
            } catch (InterruptedException e) { }
//            System.out.println("a = "+(a++));
        }
    }
}