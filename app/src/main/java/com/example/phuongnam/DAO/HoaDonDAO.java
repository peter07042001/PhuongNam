package com.example.phuongnam.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {

    private MySQLite mySQLite;

    public HoaDonDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public long insertHoaDon(HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHoaDon", hoaDon.maHoaDon);
        contentValues.put("NgayMua", hoaDon.ngayMua);
        return sqLiteDatabase.insert("HOADON", null, contentValues);
    }

    public long updateHoaDon(HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHoaDon", hoaDon.maHoaDon);
        contentValues.put("NgayMua", hoaDon.ngayMua);
        return sqLiteDatabase.update("HOADON", contentValues, "MaHoaDon=?" ,new String[]{hoaDon.maHoaDon});
    }
    public int deleteHoaDon(String MaHoaDon){
        return mySQLite.getWritableDatabase().delete("HOADON", "MaHoaDon=?", new String[]{MaHoaDon});
    }

    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> hoaDonList = new ArrayList<>();
        String get_all = "SELECT * FROM HOADON";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(get_all, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.maHoaDon = cursor.getString(cursor.getColumnIndex("MaHoaDon"));
                hoaDon.ngayMua = cursor.getString(cursor.getColumnIndex("NgayMua"));
                hoaDonList.add(hoaDon);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoaDonList;
    }
}
