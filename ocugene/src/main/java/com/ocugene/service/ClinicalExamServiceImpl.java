package com.ocugene.service;

import com.ocugene.entity.ClinicalExam;
import com.ocugene.entity.requests.AddClinicalExamRequest;
import com.ocugene.repository.ClinicalExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicalExamServiceImpl implements ClinicalExamService{

    @Autowired
    ClinicalExamRepository clinicalExamRepository;

    @Override
    public ClinicalExam addClinicalExam(AddClinicalExamRequest addClinicalExamRequest) {
        ClinicalExam clinicalExam = addClinicalExamRequest.mapToClinicalExam();
        return clinicalExamRepository.save(clinicalExam);
    }
}
