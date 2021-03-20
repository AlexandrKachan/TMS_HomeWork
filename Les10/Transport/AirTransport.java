package Transport;

abstract class AirTransport extends Transport {
    double wingspan; // размах крыльев
    double runway; // взлетная полоса

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public double getRunway() {
        return runway;
    }

    public void setRunway(double runway) {
        this.runway = runway;
    }

}
