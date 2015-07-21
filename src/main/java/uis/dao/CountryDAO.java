package uis.dao;

import uis.model.Country;

import javax.sql.DataSource;
import java.util.ArrayList;

public interface CountryDAO {

    void setDataSource(DataSource dataSource);

    void insertCountry(String name);

    ArrayList<Country> selectAllCountries();

    void deleteCountryById(int id);

    void updateCountry(int id, String name);
}
