package uis.model;

import java.sql.Timestamp;

public class User {
    //id of this user
    private int id;

    //first name of this user
    private String firstName;

    //last name of this user
    private String lastName;

    //email of this user
    private String email;

    //country id of this user
    private int countryId;

    //city id of this user
    private int cityId;

    //street name and number of this user
    private String streetNameNumber;

    //phone number of this user
    private String phoneNumber;

    //status id of this user
    private int statusId;

    //date of creation of user's account
    private Timestamp dateCreated;

    //date of updating of user's account
    private Timestamp dateUpdated;

    //name of users' country
    private String countryName;

    //name of users' city
    private String cityName;

    //name of users' status
    private StatusName statusName;

    //username of the user
    private String username;

    //password of the user
    private String password;

    //admin rights
    private boolean admin;

    /**
     * Default constructor
     */
    public User() {
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.admin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public StatusName getStatusName() {
        return statusName;
    }

    public void setStatusName(StatusName statusName) {
        this.statusName = statusName;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getStreetNameNumber() {
        return streetNameNumber;
    }

    public void setStreetNameNumber(String streetNameNumber) {
        this.streetNameNumber = streetNameNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
