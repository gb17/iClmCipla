package com.cirrius.iclmcipla;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.index.table.IndexTableActivity;
import com.sync.SyncActivity;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    // public Integer[] mThumbIds = { R.drawable.dashbutton,
    // R.drawable.calbutton,
    // R.drawable.phybutton, R.drawable.detailbutton,
    // R.drawable.reportingbutton, R.drawable.actionpointbutton,
    // R.drawable.invbutton, R.drawable.eventbutton,
    // R.drawable.phynetbutton, R.drawable.canvasbutton,
    // R.drawable.campbutton, R.drawable.syncbutton };

    public Integer[] mThumbIds = {R.drawable.calbutton, R.drawable.phybutton,
            R.drawable.detailbutton, R.drawable.reportingbutton,
            R.drawable.dashbutton, R.drawable.campbutton,
            R.drawable.eventbutton, R.drawable.invbutton,
            R.drawable.actionpointbutton, R.drawable.syncbutton,
            R.drawable.phynetbutton, R.drawable.canvasbutton};

    // public String[] titles = { "Dashboard", "Calendar", "Customers",
    // "Detailing", "Reporting", "Action Point", "Inventory", "Events",
    // "Phyzii NET", "Canvas", "Campaign", "Sync" };
    public String[] titles = {"Calendar", "Customers", "Detailing",
            "Reporting", "Dashboard", "Non Call Activity", "Leave", "Inventory",
            "Action Point", "Sync", "PhyziinetT", "Expense"};

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LinearLayout ll = new LinearLayout(mContext);
        ll.setLayoutParams(new GridView.LayoutParams(
                GridView.LayoutParams.WRAP_CONTENT,
                GridView.LayoutParams.WRAP_CONTENT, 0));
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(mContext);
        textView.setText(titles[position]);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(18);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        textView.setLayoutParams(params);
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(
                GridView.LayoutParams.WRAP_CONTENT,
                GridView.LayoutParams.WRAP_CONTENT, 0));
        imageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (position == 4) {
                    Intent intent = new Intent(mContext, Dashboard.class);
                    mContext.startActivity(intent);
                } else if (position == 0) {
                    Intent intent = new Intent(mContext, CalendarClass.class);
                    mContext.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(mContext,
                            IndexTableActivity.class);
                    mContext.startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(mContext,
                            DetailingLandingPage.class);
                    mContext.startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(mContext, Reporting.class);
                    mContext.startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(mContext, ActionPoint.class);
                    mContext.startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(mContext, Physinet.class);
                    mContext.startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(mContext, CalendarClass.class);
                    intent.putExtra("call", "NCA");
                    mContext.startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(mContext, CalendarClass.class);
                    intent.putExtra("call", "leave");
                    mContext.startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(mContext, InventoryTab.class);
                    mContext.startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(mContext, SyncActivity.class);
                    mContext.startActivity(intent);
                } else if (position == 11) {
                    Toast.makeText(mContext, "Coming Soon..", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(mContext, Canvas.class);
//                    mContext.startActivity(intent);
                }
            }
        });

        ll.addView(imageView);
        ll.addView(textView);
        // imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        return ll;
    }

}
