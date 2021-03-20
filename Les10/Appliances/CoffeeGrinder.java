package Appliances;

public class CoffeeGrinder extends SmallAppliance {
    boolean plugIn = false;

    public String getBrand() {
        return "Кофемолка Мельничка";
    }

    public double getPower() {
        return 800;
    }

    public void plugIn() {
        if (plugIn) {
            System.out.println(getBrand() + " мощномтью " + getPower() + " включен в розетку");
        } else System.out.println(getBrand() + " мощномтью " + getPower() + " не включен в розетку");
    }
}
