package Appliances;

public class CoffeeMaker extends SmallAppliance{
    boolean plugIn = true;

    public String getBrand() {
        return "Кофеварка Помощница";
    }

    public double getPower() {
        return 500;
    }

    public void plugIn() {
        if (plugIn) {
            System.out.println(getBrand() + " мощномтью " + getPower() + " включен в розетку");
        } else System.out.println(getBrand() + " мощномтью " + getPower() + " не включен в розетку");
    }
}
