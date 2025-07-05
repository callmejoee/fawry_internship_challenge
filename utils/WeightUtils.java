package utils;

public class WeightUtils {
    public static double toKilograms(double grams) {
        return grams / 1000;
    }

    public static String printWeight(double grams) {
        if (grams >= 1000) {
            return String.format("%.2fkg", toKilograms(grams));
        } else {
            return String.format("%.0fg", grams);
        }
    }
}
