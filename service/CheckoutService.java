package service;

import model.Customer;
import model.Expirable;
import utils.ShippingInfo;

public class CheckoutService {

    public void checkout(Customer customer, Cart cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        for (CartItem item : cart.getItems()) {

            if (item.getProduct() instanceof Expirable && ((Expirable) item.getProduct()).isExpired()) {

                System.out.println("Item is expired: " + item.getProduct().getName());
                return;

            }
        }

        double subTotal = cart.getSubTotal();

        ShippingService shipping = new ShippingService();

        ShippingInfo shippingInfo = shipping.calculateShipping(cart.getItems());

        double shippingCost = shippingInfo.getCost();

        double total = shippingCost + subTotal;

        if (!customer.canAfford(total)) {
            System.out.println("Insufficient Balance");
            return;
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().deductProduct(item.getQuantity());
        }

        customer.deductBalance(total);

        shippingInfo.print();

        System.out.println("** Checkout receipt **");

        for (CartItem item : cart.getItems()) {

            String name = item.getProduct().getName();
            int quantity = item.getQuantity();
            double price = item.getTotalPrice();

            System.out.printf("%dx %s %.2f%n", quantity, name, price);

        }

        System.out.println("------------");
        System.out.println("Subtotal " + subTotal);
        System.out.println("Shipping " + shippingCost);
        System.out.println("Amount " + total);

        System.out.println("Remaining Balance: " + customer.getCurrentBalance());




    }

}
