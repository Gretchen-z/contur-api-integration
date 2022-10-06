package ru.gretchen.conturapiintegration.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class LogDelegate implements JavaDelegate{
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println(delegateExecution.getVariables());
    }
}
