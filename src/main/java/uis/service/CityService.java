package uis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uis.dao.CityDAOImpl;
import uis.model.City;

import java.util.List;

@RequestMapping("city")
@Service(CityService.NAME)
public class CityService {

    public static final String NAME = "cityService";

    @Autowired
    @Qualifier(CityDAOImpl.NAME)
    CityDAOImpl cityDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<City> listCity() {
        List<City> cityList = cityDAO.selectAllCities();
        return cityList;
    }

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam(value = "name") String name, @RequestParam(value = "countryId") int countryId) {
        cityDAO.insertCity(name, countryId);
        return "Inserted  City " + name;
    }

    @RequestMapping(value = "/editCity", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestParam(value = "name") String name, @RequestParam(value = "countryId") int countryId, @RequestParam(value = "id") int id) {
        cityDAO.updateCityInfo(name, countryId, id);
        return "Edited City"+ name;
    }

    @RequestMapping(value = "/deleteCity", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam(value = "id") int id) {
        cityDAO.deleteCityById(id);
        return "Deleted City";
    }

}
