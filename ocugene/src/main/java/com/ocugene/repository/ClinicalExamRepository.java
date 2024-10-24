package com.ocugene.repository;

import com.ocugene.entity.ClinicalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalExamRepository extends JpaRepository<ClinicalExam, Integer> {
}
