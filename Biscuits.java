import java.time.LocalDate;

public class Biscuits extends Product implements Shippable, Expirable {

    private LocalDate expirationDate;
    private double weight;

    public Biscuits(String name, Double price, Integer quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;

    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
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
