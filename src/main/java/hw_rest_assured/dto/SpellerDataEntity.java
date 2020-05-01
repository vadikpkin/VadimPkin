package hw_rest_assured.dto;

import lombok.*;

@Data
public class SpellerDataEntity {
    private String textRequest;
    private SpellerSuggestion[] suggestions;
}
