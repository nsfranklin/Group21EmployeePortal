import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAlterTimetableController implements Initializable{

    @FXML private Text title;
    @FXML private ChoiceBox<String> chm1, chm2, chm3, chm4, chm5, chm6, chm7, chm8, chm9;
    @FXML private ChoiceBox<String> cht1, cht2, cht3, cht4, cht5, cht6, cht7, cht8, cht9;
    @FXML private ChoiceBox<String> chw1, chw2, chw3, chw4, chw5, chw6, chw7, chw8, chw9;
    @FXML private ChoiceBox<String> chtt1, chtt2, chtt3, chtt4, chtt5, chtt6, chtt7, chtt8, chtt9;
    @FXML private ChoiceBox<String> chf1, chf2, chf3, chf4, chf5, chf6, chf7, chf8, chf9;
    @FXML private ChoiceBox<String> chs1, chs2, chs3, chs4, chs5, chs6, chs7, chs8, chs9;
    @FXML private ChoiceBox<String> chss1, chss2, chss3, chss4, chss5, chss6, chss7, chss8, chss9;
    @FXML private Button update;
    @FXML private Button approve;
    @FXML private ChoiceBox<String> EmployeeSelect;
    @FXML private ChoiceBox<String> mode;
    //@FXML private Label text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        approve.setOnAction(event -> {
            if(View.getInstance().getScheduler().approvable()){
                View.getInstance().getScheduler().approveSchedule();
                ConfirmBox.display("Approved", "Schedule approved");
                update.getScene().getWindow().hide();
            }else if(View.getInstance().findEmployee(View.getInstance().getCurrentUserName()).getEmployeeType().equals("Manager") ){
                ConfirmBox.display("Warning", "Schedule not approve doesn't follow rules well enough");
            }else{
                Boolean confirm = ConfirmBox.yesOrNo("Warning", "Schedule does not follow set rules. Approve?");
                if(confirm){
                    View.getInstance().getScheduler().approveSchedule();
                    ConfirmBox.display("Approved", "Schedule approved");
                    update.getScene().getWindow().hide();
                }
            }

        });
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
            if(singleSelectionCheck(mon,tue,wed,thu,fri,sat,sun)) {
                if (mode.getValue().equals("remove")) {
                    updateProvisionalScheduledRemove(mon, tue, wed, thu, fri, sat, sun);
                } else if (mode.getValue().equals("add")) {
                    updateProvisionalScheduleAdd(mon, tue, wed, thu, fri, sat, sun);
                }
            }
        });
    }

    public void updateView(ArrayList<ChoiceBox<String>> boxes, int dayIndex){
        AssignedDates current = (AssignedDates) View.getInstance().getScheduler().getUnapprovedSchedule().getDate(dayIndex);
        ArrayList<int[]> times = current.getTimes();
        ArrayList<String> users = current.getUserAssigned();

        for(int q = 0 ; q < boxes.size() ; q++){
            boxes.get(q).getItems().clear();
        }

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
            montemp = mon.get(i).getValue();
            if(!montemp.equals("add new user")){
            }
            else{
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
            unapprovedMonday.addUserTimes((monaddfound+9)*60, monaddlastfound*60, EmployeeSelect.getValue());
        }

        int tueaddfound = -1;
        int tueaddlastfound = -1;
        String tuetemp;
        for(int i = 0 ; i < tue.size() ; i++)
        {
            tuetemp = tue.get(i).getValue();
            if(!tuetemp.equals("add new user")){
            }
            else{
                if(tueaddfound == -1){
                    tueaddfound = i;
                    tueaddlastfound = 1;
                }
                else{
                    tueaddlastfound = i + 1 - tueaddfound;
                }
            }
        }
        if(tueaddfound > -1) {
            unapprovedTuesday.addUserTimes((tueaddfound+9)*60, tueaddlastfound*60, EmployeeSelect.getValue());
        }

        int wedaddfound = -1;
        int wedaddlastfound = -1;
        String wedtemp;
        for(int i = 0 ; i < wed.size() ; i++)
        {
            wedtemp = wed.get(i).getValue();
            if(!wedtemp.equals("add new user")){
            }
            else{
                if(wedaddfound == -1){
                    wedaddfound = i;
                    wedaddlastfound = 1;
                }
                else{
                    wedaddlastfound = i + 1 - wedaddfound;
                }
            }
        }
        if(wedaddfound > -1) {
            unapprovedWednesday.addUserTimes((wedaddfound+9)*60, wedaddlastfound*60, EmployeeSelect.getValue());
        }

        int thuaddfound = -1;
        int thuaddlastfound = -1;
        String thutemp;
        for(int i = 0 ; i < thu.size() ; i++)
        {
            thutemp = thu.get(i).getValue();
            if(!thutemp.equals("add new user")){
            }
            else{
                if(thuaddfound == -1){
                    thuaddfound = i;
                    thuaddlastfound = 1;
                }
                else{
                    thuaddlastfound = i + 1 - thuaddfound;
                }
            }
        }
        if(thuaddfound > -1) {
            unapprovedThursday.addUserTimes((thuaddfound+9)*60, thuaddlastfound*60, EmployeeSelect.getValue());
        }

        int friaddfound = -1;
        int friaddlastfound = -1;
        String fritemp;
        for(int i = 0 ; i < fri.size() ; i++)
        {
            fritemp = fri.get(i).getValue();
            if(!fritemp.equals("add new user")){
            }
            else{
                if(friaddfound == -1){
                    friaddfound = i;
                    friaddlastfound = 1;
                }
                else{
                    friaddlastfound = i + 1 - friaddfound;
                }
            }
        }
        if(friaddfound > -1) {
            unapprovedFriday.addUserTimes((friaddfound+9)*60, friaddlastfound*60, EmployeeSelect.getValue());
        }

        int sataddfound = -1;
        int sataddlastfound = -1;
        String sattemp;
        for(int i = 0 ; i < sat.size() ; i++)
        {
            sattemp = sat.get(i).getValue();
            if(!sattemp.equals("add new user")){
            }
            else{
                if(sataddfound == -1){
                    sataddfound = i;
                    sataddlastfound = 1;
                }
                else{
                    sataddlastfound = i + 1 - sataddfound;
                }
            }
        }
        if(sataddfound > -1) {
            unapprovedSaturday.addUserTimes((sataddfound+9)*60, sataddlastfound*60, EmployeeSelect.getValue());
        }

        int sunaddfound = -1;
        int sunaddlastfound = -1;
        String suntemp;
        for(int i = 0 ; i < sun.size() ; i++)
        {
            suntemp = sun.get(i).getValue();
            if(!suntemp.equals("add new user")){
            }
            else{
                if(sunaddfound == -1){
                    sunaddfound = i;
                    sunaddlastfound = 1;
                }
                else{
                    sunaddlastfound = i + 1 - sunaddfound;
                }
            }
        }
        if(sunaddfound > -1) {
            unapprovedSunday.addUserTimes((sunaddfound+9)*60, sunaddlastfound*60, EmployeeSelect.getValue());
        }
        
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(0,unapprovedMonday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(1,unapprovedTuesday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(2,unapprovedWednesday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(3,unapprovedThursday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(4,unapprovedFriday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(5,unapprovedSaturday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(6,unapprovedSunday);
        View.getInstance().getSMC().setScheduler(View.getInstance().getScheduler());
        View.getInstance().getSMC().update();
        this.updateView(mon,0);
        this.updateView(tue,1);
        this.updateView(wed,2);
        this.updateView(thu,3);
        this.updateView(fri,4);
        this.updateView(sat,5);
        this.updateView(sun,6);
    }

    public void updateProvisionalScheduledRemove(ArrayList<ChoiceBox<String>> mon, ArrayList<ChoiceBox<String>> tue, ArrayList<ChoiceBox<String>> wed, ArrayList<ChoiceBox<String>> thu, ArrayList<ChoiceBox<String>> fri, ArrayList<ChoiceBox<String>> sat,ArrayList<ChoiceBox<String>> sun){

        Week temp = View.getInstance().getScheduler().getUnapprovedSchedule();
        AssignedDates unapprovedMonday = (AssignedDates) temp.getDate(0);
        AssignedDates unapprovedTuesday = (AssignedDates) temp.getDate(1);
        AssignedDates unapprovedWednesday = (AssignedDates) temp.getDate(2);
        AssignedDates unapprovedThursday = (AssignedDates) temp.getDate(3);
        AssignedDates unapprovedFriday = (AssignedDates) temp.getDate(4);
        AssignedDates unapprovedSaturday = (AssignedDates) temp.getDate(5);
        AssignedDates unapprovedSunday = (AssignedDates) temp.getDate(6);



        String selected = EmployeeSelect.getValue();

        String montemp;
        int monaddfound = -1;
        for(int i = 0 ; i < mon.size() ; i++)
        {
            montemp = mon.get(i).getValue();
            if(!(montemp.equals(selected))){
            }
            else{

                    monaddfound = i;
            }
        }
        if(monaddfound > -1) {
        unapprovedMonday.removeUserTimes(selected);
        }

        String tuetemp;
        int tueaddfound = -1;
        for(int i = 0 ; i < tue.size() ; i++)
        {
            tuetemp = tue.get(i).getValue();
            if(!(tuetemp.equals(selected))){
            }
            else{
                tueaddfound = i;
            }
        }
        if(tueaddfound > -1) {
            unapprovedTuesday.removeUserTimes(selected);
        }

        String wedtemp;
        int wedaddfound = -1;
        for(int i = 0 ; i < wed.size() ; i++)
        {
            wedtemp = wed.get(i).getValue();
            if(!(wedtemp.equals(selected))){
            }
            else{
                wedaddfound = i;
            }
        }
        if(wedaddfound > -1) {
            unapprovedWednesday.removeUserTimes(selected);
        }

        String thutemp;
        int thuaddfound = -1;
        for(int i = 0 ; i < thu.size() ; i++)
        {
            thutemp = thu.get(i).getValue();
            if(!(thutemp.equals(selected))){
            }
            else{

                thuaddfound = i;
            }
        }
        if(thuaddfound > -1) {
            unapprovedThursday.removeUserTimes(selected);
        }

        String fritemp;
        int friaddfound = -1;
        for(int i = 0 ; i < fri.size() ; i++)
        {
            fritemp = fri.get(i).getValue();
            if(!(fritemp.equals(selected))){
            }
            else{
                friaddfound = i;
            }
        }
        if(friaddfound > -1) {
            unapprovedFriday.removeUserTimes(selected);
        }

        String sattemp;
        int sataddfound = -1;
        for(int i = 0 ; i < sat.size() ; i++)
        {
            sattemp = sat.get(i).getValue();
            if(!(sattemp.equals(selected))){
            }
            else{
                sataddfound = i;
            }
        }
        if(sataddfound > -1) {
            unapprovedSaturday.removeUserTimes(selected);
        }

        String suntemp;
        int sunaddfound = -1;
        for(int i = 0 ; i < sun.size() ; i++)
        {
            suntemp = sun.get(i).getValue();
            if(!(suntemp.equals(selected))){
            }
            else{
                sunaddfound = i;
            }
        }
        if(sunaddfound > -1) {
            unapprovedSunday.removeUserTimes(selected);
        }
        
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(0,unapprovedMonday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(1,unapprovedTuesday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(2,unapprovedWednesday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(3,unapprovedThursday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(4,unapprovedFriday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(5,unapprovedSaturday);
        View.getInstance().getScheduler().getUnapprovedSchedule().addDay(6,unapprovedSunday);
        View.getInstance().getSMC().setScheduler(View.getInstance().getScheduler());
        View.getInstance().getSMC().update();
        this.updateView(mon,0);
        this.updateView(tue,1);
        this.updateView(wed,2);
        this.updateView(thu,3);
        this.updateView(fri,4);
        this.updateView(sat,5);
        this.updateView(sun,6);
    }

    public Boolean singleSelectionCheck(ArrayList<ChoiceBox<String>> mon, ArrayList<ChoiceBox<String>> tue, ArrayList<ChoiceBox<String>> wed, ArrayList<ChoiceBox<String>> thu, ArrayList<ChoiceBox<String>> fri, ArrayList<ChoiceBox<String>> sat,ArrayList<ChoiceBox<String>> sun){
        String firstFound = "";
        if((EmployeeSelect.getValue() == null)  ||  (mode.getValue() == null)){
            System.out.println("Employee not selected or mode not selected");
            return false;
        }
        for(int i = 0 ; i < mon.size() ; i++){
            if((mon.get(i).getValue().equals("") && firstFound.equals(""))){

            }else if(!(mon.get(i).getValue().equals("")) && firstFound.equals("")){
                firstFound = mon.get(i).getValue();
            }else{
                if(!(mon.get(i).getValue().equals(firstFound)) && (!(mon.get(i).getValue().equals("")))){
                    System.out.println("incorrect entry");
                    return false;
                }
            }
        }

        for(int i = 0 ; i < tue.size() ; i++){
            if((tue.get(i).getValue().equals("") && firstFound.equals(""))){

            }else if(!(tue.get(i).getValue().equals("")) && firstFound.equals("")){
                firstFound = tue.get(i).getValue();
            }else{
                if(!(tue.get(i).getValue().equals(firstFound)) && (!(tue.get(i).getValue().equals("")))){
                    System.out.println("incorrect entry");
                    return false;
                }
            }
        }

        for(int i = 0 ; i < wed.size() ; i++){
            if((wed.get(i).getValue().equals("") && firstFound.equals(""))){

            }else if(!(wed.get(i).getValue().equals("")) && firstFound.equals("")){
                firstFound = wed.get(i).getValue();
            }else{
                if(!(wed.get(i).getValue().equals(firstFound)) && (!(wed.get(i).getValue().equals("")))){
                    System.out.println("incorrect entry");
                    return false;
                }
            }
        }

        for(int i = 0 ; i < thu.size() ; i++){
            if((thu.get(i).getValue().equals("") && firstFound.equals(""))){

            }else if(!(thu.get(i).getValue().equals("")) && firstFound.equals("")){
                firstFound = thu.get(i).getValue();
            }else{
                if(!(thu.get(i).getValue().equals(firstFound)) && (!(thu.get(i).getValue().equals("")))){
                    System.out.println("incorrect entry");
                    return false;
                }
            }
        }

        for(int i = 0 ; i < fri.size() ; i++){
            if((fri.get(i).getValue().equals("") && firstFound.equals(""))){

            }else if(!(fri.get(i).getValue().equals("")) && firstFound.equals("")){
                firstFound = fri.get(i).getValue();
            }else{
                if(!(fri.get(i).getValue().equals(firstFound)) && (!(fri.get(i).getValue().equals("")))){
                    System.out.println("incorrect entry");
                    return false;
                }
            }
        }

        for(int i = 0 ; i < sat.size() ; i++){
            if((sat.get(i).getValue().equals("") && firstFound.equals(""))){

            }else if(!(sat.get(i).getValue().equals("")) && firstFound.equals("")){
                firstFound = sat.get(i).getValue();
            }else{
                if(!(sat.get(i).getValue().equals(firstFound)) && (!(sat.get(i).getValue().equals("")))){
                    System.out.println("incorrect entry");
                    return false;
                }
            }
        }

        for(int i = 0 ; i < sun.size() ; i++){
            if((sun.get(i).getValue().equals("") && firstFound.equals(""))){

            }else if(!(sun.get(i).getValue().equals("")) && firstFound.equals("")){
                firstFound = sun.get(i).getValue();
            }else{
                if(!(sun.get(i).getValue().equals(firstFound)) && (!(sun.get(i).getValue().equals("")))){
                    System.out.println("incorrect entry");
                    return false;
                }
            }
        }

        if(mode.getValue().equals("add") && !firstFound.equals("add new user"))
        {
            System.out.println("adding mode selected yet employees entered in timetable");
            return false;
        }

        if(mode.getValue().equals("remove") && !firstFound.equals(EmployeeSelect.getValue())){
            System.out.println("remove mode selected yet employees entered in timetable don't match the selected employee");
            return false;
        }
        return true;
    }
}
