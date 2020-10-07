package com.example.phuongnam.model;

public class HoaDonChiTiet {
    public String maHDCT;
    public String maHoaDon;
    public String maSach;
    public int soLuongMua;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHDCT, String maHoaDon, String maSach, int soLuongMua) {
        this.maHDCT = maHDCT;
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuongMua = soLuongMua;
    }
}
