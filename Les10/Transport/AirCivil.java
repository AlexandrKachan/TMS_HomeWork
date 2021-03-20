package Transport;

public class AirCivil extends AirTransport {
    boolean businessClassYes = true; // наличие бизнескласса
    int passengers = 80; // количество пасажиров

    public String getBrand() {
        return "Boing";
    }

    public double getPower() {
        return 180000;
    }

    public double getSpeed() {
        return 1000;
    }

    public double getWeight() {
        return 19000;
    }

    public double getWingspan() {
        return 24;
    }

    public double getRunway() {
        return 2000;
    }

    public void airPassengers(int passengers2) {
        if (passengers2 <= passengers) {
            System.out.println("Хотят лететь" + passengers2 + " пассажиров. Самалет Загруже");
        } else System.out.println("Хотят лететь " + passengers2 + " пассажиров. Вам нужен самолет побольше");

    }


    public void print() {
        System.out.println("Брэнд - " + getBrand() + " ,вес самолета - " + getWeight()
                + " кг , мощность - " + getPower() + " л/с , требуется взлетная полоса  " + getRunway());
        System.out.println("максимальная скорость - " + getSpeed() + ", наличие бизнескласа - " + businessClassYes);
        System.out.println("Размах крыльев  - " + getWingspan() + ", количество пасажиров - " + passengers);
    }


}



