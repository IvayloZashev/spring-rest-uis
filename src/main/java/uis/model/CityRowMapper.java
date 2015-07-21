package uis.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("id"));
        city.setName(resultSet.getString("cityName"));
        city.setCountryId(resultSet.getInt("countryId"));
        city.setCountryName(resultSet.getString("countryName"));
        return city;
    }
}
