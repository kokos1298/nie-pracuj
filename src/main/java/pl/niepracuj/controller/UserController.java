package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.model.dto.UserDto;
import pl.niepracuj.model.entity.User;
import pl.niepracuj.service.level.LevelService;
import pl.niepracuj.service.user.UserService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public void login() {
    }


    @GetMapping("/current")
    public UserDto getLoggerInUser() {
        return userService.getLoggedInUser();
    }
}
