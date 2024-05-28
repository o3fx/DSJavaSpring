import java.util.ArrayList;

public class DemoBlock{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Tom");
        list.add("Steph");
        list.add("Bill");

        for (String name:list) {
            System.out.println(name);
        }

    
        int[] values = {7, 8, 9, 10, 3, 4, 5};
        double sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int element:values) {
            sum += element;
            if (element > max) {
                max = element;
            }
        }

        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double avg = sum / values.length;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
        }

        
    }   
}