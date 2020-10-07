package com.example.phuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ManHinhChaoAc extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chao);

        imageView = findViewById(R.id.imgLogo);
    }

    public void logo(View view) {
        Intent intent = new Intent(ManHinhChaoAc.this, DangNhapActivity.class);
        startActivity(intent);
    }
}