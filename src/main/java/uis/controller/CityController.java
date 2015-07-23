package uis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uis.dao.CityDAOImpl;
import uis.model.City;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    CityDAOImpl cityDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<City> listCity() {
        return cityDAO.selectAllCities();
    }

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam(value = "name") String name, @RequestParam(value = "countryId") int countryId) {
        cityDAO.insertCity(name, countryId);
        return "Inserted city" + name;
    }

    @RequestMapping(value = "/editCity", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestParam(value = "name") String name, @RequestParam(value = "countryId") int countryId, @RequestParam(value = "id") int id) {
        cityDAO.updateCityInfo(name, countryId, id);
        return "Edited city" + name;
    }

    @RequestMapping(value = "/deleteCity", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam(value = "id") int id) {
        cityDAO.deleteCityById(id);
        return "Deleted city";
    }
}
