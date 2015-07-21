package uis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uis.conn.ConnectDB;
import uis.model.User;
import uis.model.UserRowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository(UserDAOImpl.NAME)
public class UserDAOImpl implements uis.dao.UserDAO {

    public static final String NAME = "userDAO";

    @Autowired
    @Qualifier(ConnectDB.NAME)
    ConnectDB connectDB;

    private DataSource ds = connectDB.dataSource();
    private JdbcTemplate userJdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.ds = dataSource;
        this.userJdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public ArrayList<User> selectAllUsers() {
        String selectAll = "select \"Users\".id, \"firstName\", \"lastName\", \"e-mail\", \"streetNameNumber\", \"phoneNumber\", \n" +
                "       \"dateCreated\", \"dateUpdated\", username, \"Users\".\"countryId\", \n" +
                "       \"statusId\", \"cityId\", \"isAdmin\" as admin, \"Countries\".name as \"countryName\", \n" +
                "       \"Cities\".name as \"cityName\", \"Status\".name as \"statusName\" from system.\"Users\"\n" +
                "join system.\"Countries\" on \"Users\".\"countryId\" = \"Countries\".id\n" +
                "join system.\"Cities\" on \"Users\".\"cityId\" = \"Cities\".id\n" +
                "join system.\"Status\" on \"Users\".\"statusId\" = \"Status\".id;";
        ArrayList<User> userList = (ArrayList<User>) userJdbcTemplate.query(selectAll, new UserRowMapper());
        return userList;
    }

    @Override
    public void updateUserInfo(String firstName, String lastName, String email, String streetNameNumber, String phoneNumber, int countryId, int statusId, int cityId, int id, String username, String password, boolean isAdmin) {
        String updateQuery = "UPDATE system.\"Users\"\n" +
                "                 SET  \"firstName\"=?, \"lastName\"=?, \"e-mail\"=?, \"streetNameNumber\"=?, \n" +
                "                                     \"phoneNumber\"=?, \"dateUpdated\"=current_timestamp, \"countryId\"=?, \n" +
                "                       \"statusId\"=?, \"cityId\"=?, username = ?, password = ?, \"isAdmin\" = ?\n" +
                "                 WHERE id = ?;";
        userJdbcTemplate.update(updateQuery, firstName, lastName, email, streetNameNumber, phoneNumber, countryId, statusId, cityId, id, username, password, isAdmin);
    }

    @Override
    public void deleteUserById(int id) {
        String delete = "DELETE FROM system.\"Users\"\n" +
                " WHERE id = ?;";
        userJdbcTemplate.update(delete, id);
    }

    @Override
    public void insertUser(String firstName, String lastName, String email, int countryId, int cityId, String street, String phone, int statusId, String username, String password, boolean isAdmin) {
        String insert = "INSERT INTO system.\"Users\"(\n" +
                "            \"firstName\", \"lastName\", \"e-mail\", \"streetNameNumber\", \"phoneNumber\", \n" +
                "            \"dateCreated\", \"dateUpdated\", \"countryId\", \"statusId\", \"cityId\", username, password, \"isAdmin\")\n" +
                "    VALUES ( ?, ?, ?, ?, ?, current_timestamp, current_timestamp, ?, ?, ?, ?, ?, ?);";
        userJdbcTemplate.update(insert, firstName, lastName, email, countryId, cityId, street, phone, statusId, username, password, isAdmin);
    }
}
