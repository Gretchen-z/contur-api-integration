package ru.gretchen.conturapiintegration.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class LogDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println(delegateExecution.getVariables());
    }
}
