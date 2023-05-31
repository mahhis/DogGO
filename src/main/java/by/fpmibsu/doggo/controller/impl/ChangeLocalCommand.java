package by.fpmibsu.doggo.controller.impl;


import by.fpmibsu.doggo.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLocalCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.getSession(true).setAttribute("local", request.getParameter("local"));
       request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
