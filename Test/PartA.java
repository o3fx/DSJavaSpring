import java.util.ArrayList;

public class PartA {
    public static void main(String[] args) {
        double avg = 0;
        ArrayList<String> Name = new ArrayList<String>();
        Name.add("Steve");
        Name.add("Tracy");
        Name.add("James");
        Name.add("Elisa");
        Name.add("Michelle");
        Name.add("Jeremiah");
        for (int i = 0; i < Name.size(); i++){
            double x;
            int max = 5;
            System.out.print(Name.get(i));
            x = Name.get(i).length();
            avg = avg + x;
            System.out.print(" (" + (int)x + ")");
            if(max < x) {
                System.out.print(" <= MAX LENGTH");
            }
            System.out.println();
        }
        avg = avg/Name.size();
        System.out.println("-----");
        System.out.println("The average name length is " + avg + " charecters");



    }
}
