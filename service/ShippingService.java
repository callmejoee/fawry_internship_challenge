package service;

import model.Shippable;
import utils.ShippingInfo;
import java.util.ArrayList;
import java.util.List;

public class ShippingService {

    private static final double SHIPPING_RATE = 5.0;

    public ShippingInfo calculateShipping(List<CartItem> items) {
        double totalWeight = 0.0;
        List<String> lines = new ArrayList<>();


        for (CartItem item : items) {
            Shippable shippable = (Shippable) item.getProduct();
            double itemTotalWeight = shippable.getWeight() * item.getQuantity();
            totalWeight += itemTotalWeight;
           String line = (item.getQuantity() + "x " + item.getProduct().getName() + " " + itemTotalWeight);
           lines.add(line);
        }
        double shippingCost = SHIPPING_RATE * totalWeight;
        return new ShippingInfo(lines, totalWeight, shippingCost);
    }
}
