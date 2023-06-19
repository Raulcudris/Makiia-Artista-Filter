package com.makiia.crosscutting.persistence.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recmaesusuarimc")
public class EntyRecmaesusuarimc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rec_unikey_remc")
    private Integer  recUnikeyRemc;

    @Basic(optional = false)
    @Column(name = "rec_nroreg_remc")
    private String recNroregRemc;

    @Basic(optional = false)
    @Column(name = "rec_nroreg_reus")
    private String recNroregReus;

    @Basic(optional = false)
    @Column(name = "rec_ntoken_reus")
    private String recNtokenReus;

    @Basic(optional = false)
    @Column(name = "rec_tipfil_remc")
    private String recTipfilRemc;

    @Basic(optional = false)
    @Column(name = "rec_modulo_remc")
    private String  recModuloRemc;

    @Basic(optional = false)
    @Column(name = "sis_codpai_sipa")
    private String  sisCodpaiSipa;

    @Basic(optional = false)
    @Column(name = "sis_idedpt_sidp")
    private String  sisIdedptSidp;

    @Basic(optional = false)
    @Column(name = "sis_codpro_sipr")
    private String  sisCodproSipr;

    @Basic(optional = false)
    @Column(name = "rec_geodis_remc")
    private Integer  recGeodisRemc;

    @Basic(optional = false)
    @Column(name = "rec_geolat_reus")
    private Double  recGeolatReus;

    @Basic(optional = false)
    @Column(name = "rec_geolon_reus")
    private Double  recGeolonReus;

    @Basic(optional = false)
    @Column(name = "rec_genmus_reus")
    private String  recGenmusReus;

    @Basic(optional = false)
    @Column(name = "rec_fecagi_remc")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date recFecagiRemc;

    @Basic(optional = false)
    @Column(name = "rec_fecagf_remc")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date  recFecagfRemc;

    @Basic(optional = false)
    @Column(name = "rec_diapun_remc")
    private String  recDiapunRemc;

    @Basic(optional = false)
    @Column(name = "rec_keyfil_remc")
    private String  recKeyfilRemc;

    @Basic(optional = false)
    @Column(name = "rec_keytmp_remc")
    private String  recKeytmpRemc;

    @Basic(optional = false)
    @Column(name = "rec_keytm1_remc")
    private String  recKeytm1Remc;

    @Basic(optional = false)
    @Column(name = "rec_keytm2_remc")
    private String  recKeytm2Remc;

    @Basic(optional = false)
    @Column(name = "rec_keytm3_remc")
    private String  recKeytm3Remc;

    @Basic(optional = false)
    @Column(name = "rec_keytm4_remc")
    private String  recKeytm4Remc;

    @Basic(optional = false)
    @Column(name = "rec_estreg_remc")
    private Integer  recEstregRemc;


}
