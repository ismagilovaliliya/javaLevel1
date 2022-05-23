package ru.geekbeans.lesson1;

public class HomeWorkApp {
    public static  void main(String[] args){
        System.out.println("printThreeWords() execute:");
        printThreeWords();

        System.out.println("checkSumSign() execute");
        int a, b;
        a = (int)(Math.random()*(20+1))-10;
        b = (int)(Math.random()*(20+1))-10;
        checkSumSign(a,b);

        System.out.println("printColor() execute");
        printColor();

        System.out.println("compareNumbers() execute");
        a = (int)(Math.random()*(20+1))-10;
        b = (int)(Math.random()*(20+1))-10;
        compareNumbers(a,b);
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(int a, int b){
        int sum;

        System.out.println("value a = " + a+", b = "+b);
        sum = a+b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value;

        value = (int)(Math.random()*(200+5))-100;

        System.out.println("value = " + value);

        if (value <= 0){ System.out.println("Красный");}
        if (value > 0 && value <=100 ){ System.out.println("Желтый");}
        if (value > 100 ){ System.out.println("Зеленый");}
    }

    public static void compareNumbers(int a, int b){

        System.out.println("value a = " + a+", b = "+b);

        if (a >= b){ System.out.println("a >= b");}
        else { System.out.println("a < b");}
    }
}
