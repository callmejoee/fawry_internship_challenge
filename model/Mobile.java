package model;

public class Mobile extends Product implements Shippable {

    private double weight;

    public Mobile(String name, Double price, Integer quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;

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
