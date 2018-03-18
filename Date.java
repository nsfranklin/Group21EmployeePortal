import java.util.*;

public class Date {

	private ArrayList<int[]> times;

    public Date(int startTime, int length){ //the constructor used for importing data
        times = new ArrayList<>();
        int[] temp = new int[2];
        temp[0] = startTime;
        temp[1] = length;
        times.add(temp);
    }

    public Date(int[] startTime, int[] length){ //the constructor used for importing data for multiple entries per date
        times = new ArrayList<>();
        int[] temp = new int[2];
        for(int i  =  1 ; i < startTime.length*2 ; i = i + 2) {
            temp[0] = startTime[(i-1)/2];
            temp[1] = length[i/2];
            times.add(temp);
        }
    }

    public Date(String[] startTime, String[] length){ //the constructor used for importing data for multiple entries per date
        times = new ArrayList<>();
        int[] temp = new int[2];
        for(int i  =  2 ; i < startTime.length*2 ; i = i + 2) {
            temp[0] = Integer.parseInt(startTime[(i/2) - 1]);
            temp[1] = Integer.parseInt(length[(i/2) - 1]);
            times.add(temp);
        }
    }

    public Date(){
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