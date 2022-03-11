import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LSA {

    public static String[] Alphabet = "YnkX^vw1234567890".split("");
    public static String[] Nums = "1234567890".split("");

    public static String consoleInput() {
        System.out.println("Введите ЛСА: ");
        Scanner scn = new Scanner(System.in);
        String entrance = scn.nextLine();
        if (!checkEntrance(entrance)) {
            System.out.println("\nПовторите ввод: ");
            entrance = consoleInput();
        }
        return entrance;
    }

    public static String fileInput(String entrance) {
        StringBuilder result = new StringBuilder();

        try (FileReader reader = new FileReader(entrance)) {
            FileInputStream fis = new FileInputStream(entrance);
            int c;
            char[] buff = new char[fis.available()];

            while ((c = reader.read(buff)) > 0) {
                if (c < buff.length + 1) {
                    buff = Arrays.copyOf(buff, c);
                    result.append(buff);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        if (!checkEntrance(result.toString())) {
            System.out.println("Проверьте содержимое файла и повторите попытку снова");
            System.exit(0);
        }
        return result.toString();
    }

    public static boolean checkEntrance(String str) {
        if (str.startsWith("Yn")) {
            if (str.endsWith("Yk")) {
                str = str.substring(2, str.length() - 2);
                str = str + "*";
                String[] arrStr = str.split("");
                String temp = "";
                int i = 0;
                int check = 0;
                while (i != arrStr.length) {
                    temp = "";
                    if (arrStr[i].equals("X")) {
                        int j = i + 1;
                        while (Character.isDigit(arrStr[j].charAt(0))) {
                            check++;
                            j++;
                        }
                        if (j < i + 2) {
                            System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле Х должено идти число!");
                            return false;
                        }
                        check = 0;
                        System.out.println(arrStr[j]);
                        if (arrStr[j].equals("^")) {
                            j++;
                            i = j;
                            while (Character.isDigit(arrStr[j].charAt(0))) {
                                check++;
                                j++;
                            }
                            if (j < i + 1) {
                                System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле стрелки вверх должно идти число!");
                                return false;
                            }
                        } else {
                            System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле X должна идти стрелка вверх!");
                            return false;
                        }
                        i = j;
                    }
                    if (arrStr[i].equals("Y")) {
                        int j = i + 1;
                        while (Character.isDigit(arrStr[j].charAt(0))) {
                            check++;
                            j++;
                        }
                        if (j < i + 2) {
                            System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле Y должено идти число!");
                            return false;
                        }
                        i = j;
                    }
                    if (arrStr[i].equals("v")) {
                        int j = i + 1;
                        while (Character.isDigit(arrStr[j].charAt(0))) {
                            check++;
                            j++;
                        }
                        if (j < i + 2) {
                            System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле стрелки вниз должено идти число!");
                            return false;
                        }
                        i = j;
                    }
                    if (arrStr[i].equals("W")) {
                        int j = i + 1;
                        if (arrStr[j].equals("^")) {
                            j++;
                            i = j;
                            while (Character.isDigit(arrStr[j].charAt(0))) {
                                check++;
                                j++;
                            }
                            if (j < i + 1) {
                                System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле стрелки вниз должено идти число!");
                                return false;
                            }
                        } else {
                            System.out.println("Ошибка под индексом " + (j + 2) +
                                    "\nПосле безусловного перехода должена идти стрелка вверх!");
                            return false;
                        }
                        i = j;
                    }
                    if(arrStr[i].equals("*")){
                        return true;
                    }
                }
            } else {
                System.out.println("Ошибка под индексом " + (str.length() - 1) + "\nСтрока должна кончаться Yk");
                return false;
            }
            return true;
        } else {
            System.out.println("Ошибка под индексом " + 1 + "\nСтрока должна кончаться Yk");
            return false;
        }
    }

}
