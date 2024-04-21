package com.thirdpartapi.demo.DTO;

//import com.thirdpartapi.demo.Entity.Zipcodes;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class Responsefinal {
//   Zipcodes zipcodes;
    public String country;
    public List<City> cities;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

//    public Zipcodes getZipcodes() {
//        return zipcodes;
//    }
//
//    public void setZipcodes(Zipcodes zipcodes) {
//        this.zipcodes = zipcodes;
//    }
}
