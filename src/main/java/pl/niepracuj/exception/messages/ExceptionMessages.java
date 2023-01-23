package pl.niepracuj.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessages {

    ENTITY_FOR_PROVIDED_ID_NOT_FOUND("Encja %s dla podanego id: %s nie istnieje"), //string formatter za s mozna podstawic stringa
    USER_FOR_PROVIDED_USERNAME_NOT_FOUND("Użytkownik %s nie istnieje"); //$s tzn. uztkownika dany nie istnieje

    private final String message;

}
