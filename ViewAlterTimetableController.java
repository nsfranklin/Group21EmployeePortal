import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAlterTimetableController implements Initializable{

    @FXML private ChoiceBox<String> chm1, chm2, chm3, chm4, chm5, chm6, chm7, chm8, chm9;
    @FXML private ChoiceBox<String> cht1, cht2, cht3, cht4, cht5, cht6, cht7, cht8, cht9;
    @FXML private ChoiceBox<String> chw1, chw2, chw3, chw4, chw5, chw6, chw7, chw8, chw9;
    @FXML private ChoiceBox<String> chtt1, chtt2, chtt3, chtt4, chtt5, chtt6, chtt7, chtt8, chtt9;
    @FXML private ChoiceBox<String> chf1, chf2, chf3, chf4, chf5, chf6, chf7, chf8, chf9;
    @FXML private ChoiceBox<String> chs1, chs2, chs3, chs4, chs5, chs6, chs7, chs8, chs9;
    @FXML private ChoiceBox<String> chss1, chss2, chss3, chss4, chss5, chss6, chss7, chss8, chss9;
    @FXML private Button update;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> al = new ArrayList<>();
        al.add("emp1"); al.add("emp2"); al.add("emp3"); al.add("emp4");
        for (int i=0; i<4; i++) {
            chm1.getItems().add(al.get(i)); chm2.getItems().add(al.get(i)); chm3.getItems().add(al.get(i));
            chm4.getItems().add(al.get(i)); chm5.getItems().add(al.get(i)); chm6.getItems().add(al.get(i));
            chm7.getItems().add(al.get(i)); chm8.getItems().add(al.get(i)); chm8.getItems().add(al.get(i));
            cht1.getItems().add(al.get(i)); cht2.getItems().add(al.get(i)); cht3.getItems().add(al.get(i));
            cht4.getItems().add(al.get(i)); cht5.getItems().add(al.get(i)); cht6.getItems().add(al.get(i));
            cht7.getItems().add(al.get(i)); cht8.getItems().add(al.get(i)); cht9.getItems().add(al.get(i));
            chw1.getItems().add(al.get(i)); chw2.getItems().add(al.get(i)); chw3.getItems().add(al.get(i));
            chw4.getItems().add(al.get(i)); chw5.getItems().add(al.get(i)); chw6.getItems().add(al.get(i));
            chw7.getItems().add(al.get(i)); chw8.getItems().add(al.get(i)); chw9.getItems().add(al.get(i));
            chtt1.getItems().add(al.get(i)); chtt2.getItems().add(al.get(i)); chtt3.getItems().add(al.get(i));
            chtt4.getItems().add(al.get(i)); chtt5.getItems().add(al.get(i)); chtt6.getItems().add(al.get(i));
            chtt7.getItems().add(al.get(i)); chtt8.getItems().add(al.get(i)); chtt9.getItems().add(al.get(i));
            chf1.getItems().add(al.get(i)); chf2.getItems().add(al.get(i)); chf3.getItems().add(al.get(i));
            chf4.getItems().add(al.get(i)); chf5.getItems().add(al.get(i)); chf6.getItems().add(al.get(i));
            chf7.getItems().add(al.get(i)); chf8.getItems().add(al.get(i)); chf9.getItems().add(al.get(i));
            chs1.getItems().add(al.get(i)); chs2.getItems().add(al.get(i)); chs3.getItems().add(al.get(i));
            chs4.getItems().add(al.get(i)); chs5.getItems().add(al.get(i)); chs6.getItems().add(al.get(i));
            chs7.getItems().add(al.get(i)); chs8.getItems().add(al.get(i)); chs9.getItems().add(al.get(i));
            chss1.getItems().add(al.get(i)); chss2.getItems().add(al.get(i)); chss3.getItems().add(al.get(i));
            chss4.getItems().add(al.get(i)); chss5.getItems().add(al.get(i)); chss6.getItems().add(al.get(i));
            chss7.getItems().add(al.get(i)); chss8.getItems().add(al.get(i)); chss9.getItems().add(al.get(i));
        }
    }

    public void updateTimetable (){
        if (!chm1.getSelectionModel().isEmpty()) //chm1.getValue(); // needs to be stored somewhere
        if (!chm2.getSelectionModel().isEmpty()) chm2.getValue(); // needs to be stored somewhere
        if (!chm3.getSelectionModel().isEmpty()) chm3.getValue();
        if (!chm4.getSelectionModel().isEmpty()) chm4.getValue();
        if (!chm5.getSelectionModel().isEmpty()) chm5.getValue();
        if (!chm6.getSelectionModel().isEmpty()) chm6.getValue();
        if (!chm7.getSelectionModel().isEmpty()) chm7.getValue();
        if (!chm8.getSelectionModel().isEmpty()) chm8.getValue();
        if (!chm9.getSelectionModel().isEmpty()) chm9.getValue();
        if (!cht1.getSelectionModel().isEmpty()) cht1.getValue();
        if (!cht2.getSelectionModel().isEmpty()) cht2.getValue();
        if (!cht3.getSelectionModel().isEmpty()) cht3.getValue();
        if (!cht4.getSelectionModel().isEmpty()) cht4.getValue();
        if (!cht5.getSelectionModel().isEmpty()) cht5.getValue();
        if (!cht6.getSelectionModel().isEmpty()) cht6.getValue();
        if (!cht7.getSelectionModel().isEmpty()) cht7.getValue();
        if (!cht8.getSelectionModel().isEmpty()) cht8.getValue();
        if (!cht9.getSelectionModel().isEmpty()) cht9.getValue();
        if (!chw1.getSelectionModel().isEmpty()) chw1.getValue();
        if (!chw2.getSelectionModel().isEmpty()) chw2.getValue();
        if (!chw3.getSelectionModel().isEmpty()) chw3.getValue();
        if (!chw4.getSelectionModel().isEmpty()) chw4.getValue();
        if (!chw5.getSelectionModel().isEmpty()) chw5.getValue();
        if (!chw6.getSelectionModel().isEmpty()) chw6.getValue();
        if (!chw7.getSelectionModel().isEmpty()) chw7.getValue();
        if (!chw8.getSelectionModel().isEmpty()) chw8.getValue();
        if (!chw9.getSelectionModel().isEmpty()) chw9.getValue();
        if (!chtt1.getSelectionModel().isEmpty()) chtt1.getValue();
        if (!chtt2.getSelectionModel().isEmpty()) chtt2.getValue();
        if (!chtt3.getSelectionModel().isEmpty()) chtt3.getValue();
        if (!chtt4.getSelectionModel().isEmpty()) chtt4.getValue();
        if (!chtt5.getSelectionModel().isEmpty()) chtt5.getValue();
        if (!chtt6.getSelectionModel().isEmpty()) chtt6.getValue();
        if (!chtt7.getSelectionModel().isEmpty()) chtt7.getValue();
        if (!chtt8.getSelectionModel().isEmpty()) chtt8.getValue();
        if (!chtt9.getSelectionModel().isEmpty()) chtt9.getValue();
        if (!chf1.getSelectionModel().isEmpty()) chf1.getValue();
        if (!chf2.getSelectionModel().isEmpty()) chf2.getValue();
        if (!chf3.getSelectionModel().isEmpty()) chf3.getValue();
        if (!chf4.getSelectionModel().isEmpty()) chf4.getValue();
        if (!chf5.getSelectionModel().isEmpty()) chf5.getValue();
        if (!chf6.getSelectionModel().isEmpty()) chf6.getValue();
        if (!chf7.getSelectionModel().isEmpty()) chf7.getValue();
        if (!chf8.getSelectionModel().isEmpty()) chf8.getValue();
        if (!chf9.getSelectionModel().isEmpty()) chf9.getValue();
        if (!chs1.getSelectionModel().isEmpty()) chs1.getValue();
        if (!chs2.getSelectionModel().isEmpty()) chs2.getValue();
        if (!chs3.getSelectionModel().isEmpty()) chs3.getValue();
        if (!chs4.getSelectionModel().isEmpty()) chs4.getValue();
        if (!chs5.getSelectionModel().isEmpty()) chs5.getValue();
        if (!chs6.getSelectionModel().isEmpty()) chs6.getValue();
        if (!chs7.getSelectionModel().isEmpty()) chs7.getValue();
        if (!chs8.getSelectionModel().isEmpty()) chs8.getValue();
        if (!chs9.getSelectionModel().isEmpty()) chs9.getValue();
        if (!chss1.getSelectionModel().isEmpty()) chss1.getValue();
        if (!chss2.getSelectionModel().isEmpty()) chss2.getValue();
        if (!chss3.getSelectionModel().isEmpty()) chss3.getValue();
        if (!chss4.getSelectionModel().isEmpty()) chss4.getValue();
        if (!chss5.getSelectionModel().isEmpty()) chss5.getValue();
        if (!chss6.getSelectionModel().isEmpty()) chss6.getValue();
        if (!chss7.getSelectionModel().isEmpty()) chss7.getValue();
        if (!chss8.getSelectionModel().isEmpty()) chss8.getValue();
        if (!chss9.getSelectionModel().isEmpty()) chss9.getValue();


    }
}