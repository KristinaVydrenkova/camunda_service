package org.example.delegates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.models.Deal;
import org.example.models.MonitoringMessage;
import org.example.services.DealService;
import org.springframework.stereotype.Component;

@Component
public class SaveDealDelegate implements JavaDelegate {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable("applicationId");
        String monitoringMessageJson = (String) execution.getVariable("monitoringMessage");
        MonitoringMessage message = objectMapper.readValue(monitoringMessageJson, MonitoringMessage.class);

        Deal deal = message.getApplication().getDeal();
        Long dealId = DealService.saveDeal(deal);

        execution.setVariable("dealId", dealId);
    }
}