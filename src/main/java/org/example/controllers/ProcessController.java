package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.models.Application;
import org.example.models.CAgent;
import org.example.models.Deal;
import org.example.models.MonitoringMessage;
import org.example.starters.CamundaProcessStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProcessController {

    private final CamundaProcessStarter camundaProcessStarter;

    @Autowired
    public ProcessController(CamundaProcessStarter camundaProcessStarter) {
        this.camundaProcessStarter = camundaProcessStarter;
    }

    @PostMapping("/start-process")
    public String startProcess(@RequestBody MonitoringMessage message) throws JsonProcessingException {
        camundaProcessStarter.startProcess(message);
        return "Process started!";
    }





    //для проверки
//    @GetMapping("/start-process")
//    public String startProcess() throws JsonProcessingException {
//        MonitoringMessage message = getMessage();
//        camundaProcessStarter.startProcess(message);
//        return "Process started!";
//    }
//
//    //получаем из стороннего Monitoring-сервиса
//    private MonitoringMessage getMessage(){
//        return MonitoringMessage.builder()
//                .id(1L)
//                .application(Application.builder()
//                        .id(1L)
//                        .deal(Deal.builder()
//                                .id(1L)
//                                .description("some description")
//                                .build())
//                        .cAgent(CAgent.builder()
//                                .id(1L)
//                                .name("Ivan Ivanov")
//                                .slxId("123")
//                                .build()).build())
//                .build();
//    }
}
