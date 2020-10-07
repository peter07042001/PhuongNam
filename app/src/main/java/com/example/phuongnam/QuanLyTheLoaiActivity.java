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

import com.example.phuongnam.Adapter.TheLoaiAdapter;
import com.example.phuongnam.Adapter.XemChiTIetTheLoaiAdapter;
import com.example.phuongnam.DAO.TheLoaiDAO;
import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTheLoaiActivity extends AppCompatActivity {

    MySQLite mySQLite;
    ListView listView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_the_loai);

        listView = findViewById(R.id.lvListTL);
        toolbar = findViewById(R.id.toolbarTheLoai);
        mySQLite = new MySQLite(this);
        setSupportActionBar(toolbar);

        TheLoaiDAO theLoaiDAO = new TheLoaiDAO(mySQLite);
        List<TheLoai> theLoaiList = theLoaiDAO.getAllTheLoai();
        TheLoaiAdapter theLoaiAdapter = new TheLoaiAdapter(theLoaiList);
        listView.setAdapter(theLoaiAdapter);

        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutl, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itThemTL){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_them_the_loai, null);
            builder.setView(view);

            final EditText edMaTheLoai = view.findViewById(R.id.edMaTheLoaiTL);
            final EditText edTenTheLoai = view.findViewById(R.id.edTenTheLoaiTl);
            final EditText edViTri = view.findViewById(R.id.edViTriTL);
            final EditText edMoTa = view.findViewById(R.id.edMoTaTL);

            Button them = view.findViewById(R.id.btnThemTL);
            Button huy = view.findViewById(R.id.btnHuyTL);

            final AlertDialog alertDialog = builder.show();

            huy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });


            them.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TheLoai theLoai = new TheLoai();
                    theLoai.maTheLoai = edMaTheLoai.getText().toString().trim();
                    theLoai.tenTheLoai = edTenTheLoai.getText().toString().trim();
                    theLoai.viTri = Integer.parseInt(edViTri.getText().toString().trim());
                    theLoai.moTa = edMoTa.getText().toString().trim();

                    check(theLoai.maTheLoai, edMaTheLoai);
                    check(theLoai.tenTheLoai, edTenTheLoai);
                    check(theLoai.viTri + "", edViTri);
                    check(theLoai.moTa, edMoTa);

                    TheLoaiDAO theLoaiDAO = new TheLoaiDAO(mySQLite);

                    boolean kq = theLoaiDAO.insertTheLoai(theLoai);

                    if (kq){
                        Toast.makeText(QuanLyTheLoaiActivity.this, "Them thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        List<TheLoai> theLoaiList = theLoaiDAO.getAllTheLoai();
                        TheLoaiAdapter theLoaiAdapter = new TheLoaiAdapter(theLoaiList);
                        listView.setAdapter(theLoaiAdapter);
                    }else {
                        Toast.makeText(QuanLyTheLoaiActivity.this, "Them khong thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu4, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.itXem){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_xem_chi_tiet_the_loai, null);
            builder.setView(view);

            ListView listView = view.findViewById(R.id.lvXCTTL);

            TheLoaiDAO theLoaiDAO = new TheLoaiDAO(mySQLite);
            List<TheLoai> theLoaiList = theLoaiDAO.getAllTheLoai();
            XemChiTIetTheLoaiAdapter xemChiTIetTheLoaiAdapter = new XemChiTIetTheLoaiAdapter(theLoaiList);
            listView.setAdapter(xemChiTIetTheLoaiAdapter);

            AlertDialog alertDialog = builder.show();
        }else if (id == R.id.itSua){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_sua_the_loai, null);
            builder.setView(view);

            final EditText edMaTheLoai = view.findViewById(R.id.edSuaMaTheLoai);
            final EditText edTenTheLoai = view.findViewById(R.id.edSuaTenTheLoai);
            final EditText edViTri = view.findViewById(R.id.edSuaViTri);
            final EditText edMoTa = view.findViewById(R.id.edSuaMoTa);

            Button sua = view.findViewById(R.id.btnSuaTheLoai);
            Button huy = view.findViewById(R.id.btnHuySuaTheLoai);

            final AlertDialog alertDialog = builder.show();

            huy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });


            sua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TheLoai theLoai = new TheLoai();
                    theLoai.maTheLoai = edMaTheLoai.getText().toString().trim();
                    theLoai.tenTheLoai = edTenTheLoai.getText().toString().trim();
                    theLoai.viTri = Integer.parseInt(edViTri.getText().toString().trim());
                    theLoai.moTa = edMoTa.getText().toString().trim();

                    check(theLoai.maTheLoai, edMaTheLoai);
                    check(theLoai.tenTheLoai, edTenTheLoai);
                    check(theLoai.viTri + "", edViTri);
                    check(theLoai.moTa, edMoTa);

                    TheLoaiDAO theLoaiDAO = new TheLoaiDAO(mySQLite);

                    boolean kq = theLoaiDAO.updateTheLoai(theLoai);

                    if (kq){
                        Toast.makeText(QuanLyTheLoaiActivity.this, "Sua thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        List<TheLoai> theLoaiList = theLoaiDAO.getAllTheLoai();
                        TheLoaiAdapter theLoaiAdapter = new TheLoaiAdapter(theLoaiList);
                        listView.setAdapter(theLoaiAdapter);
                    }else {
                        Toast.makeText(QuanLyTheLoaiActivity.this, "Sua khong thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                }
            });


        }else if (id == R.id.itXoa){
            AlertDialog.Builder builder = new AlertDialog.Builder(QuanLyTheLoaiActivity.this);
            builder.setMessage("Ban chac chan muon xoa");
            builder.setTitle("Xoa");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuanLyTheLoaiActivity.this, "Xoa thanh con", Toast.LENGTH_LONG).show();
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

    public void check(String data, EditText editText){
        if (data.isEmpty()){
            editText.setError("Ban chua nhap du thong tin");
        }
    }
}