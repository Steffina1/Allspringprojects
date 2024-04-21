package com.thirdpartapi.demo.DTO;

//import com.thirdpartapi.demo.Entity.Countries;
//import com.thirdpartapi.demo.Entity.DialCodes;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UnicodeRequestDTO {

     public String iso2;

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
}
