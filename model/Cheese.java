package model;

import java.time.LocalDate;

public class Cheese extends Product implements Shippable, Expirable {

    private LocalDate expirationDate;
    private double weight;

    public Cheese(String name, Double price, Integer quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;

    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isBefore(LocalDate.now())){
            System.out.println("Can not set expiration date before today");
            return;
        }
        this.expirationDate = expirationDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0){
            System.out.println("Weight can not be a value less than zero");
            return;
        }
        this.weight = weight;
    }
}
