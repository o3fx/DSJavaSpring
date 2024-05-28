public class Hey {
    public static void main(String[] args) {
        public static int getInt() {
            try {
                return 1;
            } catch (Exception e) {
                return 2;
            } finally {
                return 3;
            }
        }
    
        public static void main(String[] args) {
            System.out.println(getInt());
        }
    
    
    }
}
