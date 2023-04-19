import java.util.Arrays;

// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен разности элементов 
// двух входящих массивов в той же ячейке. Если длины массивов не равны, 
// необходимо как-то оповестить пользователя.

public class exTwo {
    public static void main(String[] args) {
        // int[] arrOne = new int[]{1, 9, 0};
        // int[] arrTwo = new int[]{8, 4, 6};
        // System.out.println(Arrays.toString(arrayDifference(arrOne, arrTwo)));

        int[] arrOne = new int[]{1, 9, 0};
        int[] arrTwo = new int[]{8, 4, 6, 1};
        System.out.println(Arrays.toString(arrayDifference(arrOne, arrTwo)));
    }

    public static int[] arrayDifference(int[] arrOne, int[] arrTwo) {
        int[] array = new int[arrOne.length];

        if (arrOne.length == arrTwo.length) {
            for (int i = 0; i < array.length; i++) {
                array[i] = arrOne[i] - arrTwo[i];
            }
            return array;
        }
        else throw new RuntimeException("Массивы имеют разную длину"); 
    }
}
