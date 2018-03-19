import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ChangePayrollDetailsController implements Initializable{
    @FXML private Pane background;
    @FXML private Label currentDatee; @FXML private TextField companyNameE;
    @FXML private TextField dateOfPaymentE; @FXML private TextField nationalInsuranceNumberE;
    @FXML private TextField hoursWorkedE; @FXML private TextField hourlyRateE;
    @FXML private TextField incomeTaxE; @FXML private TextField nationalInsuranceE;
    @FXML private TextField address1; @FXML private TextField address2;
    @FXML private TextField address3; @FXML private TextField address4;
    @FXML private Label totalEarned; @FXML private Label totalDeductions;
    @FXML private Label netPayy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy");
        currentDatee.setText(sdf.format(d));
        background.setStyle("-fx-background-color: white");
        /*
        employeeName.setText(); dateOfPayment.setText();
        totalEarned.setText(); totalDeductions.setText();
        netPay.setText(); nationalInsurance.setText();
        hourlyRate.setText(); hoursWorked.setText();
        staffID.setText();
         */
    }


    public void update (){
        totalEarned.setText(Double.toString(Double.parseDouble(hoursWorkedE.getText() ) * Double.parseDouble(hourlyRateE.getText() ) ) );
        totalDeductions.setText(Double.toString(Double.parseDouble(incomeTaxE.getText() ) + Double.parseDouble(nationalInsuranceE.getText() ) ) );
        netPayy.setText(Double.toString( Double.parseDouble(totalEarned.getText()) - Double.parseDouble(totalDeductions.getText() ) ) );
    }
}