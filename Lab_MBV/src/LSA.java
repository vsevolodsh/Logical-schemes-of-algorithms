
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LSA {

    public static String[] Alphabet = "YnkX^vw123456789".split("");
    public static String[] Nums = "123456789".split("");
    public String yArrray[];
    public String xArray[] = new String[255];
    public String numXArray[] = new String[255];
    public String numYArray[] = new String[255];


    public static String consoleImput() {
        System.out.println("Введите ЛСА: ");
        Scanner scn = new Scanner(System.in);
        String entrance = scn.nextLine();
        if (!checkEntrance(entrance)) {
            System.out.println("\nПовторите ввод: ");
            consoleImput();
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

    public String[] getAllX(String entrance) {

        int j = 0;
        String[] newStrArr = entrance.split("");
        for (int i = 0; i < newStrArr.length; i++) {
            if (newStrArr[i].equals("X")) {
                xArray[j] = newStrArr[i];
                j++;
            }
        }
        return xArray;
    }

    public String[] getAllNumAfterX(String entrance) {
        int j = 0;
        String[] newStrArr = entrance.split("");
        for (int i = 1; i < newStrArr.length; i++) {
            for (int k = 0; k < Nums.length; k++) {
                if (newStrArr[i].equals(Nums[k]) && newStrArr[i - 1].equals("X")) {
                    numXArray[j] = newStrArr[i];
                    j++;
                }
            }
        }
        return numXArray;
    }

    public String[] getAllNumAfterY(String entrance) {
        int j = 0;
        String[] newStrArr = entrance.split("");
        for (int i = 1; i < newStrArr.length; i++) {
            for (int k = 0; k < Nums.length; k++) {
                if (newStrArr[i - 1].equals("Y") && newStrArr[i].equals(Nums[k])) {
                    numYArray[j] = newStrArr[i];
                    j++;
                }
                if (newStrArr[i - 1].equals("Y") && newStrArr[i].equals("k"))
                {
                    numYArray[j] = newStrArr[i];
                    j++;
                }
            }
        }
        return numYArray;
    }

  

}
