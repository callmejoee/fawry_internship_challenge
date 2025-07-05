import model.*;
import service.Cart;
import service.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Youssef", 75);

        Cheese cheese = new Cheese("Feta Cheese", 50.0, 1000, (LocalDate.now().plusMonths(1)), 100);
        Biscuits biscuits = new Biscuits("Biskrem", 10.0, 6, LocalDate.now().minusDays(1), 100);
        MobileScratchCard mobileScratchCard = new MobileScratchCard("Vodafone 10 EGP", 16.0, 10);
        TV tv = new TV("LG", 1500.0, 2, 15.0);

        Cart cart = new Cart();
        cart.addItem(cheese, 1);
//        cart.addItem(tv, 3);
//        cart.addItem(biscuits, 1);

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);

    }
}
