package ru.gretchen.conturapiintegration.exception;

public class BasicDetailsResponseNotSaveException extends RuntimeException{
    public BasicDetailsResponseNotSaveException(String message) {
        super("Не удалось сохранить ответ с базовыми реквизитами " + message);
    }
}
