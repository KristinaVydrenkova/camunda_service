package org.example.starters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.example.models.MonitoringMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamundaProcessStarter {

    private final RuntimeService runtimeService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("camunda.process-id")
    private String processId;

    private final static String VARIABLE_NAME = "monitoringMessage";

    @Autowired
    public CamundaProcessStarter(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void startProcess(MonitoringMessage message) throws JsonProcessingException {

        String monitoringMessageJson = objectMapper.writeValueAsString(message);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
                processId,
                Variables.putValue(VARIABLE_NAME, monitoringMessageJson)
        );

        System.out.println("Process started with ID: " + processInstance.getId());
    }
}
