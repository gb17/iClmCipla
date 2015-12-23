package com.cirrius.iclmcipla;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_grid extends BaseAdapter {

    private Context mcontext;
    private int[] imageId1;

    Integer[] imageDoctor = {R.drawable.newcfix1, R.drawable.newcfix2,
            R.drawable.newmezzo, R.drawable.index, R.drawable.video};

    String[] pagenaem = {"Introduction", "Efficacy", "Dosage Chart",
            "Case Study", "Video"};

    public Custom_grid(Context c, int[] imageId1) {
        // TODO Auto-generated constructor stub

        mcontext = c;
        this.imageId1 = imageId1;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageDoctor.length;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View converview, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mcontext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (converview == null) {
            grid = new View(mcontext);
            grid = inflater.inflate(R.layout.customlistnotification, null);

            // ImageView imageView = (ImageView) grid
            // .findViewById(R.id.imageviewcustom);
            //
            // imageView.setImageResource(R.drawable.index);

            // imageView1.setImageResource(imageId1[position]);
        } else {
            grid = (View) converview;
        }
        View thumbview = (View) grid.findViewById(R.id.thumbviewgrid);
        ImageView imageView = (ImageView) grid.findViewById(R.id.cficx1);

        imageView.setImageResource(imageDoctor[position]);
        TextView seq = (TextView) thumbview.findViewById(R.id.seq);
        seq.setTextColor(Color.WHITE);
        seq.setText(pagenaem[position]);
        TextView desc1 = (TextView) thumbview.findViewById(R.id.desc1);
        desc1.setTextColor(Color.WHITE);
        final ImageView icon = (ImageView) thumbview.findViewById(R.id.desc3);

        icon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                icon.setImageResource(R.drawable.emailiconglow);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                DetailingPageV2.disMiss();

            }
        });
        return grid;
    }

}
