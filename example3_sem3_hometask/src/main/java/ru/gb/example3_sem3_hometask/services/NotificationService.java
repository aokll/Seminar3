package ru.gb.example3_sem3_hometask.services;

import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class NotificationService {

    //сообщвет что пользователь зарегистрировался в системе
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    //сообщить в консоль что ктото пришел
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
