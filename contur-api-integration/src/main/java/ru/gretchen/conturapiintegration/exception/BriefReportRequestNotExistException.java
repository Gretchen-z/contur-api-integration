package ru.gretchen.conturapiintegration.exception;

public class BriefReportRequestNotExistException extends RuntimeException{
    public BriefReportRequestNotExistException(Long inn) {
        super("Запрос с ИНН " + inn + " не существует.");
    }
}
