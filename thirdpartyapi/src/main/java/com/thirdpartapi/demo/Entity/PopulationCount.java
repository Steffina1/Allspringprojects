package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class PopulationCount {
    public String error;
    public String msg;
    Populationdata data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Populationdata getData() {
        return data;
    }

    public void setData(Populationdata data) {
        this.data = data;
    }
}

