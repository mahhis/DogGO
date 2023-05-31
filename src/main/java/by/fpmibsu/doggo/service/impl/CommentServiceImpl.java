package by.fpmibsu.doggo.service.impl;

import by.fpmibsu.doggo.dao.CommentDAO;
import by.fpmibsu.doggo.dao.FactoryDAO;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Comment;
import by.fpmibsu.doggo.service.CommentService;
import by.fpmibsu.doggo.service.exception.ServiceException;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private static final CommentDAO commentDAO = FactoryDAO.getInstance().getCommentDAO();



    @Override
    public void createComment(Comment comment) throws ServiceException {
        try {
            commentDAO.createComment(comment);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }





        @Override
        public Comment findById(int commentId) throws ServiceException {
            Comment comment = null;
            try {
                comment = commentDAO.findById(commentId);
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
            return comment;
        }




        @Override
        public void deleteComment(Comment comment) throws ServiceException {
            try {
                commentDAO.deleteComment(comment);
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public List<Comment> commentsToWalker(int walkerId) throws ServiceException {
        List<Comment> comments = null;
        try {
            comments = commentDAO.commentsToWalker(walkerId);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
        return comments;
    }


    @Override
        public void upDateComment(Comment comment) throws ServiceException {
        try {
            commentDAO.upDateComment(comment);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }


}
