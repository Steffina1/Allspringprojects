package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CountryWithStateResponse {
    private String error;
    private String msg;
    private CountryStateResponse data;

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

    public CountryStateResponse getData() {
        return data;
    }

    public void setData(CountryStateResponse data) {
        this.data = data;
    }
}
