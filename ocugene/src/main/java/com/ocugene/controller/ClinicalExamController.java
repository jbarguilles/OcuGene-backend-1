package com.ocugene.controller;

import com.ocugene.entity.ClinicalExam;
import com.ocugene.entity.Patient;
import com.ocugene.entity.requests.AddClinicalExamRequest;
import com.ocugene.entity.requests.AddPatientRequest;
import com.ocugene.service.ClinicalExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = {"/clinicalexam"})
public class ClinicalExamController {

    @Autowired
    ClinicalExamServiceImpl clinicalExamService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ClinicalExam> registerPatient (@RequestBody AddClinicalExamRequest addClinicalExamRequest) {
        return ResponseEntity.ok(clinicalExamService.addClinicalExam(addClinicalExamRequest));
    }
}
