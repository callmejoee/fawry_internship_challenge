package service;

import model.Product;
import model.Shippable;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }


    public void addItem(Product product, int quantity){

        try {
            product.deductProduct(quantity); // validates and checks in class

            for (CartItem cartItem : items) {
                if (cartItem.getProduct().getName().equals(product.getName())) {
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                    return;
                }
            }

            CartItem item = new CartItem(product, quantity);
            items.add(item);

        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
    }

    public double getSubTotal() {

        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<CartItem> getShippableItems() {

        List<CartItem> listOfItems = new ArrayList<>();

        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable) {
               listOfItems.add(item);
            }
        }
        return listOfItems;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
