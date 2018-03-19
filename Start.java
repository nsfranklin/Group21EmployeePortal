import javafx.animation.FadeTransition;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.FadeTransition;

import java.sql.*;
import java.time.Duration;

public class Start extends Application{
    Stage window;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        Image img = new Image("file:opening.png");

        ImageView imgview = new ImageView();
        imgview.setImage(img);
        imgview.setFitHeight(670);
        imgview.setFitWidth(1200);
        imgview.setOnMouseClicked(event -> {
            Login.start();
            window.close();
        });

        grid.getChildren().addAll(imgview);

        FadeTransition fadeIn = new FadeTransition(javafx.util.Duration.seconds(2), imgview);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play();

        Scene scene = new Scene(grid);
        window.setScene(scene);
        //scene.getStylesheets().add("HomePageTheme.css");
        window.setMinHeight(670);
        window.setMinWidth(1250);

        window.show();




        //window.close();
        //Login.start();




    }



}