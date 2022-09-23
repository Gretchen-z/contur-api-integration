package ru.gretchen.conturapiintegration.exception;

public class RequestNotSaveException extends RuntimeException{
    public RequestNotSaveException(String inn, String message) {
        super("Не удалось сохранить запрос с ИНН " + inn + " " + message);
    }
}
