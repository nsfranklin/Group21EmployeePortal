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
import java.util.ArrayList;

import java.io.IOException;

public class Homepage{

    private ArrayList<Employee> employeList;
    private ArrayList<Requests> requestList;
    private ArrayList<Requests> approvedRequestList;
    private Week currentSchedule;
    private ArrayList<Week> futureSchedules;
    //private ArrayList<finalHoursWorked> hoursWorkedLastMonth;

    static Stage home;

    public static void displayHomepage(/*String username, String password, String type, String staffID, String firstName, String lastName, String dob,
                                       String email, String phoneNumber, String address, String country, String city, String postCode*/){
        Homepage hp = new Homepage();

        //Employee emp;
        /*
        if (type.equals("Employee") ) {
            emp = new Employee(username, password, staffID, firstName, lastName, dob, email, phoneNumber, address, country, city, postCode);
        }
        else if (type.equals("Manager")){
            emp = new Manager(username, password, staffID, firstName, lastName, dob, email, phoneNumber, address, country, city, postCode);
        }
        else if (type.equals("Admin")){
            emp = new Admin(username, password, staffID, firstName, lastName, dob, email, phoneNumber, address, country, city, postCode);
        }
        else{
            emp = new PartTimeEmployee(username, password, staffID, firstName, lastName, dob, email, phoneNumber, address, country, city, postCode);
        }*/

        home = new Stage();

        Pane mainPane = new Pane();
        mainPane.getStylesheets().add("HomePageTheme.css");



        HBox hbox = new HBox(48);

        hbox.setStyle("-fx-background-color: red;" );

        MenuBar bar = new MenuBar();
        bar.setStyle("-fx-padding: 1 60 1 1;");

        Menu payrollMenu = new Menu("Clock");
        MenuItem cico = new MenuItem("Clock In / Clock Out");
        payrollMenu.getItems().add(cico);

        Menu empStuffMenu = new Menu("Payroll");
        MenuItem f2 = new MenuItem("View Payroll");
        f2.setOnAction(event -> { try { hp.viewPayroll(); } catch (Exception e){} });
        MenuItem f3 = new MenuItem("Change Payroll Details");
        f3.setOnAction(event -> { try { hp.viewChangePayrollDetails(); } catch (Exception e){} });
        MenuItem f11 = new MenuItem("Time Off");

        empStuffMenu.getItems().addAll(f2, f3);

        Menu accountsMenu = new Menu("Manage User Accounts");
        MenuItem createNewUser = new MenuItem("Create a New User");
        //if (!emp.getIsAllowedAdminFunctions() && !emp.getIsAllowedManagerFunctions()) createNewUser.setDisable(true);
        createNewUser.setOnAction(event -> ManageUsers.displayCreateUserWindow());
        MenuItem deleteUser = new MenuItem("Delete a User");
        deleteUser.setOnAction(event -> {
            try { ManageUsers.displayDeleteUserWindow(); } catch (IOException e){} });
        accountsMenu.getItems().addAll(createNewUser, new SeparatorMenuItem(), deleteUser);

        Menu manMenu = new Menu("Timetable");
        //if (!emp.getIsAllowedManagerFunctions()) manMenu.setDisable(true);
        MenuItem f4 = new MenuItem("View Timetable");
        MenuItem f5 = new MenuItem("Set Scheduling Rules");
        MenuItem f10 = new MenuItem("Manage Incomplete Timetable")
;
        manMenu.getItems().addAll(f4, f5, f10);

        Menu admMenu = new Menu("Time Off");
        //if (!emp.getIsAllowedAdminFunctions()) admMenu.setDisable(true);
        MenuItem f6 = new MenuItem("Request Time Off");
        MenuItem f7 = new MenuItem("View Time Off Approval");
        MenuItem f77 = new MenuItem("View Time Off Approval");
        admMenu.getItems().addAll(f6, f7, f77);


        Menu options = new Menu("Options");
        MenuItem f8 = new MenuItem("Settings");
        MenuItem f9 = new MenuItem("Log Out");
        f9.setOnAction(event -> System.exit(0));
        options.getItems().addAll(f8, f9);

        bar.getMenus().addAll(payrollMenu, empStuffMenu, accountsMenu, manMenu, admMenu, options);

        hbox.getChildren().addAll(bar);

        //if (!emp.getIsAllowedManagerFunctions()) bf.setDisable(true);
        //if (!emp.getIsAllowedAdminFunctions()) bg.setDisable(true);

        hbox.setLayoutX(100); hbox.setLayoutY(0);

        Image image = new Image("file:mukhz.jpg");
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

        Label lfname = new Label("Sample Name"/*emp.getFirstName() + " " + emp.getLastName() */);
        Label ldob = new Label("01/01/98"/*emp.getDob()*/);
        Label laddress = new Label("1 Sample Road"/*emp.getAddress()*/);
        Label lcountry = new Label("England"/*emp.getCountry()*/);
        Label lemail = new Label("sampleEmail@hotmail.com"/*emp.getEmail()*/);
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