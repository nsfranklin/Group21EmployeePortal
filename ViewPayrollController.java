import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewPayrollController implements Initializable{
    @FXML private Label currentDate; @FXML private Pane background;
    @FXML private Label employeeName; @FXML private Label dateOfPayment;
    @FXML private Label totalEarned; @FXML private Label totalDeductions;
    @FXML private Text netPay; @FXML private Label nationalInsurance;
    @FXML private Label incomeTax; @FXML private Label nationalInsuranceNumber;
    @FXML private Label hourlyRate; @FXML private Label hoursWorked;
    @FXML private Label staffID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy");
        currentDate.setText(sdf.format(d));
        background.setStyle("-fx-background-color: white");
        /*
        employeeName.setText(); dateOfPayment.setText();
        totalEarned.setText(); totalDeductions.setText();
        netPay.setText(); nationalInsurance.setText();
        hourlyRate.setText(); hoursWorked.setText();
        staffID.setText();
         */
    }
}