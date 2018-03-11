import java.util.*;

public class Date {

	private ArrayList<int[]> times;

    public Date(){
        times = null; //not done start of constructor
    }

    public void addTimes(int startTime, int length ) {  //length is in minutes 60 is 1 hour. Has to be multiple of 30
                                                       // startTime 11am is 660. I'm sorry. a full day midnight 0 midday
            int[] temp = new int[2];
            temp[0] = startTime;
            temp[1] = length;
            times.add(temp);
            return;
    }
}