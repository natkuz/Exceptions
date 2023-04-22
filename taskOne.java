import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class taskOne {
    public static void main(String[] args) {
        Scanner request = new Scanner(System.in);
        System.out.println("Enter fractional number");
        
        boolean flag = true;

        while (flag) {
            flag = false;
            try {
                Float num = Float.valueOf(request.nextLine());
                System.out.println(num);
            } catch (NumberFormatException e) {
                System.out.println("You enter not fractional number. Please, try again");
                flag = true;
            } 
        }
        request.close();
    }
}
