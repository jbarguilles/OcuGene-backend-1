package com.ocugene.service;

import com.ocugene.entity.Patient;
import com.ocugene.entity.projection.*;
import com.ocugene.entity.requests.AddPatientRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    Patient registerPatient(AddPatientRequest addPatientRequest);
    int getLatestPatientNumber();
    List<RegionCount> countPatientsPerRegion();
    List<VariantCount> countPatientsPerVariant();
    List<Patient> getAllPatients();
    Patient getByPatientCode(String patientCode);
    List<PatientProjection> getAllProjectedBy();
    BcvaStats getLeftBcvaStats();
    BcvaStats getRightBcvaStats();

}
