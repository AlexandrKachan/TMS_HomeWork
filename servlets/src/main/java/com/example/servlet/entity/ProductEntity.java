package com.example.servlet.entity;

public class ProductEntity {

    private String title;
    private double prise;

    public ProductEntity(String title, double prise) {
        this.title = title;
        this.prise = prise;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }
}
