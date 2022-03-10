import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LSA {

    public static String[] Alphabet = "YnkX^vw1234567890".split("");

    public static String consoleInput() {
        System.out.println("Введите ЛСА: ");
        Scanner scn = new Scanner(System.in);
        String entrance = scn.nextLine();
        if (!checkEntrance(entrance)) {
            System.out.println("\nПовторите ввод: ");
            consoleInput();
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
        }
        return str.toString();
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
        return checkDone;
    }
}
