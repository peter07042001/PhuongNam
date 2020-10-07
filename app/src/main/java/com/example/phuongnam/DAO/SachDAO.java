package com.example.phuongnam.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.HoaDon;
import com.example.phuongnam.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    MySQLite mySQLite;

    public SachDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public boolean insertSach(Sach sach){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSach", sach.maSach);
        contentValues.put("MaTheLoai", sach.maTheLoai);
        contentValues.put("TacGia", sach.tacGia);
        contentValues.put("NXB", sach.NXB);
        contentValues.put("SoLuong", sach.soLuong);
        contentValues.put("GiaBan", sach.giaBan);

        long kq = sqLiteDatabase.insert("BOOK", null, contentValues);

        if (kq > 0) return true;
        else return false;
    }

    public boolean updateSach(Sach sach){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSach", sach.maSach);
        contentValues.put("MaTheLoai", sach.maTheLoai);
        contentValues.put("TacGia", sach.tacGia);
        contentValues.put("NXB", sach.NXB);
        contentValues.put("SoLuong", sach.soLuong);
        contentValues.put("GiaBan", sach.giaBan);

        long kq = sqLiteDatabase.update("BOOK", contentValues, "MaSach = ?", new String[]{sach.maSach});

        if (kq > 0) return true;
        else return false;

    }

    public boolean deleteSach(String MaSach){
        long kq = mySQLite.getWritableDatabase().delete("BOOK", "MaSach=?", new String[]{MaSach});

        if (kq > 0) return true;
        else return false;
    }

    public List<Sach> getAllSach(){
        List<Sach> sachList = new ArrayList<>();
        String get_all = "SELECT * FROM BOOK";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(get_all, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Sach sach = new Sach();
                sach.maSach = cursor.getString(cursor.getColumnIndex("MaSach"));
                sach.maTheLoai = cursor.getString(cursor.getColumnIndex("MaTheLoai"));

                sach.tacGia = cursor.getString(cursor.getColumnIndex("TacGia"));
                sach.NXB = cursor.getString(cursor.getColumnIndex("NXB"));
                sach.soLuong = cursor.getInt(cursor.getColumnIndex("SoLuong"));
                sach.giaBan = cursor.getDouble(cursor.getColumnIndex("GiaBan"));


                sachList.add(sach);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachList;
    }
}
