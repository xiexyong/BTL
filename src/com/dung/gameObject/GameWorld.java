package com.dung.gameObject;

import java.awt.*;

public class GameWorld {

    public Bomberman bomberman;
    public PhysicalMap physicalMap ;

    public void Update(){
        bomberman.update();

    }

    public GameWorld(){
        bomberman = new Bomberman(260,300,this);
        physicalMap = new PhysicalMap(30,30,this);

    }

    public void Render(Graphics2D g2){
        physicalMap.draw(g2);
        bomberman.draw(g2);


    }



}
