package com.ocugene.entity.projection;


import java.util.Date;

public interface PatientProjection {

    String getPatientCode();
    Date getBirthday();
    int getAge();
    String getSex();
    String getMaritalStatus();
    String getRegion();
    String getProvince();
    String getCity();
    String getBarangay();
    String getChiefComplaint();
    String getLaterality();
    String getBlurDuration();
    String getFamilyMember();
    int getSiblingCount();
    Date getErgDate();
    String getErgResult();
    String getDiagnosis();
    String getVariant();
    Date getGenTestDate();
    String getRightBcva();
    String getLeftBcva();
    String getRightRetina();
    String getLeftRetina();
    String getRightCornea();
    String getLeftCornea();
}
