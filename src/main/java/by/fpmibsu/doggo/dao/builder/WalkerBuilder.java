package by.fpmibsu.doggo.dao.builder;

import by.fpmibsu.doggo.dao.FactoryDAO;
import by.fpmibsu.doggo.dao.UserDAO;
import by.fpmibsu.doggo.dao.exception.DAOException;
import by.fpmibsu.doggo.entity.WalkerInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WalkerBuilder {
    private static final UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
    public WalkerInfo buildWalker(ResultSet resultSet) throws SQLException, DAOException {
        WalkerInfo walker = new WalkerInfo();
        build(walker, resultSet);
        return walker;
    }

    private void build(WalkerInfo walker, ResultSet resultSet) throws SQLException, DAOException {
        walker.setUser(userDAO.findById(resultSet.getInt("user_id")));
        walker.setWalkerId(resultSet.getInt("walker_id"));
        walker.setWalkerName(resultSet.getString("walker_name"));
        walker.setRating(resultSet.getDouble("rating"));
        walker.setNumberWalks(resultSet.getInt("number_walks"));

        /* ....*/

    }
}
