package by.fpmibsu.doggo.dao.builder;

import by.fpmibsu.doggo.dao.FactoryDAO;
import by.fpmibsu.doggo.dao.UserDAO;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentBuilder {
    private static final UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
    public Comment buildComment(ResultSet resultSet) throws SQLException, DAOException {
        Comment comment = new Comment();
        build(comment, resultSet);
        return comment;
    }

    private void build(Comment comment, ResultSet resultSet) throws SQLException, DAOException {


        comment.setAuthor(userDAO.findById(resultSet.getInt("author_id")));
        comment.setWalkerInfo(userDAO.findByWalkerId(resultSet.getInt("walker_id")));
        comment.setCommentId(resultSet.getInt("comment_id"));
        comment.setContent(resultSet.getString("content"));
    }
}
