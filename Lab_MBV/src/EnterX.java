import java.util.Scanner;
import java.util.SplittableRandom;

public class EnterX {

    // entrance = YnX1^Y1Y2v1Y3X2^Y4v2Yk
    //result = YnY1Y2Y4Yk
    public static void inputAllX(String entrance) // cделать проверку на то, что значений столько же сколько и х
    {
        LSA lsa = new LSA();
        String[] allX = lsa.getAllX(entrance);
        String[] entranceArr = entrance.split("");  //Делим начальную строку на элементы
        String[] AllNumAfterY = lsa.getAllNumAfterY(entrance);
        String[] AllNumAfterX = lsa.getAllNumAfterX(entrance);
        int NumAfterYCount = 0;
        int NumAfterXCount = 0;
        System.out.println("Введите все значения логических условий X: ");
        Scanner scn = new Scanner(System.in);
        String xValue = scn.nextLine();     // Вводим значения всех х. xValue =11
        int xValueCount = 0; //Отдельный счетчик для иксов.
        String[] xValuerArr = new String[255];
        String[] test = xValue.split(""); //Делим введенные х на элементы.
        xValuerArr = test;
        boolean startOfExpression = true;//проверка, для выписывания Yn
        for (int i = 0; i < entranceArr.length; i++) {
            if ((entranceArr[i] + AllNumAfterX[NumAfterXCount]).equals(allX[xValueCount] + AllNumAfterX[NumAfterXCount])) {
                if (startOfExpression) {
                    System.out.print(entrance.substring(0, i));//Yn
                    startOfExpression = false; //больше тру он не станет.
                    NumAfterXCount++;
                }

                if (xValuerArr[xValueCount].equals("1")) {//если x-ное равно 1:
                    if (xValueCount < xValuerArr.length-1) {
                        xValueCount++;//увеличиваем счетчик иксов. он кстати тоже выходит за пределы массива, но думаю фиксится просто
                    }
                    int j = i + 1;//вводим счетчик j

                    while (!entranceArr[j].equals("X") && j < entranceArr.length) {//пока текущий элемент не равен иксу,
                        if (entranceArr[j].equals("Y")) {//и при этом он равен у,
                            System.out.print(entranceArr[j] + AllNumAfterY[NumAfterYCount]);//выписываем у и цифру после него
                            NumAfterYCount++;
                            j++;//переходим на след элемент
                        } else {
                            j++;
                        }
                    }

                    //  if (xValuerArr[xValueCount].equals("0")) {
                    // while ()
                }
            }
        }
    }
}


