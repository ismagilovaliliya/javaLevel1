import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.Random;
import java.util.Scanner;

public class MyAppExtended {

    private static  final int SIZE=3;
    private static  final int WIN_SIZE=3;

    private static  final char DOT_EMPTY = '*';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private final static char[][] MAP = new char[SIZE][SIZE];
    private static final String HEADER_FIRST_SYMBOL = "~";
    private static final String SPACE_MAP = " ";

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    private static int turnsCount;

    private static int lastRow;
    private static int lastColumn;

    public static void turnGame() {
        do {
            System.out.println("\n\n Game started");
            init();
            printMap();
            playGame();
        } while (isContinueGame());

        endGame();
    }

    private  static void endGame(){
        in.close();

    }
    private static boolean isContinueGame(){
        System.out.println("Хотите продолжить? y\\n");
         switch(in.next()){
            case "y":
             case "д":
                case "yes":
                    case "да":
                 case "+":
                 return true;

             default : return false;
        }
    }
    private static void init(){
        turnsCount = 0;

        //получить размер игрового поля
        //подобрать победную серию фишек для выбранного размера
        // размер от 3-6 победная серия -> 3
        // от 7-10 -> 4
        // 10+ -> 5

    /*    System.out.println("Введите размер игрового поля");
        SIZE = in.nextInt();

        if(SIZE <=6) {
            WIN_SIZE = 3;
        } else if (SIZE >=7 && SIZE <10){
            WIN_SIZE = 4;
        }else {
            WIN_SIZE = 5;
        }
        System.out.println("Ваша победная серия равна: " + WIN_SIZE);*/
        initMap();
    }
    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j< SIZE; j++){
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void playGame() {
      while (true) {
          humanTurn();
          printMap();
          if(checkEnd(DOT_HUMAN)){
              break;
          }

          aiTurn();
          printMap();
          if(checkEnd(DOT_AI)){
              break;
          }
      }
    }
    private static void humanTurn() {
        System.out.println("ХОД ЧЕЛОВЕКА");

        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.println("Введите координату строки: ");
            rowNumber = getValidNumberFrmScanner() - 1;

            System.out.println("Введите координату столбца: ");
            columnNumber = getValidNumberFrmScanner() - 1;

            if( isCellFree(rowNumber,columnNumber)){
                break;
            }
            System.out.printf("Ячейка с координатами: %d:%d уже занята%n%n", rowNumber +1, columnNumber+1);
        }

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;

        lastRow = rowNumber;
        lastColumn = columnNumber;

    }

    private static int getValidNumberFrmScanner() {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                }
                System.out.println("!! Проверьте значение координаты. Должно быть от 1 до " + SIZE);
            } else {
                System.out.println("!! ВВОД ДОПУСТКАЕТ ЛИШЬ ЦЕЛЫЕ ЧИСЛА");
                in.next();
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return  n>=1 && n<=SIZE;
    }

    private static void aiTurn() {
        System.out.println("ХОД КОМПЬЮТЕРА");

        int rowNumber;
        int columnNumber;

/*        while (true) {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
            if (isCellFree(rowNumber,columnNumber)) {
                break;
            }1
        }*/

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while ( !isCellFree(rowNumber,columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;

        lastRow = rowNumber;
        lastColumn = columnNumber;
    }

    private static boolean checkEnd(char symbol){

        if(checkWin(symbol)){
            if (symbol == DOT_HUMAN){
                System.out.println("УРА! ВЫ ПОБЕДИЛИ");
            }
            else {
                System.out.println("КОМПЬЮТЕР ПОБЕДИЛ");
            }
            return true;
        }

        if(checkDraw()){
            System.out.println("НИЧЬЯ!");
            return true;

        }
        return false;
    }

    private static boolean checkDraw() {
/*        for (char[] chars: MAP) {
            for(char symbol : chars){
                if(symbol == DOT_EMPTY){
                    return  false;
                }
            }
            
        }
        return  true;*/

        return turnsCount >= SIZE * SIZE;

    }
    private static boolean checkLine(char symbol, int startRow, int startColumn, int endRow, int endColumn){

        int checkWin = 3;

  /*      if (startColumn < 0 ) startColumn = 0;
        if (endColumn < 0) endColumn = 0;
        if (startRow < 0 ) startRow = 0;
        if (endRow < 0) endRow = 0;

        if (startColumn > SIZE -1 ) startColumn = SIZE-1;
        if (endColumn > SIZE -1) endColumn = SIZE-1;
        if (startRow > SIZE -1 ) startRow = SIZE-1;
        if (endRow > SIZE -1) endRow = SIZE -1;
*/
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <=endColumn ; j++) {
                if(MAP[i][j]==symbol){
                    checkWin--;
                }
            }
        }

        /*
        System.out.println("sumbol "+ symbol +" lastRow "+ startRow + "lastColumn "+startColumn);
        for (int i = 0; i <= startRow; i++) {
            System.out.println("sumbol "+ symbol +" i "+ i );
            for (int j = 0; j <startColumn ; j++) {
                System.out.println("sumbol "+ symbol +" j "+ j+ " MAP[i][j] "+ MAP[i][j]);
                if(MAP[i][j]==symbol){
                    checkWin++;
                } else if (MAP[i][j]==symbol) {
                    checkWin--;
                }
                System.out.println("sumbol "+ symbol +" checkWin "+ checkWin);
            }
        }
*/
        if(checkWin == 0) {
            return true;
        }
        return false;
    }
    private static boolean checkWin(char symbol){

        //Последняя точка сохранена
        //проверка каждой линии от это точки
        // проверка диагоналей от этой точки

/*        int WIN_SIZE_MAP = WIN_SIZE -1;

        if (checkLine(symbol,lastRow - WIN_SIZE_MAP, lastColumn, lastRow, lastColumn )) return  true;//вверх
        if (checkLine(symbol,lastRow + WIN_SIZE_MAP,lastColumn , lastRow, lastColumn)) return true;//вниз
        if (checkLine(symbol,lastRow, lastColumn,  lastRow, lastColumn + WIN_SIZE_MAP)) return true;//вправо
        if (checkLine(symbol,lastRow, lastColumn - WIN_SIZE_MAP, lastRow,lastColumn)) return  true;//влево
*/
        if (checkLine(symbol,lastRow , 0, lastRow, SIZE -1)) return  true;//горизонтально
        if (checkLine(symbol,0,lastColumn, SIZE - 1, 0)) return true;//вертикально

        /*дигонали*/
        if(checkDiagonal(symbol, lastRow, lastColumn)) return true;

    /*
        if(MAP[0][0] == symbol && MAP[0][1] == symbol &&MAP[0][2] == symbol){
            return  true;
        }
        if(MAP[1][0] == symbol && MAP[1][1] == symbol &&MAP[1][2] == symbol){
            return  true;
        }
        if(MAP[2][0] == symbol && MAP[2][1] == symbol &&MAP[2][2] == symbol){
            return  true;
        }

        if(MAP[0][0] == symbol && MAP[1][0] == symbol &&MAP[2][0] == symbol){
            return  true;
        }
        if(MAP[0][1] == symbol && MAP[1][1] == symbol &&MAP[2][1] == symbol){
            return  true;
        }
        if(MAP[0][2] == symbol && MAP[1][2] == symbol &&MAP[2][2] == symbol){
            return  true;
        }

        if(MAP[0][0] == symbol && MAP[1][1] == symbol &&MAP[2][2] == symbol){
            return  true;
        }
        if(MAP[0][2] == symbol && MAP[1][1] == symbol &&MAP[2][0] == symbol){
            return  true;
        }
*/
        return  false;

    }

    private static boolean checkDiagonal(char symbol, int lastRow, int lastColumn) {
        int checkWin = 0;

        System.out.println("sumbol "+ symbol +" lastRow "+ lastRow + "lastColumn "+lastColumn);

        /* \ ползем к верху*/
        if(lastRow >= lastColumn) {
            do {
                lastRow--;
                lastColumn--;
            } while (lastColumn != 0);

            System.out.println("\\\\sumbol "+ symbol +"lastColumn "+lastColumn + "lastRow "+ lastRow);

            // получили начало диагонали для проверки
            for (int i = lastRow; i < SIZE; i++) {
                System.out.println("\\\\sumbol "+ symbol +"lastColumn "+lastColumn + "i "+ i);
                System.out.println("\\\\sumbol "+ symbol +"MAP[lastColumn][i] "+MAP[lastColumn][i]);
                if (MAP[lastColumn][i] == symbol) {
                    checkWin++;
                } else if (MAP[lastColumn][i] == symbol) {
                    checkWin--;
                }

                System.out.println("\\\\sumbol "+ symbol +"lastColumn "+lastColumn + "i "+ i+" chekWin "+checkWin);
                lastColumn++;
            }
        } else{
            do {
                /* / */
                lastRow--;
                lastColumn--;
            } while (lastRow != 0);
            System.out.println("\\\\sumbol "+ symbol +"lastColumn "+lastColumn + "lastRow "+ lastRow);
            // получили начало диагонали для проверки
            for (int i = lastColumn; i < SIZE; i++) {
                System.out.println("///sumbol "+ symbol +"lastRow "+lastRow + "i "+ i);
                System.out.println("///sumbol "+ symbol +"MAP[i][lastRow] "+MAP[i][lastRow]);
                if (MAP[i][lastRow] == symbol) {
                    checkWin++;
                } else if (MAP[i][lastRow] == symbol) {
                    checkWin--;
                }

                System.out.println("///sumbol "+ symbol +"lastColumn "+lastColumn + "i "+ i+" chekWin "+checkWin);
                lastRow++;
            }
        }

        if(checkWin == WIN_SIZE) {
            return true;
        }

        return false;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return  MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void printMapBody() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }


}
