import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewTimetableController implements Initializable{

    @FXML private Label m1, m2, m3, m4, m5, m6, m7, m8, m9, t1, t2, t3, t4, t5, t6, t7, t8, t9;
    @FXML private Label w1, w2, w3, w4, w5, w6, w7, w8, w9, tt1, tt2, tt3, tt4, tt5, tt6, tt7, tt8, tt9;
    @FXML private Label f1, f2, f3, f4, f5, f6, f7 ,f8, f9, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    @FXML private Label ss1, ss2, ss3, ss4, ss5, ss6, ss7, ss8, ss9;
    @FXML private ChoiceBox<String> selectUser;
    @FXML private Button update;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setTimeTable();

    }

    public void setTimeTable(){
        for(int i = 0 ; i < View.getInstance().getEmployeeList().size() ; i++){
            selectUser.getItems().add(View.getInstance().getEmployeeList().get(i).getUserName());
        }
        selectUser.getItems().add("Complete Schedule");
        selectUser.setValue("Complete Schedule");
        ArrayList<Label> mon = new ArrayList<Label>();
        mon.add(m1);
        mon.add(m2);
        mon.add(m3);
        mon.add(m4);
        mon.add(m5);
        mon.add(m6);
        mon.add(m7);
        mon.add(m8);
        mon.add(m9);
        ArrayList<Label> tue = new ArrayList<Label>();
        tue.add(t1);
        tue.add(t2);
        tue.add(t3);
        tue.add(t4);
        tue.add(t5);
        tue.add(t6);
        tue.add(t7);
        tue.add(t8);
        tue.add(t9);
        ArrayList<Label> wed = new ArrayList<Label>();
        wed.add(w1);
        wed.add(w2);
        wed.add(w3);
        wed.add(w4);
        wed.add(w5);
        wed.add(w6);
        wed.add(w7);
        wed.add(w8);
        wed.add(w9);
        ArrayList<Label> thu = new ArrayList<Label>();
        thu.add(tt1);
        thu.add(tt2);
        thu.add(tt3);
        thu.add(tt4);
        thu.add(tt5);
        thu.add(tt6);
        thu.add(tt7);
        thu.add(tt8);
        thu.add(tt9);
        ArrayList<Label> fri = new ArrayList<Label>();
        fri.add(f1);
        fri.add(f2);
        fri.add(f3);
        fri.add(f4);
        fri.add(f5);
        fri.add(f6);
        fri.add(f7);
        fri.add(f8);
        fri.add(f9);
        ArrayList<Label> sat = new ArrayList<Label>();
        sat.add(s1);
        sat.add(s2);
        sat.add(s3);
        sat.add(s4);
        sat.add(s5);
        sat.add(s6);
        sat.add(s7);
        sat.add(s8);
        sat.add(s9);
        ArrayList<Label> sun = new ArrayList<Label>();
        sun.add(ss1);
        sun.add(ss2);
        sun.add(ss3);
        sun.add(ss4);
        sun.add(ss5);
        sun.add(ss6);
        sun.add(ss7);
        sun.add(ss8);
        sun.add(ss9);

        Week current = View.getInstance().getCurrentSchedule();

        this.updateView(mon,0);
        this.updateView(tue, 1);
        this.updateView(wed, 2);
        this.updateView(thu,3);
        this.updateView(fri,4);
        this.updateView(sat,5);
        this.updateView(sun,6);

        update.setOnAction(event -> {
            this.updateView(mon,0);
            this.updateView(tue, 1);
            this.updateView(wed, 2);
            this.updateView(thu,3);
            this.updateView(fri,4);
            this.updateView(sat,5);
            this.updateView(sun,6);
        });

    }

    public void updateView(ArrayList<Label> labels, int dayIndex ){
        AssignedDates current = (AssignedDates) View.getInstance().getCurrentSchedule().getDate(dayIndex);
        ArrayList<int[]> times = current.getTimes();
        ArrayList<String> users = current.getUserAssigned();


        for(int q = 0 ; q < labels.size() ; q++){
            labels.get(q).setText("");
        }

        for(int u = 0 ; u < users.size() ; u++){
            if(users.get(u) == null){
                users.remove(u);
            }
        }

        for(int i = 0 ; i < times.size() ; i++){
            System.out.println(i + " number of times");
            for(int j = (times.get(i)[0]/60)-9 ; j < (times.get(i)[1]/60) ; j++){
               if(selectUser.getValue().equals("Complete Schedule")) {
                    if (labels.get(j).getText().equals("")) {
                        labels.get(j).setText(labels.get(j).getText() + users.get(i));
                    } else {
                        labels.get(j).setText(labels.get(j).getText() + ", " + users.get(i));
                    }
               }else {
                   if (labels.get(j).getText().equals("") && users.get(j).equals(selectUser.getValue())) {
                           labels.get(j).setText(labels.get(j).getText() + users.get(i));
                   }
                   labels.get(j).setWrapText(true);
                   labels.get(j).setStyle("-fx-font: 8 arial");
               }
            }
        }
    }
}