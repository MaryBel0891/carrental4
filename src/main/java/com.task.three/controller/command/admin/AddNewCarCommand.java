package com.task.three.controller.command.admin;


import com.task.three.controller.command.Command;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class AddNewCarCommand implements Command {
    CarService carService;


    public AddNewCarCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/add_new_car.jsp";
    }
}
