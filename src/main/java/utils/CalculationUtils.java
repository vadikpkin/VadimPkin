package utils;

public final class CalculationUtils {

    private CalculationUtils() {
    }

    public static String summ(String valueOne, String valueTwo) {
        return String.valueOf(Integer.parseInt(valueOne) + Integer.parseInt(valueTwo));
    }

}
