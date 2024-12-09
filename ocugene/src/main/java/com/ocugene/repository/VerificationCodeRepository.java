package com.ocugene.repository;

import com.ocugene.entity.nonFormEntities.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Integer> {
}
