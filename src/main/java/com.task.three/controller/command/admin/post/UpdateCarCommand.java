package com.task.three.controller.command.admin.post;


import com.task.three.controller.command.Command;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class UpdateCarCommand implements Command {

    CarService carService;

    public UpdateCarCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        long carId = Long.parseLong(request.getParameter("carId2"));
        try {
           request.setAttribute("car", carService.getCar(carId));
        } catch (Exception e) {
        }
        return "/WEB-INF/admin/update_car.jsp";
    }
}