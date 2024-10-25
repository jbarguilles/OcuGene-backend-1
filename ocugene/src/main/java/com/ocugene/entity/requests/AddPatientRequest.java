package com.ocugene.entity.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AddPatientRequest {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("age")
    private int age;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("address")
    private String address;

    @JsonProperty("region")
    private String region;

    @JsonProperty("province")
    private String province;

    @JsonProperty("city")
    private String city;

    @JsonProperty("marital_status")
    private String maritalStatus;

    @JsonProperty("chief_complaint")
    private String chiefComplaint;

    @JsonProperty("blur_duration")
    private String blurDuration;

    @JsonProperty("laterality")
    private String laterality;

    @JsonProperty("family_member")
    private String familyMember;

    @JsonProperty("sibling_count")
    private int siblingCount;

    @JsonProperty("erg_date")
    private String ergDate;

    @JsonProperty("erg_result")
    private String ergResult;

    @JsonProperty("diagnosis")
    private String diagnosis;

    @JsonProperty("variant")
    private String variant;

    @JsonProperty("gen_test_date")
    private String genTestDate;

    @JsonProperty("patient_code")
    private String patientCode;

    @JsonProperty("right_bcva")
    private String rightBCVA;

    @JsonProperty("left_bcva")
    private String leftBCVA;

    @JsonProperty("right_retina")
    private String rightRetina;

    @JsonProperty("left_retina")
    private String leftRetina;

    @JsonProperty("right_cornea")
    private String rightCornea;

    @JsonProperty("left_cornea")
    private String leftCornea;

    public Patient mapToPatient(){
        Patient patient = new Patient();
        patient.setFirstName(this.firstName);

        patient.setMiddleName(this.middleName);
        patient.setLastName(this.lastName);
        patient.setAge(this.age);
        patient.setSex(this.sex);

        if(this.birthday != null && this.ergDate != null && this.genTestDate != null){
            patient.setBirthday(Date.valueOf(this.birthday));
            patient.setErgDate(Date.valueOf(this.ergDate));
            patient.setGenTestDate(Date.valueOf(this.genTestDate));
        }
        else{
            patient.setBirthday(new java.util.Date());
            patient.setErgDate(new java.util.Date());
            patient.setGenTestDate(new java.util.Date());
        }

        patient.setAddress(this.address);
        patient.setRegion(this.region);
        patient.setProvince(this.province);
        patient.setCity(this.city);
        patient.setMaritalStatus(this.maritalStatus);
        patient.setChiefComplaint(this.chiefComplaint);
        patient.setBlurDuration(this.blurDuration);
        patient.setLaterality(this.laterality);
        patient.setFamilyMember(this.familyMember);
        patient.setSiblingCount(this.siblingCount);
        patient.setErgResult(this.ergResult);
        patient.setDiagnosis(this.diagnosis);
        patient.setVariant(this.variant);
        patient.setPatientCode(this.patientCode);

        patient.setRightBCVA(this.rightBCVA);
        patient.setLeftBCVA(this.leftBCVA);
        patient.setRightCornea(this.rightCornea);
        patient.setLeftCornea(this.leftCornea);
        patient.setRightRetina(this.rightRetina);
        patient.setLeftRetina(this.leftRetina);

        return patient;
    }
}
