package com.cirrius.iclmcipla;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ActionListAdapter extends BaseAdapter {
    Context context;
    int index;
    List<String[]> list;
    Typeface font;

    public ActionListAdapter(Context context, int index, List<String[]> list) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.index = index;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (index == 1)
                convertView = inflater.inflate(R.layout.camp_list, parent,
                        false);
            else if (index == 2)
                convertView = inflater.inflate(R.layout.camp_list2, parent,
                        false);
            holder = new ViewHolder();
            holder.txt1 = (TextView) convertView.findViewById(R.id.txt1);
            holder.txt2 = (TextView) convertView.findViewById(R.id.txt2);
            holder.txt3 = (TextView) convertView.findViewById(R.id.txt3);
            holder.txt4 = (TextView) convertView.findViewById(R.id.txt4);
            holder.txt5 = (TextView) convertView.findViewById(R.id.txt5);
            holder.ll = (RelativeLayout) convertView.findViewById(R.id.ll);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        TextView plan = (TextView) convertView.findViewById(R.id.plan);
        plan.setTypeface(font);
        String[] str = list.get(position);
        holder.txt1.setText(str[1]);
        holder.txt2.setText(str[2]);
        holder.txt3.setText(str[3]);
        holder.txt4.setText(str[4]);
        holder.txt5.setText(str[0]);
        if (str[0].equals("")) {
            holder.ll.setVisibility(View.GONE);
            convertView.setLayoutParams(new ListView.LayoutParams(
                    ListView.LayoutParams.MATCH_PARENT, 120));
        }
        return convertView;
    }

    static class ViewHolder {

        public TextView txt1;
        public TextView txt2;
        public TextView txt3;
        public TextView txt4;
        public TextView txt5;
        public RelativeLayout ll;

    }

}
