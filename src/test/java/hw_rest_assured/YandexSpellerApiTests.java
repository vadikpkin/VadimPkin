package hw_rest_assured;

import hw_rest_assured.dto.SpellerDataEntity;
import hw_rest_assured.dto.SpellerSuggestion;
import hw_rest_assured.enums.YandexSpellerLang;
import hw_rest_assured.enums.YandexSpellerOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw_rest_assured.enums.YandexSpellerLang.*;
import static hw_rest_assured.enums.YandexSpellerOptions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class YandexSpellerApiTests {
    private YandexSpellerActions yandexSpellerActions;

    @BeforeClass
    public void initData() {
        yandexSpellerActions = new YandexSpellerActions();
    }


    @Test(dataProvider = "dataProviderSpellingMistakeRuEn", dataProviderClass = YandexSpellerDataProviders.class)
    public void spellingMistakeTestDefaultLangPass(SpellerDataEntity testData) {
        assertRequest(testData);
    }

    @Test(dataProvider = "dataProviderSpellingMistakeUk", dataProviderClass = YandexSpellerDataProviders.class)
    public void spellingMistakeTestUkrainianPass(SpellerDataEntity testData) {
        assertRequest(testData, UKRAINIAN);
    }

    @Test(dataProvider = "dataProviderUpperCaseMistake", dataProviderClass = YandexSpellerDataProviders.class)
    public void upperCaseMistakeDefaultLangPass(SpellerDataEntity testData) {
        assertRequest(testData);
    }

    @Test(dataProvider = "dataProviderUpperCaseMistakeUk", dataProviderClass = YandexSpellerDataProviders.class)
    public void upperCaseMistakeUkrainianLangPass(SpellerDataEntity testData) {
        assertRequest(testData, UKRAINIAN);
    }

    @Test(groups = {"smoke"},dataProvider = "dataProviderWordsDuplicationMistake", dataProviderClass = YandexSpellerDataProviders.class)
    public void duplicationMistakeDefaultLangPass(SpellerDataEntity testData) {
        assertRequest(testData, FIND_REPEAT_WORDS);
    }

    @Test(dataProvider = "dataProviderIgnoreCapitalization", dataProviderClass = YandexSpellerDataProviders.class)
    public void ignoreCapitalizationTestDefaultLangPass(SpellerDataEntity testData) {
        assertRequest(testData, IGNORE_CAPITALIZATION);
    }

    @Test(dataProvider = "dataProviderIgnoreDigits", dataProviderClass = YandexSpellerDataProviders.class)
    public void ignoreDigitsTestDefaultLangPass(SpellerDataEntity testData) {
        assertRequest(testData, IGNORE_DIGITS);
    }

    @Test(dataProvider = "dataProviderIgnoreUrls", dataProviderClass = YandexSpellerDataProviders.class)
    public void ignoreUrlTestDefaultLangPass(SpellerDataEntity testData) {
        assertRequest(testData, IGNORE_URLS);
    }

    private void assertRequest(SpellerDataEntity testData) {
        SpellerSuggestion[] actualSpellerSuggestions = yandexSpellerActions.checkText(testData.getTextRequest());
        assertThat(actualSpellerSuggestions).isEqualTo(testData.getSuggestions());
    }

    private void assertRequest(SpellerDataEntity testData, YandexSpellerOptions... options) {
        SpellerSuggestion[] actualSpellerSuggestions = yandexSpellerActions.checkText(testData.getTextRequest(), options);
        assertThat(actualSpellerSuggestions).isEqualTo(testData.getSuggestions());
    }

    private void assertRequest(SpellerDataEntity testData, YandexSpellerLang... langs) {
        SpellerSuggestion[] actualSpellerSuggestions = yandexSpellerActions.checkText(testData.getTextRequest(), langs);
        assertThat(actualSpellerSuggestions).isEqualTo(testData.getSuggestions());
    }

}
