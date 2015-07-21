package uis.dao;

import uis.model.City;

import javax.sql.DataSource;
import java.util.ArrayList;

public interface CityDAO {

    void setDataSource(DataSource dataSource);

    void insertCity(String name, int countryId);

    ArrayList<City> selectAllCities();

    void deleteCityById(int id);

    void updateCityInfo(String name, int country, int id);

}
