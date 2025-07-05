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

                System.out.println("Item is expired: " + item.getProduct());
                return;

            }
            item.getProduct().deductProduct(item.getQuantity());

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

        customer.deductBalance(total);

        shippingInfo.print();


    }

}
