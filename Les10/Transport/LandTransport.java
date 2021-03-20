package Transport;

abstract class LandTransport extends Transport {
    int wheels;// количество колес
    double fuel; // расход топлива

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}