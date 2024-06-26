package com.thirdpartapi.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UnicodeFlagdata {
    private String name;
    private String iso2;
    private String iso3;
    private String unicodeFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getUnicodeFlag() {
        return unicodeFlag;
    }

    public void setUnicodeFlag(String unicodeFlag) {
        this.unicodeFlag = unicodeFlag;
    }
}
