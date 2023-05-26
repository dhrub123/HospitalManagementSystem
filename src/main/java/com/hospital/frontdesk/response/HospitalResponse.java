package com.hospital.frontdesk.response;

import java.io.Serializable;
import java.util.Objects;

public class HospitalResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer hospitalCode;

    private Integer totalBedsAvailable;

    private Integer totalPatientsAdmitted;

    private Integer totalPatientsDischarged;

    private String hospitalName;

    public Integer getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(Integer hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public Integer getTotalBedsAvailable() {
        return totalBedsAvailable;
    }

    public void setTotalBedsAvailable(Integer totalBedsAvailable) {
        this.totalBedsAvailable = totalBedsAvailable;
    }

    public Integer getTotalPatientsAdmitted() {
        return totalPatientsAdmitted;
    }

    public void setTotalPatientsAdmitted(Integer totalPatientsAdmitted) {
        this.totalPatientsAdmitted = totalPatientsAdmitted;
    }

    public Integer getTotalPatientsDischarged() {
        return totalPatientsDischarged;
    }

    public void setTotalPatientsDischarged(Integer totalPatientsDischarged) {
        this.totalPatientsDischarged = totalPatientsDischarged;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public HospitalResponse(Integer hospitalCode, Integer totalBedsAvailable, Integer totalPatientsAdmitted, Integer totalPatientsDischarged, String hospitalName) {
        this.hospitalCode = hospitalCode;
        this.totalBedsAvailable = totalBedsAvailable;
        this.totalPatientsAdmitted = totalPatientsAdmitted;
        this.totalPatientsDischarged = totalPatientsDischarged;
        this.hospitalName = hospitalName;
    }

    public HospitalResponse() {
    }

    @Override
    public String toString() {
        return "HospitalResponse{" +
                "hospitalCode=" + hospitalCode +
                ", totalBedsAvailable=" + totalBedsAvailable +
                ", totalPatientsAdmitted=" + totalPatientsAdmitted +
                ", totalPatientsDischarged=" + totalPatientsDischarged +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }
}
