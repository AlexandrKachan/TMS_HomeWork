package Transport;

public class LandPassenger extends LandTransport {
    String type = "Седан"; //тип кузова
    int passengers = 5;

    public String getBrand() {
        return "Renault";
    }

    public double getPower() {
        return 180;
    }

    public double getSpeed() {
        return 200;
    }

    public double getWeight() {
        return 1900;
    }

    public int getWheels() {
        return 4;
    }

    public double getFuel() {
        return 8;
    }

    public double powerKvt() {
        return getPower() * 0.74;
    }

    //    private double useFuel() {
//        double useFuel = distance/100*getFuel();
//        return useFuel;
//    }
    public double fuelDist(double time) {
        double distance = time * getSpeed();
        double useFuel = distance / 100 * getFuel();

        System.out.println("За время " + time + " часа, автомобиль " + getBrand() + "  двигаясь с максимальной скоростью "
                + getSpeed() + " км/ч израсходует " + useFuel + "  литров топлива");

        return useFuel;
    }


    public void print() {
        System.out.println("Брэнд - " + getBrand() + " ,вес машины - " + getWeight()
                + " кг , мощность - " + getPower() + " л/с  или " + powerKvt() + " киловат");
        System.out.println("максимальная скорость - " + getSpeed() + ", количество колес- " + getWheels() + ", потребление топлива - "
                + getFuel());
        System.out.println("Грузоподъемность - " + " , тип кузова  - " + type +
                ", количество пасажиров - " + passengers);
    }
}
