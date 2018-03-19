import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    public static void display (String title, String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300); // Sets minimum width for the window
        window.setMinHeight(200); // sets minimum height for the window

        VBox layout = new VBox(10);

        Label lab1 = new Label(message);

        Button okButton = new Button("Ok");


        okButton.setOnAction(event -> {
            window.close();
        });


        layout.getChildren().addAll(lab1, okButton);
        layout.setAlignment(Pos.CENTER); // Aligns everything in the center !

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // This window needs to be closed before going back to the old window

    }

    static boolean ans;

    public static boolean yesOrNo (String title, String message)
    {
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300); // Sets minimum width for the window
        window.setMinHeight(200); // sets minimum height for the window

        Pane pane = new Pane();


        Label lab1 = new Label(message);
        lab1.setStyle("-fx-font-size: 15pt;");
        lab1.setLayoutX(0); lab1.setLayoutY(20);

        Button yesButton = new Button("Yes");
        yesButton.setLayoutX(100); yesButton.setLayoutY(50);

        Button noButton = new Button("No");
        noButton.setLayoutX(150); noButton.setLayoutY(50);

        yesButton.setOnAction(event -> {
            ans=true;
            window.close();
        });

        noButton.setOnAction(event -> {
            ans=false;
            window.close();
        });


        pane.getChildren().addAll(lab1, yesButton, noButton);
        //layout.setAlignment(Pos.CENTER); // Aligns everything in the center !

        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.showAndWait(); // This window needs to be closed before going back to the old window
        return ans;
    }
}