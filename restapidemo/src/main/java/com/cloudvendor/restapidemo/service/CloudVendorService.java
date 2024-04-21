package com.cloudvendor.restapidemo.service;

import com.cloudvendor.restapidemo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudvendor);
    public CloudVendor updateCloudVendor(CloudVendor cloudvendor);
    public String deleteCloudVendor(String id);
    public CloudVendor getCloudVendor(String id);
    public List<CloudVendor> getAllCloudVendor();


}
