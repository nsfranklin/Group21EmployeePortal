import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable{

    @FXML private Label date, time;
    @FXML private Button submit;
    @FXML private TextField title;
    @FXML private TextArea message;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        time.setText(sdf.format(cal.getTime()));

        Date d = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE d MMM yyyy");
        date.setText(sdf1.format(d));

    }

    @FXML
    void submitClicked() {
        try {
            File file = new File("message.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(title.getText() + "," + message.getText() + "," + date.getText() + "," + time.getText());
            fw.close();
        }
        catch (IOException e){

        }
        ConfirmBox.display("Annoucement Added" , "Announcement successfully added");
        submit.getScene().getWindow().hide();
    }

}