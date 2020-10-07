package com.example.phuongnam.model;

public class Sach {
    public String tenSach;
    public String maSach;
    public String maTheLoai;
    public String tacGia;
    public String NXB;
    public Double giaBan;
    public Integer soLuong;

    public Sach() {
    }

    public Sach(String tenSach, String maSach, String maTheLoai, String tacGia, String NXB, Double giaBan, Integer soLuong) {
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.maTheLoai = maTheLoai;
        this.tacGia = tacGia;
        this.NXB = NXB;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }
}
