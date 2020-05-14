package hw_rest_assured;

import hw_rest_assured.dto.SpellerDataEntity;
import org.testng.annotations.DataProvider;
import utils.JsonParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class YandexSpellerDataProviders {

    public static final String CHECK_TEXT_TEST_DATA_JSON =
            "src/test/resources/hw_rest_assured/suggestion_test_data/data.json";
    public static final String IGNORE_TEST_DATA_JSON =
            "src/test/resources/hw_rest_assured/speller_ignore_test_data/data.json";
    public static final String FULL_RESPONSE_DATA_JSON =
            "src/test/resources/hw_rest_assured/spelling_mistake_test_data/data_ru_en_full_response.json";


    @DataProvider
    public Iterator<Object[]> checkTextProvider() {
        return getIterator(CHECK_TEXT_TEST_DATA_JSON);
    }

    @DataProvider
    public Iterator<Object[]> ignoreProvider() {
        return getIterator(IGNORE_TEST_DATA_JSON);
    }

    @DataProvider
    public Iterator<Object[]> fullResponseProvider() {
        return getIterator(FULL_RESPONSE_DATA_JSON);
    }

    private Iterator<Object[]> getIterator(String path) {
        List<SpellerDataEntity> testData = JsonParser
                .readData(path);
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

}
