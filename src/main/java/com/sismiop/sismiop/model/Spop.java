package com.sismiop.sismiop.model;

import javax.persistence.*;

@Entity
@Table(name = "spop")
public class Spop {
    public Spop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jenisTransaksi;
    private Integer nop;
    private Integer nopBersama;
    private Integer nopAsal;
    private Integer nopSPPTLama;
    private String namaJalanOP;
    private String blokOP;
    private String kelurahaOP;
    private String rtop;
    private String rwop;
    private String pekerjaanSP;
    private String statusSP;
    private String namaSP;
    private Integer npwp;
    private String namaJalanSP;
    private String blokSP;
    private String kelurahanSP;
    private String rtsp;
    private String rwsp;
    private String luasTanah;
    private String zonaNilaiTanah;
    private String jenisTanah;
    private String jenisBangunan;
    private String luasBangunan;



    @OneToOne
    @JoinColumn(name = "permohonan_op_id")
    private PermohonanOp permohonanOp = null;

    public Long getId() {
        return id;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public Integer getNop() {
        return nop;
    }

    public void setNop(Integer nop) {
        this.nop = nop;
    }

    public Integer getNopBersama() {
        return nopBersama;
    }

    public void setNopBersama(Integer nopBersama) {
        this.nopBersama = nopBersama;
    }

    public Integer getNopAsal() {
        return nopAsal;
    }

    public void setNopAsal(Integer nopAsal) {
        this.nopAsal = nopAsal;
    }

    public Integer getNopSPPTLama() {
        return nopSPPTLama;
    }

    public void setNopSPPTLama(Integer nopSPPTLama) {
        this.nopSPPTLama = nopSPPTLama;
    }

    public String getNamaJalanOP() {
        return namaJalanOP;
    }

    public void setNamaJalanOP(String namaJalanOP) {
        this.namaJalanOP = namaJalanOP;
    }

    public String getBlokOP() {
        return blokOP;
    }

    public void setBlokOP(String blokOP) {
        this.blokOP = blokOP;
    }

    public String getKelurahaOP() {
        return kelurahaOP;
    }

    public void setKelurahaOP(String kelurahaOP) {
        this.kelurahaOP = kelurahaOP;
    }

    public String getRtop() {
        return rtop;
    }

    public void setRtop(String rtop) {
        this.rtop = rtop;
    }

    public String getRwop() {
        return rwop;
    }

    public void setRwop(String rwop) {
        this.rwop = rwop;
    }

    public String getPekerjaanSP() {
        return pekerjaanSP;
    }

    public void setPekerjaanSP(String pekerjaanSP) {
        this.pekerjaanSP = pekerjaanSP;
    }

    public String getStatusSP() {
        return statusSP;
    }

    public void setStatusSP(String statusSP) {
        this.statusSP = statusSP;
    }

    public String getNamaSP() {
        return namaSP;
    }

    public void setNamaSP(String namaSP) {
        this.namaSP = namaSP;
    }

    public Integer getNpwp() {
        return npwp;
    }

    public void setNpwp(Integer npwp) {
        this.npwp = npwp;
    }

    public String getNamaJalanSP() {
        return namaJalanSP;
    }

    public void setNamaJalanSP(String namaJalanSP) {
        this.namaJalanSP = namaJalanSP;
    }

    public String getBlokSP() {
        return blokSP;
    }

    public void setBlokSP(String blokSP) {
        this.blokSP = blokSP;
    }

    public String getKelurahanSP() {
        return kelurahanSP;
    }

    public void setKelurahanSP(String kelurahanSP) {
        this.kelurahanSP = kelurahanSP;
    }

    public String getRtsp() {
        return rtsp;
    }

    public void setRtsp(String rtsp) {
        this.rtsp = rtsp;
    }

    public String getRwsp() {
        return rwsp;
    }

    public void setRwsp(String rwsp) {
        this.rwsp = rwsp;
    }

    public String getLuasTanah() {
        return luasTanah;
    }

    public void setLuasTanah(String luasTanah) {
        this.luasTanah = luasTanah;
    }

    public String getZonaNilaiTanah() {
        return zonaNilaiTanah;
    }

    public void setZonaNilaiTanah(String zonaNilaiTanah) {
        this.zonaNilaiTanah = zonaNilaiTanah;
    }

    public String getJenisTanah() {
        return jenisTanah;
    }

    public void setJenisTanah(String jenisTanah) {
        this.jenisTanah = jenisTanah;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public PermohonanOp getPermohonanOp() {
        return permohonanOp;
    }

    public void setPermohonanOp(PermohonanOp permohonanOp) {
        this.permohonanOp = permohonanOp;
    }
}
