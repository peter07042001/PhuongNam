package com.example.phuongnam.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    MySQLite mySQLite;

    public TheLoaiDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public boolean insertTheLoai(TheLoai theLoai){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaTheLoai", theLoai.maTheLoai);
        contentValues.put("TenTheLoai", theLoai.tenTheLoai);
        contentValues.put("MoTa", theLoai.moTa);
        contentValues.put("ViTri", theLoai.viTri);

        long kq = sqLiteDatabase.insert("THELOAI", null, contentValues);

        if (kq > 0) return  true;
        else return false;
    }

    public boolean updateTheLoai(TheLoai theLoai){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaTheLoai", theLoai.maTheLoai);
        contentValues.put("TenTheLoai", theLoai.tenTheLoai);
        contentValues.put("MoTa", theLoai.moTa);
        contentValues.put("ViTri", theLoai.viTri);

        long kq = sqLiteDatabase.update("THELOAI", contentValues, "MaTheLoai=?", new String[]{theLoai.maTheLoai});

        if (kq > 0) return  true;
        else return false;
    }

    public boolean deleteTheLoai(String MaTheLoai){
        long kq = mySQLite.getWritableDatabase().delete("THELOAI", "MaTheLoai=?", new String[]{MaTheLoai});

        if (kq > 0) return  true;
        else return false;
    }

    public List<TheLoai> getAllTheLoai(){
        List<TheLoai> theLoaiList = new ArrayList<>();
        String get_all = "SELECT * FROM THELOAI";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(get_all, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                TheLoai theLoai = new TheLoai();
                theLoai.maTheLoai = cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                theLoai.tenTheLoai = cursor.getString(cursor.getColumnIndex("TenTheLoai"));
                theLoai.moTa = cursor.getString(cursor.getColumnIndex("MoTa"));
                theLoai.viTri = cursor.getInt(cursor.getColumnIndex("ViTri"));
                theLoaiList.add(theLoai);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return theLoaiList;
    }
}
