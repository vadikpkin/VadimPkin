package hw_rest_assured.enums;


public enum YandexSpellerLang {
    RUSSIAN("ru"),

    UKRAINIAN("uk"),

    ENGLISH("en"),

    DEFAULT("ru,en");

    public String value;

    YandexSpellerLang(String value) {
        this.value = value;
    }
}
