package utils;

import java.util.ArrayList;
import java.util.List;

public class ShippingInfo {

    private final List<String> lines = new ArrayList<>();
    private final double totalWeight;

    private final double cost;

    public ShippingInfo(List<String> lines, double totalWeight, double cost) {
        this.lines.addAll(lines);
        this.totalWeight = totalWeight;
        this.cost = cost;
    }

    public List<String> getLines() {
        return lines;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getCost() {
        return cost;
    }

    public void print() {
        System.out.println("** Shipment Details **");;
        for (String line : lines) {
            System.out.println(line);
        }

        System.out.println("Total Package Weight: " + WeightUtils.printWeight(totalWeight));
    }
}
