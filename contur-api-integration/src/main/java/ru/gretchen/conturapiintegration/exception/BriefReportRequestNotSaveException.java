package ru.gretchen.conturapiintegration.exception;

public class BriefReportRequestNotSaveException extends RuntimeException{
    public BriefReportRequestNotSaveException(String inn, String message) {
        super("Не удалось сохранить запрос с ИНН " + inn + " " + message);
    }
}
