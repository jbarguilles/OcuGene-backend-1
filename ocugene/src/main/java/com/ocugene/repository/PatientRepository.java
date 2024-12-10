package com.ocugene.repository;

import com.ocugene.entity.Patient;
import com.ocugene.entity.projection.*;
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
            "    public.patient p\n" +
            "GROUP BY \n" +
            "    p.diagnosis, \n" +
            "    p.variant\n" +
            "ORDER BY \n" +
            "    p.diagnosis ASC;\n", nativeQuery = true)
    List<VariantCount> countPatientsPerVariant();

    @Query(value = "select p.diagnosis as name, p.region, count(DISTINCT p) from public.patient p group by p.diagnosis, p.region order by p.diagnosis asc", nativeQuery = true)
    List<RegionCount> countPatientsPerRegion();

    @Query(value = "select p.patient_code, p.birthday, p.age, p.sex, p.marital_status, p.region, p.province, " +
            "p.city, p.barangay, p. chief_complaint, p.laterality, p.blur_duration, p.family_member, p.sibling_count, p.erg_date, " +
            "p.erg_result, p.diagnosis, p.variant, p.gen_test_date, p.right_bcva, p.left_bcva, p.right_retina, p.left_retina, " +
            "p.right_cornea, p.left_cornea from public.patient p", nativeQuery = true)
    List<PatientProjection> findAllProjectedBy();

    @Query(value = """
    SELECT
       diagnosis,
       variant,
       COALESCE(SUM(CASE WHEN left_bcva = '20/20' THEN 1 ELSE 0 END), 0) AS "count2020",
       COALESCE(SUM(CASE WHEN left_bcva = '20/40' THEN 1 ELSE 0 END), 0) AS "count2040",
       COALESCE(SUM(CASE WHEN left_bcva = '20/60' THEN 1 ELSE 0 END), 0) AS "count2060",
       COALESCE(SUM(CASE WHEN left_bcva = '20/80' THEN 1 ELSE 0 END), 0) AS "count2080",
       COALESCE(SUM(CASE WHEN left_bcva = '20/100' THEN 1 ELSE 0 END), 0) AS "count20100"
    FROM public.patient
    GROUP BY diagnosis, variant
    """, nativeQuery = true)
    List<BcvaStats> getLeftBcvaStats();

    @Query(value = """
    SELECT
       diagnosis,
       variant,
       COALESCE(SUM(CASE WHEN right_bcva = '20/20' THEN 1 ELSE 0 END), 0) AS "count2020",
       COALESCE(SUM(CASE WHEN right_bcva = '20/40' THEN 1 ELSE 0 END), 0) AS "count2040",
       COALESCE(SUM(CASE WHEN right_bcva = '20/60' THEN 1 ELSE 0 END), 0) AS "count2060",
       COALESCE(SUM(CASE WHEN right_bcva = '20/80' THEN 1 ELSE 0 END), 0) AS "count2080",
       COALESCE(SUM(CASE WHEN right_bcva = '20/100' THEN 1 ELSE 0 END), 0) AS "count20100"
    FROM public.patient
    GROUP BY diagnosis, variant
    """, nativeQuery = true)
    List<BcvaStats> getRightBcvaStats();


    @Query(value = """
        SELECT\s
            COALESCE(SUM(CASE WHEN left_cornea = 'Normal' THEN 1 ELSE 0 END), 0) AS normalCount,
            COALESCE(SUM(CASE WHEN left_cornea = 'Abnormal' THEN 1 ELSE 0 END), 0) AS abnormalCount
        FROM public.patient
    """, nativeQuery = true)
    CornealOpacityStats getLeftCornealOpacityStats();

    @Query(value = """
        SELECT\s
            COALESCE(SUM(CASE WHEN right_cornea = 'Normal' THEN 1 ELSE 0 END), 0) AS normalCount,
            COALESCE(SUM(CASE WHEN right_cornea = 'Abnormal' THEN 1 ELSE 0 END), 0) AS abnormalCount
        FROM public.patient
    """, nativeQuery = true)
    CornealOpacityStats getRightCornealOpacityStats();

    @Query(value = """
        SELECT\s
            COALESCE(SUM(CASE WHEN left_retina = 'Normal' THEN 1 ELSE 0 END), 0) AS normalCount,
            COALESCE(SUM(CASE WHEN left_retina = 'Abnormal' THEN 1 ELSE 0 END), 0) AS abnormalCount
        FROM public.patient
    """, nativeQuery = true)
    RetinalConditionStats getLeftRetinalConditionStats();

    @Query(value = """
        SELECT\s
            COALESCE(SUM(CASE WHEN right_retina = 'Normal' THEN 1 ELSE 0 END), 0) AS normalCount,
            COALESCE(SUM(CASE WHEN right_retina = 'Abnormal' THEN 1 ELSE 0 END), 0) AS abnormalCount
        FROM public.patient
    """, nativeQuery = true)
    RetinalConditionStats getRightRetinalConditionStats();
}
