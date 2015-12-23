package com.cirrius.iclmcipla;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PhysicianPage extends Activity implements OnClickListener {

    private ListView listview3;
    ArrayList<String> items = new ArrayList<String>();
    private int count;
    private boolean[] thumbnailsselection;

    private LinearLayout relativvebottom;
    ArrayList<String> name;
    Typeface font;
    private RelativeLayout relativemiddle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getActionBar().setBackgroundDrawable(
                getResources().getDrawable(R.drawable.actiopnbar));
        getActionBar().setTitle(
                Html.fromHtml("<font color=\"black\">"
                        + getString(R.string.app_name) + "</font>"));
        setContentView(R.layout.physiciant);
        // GridView gridView = (GridView) findViewById(R.id.grid);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        PhysicianList list = new PhysicianList(PhysicianPage.this);

        View v = list.loadlistview();

        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);

        rl1.addView(v);

        relativemiddle = (RelativeLayout) findViewById(R.id.relativemiddle);

        for (int i = 1; i < relativemiddle.getChildCount(); i++) {

            relativemiddle.getChildAt(i).setOnClickListener(this);
            relativemiddle.getChildAt(i).setTag(i);

        }
        TextView tv1 = (TextView) findViewById(R.id.text11);
        tv1.setTypeface(font);
        TextView tv2 = (TextView) findViewById(R.id.text22);
        tv2.setTypeface(font);
        TextView tv3 = (TextView) findViewById(R.id.text33);
        tv3.setTypeface(font);
        TextView tv4 = (TextView) findViewById(R.id.text44);
        tv4.setTypeface(font);

    }

    @Override
    public void onClick(View v) {
        int id = (int) v.getTag();
        // TODO Auto-generated method stub
        if (id == 1 || id == 8 || id == 14 || id == 21)
            openDialog1(1);
        else if (id == 13 || id == 20)
            openDialog1(2);
        else {
            relativvebottom = (LinearLayout) findViewById(R.id.relativvebottom);

            TextView tvdata = (TextView) v;
            String s = tvdata.getText().toString();

            final LinearLayout linear = new LinearLayout(PhysicianPage.this);
            linear.setBackgroundResource(R.drawable.round);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            param.setMargins(20, 10, 0, 0);
            linear.setOrientation(LinearLayout.HORIZONTAL);
            linear.setLayoutParams(param);

            TextView tv = new TextView(PhysicianPage.this);
            tv.setText(s);
            tv.setGravity(Gravity.CENTER);

            LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                    30, 30);

            Button bv = new Button(PhysicianPage.this);
            parambutton.setMargins(5, 5, 0, 0);
            bv.setBackgroundResource(R.drawable.cross108);
            bv.setLayoutParams(parambutton);
            bv.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                    relativvebottom.removeView(linear);
                }
            });

            linear.addView(tv);
            linear.addView(bv);
            relativvebottom.addView(linear);
        }
    }

    public void openDialog1(int index) {
        final Dialog dialog = new Dialog(PhysicianPage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.physicianm);
        Button b1 = (Button) dialog.findViewById(R.id.button1);

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                final ArrayList<Integer> posSel = new ArrayList<Integer>();
                name = new ArrayList<String>();
                posSel.clear();
                boolean noSelect = false;
                for (int i = 0; i < thumbnailsselection.length; i++) {
                    if (thumbnailsselection[i] == true) {
                        noSelect = true;
                        Log.e("sel pos thu-->", "" + i);
                        posSel.add(i);
                        name.add(items.get(i));

                        // break;
                    }
                }

                for (int j = 0; j < name.size(); j++) {

                    relativvebottom = (LinearLayout) findViewById(R.id.relativvebottom);

                    TextView tvdata = (TextView) v;
                    String s = tvdata.getText().toString();

                    final LinearLayout linear = new LinearLayout(
                            PhysicianPage.this);
                    linear.setBackgroundResource(R.drawable.round);

                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                            LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);
                    param.setMargins(20, 10, 0, 0);
                    linear.setOrientation(LinearLayout.HORIZONTAL);
                    linear.setLayoutParams(param);

                    TextView tv = new TextView(PhysicianPage.this);
                    tv.setText(name.get(j));
                    tv.setGravity(Gravity.CENTER);

                    LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                            30, 30);

                    Button bv = new Button(PhysicianPage.this);
                    parambutton.setMargins(5, 5, 0, 0);
                    bv.setBackgroundResource(R.drawable.cross108);
                    bv.setLayoutParams(parambutton);
                    bv.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub

                            relativvebottom.removeView(linear);
                        }
                    });

                    linear.addView(tv);
                    linear.addView(bv);
                    relativvebottom.addView(linear);
                    dialog.dismiss();

                }
            }
        });

        Display display = ((WindowManager) PhysicianPage.this
                .getSystemService(this.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        dialog.getWindow().setLayout((width) / 2, (height) / 2);
        dialog.getWindow().setBackgroundDrawableResource(
                R.drawable.circularcornerlist);
        fillarray(index);
        count = items.size();
        thumbnailsselection = new boolean[count];
        listview3 = (ListView) dialog.findViewById(R.id.mainListView);
        listview3.setAdapter(new ImageAdapter(PhysicianPage.this));

        dialog.show();

    }

    private void fillarray(int index) {
        // TODO Auto-generated method stub
        if (index == 1) {
            items.clear();
            items.add("Patch1");
            items.add("Patch2");
            items.add("Patch3");
            items.add("Patch4");
            items.add("Patch5");
            items.add("Patch6");
            items.add("Patch7");
            items.add("Patch8");
            items.add("Patch9");
            items.add("Patch10");
            items.add("Patch11");
            items.add("Patch12");
            items.add("Patch13");
            items.add("Patch14");
            items.add("Patch15");
            items.add("Patch16");
        } else {
            items.clear();
            items.add("Segment1");
            items.add("Segment2");
            items.add("Segment3");
            items.add("Segment4");
            items.add("Segment5");
            items.add("Segment6");
            items.add("Segment7");
            items.add("Segment8");
            items.add("Segment9");
            items.add("Segment10");
        }

    }

    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.row_photo, null);
                holder.textview = (TextView) convertView
                        .findViewById(R.id.thumbImage);
                holder.textview.setTextColor(Color.WHITE);
                holder.checkbox = (CheckBox) convertView
                        .findViewById(R.id.itemCheckBox);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.checkbox.setId(position);
            holder.textview.setId(position);
            holder.checkbox.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    CheckBox cb = (CheckBox) v;
                    int id = cb.getId();
                    if (thumbnailsselection[id]) {
                        cb.setChecked(false);
                        thumbnailsselection[id] = false;
                    } else {
                        cb.setChecked(true);
                        thumbnailsselection[id] = true;

                        System.out.println("cmncm" + items.get(id));

                    }
                }
            });
            holder.textview.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int id = v.getId();
                }
            });
            holder.textview.setText(items.get(position));
            holder.checkbox.setChecked(thumbnailsselection[position]);
            holder.id = position;
            return convertView;
        }
    }

    class ViewHolder {
        TextView textview;
        CheckBox checkbox;
        int id;
    }
}
