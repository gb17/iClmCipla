package com.sync;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;

/**
 * Created by admin on 12/28/15.
 */
public class ListAdapterForsynclist extends BaseAdapter {
    Context context;
    int index;
    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_12, R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_12, R.drawable.doct_3, R.drawable.doct_4};


    Integer[] imageDoctor1 = {R.drawable.newcfix1, R.drawable.solsuna,
            R.drawable.newjade, R.drawable.stelpep, R.drawable.acenomorol, R.drawable.dew1, R.drawable.dem1,
            R.drawable.newstillsep, R.drawable.mezzodrop, R.drawable.zep1};

    private String[] Drname = {"Alan Spiegel", "Ph. Alexander Fleming",
            "John Cussack", "Alexis E. Te", "Alice Rusk", "Alan Spiegel", "Ph. Alexander Fleming",
            "John Cussack", "Alexis E. Te", "Alice Rusk"};


    private String[] Drname1 = {"C-Fix", "Solsuna",
            "10 Dew Pill", "ZEPin", "Mezzo Drop", "Acenomorol", "DEMPI",
            "Fade Pill", "Still SEP", "Ratio ZEP"};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A", "10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};

    String strTime1[] = {"", "", "", "",
            "", "", "", "", "", "",
            "", "", "", "", "",
            "", "", "", "", "", "",
            ""};
    String[] Class = {"", "", "", "", "", "", "", "", "", ""};

    String[] Specialty = {"2 MB", "1.2 MB",
            "3 MB", "0.85 MB", "1 MB", "2 MB", "1.2 MB",
            "3 MB", "0.85 MB", "1 MB"};

    Typeface font;

    ListAdapterForsynclist(Context context, int index) {
        this.context = context;
        this.index = index;

        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
    }


    @Override
    public int getCount() {
        return Drname.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sync_list_item, null);

            TextView mItemName = (TextView) convertView
                    .findViewById(R.id.eventsListEventRowText);

            TextView mItemTime = (TextView) convertView
                    .findViewById(R.id.time);

            ImageView drImageView = (ImageView) convertView
                    .findViewById(R.id.dr_image);
            TextView mItemPrice = (TextView) convertView
                    .findViewById(R.id.textViewItemPrice);

            TextView childtextview3 = (TextView) convertView
                    .findViewById(R.id.childtextview3);

            TextView menufordr = (TextView) convertView
                    .findViewById(R.id.menufordr);
            // menufordr.setTypeface(font);

            final LinearLayout layout = (LinearLayout) convertView
                    .findViewById(R.id.childiewoflist);
            final RelativeLayout mask = (RelativeLayout) convertView
                    .findViewById(R.id.masklay);
            TextView download = (TextView) convertView
                    .findViewById(R.id.download);
            final LinearLayout ll = (LinearLayout) convertView
                    .findViewById(R.id.retry);

//           /* download.setTypeface(font);


            if (index == 1) {
                TextView tick1 = (TextView) convertView
                        .findViewById(R.id.tick1);
                tick1.setTypeface(font);
                TextView tick2 = (TextView) convertView
                        .findViewById(R.id.tick2);
                tick2.setTypeface(font);
                if (position == 0) {
                    tick1.setVisibility(View.VISIBLE);
                    tick1.setText(R.string.icon_tick);
                    tick1.setTextSize(20);
                    tick1.setTextColor(Color.YELLOW);
                    tick2.setVisibility(View.VISIBLE);
                    tick2.setText(R.string.icon_tick);
                    tick2.setTextSize(20);
                    tick2.setTextColor(Color.CYAN);
                } else if (position == 1 || position == 2) {
                    tick1.setVisibility(View.VISIBLE);
                    tick1.setText(R.string.icon_tick);
                    tick1.setTextSize(20);
                    tick1.setTextColor(Color.YELLOW);
                } else {
                    tick2.setVisibility(View.VISIBLE);
                    tick2.setText(R.string.icon_exclaim);
                    tick2.setTextSize(20);
                    tick2.setTextColor(Color.parseColor("#00ffff"));
                }

            }

        if (index==1)
        {
            drImageView.setImageResource(imageDoctor[position]);
            mItemTime.setText(strTime[position]);
            mItemName.setText(Drname[position]);
            mItemPrice.setText(Specialty[position]);
            childtextview3.setText(Class[position]);
        }
            else
        {
            drImageView.setImageResource(imageDoctor1[position]);
            mItemTime.setText(strTime1[position]);
            mItemName.setText(Drname1[position]);
            mItemPrice.setText(Specialty[position]);
            childtextview3.setText(Class[position]);
        }


            // mItemName.setText(itemName);
            // mItemTime.setText(itemTime);
            // mItemPrice.setText(itemPrice);
            // childtextview3.setText(itemClass);
        }

        return convertView;
    }
}
