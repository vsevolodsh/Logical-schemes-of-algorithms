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

    private static boolean checkEntrance(String entrance) {
        boolean checkDone = true;
        String[] newStrArr = entrance.split("");
        boolean[] checkArr = new boolean[newStrArr.length];

        if (entrance.startsWith("Yn") && entrance.endsWith("Yk")) {
            for (int i = 0; i < newStrArr.length; i++) {
                for (int j = 0; j < Alphabet.length; j++) {

                    if (newStrArr[i].equals(Alphabet[j])) {
                        checkArr[i] = true;
                    }

                }
                if (!checkArr[i]) {
                    System.out.print("Символ номер " + (i + 1) + " неправильный; ");
                    checkDone = false;
                }
            }
        } else {
            System.out.println("Проверьте правильность ввода начального и конечного оператора");
            checkDone = false;
        }


        for (int i = 3; i < newStrArr.length - 1; i++) {
            char ch = newStrArr[i].charAt(0);
            if (newStrArr[i - 1].equals("Y")) {

                if (!(Character.isDigit(ch))) {
                    System.out.println("После Y должна ставиться какая-то цифра, проверьте элемент " + i);
                    checkDone = false;
                }

            }
            if (newStrArr[i - 1].equals("X")) {

                if (!(Character.isDigit(ch))) {
                    System.out.println("После X должна ставиться какая-то цифра, проверьте элемент " + i);
                    checkDone = false;
                }
            }
            if (newStrArr[i - 1].equals("v")) {

                if (!(Character.isDigit(ch))) {
                    System.out.println("После нижней стрелки должна ставиться какая-то цифра, проверьте элемент " + i);
                    checkDone = false;
                }
            }
            if (newStrArr[i - 1].equals("w")) {
                if ((!newStrArr[i].equals("^"))) {
                    System.out.println("После безусловного перехода w должна ставиться стрелка вверх, проверьте элемент " + i);
                }
                if (!(Character.isDigit(newStrArr[i + 1].charAt(0)))) {
                    System.out.println("После стрелки вверх должна ставиться какая-то цифра, проверьте элемент " + (i + 1));
                    checkDone = false;
                }
            }

        }
        return checkDone;
    }

}
