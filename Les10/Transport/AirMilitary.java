package Transport;

public class AirMilitary extends AirTransport {

    boolean ejectionYes = false; // система катапультироания
    int missile = 2;// количество рокет
    int miss = 0;

    public String getBrand() {
        return "Messerschmitt";
    }

    public double getPower() {
        return 720;
    }

    public double getSpeed() {
        return 465;
    }

    public double getWeight() {
        return 2150;
    }

    public double getWingspan() {
        return 9.85;
    }

    public double getRunway() {
        return 500;
    }

    public void shootMiss() {
        if (miss < missile) {
            System.out.println("Ракета пошла...");
        } else System.out.println("Боеприпасы отсутствуют");
        miss++;

    }

    public void eject() {
        if (ejectionYes = true) {
            System.out.println("Катапультирование прошло успешно");
        } else System.out.println("У вас нет такой системы");
    }


    public void print() {
        System.out.println("Брэнд - " + getBrand() + " ,вес самолета - " + getWeight()
                + " кг , мощность - " + getPower() + " л/с , требуется взлетная полоса  " + getRunway());
        System.out.println("максимальная скорость - " + getSpeed() + ", наличие системы катапультирования - " + ejectionYes);
        System.out.println("Размах крыльев  - " + getWingspan() + ", количество ракет - " + missile);
    }


}
