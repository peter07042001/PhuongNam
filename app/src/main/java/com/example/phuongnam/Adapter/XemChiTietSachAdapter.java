package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.phuongnam.R;
import com.example.phuongnam.model.NguoiDung;
import com.example.phuongnam.model.Sach;

import java.util.List;

public class XemChiTietSachAdapter extends BaseAdapter {
    List<Sach> sachList;

    public XemChiTietSachAdapter(List<Sach> sachList) {
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.xem_chi_tiet_sach_adapter, parent, false);
        Sach sach = sachList.get(position);
        TextView tensach = convertView.findViewById(R.id.XCTTENSACH);
        TextView masach = convertView.findViewById(R.id.XCTMASACH);
        TextView matl = convertView.findViewById(R.id.XCTMATL);
        TextView tg = convertView.findViewById(R.id.XCTTG);
        TextView gb = convertView.findViewById(R.id.XCTGB);
        TextView nxb = convertView.findViewById(R.id.XCTNXB);
        TextView sl = convertView.findViewById(R.id.XCTSL);

        tensach.setText(sach.tenSach);
        masach.setText(sach.maSach);
        matl.setText(sach.maTheLoai);
        tg.setText(sach.tacGia);
        gb.setText(sach.giaBan+"");
        nxb.setText(sach.NXB);
        sl.setText(sach.soLuong+ "");
        return convertView;
    }
}
