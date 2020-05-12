package hw_rest_assured.dto;

import lombok.*;

import java.util.List;

@Data
public class SpellerDataEntity {
    private int id;
    private String textRequest;
    private List<String> suggestionsTexts;
    private SpellerSuggestion[] suggestions;

    public SpellerDataEntity(String textRequest, List<String> suggestionsTexts) {
        this.textRequest = textRequest;
        this.suggestionsTexts = suggestionsTexts;
    }
}
