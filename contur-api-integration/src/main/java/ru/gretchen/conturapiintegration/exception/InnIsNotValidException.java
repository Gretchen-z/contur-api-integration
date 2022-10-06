package ru.gretchen.conturapiintegration.exception;

public class InnIsNotValidException extends RuntimeException {
    public InnIsNotValidException(String inn) {
        super("Инн " + inn + " не соответствует формату");
    }
}
