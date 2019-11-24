package com.hospital.frontdesk.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.properties.SpecialistsProperties;
import com.hospital.frontdesk.response.Specialist;

@Component
public class SpecialistData {

	@Autowired
	SpecialistsProperties specialistsProperties;

	@Cacheable("specialists")
	public List<Specialist> createDummyRecords() {
		System.out.println("Create dummy records");
		return specialistsProperties.getList();

	}
}
