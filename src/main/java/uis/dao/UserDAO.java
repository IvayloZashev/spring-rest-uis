package uis.dao;

import uis.model.User;

import javax.sql.DataSource;
import java.util.ArrayList;

public interface UserDAO {

    void setDataSource(DataSource dataSource);

    ArrayList<User> selectAllUsers();

    void updateUserInfo(String firstName, String lastName, String email, String streetNameNumber, String phoneNumber,
                   int countryId, int statusId, int cityId, int id, String username, String password, boolean isAdmin);

    void deleteUserById(int id);

    void insertUser(String firstName, String lastName, String email, int countryId, int cityId, String street,
                    String phone, int statusId, String username, String password, boolean isAdmin);
}
