package com.ocugene.repository;

import com.ocugene.entity.Patient;
import com.ocugene.entity.projection.RegionCount;
import com.ocugene.entity.projection.VariantCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByPatientCode(String patientCode);

    Patient findTopByOrderByPatientIDDesc();

    @Query(value = "SELECT \n" +
            "    p.diagnosis AS name, \n" +
            "    p.variant, \n" +
            "    COUNT(p), \n" +
            "    mode() WITHIN GROUP (ORDER BY p.blur_duration) AS duration,\n" +
            "    ROUND(AVG(p.age), 2) AS age\n" +
            "FROM \n" +
            "    registrydatabase.patient p\n" +
            "GROUP BY \n" +
            "    p.diagnosis, \n" +
            "    p.variant\n" +
            "ORDER BY \n" +
            "    p.diagnosis ASC;\n", nativeQuery = true)
    List<VariantCount> countPatientsPerVariant();

    @Query(value = "select p.diagnosis as name, p.region, count(DISTINCT p) from registrydatabase.patient p group by p.diagnosis, p.region order by p.diagnosis asc", nativeQuery = true)
    List<RegionCount> countPatientsPerRegion();










}
