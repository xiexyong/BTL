package com.dung.effect;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Hashtable;

public class CacheDataLoader {

    private  static  CacheDataLoader instance = null;
    public CacheDataLoader getInstance;

    private String frameFile = "data/frame.txt";
    private String animationFile = "data/animation.txt";
    private String phymapfile = "data/backgroundmap.txt";
    private String backgroundmapfile = "data/backgroundmap.txt";





    private Hashtable<String, FrameImage> frameImages;
    private Hashtable<String, Animation> animations;

    private int[][] phymap;
    private int[][] backmap;


    private CacheDataLoader(){
    }

    public static  CacheDataLoader getInstance(){
        if(instance == null) instance = new CacheDataLoader();
        return  instance;
    }

    public int[][] getPhysicalMap(){
        return instance.backmap;
    }
    public int[][] getBackgroundMap(){
        return instance.backmap;
    }

    public void LoadPhyMap() throws IOException {
        FileReader fr = new FileReader(phymapfile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        line = br.readLine();
        int numberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int numberOfColumns = Integer.parseInt(line);

        instance.phymap = new int[numberOfRows][numberOfColumns];

        for(int i = 0; i < numberOfRows; i++) {
            line = br.readLine();
            String[] str = line.split(" ");
            for (int j = 0; j < numberOfColumns; j++) {
                instance.phymap[i][j] = Integer.parseInt(str[j]);
            }
        }

            /*for(int i = 0; i < numberOfRows; i++){
                 for(int j = 0; j< numberOfColumns; j++){
                     System.out.print(" "+instance.phymap[i][j]);
                 }
                System.out.println();
            }*/

            br.close();

    }

    public void LoadFrame() throws IOException{
        frameImages = new Hashtable<String, FrameImage>();

        FileReader fr = new FileReader(frameFile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        if(br.readLine() == null){
            System.out.println("No data");
            throw  new IOException();
        }
        else {
            fr = new FileReader(frameFile);
            br = new BufferedReader(fr);

            while((line = br.readLine()).equals(""));

            int n = Integer.parseInt(line);

            for(int i = 0;i < n; i++){

                FrameImage frame = new FrameImage();

                while ((line = br.readLine()).equals(""));
                frame.setName(line);

                while ((line = br.readLine()).equals(""));
                String[] str = line.split(" ");
                String path = str[1];

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int x = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int y = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int w = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int h = Integer.parseInt(str[1]);

                BufferedImage imageData = ImageIO.read(new File(path));
                BufferedImage image = imageData.getSubimage(x,y,w,h);
                frame.setImage(image);

                instance.frameImages.put(frame.getName(),frame);


            }
            br.close();

        }
    }
    public void LoadAnimation() throws IOException{
        animations = new Hashtable<String, Animation>();

        FileReader fr = new FileReader(animationFile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;
        if(br.readLine() == null) {
            System.out.println("No data");
            throw  new IOException();
        }
        else {
            fr = new FileReader(animationFile);
            br = new BufferedReader(fr);

            while ((line = br.readLine()).equals(""));

            int n = Integer.parseInt(line);

            for(int i = 0; i < n; i++){

                Animation animation = new Animation();

                while ((line = br.readLine()).equals(""));
                animation.setName(line);

                while ((line = br.readLine()).equals(""));
                String[] str =  line.split(" ");

                for(int j=0; j< str.length; j+=2){
                    animation.add(getFrameImage(str[j]), Double.parseDouble(str[j+1]));
                    instance.animations.put(animation.getName(), animation);

                }


            }



        }
    }

    public void LoadBackgroundMap() throws IOException{

        FileReader fr = new FileReader(backgroundmapfile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        line = br.readLine();
        int numberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int numberOfColumns = Integer.parseInt(line);


        instance.backmap = new int[numberOfRows][numberOfColumns];

        for(int i = 0;i < numberOfRows;i++){
            line = br.readLine();
            String [] str = line.split(" ");
            for(int j = 0;j<numberOfColumns;j++)
                instance.backmap[i][j] = Integer.parseInt(str[j]);
        }

        /*for(int i = 0;i < numberOfRows;i++){

            for(int j = 0;j<numberOfColumns;j++)
                System.out.print(" "+instance.backmap[i][j]);

            System.out.println();
        }*/

        br.close();

    }

    public FrameImage getFrameImage(String name){
        FrameImage frameImage = new FrameImage(instance.frameImages.get(name));
        return frameImage;


    }


    public Animation getAnimation(String name){
        Animation animation = new Animation(instance.animations.get(name));
        return animation;

    }
    public void LoadData() throws IOException{
        LoadFrame();
        LoadAnimation();
        LoadPhyMap();
        LoadBackgroundMap();
    }

}
