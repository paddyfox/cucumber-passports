package kainos.specs.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LanguageCode {
    ENGLISH("en"),
    WELSH("cy");

    private final String languageCode;

}
