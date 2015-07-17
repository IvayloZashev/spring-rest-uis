package uis.model;

public class Country {
    //id of this country
    private int id;

    //name of this country
    private String countryName;

    /**
     * Default constructor
     */
    public Country() {
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
