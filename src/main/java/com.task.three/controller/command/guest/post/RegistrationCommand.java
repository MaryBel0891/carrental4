package com.task.three.controller.command.guest.post;


import com.task.three.controller.command.Command;
import com.task.three.controller.config.BCryptPasswordEncoder;
import com.task.three.controller.config.Regex;
import com.task.three.model.entity.RoleType;
import com.task.three.model.entity.User;
import com.task.three.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private final UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return save(new User.Builder()
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .password(password)
                        .build());

    }
    public String save(User user){

        if (verify(user)) {
            try {
                userService.addUser(new User.Builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .email(user.getEmail())
                        .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                        .role(RoleType.USER)
                        .build());
                return "redirect:/login";
            } catch (Exception e) {
                return "redirect:/registration?error=userAlreadyExist";
            }
        }else
            return "redirect:/registration?regex=error";
    }
    public boolean verify(User user){
        return user.getEmail().matches(Regex.EMAIL_REGEX)
                && (user.getName().matches(Regex.NAME_REGEX) || user.getName().matches(Regex.NAME_UKR_REGEX))
                && (user.getSurname().matches(Regex.NAME_REGEX) || user.getSurname().matches(Regex.NAME_UKR_REGEX))
                && user.getPassword().matches(Regex.PASSWORD_REGEX);

    }
}
