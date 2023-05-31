package by.fpmibsu.doggo.controller.impl;


import by.fpmibsu.doggo.controller.Command;
import by.fpmibsu.doggo.controller.constants.CommandName;
import by.fpmibsu.doggo.controller.constants.ParameterName;
import by.fpmibsu.doggo.entity.User;
import by.fpmibsu.doggo.entity.WalkerInfo;
import by.fpmibsu.doggo.entity.enums.Role;
import by.fpmibsu.doggo.service.FactoryService;
import by.fpmibsu.doggo.service.UserService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
//Registration
//CntrollerAuth
public class SignUpCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = request.getParameter(ParameterName.USERNAME);
		String telephoneNumber = request.getParameter(ParameterName.TELEPHONE_NUMBER);
		String password = request.getParameter(ParameterName.PASSWORD);

		HttpSession session = request.getSession();


		User user = new User();
		user.setUsername(username);
		user.setTelephoneNumber(telephoneNumber);
		user.setPassword(password);
		user.setRole(Role.USER);
		user.setRole_id(2);


		UserService userService = FactoryService.getInstance().getUserService();


		try {
			userService.registration(user);

			List<WalkerInfo> walkers = userService.walkerList();

			session.setAttribute(ParameterName.WALKERS, walkers);
			session.setAttribute(ParameterName.USERNAME, user.getUsername());

			response.sendRedirect(CommandName.MAIN_PAGE);
		} catch (ServiceException e) {
			//response.sendRedirect(CommandName.ERROR_PAGE);
		}

	}

}
