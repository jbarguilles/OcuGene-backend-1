package com.ocugene.repository;

import com.ocugene.entity.Patient;
import com.ocugene.entity.projection.PatientProjection;
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

    @Query(value = "select p.patient_code, p.birthday, p.age, p.sex, p.marital_status, p.region, p.province, " +
            "p.city, p.barangay, p. chief_complaint, p.laterality, p.blur_duration, p.family_member, p.sibling_count, p.erg_date, " +
            "p.erg_result, p.diagnosis, p.variant, p.gen_test_date, p.right_bcva, p.left_bcva, p.right_retina, p.left_retina, " +
            "p.right_cornea, p.left_cornea from registrydatabase.patient p", nativeQuery = true)
    List<PatientProjection> findAllProjectedBy();








}
