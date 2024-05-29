public class PartB {
    public static void main(String[] args) {
        String phrase = "Derryfield";
        int x;
        int c = 0;
        x = phrase.length();
        for(int i = 0; i < x; i++){
            String y = phrase.substring(c, i+1);
            System.out.print(y);
            System.out.print(" | ");
            c = c + 1;
        }
        System.out.println("");
        System.out.println("is the best!");
    }
}
