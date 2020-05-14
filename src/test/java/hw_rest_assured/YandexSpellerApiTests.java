package hw_rest_assured;

import hw_rest_assured.dto.SpellerDataEntity;
import hw_rest_assured.dto.SpellerSuggestion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class YandexSpellerApiTests {


    private YandexSpellerActions yandexSpellerActions;

    @BeforeClass
    public void init() {
        yandexSpellerActions = new YandexSpellerActions();
    }

    @Test(dataProviderClass = YandexSpellerDataProviders.class, dataProvider = "checkTextProvider")
    public void checkTextMethodSuggestionsTest(SpellerDataEntity spellerDataEntity) {
        //Sending request with incorrect text
        SpellerSuggestion[] result = yandexSpellerActions.checkText(spellerDataEntity);
        //Verifying suggestions
        new YandexSpellerAssertions(result)
                .verifyNotEmptyResponse()
                .verifySuggestion(spellerDataEntity.getSuggestionsTexts());
        //Writing suggestions to text request of test data
        spellerDataEntity.setTextRequest(Arrays.stream(result).map(SpellerSuggestion::getSuggestionsAsString)
                .collect(Collectors.joining(",")));
        //Sending request with suggestions for speller
        result = yandexSpellerActions.checkText(spellerDataEntity);
        //Verifying that suggestion are correct
        new YandexSpellerAssertions(result).verifyEmptyResponse();
    }

    @Test(dataProviderClass = YandexSpellerDataProviders.class, dataProvider = "ignoreProvider")
    public void correctWordAndIgnoreDefaultLangTestPass(SpellerDataEntity spellerDataEntity) {
        SpellerSuggestion[] result = yandexSpellerActions.checkText(spellerDataEntity);
        new YandexSpellerAssertions(result)
                .verifyEmptyResponse();
    }

    @Test(dataProvider = "fullResponseProvider", dataProviderClass = YandexSpellerDataProviders.class)
    public void checkTextFullResponseVerifyTest(SpellerDataEntity spellerDataEntity) {
        SpellerSuggestion[] result = yandexSpellerActions.checkText(spellerDataEntity);
        new YandexSpellerAssertions(result)
                .verifyNotEmptyResponse()
                .verifyCode(spellerDataEntity.getCodesAsString())
                .verifyPos(spellerDataEntity.getPosAsString())
                .verifyRow(spellerDataEntity.getRowsAsString())
                .verifyCol(spellerDataEntity.getColsAsString())
                .verifyLen(spellerDataEntity.getLenAsString())
                .verifyWord(spellerDataEntity.getWordsAsString())
                .verifySuggestion(spellerDataEntity.getSuggestions());
    }

}
