package com.mysqlwithspringboot.springbootwithmysql.repository;

import com.mysqlwithspringboot.springbootwithmysql.entity.StoreInformationProperties;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends CrudRepository<StoreInformationProperties, Integer> {

    List<StoreInformationProperties> findBystoreName(String storeName);
    List<StoreInformationProperties> findBystoreAddress(String storeAddress);
    List<StoreInformationProperties> findBystorePhoneNum(String storePhoneNum);


}
