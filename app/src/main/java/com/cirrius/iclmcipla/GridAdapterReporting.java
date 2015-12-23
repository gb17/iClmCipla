package com.cirrius.iclmcipla;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GridAdapterReporting extends BaseAdapter {
    Context context;
    ArrayList<RelativeLayout> arrList;

    public GridAdapterReporting(Context context,
                                ArrayList<RelativeLayout> arrList) {
        this.context = context;
        this.arrList = arrList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrList.size();
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

        if (convertView == null) {
            convertView = arrList.get(position);
        }

        convertView.setLayoutParams(new GridView.LayoutParams(213,
                GridView.LayoutParams.WRAP_CONTENT));

        final GridView grid = (GridView) parent;

        RelativeLayout view = (RelativeLayout) convertView;
        ImageView delete = (ImageView) view.getChildAt(1);
        delete.setId(position);
        delete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int pos = v.getId();
                arrList.remove(pos);
                GridAdapterReporting adapter;
                adapter = new GridAdapterReporting(context, arrList);
                grid.setAdapter(adapter);
                ((RelativeLayout) grid.getParent()).getChildAt(4)
                        .setVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
