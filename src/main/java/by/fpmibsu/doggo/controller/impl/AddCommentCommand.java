package by.fpmibsu.doggo.controller.impl;

import by.fpmibsu.doggo.controller.Command;
import by.fpmibsu.doggo.controller.constants.CommandName;
import by.fpmibsu.doggo.controller.constants.ParameterName;
import by.fpmibsu.doggo.entity.Comment;
import by.fpmibsu.doggo.service.CommentService;
import by.fpmibsu.doggo.service.FactoryService;
import by.fpmibsu.doggo.service.UserService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AddCommentCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Integer walkerId = Integer.valueOf(request.getParameter(ParameterName.WALKER_ID));
        String author = (String) session.getAttribute(ParameterName.USERNAME);
        String content = request.getParameter(ParameterName.CONTENT);

        UserService userService = FactoryService.getInstance().getUserService();
        CommentService commentService = FactoryService.getInstance().getCommentService();

        Comment comment = new Comment();


        System.out.println(1);


        try {

            comment.setWalkerInfo(userService.findByWalkerId(walkerId));
            System.out.println(4);
            comment.setAuthor(userService.findByUsername(author));
            System.out.println(9);
            comment.setContent(content);
            System.out.println(2);

            commentService.createComment(comment);

            List<Comment> comments = commentService.commentsToWalker(walkerId);

            session.setAttribute(ParameterName.COMMENTS,comments);
            response.sendRedirect(CommandName.WALKER_PAGE+walkerId);
            System.out.println(3);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
