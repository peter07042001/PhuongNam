package com.example.phuongnam.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class HDCTDAO {

    private MySQLite mySQLite;

    public HDCTDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public long insertHDCT(HoaDonChiTiet hoaDonChiTiet){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHDCT", hoaDonChiTiet.maHDCT);
        contentValues.put("MaHoaDon", hoaDonChiTiet.maHoaDon);
        contentValues.put("MaSach", hoaDonChiTiet.maSach);
        contentValues.put("SoLuongMua", hoaDonChiTiet.soLuongMua);

        return sqLiteDatabase.insert("HDCT", null, contentValues);
    }

    public long updateHDCT(HoaDonChiTiet hoaDonChiTiet){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHDCT", hoaDonChiTiet.maHDCT);
        contentValues.put("MaHoaDon", hoaDonChiTiet.maHoaDon);
        contentValues.put("MaSach", hoaDonChiTiet.maSach);
        contentValues.put("SoLuongMua", hoaDonChiTiet.soLuongMua);

        return sqLiteDatabase.update("HDCT", contentValues, "MaHDCT=?", new String[]{hoaDonChiTiet.maHDCT});
    }

    public int deleteHDCT(String maHDCT){
        return mySQLite.getWritableDatabase().delete("HDCT", "MaHDCT=?", new String[]{maHDCT});
    }

    public List<HoaDonChiTiet> getAllHDCT(){
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        String get_All = "SELECT * FROM HDCT";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(get_All, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.maHDCT = cursor.getString(cursor.getColumnIndex("MaHDCT"));
                hoaDonChiTiet.maHoaDon = cursor.getString(cursor.getColumnIndex("MaHoaDon"));
                hoaDonChiTiet.maSach = cursor.getString(cursor.getColumnIndex("MaSach"));
                hoaDonChiTiet.soLuongMua = cursor.getInt(cursor.getColumnIndex("SoLuongMua"));

                hoaDonChiTietList.add(hoaDonChiTiet);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoaDonChiTietList;
    }
}
