package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class DoctorAdapter extends ArrayAdapter<DoctorEntity> {
    Context context;
    List<DoctorEntity> list;
    public DoctorAdapter(Context context, List<DoctorEntity> list) {
        super(context, R.layout.doctor_list_item, list);
        this.context = context;
        this.list = list;
    }

    class ViewHolder {
        TextView t1, t2,t3,t4;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.doctor_list_item, parent, false);
            holder = new ViewHolder();
            holder.t1 = convertView.findViewById(R.id.tvName);
            holder.t2 = convertView.findViewById(R.id.tvQualification);
            holder.t3 = convertView.findViewById(R.id.tvAvailable);
            holder.t4=convertView.findViewById(R.id.tvFee);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.t1.setText("Name: "+list.get(position).getName());
        holder.t2.setText(list.get(position).getQualification());
        holder.t3.setText("Available : "+list.get(position).getAvailable());
        holder.t4.setText("Fee : "+list.get(position).getFee()+" TK");
        return convertView;
    }

}
