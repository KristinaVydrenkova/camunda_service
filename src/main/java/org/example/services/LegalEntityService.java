package org.example.services;

import org.example.models.LegalEntity;
import org.springframework.stereotype.Service;

@Service
public class LegalEntityService {

    public static LegalEntity getLegalEntityByMdmCode(String mdmCode) {
        // Логика получения данных о юр.лице
        return LegalEntity.builder().mdmCode(mdmCode).build();
    }

    public static void saveLegalEntity(LegalEntity legalEntity) {
        // Логика сохранения юр.лица
    }
}
