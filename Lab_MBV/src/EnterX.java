import java.util.ArrayList;
import java.util.Scanner;

public class EnterX {
    public static String newStr = "";

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

    public static String createString(String entrance, int index) {
        ArrayList<String> etalonArr = createArrayOfString(entrance);
        for (int i = index; i < etalonArr.size(); i++) {
            index = i;
            String str = etalonArr.get(i);
            if (str.substring(0, 1).equals("Y")) {
                if (str.equals("Yk")) {
                    newStr += str;
                    break;
                } else {
                    newStr += str;
                    createString(entrance, index + 1);
                    break;
                }
            }
            if (str.substring(0, 1).equals("X")) {
                if (getX() == 0) {
                    String temp = "v" + str.substring(str.indexOf("^") + 1);
                    createString(entrance, etalonArr.indexOf(temp) + 1);
                    break;
                } else {
                    createString(entrance, index + 1);
                    break;
                }
            }
            if (str.substring(0, 1).equals("W")) {
                String temp = "v" + str.substring(str.indexOf("^") + 1);
                createString(entrance, etalonArr.indexOf(temp) + 1);
                break;
            }
            //i++;
        }
        return newStr;
    }

    public static String strChange(ArrayList<String> arr, int i) {
        String str = "";
        while (i < arr.size()) {
            str += arr.get(i);
            i++;
        }
        return str;
    }

    public static int getX() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите х:");
        return scan.nextInt();
    }
}
