package com.dung.userinterface;

import com.dung.gameObject.Bomberman;
import com.dung.gameObject.GameWorld;

import java.awt.event.KeyEvent;

public class InputManager {

    private GameWorld gameWorld;

    public InputManager(GameWorld gameWorld){
        this.gameWorld = gameWorld;

    }

    public void processKeyPressed(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_UP:
                gameWorld.bomberman.setDirection(Bomberman.UP_DIR);
                gameWorld.bomberman.setSpeedY(-1);
                gameWorld.bomberman.setSpeedX(0);
                gameWorld.bomberman.setLAND_DIR(0);
                break;
            case KeyEvent.VK_DOWN:
                gameWorld.bomberman.setDirection(Bomberman.DOWN_DIR);
                gameWorld.bomberman.setSpeedY(1);
                gameWorld.bomberman.setSpeedX(0);
                gameWorld.bomberman.setLAND_DIR(0);
                break;
            case KeyEvent.VK_LEFT:
                gameWorld.bomberman.setDirection(Bomberman.LEFT_DIR);
                gameWorld.bomberman.setSpeedX(-1);
                gameWorld.bomberman.setSpeedY(0);
                gameWorld.bomberman.setLAND_DIR(0);
                break;
            case KeyEvent.VK_RIGHT:
                gameWorld.bomberman.setDirection(Bomberman.RIGHT_DIR);
                gameWorld.bomberman.setSpeedX(1);
                gameWorld.bomberman.setSpeedY(0);
                gameWorld.bomberman.setLAND_DIR(0);
                break;
            case KeyEvent.VK_ENTER:
                System.out.println("You press enter");
                break;
            case  KeyEvent.VK_SPACE:
                gameWorld.bomberman.setMakeBomb(1);
                break;
        }
    }
    public void processKeyReleased(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_UP:
                gameWorld.bomberman.setSpeedY(0);
                gameWorld.bomberman.setLAND_DIR(1);
                break;
            case KeyEvent.VK_DOWN:
                gameWorld.bomberman.setSpeedY(0);
                gameWorld.bomberman.setLAND_DIR(1);
                break;
            case KeyEvent.VK_LEFT:
                gameWorld.bomberman.setSpeedX(0);
                gameWorld.bomberman.setLAND_DIR(1);
                break;
            case KeyEvent.VK_RIGHT:
                gameWorld.bomberman.setSpeedX(0);
                gameWorld.bomberman.setLAND_DIR(1);
                break;
            case KeyEvent.VK_ENTER:

                break;
            case  KeyEvent.VK_SPACE:
                //ameWorld.bomberman.setMakeBomb(0);
                break;
        }
    }
}
