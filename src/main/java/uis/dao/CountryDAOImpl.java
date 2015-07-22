package uis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uis.conn.ConnectDB;
import uis.model.Country;
import uis.model.CountryRowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    ConnectDB connectDB;

    private DataSource ds = connectDB.dataSource();
    private JdbcTemplate countryJdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.ds = dataSource;
        this.countryJdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void insertCountry(String name) {
        String insert = "INSERT INTO system.\"Countries\"(\n" +
                "             name)\n" +
                "    VALUES (?);";
        countryJdbcTemplate.update(insert, name);
    }

    @Override
    public ArrayList<Country> selectAllCountries() {
        String selectAll = "SELECT *\n" +
                "  FROM system.\"Countries\";";
        ArrayList<Country> countryList = (ArrayList<Country>) countryJdbcTemplate.query(selectAll, new CountryRowMapper());
        return countryList;
    }

    @Override
    public void deleteCountryById(int id) {
        String deleteQuery = "DELETE FROM system.\"Countries\"\n" +
                " WHERE id = ?;";
        countryJdbcTemplate.update(deleteQuery, id);
    }

    @Override
    public void updateCountry(int id, String name) {
        String update = "UPDATE system.\"Countries\"\n" +
                "   SET name=?\n" +
                " WHERE id = ?;";
        countryJdbcTemplate.update(update, id, name);
    }
}
