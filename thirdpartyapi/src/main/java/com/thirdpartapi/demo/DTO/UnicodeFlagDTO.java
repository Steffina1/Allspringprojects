package com.thirdpartapi.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UnicodeFlagDTO {
    public String name;

    public String unicodeFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnicodeFlag() {
        return unicodeFlag;
    }

    public void setUnicodeFlag(String unicodeFlag) {
        this.unicodeFlag = unicodeFlag;
    }
}
