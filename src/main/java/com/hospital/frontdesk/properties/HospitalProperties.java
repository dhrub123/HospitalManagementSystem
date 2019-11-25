package com.hospital.frontdesk.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.response.Hospital;

@Component
@PropertySource(name = "hospitalData", value = "classpath:hospital.properties", ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "hospital")
public class HospitalProperties {

	private List<Hospital> list;

	public List<Hospital> getList() {
		return list;
	}

	public void setList(List<Hospital> list) {
		this.list = list;
	}

}
