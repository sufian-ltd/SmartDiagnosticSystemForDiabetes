package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PrescriptionDataAdapter extends ArrayAdapter<PrescriptionDataEntity> {

    Context context;
    List<PrescriptionDataEntity> list;
    public PrescriptionDataAdapter(Context context, List<PrescriptionDataEntity> list ) {
        super(context, R.layout.precription_list_item, list);
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
            convertView = inflater.inflate(R.layout.precription_list_item, parent, false);
            holder = new ViewHolder();
            holder.t1 = convertView.findViewById(R.id.tvMedicine);
            holder.t2 = convertView.findViewById(R.id.tvTime);
            holder.t3 = convertView.findViewById(R.id.tvDay);
            holder.t4 = convertView.findViewById(R.id.tvEatTime);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.t1.setText("Medicine : "+list.get(position).getMedicine());
        holder.t2.setText("Dose : "+list.get(position).getTime1());
        holder.t3.setText(""+list.get(position).getDay1());
        holder.t4.setText(list.get(position).getEatTime());
        return convertView;
    }
}
