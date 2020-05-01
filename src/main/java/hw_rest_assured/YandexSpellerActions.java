package hw_rest_assured;

import com.google.gson.Gson;
import hw_rest_assured.dto.SpellerSuggestion;
import hw_rest_assured.enums.YandexSpellerLang;
import hw_rest_assured.enums.YandexSpellerOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static hw_rest_assured.URI.*;

public class YandexSpellerActions {

    public SpellerSuggestion[] checkText(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", text);

        return new Gson().fromJson(
                new YandexSpellerService()
                        .getWithParams(CHECK_TEXT, params)
                        .getBody().asString(), SpellerSuggestion[].class);
    }

    public SpellerSuggestion[] checkText(String text, YandexSpellerLang... langs) {
        Map<String, Object> params = new HashMap<>();
        String lang = Arrays.stream(langs).map(e -> e.value).collect(Collectors.joining(","));
        params.put("text", text);
        params.put("lang", lang);

        return new Gson().fromJson(
                new YandexSpellerService()
                        .getWithParams(CHECK_TEXT, params)
                        .getBody().asString(), SpellerSuggestion[].class);
    }

    public SpellerSuggestion[] checkText(String text, YandexSpellerOptions... option) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", text);
        params.put("options", Arrays.stream(option).map(e -> e.intValue).mapToInt(Integer::intValue).sum());

        return new Gson().fromJson(
                new YandexSpellerService()
                        .getWithParams(CHECK_TEXT, params)
                        .getBody().asString(), SpellerSuggestion[].class);
    }
}
