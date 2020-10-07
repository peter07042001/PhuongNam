package com.example.phuongnam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.phuongnam.Adapter.NguoiDungAdapter;
import com.example.phuongnam.Adapter.XemChiTietNguoiDungAdapter;
import com.example.phuongnam.DAO.NguoiDungDAO;
import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class QuanLyNguoiDungActivity extends AppCompatActivity {

    MySQLite mySQLite;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nguoi_dung);
        listView = findViewById(R.id.lvList);

        mySQLite = new MySQLite(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(mySQLite);
        List<NguoiDung> nguoiDungList = nguoiDungDAO.getAllUser();
        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
        listView.setAdapter(nguoiDungAdapter);

        registerForContextMenu(listView);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itThem){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_them_nguoi_dung, null);
            builder.setView(view);

            final EditText edUserThemNguoiDung = view.findViewById(R.id.edUserThemNguoiDung);
            final EditText edPassThemNguoiDung = view.findViewById(R.id.edPassThemNguoiDung);
            EditText edPass2ThemNguoiDung = view.findViewById(R.id.edPass2ThemNguoiDung);
            final EditText edPhoneThemNguoiDung = view.findViewById(R.id.edPhoneThemNguoiDung);
            final EditText edNameThemNguoiDung = view.findViewById(R.id.edNameThemNguoiDung);
            Button btnThemNguoiDung = view.findViewById(R.id.btnThemNguoiDung);
            Button btnHuyNguoiDung = view.findViewById(R.id.btnHuyNguoiDung);

            final AlertDialog alertDialog = builder.show();

            btnHuyNguoiDung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            btnThemNguoiDung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NguoiDung nguoiDung = new NguoiDung();
                    nguoiDung.userName = edUserThemNguoiDung.getText().toString().trim();
                    nguoiDung.passWord = edPassThemNguoiDung.getText().toString().trim();
                    nguoiDung.sdt = edPhoneThemNguoiDung.getText().toString().trim();
                    nguoiDung.hoTen = edNameThemNguoiDung.getText().toString().trim();

                    checkEmty(nguoiDung.userName, edUserThemNguoiDung);
                    checkEmty(nguoiDung.passWord, edPassThemNguoiDung);
                    checkEmty(nguoiDung.sdt, edPhoneThemNguoiDung);
                    checkEmty(nguoiDung.hoTen, edNameThemNguoiDung);

                    NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(mySQLite);

                    boolean kq = nguoiDungDAO.insertUser(nguoiDung);
                    if (kq){
                        Toast.makeText(QuanLyNguoiDungActivity.this, "Them thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        List<NguoiDung> nguoiDungList = nguoiDungDAO.getAllUser();
                        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
                        listView.setAdapter(nguoiDungAdapter);
                    }else {
                        Toast.makeText(QuanLyNguoiDungActivity.this, "Them khong thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                }
            });

        }else if (id == R.id.itDMK){
            Intent intent = new Intent(QuanLyNguoiDungActivity.this, QuenMatKhauActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(QuanLyNguoiDungActivity.this, DangNhapActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.itXem){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_xem_chi_tiet_nguoi_dung, null);
            builder.setView(view);
            final ListView listView = view.findViewById(R.id.lvXCTNG);
            NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(mySQLite);

            List<NguoiDung> nguoiDungList = nguoiDungDAO.getAllUser();
            XemChiTietNguoiDungAdapter xemChiTietNguoiDungAdapter = new XemChiTietNguoiDungAdapter(nguoiDungList);
            listView.setAdapter(xemChiTietNguoiDungAdapter);

            final AlertDialog alertDialog = builder.show();

        }else if (id == R.id.itSua){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_sua_nguoi_dung_adapter, null);
            builder.setView(view);

            final EditText edUserSuaNguoiDung = view.findViewById(R.id.edUserSuaNguoiDung);
            final EditText edPassSuaNguoiDung = view.findViewById(R.id.edPassSuaNguoiDung);
            final EditText edPhoneSuaNguoiDung = view.findViewById(R.id.edPhoneSuaNguoiDung);
            final EditText edNameSuaNguoiDung = view.findViewById(R.id.edNameSuaNguoiDung);
            Button btnSuaSuaNguoiDung = view.findViewById(R.id.btnSuaSuaNguoiDung);
            Button btnHuySuaNguoiDung = view.findViewById(R.id.btnHuySuaNguoiDung);

            final AlertDialog alertDialog = builder.show();

            btnHuySuaNguoiDung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            btnSuaSuaNguoiDung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NguoiDung nguoiDung = new NguoiDung();
                    nguoiDung.userName = edUserSuaNguoiDung.getText().toString().trim();
                    nguoiDung.passWord = edPassSuaNguoiDung.getText().toString().trim();
                    nguoiDung.sdt = edPhoneSuaNguoiDung.getText().toString().trim();
                    nguoiDung.hoTen = edNameSuaNguoiDung.getText().toString().trim();

                    checkEmty(nguoiDung.userName, edUserSuaNguoiDung);
                    checkEmty(nguoiDung.passWord, edPassSuaNguoiDung);
                    checkEmty(nguoiDung.sdt, edPhoneSuaNguoiDung);
                    checkEmty(nguoiDung.hoTen, edNameSuaNguoiDung);

                    NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(mySQLite);

                    boolean kq = nguoiDungDAO.updateUser(nguoiDung);
                    if (kq){
                        Toast.makeText(QuanLyNguoiDungActivity.this, "Sua thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        List<NguoiDung> nguoiDungList = nguoiDungDAO.getAllUser();
                        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
                        listView.setAdapter(nguoiDungAdapter);
                    }else {
                        Toast.makeText(QuanLyNguoiDungActivity.this, "Sua khong thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                }
            });
        }else if (id == R.id.itXoa){
            AlertDialog.Builder builder = new AlertDialog.Builder(QuanLyNguoiDungActivity.this);
            builder.setMessage("Ban chac chan muon xoa");
            builder.setTitle("Xoa");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(QuanLyNguoiDungActivity.this, "Xoa thanh cong", Toast.LENGTH_LONG).show();

                }
            });
            builder.setNegativeButton("Huy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuanLyNguoiDungActivity.this, "Xoa khong thanh cong", Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return super.onContextItemSelected(item);
    }

    public void checkEmty(String data, EditText editText){
        if (data.isEmpty()){
            editText.setError("Ban chua nhap du thong tin!");
            return;
        }
    }
}