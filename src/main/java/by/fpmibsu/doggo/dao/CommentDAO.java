package by.fpmibsu.doggo.dao;

import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Comment;

import java.util.List;

public interface CommentDAO {

    void createComment(Comment comment) throws DAOException;
    Comment findById(int commentId) throws DAOException;
    void deleteComment(Comment  omment) throws DAOException;
    void upDateComment(Comment comment) throws DAOException;

    List<Comment>  commentsToWalker(int walkerId) throws DAOException;

}
