package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.phuongnam.R;
import com.example.phuongnam.model.Sach;

import java.util.List;

public class SachBanChayAdapter extends BaseAdapter {
    List<Sach> sachList;

    public SachBanChayAdapter(List<Sach> sachList) {
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sach_ban_chay_adapter, parent, false);
        Sach sach = sachList.get(position);
        TextView textView = convertView.findViewById(R.id.tvMaSachBC);
        TextView textView1 = convertView.findViewById(R.id.tvSlSACHBC);
        textView.setText(sach.maSach);
        textView1.setText(sach.soLuong+"");
        return convertView;
    }
}
