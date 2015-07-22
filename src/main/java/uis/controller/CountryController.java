package uis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uis.model.Country;
import uis.dao.CountryDAOImpl;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {

    @Autowired
    CountryDAOImpl countryDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Country> listCountry() {
        return countryDAO.selectAllCountries();
    }

    @RequestMapping(value = "/addCountry", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam(value = "name") String name) {
        countryDAO.insertCountry(name);
        return "Inserted Country" + name;
    }

    @RequestMapping(value = "/editCountry", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {
        countryDAO.updateCountry(id, name);
        return "Edited Country" + name;
    }

    @RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam(value = "id") int id) {
        countryDAO.deleteCountryById(id);
        return "Deleted Country";
    }

}
