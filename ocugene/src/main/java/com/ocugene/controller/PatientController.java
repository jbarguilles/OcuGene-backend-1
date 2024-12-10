package com.ocugene.controller;

import com.ocugene.entity.Patient;
import com.ocugene.entity.projection.*;
import com.ocugene.entity.requests.AddPatientRequest;
import com.ocugene.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = {"/patient"})
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Patient> registerPatient (@RequestBody AddPatientRequest addPatientRequest) {
        return ResponseEntity.ok(patientService.registerPatient(addPatientRequest));
    }

    @GetMapping("/getLatestID")
    @ResponseBody
    public ResponseEntity<Integer> getLatestPatientID(){
        return ResponseEntity.ok(patientService.getLatestPatientNumber());
    }

    @GetMapping("/count-per-region")
    @ResponseBody
    public ResponseEntity<List<RegionCount>> countPatientsPerRegion(){
        return ResponseEntity.ok(patientService.countPatientsPerRegion());
    }

    @GetMapping("/count-per-variant")
    @ResponseBody
    public ResponseEntity<List<VariantCount>> countPatientsPerVariant(){
        return ResponseEntity.ok(patientService.countPatientsPerVariant());
    }

    @GetMapping("/get-all")
    @ResponseBody
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/get-all-projections")
    @ResponseBody
    public ResponseEntity<List<PatientProjection>> getAllPatientsProjectedBy(){
        return ResponseEntity.ok(patientService.getAllProjectedBy());
    }

    @GetMapping("/get-by-patient-code")
    @ResponseBody
    public ResponseEntity<Patient> getByPatientID(@RequestParam String patientCode){
        return ResponseEntity.ok(patientService.getByPatientCode(patientCode));
    }

    @GetMapping("/get-left-bcva-stats")
    @ResponseBody
    public ResponseEntity<List<BcvaStats>> getLeftBcvaStats(){

        return  ResponseEntity.ok(patientService.getLeftBcvaStats());
    }

    @GetMapping("/get-right-bcva-stats")
    @ResponseBody
    public ResponseEntity<List<BcvaStats>> getRightBcvaStats(){

        return  ResponseEntity.ok(patientService.getRightBcvaStats());
    }

    @GetMapping("/get-left-corneal-opacity-stats")
    @ResponseBody
    public ResponseEntity<List<CornealOpacityStats>> getLeftCornealOpacityStats(){

        return  ResponseEntity.ok(patientService.getLeftCornealOpacityStats());
    }

    @GetMapping("/get-right-corneal-opacity-stats")
    @ResponseBody
    public ResponseEntity<List<CornealOpacityStats>> getRightCornealOpacityStats(){

        return  ResponseEntity.ok(patientService.getRightCornealOpacityStats());
    }

    @GetMapping("/get-left-retinal-condition-stats")
    @ResponseBody
    public ResponseEntity<RetinalConditionStats> getLeftRetinalConditionStats(){

        return  ResponseEntity.ok(patientService.getLeftRetinalConditionStats());
    }

    @GetMapping("/get-right-retinal-condition-stats")
    @ResponseBody
    public ResponseEntity<RetinalConditionStats> getRightRetinalConditionStats(){

        return  ResponseEntity.ok(patientService.getRightRetinalConditionStats());
    }

}
