package com.thirdpartapi.demo.Service.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thirdpartapi.demo.DTO.*;
import com.thirdpartapi.demo.Entity.*;
import com.thirdpartapi.demo.Service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestServiceImpl implements RestService {
    String baseurl = "https://jsonplaceholder.typicode.com/";
    // List<Countries> countriesCitiesList = new ArrayList<>();


    StringBuilder stringBuilder = new StringBuilder(baseurl);
    String getpost = "posts";
    @Autowired
    private RestTemplate restTemplate;

    private HttpHeaders gethttpheaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }


    @Override
    public CapitalDTO getCapitalFromCountry(Countryrequest countryrequest) {
        CapitalDTO capitalDTO = new CapitalDTO();
        String capitalurl = "https://countriesnow.space/api/v0.1/countries/capital";
        HttpEntity<Countryrequest> request = new HttpEntity<Countryrequest>(countryrequest, gethttpheaders());
        Capitalfromcountry capitalfromcountry = restTemplate.postForEntity(capitalurl, request, Capitalfromcountry.class).getBody();
        try {
            Capitals capitals = (Capitals) capitalfromcountry.getData();
            if (!countryrequest.getCountry().isEmpty()) {
                capitalDTO.setName(capitals.getName());
                capitalDTO.setCapital(capitals.getCapital());
            }
        } catch (NullPointerException e) {
            return null;
        }
        return capitalDTO;
    }

    @Override
    public List<StatesDTO> getStatesofCountry(Countryrequest countryrequest) {
        List<StatesDTO> statesDTOList = new ArrayList<>();
        String statesurl = "https://countriesnow.space/api/v0.1/countries/states";
        HttpEntity<Countryrequest> request = new HttpEntity<Countryrequest>(countryrequest);
        ResponseEntity<CountryWithStateResponse> response = restTemplate
                .exchange(statesurl, HttpMethod.POST, request, CountryWithStateResponse.class);
        try {
            List<States> listofStates = Objects.requireNonNull(response.getBody()).getData().getStates();
            for (States states : listofStates) {
                StatesDTO statesDTO = new StatesDTO();
                if (countryrequest.getCountry().equals(response.getBody().getData().getName())) {
                    statesDTO.setStatename(states.getName());
                }
                statesDTOList.add(statesDTO);
            }
        } catch (NullPointerException e) {
            return null;
        }

        return statesDTOList;
    }

    @Override
    public List<CapitalDTO> getallcountriesAndCapitals() {
        List<CapitalDTO> capitalDTOList = new ArrayList<>();
        String capitalurl = "https://countriesnow.space/api/v0.1/countries/capital";
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpheaders());
        Capitalfromcountry capitalfromcountry = restTemplate.getForEntity(capitalurl, Capitalfromcountry.class).getBody();
        List<Capitals> capitals = capitalfromcountry.getData();
        for (Capitals capitals1 : capitals) {
            CapitalDTO capitalDTO = new CapitalDTO();
            capitalDTO.setName(capitals1.getName());
            capitalDTO.setCapital(capitals1.getCapital());
            capitalDTOList.add(capitalDTO);
        }
        return capitalDTOList;
    }


    @Override
    public List<CitiesDTO> getCitiesfromCountries(Countryrequest countryrequest) {
        List<CitiesDTO> citydtolist = new ArrayList<>();
        String citiesurl = "https://countriesnow.space/api/v0.1/countries/cities";
        HttpEntity<Countryrequest> request = new HttpEntity<Countryrequest>(countryrequest, gethttpheaders());
        CountryApiResponse countryApiResponse = restTemplate.postForEntity(citiesurl, request, CountryApiResponse.class).getBody();
        if (countryApiResponse != null) {
            for (String city : countryApiResponse.getData()) {
                CitiesDTO cityDto = new CitiesDTO();
                if (countryrequest.getCountry() != null) {
                    cityDto.setCityname(String.valueOf(city));
                }
                citydtolist.add(cityDto);
            }
        }
        return citydtolist;
    }

    @Override
    public UnicodeFlagDTO getUnicodeFlagfromIso(UnicodeRequestDTO unicodeRequestDTO) {
        String uniurl = "https://countriesnow.space/api/v0.1/countries/flag/unicode";
        HttpEntity<UnicodeRequestDTO> request = new HttpEntity<>(unicodeRequestDTO, gethttpheaders());
        Object[] object = new Object[]{restTemplate.postForObject(uniurl, request, UnicodeFlagResponse.class)};
        ObjectMapper objectMapper = new ObjectMapper();
     UnicodeFlagdata unicodeFlagdata= Arrays.stream(object).map(o -> objectMapper.convertValue(o, UnicodeFlagResponse.class)).map(UnicodeFlagResponse::getData).
             toList().get(0);
//        restTemplate.postForEntity(uniurl, request, UnicodeFlagResponse.class);
//        UnicodeFlagdata unicodeFlagdata = unicodeFlagResponse.getData();
        UnicodeFlagDTO unicodeFlagDTO = new UnicodeFlagDTO();
        unicodeFlagDTO.setUnicodeFlag(unicodeFlagdata.getUnicodeFlag());
        unicodeFlagDTO.setName(unicodeFlagdata.getName());
        return unicodeFlagDTO;
    }

//
//                    Populationvalue citypop = getpopulationdatafromcity(city);
//                    if(citypop !=null)
//
//    {
//        cityDto.setPopulation(citypop.getPopulationcount());
//    }

//        Object[] object = new Object[]{restTemplate.postForObject(uniurl, request, UnicodeFlagResponse.class)};
//        ObjectMapper objectMapper = new ObjectMapper();
//     UnicodeFlagdata unicodeFlagdata= (UnicodeFlagdata) Arrays.stream(object).map(o -> objectMapper.convertValue(o, UnicodeFlagResponse.class)).map(UnicodeFlagResponse::getData).
//             toList().get(0);


    //ArrayList<Cities> citylist = new ArrayList<>();
    //HttpEntity<Map> httpEntity = new HttpEntity<>(gethttpheaders());
    //Object[] object = new Object[]{restTemplate.getForObject(citiesurl, Object.class)};
    // ObjectMapper objectMapper1 = new ObjectMapper();
    // citylist=  Arrays.stream(object).map(o -> objectMapper1.convertValue(o, Countries.class)).map(Countries::getData).
    //       collect(Collectors.toList()).get(0);

//        CitiesDTO citiesDTO = new CitiesDTO();
//        for(Cities cityname: citylist) {
//            //if (countries.getMsg().contains(name)) {
//                citiesDTO.setCityname(String.valueOf(cityname));
//                Populationvalue cityPop = getpopulationdatafromcity(String.valueOf(cityname));
//                if(cityPop != null && cityPop.getPopulationcount() != null) {
//                    citiesDTO.setPopulation(cityPop.getPopulationcount());
//                }
//            citydtolist.add(citiesDTO);
//                }



    //}
    //}


//    @Override
//    public Populationvalue getpopulationdatafromcity(String cityname) {
//
//        RestTemplate restTemplate = new RestTemplate();
//        Populationvalue populationvalue = new Populationvalue();
//        String populationurl = "https://countriesnow.space/api/v0.1/countries/population/cities/q?city={0}&name=null";
//        populationurl = populationurl.replace("{0}", cityname);
//        PopulationCount populationCount = null;
//        try{
//            populationCount = restTemplate.getForObject(populationurl, PopulationCount.class);
//        }
//        catch (Exception ex)
//        {
//            return null;
//        }
//
//        if (populationCount != null && populationCount.getData() != null &&
//                populationCount.getData().getPopulationCounts() != null &&
//                !populationCount.getData().getPopulationCounts().isEmpty() &&
//                populationCount.getData().getPopulationCounts().stream().findFirst().isPresent()) {
//            populationvalue.setPopulationcount(populationCount.getData().getPopulationCounts().get(0).getValue());
//        }
//        return populationvalue;
//    }

    @Override
    public List<JsontitleDTO> getCitiesAndIdFromCountries(Jsontitle jsontitle) {
        String jsonurl = "https://jsonplaceholder.typicode.com/posts";
        HttpEntity<Jsontitle> request = new HttpEntity<Jsontitle>(jsontitle);
        JsontitleDTO jsontitleDTO = restTemplate.postForEntity(jsonurl, request, JsontitleDTO.class).getBody();
        List<JsontitleDTO> jsontitleDTOList = new ArrayList<>();
        jsontitleDTOList.add(jsontitleDTO);
        return jsontitleDTOList;
    }
}

//    @Override
//    public JsontitleDTO gettitlefromJson(Jsontitle jsontitle) {
//        String jsonurl="https://jsonplaceholder.typicode.com/posts";
//        HttpEntity<Jsontitle> request = new HttpEntity<Jsontitle>(jsontitle);
//      JsontitleDTO jsontitleDTO=   restTemplate.postForEntity(jsonurl, request, JsontitleDTO.class).getBody();
//        return jsontitleDTO;
//    }







        //POST Code
        //GetPopulationOfCity getPopulationOfCity= new GetPopulationOfCity();
        //getPopulationOfCity.setCity(cityname);
        //HttpEntity<GetPopulationOfCity> request =
         //       new HttpEntity<GetPopulationOfCity>(getPopulationOfCity);

        //// Object[] object1 = new Object[]{restTemplate.postForObject(populationurl, request, Object.class)};


//
//        List<Populationdata> populationdataList = new ArrayList<>();
//        String populationurl = "https://countriesnow.space/api/v0.1/countries/population/cities";
//        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpheaders());
//        Object[] object = new Object[]{restTemplate.getForObject(populationurl, Object.class)};
//        ObjectMapper objectMapper = new ObjectMapper();
//        populationdataList = Arrays.stream(object).map(o -> objectMapper.convertValue(o, PopulationCount.class)).map(PopulationCount::getData)
//                .collect(Collectors.toList()).get(0);
//
//        List<PopulationCount> populationCountList = new ArrayList<>();
//        for (Populationdata pd : populationdataList) {
//            if (pd.getCity().equals(cityname)) {
//                populationvalue.setPopulationcount(pd.getPopulationCounts().get(0).getValue());
//            }
//
//        }








//    @Override
//    public List<DialCodes> getDialCodesOfCountries() {
//        String dialcodeurl = "https://countriesnow.space/api/v0.1/countries/codes";
//        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpheaders());
//        Object[] object = new Object[]{restTemplate.getForObject(dialcodeurl, Object.class)};
//        ObjectMapper objectMapper = new ObjectMapper();
//        dialCodesList= Arrays.stream(object).map(o -> objectMapper.convertValue(o, Zipcodes.class)).map(Zipcodes::getData).
//                collect(Collectors.toList()).get(0);
//        return dialCodesList;
//
//    }



//    @Override
//    public DialCodewithcities getdialcodeandcities(String countryname) {
//        List<DialCodewithcities> dialCodewithcitiesList = new ArrayList<>();
//        String countryurl = "https://countriesnow.space/api/v0.1/countries";
//        String dialcodeurl = "https://countriesnow.space/api/v0.1/countries/codes";
//        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpheaders());
//        Object[] object = new Object[]{restTemplate.getForObject(countryurl, Object.class)};
//        Object[] object1 = new Object[]{restTemplate.getForObject(dialcodeurl, Object.class)};
//        ObjectMapper objectMapper = new ObjectMapper();
//        dialCodewithcitiesList= Arrays.stream(object).map(o -> objectMapper.convertValue(o, Dataresponse.class)).map(Dataresponse::getData).
//                collect(Collectors.toList());
//        return
//    }




//    @Override
//    public List getPosts() {
//        String url = stringBuilder.append(getpost).toString();
//        //pass header and payload in http entity
//        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpheaders());
//        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class).getBody();
//    }
//
//    @Override
//    public Map getPostbyId(int id) {
//        String getbyidurl = stringBuilder.append(getpost).append("/"+id).toString();
//        //pass header and payload in http entity
//        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpheaders());
//        return restTemplate.exchange(getbyidurl, HttpMethod.GET, httpEntity, Map.class).getBody();
//    }
//
//    @Override
//    public Map<String, Object> createPost(Map<String, Object> payload) {
//        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, gethttpheaders() );
//            String postural = stringBuilder.append(getpost).toString();
//            //pass header and payload in http entity
//            return restTemplate.exchange(postural, HttpMethod.POST, httpEntity, Map.class).getBody();
//        }

//    @Override
//    public Map<String, Object> updatePost(int id, Map<String, Object> payload) {
//        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, gethttpheaders() );
//        String putural = stringBuilder.append(getpost).append("/"+id).toString();
//        //pass header and payload in http entity
//        return restTemplate.exchange(putural, HttpMethod.PUT, httpEntity, Map.class).getBody();
//    }
//
//    @Override
//    public Map<String, Object> deletePostbyId(int id) {
//        HttpEntity<Map> httpEntity = new HttpEntity<>(gethttpheaders());
//        String deleteural = stringBuilder.append(getpost).append("/"+id).toString();
//        //pass header and payload in http entity
//        return restTemplate.exchange(deleteural, HttpMethod.DELETE, httpEntity, Map.class).getBody();
//    }

//    @Override
//    public CapitalDTO getcapitalfromcountry(String countrynme) {
//        List<Capitals> capitalsList = new ArrayList<>();
//        HttpEntity<Map> httpEntity = new HttpEntity<>(gethttpheaders());
//        String capitalurl="https://countriesnow.space/api/v0.1/countries/capital";
//        Object[] object = new Object[]{restTemplate.getForObject(capitalurl, Object.class)};
//        ObjectMapper objectMapper = new ObjectMapper();
//        capitalsList=  Arrays.stream(object).map(o -> objectMapper.convertValue(o, Capitalfromcountry.class)).map(Capitalfromcountry::getData).
//                collect(Collectors.toList()).get(0);
//        CapitalDTO capitalDTO = new CapitalDTO();
//        for(Capitals capitl : capitalsList) {
//            if(capitl.getName().equals(countrynme)) {
//                capitalDTO.setName(capitl.getName());
//                capitalDTO.setCapital(capitl.getCapital());
//
//            }
//
//        }
//        return capitalDTO;
//
//    }






