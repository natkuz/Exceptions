import java.util.Arrays;
import java.util.Scanner;

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class exOne {
    public static void main(String[] args) {
        // System.out.println(nullPointerExcep(1, null));
        // negArrSizeExcep(-1);
        System.out.println(Arrays.toString(inputMismatchExcep()));
    }

    public static Integer nullPointerExcep(Integer x, Integer y) {
        return x * y;
    }

    public static int[] negArrSizeExcep(int size) {
        return new int[size];
    }

    public static int[] inputMismatchExcep() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите первое значение для массива:");
        Integer x = input.nextInt();
        System.out.println("Введите второе значение для массива:");
        Integer y = input.nextInt();
        System.out.println("Введите третье значение для массива:");
        Integer z = input.nextInt();
        input.close();
        return new int[]{x, y, z};
    }
}
