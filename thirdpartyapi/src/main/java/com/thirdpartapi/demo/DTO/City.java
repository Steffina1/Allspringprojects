package com.thirdpartapi.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class City {

    private String city;

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    private String population;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
