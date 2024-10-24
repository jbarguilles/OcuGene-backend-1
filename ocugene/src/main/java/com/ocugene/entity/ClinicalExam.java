package com.ocugene.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clinicalexam", schema = "registrydatabase")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClinicalExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinical_exam_id")
    private Integer clinicalExamID;

    @Column(name = "right_bcva")
    String rightBCVA;

    @Column(name = "left_bcva")
    String leftBCVA;

    @Column(name = "right_retina")
    String rightRetina;

    @Column(name = "left_retina")
    String leftRetina;

    @Column(name = "right_cornea")
    String rightCornea;

    @Column(name = "left_cornea")
    String leftCornea;
}
