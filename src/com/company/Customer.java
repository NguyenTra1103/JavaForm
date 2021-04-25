package com.company;

public class Customer {
    private String MaThe,BienSo,TenKH,CMND,ThoiGianVao,ThoiGianRa,ThoiGianDo, ChiPhi;
    private int  LoaiXe;
    public Customer(){

    }

    public Customer(String maThe, String bienSo, String tenKH, String CMND, String thoiGianVao, String thoiGianRa, String thoiGianDo, String chiPhi, int loaiXe) {
        MaThe = maThe;
        BienSo = bienSo;
        TenKH = tenKH;
        this.CMND = CMND;
        ThoiGianVao = thoiGianVao;
        ThoiGianRa = thoiGianRa;
        ThoiGianDo = thoiGianDo;
        ChiPhi = chiPhi;
        LoaiXe = loaiXe;
    }

    public String getMaThe() {
        return MaThe;
    }

    public void setMaThe(String maThe) {
        MaThe = maThe;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String bienSo) {
        BienSo = bienSo;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getThoiGianVao() {
        return ThoiGianVao;
    }

    public void setThoiGianVao(String thoiGianVao) {
        ThoiGianVao = thoiGianVao;
    }

    public String getThoiGianRa() {
        return ThoiGianRa;
    }

    public void setThoiGianRa(String thoiGianRa) {
        ThoiGianRa = thoiGianRa;
    }

    public String getThoiGianDo() {
        return ThoiGianDo;
    }

    public void setThoiGianDo(String thoiGianDo) {
        ThoiGianDo = thoiGianDo;
    }

    public String getChiPhi() {
        return ChiPhi;
    }

    public void setChiPhi(String chiPhi) {
        ChiPhi = chiPhi;
    }

    public int getLoaiXe() {
        return LoaiXe;
    }

    public void setLoaiXe(int loaiXe) {
        LoaiXe = loaiXe;
    }
}
