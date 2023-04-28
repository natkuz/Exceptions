import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Напишите приложение, которое будет запрашивать у пользователя следующие данные 
// в произвольном порядке, разделенные пробелом: Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// дата_рождения - строка формата dd.mm.yyyy
// номер_телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству. 
// Если количество не совпадает с требуемым, вернуть код ошибки, обработать его 
// и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и 
// выделить из них требуемые параметры. Если форматы данных не совпадают, 
// нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. 
// Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
// в него в одну строку должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

// Не забудьте закрыть соединение с файлом.

// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
// пользователь должен увидеть стектрейс ошибки.

public class task {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner inPut = new Scanner(System.in);
        System.out.println("Enter with a space:\n\tsurname\n\tname\n\tpatronymic"
                            +"\n\tdate of birth in the format dd.mm.yyyy"
                            +"\n\tphone number (only numbers)"
                            +"\n\tgender - symbol f or m");
        String inputData = inPut.nextLine();
        inPut.close();

        String[] data = inputData.split(" ");
        ArrayList<String> dataIn = new ArrayList<>();
        for (String el : data) {
            dataIn.add(el);
        }

        if (checkCount(data) == -1) System.out.println("Less data entered than expected");
        else if (checkCount(data) == -2) System.out.println("Too much, added something extra");
        else if (checkCount(data) == 6) {
            String gender = "<" + gender(dataIn) + ">";
            dataIn.remove(gender(dataIn));
            String phone = "<" + phone(dataIn) + ">";
            dataIn.remove(phone(dataIn));
            String date = "<" + date(dataIn) + ">";
            dataIn.remove(date(dataIn));
            String surname = "<" + surname(dataIn) + ">";
            String fileName = surname(dataIn);
            dataIn.remove(surname(dataIn));
            String name = "<" + name(dataIn) + ">";
            dataIn.remove(name(dataIn));
            String patronymic = "<" + patronymic(dataIn) + ">";
            dataIn.remove(patronymic(dataIn));

            File f = new File(fileName);
            if (!f.exists())
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                }
            
            FileWriter fr = null;
            try {
                fr = new FileWriter(fileName,true);
                fr.write(surname);
                fr.write(name);
                fr.write(patronymic);
                fr.write(date);
                fr.write(phone);
                fr.write(gender);
                fr.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int checkCount(String[] arr) {
        if (arr.length < 6) return -1;
        if (arr.length > 6) return -2;
        return arr.length;
    }
        
    public static String gender(ArrayList<String> arr) {
        String gender = null;
        
        for (String el : arr) {
            if (el.length() == 1 && (el.equals("f") || el.equals("m"))) {
                gender = el;
                return gender;
            } 
        }
        throw new RuntimeException("Invalid gender");
    }
        
    public static String phone(ArrayList<String> arr) {
        String phone = null;
        for (String el : arr) {
            if (el.matches("[0-9]+")) {
                phone = el;
                return phone;
            }
        }
        throw new RuntimeException("Invalid phone number, only numbers needed");
    }

    public static String date(ArrayList<String> arr) {
        String date;
        for (String el : arr) {
            if (el.matches("(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).(19[0-9][0-9]|20[0-9][0-9])")) {
                date = el;
                return date;
            }
        }
        throw new RuntimeException("Invalid date format");
    }
    
    public static String surname(ArrayList<String> arr) {
        String surname;
        for (String el : arr) {
            if (el.matches("[a-zA-Z]+")) {
                surname = el;
                return surname;
            }
        }
        throw new RuntimeException("Last name must contain only latin characters");
    }

    public static String name(ArrayList<String> arr) {
        String name;
        for (String el : arr) {
            if (el.matches("[a-zA-Z]+")) {
                name = el;
                return name;
            }
        }
        throw new RuntimeException("The name must contain only latin characters");
    }

    public static String patronymic(ArrayList<String> arr) {
        String patronymic;
        for (String el : arr) {
            if (el.matches("[a-zA-Z]+")) {
                patronymic = el;
                return patronymic;
            }
        }
        throw new RuntimeException("Patronymic must contain only Latin characters");
    }
}