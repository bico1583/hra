package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player  {
    public int i;
    private double x,y;
    private double xy;
    private String playerimage ="sample\\images.png";

    ImageView iv = new ImageView(playerimage);

    public Player(int x, int y){
        this.x =x;
        this.y =y;

    }
    public double getX(){
        xy=iv.getLayoutX();
        return xy;
    }

    public ImageView draw(){
        iv.relocate(x,y);
        iv.setPreserveRatio(true);
        iv.setFitHeight(50);
        return iv;

    }

    public ImageView moveLeft(){
        iv.relocate(iv.getLayoutX()-7,iv.getLayoutY());
        return iv;
    }

    public ImageView moveRight(){
        iv.relocate(iv.getLayoutX()+7,iv.getLayoutY());
        return iv;
    }

    public double[] PlayerPosition(){

        x=iv.getX();
        y=iv.getY();
        double[] positionPlayer = {x,y};

        return positionPlayer;
    }




    public ImageView PlayerDie(){
        iv.setPreserveRatio(true);
        iv.setFitWidth(0);
        return iv;
    }
}
