import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewChangeUserAccountTypeController implements Initializable {

    @FXML private Label CurrentTypeLabel;
    @FXML private Button update;
    @FXML private Text newTypeMenuLabel;
    @FXML private ChoiceBox<String> currentTypeMenu;
    @FXML private ChoiceBox<String> newTypeMenu;

    @Override public void initialize(URL location, ResourceBundle resources) {
        newTypeMenu.hide();
        newTypeMenuLabel.setText("");
        CurrentTypeLabel.setText("");
        ArrayList<String> users = new ArrayList<>();
        if(View.getInstance().getCurrentUserName().equals("admin")) {
            users = View.getInstance().getUsernameList("admin");
        }else{
            users = View.getInstance().getUsernameList("Admin", "Manager");
        }
            for (int i=0; i<users.size(); i++) currentTypeMenu.getItems().add(users.get(i));
        ArrayList<String> types = new ArrayList<>();
        types.add("Part-Time Employee"); types.add("Full-Time Employee");
        if(View.getInstance().getCurrentUserName().equals("admin")){
            types.add("Manager");
        }
        for (int j=0; j<types.size(); j++) newTypeMenu.getItems().add(types.get(j));
        //this.update = new Button();
        update.setOnAction(event -> updateType());

    }

    public void choiceBoxChosen(){
        currentTypeMenu.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            CurrentTypeLabel.setText(View.getInstance().findEmployee(currentTypeMenu.getValue()).getEmployeeType());
            newTypeMenu.show();
            newTypeMenuLabel.setText("Type to change User to:");
        });
    }

    public void updateType (){
        String username = currentTypeMenu.getValue();
        String newType = newTypeMenu.getValue();

        if (View.getInstance().findEmployee(username).getEmployeeType().equals("Employee")){
            if(newType.equals("Part-Time Employee")){
               Manager m = (Manager) View.getInstance().getSMC().findEmployee(View.getInstance().getCurrentUserName());
               Employee e = View.getInstance().getSMC().findEmployee(username);
               m.changeEmployeeToPartTimeEmployee(e);
               View.getInstance().getSMC().update();
               ConfirmBox.display("Successful",username + " is now a Part-Time Employee");
               update.getScene().getWindow().hide();

            }else if(newType.equals("Full-Time Employee")){
                ConfirmBox.display("Error",username + " is already a Full-Time Employee");
            }else if(newType.equals("Manager")){
                Admin a = (Admin) View.getInstance().getSMC().findEmployee(View.getInstance().getCurrentUserName());
                Employee e = View.getInstance().getSMC().findEmployee(username);
                a.markEmployeeAsManager(e);
                View.getInstance().getSMC().update();
                ConfirmBox.display("Successful",username + " is now a Manager");
                update.getScene().getWindow().hide();
            }
        }else if(View.getInstance().findEmployee(username).getEmployeeType().equals("PartTimeEmployee")){
            if(newType.equals("Part-Time Employee")){
                ConfirmBox.display("Error",username + " is already a Part-Time Employee");
            }else if(newType.equals("Full-Time Employee")){
                Admin a = (Admin) View.getInstance().getSMC().findEmployee(View.getInstance().getCurrentUserName());
                PartTimeEmployee p = (PartTimeEmployee) View.getInstance().getSMC().findEmployee(username);
                a.changePartTimeEmployeeToEmployee(p);
                View.getInstance().getSMC().update();
                ConfirmBox.display("Successful",username + " is now a Full-Time Employee");
                update.getScene().getWindow().hide();

            }else if(newType.equals("Manager")){
                Admin a = (Admin) View.getInstance().getSMC().findEmployee(View.getInstance().getCurrentUserName());
                PartTimeEmployee p = (PartTimeEmployee) View.getInstance().getSMC().findEmployee(username);
                a.changePartTimeEmployeeToEmployee(p);
                View.getInstance().getSMC().update();
                Employee e = View.getInstance().getSMC().findEmployee(username);
                a.markEmployeeAsManager(e);
                View.getInstance().getSMC().update();
                ConfirmBox.display("Successful",username + " is now a Manager");
                update.getScene().getWindow().hide();
            }
        }else if(View.getInstance().findEmployee(username).getEmployeeType().equals("Manager")){
            if(newType.equals("Part-Time Employee")){
                Admin a = (Admin) View.getInstance().getSMC().findEmployee(View.getInstance().getCurrentUserName());
                Manager m = (Manager) View.getInstance().getSMC().findEmployee(username);
                a.unmarkEmployeeAsManager(m);
                View.getInstance().getSMC().update();
                Employee e = View.getInstance().getSMC().findEmployee(username);
                a.changeEmployeeToPartTimeEmployee(e);
                View.getInstance().getSMC().update();
                ConfirmBox.display("Successful",username + " is now a Part-Time Employee");
                update.getScene().getWindow().hide();


            }else if(newType.equals("Full-Time Employee")){
                Admin a = (Admin) View.getInstance().getSMC().findEmployee(View.getInstance().getCurrentUserName());
                Employee e = View.getInstance().getSMC().findEmployee(username);
                a.changeEmployeeToPartTimeEmployee(e);
                View.getInstance().getSMC().update();
                ConfirmBox.display("Successful",username + " is now a Full-Time Employee");
                update.getScene().getWindow().hide();
            }else if(newType.equals("Manager")){
                ConfirmBox.display("Error",username + " is already a Manager");

            }
        }
    }
}