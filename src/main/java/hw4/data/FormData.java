package hw4.data;

import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import java.util.List;

public class FormData {
    private String odd;
    private String even;
    private Colors colors;
    private Metals metals;
    private List<Vegetables> vegetables;
    private List<Elements> elements;

    public FormData(String odd, String even, Colors colors, Metals metals, List<Vegetables> vegetables, List<Elements> elements) {
        this.odd = odd;
        this.even = even;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
        this.elements = elements;
    }

    public String getOdd() {
        return odd;
    }

    public String getEven() {
        return even;
    }

    public String getColors() {
        return colors.toString();
    }

    public String getMetals() {
        return metals.toString();
    }

    public List<Vegetables> getVegetables() {
        return vegetables;

    }

    public List<Elements> getElements() {
        return elements;
    }

    public String getVegetablesAsString() {
        if (vegetables == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        vegetables.forEach(e -> stringBuilder.append(e.toString()));
        return stringBuilder.toString();

    }

    public String getElementsAsString() {
        if (elements == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(e -> stringBuilder.append(e.toString()));
        return stringBuilder.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String odd;
        private String even;
        private Colors colors;
        private Metals metals;
        private List<Vegetables> vegetables;
        private List<Elements> elements;


        public Builder() {
        }

        public Builder setOdd(String odd) {
            this.odd = odd;
            return this;
        }

        public Builder setEven(String even) {
            this.even = even;
            return this;

        }

        public Builder setColors(Colors colors) {
            this.colors = colors;
            return this;

        }

        public Builder setMetals(Metals metals) {
            this.metals = metals;
            return this;

        }

        public Builder setVegetables(List<Vegetables> vegetables) {
            this.vegetables = vegetables;
            return this;

        }

        public Builder setElements(List<Elements> elements) {
            this.elements = elements;
            return this;

        }

        public FormData build() {
            return new FormData(odd, even, colors, metals, vegetables, elements);
        }
    }
}
