package org.example.delegates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.models.Application;
import org.example.models.MonitoringMessage;
import org.example.services.ApplicationService;
import org.springframework.stereotype.Component;

@Component
public class SaveApplicationDelegate implements JavaDelegate {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String monitoringMessageJson = (String) execution.getVariable("monitoringMessage");
        MonitoringMessage message = objectMapper.readValue(monitoringMessageJson, MonitoringMessage.class);

        Application application = message.getApplication();
        Long applicationId = ApplicationService.saveApplication(application);

        execution.setVariable("applicationId", applicationId);
    }
}