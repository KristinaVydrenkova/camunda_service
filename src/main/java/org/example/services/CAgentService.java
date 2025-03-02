package org.example.services;

import org.example.models.CAgent;
import org.springframework.stereotype.Service;

@Service
public class CAgentService {

    public static String saveCounterAgent(CAgent counterAgent) {
        // Логика сохранения контрагента
        return counterAgent.getSlxId();
    }

    public static String exchangeSlxIdToMdmCode(String slxId) {
        // Логика обмена slx_id на mdm_code
        return "MDM123";
    }
}
