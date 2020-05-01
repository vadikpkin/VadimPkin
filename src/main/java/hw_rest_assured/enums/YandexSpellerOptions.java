package hw_rest_assured.enums;

public enum YandexSpellerOptions {

    IGNORE_DIGITS(2),

    IGNORE_URLS(4),

    FIND_REPEAT_WORDS(8),

    IGNORE_CAPITALIZATION(512);

    public int intValue;

    YandexSpellerOptions(int value) {
        this.intValue = value;
    }
}
