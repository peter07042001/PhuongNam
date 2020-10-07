package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.phuongnam.R;
import com.example.phuongnam.model.NguoiDung;

import java.util.List;

public class XemChiTietNguoiDungAdapter extends BaseAdapter {
    List<NguoiDung> nguoiDungList;

    public XemChiTietNguoiDungAdapter(List<NguoiDung> nguoiDungList) {
        this.nguoiDungList = nguoiDungList;
    }

    @Override
    public int getCount() {
        return nguoiDungList.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.xct_nguoi_dung_adapter, parent, false);
        NguoiDung nguoiDung = nguoiDungList.get(position);
        TextView user = convertView.findViewById(R.id.XCTUser);
        TextView pass = convertView.findViewById(R.id.XCTPass);
        TextView hoten = convertView.findViewById(R.id.XCTHoTen);
        TextView sdt = convertView.findViewById(R.id.XCTSDT);

        user.setText(nguoiDung.userName);
        pass.setText(nguoiDung.passWord);
        hoten.setText(nguoiDung.hoTen);
        sdt.setText(nguoiDung.sdt);
        return convertView;
    }
}
