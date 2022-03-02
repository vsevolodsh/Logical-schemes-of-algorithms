import java.util.Scanner;

public class EnterX {

    // entrance = YnX1^Y1Y2v1Y3X2^Y4v2Yk
    //result = YnY1Y2Y4Yk
    public static void inputAllX(String entrance) // cделать проверку на то, что значений столько же сколько и х
    {
        LSA lsa = new LSA();
        String[] allX = lsa.getAllX(entrance); //allX = X1X2; 1 элемент = Х1. сразу два символа
        String[] entranceArr = entrance.split("");  //Делим начальную строку на элементы
        System.out.println("Введите все значения логических условий X: ");
        Scanner scn = new Scanner(System.in);
        String xValue = scn.nextLine();     // Вводим значения всех х. xValue =11
        int xValueCount = 0; //Отдельный счетчик для иксов.
        String[] xValuerArr = xValue.split(""); //Делим введенные х на элементы.
        boolean startOfExpression = true;//проверка, для выписывания Yn
        for (int i = 0; i < entranceArr.length; i++) {
            if (!entranceArr[i].equals("k")) {//тут проблема с выходом за пределы. поэтому пока i!=к
                if ((entranceArr[i] + entranceArr[i + 1]).equals(allX[xValueCount])) {//т.к. аллх возвращает х1, то соединяю строки вводных данных
                    if (startOfExpression) {
                        System.out.print(entrance.substring(0, i));//Yn
                        startOfExpression = false; //больше тру он не станет.
                    }
                    if (xValuerArr[xValueCount].equals("1")) {//если x-ное равно 1:
                        xValueCount++;//увеличиваем счетчик иксов. он кстати тоже выходит за пределы массива, но думаю фиксится просто
                        int j = i + 1;//вводим счетчик j 
                        if (!entranceArr[i].equals("k")) { // здесь он выходит за пределы массива. не знаю как пофиксить
                            while (!entranceArr[j].equals("X")) {//пока текущий элемент не равен иксу, 
                                if (entranceArr[j].equals("Y")) {//и при этом он равен у,
                                    System.out.print(entranceArr[j] + entranceArr[j + 1]);//выписываем у и цифру после него
                                    j++;//переходим на след элемент
                                } else {
                                    j++;
                                }
                            }
                        }
                        if (xValuerArr[xValueCount].equals("0")) {
                            // while ()
                        }
                    }
                }

            }
        }
    }

}
