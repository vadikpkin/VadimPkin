package hw_rest_assured;

import hw_rest_assured.dto.SpellerSuggestion;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class YandexSpellerAssertions {


    public void verifySuggestion(SpellerSuggestion[] actualSuggestions, List<String> expectedSuggestions) {
        for (int i = 0; i < expectedSuggestions.size(); i++) {
            assertThat(expectedSuggestions.get(i)).isEqualTo(actualSuggestions[i].getSuggestionsAsString());
        }
    }

    public void verifyFullResponseEntity(SpellerSuggestion[] actualSuggestions, SpellerSuggestion[] expectedSuggestions) {
        assertThat(actualSuggestions).isEqualTo(expectedSuggestions);
    }

    public void verifyEmptyResponse(SpellerSuggestion[] actualSuggestions) {
        assertThat(actualSuggestions).isEmpty();
    }
}
