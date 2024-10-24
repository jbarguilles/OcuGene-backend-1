package com.ocugene.controller;

import com.ocugene.entity.Patient;
import com.ocugene.entity.requests.AddPatientRequest;
import com.ocugene.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = {"/patient"})
public class PatientController {

    @Autowired
    PatientServiceImpl patientService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Patient> registerPatient (@RequestBody AddPatientRequest addPatientRequest) {
        return ResponseEntity.ok(patientService.registerPatient(addPatientRequest));
    }
}
