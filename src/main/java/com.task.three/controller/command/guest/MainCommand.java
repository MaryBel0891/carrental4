package com.task.three.controller.command.guest;


import com.task.three.controller.command.Command;
import com.task.three.model.service.AsyncEJB;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainCommand implements Command {
    AsyncEJB ejb;

    public MainCommand(AsyncEJB ejb) {
        this.ejb = ejb;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            Future<Integer> future = ejb.addNumbers(10, 20);
            System.out.println("Client is working ...");
            Thread.currentThread().sleep(1000);

            if (!future.isDone()) {
                System.out.println( "Response not ready yet ...");
            }

            System.out.println("Client is working again ...");
            Thread.currentThread().sleep(1000);

            if (!future.isDone()) {
                System.out.println("Response not ready yet ...");
            }

            System.out.println( "Client is still working ...");
            Thread.currentThread().sleep(1000);

            if (!future.isDone()) {
                System.out.println("Response not ready yet ...");
            } else {
                System.out.println("Response is now ready");
            }

            Integer result = future.get();

            System.out.println( "The result is: " + result);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
        return "/WEB-INF/guest/main.jsp";
    }
}
