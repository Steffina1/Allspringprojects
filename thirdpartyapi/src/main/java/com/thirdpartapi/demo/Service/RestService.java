package com.thirdpartapi.demo.Service;

import com.thirdpartapi.demo.DTO.*;
import com.thirdpartapi.demo.Entity.*;

import java.util.List;

public interface RestService {

//    List<Map<String, Object>> getPosts();
//    Map<String, Object> getPostbyId(int id);
//    Map<String, Object> createPost(Map<String, Object> payload);
//    Map<String, Object> updatePost(int id, Map<String, Object> payload);
//    Map<String, Object> deletePostbyId(int id);

    CapitalDTO getCapitalFromCountry(Countryrequest countryrequest);
    List<StatesDTO> getStatesofCountry(Countryrequest countryrequest);
    List<CapitalDTO> getallcountriesAndCapitals();

    List<CitiesDTO> getCitiesfromCountries(Countryrequest countryrequest);
    UnicodeFlagDTO getUnicodeFlagfromIso(UnicodeRequestDTO unicodeRequestDTO);
//    Populationvalue getpopulationdatafromcity(String cityname);
    List<JsontitleDTO> getCitiesAndIdFromCountries(Jsontitle jsontitle);




}
