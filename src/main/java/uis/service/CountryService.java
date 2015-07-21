package uis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uis.dao.CountryDAOImpl;
import uis.model.Country;

import java.util.List;

@Service(CountryService.NAME)
public class CountryService {
    public static final String NAME = "countryService";

    @Autowired
    @Qualifier(CountryDAOImpl.NAME)
    CountryDAOImpl countryDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Country> listCountry() {
        List<Country> countryList = countryDAO.selectAllCountries();
        return countryList;
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
