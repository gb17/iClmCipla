package com.cirrius.iclmcipla;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class NewCustomAdapter extends BaseAdapter {
    List<String[]> originalData = null;
    List<String[]> filteredData = null;

    Context context;



    Integer[] imageDoctor = { R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
            R.drawable.doct_9, R.drawable.doct_7, R.drawable.doct_6, };

    String[] Drname = { "Alan Spiegel", "Alexander F", "Alexander M.",
            "Alexis E. Te", "Alice Rusk", "John Cussack", "Paul Allen" };

    String strTime[] = { "10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "01:45 pm", "02:15 pm", "01:30 pm", "Class B",
            "Class C", "Class A" };

    String[] Specialty = { "Nuclear cardiology", "Cardiologist",
            "Urologic oncology", "Urologic oncology", "Neurologist",
            "Nuclear cardiology", "Cardiologist" };
    String[] Class = { "Class B", "Class A", "Class C", "Class C", "Class B",
            "Class A", "Class C" };


    private Typeface font;
    int index = 0;

    public NewCustomAdapter(Context context) {
        // TODO Auto-generated constructor stub
        this.context = context;
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
    }

    @Override
    public int getCount() {
        return Drname.length;
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

        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_exrow_third, null);

        TextView mItemName = (TextView) convertView
                .findViewById(R.id.eventsListEventRowText);

        TextView mItemTime = (TextView) convertView.findViewById(R.id.time);

        ImageView drImageView = (ImageView) convertView
                .findViewById(R.id.dr_image);
        TextView mItemPrice = (TextView) convertView
                .findViewById(R.id.textViewItemPrice);

        TextView childtextview3 = (TextView) convertView
                .findViewById(R.id.childtextview3);

        final LinearLayout childiewoflist = (LinearLayout) convertView
                .findViewById(R.id.childiewoflist);


        drImageView.setImageResource(imageDoctor[position]);
        mItemTime.setText(strTime[position]);
        mItemName.setText(Drname[position]);
        mItemPrice.setText(Specialty[position]);
        childtextview3.setText(Class[position]);

        return convertView;
    }

    static class ViewHolder {

        public TextView name;
        public TextView speciality;
        public TextView drclass;
        public ImageView drimage;

    }


}
