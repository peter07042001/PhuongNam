package com.example.phuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.phuongnam.model.NguoiDung;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void nguoidung(View view) {
        Intent intent = new Intent(HomeActivity.this, QuanLyNguoiDungActivity.class);
        startActivity(intent);
    }

    public void theloai(View view) {
        Intent intent = new Intent(HomeActivity.this, QuanLyTheLoaiActivity.class);
        startActivity(intent);
    }

    public void sach(View view) {
        Intent intent = new Intent(HomeActivity.this, QuanLySachActivity.class);
        startActivity(intent);
    }

    public void hoadon(View view) {
        Intent intent = new Intent(HomeActivity.this, QuanLyHoaDonActivity.class);
        startActivity(intent);
    }

    public void sachbanchay(View view) {
        Intent intent = new Intent(HomeActivity.this, SacBanChayActivity.class);
        startActivity(intent);
    }

    public void thongke(View view) {
        Intent intent = new Intent(HomeActivity.this, ThongKeActivity.class);
        startActivity(intent);
    }
}