package com.hospital.frontdesk.dao.mapper;

import com.hospital.frontdesk.dao.entities.Hospital;
import com.hospital.frontdesk.response.HospitalResponse;
import org.springframework.beans.BeanUtils;

public class HospitalMapper {

    public static HospitalResponse toResponse(Hospital hospitalEntity){
        HospitalResponse response = new HospitalResponse();
        BeanUtils.copyProperties(hospitalEntity, response);

        System.out.println("entity data = " + hospitalEntity);
        System.out.println("response = " + response);
        return response;
    }
}
