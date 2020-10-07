package com.example.phuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.phuongnam.Adapter.SachBanChayAdapter;
import com.example.phuongnam.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SacBanChayActivity extends AppCompatActivity {

    List<Sach> sachList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sac_ban_chay);

        listView = findViewById(R.id.lvListSBC);
        sachList = new ArrayList<>();

        for (int i = 0 ; i < 11 ; i++){
            Sach sach = new Sach();
            sach.maSach = "1";
            sach.soLuong = 10;
            sachList.add(sach);
        }
        SachBanChayAdapter sachBanChayAdapter = new SachBanChayAdapter(sachList);
        listView.setAdapter(sachBanChayAdapter);
    }
}