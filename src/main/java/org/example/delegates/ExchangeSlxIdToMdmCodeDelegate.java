package org.example.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.services.CAgentService;
import org.springframework.stereotype.Component;

@Component
public class ExchangeSlxIdToMdmCodeDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String slxId = (String) execution.getVariable("slxId");

        String mdmCode = CAgentService.exchangeSlxIdToMdmCode(slxId);

        execution.setVariable("mdmCode", mdmCode);
    }
}