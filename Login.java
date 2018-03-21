import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.geometry.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Login{

    static Stage window;
    static TextField inputUser;
    static PasswordField inputPass;

    public static void start() {

        window = new Stage();
        window.setTitle("Login page");

        Pane grid = new Pane();


        Label empPort = new Label("Employee Portal");
        empPort.setId("title");
        empPort.setLayoutX(110); empPort.setLayoutY(30);

        Label username = new Label("Username");
        username.setLayoutX(110); username.setLayoutY(100);

        Label password = new Label("Password");
        password.setLayoutX(110); password.setLayoutY(135);

        inputUser = new TextField();
        inputUser.setLayoutX(180); inputUser.setLayoutY(95);
        inputUser.setMinWidth(220);

        inputPass = new PasswordField();
        inputPass.setPromptText("Enter password");
        inputPass.setLayoutX(180); inputPass.setLayoutY(130);
        inputPass.setMinWidth(220);


        Button login = new Button("Log in");
        login.setMinWidth(60); login.setMinHeight(30);
        login.setLayoutX(180); login.setLayoutY(170);

        Button forgot = new Button("Forgot Password?");
        forgot.setMinWidth(60); forgot.setMinHeight(30);
        forgot.setLayoutX(250); forgot.setLayoutY(170);

        login.setOnKeyPressed(event -> checkLoginDetails(inputUser.getText(), inputPass.getText()));
        login.setOnAction(event -> checkLoginDetails(inputUser.getText(), inputPass.getText()));



        grid.getChildren().addAll(empPort, username, password, inputUser, inputPass, login, forgot);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        scene.getStylesheets().add("LoginTheme.css");
        window.setMinHeight(300);
        window.setMinWidth(500);

        window.show();

    }

    public static void checkLoginDetails(String username, String password){
        if (checkUserPassword(username).equals(password) && !(("").equals(password))) {
            View.getInstance().setCurrentUserName(username);
            window.close();
            Homepage.displayHomepage();
            /*Homepage.displayHomepage(username, password, lines[2], lines[3], lines[4], lines[5], lines[6], lines[7],
                    lines[8], lines[9], lines[10], lines[11], lines[12]);*/
        }
        else{
            ConfirmBox.display("Error in login details!", "Error! \nEnter Login details again");
            inputPass.clear();
            inputUser.clear();
        }
    }

    public static String checkUserPassword(String username){
        for(int i = 0 ; i < View.getInstance().getEmployeeList().size() ; i++){
            if(View.getInstance().getEmployeeList().get(i).getUserName().equals(username)){
                return View.getInstance().getEmployeeList().get(i).getUserPassword();
            }
        }
        return "";
    }

}