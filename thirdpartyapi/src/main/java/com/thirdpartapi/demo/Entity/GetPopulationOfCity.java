package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class GetPopulationOfCity {
private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
