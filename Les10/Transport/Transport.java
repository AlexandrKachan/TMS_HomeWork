package Transport;

abstract class Transport {

    private String brand;
    private double power;
    private double speed;
    private double weight;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPower() {
        return power;
    }

    public void setPower() {
        this.power = power;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed() {
        this.speed = speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight() {
        this.weight = weight;
    }


    public void print() {
        System.out.println(getBrand() + getSpeed() + getPower() + getWeight());
    }
}

