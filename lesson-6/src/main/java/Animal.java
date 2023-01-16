public abstract class Animal extends Object  {

    private String name;
    private int age;

    private String type;
    public Animal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public void run(int value){
        System.out.printf("%s пробежал %d метров", getType(),value);
        System.out.println();
    }

    public  void swim(int value){
        System.out.printf("%s проплыл %d метров", getType(), value);
        System.out.println();
    }

    public void printInfo(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        return String.format("Кличка %s: и возраст %d", name, age);

    }
}
