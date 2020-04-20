package hw_jdi.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MetalsAndColorsData {
    private int[] summary;
    private String color;
    private String metal;
    private String[] vegetable;
    private String[] element;

}
