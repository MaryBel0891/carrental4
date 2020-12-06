package com.task.three.controller.command.admin.post;


import com.task.three.controller.command.Command;
import com.task.three.model.entity.Car;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class UpdateCarSubmitCommand implements Command {

    CarService carService;

    public UpdateCarSubmitCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        long carId = Long.parseLong(request.getParameter("id"));
        String carName = request.getParameter("name");
        int carPrice = Integer.parseInt(request.getParameter("price"));
        int carInsuranceValue = Integer.parseInt(request.getParameter("insuranceValue"));
        Car car = new Car(carId, carName, carPrice, carInsuranceValue);
        carService.updateCar(car);
        return "redirect:/admin/adminCarList";
    }
}
