package util;

import java.util.ArrayList;

public interface Measurable{
    double getMeasure();

    public static double calcAvg(ArrayList<Measurable>list) {
       // is list empty?
       if (list.size() == 0) {
           return 0;
       }

       // iterate through list and calculate average.
       double sum = 0;
       for(Measurable item:list) {
           sum = sum + item.getMeasure();
       }

       // return the average value of the list.
       return sum / list.size();
   }
   

}