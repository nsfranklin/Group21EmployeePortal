import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;


import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class ManageUsers {

    public static void displayCreateUserWindow() {
        Stage stg = new Stage();
        GridPane gridd = new GridPane();
        gridd.setPadding(new Insets(10, 10, 10, 10));
        gridd.setVgap(8);
        gridd.setHgap(10);

        Label lab = new Label("Add a new User to the Employee Portal");
        lab.setId("CreateNewEmployeeTitle");
        GridPane.setConstraints(lab,1, 0);

        Label choiceLab = new Label("Choose role of user ");
        GridPane.setConstraints(choiceLab, 0, 2);

        ChoiceBox<String> choices = new ChoiceBox<>();
        choices.getItems().addAll("Employee", "Part-Time Employee", "Manager");
        choices.setValue("Employee");
        GridPane.setConstraints(choices,1, 2 );

        ArrayList<String> userList = new ArrayList<>();

        if(!View.getInstance().findEmployee(View.getInstance().getCurrentUserName()).getEmployeeType().equals("PartTimeEmployee")) {
            userList = View.getInstance().getUsernameList();
        }
        else{
            userList.add(View.getInstance().getCurrentUserName());
        }
        ObservableList<String> userSelect = FXCollections.observableArrayList(userList);

        Label usernameLab = new Label("Enter user's Username");
        GridPane.setConstraints(usernameLab, 0, 3);
        TextField username = new TextField();
        //username.setMinWidth(50);
        GridPane.setConstraints(username, 1, 3);


        Label passwordLab = new Label("Enter user's Password");
        GridPane.setConstraints(passwordLab, 0, 4);
        PasswordField password = new PasswordField();
        GridPane.setConstraints(password, 1, 4);

        Label password2Lab = new Label("Confirm the Password");
        GridPane.setConstraints(password2Lab, 0, 5);
        PasswordField password2 = new PasswordField();
        GridPane.setConstraints(password2, 1, 5);

        Label acNoLab = new Label("Account Number:");
        GridPane.setConstraints(acNoLab, 0, 6);
        TextField acNo = new TextField();
        GridPane.setConstraints(acNo, 1, 6);

        Label sortCodeLab = new Label("Sort Code");
        GridPane.setConstraints(sortCodeLab, 0, 7);
        TextField sortCode = new TextField();
        GridPane.setConstraints(sortCode, 1, 7);

        Label formatLab = new Label("Start Format:");
        GridPane.setConstraints(formatLab, 0 , 8);
        Label formatExam = new Label("9 = \"9am\" and 17 = \"5pm\"");
        GridPane.setConstraints(formatExam, 1 , 8);
        Label durLab = new Label("Duration Format:");
        GridPane.setConstraints(durLab, 2 , 8);
        Label durExam = new Label("8 = \"for 8 hours\"");
        GridPane.setConstraints(durExam, 3 , 8);

        Label monStartLab = new Label("Monday Start");
        GridPane.setConstraints(monStartLab, 0, 9);
        TextField monStart = new TextField();
        GridPane.setConstraints(monStart, 1, 9);
        Label monLengthLab = new Label("Duration");
        GridPane.setConstraints(monLengthLab, 2, 9);
        TextField monLength = new TextField();
        GridPane.setConstraints(monLength, 3, 9);

        Label tueStartLab = new Label("Tuesday Start");
        GridPane.setConstraints(tueStartLab, 0, 10);
        TextField tueStart = new TextField();
        GridPane.setConstraints(tueStart, 1, 10);
        Label tueLengthLab = new Label("Duration");
        GridPane.setConstraints(tueLengthLab, 2, 10);
        TextField tueLength = new TextField();
        GridPane.setConstraints(tueLength, 3, 10);

        Label wedStartLab = new Label("Wednesday Start");
        GridPane.setConstraints(wedStartLab, 0, 11);
        TextField wedStart = new TextField();
        GridPane.setConstraints(wedStart, 1, 11);
        Label wedLengthLab = new Label("Duration");
        GridPane.setConstraints(wedLengthLab, 2, 11);
        TextField wedLength = new TextField();
        GridPane.setConstraints(wedLength, 3, 11);

        Label thuStartLab = new Label("Thursday Start");
        GridPane.setConstraints(thuStartLab, 0, 12);
        TextField thuStart = new TextField();
        GridPane.setConstraints(thuStart, 1, 12);
        Label thuLengthLab = new Label("Duration");
        GridPane.setConstraints(thuLengthLab, 2, 12);
        TextField thuLength = new TextField();
        GridPane.setConstraints(thuLength, 3, 12);

        Label friStartLab = new Label("Friday Start");
        GridPane.setConstraints(friStartLab, 0, 13);
        TextField friStart = new TextField();
        GridPane.setConstraints(friStart, 1, 13);
        Label friLengthLab = new Label("Duration");
        GridPane.setConstraints(friLengthLab, 2, 13);
        TextField friLength = new TextField();
        GridPane.setConstraints(friLength, 3, 13);

        Label satStartLab = new Label("Saturday Start");
        GridPane.setConstraints(satStartLab, 0, 14);
        TextField satStart = new TextField();
        GridPane.setConstraints(satStart, 1, 14);
        Label satLengthLab = new Label("Duration");
        GridPane.setConstraints(satLengthLab, 2, 14);
        TextField satLength = new TextField();
        GridPane.setConstraints(satLength, 3, 14);

        Label sunStartLab = new Label("Sunday Start");
        GridPane.setConstraints(sunStartLab, 0, 15);
        TextField sunStart = new TextField();
        GridPane.setConstraints(sunStart, 1, 15);
        Label sunLengthLab = new Label("Duration");
        GridPane.setConstraints(sunLengthLab, 2, 15);
        TextField sunLength = new TextField();
        GridPane.setConstraints(sunLength, 3, 15);

        Button addUser = new Button("Add User");
        addUser.setMinHeight(50);
        addUser.setMinWidth(100);
        addUser.setOnAction(event -> {
            if (!(password.getText().equals(password2.getText())))
            {
                ConfirmBox.display("Passwords do not match!", "Error! \nEnsure the passwords are the same");
            }
            else if(!inputParse(arrayListAggregator(monStart.getText(),monLength.getText(),tueStart.getText(), tueLength.getText(),wedStart.getText(),wedLength.getText(),thuStart.getText(),thuLength.getText(),friStart.getText(),friLength.getText(),satStart.getText(),satLength.getText(),sunStart.getText(),sunLength.getText())))
            {
                ConfirmBox.display("Availiblity formated Incorrectly", "Error! \nEnsure Availability is set as per the example");
            }
            else{
                Week week = new Week(monStart.getText(),monLength.getText(),tueStart.getText(), tueLength.getText(),wedStart.getText(),wedLength.getText(),thuStart.getText(),thuLength.getText(),friStart.getText(),friLength.getText(),satStart.getText(),satLength.getText(),sunStart.getText(),sunLength.getText());
                PayrollDetails p = new PayrollDetails(acNo.getText(), sortCode.getText());
                if(choices.getValue().equals("Employee")){
                    View.getInstance().getSMC().getEmployeeList().add(new Employee(username.getText(),password.getText(), p,false , week));
                    View.getInstance().getSMC().update();
                }else if(choices.getValue().equals("Part-Time Employee")){
                    View.getInstance().getSMC().getEmployeeList().add(new PartTimeEmployee(username.getText(),password.getText(), p,false , week));
                    View.getInstance().getSMC().update();
                }else{
                    View.getInstance().getSMC().getEmployeeList().add(new Manager(username.getText(),password.getText(), p,false , week));
                    View.getInstance().getSMC().update();
                }
                ConfirmBox.display("Added a new User", "Successfully added " + username.getText() + " as a User!");
                stg.close();
            }
        });
        GridPane.setConstraints(addUser, 0, 16);
        Label errorText = new Label("");
        GridPane.setConstraints(errorText,1, 16);



        gridd.getChildren().addAll(choiceLab, lab, choices, usernameLab, username, passwordLab, password, password2Lab, password2, acNoLab, acNo,
                sortCodeLab, sortCode,formatLab,formatExam,durLab, durExam, monStartLab,  monStart,monLengthLab,monLength, tueStartLab,
                tueStart,tueLengthLab,tueLength, wedStartLab, wedStart,wedLengthLab,wedLength, thuStartLab, thuStart,thuLengthLab,thuLength,
                friStartLab, friStart,friLengthLab,friLength, satStartLab, satStart,satLengthLab,satLength, sunStartLab, sunStart, sunLengthLab,sunLength, addUser , errorText); //postCodeLab, postCode,

        Scene scene = new Scene(gridd, 600, 600);
        scene.getStylesheets().add("ManageUsersCreateUsers.css");
        stg.setScene(scene);
        stg.setMinWidth(900);
        stg.show();

    }

    public static void displayEditAvailabilityWindow() {
        Stage stg = new Stage();
        stg.setTitle("Edit Availability");
        GridPane gridd = new GridPane();
        gridd.setPadding(new Insets(10, 10, 10, 10));
        gridd.setVgap(8);
        gridd.setHgap(10);

        Label choiceLab = new Label("Select User");
        GridPane.setConstraints(choiceLab, 0, 1);

        ChoiceBox<String> choices = new ChoiceBox<>();

        ArrayList<String> employeeList = View.getInstance().getUsernameList();

        for(int i = 0 ; i < employeeList.size() ; i++) {
            choices.getItems().add(employeeList.get(i));
        }

        if((View.getInstance().findEmployee(View.getInstance().getCurrentUserName()).getEmployeeType().equals("Employee") || View.getInstance().findEmployee(View.getInstance().getCurrentUserName()).getEmployeeType().equals("PartTimeEmployee")))
        {
            choices.setValue(View.getInstance().getCurrentUserName());
            choices.setDisable(true);
        }
        else{
        }
        GridPane.setConstraints(choices,1, 1);

        Label formatLab = new Label("Start Format:");
        GridPane.setConstraints(formatLab, 0 , 2);
        Label formatExam = new Label("9 = \"9am\" and 17 = \"5pm\"");
        GridPane.setConstraints(formatExam, 1 , 2);
        Label durLab = new Label("Duration Format:");
        GridPane.setConstraints(durLab, 2 , 2);
        Label durExam = new Label("8 = \"for 8 hours\"");
        GridPane.setConstraints(durExam, 3 , 2);

        Label monStartLab = new Label("Monday Start");
        GridPane.setConstraints(monStartLab, 0, 3);
        TextField monStart = new TextField();
        GridPane.setConstraints(monStart, 1, 3);
        Label monLengthLab = new Label("Duration");
        GridPane.setConstraints(monLengthLab, 2, 3);
        TextField monLength = new TextField();
        GridPane.setConstraints(monLength, 3, 3);

        Label tueStartLab = new Label("Tuesday Start");
        GridPane.setConstraints(tueStartLab, 0, 4);
        TextField tueStart = new TextField();
        GridPane.setConstraints(tueStart, 1, 4);
        Label tueLengthLab = new Label("Duration");
        GridPane.setConstraints(tueLengthLab, 2, 4);
        TextField tueLength = new TextField();
        GridPane.setConstraints(tueLength, 3, 4);

        Label wedStartLab = new Label("Wednesday Start");
        GridPane.setConstraints(wedStartLab, 0, 5);
        TextField wedStart = new TextField();
        GridPane.setConstraints(wedStart, 1, 5);
        Label wedLengthLab = new Label("Duration");
        GridPane.setConstraints(wedLengthLab, 2, 5);
        TextField wedLength = new TextField();
        GridPane.setConstraints(wedLength, 3, 5);

        Label thuStartLab = new Label("Thursday Start");
        GridPane.setConstraints(thuStartLab, 0, 6);
        TextField thuStart = new TextField();
        GridPane.setConstraints(thuStart, 1, 6);
        Label thuLengthLab = new Label("Duration");
        GridPane.setConstraints(thuLengthLab, 2, 6);
        TextField thuLength = new TextField();
        GridPane.setConstraints(thuLength, 3, 6);

        Label friStartLab = new Label("Friday Start");
        GridPane.setConstraints(friStartLab, 0, 7);
        TextField friStart = new TextField();
        GridPane.setConstraints(friStart, 1, 7);
        Label friLengthLab = new Label("Duration");
        GridPane.setConstraints(friLengthLab, 2, 7);
        TextField friLength = new TextField();
        GridPane.setConstraints(friLength, 3, 7);

        Label satStartLab = new Label("Saturday Start");
        GridPane.setConstraints(satStartLab, 0, 8);
        TextField satStart = new TextField();
        GridPane.setConstraints(satStart, 1, 8);
        Label satLengthLab = new Label("Duration");
        GridPane.setConstraints(satLengthLab, 2, 8);
        TextField satLength = new TextField();
        GridPane.setConstraints(satLength, 3, 8);

        Label sunStartLab = new Label("Sunday Start");
        GridPane.setConstraints(sunStartLab, 0, 9);
        TextField sunStart = new TextField();
        GridPane.setConstraints(sunStart, 1, 9);
        Label sunLengthLab = new Label("Duration");
        GridPane.setConstraints(sunLengthLab, 2, 9);
        TextField sunLength = new TextField();
        GridPane.setConstraints(sunLength, 3, 9);



        Button addUser = new Button("Update Availability");
        addUser.setMinHeight(50);
        addUser.setMinWidth(100);
        addUser.setOnAction(event -> {

            if(!inputParse(arrayListAggregator(monStart.getText(),monLength.getText(),tueStart.getText(), tueLength.getText(),wedStart.getText(),wedLength.getText(),thuStart.getText(),thuLength.getText(),friStart.getText(),friLength.getText(),satStart.getText(),satLength.getText(),sunStart.getText(),sunLength.getText())))
            {
                ConfirmBox.display("Availiblity formated Incorrectly", "Error! \nEnsure Availability is set as per the example");
            }
            else{
                Week week = new Week(monStart.getText(),monLength.getText(),tueStart.getText(), tueLength.getText(),wedStart.getText(),wedLength.getText(),thuStart.getText(),thuLength.getText(),friStart.getText(),friLength.getText(),satStart.getText(),satLength.getText(),sunStart.getText(),sunLength.getText());
                View.getInstance().getSMC().findEmployee(choices.getValue()).setEmployeeAvalibility(week);
                View.getInstance().getSMC().update();
                ConfirmBox.display("Added a new User", "Successfully updated " + View.getInstance().getCurrentUserName() + " availability!");
                stg.close();
            }
        });
        GridPane.setConstraints(addUser, 0, 10);
        Label errorText = new Label("");
        GridPane.setConstraints(errorText,1, 10);



        gridd.getChildren().addAll(choiceLab, choices,formatLab,formatExam,durLab, durExam, monStartLab,  monStart,monLengthLab,monLength, tueStartLab,
                tueStart,tueLengthLab,tueLength, wedStartLab, wedStart,wedLengthLab,wedLength, thuStartLab, thuStart,thuLengthLab,thuLength,
                friStartLab, friStart,friLengthLab,friLength, satStartLab, satStart,satLengthLab,satLength, sunStartLab, sunStart, sunLengthLab,sunLength, addUser , errorText); //postCodeLab, postCode,

        Scene scene = new Scene(gridd, 600, 600);
        scene.getStylesheets().add("ManageUsersCreateUsers.css");
        stg.setScene(scene);
        stg.setMinWidth(900);
        stg.show();

    }

    public static boolean inputParse(ArrayList<String> a){
        for(int i = 0 ; i < a.size() ; i = i + 2){
            try {
                Integer.parseInt(a.get(i));
                Integer.parseInt(a.get(i+1));
            } catch(NumberFormatException e){
                return false;
            }
            if(!((24 - Integer.parseInt(a.get(i+1)) - Integer.parseInt(a.get(i))) > 0 )){
                    return false;
            }
        }
        return true;
    }

    public static ArrayList<String> arrayListAggregator(String m1, String m2, String t1, String t2, String w1, String w2, String tt1,
                                                        String tt2, String f1, String f2, String s1, String s2, String ss1, String ss2 ){
        ArrayList<String> a = new ArrayList<>();
        a.add(m1); a.add(m2); a.add(t1); a.add(t2);
        a.add(w1); a.add(w2); a.add(tt1); a.add(tt2);
        a.add(f1); a.add(f2); a.add(s1); a.add(s2);
        a.add(ss1); a.add(ss2);
        return a;
    }

    public static void displayDeleteUserWindow () throws IOException{
        Stage stg = new Stage();
        Pane pane = new Pane();


        Label title = new Label("Delete a User");
        title.setLayoutX(150); title.setLayoutY(0);
        pane.getChildren().add(title);

        TableView<String> table = new TableView<>();

        TableColumn<String, String> userNameColumn = new TableColumn<>("Username");
        userNameColumn.setMinWidth(125);
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("UserName"));

        table.setItems(addUsers());
        table.getColumns().addAll(userNameColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setLayoutX(10); table.setLayoutY(50);
        pane.getChildren().add(table);

        Button delete = new Button("Delete Selected User");
        delete.setMinWidth(30); delete.setMinHeight(70); //delete.setStyle();
        delete.setOnAction(event -> {
            //try {
                String user = table.getSelectionModel().getSelectedItem();
                //boolean del = ConfirmBox.yesOrNo("Delete User?", "Are you sure you want to delete\n" + emp.getFirstName() + " " + emp.getLastName() + "?");
                //if (!del) return;
                //else updateTable(table);
            //}catch (IOException e){}
        });

        delete.setLayoutX(550); delete.setLayoutY(50);
        pane.getChildren().add(delete);

        Scene scene = new Scene(pane, 700, 500);
        //scene.getStylesheets().add("ManageUsersDeleteUsers.css");
        stg.setScene(scene);
        stg.show();
    }

    private static ObservableList<String> addUsers (){
        ObservableList<String> users = FXCollections.observableArrayList();
        ArrayList<Employee> a =  View.getInstance().getEmployeeList();
        for(int i = 0 ; i < a.size() ; i++){
            if (!(a.get(i).getUserName().equals("Admin"))) {
                System.out.println(a.get(i).getUserName());
                users.add(a.get(i).getUserName());
            }
        }

        return users;
    }

    public static void updateTable(TableView<String> table) throws IOException{
        ObservableList<String> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        String user = table.getSelectionModel().getSelectedItem();
        productSelected.forEach(allProducts::remove);
        try {
            removeUserFromFile(user);
        }
        catch (Exception e) {}
    }

    public static void removeUserFromFile(String user){

        // Method to delete a user from a file, or 'deregister'.
    }
}