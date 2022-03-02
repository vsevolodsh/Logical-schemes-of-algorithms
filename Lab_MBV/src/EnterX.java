import java.util.Scanner;

public class EnterX {

    // entrance = YnX1^Y1Y2v1Y3X2^Y4v2Yk
    //result = YnY1Y2Y4Yk
    public static void inputAllX(String entrance) // cделать проверку на то, что значений столько же сколько и х
    {
        LSA lsa = new LSA();
        String[] allX = lsa.getAllX(entrance); //allX = X1X2
        String[] entranceArr = entrance.split("");  
        System.out.println("Введите все значения логических условий X: ");
        Scanner scn = new Scanner(System.in);
        String xValue = scn.nextLine();     // xValue =11
        int xValueCount = 0;
        String[] xValuerArr = xValue.split("");
        boolean startOfExpression = true;
        for (int i = 0; i < entranceArr.length; i++) {
            if (!entranceArr[i].equals("k")) {
                if ((entranceArr[i] + entranceArr[i + 1]).equals(allX[xValueCount])) {
                    if (startOfExpression) {
                        System.out.print(entrance.substring(0, i));//Yn
                        startOfExpression = false;
                    }
                    if (xValuerArr[xValueCount].equals("1")) {
                        xValueCount++;
                        int j = i + 1;
                        if (!entranceArr[i].equals("k")) {
                            while (!entranceArr[j].equals("X")) {
                                if (entranceArr[j].equals("Y")) {
                                    System.out.print(entranceArr[j] + entranceArr[j + 1]);
                                    j++;
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
