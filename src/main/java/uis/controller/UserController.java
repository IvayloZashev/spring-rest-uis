package uis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uis.model.User;
import uis.dao.UserDAOImpl;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDAOImpl userDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> listUser() {
        return userDAO.selectAllUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "email") String email,
                         @RequestParam(value = "countryId") int countryId, @RequestParam(value = "cityId") int cityId, @RequestParam(value = "street") String street,
                         @RequestParam(value = "phone") String phone, @RequestParam(value = "statusId") int statusId, @RequestParam(value = "username") String username,
                         @RequestParam(value = "password") String password, @RequestParam(value = "isAdmin") boolean isAdmin) {

        userDAO.insertUser(name, lastName, email, countryId, cityId, street, phone, statusId, username, password, isAdmin);
        return "Inserted user" + name + lastName;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "email") String email,
                       @RequestParam(value = "street") String street, @RequestParam(value = "phone") String phone, @RequestParam(value = "countryId") int countryId,
                       @RequestParam(value = "statusId") int statusId, @RequestParam(value = "cityId") int cityId, @RequestParam(value = "id") int id,
                       @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "isAdmin") boolean isAdmin) {

        userDAO.updateUserInfo(name, lastName, email, street, phone, countryId, statusId, cityId, id, username, password, isAdmin);
        return "Edited user" + name + lastName;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam(value = "id") int id) {
        userDAO.deleteUserById(id);
        return "Deleted user";
    }

}
