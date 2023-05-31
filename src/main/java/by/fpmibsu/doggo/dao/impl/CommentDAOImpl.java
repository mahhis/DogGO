package by.fpmibsu.doggo.dao.impl;

import by.fpmibsu.doggo.dao.CommentDAO;
import by.fpmibsu.doggo.dao.builder.BuilderFactory;
import by.fpmibsu.doggo.dao.database.ConnectionPool;
import by.fpmibsu.doggo.dao.database.ConnectionPoolException;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String FIND_COMMENT_BY_ID = "SELECT * FROM comments WHERE comment_id = ?";
    private static final String FIND_ALL_COMMENTS_BY_WALKER_ID = "SELECT * FROM comments WHERE walker_id = ?";

    private static final String CREATE_NEW_COMMENT = "INSERT INTO  comments (walker_id, author_id, content) VALUES (?, ?, ?);";
    private static final String UPDATE_COMMENT = "UPDATE comments SET content = ? WHERE comment_id = ?";
    private static final String DELETE_COMMENT = "DELETE FROM comments WHERE comment_id = ?";





    @Override
    public void createComment(Comment comment) throws DAOException {


        Connection connection = null;
        PreparedStatement statement = null;
        String sql = CREATE_NEW_COMMENT;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, comment.getWalkerInfo().getWalkerId());
            statement.setInt(2, comment.getAuthor().getId());
            statement.setString(3, comment.getContent());
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    public Comment findById(int commentId) throws DAOException {
        Comment comment = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_COMMENT_BY_ID;

        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, commentId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                comment = BuilderFactory.getCommentBuilder().buildComment(resultSet);
            } else {
                comment = new Comment();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return comment;
    }




    @Override
    public void deleteComment(Comment user) throws DAOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = DELETE_COMMENT;
        try {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getCommentId());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void upDateComment(Comment comment) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = UPDATE_COMMENT;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, comment.getContent());
            statement.setInt(2, comment.getCommentId());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Comment> commentsToWalker(int walkerId) throws DAOException {

            List<Comment> comments = new ArrayList<>();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            String sql = FIND_ALL_COMMENTS_BY_WALKER_ID;
            try {
                connection = connectionPool.takeConnection();
                statement = connection.prepareStatement(sql);
                statement.setInt(1,walkerId);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    comments.add(BuilderFactory.getCommentBuilder().buildComment(resultSet));
                }
            } catch (ConnectionPoolException | SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    connectionPool.closeConnection(connection, statement, resultSet);
                } catch (ConnectionPoolException e) {
                    e.printStackTrace();
                }
            }
            return comments;

    }
}
