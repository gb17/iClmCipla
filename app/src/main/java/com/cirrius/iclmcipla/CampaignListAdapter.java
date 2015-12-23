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

public class CampaignListAdapter extends BaseAdapter {
    Context context;
    Typeface font;
    int index;

    public CampaignListAdapter(Context context, int index) {
        this.context = context;
        this.index = index;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if (index == 1)
            return 2;
        else if (index == 2)
            return 3;
        else
            return 0;
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
        View view;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = new View(context);
            if (index == 1)
                view = inflater.inflate(R.layout.camp_list, parent, false);
            else if (index == 2)
                view = inflater.inflate(R.layout.camp_list2, parent, false);
        } else {
            view = (View) convertView;
        }
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        TextView plan = (TextView) view.findViewById(R.id.plan);
        plan.setTypeface(font);

        TextView txt1 = (TextView) view.findViewById(R.id.txt1);
        TextView txt2 = (TextView) view.findViewById(R.id.txt2);
        TextView txt3 = (TextView) view.findViewById(R.id.txt3);
        TextView txt4 = (TextView) view.findViewById(R.id.txt4);
        TextView txt5 = (TextView) view.findViewById(R.id.txt5);
        RelativeLayout ll = (RelativeLayout) view.findViewById(R.id.ll);
        if (position == 0) {
            plan.setVisibility(View.VISIBLE);
        } else if (position == 1) {
            plan.setVisibility(View.INVISIBLE);
            txt1.setText("Mezzo Drop Revival  |  Mezzo Drop");
            txt2.setText("Detailing");
            if (index == 1)
                txt3.setText("30 Sep 2015");
            else
                txt3.setText("14 Aug");
            txt4.setText("10 Days");
            if (index == 1)
                txt5.setText("In Next Month");
            else
                txt5.setText("This Year");
        } else if (position == 2 || position == 3 || position == 4) {
            plan.setVisibility(View.GONE);
            ll.setVisibility(View.GONE);
            txt1.setText("Roar For Crore  |  C-FIX");
            txt2.setText("Detailing");
            txt3.setText("4 Aug");
            txt4.setText("3 Days");
            view.setLayoutParams(new ListView.LayoutParams(
                    ListView.LayoutParams.MATCH_PARENT, 120));
        }
        return view;
    }
}
