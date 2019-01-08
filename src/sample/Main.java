package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ObservableLongValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Button start = new Button("Press to Start");

        EventHandler<ActionEvent> gameStart = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < 5; i ++)
                {
                    int num = (int)(Math.random() *3);
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        start.setOnAction(gameStart);
        Pane main = new Pane();
        main.getChildren().add(start);
        Scene primary = new Scene(main,500,200);
        primaryStage.setScene(primary);
        primaryStage.show();
    }

    public void buttonLight(int num, Stage primaryStage) {
        Button blue = new Button("Blue");
        Button green = new Button("Green");
        Button yellow = new Button("Yellow");
        Button red = new Button("Red");
        Button submit = new Button("Submit");
        if (num == 0) {
            blue.setStyle("-fx-background-color: blue");
        } else if (num == 1) {
            green.setStyle("-fx-background-color: green");
        } else if (num == 2) {
            yellow.setStyle("-fx-background-color: yellow");
        } else if (num == 3) {
            red.setStyle("-fx-background-color: red");
        }

        EventHandler<ActionEvent> setColor = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        };
        red.setOnAction(setColor);
        yellow.setOnAction(setColor);
        green.setOnAction(setColor);
        blue.setOnAction(setColor);

        Pane game = new Pane();
        HBox hitBox = new HBox(red, yellow, green, blue, submit);
        game.getChildren().add(hitBox);
        Scene secondary = new Scene(game, 500, 200);
        primaryStage.setScene(secondary);
        primaryStage.show();
    }

    public void StartGame(Stage primaryStage) {
        Button blue = new Button("Blue");
        Button green = new Button("Green");
        Button yellow = new Button("Yellow");
        Button red = new Button("Red");
        Button submit = new Button("Submit");

        red.setStyle("-fx-background-color: white");
        yellow.setStyle("-fx-background-color: white");
        green.setStyle("-fx-background-color: white");
        blue.setStyle("-fx-background-color: white");
        submit.setStyle("-fx-background-color: white");

        EventHandler<ActionEvent> setRed = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                red.setStyle("-fx-background-color: red");
                long time = System.nanoTime();
                System.out.println("Running");
                new AnimationTimer()
                {
                    @Override
                    public void handle(long now) {
                        if((now-time) >= 100000000l)
                        {
                            red.setStyle("-fx-background-color: white");
                        }
                    }
                }.start();
            }
        };

        EventHandler<ActionEvent> setYellow = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                yellow.setStyle("-fx-background-color: yellow");
                long time = System.nanoTime();
                new AnimationTimer()
                {
                    @Override
                    public void handle(long now) {
                        if((now-time) >= 100000000l)
                        {
                            yellow.setStyle("-fx-background-color: white");
                        }
                    }
                }.start();
            }
        };

        EventHandler<ActionEvent> setGreen = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                green.setStyle("-fx-background-color: green");
                long time = System.nanoTime();
                new AnimationTimer()
                {
                    @Override
                    public void handle(long now) {
                        if((now-time) >= 100000000l)
                        {
                            green.setStyle("-fx-background-color: white");
                        }
                    }
                }.start();
            }
        };

        EventHandler<ActionEvent> setBlue = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                blue.setStyle("-fx-background-color: blue");
                long time = System.nanoTime();
                new AnimationTimer()
                {
                    @Override
                    public void handle(long now) {
                        if((now-time) >= 100000000l)
                        {
                            blue.setStyle("-fx-background-color: white");
                        }
                    }
                }.start();
            }
        };

        red.setOnAction(setRed);
        yellow.setOnAction(setYellow);
        green.setOnAction(setGreen);
        blue.setOnAction(setBlue);

        Pane game = new Pane();
        HBox hitBox = new HBox(red, yellow, green, blue, submit);
        game.getChildren().add(hitBox);
        Scene secondary = new Scene(game, 500, 200);
        primaryStage.setScene(secondary);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
