public class MathCalc {

    private double result;

    public MathCalc(){}

    public double calc( double a, double b, String operationCalc){

         result = 0;

        switch (operationCalc){
            case "+":
                result = a + b;
            break;
            case "-":
                result = a - b;
            break;
            case "*":
                result = a * b;
            break;
            case "/":
                result = a / b;
            break;
        }
        return result;
    }
}
