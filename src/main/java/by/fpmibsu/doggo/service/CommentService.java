package by.fpmibsu.doggo.service;

import by.fpmibsu.doggo.entity.Comment;
import by.fpmibsu.doggo.service.exception.ServiceException;

import java.util.List;

public interface CommentService {

    public void createComment(Comment comment) throws ServiceException;
    public Comment findById(int commentId) throws ServiceException ;

    public void deleteComment(Comment comment) throws ServiceException ;


    public void upDateComment(Comment comment) throws ServiceException ;
    public List<Comment> commentsToWalker(int walkerId) throws ServiceException ;
}
