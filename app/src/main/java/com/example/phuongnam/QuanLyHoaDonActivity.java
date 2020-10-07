package com.example.phuongnam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phuongnam.Adapter.HoaDonAdapter;
import com.example.phuongnam.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class QuanLyHoaDonActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;
    List<HoaDon> hoaDonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_hoa_don);

        listView = findViewById(R.id.lvListHD);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        hoaDonList = new ArrayList<>();
        for (int i = 0 ; i<20;i++){
            HoaDon hoaDon = new HoaDon();
            hoaDon.maHoaDon = "1";
            hoaDon.ngayMua = "11-12-2001";
            hoaDonList.add(hoaDon);
        }
        HoaDonAdapter hoaDonAdapter = new HoaDonAdapter(hoaDonList);
        listView.setAdapter(hoaDonAdapter);
        registerForContextMenu(listView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuhd, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itThemHD){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu2, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.itXem){

        }else if (id == R.id.itSua){

        }else if (id == R.id.itXoa){
            AlertDialog.Builder builder = new AlertDialog.Builder(QuanLyHoaDonActivity.this);
            builder.setMessage("Ban chac chan muon xoa");
            builder.setTitle("Xoa");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuanLyHoaDonActivity.this, "Xoa thanh con", Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Huy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return super.onContextItemSelected(item);
    }
}