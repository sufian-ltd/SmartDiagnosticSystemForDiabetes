package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListItemEntity> {
    Context context;
    List<ListItemEntity> listItemEntities;
    public ListAdapter(Context context, List<ListItemEntity> listItemEntities) {
        super(context, R.layout.list_item, listItemEntities);
        this.context = context;
        this.listItemEntities = listItemEntities;
    }

    class ViewHolder {
        TextView t1, t2;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.t1 = convertView.findViewById(R.id.tvName);
            holder.t2 = convertView.findViewById(R.id.tvDate);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.t1.setText(listItemEntities.get(position).getName());
        holder.t2.setText(listItemEntities.get(position).getDate());
        return convertView;
    }

}
