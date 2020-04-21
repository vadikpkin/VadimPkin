package hw_jdi.entities;

import lombok.*;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MetalsAndColorsData {
    private int[] summary;
    private String color;
    private String metals;
    private String[] vegetables;
    private String[] elements;

    public int getOdd() {
        return this.summary[0];
    }

    public int getEven() {
        return this.summary[1];
    }

    public String getVegetablesAsString() {
        return getAsString(vegetables);

    }

    public String getElementsAsString() {
        return getAsString(elements);
    }

    private String getAsString(String[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(elements).forEach(e -> stringBuilder.append(e).append(", "));
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(",")).trim();
    }

}
