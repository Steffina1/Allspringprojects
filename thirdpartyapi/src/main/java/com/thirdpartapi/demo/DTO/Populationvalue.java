package com.thirdpartapi.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class Populationvalue {
    private String populationcount;

    public String getPopulationcount() {
        return populationcount;
    }

    public void setPopulationcount(String populationcount) {
        this.populationcount = populationcount;
    }
}
