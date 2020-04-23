package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class BmiRepository {

    @Autowired
    JdbcTemplate jdbc;
    SqlRowSet sqlRowSet;

    public void updateInfo(User user){
        String sql = "UPDATE bmi_db.user SET weight=?, height=? WHERE user_id = 1";

        jdbc.update(sql, preparedStatement -> {
            preparedStatement.setString(1, user.getWeight());
            preparedStatement.setDouble(2, user.getHeight());
        });
    }

    public User getUser() {
        String sql = "SELECT * FROM user WHERE user_id=?";
        sqlRowSet = jdbc.queryForRowSet(sql, 1);

        while (sqlRowSet.next()){
            return new User(
                    sqlRowSet.getInt("user_id"),
                    sqlRowSet.getString("weight"),
                    sqlRowSet.getDouble("height")
            );
        }
        return null;
    }

    public void createUser() {
        String sql = "INSERT INTO bmi_db.user (user_id, weight, height) " +
                "VALUES (?, ?, ?)";

        jdbc.update(sql, preparedStatement -> {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "0");
            preparedStatement.setDouble(3, 0);
        });
    }
}
