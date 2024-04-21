package com.cloudvendor.restapidemo.service.implementation;

import com.cloudvendor.restapidemo.exception.CloudvendorNotFoundException;
import com.cloudvendor.restapidemo.model.CloudVendor;
import com.cloudvendor.restapidemo.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import com.cloudvendor.restapidemo.repository.CloudVendorRepository;

import java.util.List;
@Service
@EnableCaching
public class CloudServiceImplemenet implements CloudVendorService {
    @Autowired
    CloudVendorRepository cloudVendorRepository;


    public CloudServiceImplemenet(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudvendor) {
        cloudVendorRepository.save(cloudvendor);
        return "Success creating";
    }

    @Override
    @CachePut(cacheNames = "cacheCloud", key="#cloudvendor.id")
    public CloudVendor updateCloudVendor(CloudVendor cloudvendor) {
        cloudVendorRepository.save(cloudvendor);
        return cloudvendor;
    }

    @Override
    @CacheEvict(cacheNames = "cacheCloud", key="#id")
    public String deleteCloudVendor(String id) {
        cloudVendorRepository.deleteById(id);
        return "Success deleted";
    }

    @Override
 @Cacheable(cacheNames = "cacheCloud", key="#id")
    public CloudVendor getCloudVendor(String id) {
//        if(cloudVendorRepository.findById(id).isEmpty())
//            throw new CloudvendorNotFoundException("Requested Cloud Vendor does not exist");
        System.out.println("Fetching from db");
        return cloudVendorRepository.findById(id).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
