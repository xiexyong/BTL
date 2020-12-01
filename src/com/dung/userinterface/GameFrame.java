package com.dung.userinterface;

import com.dung.effect.CacheDataLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {

    public static final int s_width = 1120;
    public static final int s_height = 600;
    GamePanel gamePanel;

    public GameFrame(){
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width-s_width)/2,(dimension.height-s_height)/2,s_width,s_height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (IOException e) {
            e.printStackTrace();
        }


        gamePanel = new GamePanel();
        add(gamePanel);


        this.addKeyListener(gamePanel);


    }

    public void startGame(){
        gamePanel.startGame();
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.startGame();
    }
}
