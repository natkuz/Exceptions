import java.util.Arrays;

// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен частному элементов 
// двух входящих массивов в той же ячейке. Если длины массивов не равны, 
// необходимо как-то оповестить пользователя. 
// Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - 
// RuntimeException, т.е. ваше.

public class exThree {
    public static void main(String[] args) {
        // int[] arrOne = new int[]{1, 9, 0};
        // int[] arrTwo = new int[]{8, 4, 0};
        // System.out.println(Arrays.toString(arrayQuotient(arrOne, arrTwo)));

        // int[] arrOne = new int[]{1, 9, 0};
        // int[] arrTwo = new int[]{8, 4, 6, 1};
        // System.out.println(Arrays.toString(arrayQuotient(arrOne, arrTwo)));

        int[] arrOne = new int[]{1, 9, 0};
        int[] arrTwo = new int[]{8, 4, 6};
        System.out.println(Arrays.toString(arrayQuotient(arrOne, arrTwo)));
    }

    public static Object[] arrayQuotient(int[] arrOne, int[] arrTwo) {
        Object[] array = new Object[arrOne.length];

        if (arrOne.length == arrTwo.length) {
            for (int i = 0; i < array.length; i++) {
                try {
                    array[i] = arrOne[i] / arrTwo[i];
                } catch (Exception e) {
                    return new Object[]{"Присутствует деление на 0"};
                }                
            }
            return array;
        }
        else throw new RuntimeException("Массивы имеют разную длину"); 
    }
}
