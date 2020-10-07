package com.example.phuongnam.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {

    private MySQLite mySQLite;

    public NguoiDungDAO(MySQLite mySQLite){
        this.mySQLite = mySQLite;
    }
    //them
    public boolean insertUser(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Username", nguoiDung.userName);
        contentValues.put("Password", nguoiDung.passWord);
        contentValues.put("HoTen", nguoiDung.hoTen);
        contentValues.put("Phone", nguoiDung.sdt);

        long kq = sqLiteDatabase.insert("USER", null, contentValues);

        if (kq > 0) return true;
        else return false;
    }
    //sua
    public boolean updateUser(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Username", nguoiDung.userName);
        contentValues.put("Password", nguoiDung.passWord);
        contentValues.put("HoTen", nguoiDung.hoTen);
        contentValues.put("Phone", nguoiDung.sdt);

        long kq = sqLiteDatabase.update("USER", contentValues, "Username = ?", new String[]{nguoiDung.userName});

        if (kq > 0) return  true;
        else return false;
    }
    //xoa
    public boolean deleteUser(String userName){
        long kq = mySQLite.getWritableDatabase().delete("USER", "Username=?", new String[]{userName});
        if (kq > 0) return true;
        else return false;
    }
    //laydanhsach
    public List<NguoiDung> getAllUser(){
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String get_all = "SELECT * FROM USER";

        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(get_all, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
             NguoiDung nguoiDung = new NguoiDung();
             nguoiDung.userName = cursor.getString(cursor.getColumnIndex("Username"));
             nguoiDung.passWord = cursor.getString(cursor.getColumnIndex("Password"));
             nguoiDung.sdt = cursor.getString(cursor.getColumnIndex("Phone"));
             nguoiDung.hoTen = cursor.getString(cursor.getColumnIndex("HoTen"));

             nguoiDungList.add(nguoiDung);
             cursor.moveToNext();

            }
            cursor.close();
        }
        return nguoiDungList;
    }
}
