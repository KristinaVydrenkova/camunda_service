package org.example.services;

import org.example.models.Application;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    public static Long saveApplication(Application application) {
        // Логика сохранения заявки
        return application.getId();
    }
}
