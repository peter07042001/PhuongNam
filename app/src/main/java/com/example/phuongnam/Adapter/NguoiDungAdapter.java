package com.example.phuongnam.Adapter;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phuongnam.DAO.NguoiDungDAO;
import com.example.phuongnam.QuanLyNguoiDungActivity;
import com.example.phuongnam.R;
import com.example.phuongnam.SQLite.MySQLite;
import com.example.phuongnam.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {

    List<NguoiDung> nguoiDungList;
    public NguoiDungAdapter(List<NguoiDung> nguoiDungList){
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nguoi_dung_adapter, parent, false);
        NguoiDung nguoiDung = nguoiDungList.get(position);
        TextView textView = convertView.findViewById(R.id.tvName);
        textView.setText(nguoiDung.userName + " : " + nguoiDung.sdt +" : " + nguoiDung.hoTen);
        ImageView imageView = convertView.findViewById(R.id.imgXoaNguoiDungAdapter);;


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(new MySQLite(parent.getContext()));
                String username = nguoiDungList.get(position).userName;
                boolean kq = nguoiDungDAO.deleteUser(username);
                if (kq){
                    Toast.makeText(parent.getContext(), "Xoa thanh cong", Toast.LENGTH_LONG).show();
                    nguoiDungList.remove(position);
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(parent.getContext(), "Xoa khong thanh cong", Toast.LENGTH_LONG).show();
                }
            }
        });
        return convertView;
    }
}
