package uis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uis.conn.ConnectDB;
import uis.model.City;
import uis.model.CityRowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository(CityDAOImpl.NAME)
public class CityDAOImpl implements CityDAO {

    public static final String NAME = "cityDAO";

    @Autowired
    @Qualifier(ConnectDB.NAME)
    ConnectDB connectDB;

    private DataSource ds = connectDB.dataSource();
    private JdbcTemplate cityJdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.ds = dataSource;
        this.cityJdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void insertCity(String name, int countryId) {
        String insert = "INSERT INTO system.\"Cities\"(\n" +
                "             name, \"countryId\")\n" +
                "    VALUES ( ?, ?);";
        cityJdbcTemplate.update(insert, name, countryId);
    }

    @Override
    public ArrayList<City> selectAllCities() {
        String selectAll = "SELECT \"Cities\".id, \"Cities\".name as \"cityName\", \"Cities\".\"countryId\", \"Countries\".name as \"countryName\"\n" +
                "  FROM system.\"Cities\" join system.\"Countries\" on \"Cities\".\"countryId\" = \"Countries\".id;";
        ArrayList<City> cityList = (ArrayList<City>) cityJdbcTemplate.query(selectAll, new CityRowMapper());
        return cityList;
    }

    @Override
    public void deleteCityById(int id) {
        String deleteQuery = "DELETE FROM system.\"Cities\"\n" +
                " WHERE id = ?;";
        cityJdbcTemplate.update(deleteQuery, id);
    }

    @Override
    public void updateCityInfo(String name, int country, int id) {
        String update = "UPDATE system.\"Cities\"\n" +
                "   SET  name=?, \"countryId\"=?\n" +
                " WHERE id = ?;";
        cityJdbcTemplate.update(update, name, country, id);
    }
}
