import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javax.swing.text.DateFormatter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class RequestTimeOffGuiController implements Initializable {
    @FXML private Label date;
    @FXML private Label time;
    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private ToggleGroup type;
    @FXML private RadioButton holiday;
    @FXML private RadioButton sickness;
    @FXML private RadioButton other;
    @FXML private Pane pane;
    @FXML private TextArea description;
    @FXML private Label errorText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        time.setText(sdf.format(cal.getTime()));
        //time.setText(Integer.toString(SystemManager.getTime()));                 should be this file - line above is sample!

        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE d MM yyyy");
        date.setText(sdf2.format(new Date()));
        pane.setStyle("-fx-background-color: #9bffc8;");



    }
    public void submit () throws InterruptedException{
        Date currentDate = new Date();
        String typee = "";
        String userName = View.getInstance().getCurrentUserName();
        if(startDate.getValue() != null && endDate.getValue() != null) {
            String startDatee = startDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String endDatee = endDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            try {
                if (holiday.isSelected()) {
                    typee = holiday.getText();
                } else if (sickness.isSelected()) {
                    typee = sickness.getText();
                } else {
                    typee = other.getText();
                }
                currentDate = new Date(); //SimpleDateFormat("dd/MM/yyyy").parse(date.getText());
                SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
            } catch (Exception e) {
            }
            if (parseEntry(currentDate, startDate.getValue(), endDate.getValue())) {
                Requests newRequest = new timeOff(currentDate, getTime(), typee, java.sql.Date.valueOf(startDate.getValue()), java.sql.Date.valueOf(endDate.getValue()), this.description.getText(), userName);
                View.getInstance().addRequest(newRequest);
                View.getInstance().getSMC().setRequestList(View.getInstance().getRequestList());
                View.getInstance().getSMC().update();
                ConfirmBox.display("Request Added", "Successfully added " + typee + " Request from " + java.sql.Date.valueOf(startDate.getValue()) + " - " + java.sql.Date.valueOf(endDate.getValue()));
                errorText.getScene().getWindow().hide();
                }
        }
        else{
            errorText.setText("Enter Dates of Request");
        }
        //close the window;
    }

    public Boolean parseEntry(Date currentDate,LocalDate startDate,LocalDate endDate){
        if(currentDate.after(java.sql.Date.valueOf(startDate))){
            errorText.setText("Start Date is before currentDate");
            return false;
        }
        if(java.sql.Date.valueOf(startDate).after(java.sql.Date.valueOf(endDate))){
            errorText.setText("Start Date is after endDate");
            return false;
        }
        return true;
    }

    public void close (){
        Platform.exit();
    }

    public int getTime(){
        String[] temp = LocalTime.now().toString().split(":");
        int local = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        return local;
    }

}
