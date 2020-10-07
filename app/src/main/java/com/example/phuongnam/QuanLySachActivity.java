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

import com.example.phuongnam.Adapter.QuanLySachAdapter;
import com.example.phuongnam.Adapter.XemChiTietSachAdapter;
import com.example.phuongnam.DAO.SachDAO;
import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class QuanLySachActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;
    MySQLite mySQLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sach);
        listView = findViewById(R.id.lvListQLS);
        toolbar = findViewById(R.id.toolbarQLSach);
        mySQLite = new MySQLite(this);
        setSupportActionBar(toolbar);

        SachDAO sachDAO = new SachDAO(mySQLite);
        List<Sach> sachList = sachDAO.getAllSach();
        QuanLySachAdapter quanLySachAdapter = new QuanLySachAdapter(sachList);
        listView.setAdapter(quanLySachAdapter);

        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuqls, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itQLS){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_them_sach, null);
            builder.setView(view);

            final EditText edMaSach = view.findViewById(R.id.edMaSachSach);
            final EditText edMaTheLoai = view.findViewById(R.id.spiner);
            final EditText edTenSach = view.findViewById(R.id.edTenSachSach);
            final EditText edTacGia = view.findViewById(R.id.edTacGiaSach);
            final EditText edNXB = view.findViewById(R.id.edNXBSach);
            final EditText edGiaBan = view.findViewById(R.id.edGiaBanSach);
            final EditText edSoLuong = view.findViewById(R.id.edSoLuongSach);
            Button btnThem = view.findViewById(R.id.btnThemSach);
            Button btnHuy = view.findViewById(R.id.btnHuySach);

            final AlertDialog alertDialog = builder.show();

            btnHuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            btnThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sach sach = new Sach();
                    sach.maSach = edMaSach.getText().toString().trim();
                    sach.maTheLoai = edMaTheLoai.getText().toString().trim();
                    sach.tenSach = edTenSach.getText().toString().trim();
                    sach.tacGia = edTacGia.getText().toString().trim();
                    sach.NXB = edNXB.getText().toString().trim();
                    sach.giaBan = Double.parseDouble(edGiaBan.getText().toString().trim());
                    sach.soLuong = Integer.parseInt(edSoLuong.getText().toString().trim());

                    checkEmpty(sach.maSach, edMaSach);
                    checkEmpty(sach.maTheLoai, edMaTheLoai);
                    checkEmpty(sach.tenSach, edTenSach);
                    checkEmpty(sach.tacGia, edTacGia);
                    checkEmpty(sach.NXB, edNXB);
                    checkEmpty(sach.giaBan + " ", edGiaBan);
                    checkEmpty(sach.soLuong+" ", edSoLuong);

                    SachDAO sachDAO = new SachDAO(mySQLite);

                    boolean kq = sachDAO.insertSach(sach);

                    if (kq){
                        Toast.makeText(QuanLySachActivity.this, "Them thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        List<Sach> sachList = sachDAO.getAllSach();
                        QuanLySachAdapter quanLySachAdapter = new QuanLySachAdapter(sachList);
                        listView.setAdapter(quanLySachAdapter);
                    }else {
                        Toast.makeText(QuanLySachActivity.this, "Them khong thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu3, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.itXem){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_xem_chi_tiet_sach, null);
            builder.setView(view);

            ListView listView = view.findViewById(R.id.lvListXCTSACH);

            SachDAO sachDAO = new SachDAO(mySQLite);
            List<Sach> sachList = sachDAO.getAllSach();
            XemChiTietSachAdapter xemChiTietSachAdapter = new XemChiTietSachAdapter(sachList);
            listView.setAdapter(xemChiTietSachAdapter);

            AlertDialog alertDialog = builder.show();
        }else if (id == R.id.itSua){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_sua_sach, null);
            builder.setView(view);

            final EditText edMaSach = view.findViewById(R.id.edMaSachSuaSach);

            final EditText edTenSach = view.findViewById(R.id.edTenSachSuaSach);
            final EditText edTacGia = view.findViewById(R.id.edTacGiaSuaSach);
            final EditText edNXB = view.findViewById(R.id.edNXBSuaSach);
            final EditText edGiaBan = view.findViewById(R.id.edGiaBanSuaSach);
            final EditText edSoLuong = view.findViewById(R.id.edSoLuongSuaSach);
            Button btnSua = view.findViewById(R.id.btnSuaSach);
            Button btnHuy = view.findViewById(R.id.btnHuySuaSach);

            final AlertDialog alertDialog = builder.show();

            btnHuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            btnSua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sach sach = new Sach();
                    sach.maSach = edMaSach.getText().toString().trim();

                    sach.tenSach = edTenSach.getText().toString().trim();
                    sach.tacGia = edTacGia.getText().toString().trim();
                    sach.NXB = edNXB.getText().toString().trim();
                    sach.giaBan = Double.parseDouble(edGiaBan.getText().toString().trim());
                    sach.soLuong = Integer.parseInt(edSoLuong.getText().toString().trim());

                    checkEmpty(sach.maSach, edMaSach);

                    checkEmpty(sach.tenSach, edTenSach);
                    checkEmpty(sach.tacGia, edTacGia);
                    checkEmpty(sach.NXB, edNXB);
                    checkEmpty(sach.giaBan + " ", edGiaBan);
                    checkEmpty(sach.soLuong+" ", edSoLuong);

                    SachDAO sachDAO = new SachDAO(mySQLite);

                    boolean kq = sachDAO.updateSach(sach);

                    if (kq){
                        Toast.makeText(QuanLySachActivity.this, "Them thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        List<Sach> sachList = sachDAO.getAllSach();
                        QuanLySachAdapter quanLySachAdapter = new QuanLySachAdapter(sachList);
                        listView.setAdapter(quanLySachAdapter);
                    }else {
                        Toast.makeText(QuanLySachActivity.this, "Them khong thanh cong", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                }
            });

        }else if (id == R.id.itXoa){
            AlertDialog.Builder builder = new AlertDialog.Builder(QuanLySachActivity.this);
            builder.setMessage("Ban chac chan muon xoa");
            builder.setTitle("Xoa");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuanLySachActivity.this, "Xoa thanh con", Toast.LENGTH_LONG).show();
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

    public void checkEmpty(String data, EditText editText){
        if (data.isEmpty()){
            editText.setError("Chua nhap du thong tin");
            return;
        }
    }
}