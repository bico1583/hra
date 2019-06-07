package sample;

import javafx.scene.image.ImageView;

public class ShootFire {
    private int x,y;
    private String playershoot ="sample\\\\Laser1.jpg";
    ImageView ivshoot = new ImageView(playershoot);

    public ShootFire(int x, int y){
        this.x =x;
        this.y =y;
    }

//    public int getX(){
////        return x;
////    }
////    public void  setX(int x){
////        this.x =x;
////    }

    public int getY(){
        return y;
    }
    public void  setY(int y){
        this.y =y;
    }


    public ImageView Draw(double x ,int y){
        ivshoot.relocate(x, y);
        ivshoot.setPreserveRatio(true);
        ivshoot.setFitHeight(20);
        return ivshoot;
    }



}
