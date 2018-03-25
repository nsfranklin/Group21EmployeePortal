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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.geometry.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.ArrayList;

import java.io.IOException;

public class Homepage{

    static Stage home;

    public static void displayHomepage() {
        Homepage hp = new Homepage();
        Employee loggedInUser = View.getInstance().findEmployee();


        home = new Stage();

        Pane mainPane = new Pane();
        mainPane.getStylesheets().add("HomePageTheme.css");

        Label empPort = new Label("Employee Portal");
        empPort.setId("title");
        empPort.setLayoutX(307); empPort.setLayoutY(40);

        HBox hbox = new HBox(48);

        hbox.setStyle("-fx-background-color: red;" );

        MenuBar bar = new MenuBar();
        bar.setStyle("-fx-padding: 1 60 1 1;");

        Label lfname = new Label( View.getInstance().getCurrentUserName());
        Label ldob = new Label("Clocked In:");
        Label laddress = new Label("--------------");
        Label lcountry = new Label("Clocked Out:");
        Label lclockedout = new Label("--------------");
        Label lemail = new Label(View.getInstance().getCurrentUserName() + "@prototype.com");


        VBox vboxx = new VBox();
        vboxx.setId("UserInfo");
        vboxx.getChildren().addAll(lfname, ldob, laddress, lcountry, lclockedout , lemail);
        vboxx.setLayoutX(5);
        vboxx.setLayoutY(315);

        Menu payrollMenu = new Menu("Clock");
        MenuItem cico = new MenuItem("Clock In / Clock Out");
        cico.setOnAction(event -> hp.clockedHandler(laddress,lclockedout));
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
        if ((loggedInUser.getEmployeeType().equals("Employee"))){
            accountsMenu.setDisable(true);
        }

        MenuItem createNewUser = new MenuItem("Create a New User");
        if (!((loggedInUser.getEmployeeType().equals("Manager")) || (loggedInUser.getEmployeeType().equals("Admin")))){
            createNewUser.setDisable(true);
        }
        createNewUser.setOnAction(event -> ManageUsers.displayCreateUserWindow());

        MenuItem deleteUser = new MenuItem("Delete a User");
        if (!(loggedInUser.getEmployeeType().equals("Admin"))){
            deleteUser.setDisable(true);
        }
        deleteUser.setOnAction(event -> {
            try { ManageUsers.displayDeleteUserWindow(); } catch (IOException e){} });
        MenuItem changeUserType = new MenuItem("Change A User's Account Type");
        if(!((loggedInUser.getEmployeeType().equals("Manager")) || (loggedInUser.getEmployeeType().equals("Admin")))){
            changeUserType.setDisable(true);
        }
        changeUserType.setOnAction(event -> {try{ hp.viewChangeUserAccountType();} catch(Exception e){}});

        MenuItem updateUserAvailability = new Menu("Change User Availability");
        if ((loggedInUser.getEmployeeType().equals("Employee"))){
            updateUserAvailability.setDisable(true);
        }
        updateUserAvailability.setOnAction(event -> ManageUsers.displayEditAvailabilityWindow());

        accountsMenu.getItems().addAll(createNewUser, new SeparatorMenuItem(), deleteUser, changeUserType, updateUserAvailability);

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
        MenuItem message = new MenuItem("Announcement");
        message.setOnAction(event -> {try{hp.viewAnnouncement();} catch (Exception e) {}});
        MenuItem f8 = new MenuItem("Settings");
        MenuItem f9 = new MenuItem("Log Out");
        f9.setOnAction(event -> logOutEvent());
        options.getItems().addAll(message, f8, f9);

        bar.getMenus().addAll(payrollMenu, empStuffMenu, accountsMenu, manMenu, admMenu, options);

        hbox.getChildren().addAll(bar);

        //if (!emp.getIsAllowedManagerFunctions()) bf.setDisable(true);
        //if (!emp.getIsAllowedAdminFunctions()) bg.setDisable(true);
        Image image;
        hbox.setLayoutX(200); hbox.setLayoutY(0);
        hbox.setMaxWidth(700);
        if(userProfilePicture(loggedInUser)){
            image = new Image("file:"+loggedInUser.getUserName()+".png");
        } else {
            image = new Image("file:mukhz.jpg");
        }
        ImageView iv = new ImageView();
        iv.setFitWidth(200);
        iv.setFitHeight(200);
        iv.setImage(image);
        iv.setLayoutY(100);
        iv.setLayoutX(0);

        Image timetableImage = new Image("file:logo.png");
        ImageView ivt = new ImageView();
        ivt.setFitWidth(140);
        ivt.setFitHeight(105);
        ivt.setImage(timetableImage);
        ivt.setLayoutX(30);
        ivt.setLayoutY(-5);





        Line dline = new Line(200, 0, 200 ,550);
        Line aline = new Line(0, 100, 774, 100);

        Label announcements = new Label("Announcement Board");
        announcements.setLayoutX(307); announcements.setLayoutY(110);
        announcements.setStyle("-fx-font-size: 17pt;");

        Label ancmntTitle = new Label(); ancmntTitle.setStyle("-fx-font-weight: bold;");
        Label ancmntMessage = new Label(); //ancmntMessage.setLayoutX(300); ancmntMessage.setLayoutY(250);
        Label ancmntDate = new Label(); //ancmntDate.setLayoutX(300); ancmntDate.setLayoutY(400);
        Label ancmntTime = new Label(); //ancmntTime.setLayoutX(300); ancmntTime.setLayoutY(450);
        VBox ancmntBox = new VBox();
        ancmntBox.getChildren().addAll(ancmntTitle, ancmntMessage, ancmntDate, ancmntTime);
        //ancmntBox.setLayoutX(315); ancmntBox.setLayoutY(15);

        Button update = new Button("Update");
        update.setLayoutX(552); update.setLayoutY(116);
        update.setOnAction(event -> {
            ArrayList<String> al = announcementStrings();
            ancmntTitle.setText("Title: " + al.get(0));
            ancmntMessage.setText("Announcement: " + al.get(1));
            ancmntDate.setText("Date created: " + al.get(2));
            ancmntTime.setText("Time sent: " + al.get(3));
            ancmntBox.getChildren().addAll(ancmntTitle, ancmntMessage, ancmntDate, ancmntTime);
            ancmntBox.setLayoutX(307); ancmntBox.setLayoutY(170);
        });



        mainPane.getChildren().addAll(hbox,iv, vboxx, ivt, empPort, dline, aline, ancmntTitle,
                ancmntMessage, ancmntDate, ancmntTime, update, announcements, ancmntBox);

        Scene scene = new Scene(mainPane, 400, 350);
        //scene.getStylesheets().add("HomePageTheme.css");
        home.setScene(scene);
        home.setMinHeight(530);
        home.setMinWidth(774);
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

    public void clockedHandler(Label a, Label b){
        String currentUser = View.getInstance().getCurrentUserName();
        int temp = findClockUser(currentUser);
        if(temp == -1){
            View.getInstance().getSMC().findEmployee(currentUser).clockIn();
            View.getInstance().getSMC().update();
            a.setText(String.valueOf(View.getInstance().getClockedHoursList().get(findClockUser(currentUser)).getClockedIn()/60) + ":" +  String.valueOf(View.getInstance().getClockedHoursList().get(findClockUser(currentUser)).getClockedIn()%60));
        }else{
            View.getInstance().getSMC().findEmployee(currentUser).clockOut();
            View.getInstance().getSMC().update();
            b.setText(String.valueOf(View.getInstance().getClockedHoursList().get(findClockUser(currentUser)).getClockedOut()/60) + ":" + String.valueOf(View.getInstance().getClockedHoursList().get(findClockUser(currentUser)).getClockedOut()%60));
        }
    }

    public void viewChangeUserAccountType () throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewChangeUserAccountType.fxml"));
        Parent p = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public int findClockUser(String username){
        ArrayList<ClockedHours> temp = View.getInstance().getClockedHoursList();
        if(!temp.isEmpty()) {
        }
        for(int i = 0 ; i < View.getInstance().getClockedHoursList().size() ; i++){
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

    public void viewAnnouncement() throws  Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAnnouncement.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public static ArrayList<String> announcementStrings (){
        ArrayList<String> al = new ArrayList<>();
        String[] lines;
        String line="";
        try{
            BufferedReader r = new BufferedReader(new FileReader("message.txt"));

            line=r.readLine();
            lines = line.split(",");
            al.add(lines[0]); System.out.println(al.get(0));
            al.add(lines[1]); System.out.println(al.get(1));
            al.add(lines[2]); System.out.println(al.get(2));
            al.add(lines[3]); System.out.println(al.get(3));

            r.close();
        }
        catch (IOException e){

        }
        return al;
    }
}