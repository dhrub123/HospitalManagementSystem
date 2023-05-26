package com.hospital.frontdesk.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hospital")
@NamedQuery(name="Hospital.findAll", query="SELECT h FROM Hospital h")
@Data
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hospital_code")
    private Integer hospitalCode;

    @Column(name = "total_beds_available")
    private Integer totalBedsAvailable;

    @Column(name = "total_patients_admitted")
    private Integer totalPatientsAdmitted;

    @Column(name = "total_patients_discharged")
    private Integer totalPatientsDischarged;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }else if (o.hashCode() != this.hashCode()) {
            return true;
        }else{
            return false;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(hospitalCode, totalBedsAvailable, totalPatientsAdmitted, totalPatientsDischarged, hospitalName);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalCode=" + hospitalCode +
                ", totalBedsAvailable=" + totalBedsAvailable +
                ", totalPatientsAdmitted=" + totalPatientsAdmitted +
                ", totalPatientsDischarged=" + totalPatientsDischarged +
                ", hospitalName=" + hospitalName +
                '}';
    }
}
