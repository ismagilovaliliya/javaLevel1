import java.util.concurrent.ThreadLocalRandom;

public class Cat {

    private String name;
    private int catFoodCount; //сколько съедает за один подход
    private int saturationFood; //уровень насыщения
    private int fullSaturation; //уровень полного насыщения
    private boolean fullness;
    private boolean catCanEat;// возможность кушать

    public Cat(String name, int fullSaturation) {
        this.name = name;
        this.saturationFood = 0;
        this.fullness = false;
        this.fullSaturation = fullSaturation;
        this.catCanEat = true;
    }

    public void eat(Plate plate) {
        int catFoodForSaturation;

        if (this.fullness){
            return;
        }

        catFoodCount = ThreadLocalRandom.current().nextInt(4)+3;
        if (plate.isDecreaseFood(catFoodCount,fullSaturation - saturationFood )){// достаточность корма на тарелке
            if ((saturationFood + catFoodCount) > fullSaturation){
                catFoodForSaturation = fullSaturation - saturationFood;
                saturationFood += catFoodForSaturation;
                plate.decreaseFood(catFoodForSaturation);
                this.fullness = true;

                System.out.printf("Котька %s следит за фигурой и съел только %2d шт корма вместо %2d.\nЕго уровень насыщения = %2d\nПолный уровень насыщения = %2d", name, catFoodForSaturation, catFoodCount, saturationFood, fullSaturation);
                System.out.println();

            }else {
                plate.decreaseFood(catFoodCount);
                saturationFood += catFoodCount;

                System.out.printf("Кот %s съел %2d шт корма. \nЕго уровень насыщения = %2d\nПолный уровень насыщения = %2d", name, catFoodCount, saturationFood, fullSaturation);
                System.out.println();

                if (saturationFood == fullSaturation) {
                    this.fullness = true;
                }
            }
        }else{
            catCanEat = false;
        }
    }

    public boolean getCatCanEat(){
        return catCanEat;
    }
    public int getCatFoodCount(){
        return catFoodCount;
    }

    public boolean getFullness(){
        return fullness;
    }

    public String getName() {
        return name;
    }
}
