public class Cats extends Animal {

    private String type;

    private static int catsCount;

    public Cats(String name, int age){
        super(name, age, "Cat");
        this.type = type;
        catsCount++;

    }

    public static int getCatsCount(){ return catsCount;}
    public static void printPlayersCountInfo(){
        System.out.println("Всего котов: "+ getCatsCount());
    }

    @Override
    public void swim(int value){
        System.out.println("Коты не умеет плавать!");
    }

    @Override
    public void run(int value){
        if (value > 200) { System.out.println("Коты более 200 метров не бегают! Им лень");}
        else {
            System.out.printf("%s пробежал %d метров! Красава!", super.getName(), value);
            System.out.println();
        }
    }
}
