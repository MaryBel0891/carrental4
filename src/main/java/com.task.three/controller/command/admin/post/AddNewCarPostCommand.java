package com.task.three.controller.command.admin.post;


import com.task.three.controller.command.Command;
import com.task.three.model.entity.Car;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class AddNewCarPostCommand implements Command {
    CarService carService;

    public AddNewCarPostCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int insuranceValue = Integer.parseInt(request.getParameter("insuranceValue"));
            try {
                carService.addCar(new Car(name, price, insuranceValue));
            } catch (Exception e) {

            }
        return "redirect:/admin/add_new_car";
    }
}
