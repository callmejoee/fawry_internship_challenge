package model;

public class Product {
    
    private String name;
    private double price;
    private int quantity;

    public Product(String name, Double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void deductProduct(int quantity){
        if (getQuantity() == 0){
            System.out.println("model.Product is out of stock");
            return;
        }
        else if (quantity <= 0){
            System.out.println("Please add a positive quantity");
            return;
        }
        else if (getQuantity() < quantity){
            System.out.println("Insufficient Quantity");
            return;
        }

        setQuantity(this.quantity - quantity);
    }

}
