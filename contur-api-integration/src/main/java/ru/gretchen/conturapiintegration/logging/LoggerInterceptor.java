package ru.gretchen.conturapiintegration.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger("Controller");

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @Nullable Object handler) {
        logger.info(request.getSession().getId() + " " + request.getMethod() + request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @Nullable Object handler,
            Exception ex) {
        if (ex != null) {
            logger.warn(request.getSession().getId() + " " + ex.getMessage());
        }
        else {
            logger.info(request.getSession().getId() + " Status: " + response.getStatus());
        }
    }
}
