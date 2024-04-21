package com.cloudvendor.restapidemo.repository;

import com.cloudvendor.restapidemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
