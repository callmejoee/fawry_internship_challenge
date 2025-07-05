package model;

public class Customer {

    private String name;
    private double currentBalance;

    public Customer(String name, double currentBalance) {
        this.name = name;
        this.currentBalance = currentBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean canAfford(double cost){
        return getCurrentBalance() > cost;
    }

    public void deductBalance(double amount){
        if (canAfford(amount)){
            setCurrentBalance(getCurrentBalance() - amount);
        }
        else {
            System.out.println("Your current balance isn't sufficient");
        }
    }
}
