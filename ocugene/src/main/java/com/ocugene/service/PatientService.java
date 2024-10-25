package com.ocugene.service;

import com.ocugene.entity.Patient;
import com.ocugene.entity.requests.AddPatientRequest;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {

    public Patient registerPatient(AddPatientRequest addPatientRequest);
    public int getLatestPatientNumber();
}
