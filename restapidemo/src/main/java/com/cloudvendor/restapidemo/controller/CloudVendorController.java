package com.cloudvendor.restapidemo.controller;

import com.cloudvendor.restapidemo.model.CloudVendor;
import com.cloudvendor.restapidemo.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cloudvendor.restapidemo.service.CloudVendorService;

import java.util.List;

//controller layer
@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {
    CloudVendorService cloudVendorservice;

    public CloudVendorController(CloudVendorService cloudVendorservice) {
        this.cloudVendorservice = cloudVendorservice;
    }
//get vendordetails from db
    @GetMapping("/id/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return cloudVendorservice.getCloudVendor(vendorId);
        //ResponseHandler.responsehandleremployee("The vendor details are displayed above", HttpStatus.OK,
        //new CloudVendor("C1", "Cvs", "Address one",
        //"xxxxxxxx");
    }
    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorservice.getAllCloudVendor();
    }
    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorservice.createCloudVendor(cloudVendor);
        return "Cloud vendor created successfully";
    }
@PutMapping
    public CloudVendor updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
    cloudVendorservice.updateCloudVendor(cloudVendor);
        return cloudVendor;
}

@DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId) {
    cloudVendorservice.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully";
}
}