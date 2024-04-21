package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class Pcount {
    private String year;
    private String value;
    private String sex;
    private String reliabilty;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReliabilty() {
        return reliabilty;
    }

    public void setReliabilty(String reliabilty) {
        this.reliabilty = reliabilty;
    }
}
