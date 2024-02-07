package microservice.userservice.controller;

import microservice.userservice.model.User;
import microservice.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository user;

    @GetMapping("/users")
    public List<User> getAllUser() {
        System.out.println("Get all Users...");

        List<User> users = new ArrayList<>();
        user.findAll().forEach(users::add);

        return users;
    }
}


