package com.ocugene.entity.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.ClinicalExam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddClinicalExamRequest {

    @JsonProperty("right_bcva")
    private String rightBCVA;

    @JsonProperty("left_bcva")
    private String leftBCVA;

    @JsonProperty("right_retina")
    private String rightRetina;

    @JsonProperty("left_retina")
    private String leftRetina;

    @JsonProperty("right_cornea")
    private String rightCornea;

    @JsonProperty("left_cornea")
    private String leftCornea;

    public ClinicalExam mapToClinicalExam() {
        ClinicalExam clinicalExam  = new ClinicalExam();

        clinicalExam.setLeftCornea(this.leftCornea);
        clinicalExam.setRightCornea(this.rightCornea);
        clinicalExam.setLeftBCVA(this.leftBCVA);
        clinicalExam.setRightBCVA(this.rightBCVA);
        clinicalExam.setLeftRetina(this.leftRetina);
        clinicalExam.setRightRetina(this.rightRetina);

        return clinicalExam;
    }
}
