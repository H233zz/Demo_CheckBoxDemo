package com.example.administrator.checkboxdome;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13 0013.
 */

public class MyAdapter extends BaseAdapter {
    private List<Bean> list;
    private Context context;

    public MyAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView= View.inflate(context,R.layout.item1,null);
            holder.name=(TextView) convertView.findViewById(R.id.text);
            holder.box=(CheckBox)convertView.findViewById(R.id.check);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(position).ischeck=isChecked;

            }
        });

        holder.name.setText(list.get(position).name);
        holder.box.setChecked(list.get(position).ischeck);

        return convertView;
    }
    class ViewHolder{
        TextView name;
        CheckBox box;
    }
}
