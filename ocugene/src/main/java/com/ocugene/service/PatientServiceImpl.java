package com.ocugene.service;

import com.ocugene.entity.Patient;
import com.ocugene.entity.projection.RegionCount;
import com.ocugene.entity.projection.VariantCount;
import com.ocugene.entity.requests.AddPatientRequest;
import com.ocugene.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    public Patient registerPatient(AddPatientRequest addPatientRequest){
        Patient patient = addPatientRequest.mapToPatient();
        return patientRepository.save(patient);
    }

    public int getLatestPatientNumber(){
        Patient latestPatient = patientRepository.findTopByOrderByPatientIDDesc();
        return (latestPatient == null) ? 0 : latestPatient.getPatientID();
    }

    @Override
    public List<RegionCount> countPatientsPerRegion() {
        return patientRepository.countPatientsPerRegion();
    }

    @Override
    public List<VariantCount> countPatientsPerVariant() {
        return patientRepository.countPatientsPerVariant();
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
