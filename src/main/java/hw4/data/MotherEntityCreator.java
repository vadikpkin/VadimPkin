package hw4.data;

import hw4.enums.Colors;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import java.util.Arrays;

public class MotherEntityCreator {

    public static FormData.Builder getDefaultFormDataBuilder() {
        return new FormData.Builder()
                .setEven("2")
                .setOdd("1")
                .setColors(Colors.COLORS)
                .setVegetables(Arrays.asList(Vegetables.VEGETABLES))
                .setMetals(Metals.METALS);
    }
}
