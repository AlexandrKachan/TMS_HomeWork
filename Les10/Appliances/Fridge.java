package Appliances;

public class Fridge extends BigAppliance {
    boolean plugIn = false;


    public String getBrand() {
        return "Холодильник Холодок";
    }

    public double getPower() {
        return 1800;
    }

    public void plugIn() {
        if (plugIn) {
            System.out.println(getBrand() + " мощномтью " + getPower() + " включен в розетку");
        } else System.out.println(getBrand() + " мощномтью " + getPower() + " не включен в розетку");
    }
}

