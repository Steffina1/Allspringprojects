package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class Populationdata {
    private String city;
    private String country;
    List<Pcount> populationCounts;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Pcount> getPopulationCounts() {
        return populationCounts;
    }

    public void setPopulationCounts(List<Pcount> populationCounts) {
        this.populationCounts = populationCounts;
    }
}
