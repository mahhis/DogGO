package by.fpmibsu.doggo.controller.impl;


import by.fpmibsu.doggo.controller.Command;
import by.fpmibsu.doggo.controller.constants.CommandName;
import by.fpmibsu.doggo.controller.constants.ParameterName;
import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.entity.WalkerInfo;
import by.fpmibsu.doggo.service.FactoryService;
import by.fpmibsu.doggo.service.UserService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
//Login
public class SignInCommand implements Command {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		String username = request.getParameter(ParameterName.USERNAME);
		String password = request.getParameter(ParameterName.PASSWORD);
		HttpSession session = request.getSession();
		User user;

		UserService userService = FactoryService.getInstance().getUserService();


		try {
			if(userService.authorisation(username, password)){


				user = userService.findByUsername(username);
				List<WalkerInfo> walkers = userService.walkerList();


				session.setAttribute(ParameterName.USERNAME, user.getUsername());
				session.setAttribute(ParameterName.WALKERS, walkers);

				response.sendRedirect(CommandName.MAIN_PAGE);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

