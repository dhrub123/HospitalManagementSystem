package com.hospital.frontdesk.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.response.Specialist;

@Component
@PropertySource(name = "specialistData", value = "classpath:specialist.properties", ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "specialist")
public class SpecialistsProperties {

	private List<Specialist> list;

	public List<Specialist> getList() {
		return list;
	}

	public void setList(List<Specialist> list) {
		this.list = list;
	}

}
