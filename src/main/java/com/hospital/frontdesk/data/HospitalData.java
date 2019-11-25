package com.hospital.frontdesk.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.properties.HospitalProperties;
import com.hospital.frontdesk.response.Hospital;

@Component
public class HospitalData {

	@Autowired
	HospitalProperties hospitalProperties;

	@Cacheable("hospitals")
	public List<Hospital> createDummyRecords() {
		System.out.println("Create dummy hospital records");
		return hospitalProperties.getList();

	}
}
