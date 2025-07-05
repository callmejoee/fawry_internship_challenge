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
        // leave the expiration date can be before today
        // in case they want to sell an expired item
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
