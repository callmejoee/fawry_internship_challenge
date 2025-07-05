package service;

import model.Shippable;
import utils.ShippingInfo;
import utils.WeightUtils;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {

    private static final double SHIPPING_RATE = 5.0;
    private static final double BASE_FEE = 10.0;


    public ShippingInfo calculateShipping(List<CartItem> items) {
        double totalWeight = 0.0;
        List<String> lines = new ArrayList<>();


        for (CartItem item : items) {
            Shippable shippable = (Shippable) item.getProduct();
            double itemTotalWeight = shippable.getWeight() * item.getQuantity();
            totalWeight += itemTotalWeight;
           String line = (item.getQuantity() + "x " + item.getProduct().getName() + " " + WeightUtils.printWeight(itemTotalWeight));
           lines.add(line);
        }
        double shippingCost = BASE_FEE + SHIPPING_RATE * WeightUtils.toKilograms(totalWeight);
        return new ShippingInfo(lines, totalWeight, shippingCost);
    }
}
