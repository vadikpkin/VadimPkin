package hw_rest_assured;

import hw_rest_assured.dto.SpellerDataEntity;
import org.testng.annotations.DataProvider;
import utils.JsonParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class YandexSpellerDataProviders {

    @DataProvider
    public Iterator<Object[]> dataProviderSpellingMistakeRuEn() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/spelling_mistake_test_data/data_ru_en.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderSpellingMistakeUk() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/spelling_mistake_test_data/data_uk.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderUpperCaseMistake() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/upper_case_mistake_test_data/data_ru_en.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderUpperCaseMistakeUk() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/upper_case_mistake_test_data/data_uk.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderWordsDuplicationMistake() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/duplication_mistake_test_data/data.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreCapitalization() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/ignore_capitalization_test_data/data.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreDigits() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/ignore_digits_test_data/data.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderIgnoreUrls() {
        List<SpellerDataEntity> testData = JsonParser
                .readData("src/test/resources/hw_rest_assured/ignore_urls_test_data/data.json");
        Collection<Object[]> data = new ArrayList<Object[]>();
        testData.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

}
