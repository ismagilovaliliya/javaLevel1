public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cats("Missi", 2);
        Animal dog1 = new Dogs("Frank",15);
        Animal dog2 = new Dogs("Doggi",10);
        
        cat1.swim(10);
        cat1.swim(300);

        dog1.swim(60);
        dog1.swim(600);

        cat1.run(10);
        cat1.run(300);

        dog1.run(60);
        dog2.run(600);

        cat1.printInfo();
        dog1.printInfo();
        dog2.printInfo();
        
        Cats.printPlayersCountInfo();
        Dogs.printDogsCountInfo();
    }
}
