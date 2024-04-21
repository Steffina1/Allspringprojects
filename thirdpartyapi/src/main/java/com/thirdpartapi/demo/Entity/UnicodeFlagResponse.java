package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UnicodeFlagResponse {
    public String error;
    public String msg;
    public UnicodeFlagdata data;

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

    public UnicodeFlagdata getData() {
        return data;
    }

    public void setData(UnicodeFlagdata data) {
        this.data = data;
    }
}
