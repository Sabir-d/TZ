import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws CalculatorException {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример для решения формата a + b,a - b,a / b,a * b римскими или арабскими числами значением от 1-10 или I-X");
        String primer = in.nextLine();
        in.close();
        primer.trim();
        System.out.println( Call(primer));

    }


    public static String Call(String primer) {

        int operand1=0;
        int operand2=0;
        int answer=0;
        String answerr="";

        String answerRoman = "";
        boolean roman =false;
        String [] primer1= primer.split(" ");
        if (primer1.length!=3) {
            return answerr= "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) через пробел";

        }
        try {
            operand1 = Integer.parseInt(primer1[0]);
            if( operand1<0 || operand1>10)
            {
                return answerr= "throws Exception //т.к. операнд 1 не входит в промежуток 1-10";
            }
            try {
                operand2 = Integer.parseInt(primer1[2]);
                if (operand2 < 0 || operand2 > 10) {
                    return  answerr = "throws Exception //т.к. операнд 2 не входит в промежуток 1-10";

                }
            }
            catch (Exception e)
            {return answerr= "throws Exception //т.к. используются одновременно разные системы счисления";}
        }
        catch (Exception e)
        {try {
            RomanNumeral roman1 = RomanNumeral.valueOf(primer1[0]);
            operand1=roman1.getArabNumber();
            roman1 = RomanNumeral.valueOf(primer1[2]);
            operand2=roman1.getArabNumber();
            roman=true;
        }
        catch (IllegalArgumentException d)
        { return answerr= "throws Exception //т.к. используются одновременно разные системы счисления";}

        }


        switch (primer1[1]) {
            case ("+"):
                answer = operand1 + operand2;
                break;
            case ("-"):
                answer = operand1 - operand2;
                break;
            case ("*"):
                answer = operand1 * operand2;
                break;
            case ("/"):
                answer = operand1 / operand2;
                break;
            default:
            return     answerr= "throws Exception //т.к. используется оператор, не подходящий в тз";

        }
        if(roman)
        {
            if (answer<=0)
            {
                return     answerr="throws Exception //т.к. римская цифра не может быть меньше или равна 0";
            }
            int units = answer%10;
            int tens = (answer%100)/10;
            int hundreds = (answer%1000)/100;
            if (hundreds==1)
            {
                answerRoman="C";
            }
            switch (tens) {
                case 1: answerRoman += "X";
                    break;
                case 2: answerRoman += "XX";
                    break;
                case 3: answerRoman += "XXX";
                    break;
                case 4: answerRoman += "XL";
                    break;
                case 5: answerRoman += "L";
                    break;
                case 6: answerRoman += "LX";
                    break;
                case 7: answerRoman += "LXX";
                    break;
                case 8: answerRoman += "LXXX";
                    break;
                case 9: answerRoman += "XC";
                    break;
            }
            switch (units) {
                case 1:
                    answerRoman += "I";
                    break;
                case 2:
                    answerRoman += "II";
                    break;
                case 3:
                    answerRoman += "III";
                    break;
                case 4:
                    answerRoman += "IV";
                    break;
                case 5:
                    answerRoman += "V";
                    break;
                case 6:
                    answerRoman += "VI";
                    break;
                case 7:
                    answerRoman += "VII";
                    break;
                case 8:
                    answerRoman += "VIII";
                    break;
                case 9:
                    answerRoman += "IX";
                    break;
            }
            return answerRoman;
        }
        else
        {

            return String.valueOf((answer));
        }


    }
}