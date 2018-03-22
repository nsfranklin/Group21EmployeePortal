import javafx.application.*;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.geometry.*;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;

import java.io.IOException;

public class Homepage{

    static Stage home;

    public static void displayHomepage(/*String username, String password, String type, String staffID, String firstName, String lastName, String dob,
                                       String email, String phoneNumber, String address, String country, String city, String postCode*/){
        Homepage hp = new Homepage();
        Employee loggedInUser = View.getInstance().findEmployee();


        home = new Stage();

        Pane mainPane = new Pane();
        mainPane.getStylesheets().add("HomePageTheme.css");



        HBox hbox = new HBox(48);

        hbox.setStyle("-fx-background-color: red;" );

        MenuBar bar = new MenuBar();
        bar.setStyle("-fx-padding: 1 60 1 1;");

        Menu payrollMenu = new Menu("Clock");
        MenuItem cico = new MenuItem("Clock In / Clock Out");
        cico.setOnAction(event -> hp.clockedHandler());
        payrollMenu.getItems().add(cico);

        Menu empStuffMenu = new Menu("Payroll");
        MenuItem f2 = new MenuItem("View Payroll");
        f2.setOnAction(event -> { try { hp.viewPayroll(); } catch (Exception e){} });
        MenuItem f3 = new MenuItem("Change Payroll Details");
        if (!((loggedInUser.getEmployeeType().equals("Manager")) || (loggedInUser.getEmployeeType().equals("Admin") || (loggedInUser.getEmployeeType().equals("PartTimeEmployee"))))){
            f3.setDisable(true);
        }
        f3.setOnAction(event -> {
                try {
                    hp.viewChangePayrollDetails();
                } catch (Exception e) {
                }
            });
                    MenuItem f11 = new MenuItem("Time Off");

        empStuffMenu.getItems().addAll(f2, f3);


        Menu accountsMenu = new Menu("Manage User Accounts");
        if (!((loggedInUser.getEmployeeType().equals("Manager")) || (loggedInUser.getEmployeeType().equals("Admin")))){
            accountsMenu.setDisable(true);
        }
        MenuItem createNewUser = new MenuItem("Create a New User");
        if (!((loggedInUser.getEmployeeType().equals("Manager")) || (loggedInUser.getEmployeeType().equals("Admin")))){
            createNewUser.setDisable(true);
        }
        createNewUser.setOnAction(event -> ManageUsers.displayCreateUserWindow());

        MenuItem updateUserAvailability = new Menu("Change User Availability");
        if ((loggedInUser.getEmployeeType().equals("PartTimeEmployee"))){
            accountsMenu.setDisable(true);
        }
        //updateUserAvailability.setOnAction(event -> );

        MenuItem deleteUser = new MenuItem("Delete a User");
        if (!(loggedInUser.getEmployeeType().equals("Admin"))){
            deleteUser.setDisable(true);
        }
        deleteUser.setOnAction(event -> {
            try { ManageUsers.displayDeleteUserWindow(); } catch (IOException e){} });
        accountsMenu.getItems().addAll(createNewUser, new SeparatorMenuItem(), deleteUser);

        Menu manMenu = new Menu("Timetable");
        //if (!emp.getIsAllowedManagerFunctions()) manMenu.setDisable(true);
        MenuItem f4 = new MenuItem("View Timetable");
        f4.setOnAction(event -> { try {hp.viewTimetable(); } catch (Exception e){} });
        MenuItem f5 = new MenuItem("Set Scheduling Rules");
        if (!(loggedInUser.getEmployeeType().equals("Admin"))){
            f5.setDisable(true);
        }
        MenuItem f10 = new MenuItem("Manage Incomplete Timetable");
        if (!((loggedInUser.getEmployeeType().equals("Manager")) || (loggedInUser.getEmployeeType().equals("Admin")))){
            f10.setDisable(true);
        }
        f10.setOnAction(event -> { try {hp.viewAlterTimetable();} catch (Exception e){}});

        manMenu.getItems().addAll(f4, f5, f10);

        Menu admMenu = new Menu("Time Off");
        //if (!emp.getIsAllowedAdminFunctions()) admMenu.setDisable(true);
        MenuItem f6 = new MenuItem("Request Time Off");
        f6.setOnAction(event -> { try { hp.viewRequestTimeOff(); } catch (Exception e){} });
        MenuItem f7 = new MenuItem("View Time Off Approval");
        f7.setOnAction(event -> { try { hp.viewTimeOffApproval(); } catch (Exception e){} });
        MenuItem f77 = new MenuItem("Manage Time Off Requests");
        if (!((loggedInUser.getEmployeeType().equals("Manager")) || (loggedInUser.getEmployeeType().equals("Admin")))){
            f77.setDisable(true);
        }
        f77.setOnAction(event -> ManageTimeOffRequests.manageRequests());
        admMenu.getItems().addAll(f6, f7, f77);


        Menu options = new Menu("Options");
        MenuItem f8 = new MenuItem("Settings");
        MenuItem f9 = new MenuItem("Log Out");
        f9.setOnAction(event -> logOutEvent());
        options.getItems().addAll(f8, f9);

        bar.getMenus().addAll(payrollMenu, empStuffMenu, accountsMenu, manMenu, admMenu, options);

        hbox.getChildren().addAll(bar);

        //if (!emp.getIsAllowedManagerFunctions()) bf.setDisable(true);
        //if (!emp.getIsAllowedAdminFunctions()) bg.setDisable(true);
        Image image;
        hbox.setLayoutX(100); hbox.setLayoutY(0);
        if(userProfilePicture(loggedInUser)){
            image = new Image("file:"+loggedInUser.getUserName()+".png");
        } else {
            image = new Image("file:mukhz.jpg");
        }
        ImageView iv = new ImageView();
        iv.setFitWidth(200);
        iv.setFitHeight(200);
        iv.setImage(image);
        iv.setLayoutY(50);
        iv.setLayoutX(50);

        Image timetableImage = new Image("file:timetable.jpg");
        ImageView ivt = new ImageView();
        ivt.setFitWidth(450);
        ivt.setFitHeight(400);
        ivt.setImage(timetableImage);
        ivt.setLayoutX(300);
        ivt.setLayoutY(50);

        Label lfname = new Label( View.getInstance().getCurrentUserName());
        Label ldob = new Label("01/01/98"/*emp.getDob()*/);
        Label laddress = new Label("1 Sample Road"/*emp.getAddress()*/);
        Label lcountry = new Label("England"/*emp.getCountry()*/);
        Label lemail = new Label(View.getInstance().getCurrentUserName() + "@prototype.com");
        VBox vboxx = new VBox();
        vboxx.setId("UserInfo");
        vboxx.getChildren().addAll(lfname, ldob, laddress, lcountry, lemail);
        vboxx.setLayoutX(50);
        vboxx.setLayoutY(260);

        mainPane.getChildren().addAll(hbox,iv, vboxx, ivt);

        Scene scene = new Scene(mainPane, 400, 350);
        //scene.getStylesheets().add("HomePageTheme.css");
        home.setScene(scene);
        home.setMinHeight(500);
        home.setMinWidth(800);
        home.show();
    }

    public static Boolean userProfilePicture(Employee loggedInUser){
        return new File(loggedInUser.getUserName()+".png").exists();
    }

    public void viewTimetable () throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewTimetable.fxml"));
        Parent r = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(r));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public static void logOutEvent(){
        home.close();
        Login.start();
    }

    public void viewAlterTimetable () throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAlterTimetable.fxml"));
        Parent p = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void clockedHandler(){
        String currentUser = View.getInstance().getCurrentUserName();
        int temp = findClockUser(currentUser);
        if(temp == -1){
            System.out.println("clocked in handler");
            View.getInstance().getSMC().findEmployee(currentUser).clockIn();
            View.getInstance().getSMC().update();
        }else{
            System.out.println("Clocked out handler");
            View.getInstance().getSMC().findEmployee(currentUser).clockOut();
            View.getInstance().getSMC().update();
        }
    }

    public int findClockUser(String username){
        ArrayList<ClockedHours> temp = View.getInstance().getClockedHoursList();
        System.out.println(temp);
        if(!temp.isEmpty()) {
            System.out.println(temp.get(0).getUserName());
        }
        for(int i = 0 ; i < View.getInstance().getClockedHoursList().size() ; i++){
            System.out.println(i);
            if(temp.get(i).getUserName().equals(username)) {

                return i;
            }
        }
        return -1;
    }

    public void viewRequestTimeOff () throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RequestTimeOffGui.fxml"));
        Parent rooot = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rooot));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void viewTimeOffApproval () throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewTimeOffApproval.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void viewPayroll () throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewPayroll.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    public void viewChangePayrollDetails () throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangePayrollDetails.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}