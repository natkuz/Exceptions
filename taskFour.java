import java.util.Scanner;

// Разработайте программу, которая выбросит Exception, 
// когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

public class taskFour {
    public static void main(String[] args) {
        Scanner inStr = new Scanner(System.in);
        System.out.println("Введите любое значение");
        String str = inStr.nextLine();
        ex(str);
        inStr.close();
    }

    public static void ex(String str) {
        try {
            if (str.isEmpty()) throw new RuntimeException("Пустую строку вводить нельзя");
        } catch (RuntimeException e) {
            System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
        }   
    }
}
