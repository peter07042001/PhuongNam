package com.example.phuongnam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phuongnam.DAO.TheLoaiDAO;
import com.example.phuongnam.R;
import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.TheLoai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    List<TheLoai> theLoaiList;

    public TheLoaiAdapter(List<TheLoai> theLoaiList) {
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.the_loai_adapter, parent, false);
        TheLoai theLoai = theLoaiList.get(position);
        TextView textView = convertView.findViewById(R.id.tvMaTL);
        TextView textView1 = convertView.findViewById(R.id.tvTenTL);
        textView.setText(theLoai.maTheLoai);
        textView1.setText(theLoai.tenTheLoai);
        ImageView imageView = convertView.findViewById(R.id.imgXoaTheLoai);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheLoaiDAO theLoaiDAO = new TheLoaiDAO(new MySQLite(parent.getContext()));
                String maTheLoai = theLoaiList.get(position).maTheLoai;

                boolean kq = theLoaiDAO.deleteTheLoai(maTheLoai);

                if (kq){
                    Toast.makeText(parent.getContext(), "Xoa thanh cong", Toast.LENGTH_LONG).show();
                    theLoaiList.remove(position);
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(parent.getContext(), "Xoa khong thanh cong", Toast.LENGTH_LONG).show();
                }
            }
        });
        return convertView;
    }
}
