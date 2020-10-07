package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.phuongnam.R;
import com.example.phuongnam.model.HoaDon;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {

    List<HoaDon> hoaDonList;
    public HoaDonAdapter(List<HoaDon> hoaDonList){
        this.hoaDonList = hoaDonList;
    }
    @Override
    public int getCount() {
        return hoaDonList.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoa_don_adapter, parent, false);
        HoaDon hoaDon = hoaDonList.get(position);
        TextView textView = convertView.findViewById(R.id.tvHoDonAdapter);
        TextView textView1 = convertView.findViewById(R.id.tvHoDonAdapter1);
        textView.setText(hoaDon.maHoaDon);
        textView1.setText(hoaDon.ngayMua);
        return convertView;
    }
}
