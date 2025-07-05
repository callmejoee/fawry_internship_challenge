package service;
import model.Product;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0){
            System.out.println("Quantity can not be negative");
            return;
        }
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }
}
