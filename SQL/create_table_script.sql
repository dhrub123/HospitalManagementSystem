CREATE SCHEMA health;

CREATE TABLE health.hospital (
    hospital_code     INTEGER,
    total_beds_available INTEGER,
    total_patients_admitted INTEGER,
    total_patients_discharged INTEGER,
    hospital_name    VARCHAR(255)
);

CREATE TABLE health.specialist (
    hospital_code     INTEGER,
    specialist_type    VARCHAR(255),
    specialist_name    VARCHAR(255),
    specialist_available_days    VARCHAR(255),
    specialist_available_time    VARCHAR(255),
    is_available BOOLEAN
);