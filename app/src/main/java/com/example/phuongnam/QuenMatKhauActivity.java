package com.example.phuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuenMatKhauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);
    }

    public void btnDoiMK(View view) {
        Intent i = new Intent(QuenMatKhauActivity.this, DangNhapActivity.class);
        startActivity(i);
    }

    public void btnHuyQMK(View view) {
        Intent i1 = new Intent(QuenMatKhauActivity.this, DangNhapActivity.class);
        startActivity(i1);
    }
}