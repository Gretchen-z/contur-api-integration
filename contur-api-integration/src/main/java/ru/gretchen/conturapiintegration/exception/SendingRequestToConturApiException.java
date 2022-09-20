package ru.gretchen.conturapiintegration.exception;

public class SendingRequestToConturApiException extends RuntimeException{
    public SendingRequestToConturApiException(String message) {
        super("Не удалось направить запрос к API Контур Фокус " + message);
    }
}
