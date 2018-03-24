import java.util.*;

public class DateImp {

	private ArrayList<int[]> times;

    public DateImp(int startTime, int length){ //the constructor used for importing data
        times = new ArrayList<>();
        int[] temp = new int[2];
        temp[0] = startTime;
        temp[1] = length;
        times.add(temp);
    }

    public DateImp(int[] startTime, int[] length){ //the constructor used for importing data for multiple entries per date
        times = new ArrayList<>();
        int[] temp = new int[2];
        for(int i  =  0 ; i < startTime.length ; i++) {
            temp[0] = startTime[i];
            temp[1] = length[i];
            times.add(temp);
        }
    }

    public DateImp(String[] startTime, String[] length){ //the constructor used for importing data for multiple entries per date
        times = new ArrayList<>();
        int[] temp = new int[2];
        for(int i  =  1 ; i < startTime.length ; i++) {
            temp[0] = Integer.parseInt(startTime[(i) - 1]);
            temp[1] = Integer.parseInt(length[(i) - 1]);
            times.add(temp);
        }
    }

    public DateImp(){
        times = new ArrayList<>();
    }

    public void addTimes(int startTime, int length ) {  //length is in minutes 60 is 1 hour. Has to be multiple of 30
                                                       // startTime 11am is 660. I'm sorry. a full day midnight 0 midday
            int[] temp = new int[2];
            temp[0] = startTime;
            temp[1] = length;
            times.add(temp);
    }

    public ArrayList<int[]> getTimes(){
        return this.times;
    }

}