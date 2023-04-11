package by.fpmibsu.doggo.dao.builder;



import by.fpmibsu.doggo.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder {

    public User buildUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        build(user, resultSet);
        return user;
    }

    private void build(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt("id"));
       /* ....*/
        user.setEmail(resultSet.getString("email"));
    }
}
