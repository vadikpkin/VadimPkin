package hw_rest_assured;

import hw_rest_assured.dto.SpellerDataEntity;
import hw_rest_assured.dto.SpellerSuggestion;
import hw_rest_assured.enums.YandexSpellerLang;
import hw_rest_assured.enums.YandexSpellerOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw_rest_assured.enums.YandexSpellerLang.*;
import static hw_rest_assured.enums.YandexSpellerOptions.*;


public class YandexSpellerApiTests {
    private YandexSpellerActions yandexSpellerActions;

    @BeforeClass
    public void initData() {
        yandexSpellerActions = new YandexSpellerActions();
    }

    @Test(dataProvider = "dataProviderCorrectWord", dataProviderClass = YandexSpellerDataProviders.class)
    public void correctWordDefaultLangTestPass(Object testData) {
        SpellerSuggestion[] actualSuggestions = yandexSpellerActions.checkText(testData.toString());
        new YandexSpellerAssertions()
                .verifyEmptyResponse(actualSuggestions);

    }

    @Test(dataProvider = "dataProviderSpellingMistakeRuEn", dataProviderClass = YandexSpellerDataProviders.class)
    public void spellingMistakeTestDefaultLangFullResponseVerifyPass(SpellerDataEntity testData) {
        SpellerSuggestion[] actualSuggestions = yandexSpellerActions.checkText(testData.getTextRequest());
        new YandexSpellerAssertions()
                .verifyFullResponseEntity(actualSuggestions, testData.getSuggestions());
    }

    @Test(dataProvider = "dataProviderSpellingMistakeUk", dataProviderClass = YandexSpellerDataProviders.class)
    public void spellingMistakeTestUkrainianSuggestionVerifyPass(SpellerDataEntity testData) {
        assertSuggestions(testData, UKRAINIAN);
    }

    @Test(dataProvider = "dataProviderUpperCaseMistake", dataProviderClass = YandexSpellerDataProviders.class)
    public void upperCaseMistakeDefaultLangSuggestionVerifyPass(SpellerDataEntity testData) {
        assertSuggestions(testData);
    }

    @Test(dataProvider = "dataProviderUpperCaseMistakeUk", dataProviderClass = YandexSpellerDataProviders.class)
    public void upperCaseMistakeUkrainianLangSuggestionVerifyPass(SpellerDataEntity testData) {
        assertSuggestions(testData, UKRAINIAN);
    }

    @Test(dataProvider = "dataProviderWordsDuplicationMistake", dataProviderClass = YandexSpellerDataProviders.class)
    public void duplicationMistakeDefaultLangSuggestionVerifyPass(SpellerDataEntity testData) {
        assertSuggestions(testData, FIND_REPEAT_WORDS);
    }

    @Test(dataProvider = "dataProviderIgnoreCapitalization", dataProviderClass = YandexSpellerDataProviders.class)
    public void ignoreCapitalizationTestDefaultLangSuggestionVerifyPass(SpellerDataEntity testData) {
        assertSuggestions(testData, IGNORE_CAPITALIZATION);
    }

    @Test(dataProvider = "dataProviderIgnoreDigits", dataProviderClass = YandexSpellerDataProviders.class)
    public void ignoreDigitsTestDefaultLangSuggestionVerifyPass(SpellerDataEntity testData) {
        assertSuggestions(testData, IGNORE_DIGITS);
    }

    @Test(dataProvider = "dataProviderIgnoreUrls", dataProviderClass = YandexSpellerDataProviders.class)
    public void ignoreUrlTestDefaultLangSuggestionVerifyPass(SpellerDataEntity testData) {
        assertSuggestions(testData, IGNORE_URLS);
    }

    private void assertSuggestions(SpellerDataEntity testData) {
        SpellerSuggestion[] actualSpellerSuggestions = yandexSpellerActions.checkText(testData.getTextRequest());
        verifySuggestions(actualSpellerSuggestions, testData);
    }
    
    private void assertSuggestions(SpellerDataEntity testData, YandexSpellerOptions... options) {
        SpellerSuggestion[] actualSpellerSuggestions = yandexSpellerActions.checkText(testData.getTextRequest(), options);
        verifySuggestions(actualSpellerSuggestions, testData);
    }

    private void assertSuggestions(SpellerDataEntity testData, YandexSpellerLang... langs) {
        SpellerSuggestion[] actualSpellerSuggestions = yandexSpellerActions.checkText(testData.getTextRequest(), langs);
        verifySuggestions(actualSpellerSuggestions, testData);
    }

    private void verifySuggestions(SpellerSuggestion[] actualSpellerSuggestions, SpellerDataEntity testData) {
        new YandexSpellerAssertions()
                .verifySuggestion(actualSpellerSuggestions, testData.getSuggestionsTexts());
    }
}
