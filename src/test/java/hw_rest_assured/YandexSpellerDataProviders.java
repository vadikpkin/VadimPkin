package hw_rest_assured;

import hw_rest_assured.dto.SpellerDataEntity;
import org.testng.annotations.DataProvider;
import utils.JsonParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class YandexSpellerDataProviders {

    public static final String SPELLING_MISTAKE_TEST_DATA_DATA_RU_EN_JSON =
            "src/test/resources/hw_rest_assured/spelling_mistake_test_data/data_ru_en_full_response.json";
    public static final String SPELLING_MISTAKE_TEST_DATA_DATA_UK_JSON =
            "src/test/resources/hw_rest_assured/spelling_mistake_test_data/data_uk.json";
    public static final String UPPER_CASE_MISTAKE_TEST_DATA_DATA_RU_EN_JSON =
            "src/test/resources/hw_rest_assured/upper_case_mistake_test_data/data_ru_en.json";
    public static final String UPPER_CASE_MISTAKE_TEST_DATA_DATA_UK_JSON =
            "src/test/resources/hw_rest_assured/upper_case_mistake_test_data/data_uk.json";
    public static final String DUPLICATION_MISTAKE_TEST_DATA_DATA_JSON =
            "src/test/resources/hw_rest_assured/duplication_mistake_test_data/data.json";
    public static final String IGNORE_CAPITALIZATION_TEST_DATA_DATA_JSON =
            "src/test/resources/hw_rest_assured/ignore_capitalization_test_data/data.json";
    public static final String IGNORE_DIGITS_TEST_DATA_DATA_JSON =
            "src/test/resources/hw_rest_assured/ignore_digits_test_data/data.json";
    public static final String IGNORE_URLS_TEST_DATA_DATA_JSON =
            "src/test/resources/hw_rest_assured/ignore_urls_test_data/data.json";

    @DataProvider
    public Iterator<Object[]> dataProviderSpellingMistakeRuEn() {
        return getIterator(SPELLING_MISTAKE_TEST_DATA_DATA_RU_EN_JSON);
    }

    @DataProvider
    public Iterator<Object[]> dataProviderSpellingMistakeUk() {
        return getIterator(SPELLING_MISTAKE_TEST_DATA_DATA_UK_JSON);
    }

    @DataProvider
    public Iterator<Object[]> dataProviderUpperCaseMistake() {
        return getIterator(UPPER_CASE_MISTAKE_TEST_DATA_DATA_RU_EN_JSON);
    }

    @DataProvider
    public Iterator<Object[]> dataProviderUpperCaseMistakeUk() {
        return getIterator(UPPER_CASE_MISTAKE_TEST_DATA_DATA_UK_JSON);
    }

    @DataProvider
    public Iterator<Object[]> dataProviderWordsDuplicationMistake() {
        return getIterator(DUPLICATION_MISTAKE_TEST_DATA_DATA_JSON);
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreCapitalization() {
        return getIterator(IGNORE_CAPITALIZATION_TEST_DATA_DATA_JSON);
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreDigits() {
        return getIterator(IGNORE_DIGITS_TEST_DATA_DATA_JSON);
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreUrls() {
        return getIterator(IGNORE_URLS_TEST_DATA_DATA_JSON);
    }

    @DataProvider
    public Object[][] dataProviderCorrectWord() {
        return new Object[][]{
                {"dog"},
                {"собака"}
        };
    }

    private Iterator<Object[]> getIterator(String path) {
        List<SpellerDataEntity> testData = JsonParser
                .readData(path);
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

}
