package com.example.pong;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Auto extends Pane {
    public static Label gameOver;
    Rectangle object;
    private ImageView imv;

    public Auto(){
        object = new Rectangle(100,150, Color.BLUEVIOLET);
        imv = new ImageView(new Image("C:\\Users\\даня\\IdeaProjects\\Pong\\src\\main\\resources\\com\\example\\pong\\RetroCar.png",100,160,false,true));
        getChildren().addAll(imv);
        setTranslateY(400);
    }

    public void setCarImage(){
        imv.setImage(new Image("C:\\Users\\даня\\IdeaProjects\\Pong\\src\\main\\resources\\com\\example\\pong\\RetroCar.png",100,160,false,true));
    }

    public void moveY(){
        setTranslateY(getTranslateY()-2);

        for(Wall w : Pong.walls){
            if(this.getBoundsInParent().intersects(w.getBoundsInParent())){
                gameOver = new Label("GAME OVER!!!");
                gameOver.setTranslateY(380); gameOver.setTranslateX(250);
                gameOver.setFont(new Font(24));
                Pong.appRoot.getChildren().addAll(gameOver);
                imv.setImage(new Image("C:\\Users\\даня\\IdeaProjects\\Pong\\src\\main\\resources\\com\\example\\pong\\Explosion.png",300,300,false,true));
                Pong.timer.stop();
            }
        }
    }

}
