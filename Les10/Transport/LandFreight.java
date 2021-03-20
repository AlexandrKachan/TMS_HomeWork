package Transport;

public class LandFreight extends LandTransport {
    double carrying = 20; // грузоподъемность

    public String getBrand() {
        return "MAN";
    }

    public double getPower() {
        return 1800;
    }

    public double getSpeed() {
        return 100;
    }

    public double getWeight() {
        return 10900;
    }

    public int getWheels() {
        return 12;
    }

    public double getFuel() {
        return 15;
    }

    public double powerKvt() {
        return getPower() * 0.74;
    }


    public void carringFr(double carrying2) {
        if (carrying2 <= carrying) {
            System.out.println("Грузим " + carrying2 + " тонн. Грузовик загружен");
        } else System.out.println("Грузим " + carrying2 + " тонн. Вам нужен грузовик побольше");

    }


    public void print() {
        System.out.println("Брэнд - " + getBrand() + " ,вес машины - " + getWeight()
                + " кг , мощность - " + getPower() + " л/с  или " + powerKvt() + " киловат");
        System.out.println("максимальная скорость - " + getSpeed() + ", количество колес- " + getWheels());
        System.out.println("Потребление топлива - " + getFuel() + " Грузоподъемность - " + carrying + " тонн");
    }


}
