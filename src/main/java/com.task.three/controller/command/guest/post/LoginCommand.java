package com.task.three.controller.command.guest.post;


import com.task.three.controller.command.Command;
import com.task.three.controller.command.CommandUtility;
import com.task.three.controller.config.BCryptPasswordEncoder;
import com.task.three.controller.config.Regex;
import com.task.three.model.entity.RoleType;
import com.task.three.model.entity.User;
import com.task.three.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class LoginCommand implements Command, Serializable {


    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user;
        try {
            if (isValid(email, password) ) {
                user = userService.findByEmail(email);
                if (new BCryptPasswordEncoder().matches(password, user.getPassword()) && CommandUtility.checkUserIsNotLogged(request, email)) {
                    CommandUtility.setUserToSession(request, user);
                }else {
                    return "redirect:/login?user=error";
                }

            }else {
                return "redirect:/login?validation=error";
            }
        }catch (Exception e){
            return "redirect:/login?user=exception";
        }

        return redirect(user.getRole());

    }

    //todo
    private boolean isValid (String email, String password){
        return email.matches(Regex.EMAIL_REGEX) && password.matches(Regex.PASSWORD_REGEX);
    }
    private String redirect(RoleType role){
        return role.equals(RoleType.USER)
                ? "redirect:/user/order_car"
                : "redirect:/admin/add_new_car";
    }
}
