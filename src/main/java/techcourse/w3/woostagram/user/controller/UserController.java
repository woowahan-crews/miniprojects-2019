package techcourse.w3.woostagram.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import techcourse.w3.woostagram.user.dto.UserDto;
import techcourse.w3.woostagram.user.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login/form")
    public String show() {
        return "login";
    }

    @GetMapping("signup/form")
    public String createFrom() {
        return "signup";
    }

    @PostMapping("signup")
    public String create(UserDto userDto) {
        userService.create(userDto);
        return "redirect:/login/form";
    }

}
