package by.fpmibsu.doggo.controller.impl.goToCommands;


import by.fpmibsu.doggo.controller.Command;
import by.fpmibsu.doggo.controller.constants.PagePath;
import by.fpmibsu.doggo.controller.constants.ParameterName;
import by.fpmibsu.doggo.entity.Comment;
import by.fpmibsu.doggo.service.CommentService;
import by.fpmibsu.doggo.service.FactoryService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToViewWalkerPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CommentService commentService = FactoryService.getInstance().getCommentService();
        HttpSession session = request.getSession();

        Integer walkerId = Integer.valueOf(request.getParameter(ParameterName.WALKER_ID));
        List<Comment> comments = null;
        try {
            comments = commentService.commentsToWalker(walkerId);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute(ParameterName.COMMENTS,comments);
        session.setAttribute(ParameterName.WALKER_ID, walkerId);

        RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.VIEW_WALKER_PAGE);
        dispatcher.forward(request, response);

    }
}