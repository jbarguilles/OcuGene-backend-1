package com.ocugene.service;

import com.ocugene.entity.Patient;
import com.ocugene.entity.User;
import com.ocugene.entity.projection.*;
import com.ocugene.entity.requests.AddPatientRequest;
import com.ocugene.repository.PatientRepository;
import com.ocugene.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserRepository userRepository;

    public Patient registerPatient(AddPatientRequest addPatientRequest){
        Patient patient = addPatientRequest.mapToPatient();

        User user = new User();
        user.setUserType("patient");
        user.setUsername(addPatientRequest.getPatientCode());

        String patientFirstName = addPatientRequest.getFirstName().toLowerCase().replace(" ", "");
        String patientLastName = addPatientRequest.getLastName().toLowerCase().replace(" ", "");

        user.setUserPassword(patientFirstName.concat(patientLastName));
        user.setFirstName(addPatientRequest.getFirstName());
        user.setLastName(addPatientRequest.getLastName());
        user.setContactNumber(addPatientRequest.getContactNumber());

        patient.setCredentials(user);
        userRepository.save(user);

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

    @Override
    public Patient getByPatientCode(String patientCode) {
        return patientRepository.findByPatientCode(patientCode);
    }
    @Override
    public List<PatientProjection> getAllProjectedBy(){
        return patientRepository.findAllProjectedBy();
    }

    @Override
    public BcvaStats getLeftBcvaStats() {
        return patientRepository.getLeftBcvaStats();
    }

    @Override
    public BcvaStats getRightBcvaStats() {
        return patientRepository.getRightBcvaStats();
    }

    @Override
    public CornealOpacityStats getLeftCornealOpacityStats() {
        return patientRepository.getLeftCornealOpacityStats();
    }

    @Override
    public CornealOpacityStats getRightCornealOpacityStats() {
        return patientRepository.getRightCornealOpacityStats();
    }

    @Override
    public RetinalConditionStats getLeftRetinalConditionStats() {
        return patientRepository.getLeftRetinalConditionStats();
    }

    @Override
    public RetinalConditionStats getRightRetinalConditionStats() {
        return patientRepository.getRightRetinalConditionStats();
    }
}
