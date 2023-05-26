package com.hospital.frontdesk.dao.repositories;

import com.hospital.frontdesk.dao.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

    @Query(value = "SELECT h FROM Hospital h WHERE h.hospitalCode = (?1)")
    Hospital findByHospitalCode(Integer hospitalCode);
}
