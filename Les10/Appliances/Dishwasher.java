package Appliances;

public class Dishwasher extends  BigAppliance {
    boolean plugIn = true;

    public String getBrand() {
        return "Посудомойка Чистюля";
    }

    public double getPower() {
        return 2800;
    }

    public void plugIn() {
        if (plugIn) {
            System.out.println(getBrand() + " мощномтью " + getPower() + " включен в розетку");
        } else System.out.println(getBrand() + " мощномтью " + getPower() + " не включен в розетку");
    }
}
