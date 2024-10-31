package com.ocugene.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "patient", schema = "registrydatabase")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "region")
    private String region;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "barangay")
    private String barangay;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "chief_complaint")
    private String chiefComplaint;

    @Column(name = "blur_duration")
    private String blurDuration;

    @Column(name = "laterality")
    private String laterality;

    @Column(name = "family_member")
    private String familyMember;

    @Column(name = "sibling_count")
    private int siblingCount;

    @Column(name = "erg_date")
    private Date ergDate;

    @Column(name = "erg_result")
    private String ergResult;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "variant")
    private String variant;

    @Column(name = "gen_test_date")
    private Date genTestDate;

    @Column(name = "patient_code")
    private String patientCode;

    @Column(name = "right_bcva")
    String rightBCVA;

    @Column(name = "left_bcva")
    String leftBCVA;

    @Column(name = "right_retina")
    String rightRetina;

    @Column(name = "left_retina")
    String leftRetina;

    @Column(name = "right_cornea")
    String rightCornea;

    @Column(name = "left_cornea")
    String leftCornea;
}
