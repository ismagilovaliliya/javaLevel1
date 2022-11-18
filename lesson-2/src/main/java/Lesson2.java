import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Lesson2 {
    public static void main(String[] args) {

        int a, b;
        a = (int)(Math.random()*(20+1))-10;
        b = (int)(Math.random()*(20+1))-10;

        System.out.println("Value a =" + a+ ", b = " + b);

        System.out.println("checkNumber() execute");
        boolean result = checkNumber(a,b);
        System.out.print("Сумма целых чисел = ");
        if (result == true) {System.out.println("в диапазоне (10,20]");}
        else {System.out.println("не в диапазоне (10,20] ");}

        System.out.println("checkNumberSign() execute");
        checkNumberSign(a);

        System.out.println("checkOneNumber() execute");
        result = checkOneNumber(b);
        if (result == true) {System.out.println("В метод передано положительное число = " + b);}
        else {System.out.println("В метод передано отрицательное число = " + b);}

        System.out.println("writeN() execute");
        String word = "Java Lesson 2";
        int count = 5;
        System.out.println("Вывод слова "+word + " "+count+" раз");
        writeN(word, count);


    }

    public static boolean checkNumber(int a, int b) {

        int sum = a +b;
        if( sum > 10 && sum <=20) { return true;}
        else return false;
    }

    public static void checkNumberSign(int a){

        if (a >=0){
            System.out.println("В метод передано положительное число "+ a);
        }
        else {
            System.out.println("В метод передано отрицательное число " + a);
        }

    }

    public static boolean checkOneNumber(int a) {

        if( a >= 0 ) { return true;}
        else return false;
    }

    public static void writeN(String word, int n){
        while (n > 0){
            System.out.println(n + " "+ word);
            n--;
        }
    }

    public static int checkYear(int year){
        return  1;
    }
}
