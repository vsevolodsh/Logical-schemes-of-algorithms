import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EnterX {
    public static String newStrConsX = "";
    public static String newStrAllX = "";
    public static int indexX = 0;
    public static int circleCount = 0;


    public static ArrayList<String> createArrayOfString(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] arrStr = str.split("");
        String temp = "";
        int i = 0;
        while (i != arrStr.length) {
            temp = "";

            if (arrStr[i].equals("Y")) {
                int j = i;
                temp += arrStr[j];
                j++;
                if (arrStr[j].equals("n") || arrStr[j].equals("k")) {
                    temp += arrStr[j];
                } else {
                    while (Character.isDigit(arrStr[j].charAt(0))) {
                        temp += arrStr[j];
                        j++;
                    }
                }
                arrayList.add(temp);
            }
            if (arrStr[i].equals("X")) {
                int j = i;
                temp += arrStr[j];
                j++;
                while (Character.isDigit(arrStr[j].charAt(0))) {
                    temp += arrStr[j];
                    j++;
                }
                temp += arrStr[j];
                j++;
                while (Character.isDigit(arrStr[j].charAt(0))) {
                    temp += arrStr[j];
                    j++;
                }
                arrayList.add(temp);
            }
            if (arrStr[i].equals("v")) {
                int j = i;
                temp += arrStr[j];
                j++;
                while (Character.isDigit(arrStr[j].charAt(0))) {
                    temp += arrStr[j];
                    j++;
                }
                arrayList.add(temp);
            }
            if (arrStr[i].equals("W")) {
                int j = i;
                temp += arrStr[j] + arrStr[j + 1];
                j += 2;
                while (Character.isDigit(arrStr[j].charAt(0))) {
                    temp += arrStr[j];
                    j++;
                }
                arrayList.add(temp);
            }
            i++;
        }
        return arrayList;
    }

    public static String consecutiveX(String entrance, int index) {
        ArrayList<String> etalonArr = createArrayOfString(entrance);
        for (int i = index; i < etalonArr.size(); i++) {
            index = i;
            String str = etalonArr.get(i);
            if (str.substring(0, 1).equals("Y")) {
                if (str.equals("Yk")) {
                    newStrConsX += str;
                    break;
                } else {
                    newStrConsX += str;
                    consecutiveX(entrance, index + 1);
                    break;
                }
            }

            if (str.substring(0, 1).equals("X")) {
                String numAfterX = str.substring(1, str.indexOf("^"));
                int gX = getX(numAfterX);
                if (gX == 0) {
                    String temp = "v" + str.substring(str.indexOf("^") + 1);
                    System.out.println("Промежуточный результат: " + newStrConsX);
                    consecutiveX(entrance, etalonArr.indexOf(temp) + 1);
                    break;
                } else if (gX == 1) {
                    System.out.println("Промежуточный результат: " + newStrConsX);
                    consecutiveX(entrance, index + 1);
                    break;
                } else {
                    System.out.println("Неверное значение X! Повторите ввод!");
                    consecutiveX(entrance, index);
                    break;
                }
            }

            if (str.substring(0, 1).equals("W")) {
                String temp = "v" + str.substring(str.indexOf("^") + 1);
                consecutiveX(entrance, etalonArr.indexOf(temp) + 1);
                break;
            }
        }
        return newStrConsX;
    }

    public static String allX(String entrance, int index, ArrayList<String> arrX) {
        if (circleCount>100){
            System.out.println("Программа попала в бесконечный цикл. Результат: ");
            return newStrAllX;
        }
        ArrayList<String> etalonArr = createArrayOfString(entrance);
        for (int i = index; i < etalonArr.size(); i++) {
            index = i;
            String str = etalonArr.get(i);
            if (str.substring(0, 1).equals("Y")) {
                if (str.equals("Yk")) {
                    newStrAllX += str;
                    break;
                } else {
                    newStrAllX += str;
                    allX(entrance, index + 1, arrX);
                    break;
                }
            }

            if (str.substring(0, 1).equals("X")) {
                circleCount++;
                if (arrX.get(Integer.parseInt(getNum(str))).equals("0")) {
                    String temp = "v" + str.substring(str.indexOf("^") + 1);
                    allX(entrance, etalonArr.indexOf(temp) + 1, arrX);
                    break;
                } else {
                    allX(entrance, index + 1, arrX);
                    break;
                }
            }

            if (str.substring(0, 1).equals("W")) {
                String temp = "v" + str.substring(str.indexOf("^") + 1);
                allX(entrance, etalonArr.indexOf(temp) + 1, arrX);
                break;
            }
        }
        return newStrAllX;
    }

    public static String allValueX(String entrance, int index, ArrayList<String> arrX) {
        if (circleCount>100){
            System.out.println("Программа попала в бесконечный цикл. Результат: ");
            return newStrAllX;
        }
        ArrayList<String> etalonArr = createArrayOfString(entrance);
        for (int i = index; i < etalonArr.size(); i++) {
            index = i;
            String str = etalonArr.get(i);
            if (str.substring(0, 1).equals("Y")) {
                if (str.equals("Yk")) {
                    newStrAllX += str;
                    break;
                } else {
                    newStrAllX += str;
                    allValueX(entrance, index + 1, arrX);
                    break;
                }
            }

            if (str.substring(0, 1).equals("X")) {
                if (arrX.get(indexX).equals("0")) {
                    indexX++;
                    String temp = "v" + str.substring(str.indexOf("^") + 1);
                    allValueX(entrance, etalonArr.indexOf(temp) + 1, arrX);
                    break;
                } else {
                    indexX++;
                    allValueX(entrance, index + 1, arrX);
                    break;
                }
            }

            if (str.substring(0, 1).equals("W")) {
                String temp = "v" + str.substring(str.indexOf("^") + 1);
                allValueX(entrance, etalonArr.indexOf(temp) + 1, arrX);
                break;
            }
        }
        return newStrAllX;
    }

    public static String getNum(String str) {
        char[] ch = str.toCharArray();
        int i = 1;
        String num = "";
        while (Character.isDigit(ch[i])) {
            num += ch[i];
            i++;
        }
        return num;
    }

    public static ArrayList<String> enterX() {
        System.out.println("Введите все X: ");
        Scanner scan = new Scanner(System.in);
        String[] x = scan.nextLine().split("");
        ArrayList<String> listX = new ArrayList<String>(Arrays.asList(x));
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals("0") && !x[i].equals("1")) {
                System.out.println("Неверное значение X под номером " + (i + 1) +
                        "\nЗначение х может принимать только 0 или 1.Повторите ввод!");
                listX = enterX();
                break;
            }
        }
        return listX;
    }
    //

    public static int getX(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите х%s:", str);
        String x = scan.nextLine();
        if(!x.equals("0") && !x.equals("1")){
            System.out.println("Значение х может принимать только 0 или 1. Повторите ввод.");
            x = String.valueOf(getX(str));
        }
        return Integer.parseInt(x);
    }
}
