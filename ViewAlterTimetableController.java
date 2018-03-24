import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
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
    @FXML private ChoiceBox<String> EmployeeSelect;
    @FXML private ChoiceBox<String> mode;
    //@FXML private Label text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mode.getItems().addAll("remove" , "add");
        for(int i = 0 ; i < View.getInstance().getEmployeeList().size() ; i++){
            EmployeeSelect.getItems().add(View.getInstance().getEmployeeList().get(i).getUserName());
        }
        this.updateTimetable();
    }

    public void updateTimetable (){
        ArrayList<ChoiceBox<String>> mon = new ArrayList<ChoiceBox<String>>();
        mon.add(chm1);
        mon.add(chm2);
        mon.add(chm3);
        mon.add(chm4);
        mon.add(chm5);
        mon.add(chm6);
        mon.add(chm7);
        mon.add(chm8);
        mon.add(chm9);
        ArrayList<ChoiceBox<String>> tue = new ArrayList<ChoiceBox<String>>();
        tue.add(cht1);
        tue.add(cht2);
        tue.add(cht3);
        tue.add(cht4);
        tue.add(cht5);
        tue.add(cht6);
        tue.add(cht7);
        tue.add(cht8);
        tue.add(cht9);
        ArrayList<ChoiceBox<String>> wed = new ArrayList<ChoiceBox<String>>();
        wed.add(chw1);
        wed.add(chw2);
        wed.add(chw3);
        wed.add(chw4);
        wed.add(chw5);
        wed.add(chw6);
        wed.add(chw7);
        wed.add(chw8);
        wed.add(chw9);
        ArrayList<ChoiceBox<String>> thu = new ArrayList<ChoiceBox<String>>();
        thu.add(chtt1);
        thu.add(chtt2);
        thu.add(chtt3);
        thu.add(chtt4);
        thu.add(chtt5);
        thu.add(chtt6);
        thu.add(chtt7);
        thu.add(chtt8);
        thu.add(chtt9);
        ArrayList<ChoiceBox<String>> fri = new ArrayList<ChoiceBox<String>>();
        fri.add(chf1);
        fri.add(chf2);
        fri.add(chf3);
        fri.add(chf4);
        fri.add(chf5);
        fri.add(chf6);
        fri.add(chf7);
        fri.add(chf8);
        fri.add(chf9);
        ArrayList<ChoiceBox<String>> sat = new ArrayList<ChoiceBox<String>>();
        sat.add(chs1);
        sat.add(chs2);
        sat.add(chs3);
        sat.add(chs4);
        sat.add(chs5);
        sat.add(chs6);
        sat.add(chs7);
        sat.add(chs8);
        sat.add(chs9);
        ArrayList<ChoiceBox<String>> sun = new ArrayList<ChoiceBox<String>>();
        sun.add(chss1);
        sun.add(chss2);
        sun.add(chss3);
        sun.add(chss4);
        sun.add(chss5);
        sun.add(chss6);
        sun.add(chss7);
        sun.add(chss8);
        sun.add(chss9);


        this.updateView(mon,0);
        this.updateView(tue,1);
        this.updateView(wed,2);
        this.updateView(thu,3);
        this.updateView(fri,4);
        this.updateView(sat,5);
        this.updateView(sun,6);


        update.setOnAction(event -> {
            if(mode.getValue().equals("remove")){
                updateProvisionalScheduleAdd(mon, tue, wed, thu, fri, sat, sun);
            }else if(mode.getValue().equals("add")){
                updateProvisionalScheduleAdd(mon, tue, wed, thu, fri, sat, sun);
            }
        });
    }

    public void updateView(ArrayList<ChoiceBox<String>> boxes, int dayIndex){
        AssignedDates current = (AssignedDates) View.getInstance().getScheduler().getUnapprovedSchedule().getDate(dayIndex);
        ArrayList<int[]> times = current.getTimes();
        ArrayList<String> users = current.getUserAssigned();

        for(int u = 0 ; u < users.size() ; u++){
            if(users.get(u) == null){
                users.remove(u);
            }
        }
        for(int i = 0 ; i < times.size() ; i++){
            for(int j = (times.get(i)[0]/60)-9 ; j < (times.get(i)[1]/60) ; j++){
                boxes.get(j).getItems().add(users.get(i));
            }
        }
        for(int l = 0 ; l < 1 ; l++){
            for(int k = 0 ; k < 9 ; k++){
                boxes.get(k).getItems().add("add new user");
                boxes.get(k).getItems().add("");
                boxes.get(k).setValue("");
            }
        }
    }

    public void updateProvisionalScheduleAdd(ArrayList<ChoiceBox<String>> mon, ArrayList<ChoiceBox<String>> tue, ArrayList<ChoiceBox<String>> wed, ArrayList<ChoiceBox<String>> thu, ArrayList<ChoiceBox<String>> fri, ArrayList<ChoiceBox<String>> sat,ArrayList<ChoiceBox<String>> sun){

        Week temp = View.getInstance().getScheduler().getUnapprovedSchedule();
        AssignedDates unapprovedMonday = (AssignedDates) temp.getDate(0);
        AssignedDates unapprovedTuesday = (AssignedDates) temp.getDate(1);
        AssignedDates unapprovedWednesday = (AssignedDates) temp.getDate(2);
        AssignedDates unapprovedThursday = (AssignedDates) temp.getDate(3);
        AssignedDates unapprovedFriday = (AssignedDates) temp.getDate(4);
        AssignedDates unapprovedSaturday = (AssignedDates) temp.getDate(5);
        AssignedDates unapprovedSunday = (AssignedDates) temp.getDate(6);

        int monaddfound = -1;
        int monaddlastfound = -1;
        String montemp;
        for(int i = 0 ; i < mon.size() ; i++)
        {
            System.out.println(i);
            montemp = mon.get(i).getValue();
            if(!montemp.equals("add new user")){
            System.out.println(i +" add new user not found");
            }
            else{
                System.out.println(i + "Found");
                if(monaddfound == -1){
                    monaddfound = i;
                    monaddlastfound = 1;
                }
                else{
                    monaddlastfound = i + 1 - monaddfound;
                }
            }
        }
        if(monaddfound > -1) {
            System.out.println(EmployeeSelect.getValue());
            unapprovedMonday.addUserTimes((monaddfound+9)*60, monaddlastfound*60, EmployeeSelect.getValue());
        }


        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(0,unapprovedMonday);
        View.getInstance().getSMC().setScheduler(View.getInstance().getScheduler());
        View.getInstance().getSMC().update();

    }

    public Week updateProvisionalScheduledRemove(ArrayList<ChoiceBox<String>> mon, ArrayList<ChoiceBox<String>> tue, ArrayList<ChoiceBox<String>> wed, ArrayList<ChoiceBox<String>> thu, ArrayList<ChoiceBox<String>> fri, ArrayList<ChoiceBox<String>> sat,ArrayList<ChoiceBox<String>> sun){

        Week temp = View.getInstance().getScheduler().getUnapprovedSchedule();
        AssignedDates unapprovedMonday = (AssignedDates) temp.getDate(0);
        AssignedDates unapprovedTuesday = (AssignedDates) temp.getDate(1);
        AssignedDates unapprovedWednesday = (AssignedDates) temp.getDate(2);
        AssignedDates unapprovedThursday = (AssignedDates) temp.getDate(3);
        AssignedDates unapprovedFriday = (AssignedDates) temp.getDate(4);
        AssignedDates unapprovedSaturday = (AssignedDates) temp.getDate(5);
        AssignedDates unapprovedSunday = (AssignedDates) temp.getDate(6);


        for(int i = 0 ; i < mon.size() ; i++)
        {

        }

        return new Week();
    }

}
