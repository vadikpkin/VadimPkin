package hw_rest_assured;

import hw_rest_assured.dto.SpellerSuggestion;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class YandexSpellerAssertions {

    private SpellerSuggestion[] result;

    public YandexSpellerAssertions verifySuggestion(List<String> expectedSuggestions) {
        for (int i = 0; i < expectedSuggestions.size(); i++) {
            assertThat(expectedSuggestions.get(i)).isEqualTo(result[i].getSuggestionsAsString());
        }
        return this;
    }

    public YandexSpellerAssertions verifySuggestion(SpellerSuggestion[] expectedSuggestions) {
        assertThat(result).isEqualTo(expectedSuggestions);
        return this;
    }

    public YandexSpellerAssertions verifyEmptyResponse() {
        assertThat(result).isEmpty();
        return this;
    }

    public YandexSpellerAssertions verifyNotEmptyResponse() {
        assertThat(result).isNotEmpty();
        return this;
    }

    public YandexSpellerAssertions verifyCode(String expectedCode) {
        return verify(expectedCode, SpellerSuggestion::getCode);
    }

    public YandexSpellerAssertions verifyPos(String pos) {
        return verify(pos, SpellerSuggestion::getPos);
    }

    public YandexSpellerAssertions verifyRow(String row) {
        return verify(row, SpellerSuggestion::getRow);
    }

    public YandexSpellerAssertions verifyCol(String col) {
        return verify(col, SpellerSuggestion::getCol);
    }

    public YandexSpellerAssertions verifyLen(String len) {
        return verify(len, SpellerSuggestion::getLen);
    }

    public YandexSpellerAssertions verifyWord(String word) {
        return verify(word, SpellerSuggestion::getWord);
    }

    private YandexSpellerAssertions verify(String expectedCode, Function<SpellerSuggestion, String> function) {
        for (SpellerSuggestion spellerSuggestion : result) {
            assertThat(function.apply(spellerSuggestion)).isEqualTo(expectedCode);
        }
        return this;
    }
}
