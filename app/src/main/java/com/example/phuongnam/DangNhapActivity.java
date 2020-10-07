package com.example.phuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DangNhapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
    }

    public void btnDangNhap(View view) {
        Intent intent = new Intent(DangNhapActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void btnHuy(View view) {
        Intent intent1 = new Intent(DangNhapActivity.this, ManHinhChaoAc.class);
        startActivity(intent1);
    }
}