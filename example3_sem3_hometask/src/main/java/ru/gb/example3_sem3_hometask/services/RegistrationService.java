package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class RegistrationService {//регистрация новых пользователей

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;
@Autowired
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);

        dataProcessingService.addUserToList(user);

        notificationService.sendNotification("user add");
    }
}

