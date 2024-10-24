package com.ocugene.service;

import com.ocugene.entity.ClinicalExam;
import com.ocugene.entity.requests.AddClinicalExamRequest;
import org.springframework.stereotype.Service;

@Service
public interface ClinicalExamService {

    public ClinicalExam addClinicalExam(AddClinicalExamRequest addClinicalExamRequest);
}
