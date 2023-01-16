public class Dogs extends Animal{

    private String type;

    private static int dogsCount;

    public Dogs(String name, int age){
        super(name, age, "Dog");
        this.type = type;
        dogsCount++;

    }

    public static int getDogCount(){
        return  dogsCount;
    }

    public static void printDogsCountInfo(){
        System.out.println("Всего собак " + getDogCount());
    }
    @Override
    public void swim(int value){
        if (value > 500) { System.out.println("Собаки более 500 метров не плавают! Им лень");}
        else {
            System.out.printf("%s проплыл %d метров! Красава!", super.getName(), value);
        }
    }

    @Override
    public void run(int value){
        if (value > 10) { System.out.println("Собаки более 200 метров не бегают! Им лень");}
        else {
            System.out.printf("%s пробежал %d метров! Красава!", super.getName(), value);
        }
    }
}
