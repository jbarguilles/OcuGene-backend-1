package com.ocugene.service;

import com.ocugene.entity.nonFormEntities.VerificationCode;
import org.springframework.stereotype.Service;

/**
 * Service for handling emails being sent.
 */
@Service
public interface EmailService {

    void sendVerificationEmail(VerificationCode verificationCode);
}
