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

        type.setText(""); // type.setText(Getter method to get the Request's type of holiday e.g. holiday, sickness or other);
        startDate.setText(""); // startDate.setText(Getter method to get the request's startDate (may need to convert data to string or vice versa) );
        endDate.setText(""); // endDate.setText(GEtter Method for Request's End Date (same as above));
        status.setText("");

        this.findRequest();
        /*
            if (Request in getApprovedRequestList)
            status.setText("Approved");

         */
    }


    public void findRequest(){

        timeOff temp;
        for (int i = 0; i < View.getInstance().getApprovedRequestList().size(); i++) {
            temp = (timeOff) View.getInstance().getApprovedRequestList().get(i);
            if(temp.getUserName().equals(View.getInstance().getCurrentUserName())){
                type.setText(temp.getTimeOffType());
                startDate.setText(temp.getStartDate().toString());
                endDate.setText(temp.getEndDate().toString());
                status.setText("approved");
                return;
            }
        }

        for(int j = 0 ; j < View.getInstance().getRequestList().size() ; j++){
            temp = (timeOff) View.getInstance().getRequestList().get(j);
            if (temp.getUserName().equals(View.getInstance().getCurrentUserName())) {
                type.setText(temp.getTimeOffType());
                startDate.setText(temp.getStartDate().toString());
                endDate.setText(temp.getEndDate().toString());
                status.setText("Pending");
                return;
            }
        }
    }
}
