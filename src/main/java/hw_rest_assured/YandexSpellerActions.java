package hw_rest_assured;

import com.google.gson.Gson;
import hw_rest_assured.dto.SpellerDataEntity;
import hw_rest_assured.dto.SpellerSuggestion;

import java.util.HashMap;
import java.util.Map;

import static hw_rest_assured.URI.*;

public class YandexSpellerActions {

    public SpellerSuggestion[] checkText(SpellerDataEntity dataEntity) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", dataEntity.getTextRequest());
        if (dataEntity.getOptions() != null)
            params.put("options", dataEntity.getOptions().value);
        if (dataEntity.getLang() != null)
            params.put("lang", dataEntity.getLang().value);

        return new Gson().fromJson(
                new YandexSpellerService()
                        .getWithParams(CHECK_TEXT, params)
                        .getBody().asString(), SpellerSuggestion[].class);
    }
}
