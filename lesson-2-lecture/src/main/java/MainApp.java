public class MainApp {
    public static void main(String[] args) {
        eight();
    }

    public static  void eight(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i ==0) || (i==5)|| (j==0)||(j==5)){  System.out.print('*');System.out.print(' ');}
                else { System.out.print(' ');System.out.print(' ');}
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i ==0) || (i==5)|| (j==0)||(j==5) || (i == j)){  System.out.print('*');System.out.print(' ');}
                else { System.out.print(' ');System.out.print(' ');}
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i==5)|| (j==0) || (i == j)){  System.out.print('*');System.out.print(' ');}
                else { System.out.print(' ');System.out.print(' ');}
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i ==2 && j==2)|| (i ==2 && j==3)||(i ==3 && j==2)||(i ==3 && j==3)){  System.out.print(' ');System.out.print(' ');}
                else { System.out.print('*');System.out.print(' ');}
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i == 4 && j==0)|| (i ==5 && j==0)||(i ==0 && j==4)||(i ==0 && j==5)){  System.out.print(' ');System.out.print(' ');}
                else { System.out.print('*');System.out.print(' ');}
            }
            System.out.println();
        }

    }

    public static  void sixth(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i +j) % 2 >0){  System.out.print('*');System.out.print(' ');}
                else { System.out.print('0');System.out.print(' ');}
            }
            System.out.println();
        }
    }

    public static  void seventh(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i > j) {
                    System.out.print("0 ");
                } else if (i < j) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static  void fifth(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i ==0) || (i==5)|| (j==0) ||(j==5)){  System.out.print('0');System.out.print(' ');}
                else { System.out.print('*');System.out.print(' ');}
            }
            System.out.println();
        }
    }
    public  static void fourthly(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j >= 3){  System.out.print('0');System.out.print(' ');}
                else { System.out.print('*');System.out.print(' ');}
            }
            System.out.println();
        }
    }

    public static  void third(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print('*');
                System.out.print(' ');
            }
            System.out.println();
        }

    }
    public static void second() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void first() {
        for (int j = 0; j < 10; j++) {
            System.out.print('*');
        }
        System.out.println();
    }

}
