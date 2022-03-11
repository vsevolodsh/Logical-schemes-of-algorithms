import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LSA {

    public static String[] Alphabet = "YnkX^vW1234567890".split("");

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

    public static String fileInput(String name) {
        StringBuilder str = new StringBuilder();

        try (FileReader reader = new FileReader(name)) {
            FileInputStream fis = new FileInputStream(name);
            int c;
            char[] buff = new char[fis.available()];

            while ((c = reader.read(buff)) > 0) {
                if (c < buff.length + 1) {
                    buff = Arrays.copyOf(buff, c);
                    str.append(buff);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return str.toString();
    }

    public static boolean checkEntrance(String str) {
        String[] newStrArr = str.split("");
        boolean[] checkArr = new boolean[newStrArr.length];
        if (str.startsWith("Yn") && str.endsWith("Yk")) {
            for (int i = 0; i < newStrArr.length; i++) {
                for (int j = 0; j < Alphabet.length; j++) {
                    if (newStrArr[i].equals(Alphabet[j])) {
                        checkArr[i] = true;
                    }
                }
                if (!checkArr[i]) {
                    System.out.print("Символ номер " + (i + 1) + " неправильный");
                    return false;
                }
            }

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
                        temp += arrStr[j];
                        check++;
                        j++;
                    }
                    if (j < i + 2) {
                        System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле Х должено идти число!");
                        return false;
                    }
                    check = 0;

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
                        System.out.println("Ошибка под индексом " + (j + 2) + "\nПосле X" + temp + " должна идти стрелка вверх!");
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
                if (arrStr[i].equals("*")) {
                    return true;
                }
            }
            return true;
        } else {
            System.out.println("Проверьте правильность ввода начального и конечного оператора");
            return false;
        }
    }
}
