import java.util.ArrayList;

public class Comb {
    public static void main(String[] args) {
        /*int[] values = {0, 7, 4, 3, 1};
        for(int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        */
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(2.0);
        list.add(1.5);
        list.add(3.0);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
