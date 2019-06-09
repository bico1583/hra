package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;


import javax.xml.stream.events.StartDocument;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application  {
    boolean shoot;
    boolean goRIGHT,goLEFT;
    int shootCall=500;

    double x,y;
    float seconds;
    ShootFire shot = new ShootFire(210,500);
    ShootFire shot2 = new ShootFire(250,500);

    Player p = new Player(220,650);

    Timer timer = new Timer();



    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        final double StartX = 220;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(goLEFT == true){
                    p.moveLeft();

                }
                if(goRIGHT == true){
                    p.moveRight();
                }
                else if (shoot == true){
                        shootCall-=7;
                        shot.Draw(StartX,shootCall);
                }

            }
        };
        timer.start();

        root.getChildren().add(p.draw());



        Scene scene = new Scene(root, 600, 800);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
            public void handle(KeyEvent event) {
               switch (event.getCode()){
                   case LEFT:goLEFT=true; break;//goLEFT=true;break;
                    case RIGHT:goRIGHT=true;break;//goRIGHT=true;break;
                   case SPACE: shootCall = 650;
                       shoot =true;
                       root.getChildren().add(shot.Draw(p.getX(),shootCall));
                       break;

                }

            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case LEFT: goLEFT = false;
                    case RIGHT: goRIGHT = false;
                }
            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
