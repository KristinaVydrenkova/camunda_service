package org.example.services;

import org.example.models.Deal;
import org.springframework.stereotype.Service;

@Service
public class DealService {

    public static Long saveDeal(Deal deal) {
        // Логика сохранения сделки
        return deal.getId();
    }
}
