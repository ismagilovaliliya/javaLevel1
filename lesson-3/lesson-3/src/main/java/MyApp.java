import java.util.Arrays;
import java.util.Random;

public class MyApp {
    public static void main(String[] args) {
        changeElements();
        insert100();
        multiply2();
        insert1();

        int[] arr;

        int len = 5;
        int value = 33;
        arr = addArray(len, value);
        System.out.println("Массив размером " +len+ " и с значением "+value+": \n" +Arrays.toString(arr));

        arr = new int[10];
        Random random = new Random();
        for (int i= 0; i<arr.length; i++){
            arr[i] = random.nextInt(101);
        }
        System.out.println("Исходный массив" + Arrays.toString(arr));
        findMinMax(arr);

        int arr2[] = {2,2,2,1,2,2,10,1};
        System.out.println("Проверка на равенство " + isCheckArray(arr));
        System.out.println("Проверка на равенство " + isCheckArray(arr2));

        int arr3[] = {1,2,3,4,5};
        int n = -2;
        move(arr3, n);

    }
    public static  void  move(int[] arr, int n){
        int size = arr.length;

/*        int[] new_arr = new int [size];
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


        System.out.println(Arrays.toString(new_arr));*/


        int shiftNumber = n % arr.length;

        if(shiftNumber < 0){
            shiftLeft(arr, shiftNumber);
        } else {
            shiftRight(arr,shiftNumber);
        }
        System.out.println(Arrays.toString(arr) + "; shiftNumber = " + n);

    }

    private static void shiftRight(int[] array, int n){
        for (int i = 0; i < n i++) {
            int lastValue = array[array.length -1];
            for (int j = array.length-1; j > 0; j+--) {
                array[j] = array[j-1]
            }
            array[0] = lastValue;
        }
    }
    private static void shiftLeft(int[] array, int n){
        for (int i = 0; i < Math.abs(n); i++) {
            int firstValue = array[0];
            for(int j = 0; j < array.length -1; j++){
                array[j] = array[j+1];
            }
            array[array.length -1] = firstValue;
        }
    }

    public static boolean isCheckArray(int[] arr) {

        int sum1, sum2;
        sum1 = 0;
        sum2 = 0;

 /*       for (int i = 0; i < arr.length; i++) {
            sum1 = sum1 + arr[i];
            sum2 = 0;
            for (int j = arr.length - 1; j > i; j--) {
                sum2 = sum2 + arr[j];
            }
            System.out.printf("sum1= %2d, sum2= %2d", sum1, sum2);
            System.out.println();

            if(sum1 == sum2) { return true;}
        }
*/

        int leftSum = 0;
        int rightSum = sum(arr, 0, arr.length);

        if (rightSum % 2 != 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++){
            leftSum += arr[i];
      //  rightSum -= arr[i];

            if (leftSum == rightSum / 2) {
                return true;
            }
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

        //max = Math.max(array[i], max);
        //min = Math.min(array[i], min);


        Arrays.sort(arr);
        min = arr[0];
        max = arr[arr.length -1];

        System.out.printf("max value %2d, min value %2d",max,min);
        System.out.println();
    }

    public static int[] addArray(int len, int value){
        int[] arr = new int[len];

        for(int i = 0; i < len; i ++)
            arr[i] = value;

        return arr;

    }

    public static  void insert1(){
        int[][] arr = new int [6][6];

/*        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length ; j++) {
                if((i == j)||((arr.length -1-i) == j)) { arr[i][j] = 1; }
                else arr[i][j] = 0;
                System.out.printf("%2d", arr[i][j]);
            }
            System.out.println();
        }*/

        int lastIndex = arr.length - 1;

      /*  for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }*/

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] =  arr[i][lastIndex -i] ==1;
        }

        for (int[] ints: arr){
            System.out.println(Arrays.toString(ints));
        }

    }

    public static void multiply2(){
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Массив \n" + Arrays.toString(arr));

        for (int i= 0; i<arr.length; i++){
            arr[i] = arr[i] < 6 ? arr[i]*2:arr[i];
        }
        System.out.println("Массив новый \n" + Arrays.toString(arr));
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
            arr[i] = (arr[i] == 0) ? 1: 0;
        }
        System.out.println("Массив после замены" + Arrays.toString(arr));
    }

}
