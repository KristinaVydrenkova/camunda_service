package org.example.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.models.LegalEntity;
import org.example.services.LegalEntityService;
import org.springframework.stereotype.Component;

@Component
public class SaveLegalEntityDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String mdmCode = (String) execution.getVariable("mdmCode");

        LegalEntity legalEntity = LegalEntityService.getLegalEntityByMdmCode(mdmCode);

        LegalEntityService.saveLegalEntity(legalEntity);
    }
}