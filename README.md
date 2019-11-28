# HospitalManagementSystem
https://dzone.com/articles/deploying-spring-boot-microservice-to-docker-a-qui
https://medium.com/faun/running-dockerized-applications-on-aws-d5cb92db9d16

#Test Endpoints
http://localhost:8080/v0/hospital/retrieveSpecialistDetails?specialist_type=eye&hospital_name=fortis
Accept:application/xml
http://localhost:8080/v0/hospital/getAppointmentDetails?specialist_name=sushil&hospital_name=fortis&patient_name=Dhruba&appointment_day=Thursday
http://localhost:8080/v0/hospital/callApi?env=localhost&port=8080&specialist_type=dentist&hospital_name=apollo
http://localhost:8080/v0/hospital/getNumberOfBeds?hospital_name=fortis