package com.thirdpartapi.demo.Controller;

import com.thirdpartapi.demo.DTO.*;
import com.thirdpartapi.demo.Entity.*;
import com.thirdpartapi.demo.Service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/restapi")
public class RestController {
@Autowired
   RestService restService;
private static final Logger logger = LoggerFactory.getLogger(RestController.class);


//    @GetMapping("/getPosts")
//    List<Map<String, Object>> getallPosts() {
//     return restService.getPosts();
//    }
//
//    @GetMapping("/getPosts/{id}")
//    Map<String, Object> getpostsbyId(@PathVariable("id") int id) {
//        return restService.getPostbyId(id);
//    }
//    @PostMapping("/createPost")
//    Map<String, Object> createPost(@RequestBody Map<String, Object> payload) {
//        return restService.createPost(payload);
//    }
//    @PutMapping("/updatePost/{id}")
//    Map<String, Object> updatePost(@PathVariable("id") int id, @RequestBody Map<String, Object> payload) {
//        return restService.updatePost(id, payload);
//    }
//    @DeleteMapping("/deletePost/{id}")
//    Map<String, Object> deletePost(@PathVariable("id") int id) {
//        return restService.deletePostbyId(id);
//    }
    @GetMapping("/getcountries")
    List<CapitalDTO> getAllCountriesAndCapitals() {
     return restService.getallcountriesAndCapitals();
    }

    @PostMapping("/getcitiesfromcountry")
    List<CitiesDTO> getCitiesfromCountry(@RequestBody Countryrequest countryrequest) {
        return restService.getCitiesfromCountries(countryrequest);
    }
    @PostMapping("/getcapitalofonecountry")
    CapitalDTO getCapitalOfCountry(@RequestBody Countryrequest countryrequest) {
        return restService.getCapitalFromCountry(countryrequest);
    }

//    @GetMapping("/getcountriescities")
//    List<Countries> getAllCountriesAndCities() {
//        return restService.getAllCountiresandCities();
//    }

    @PostMapping("/getunicodeflag")
   UnicodeFlagDTO getUnicodes(@RequestBody UnicodeRequestDTO unicodeRequestDTO) {
        return restService.getUnicodeFlagfromIso(unicodeRequestDTO);
    }
       @PostMapping("/getstatesfromcountry")
         List<StatesDTO> getStates(@RequestBody Countryrequest countryrequest) {
           logger.info("Calling post request for getting states");
    return restService.getStatesofCountry(countryrequest);
}

//    @GetMapping("/getpopulationcountfromcity/{cityname}")
//    Populationvalue getpopulatonfromcity(@PathVariable ("cityname") String cityname) {
//        return restService.getpopulationdatafromcity(cityname);
//    }
//
    @PostMapping
    List<JsontitleDTO> gettitle(@RequestBody Jsontitle jsontitle) {
        logger.info("Calling post request for getting title");
        return restService.getCitiesAndIdFromCountries(jsontitle);
    }







}
