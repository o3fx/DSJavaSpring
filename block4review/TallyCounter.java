public class TallyCounter {
    private int count = 0;
    public void setCount(int count1) {
        if (count1 < 0){
            System.err.println("Invalid count");
            this.count = count1;
        }
    }
}
