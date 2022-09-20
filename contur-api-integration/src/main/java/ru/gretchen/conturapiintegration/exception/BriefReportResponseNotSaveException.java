package ru.gretchen.conturapiintegration.exception;

public class BriefReportResponseNotSaveException extends RuntimeException{
    public BriefReportResponseNotSaveException(String message) {
        super("Не удалось сохранить ответ сервиса " + message);
    }
}
