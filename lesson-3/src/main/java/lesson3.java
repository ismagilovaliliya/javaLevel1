import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class lesson3 {
    public static void main(String[] args) {
        /*changeElements();
        insert100();
        multiply6();*/

 /*       int [] arr = new int[10];
        Random random = new Random();
        for (int i= 0; i<arr.length; i++){
            arr[i] = random.nextInt(101);
        }
        System.out.println("Исходный массив" + Arrays.toString(arr));

       int arr2[] = {2,2,2,1,2,2,10,1};
        findMinMax(arr);
        System.out.println("Проверка на равенство " + isCheckArray(arr));
        System.out.println("Проверка на равенство " + isCheckArray(arr2));
*/
        int arr3[] = {1,2,3,4,5};
        int n = -2;
        move(arr3, n);
    }
    public static  void  move(int[] arr, int n){
        int size = arr.length;

        int[] new_arr = new int [size];
        int j;

        int step = n%size;
        System.out.println(step);
        if(step >= 0) {
             for (int i = 0; i < size; i++) {
                 j = (i + step >= size) ? (i + step) - size : i + step;
                 new_arr[j] = arr[i];
             }
         }

        else {
            for (int i = 0; i < size; i++) {
                j = (size + (i + step) >= size) ? (size + (i + step)) - size : size + (i + step);
                new_arr[j] = arr[i];
            }
        }


        System.out.println(Arrays.toString(new_arr));
    }
    public static boolean isCheckArray(int[] arr) {

        int sum1, sum2;
        sum1 = 0; sum2 = 0;

            for (int i = 0; i < arr.length; i++) {
                sum1 = sum1 + arr[i];
                sum2 = 0;
                for (int j = arr.length - 1; j > i; j--) {
                    sum2 = sum2 + arr[j];
                }
                System.out.printf("sum1= %2d, sum2= %2d", sum1, sum2);
                System.out.println();

                if(sum1 == sum2) { return true;}
            }

        return false;
    }

    public static void findMinMax(int[] arr){

        int min = arr[0];
        int max = arr[0];

        for (int i= 0; i<arr.length; i++){

            min = arr[i] < min ? arr[i] : min;
            max = arr[i] > max ? arr[i] : max;
        }

        System.out.printf("max value %2d, min value %2d",max,min);
        System.out.println();
    }

    public static void multiply6(){
        int [] arr = {};
    }

    public static void insert100(){
        int [] arr = new int[100];

        for (int i= 0; i<arr.length; i++){
            arr[i] = i+1;
        }
        System.out.println("Массив [1, 100] \n" + Arrays.toString(arr));
    }
    public static void changeElements(){

        int [] arr = new int[10];
        Random random = new Random();

        for (int i= 0; i<arr.length; i++){
            arr[i] = random.nextInt(2);
        }
        System.out.println("Исходный массив" + Arrays.toString(arr));

        for (int i=0; i < arr.length; i++){
           if (arr[i] == 0) { arr[i] = 1;}
           else { arr[i] = 0;}
        }
        System.out.println("Массив после замены" + Arrays.toString(arr));
    }

}
