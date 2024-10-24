package com.ocugene.service;

import com.ocugene.entity.Patient;
import com.ocugene.entity.requests.AddPatientRequest;
import com.ocugene.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    public Patient registerPatient(AddPatientRequest addPatientRequest){
        Patient patient = addPatientRequest.mapToPatient();
        return patientRepository.save(patient);
    }
}
