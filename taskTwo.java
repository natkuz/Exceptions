public class taskTwo {
    public static void main(String[] args) {
        int d = 0;
        int[] arr = new int[2];
        ex(arr, d);
        System.out.println(":)");
    }

    public static void ex(int[] intArray, int d) {
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
