package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Capitalfromcountry {

    public String error;
    public String msg;
    public List<Capitals> data;


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

    public List<Capitals> getData() {
        return data;
    }

    public void setData(List<Capitals> data) {
        this.data = data;
    }
}
