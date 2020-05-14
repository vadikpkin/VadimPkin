package hw_rest_assured.dto;

import hw_rest_assured.enums.YandexSpellerLang;
import hw_rest_assured.enums.YandexSpellerOptions;
import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Data
public class SpellerDataEntity {
    private int id;
    private String textRequest;
    private List<String> suggestionsTexts;
    private SpellerSuggestion[] suggestions;
    private YandexSpellerOptions options;
    private YandexSpellerLang lang;
    private String code;


    public String getCodesAsString() {
        return getCollect(() -> SpellerSuggestion::getCode);
    }

    public String getRowsAsString() {
        return getCollect(() -> SpellerSuggestion::getRow);
    }

    public String getColsAsString() {
        return getCollect(() -> SpellerSuggestion::getCol);
    }

    public String getPosAsString() {
        return getCollect(() -> SpellerSuggestion::getPos);
    }


    public String getLenAsString() {
        return getCollect(() -> SpellerSuggestion::getLen);
    }

    public String getWordsAsString() {
        return getCollect(() -> SpellerSuggestion::getWord);
    }

    private String getCollect(Supplier<Function<SpellerSuggestion, String>> supplier) {
        return Arrays.stream(suggestions).map(supplier.get()).collect(Collectors.joining(", "));
    }




}
