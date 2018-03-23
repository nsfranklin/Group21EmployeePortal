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
        users = View.getInstance().getUsernameList();
        for (int i=0; i<users.size(); i++) currentTypeMenu.getItems().add(users.get(i));
        ArrayList<String> types = new ArrayList<>();
        types.add("Part-Time Employee"); types.add("Full-Time Employee"); types.add("Manager");
        for (int j=0; j<types.size(); j++) newTypeMenu.getItems().add(types.get(j));

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

            }else if(newType.equals("Full-Time Employee")){

            }else if(newType.equals("Manager")){

            }
        }else if(View.getInstance().findEmployee(username).getEmployeeType().equals("PartTimeEmployee")){
            if(newType.equals("Part-Time Employee")){

            }else if(newType.equals("Full-Time Employee")){

            }else if(newType.equals("Manager")){

            }
        }else if(View.getInstance().findEmployee(username).getEmployeeType().equals("Manager")){
            if(newType.equals("Part-Time Employee")){

            }else if(newType.equals("Full-Time Employee")){

            }else if(newType.equals("Manager")){

            }
        }
    }
}