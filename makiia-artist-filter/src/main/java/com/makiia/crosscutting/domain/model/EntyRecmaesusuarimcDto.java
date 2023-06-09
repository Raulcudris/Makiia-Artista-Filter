package com.makiia.crosscutting.domain.model;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EntyRecmaesusuarimcDto {

    private Integer recUnikeyRemc;
    private String  recNroregRemc;
    private String  recNroregReus;
    private String  recNtokenReus;
    private String  recTipfilRemc;
    private String  recModuloRemc;
    private String  sisCodpaiSipa;
    private String  sisIdedptSidp;
    private String  sisCodproSipr;
    private Integer recGeodisRemc;
    private Double  recGeolatReus;
    private Double  recGeolonReus;
    private String  recGenmusReus;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date recFecagiRemc;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date   recFecagfRemc;
    private String  recDiapunRemc;
    private String  recKeyfilRemc;
    private String  recKeytmpRemc;
    private String  recKeytm1Remc;
    private String  recKeytm2Remc;
    private String  recKeytm3Remc;
    private String  recKeytm4Remc;
    private Integer recEstregRemc;
}
