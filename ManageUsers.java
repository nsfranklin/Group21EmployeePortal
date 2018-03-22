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
import java.nio.file.Files;
import java.nio.file.Path;
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
        choices.getItems().addAll("Employee", "Part-Time Employee", "Manager", "Admin");
        choices.setValue("Employee");
        GridPane.setConstraints(choices,1, 2 );


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

        Label staffIDLab = new Label("Account Number:");
        GridPane.setConstraints(staffIDLab, 0, 6);
        TextField staffID = new TextField();
        GridPane.setConstraints(staffID, 1, 6);

        Label firstnameLab = new Label("Sort Code");
        GridPane.setConstraints(firstnameLab, 0, 7);
        TextField firstName = new TextField();
        GridPane.setConstraints(firstName, 1, 7);

        Label lastnameLab = new Label("Monday Start");
        GridPane.setConstraints(lastnameLab, 0, 8);
        TextField lastName = new TextField();
        GridPane.setConstraints(lastName, 1, 8);

        Label dobLab = new Label("Tuesday Start");
        GridPane.setConstraints(dobLab, 0, 9);
        TextField dob = new TextField();
        GridPane.setConstraints(dob, 1, 9);

        Label emailLab = new Label("Wednesday Start");
        GridPane.setConstraints(emailLab, 0, 10);
        TextField email = new TextField();
        GridPane.setConstraints(email, 1, 10);

        Label phoneNumberLab = new Label("Thursday Start");
        GridPane.setConstraints(phoneNumberLab, 0, 11);
        TextField phoneNumber = new TextField();
        GridPane.setConstraints(phoneNumber, 1, 11);

        Label addressLab = new Label("Friday Start");
        GridPane.setConstraints(addressLab, 0, 12);
        TextField address = new TextField();
        GridPane.setConstraints(address, 1, 12);
        Label friLengthLab = new Label("Duration");
        GridPane.setConstraints(friLengthLab, 2, 14);

        Label countryLab = new Label("Saturday Start");
        GridPane.setConstraints(countryLab, 0, 13);
        TextField country = new TextField();
        GridPane.setConstraints(country, 1, 13);
        Label satLengthLab = new Label("Duration");
        GridPane.setConstraints(sunLengthLab, 2, 13);

        Label cityLab = new Label("Sunday Start");
        GridPane.setConstraints(cityLab, 0, 14);
        TextField city = new TextField();
        GridPane.setConstraints(city, 1, 14);
        Label sunLengthLab = new Label("Duration");
        GridPane.setConstraints(sunLengthLab, 2, 14);

        //Label postCodeLab = new Label("Enter user's Post Code");
        //GridPane.setConstraints(postCodeLab, 0, 15);
        //TextField postCode = new TextField();
        //GridPane.setConstraints(postCode, 1, 15);

        Button addUser = new Button("Add User");
        addUser.setMinHeight(50);
        addUser.setMinWidth(100);
        addUser.setOnAction(event -> {
            if (!(password.getText().equals(password2.getText())))
                ConfirmBox.display("Passwords do not match!", "Error! \nEnsure the passwords are the same");
            else {
                createUser(username.getText(), password.getText(), choices, staffID.getText(), firstName.getText(), lastName.getText(), dob.getText(),
                        email.getText(), phoneNumber.getText(), address.getText(), country.getText(), city.getText(), "");
                ConfirmBox.display("Added a new User", "Successfully added " + username.getText() + " as a User!");
                stg.close();
            }
        });
        GridPane.setConstraints(addUser, 0, 16);



        gridd.getChildren().addAll(choiceLab, lab, choices, usernameLab, username, passwordLab, password, password2Lab, password2, staffIDLab, staffID,
                firstnameLab, firstName, lastnameLab, lastName, dobLab, dob, emailLab, email, phoneNumberLab, phoneNumber, addressLab, address,
                countryLab, country, cityLab, city,sunLengthLab, addUser); //postCodeLab, postCode,

        Scene scene = new Scene(gridd, 600, 600);
        scene.getStylesheets().add("ManageUsersCreateUsers.css");
        stg.setScene(scene);
        stg.setMinWidth(900);
        stg.show();

    }

    public static void createUser(String username, String password, ChoiceBox<String> choices, String staffID, String firstName, String lastName,
                                  String dob, String email, String phoneNumber, String address, String country, String city, String postCode){

       // Method to add new user's info to text file
    }

    public static void displayDeleteUserWindow () throws IOException{
        Stage stg = new Stage();
        Pane pane = new Pane();


        Label title = new Label("Delete a User");
        title.setLayoutX(150); title.setLayoutY(0);
        title.setStyle("-fx-font-size: 25pt;" + "-fx-font-family: Georgia, Times, \"Times New Roman\", serif;");
        pane.getChildren().add(title);

        TableView<EmployeeView> table = new TableView<>();


        TableColumn<EmployeeView, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setMinWidth(125);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<EmployeeView, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setMinWidth(125);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        TableColumn<EmployeeView, String> userNameColumn = new TableColumn<>("Username");
        userNameColumn.setMinWidth(125);
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("UserName"));


        TableColumn<EmployeeView, String> staffIdColumn = new TableColumn<>("Staff ID");
        staffIdColumn.setMinWidth(125);
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffID"));


        table.setItems(addUsers());
        table.getColumns().addAll(firstNameColumn, lastNameColumn, userNameColumn, staffIdColumn);

        table.setLayoutX(10); table.setLayoutY(50);
        pane.getChildren().add(table);

        Button delete = new Button("Delete Selected User");
        delete.setMinWidth(30); delete.setMinHeight(70); //delete.setStyle();
        delete.setOnAction(event -> {
            try {
                EmployeeView emp = table.getSelectionModel().getSelectedItem();
                boolean del = ConfirmBox.yesOrNo("Delete User?", "Are you sure you want to delete\n" + emp.getFirstName() + " " + emp.getLastName() + "?");
                if (!del) return;
                else updateTable(table);
            }catch (IOException e){}
        });

        delete.setLayoutX(550); delete.setLayoutY(50);
        pane.getChildren().add(delete);

        Scene scene = new Scene(pane, 700, 500);
        //scene.getStylesheets().add("ManageUsersDeleteUsers.css");
        stg.setScene(scene);
        stg.show();
    }

    private static ObservableList<EmployeeView> addUsers (){
        ObservableList<EmployeeView> users = FXCollections.observableArrayList();
        //Sample data
        users.add(new EmployeeView("q", "q", "q", "q", "q", "q", "q", "q",
                    "q", "q", "q", "q"));
        users.add(new EmployeeView("w", "w", "w", "w", "w", "w", "w", "w",
                "w", "w", "w", "w"));
        users.add(new EmployeeView("e", "e", "e", "e", "e", "e", "e", "e",
                "e", "e", "e", "e"));

        // Method needs to get all Employee records from file
        return users;
    }

    public static void updateTable(TableView<EmployeeView> table) throws IOException{
        ObservableList<EmployeeView> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        EmployeeView emp = table.getSelectionModel().getSelectedItem();
        productSelected.forEach(allProducts::remove);
        try {
            removeUserFromFile(emp);
        }
        catch (Exception e) {}
    }

    public static void removeUserFromFile(EmployeeView emp){

        // Method to delete a user from a file, or 'deregister'.
    }
}