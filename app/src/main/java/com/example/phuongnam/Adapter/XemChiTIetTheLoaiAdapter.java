package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.phuongnam.R;
import com.example.phuongnam.model.HoaDonChiTiet;
import com.example.phuongnam.model.TheLoai;

import java.util.List;

public class XemChiTIetTheLoaiAdapter extends BaseAdapter {
    List<TheLoai> theLoaiList;

    public XemChiTIetTheLoaiAdapter(List<TheLoai> theLoaiList) {
        this.theLoaiList = theLoaiList;
    }

    @Override
    public int getCount() {
        return theLoaiList.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.xem_chi_tiet_the_loai_adapter, parent, false);
        TheLoai theLoai = theLoaiList.get(position);
        TextView maTL = convertView.findViewById(R.id.XCTMATLTL);
        TextView tenTL = convertView.findViewById(R.id.XCTTENTL);
        TextView moTa = convertView.findViewById(R.id.XCTMOTA);
        TextView viTri = convertView.findViewById(R.id.XCTVITRI);

        maTL.setText(theLoai.maTheLoai);
        tenTL.setText(theLoai.tenTheLoai);
        moTa.setText(theLoai.moTa);
        viTri.setText(theLoai.viTri+"");
        return convertView;
    }
}
