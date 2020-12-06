package com.task.three.controller.command.admin.post;


import com.task.three.controller.command.Command;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class DeleteCarCommand implements Command {
    CarService carService;

    public DeleteCarCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        long carId = Long.parseLong(request.getParameter("carId"));
        try {
            carService.deleteCar(carId);
        } catch (Exception e) {

        }
        return "redirect:/admin/adminCarList";
    }
}
