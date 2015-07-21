package uis.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setEmail(resultSet.getString("e-mail"));
        user.setCountryId(resultSet.getInt("countryId"));
        user.setCityId(resultSet.getInt("cityId"));
        user.setPhoneNumber(resultSet.getString("phoneNumber"));
        user.setStatusId(resultSet.getInt("statusId"));
        user.setUsername(resultSet.getString("username"));
        user.setIsAdmin(resultSet.getBoolean("admin"));
        user.setStatusName(StatusName.valueOf(resultSet.getString("statusName")));
        user.setStreetNameNumber(resultSet.getString("streetNameNumber"));
        user.setDateCreated(resultSet.getTimestamp("dateCreated"));
        user.setDateUpdated(resultSet.getTimestamp("dateUpdated"));
        user.setCountryName(resultSet.getString("countryName"));
        user.setCityName(resultSet.getString("cityName"));
        return user;
    }
}
