package com.task.three.controller;


import com.task.three.controller.command.Command;
import com.task.three.controller.command.LogoutCommand;
import com.task.three.controller.command.admin.AddNewCarCommand;
import com.task.three.controller.command.admin.AdminCarListCommand;
import com.task.three.controller.command.admin.post.AddNewCarPostCommand;
import com.task.three.controller.command.admin.post.DeleteCarCommand;
import com.task.three.controller.command.admin.post.UpdateCarCommand;
import com.task.three.controller.command.admin.post.UpdateCarSubmitCommand;
import com.task.three.controller.command.guest.LoginPageCommand;
import com.task.three.controller.command.guest.MainCommand;
import com.task.three.controller.command.guest.RegistrationPageCommand;
import com.task.three.controller.command.guest.post.LoginCommand;
import com.task.three.controller.command.guest.post.RegistrationCommand;
import com.task.three.controller.command.user.OrderCarCommand;
import com.task.three.controller.command.user.post.AddOrderToCarRentalCommand;
import com.task.three.controller.command.user.post.CreateOrderCommand;
import com.task.three.model.service.AsyncEJB;
import com.task.three.model.service.CarRentalService;
import com.task.three.model.service.CarService;
import com.task.three.model.service.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    @EJB
    private UserService userService;
    @EJB
    private CarService carService;
    @EJB
    private CarRentalService carRentalService;
    @EJB
    AsyncEJB ejb;


    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("logout", new LogoutCommand());
        commands.put("login", new LoginPageCommand());
        commands.put("log", new LoginCommand(userService));
        commands.put("reg", new RegistrationCommand(userService));
        commands.put("registration", new RegistrationPageCommand());
        commands.put("", new MainCommand(ejb));

        commands.put("admin/add_new_car", new AddNewCarCommand(carService));
        commands.put("admin/adminCarList", new AdminCarListCommand(carService));
        commands.put("admin/deleteCar", new DeleteCarCommand(carService));
        commands.put("admin/updateCar", new UpdateCarCommand(carService));
        commands.put("admin/updateCarSubmit",new UpdateCarSubmitCommand(carService));
        commands.put("admin/addNewCarPost", new AddNewCarPostCommand(carService));

        commands.put("user/order_car", new OrderCarCommand(carService));
        commands.put("user/order_create", new CreateOrderCommand(carRentalService, carService));
        commands.put("user/addOrderToCarRental", new AddOrderToCarRentalCommand(carRentalService));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/web/" , "");
        Command command = commands.getOrDefault(path ,
                (req)->"/error.jsp");
        String page = command.execute(request);
        if (page.contains("redirect"))
            response.sendRedirect(request.getContextPath() + page.replace("redirect:", ""));
        else
            request.getRequestDispatcher(page).forward(request,response);
    }

}
