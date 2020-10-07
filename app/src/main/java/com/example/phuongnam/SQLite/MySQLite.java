package com.example.phuongnam.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLite extends SQLiteOpenHelper {

    public MySQLite(Context context) {
        super(context, "data.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_user = "CREATE TABLE USER( Username NVARCHAR(50) primary key, Password NVARCHAR(50) NOT NULL, Phone NCHAR(10) NOT NULL, HoTen NVARCHAR(50) )";
        String table_book = "CREATE TABLE BOOK (MaSach NCHAR(5) primary key NOT NULL, MaTheLoai NCHAR(5) NOT NULL, TacGia NVARCHAR(50), NXB NVARCHAR (50), SoLuong INT NOT NULL, GiaBan FLOAT NOT NULL ) ";
        String table_type = "CREATE TABLE THELOAI (MaTheLoai NCHAR(5) primary key NOT NULL, TenTheLoai NVARCHAR(50) NOT NULL, MoTa NVARCHAR(225), ViTri INT ) ";
        String table_bill = "CREATE TABLE HOADON (MaHoaDon NCHAR(7) primary key NOT NULL, NgayMua DATE NOT NULL ) ";
        String table_bill_detail = "CREATE TABLE HDCT (MaHDCT INT primary key, MaHoaDon NCHAR(7) NOT NULL, MaSach NCHAR(5) NOT NULL, SoLuongMua INT NOT NULL ) ";

        db.execSQL(table_user);
        db.execSQL(table_book);
        db.execSQL(table_type);
        db.execSQL(table_bill);
        db.execSQL(table_bill_detail);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion < 2){
                db.execSQL("ALTER TABLE BOOK ADD COLUMN TenSach NVARCHAR(50)");
            }
    }
}
