package Appliances;

public class AppRunner {
    public static void main(String[] args) {
        Fridge fr = new Fridge();
        fr.plugIn();
        Dishwasher dw = new Dishwasher();
        dw.plugIn();
        CoffeeGrinder cg = new CoffeeGrinder();
        cg.plugIn();
        CoffeeMaker cm = new CoffeeMaker();
        cm.plugIn();


    }


}
