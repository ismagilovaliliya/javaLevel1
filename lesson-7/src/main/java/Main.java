public class Main {

    public static void main(String[] args) throws InterruptedException {

        Cat[] cats ={
                new Cat("Котя",6),
                new Cat("Шустр",4),
                new Cat("Бакс",7),
                new Cat("Лева",1)
        };

        Plate plate = new Plate(20);

        plate.printInfo();

        //кормим котов
        for (Cat c: cats) {
            while (!c.getFullness() && plate.getFoodCount() > 0 && c.getCatCanEat()) {
                c.eat(plate);
                plate.printInfo();
                Thread.sleep(1000);
            }
        }

        //итог
        for (Cat c : cats){
            if(c.getFullness()){
                System.out.printf("%s - сытый",c.getName());
                System.out.println();
            }
            else {
                System.out.printf("%s голодный. Докиньте корма",c.getName());
                System.out.println();
            }
        }

    }
}
