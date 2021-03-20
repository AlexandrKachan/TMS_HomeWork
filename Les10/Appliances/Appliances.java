package Appliances;

abstract class Appliances {

    private String brand;
    boolean plugIn = false;


    public String getBrand(String brand) {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
