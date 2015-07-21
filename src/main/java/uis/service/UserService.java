package uis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uis.dao.UserDAOImpl;
import uis.model.User;

import java.util.List;

@Service(UserService.NAME)
public class UserService {
    public static final String NAME = "userService";

    @Autowired
    @Qualifier(UserDAOImpl.NAME)
    UserDAOImpl userDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> listUser() {
        List<User> userList = userDAO.selectAllUsers();
        return userList;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "email") String email,
                         @RequestParam(value = "countryId") int countryId, @RequestParam(value = "cityId") int cityId, @RequestParam(value = "street") String street,
                         @RequestParam(value = "phone") String phone, @RequestParam(value = "statusId") int statusId, @RequestParam(value = "username") String username,
                         @RequestParam(value = "password") String password, @RequestParam(value = "isAdmin") boolean isAdmin) {

        userDAO.insertUser(name, lastName, email, countryId, cityId, street, phone, statusId, username, password, isAdmin);
        return "Inserted User" + name + lastName;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "email") String email,
                       @RequestParam(value = "street") String street, @RequestParam(value = "phone") String phone, @RequestParam(value = "countryId") int countryId,
                       @RequestParam(value = "statusId") int statusId, @RequestParam(value = "cityId") int cityId, @RequestParam(value = "id") int id,
                       @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "isAdmin") boolean isAdmin) {

        userDAO.updateUserInfo(name, lastName, email, street, phone, countryId, statusId, cityId, id, username, password, isAdmin);
        return "Edited User" + name + lastName;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam(value = "id") int id) {
        userDAO.deleteUserById(id);
        return "Deleted User";
    }

}
