public class Hello {
    private static int value;

    public static void setValue(int newValue) {
        int value = newValue;
        System.out.println("value = " + value);
    }

    public static void main(String[] args) {
        System.out.println("value = " + value);
        setValue(77);
        System.out.println("value = " + value);
    }
}
