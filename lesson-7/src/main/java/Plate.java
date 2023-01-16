public class Plate {

    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString(){
        return "В тарелке количество корма: " + foodCount + " шт\n";
    }

    public int getFoodCount(){
        return foodCount;
    }

    public boolean isDecreaseFood(int catEatFoodCount, int catEatNeed) {
        if (catEatFoodCount > foodCount && catEatNeed > foodCount){
            System.out.println("Корма в тарелке не хватает чтобы он наелся. Докиньте по-братски");
            return false;
        }

        return true;
    }

    public void decreaseFood(int catEatFoodCount) {
            foodCount -= catEatFoodCount;
    }

    public void addFood(int addFoodCount){
            foodCount += addFoodCount;
    };
}
