package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.phuongnam.R;
import com.example.phuongnam.model.HoaDonChiTiet;

import java.util.List;

public class XemChiTietHoaDonAdapter extends BaseAdapter {
    List<HoaDonChiTiet> hoaDonChiTietList;

    public XemChiTietHoaDonAdapter(List<HoaDonChiTiet> hoaDonChiTietList) {
        this.hoaDonChiTietList = hoaDonChiTietList;
    }

    @Override
    public int getCount() {
        return hoaDonChiTietList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.xem_chi_tiet_hoa_don_adapter, parent, false);
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietList.get(position);
        TextView maHDCT = convertView.findViewById(R.id.XemChiTietMaHDCT);
        TextView maHD = convertView.findViewById(R.id.XCTMaHD);
        TextView maSach = convertView.findViewById(R.id.XCTMaSach);
        TextView SoLuong = convertView.findViewById(R.id.XCTSoLuong);

        maHDCT.setText(hoaDonChiTiet.maHDCT);
        maHD.setText(hoaDonChiTiet.maHoaDon);
        maSach.setText(hoaDonChiTiet.maSach);
        SoLuong.setText(hoaDonChiTiet.soLuongMua +"");
        return convertView;
    }
}
