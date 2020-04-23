package hw_jdi.entities;

import lombok.*;

import static java.lang.String.*;
import static java.util.Arrays.stream;

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

    public String getExpectedResult() {
        return format(
                        "Summary: %s\n" +
                        "Elements: %s\n" +
                        "Color: %s\n" +
                        "Metal: %s\n" +
                        "Vegetables: %s",
                stream(this.summary).sum(), this.getElementsAsString(), this.color, this.metals, this.getVegetablesAsString());
    }

    private String getAsString(String[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        return String.join(", ", elements);
    }

}
