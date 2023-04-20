package com.makiia.crosscutting.domain.model;
import lombok.*;
import java.util.Date;

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
    private Date    recFecagiRemc;
    private Date    recFecagfRemc;
    private String  recDiapunRemc;
    private String  recKeyfilRemc;
    private String  recKeytmpRemc;
    private String  recKeytm1Remc;
    private String  recKeytm2Remc;
    private String  recKeytm3Remc;
    private String  recKeytm4Remc;
    //private String  recErrauxRemc;
    private Integer  recEstregRemc;
}
