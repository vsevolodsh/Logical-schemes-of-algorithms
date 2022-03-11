import java.util.Scanner;

public class Main {

    static void switchLsa() {
        System.out.println("Выберите способ ввода ЛСА (нажмите соответствующую цифру).");
        System.out.println("Формат ввода: ЛСА должна начинаться с Yn и заканчиваться Yk. Y и X должны быть с большой буквы. Стрелка вверх - ^, стрелка вниз - v. Без пробелов.");
        System.out.println("1.Ввод с помощью консоли.");
        System.out.println("2.Ввод с помошью файла.");
        System.out.println("9.Выход.");
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        switch (a) {
            case 1:
                String lsaEntranceConsole = LSA.consoleInput();
                switchX(lsaEntranceConsole);
                break;
            case 2:
                System.out.println("Введите путь к файлу с ЛСА: ");
                Scanner scnFile = new Scanner(System.in);
                String entrance = scnFile.nextLine();
                String lsaEntranceFile = LSA.fileInput(entrance);
                switchX(lsaEntranceFile);
                break;
            case 9:
                break;
            default:
                System.out.println("Проверьте правильность ввода и попробуйте снвова.");
                switchLsa();
                break;
        }
    }
    static void switchX(String entranceLsa) {
        System.out.println("Выберите способ ввода значений Х (нажмите соответствующую цифру).");
        System.out.println("1.Последовательный ввод значений логических условий Х и вывод результата каждого шага моделирования.");
        System.out.println("2.Ввод значений всех логических условий Х и вывод результата моделирования.");
        System.out.println("3.Полный перебор всех значений логических условий Х и вывод результата моделирования.");
        System.out.println("4.Назад.");
        System.out.println("9.Выход.");
        Scanner scn = new Scanner(System.in);
        String a = scn.nextLine();
        switch (a) {
            case "1":
                System.out.println( EnterX.consecutiveX(entranceLsa,0));
                break;
            case "2":
                System.out.println( EnterX.allX(entranceLsa,0,EnterX.enterX()));
                break;
            case "3":
                System.out.println( EnterX.allValueX(entranceLsa,0,EnterX.enterX()));
                break;
            case "4":
               switchLsa();
            case "9":
                break;
        }
    }
    public static void main(String[] args) {
        //Ynv1X0^1v2X1^6X2^8v5Y5Y6W^9v6X2^7Y2Y3v3X3^5W^4v7Y1Y2v4Y5W^2v8Y1Y4W^3v9Yk
        //Ynv1X0^1x1^2x2^3Y1Y2W^4v3X3^4Y1Y3W^5v4X4^5W^6v5Y4W^6v2Y1W^3v6Yk
        //Ynv1X0^1v2X1^3X2^4Y2Y3Y4v6X4^5W^2v3Y1Y2Y3W^6v4X3^7W^8v7Y3Y4Y5v5Y5Y6v8Yk
       switchLsa();

    }
}
