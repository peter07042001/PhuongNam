package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phuongnam.DAO.SachDAO;
import com.example.phuongnam.R;
import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.Sach;

import java.util.List;

public class QuanLySachAdapter extends BaseAdapter {
    List<Sach> sachList;

    public QuanLySachAdapter(List<Sach> sachList) {
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quan_ly_sach_adaper, parent, false);
        Sach sach = sachList.get(position);
        TextView textView = convertView.findViewById(R.id.tvTenSach);
        TextView textView1 = convertView.findViewById(R.id.tvGiaBan);
        textView.setText(sach.tenSach);
        textView1.setText(sach.giaBan+"");
        ImageView imageView = convertView.findViewById(R.id.imgXoaSach);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SachDAO sachDAO = new SachDAO(new MySQLite(parent.getContext()));
                String maSach = sachList.get(position).maSach;
                boolean kq = sachDAO.deleteSach(maSach);
                if (kq){
                    Toast.makeText(parent.getContext(), "Xoa thanh cong", Toast.LENGTH_LONG).show();
                    sachList.remove(position);
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(parent.getContext(), "Xoa KHONG thanh cong", Toast.LENGTH_LONG).show();
                }
            }
        });
        return convertView;
    }
}
