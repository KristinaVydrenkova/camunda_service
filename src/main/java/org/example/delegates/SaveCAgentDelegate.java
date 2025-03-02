package org.example.delegates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.models.CAgent;
import org.example.models.MonitoringMessage;
import org.example.services.CAgentService;
import org.springframework.stereotype.Component;

@Component
public class SaveCAgentDelegate implements JavaDelegate {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable("applicationId");
        Long dealId = (Long) execution.getVariable("dealId");
        String monitoringMessageJson = (String) execution.getVariable("monitoringMessage");
        MonitoringMessage message = objectMapper.readValue(monitoringMessageJson, MonitoringMessage.class);

        CAgent counterAgent = message.getApplication().getCAgent();
        String slxId = CAgentService.saveCounterAgent(counterAgent);

        execution.setVariable("slxId", slxId);
    }
}