package ru.gretchen.conturapiintegration.exception;

public class RequestNotExistException extends RuntimeException{
    public RequestNotExistException(Long inn) {
        super("Запрос с ИНН " + inn + " не существует.");
    }
}
