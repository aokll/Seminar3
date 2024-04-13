package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")//привязываем RestController к адресу "/users"
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }
    @PostMapping
    public String userAddFromParam(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) int age,
                                   @RequestParam(required = false) String email)
    {
        service.processRegistration(name,age,email);
        return "User added from param!";
    }
}
/**/