package ru.gretchen.conturapiintegration.exception;

public class GetBriefReportException extends RuntimeException{
    public GetBriefReportException(String uri, String message) {
        super("Введён неверный uri " + uri + " " + message);
    }
}
