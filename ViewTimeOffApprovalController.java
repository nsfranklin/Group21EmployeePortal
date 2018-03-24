import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;


public class ViewTimeOffApprovalController implements Initializable {
    @FXML
    private Label type;
    @FXML private Label startDate;
    @FXML private Label endDate;
    @FXML private Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        type.setText("Holiday"); // type.setText(Getter method to get the Request's type of holiday e.g. holiday, sickness or other);
        startDate.setText("02/05/2018"); // startDate.setText(Getter method to get the request's startDate (may need to convert data to string or vice versa) );
        endDate.setText("26/05/2018"); // endDate.setText(GEtter Method for Request's End Date (same as above));
        status.setText("Disapproved");

        /*
            if (Request in getApprovedRequestList)
            status.setText("Approved");

         */
    }
}
