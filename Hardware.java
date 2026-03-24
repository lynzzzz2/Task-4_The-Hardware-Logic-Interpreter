package org.example;

public abstract class Hardware {
    private int id;
    private String brand;
    private int spec;

    public Hardware(int id, String brand, int spec) {
        this.id = id;
        this.brand = brand;
        this.spec = spec;
    }

    public int getSpec() { return spec; }
    public String getBrand() { return brand; }
    public int getId() { return id; }

    public abstract String interpretSpec();

    public void display() {
        System.out.println(id + " | " + brand + " | " + interpretSpec());
    }
}
