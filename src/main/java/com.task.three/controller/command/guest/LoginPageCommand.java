package com.task.three.controller.command.guest;


import com.task.three.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LoginPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/guest/login.jsp";
    }
}
