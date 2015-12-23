package com.cirrius.iclmcipla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_gridfornoti extends BaseAdapter {

    private int[] imageId;
    private Context mcontext;
    private String[] data;
    private String[] datanext;
    private int[] imageId1;

    public Custom_gridfornoti(Context c, int[] imageId, String[] data,
                              String[] datanext, int[] imageId1) {
        // TODO Auto-generated constructor stub

        mcontext = c;
        this.imageId = imageId;
        this.data = data;
        this.datanext = datanext;
        this.imageId1 = imageId1;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
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
            grid = inflater.inflate(
                    R.layout.customlistnotificationfornotification, null);

            TextView textView = (TextView) grid.findViewById(R.id.textview1);

            TextView textView1 = (TextView) grid.findViewById(R.id.textview2);

            ImageView imageView = (ImageView) grid
                    .findViewById(R.id.imageviewcustom);

            ImageView imageView1 = (ImageView) grid
                    .findViewById(R.id.imageviewcustomlast);

            textView.setText(data[position]);
            textView1.setText(datanext[position]);
            imageView.setImageResource(imageId[position]);
            if (position == 3) {
                imageView1.setImageResource(R.drawable.pdf_attachment);
            }
            // imageView1.setImageResource(imageId1[position]);
        } else {
            grid = (View) converview;
        }
        return grid;
    }

}
