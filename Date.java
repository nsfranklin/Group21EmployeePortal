import java.util.*;

public class Date {

	private ArrayList<int[]> times;

    public Date(int startTime, int length){ //the constructor used for importing data
        int[] temp = new int[2];
        temp[0] = startTime;
        temp[1] = length;
        times.add(temp);
    }

    public Date(int[] startTime, int[] length){ //the constructor used for importing data for multiple entries per date
        int[] temp = new int[2];
        for(int i  =  1 ; i < startTime.length*2 ; i = i + 2) {
             temp[0] = startTime[i-1];
            temp[1] = length[i];
            times.add(temp);
        }
    }

    public void addTimes(int startTime, int length ) {  //length is in minutes 60 is 1 hour. Has to be multiple of 30
                                                       // startTime 11am is 660. I'm sorry. a full day midnight 0 midday
            int[] temp = new int[2];
            temp[0] = startTime;
            temp[1] = length;
            times.add(temp);
    }
}