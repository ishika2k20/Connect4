package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Button;

public class Main extends Application {

    private Controller Controller;

    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();

        Controller=loader.getController();
        Controller.createPlayground();

        MenuBar menuBar =  createMenu();

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());


        Scene scene=new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private MenuBar createMenu() {

        //file menu

        Menu fileMenu=new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> Controller.resetGame());

        MenuItem resetGame= new MenuItem("Reset Game");
        resetGame.setOnAction(event -> Controller.resetGame());

        SeparatorMenuItem  separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");

        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Connect4");

        aboutGame.setOnAction(event -> aboutConnect4());


        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);



        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(  fileMenu  , helpMenu);

        return  menuBar;
    }

    private void aboutMe() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the developer");
        alert.setHeaderText("Ishika Ranjan");
        alert.setContentText("I Love to play around with code and create new application." +
                "Connect 4 is one of them ,who so" +
                " ever will play will enjoy it," +
                " In free times i love to spend times with loved ones and sometimes loves to watch Netflix  ");
        alert.show();

    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect four");
        alert.setHeaderText("How to Play?");
        alert.setContentText("is a two-player connection board game in which the players first choose " +
                "a color and then take turns dropping one colored disc from the top into" +
                " a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying " +
                "the lowest available space within the column. The objective of the game is to be " +
                "the first to form a horizontal, vertical, or diagonal line of four of one's own discs. " +
                "Connect Four is a solved game. The first player can always win by playing the right moves.");


        alert.show();
    }

    private void exitGame() {

        Platform.exit();
        System.exit(0);

    }

    private void resetGame() {

        //Todo
    }


    public static void main(String[] args) {
        launch(args);
    }
}
