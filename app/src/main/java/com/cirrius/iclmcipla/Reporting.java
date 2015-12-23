package com.cirrius.iclmcipla;

import com.cirrius.expand.Expandablelistviewfordoc;
import com.cirrius.iclmcipla.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Reporting extends Activity {

    private Typeface font;
    LinearLayout linear;
    TextView tick1, tick2, noreporting, nofilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Reporting");
        setContentView(R.layout.repoting);

        Expandablelistviewfordoc list = new Expandablelistviewfordoc(
                Reporting.this, 29, 1);

        View v = list.multilevleexpandalelistview(2);
        tick1 = (TextView) findViewById(R.id.tick1);
        tick1.setOnClickListener(listener);
        tick1.setTypeface(font);
        tick1.setTag("0");
        tick2 = (TextView) findViewById(R.id.tick2);
        tick2.setOnClickListener(listener);
        tick2.setTypeface(font);
        tick2.setTag("0");
        noreporting = (TextView) findViewById(R.id.noreport);
        noreporting.setOnClickListener(listener);
        nofilter = (TextView) findViewById(R.id.nofilter);
        nofilter.setOnClickListener(listener);
        nofilter.setTag("0");

        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
        rl1.addView(v);

        linear = (LinearLayout) findViewById(R.id.cardlinear);
        String nameArr[] = {"Dr. Alan Spiegel", "Dr. Tim Powell",
                "Dr. Alexander Fleming", "Dr. Alexis E. Te", "Dr. Alice Rusk",
                "Dr. Bob Sampson"};
        for (int i = 0; i < 6; i++) {
            TextView text = new TextView(this);
            int date = 17 - i;
            text.setText(date + " July");
            text.setTextSize(26);
            text.setTextColor(Color.parseColor("#C5C5C5"));
            text.setPadding(0, 5, 0, 15);
            LinearLayout child = new LinearLayout(this);
            child.setOrientation(LinearLayout.HORIZONTAL);

            if (i == 2 || i == 5) {
                RelativeLayout row1 = getDoctorThumbnail(3, nameArr[5],
                        R.drawable.doc1, "Bronx Blvd", "11.00 am");
                RelativeLayout row2 = getDoctorThumbnail(1, nameArr[5],
                        R.drawable.doct_14, "Brooklyn", "11.30 am");
                RelativeLayout row3 = getDoctorThumbnail(2, nameArr[5],
                        R.drawable.doctor3, "Texas", "12.00 am");
                child.addView(row2);
            } else if (i == 1 || i == 4) {
                RelativeLayout row1 = getDoctorThumbnail(3, nameArr[3],
                        R.drawable.doct_15, "New York", "12.45 pm");
                RelativeLayout row2 = getDoctorThumbnail(1, nameArr[3],
                        R.drawable.doct_14, "Boulevard", "01.30 pm");
                RelativeLayout row3 = getDoctorThumbnail(2, nameArr[4],
                        R.drawable.doct_16, "Beverly Hills", "02.30 pm");
                child.addView(row3);
                child.addView(row1);
            } else {
                RelativeLayout row1 = getDoctorThumbnail(3, nameArr[0],
                        R.drawable.doc1, "Avenue", "03.30 pm");
                RelativeLayout row2 = getDoctorThumbnail(1, nameArr[1],
                        R.drawable.doct_12, "Brooklyn", "04.00 pm");
                RelativeLayout row3 = getDoctorThumbnail(2, nameArr[2],
                        R.drawable.doct_13, "Edison", "04.30 pm");
                child.addView(row1);
                child.addView(row2);
                child.addView(row3);
            }
            linear.addView(text);
            linear.addView(child);
        }

    }

    public RelativeLayout getDoctorThumbnail(int index, String nameData,
                                             int resource, String patchtxt, String timetxt) {
        RelativeLayout parent = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(230,
                170);
        parent.setLayoutParams(rlp);
        parent.setBackgroundColor(Color.parseColor("#494949"));
        ImageView drImge = new ImageView(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(80, 80);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        drImge.setLayoutParams(lp);
        drImge.setId(1001);
        drImge.setImageResource(resource);
        drImge.setPadding(20, 20, 0, 0);

        View view = new View(this);
        RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(2,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        par.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        view.setLayoutParams(par);
        view.setBackgroundColor(Color.WHITE);

        TextView tv = new TextView(this);
        RelativeLayout.LayoutParams tp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        tp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        tp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tp.leftMargin = 5;
        tv.setPadding(0, 15, 20, 0);
        tv.setText(timetxt);
        tv.setLayoutParams(tp);
        tv.setTextSize(18);
        tv.setTextColor(Color.WHITE);

        TextView tick = new TextView(this);
        RelativeLayout.LayoutParams tickparam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        tickparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tick.setPadding(90, 35, 0, 0);
        if (index == 1) {
            tick.setText(R.string.icon_tick);
            tick.setTextColor(Color.YELLOW);
        } else if (index == 2) {
            tick.setText(R.string.icon_exclaim);
            tick.setTextColor(Color.RED);
        } else
            tick.setVisibility(View.INVISIBLE);
        tick.setTypeface(font);
        tick.setLayoutParams(tickparam);

        tick.setTextSize(22);

        TextView name = new TextView(this);
        RelativeLayout.LayoutParams nameparam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        nameparam.addRule(RelativeLayout.BELOW, 1001);
        name.setId(1002);
        name.setPadding(20, 20, 0, 0);
        name.setLayoutParams(nameparam);
        name.setText(nameData);
        name.setTextSize(20);
        name.setTypeface(null, Typeface.BOLD);
        name.setTextColor(Color.WHITE);

        TextView patch = new TextView(this);
        RelativeLayout.LayoutParams patchparam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        patchparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        patchparam.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        patch.setPadding(20, 0, 0, 20);
        patch.setLayoutParams(patchparam);
        patch.setText(patchtxt);
        patch.setTextSize(18);
        patch.setTextColor(Color.WHITE);

        parent.addView(drImge);
        parent.addView(tv);
        parent.addView(tick);
        parent.addView(name);
        parent.addView(patch);
        parent.addView(view);
        parent.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Reporting.this, ReportingTabs.class);
                Reporting.this.startActivity(intent);
            }
        });

        return parent;

    }

    OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            // TextView text1 = (TextView) linear.getChildAt(0);
            LinearLayout child1 = (LinearLayout) linear.getChildAt(1);
            TextView text2 = (TextView) linear.getChildAt(2);
            LinearLayout child2 = (LinearLayout) linear.getChildAt(3);
            TextView text3 = (TextView) linear.getChildAt(4);
            LinearLayout child3 = (LinearLayout) linear.getChildAt(5);
            // TextView text4 = (TextView) linear.getChildAt(6);
            LinearLayout child4 = (LinearLayout) linear.getChildAt(7);
            TextView text5 = (TextView) linear.getChildAt(8);
            LinearLayout child5 = (LinearLayout) linear.getChildAt(9);
            TextView text6 = (TextView) linear.getChildAt(10);
            LinearLayout child6 = (LinearLayout) linear.getChildAt(11);

            if (v.getId() == R.id.tick1) {
                if (v.getTag().equals("1")) {
                    tick1.setBackgroundResource(R.drawable.round_gray);
                    tick2.setBackgroundResource(R.drawable.round_gray);
                    noreporting.setBackgroundResource(R.drawable.round_gray);
                    nofilter.setBackgroundResource(R.drawable.round_gray);
                    child1.getChildAt(0).setVisibility(View.VISIBLE);
                    child1.getChildAt(2).setVisibility(View.VISIBLE);
                    child1.getChildAt(1).setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    child2.getChildAt(0).setVisibility(View.VISIBLE);
                    child2.getChildAt(1).setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                    child3.setVisibility(View.VISIBLE);
                    child4.getChildAt(0).setVisibility(View.VISIBLE);
                    child4.getChildAt(2).setVisibility(View.VISIBLE);
                    child4.getChildAt(1).setVisibility(View.VISIBLE);
                    text5.setVisibility(View.VISIBLE);
                    child5.getChildAt(0).setVisibility(View.VISIBLE);
                    child5.getChildAt(1).setVisibility(View.VISIBLE);
                    text6.setVisibility(View.VISIBLE);
                    child6.setVisibility(View.VISIBLE);
                    v.setTag("0");
                } else {
                    tick1.setBackgroundResource(R.drawable.round_cyan);
                    tick2.setBackgroundResource(R.drawable.round_gray);
                    noreporting.setBackgroundResource(R.drawable.round_gray);
                    nofilter.setBackgroundResource(R.drawable.round_gray);
                    child1.getChildAt(0).setVisibility(View.GONE);
                    child1.getChildAt(2).setVisibility(View.GONE);
                    child1.getChildAt(1).setVisibility(View.VISIBLE);
                    text2.setVisibility(View.GONE);
                    child2.getChildAt(0).setVisibility(View.GONE);
                    child2.getChildAt(1).setVisibility(View.GONE);
                    text3.setVisibility(View.VISIBLE);
                    child3.setVisibility(View.VISIBLE);
                    child4.getChildAt(0).setVisibility(View.GONE);
                    child4.getChildAt(2).setVisibility(View.GONE);
                    child4.getChildAt(1).setVisibility(View.VISIBLE);
                    text5.setVisibility(View.GONE);
                    child5.getChildAt(0).setVisibility(View.GONE);
                    child5.getChildAt(1).setVisibility(View.GONE);
                    text6.setVisibility(View.VISIBLE);
                    child6.setVisibility(View.VISIBLE);
                    v.setTag("1");
                }
            } else if (v.getId() == R.id.tick2) {
                if (v.getTag().equals("1")) {
                    tick1.setBackgroundResource(R.drawable.round_gray);
                    tick2.setBackgroundResource(R.drawable.round_gray);
                    noreporting.setBackgroundResource(R.drawable.round_gray);
                    nofilter.setBackgroundResource(R.drawable.round_gray);
                    child1.getChildAt(0).setVisibility(View.VISIBLE);
                    child1.getChildAt(2).setVisibility(View.VISIBLE);
                    child1.getChildAt(1).setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    child2.getChildAt(0).setVisibility(View.VISIBLE);
                    child2.getChildAt(1).setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                    child3.setVisibility(View.VISIBLE);
                    child4.getChildAt(0).setVisibility(View.VISIBLE);
                    child4.getChildAt(2).setVisibility(View.VISIBLE);
                    child4.getChildAt(1).setVisibility(View.VISIBLE);
                    text5.setVisibility(View.VISIBLE);
                    child5.getChildAt(0).setVisibility(View.VISIBLE);
                    child5.getChildAt(1).setVisibility(View.VISIBLE);
                    text6.setVisibility(View.VISIBLE);
                    child6.setVisibility(View.VISIBLE);
                    v.setTag("0");
                } else {
                    tick2.setBackgroundResource(R.drawable.round_cyan);
                    tick1.setBackgroundResource(R.drawable.round_gray);
                    noreporting.setBackgroundResource(R.drawable.round_gray);
                    nofilter.setBackgroundResource(R.drawable.round_gray);
                    child1.getChildAt(0).setVisibility(View.GONE);
                    child1.getChildAt(2).setVisibility(View.VISIBLE);
                    child1.getChildAt(1).setVisibility(View.GONE);
                    text2.setVisibility(View.VISIBLE);
                    child2.getChildAt(0).setVisibility(View.VISIBLE);
                    child2.getChildAt(1).setVisibility(View.GONE);
                    text3.setVisibility(View.GONE);
                    child3.setVisibility(View.GONE);
                    child4.getChildAt(0).setVisibility(View.GONE);
                    child4.getChildAt(2).setVisibility(View.VISIBLE);
                    child4.getChildAt(1).setVisibility(View.GONE);
                    text5.setVisibility(View.VISIBLE);
                    child5.getChildAt(0).setVisibility(View.VISIBLE);
                    child5.getChildAt(1).setVisibility(View.GONE);
                    text6.setVisibility(View.GONE);
                    child6.setVisibility(View.GONE);
                    v.setTag("1");
                }
            } else if (v.getId() == R.id.noreport) {
                tick1.setBackgroundResource(R.drawable.round_gray);
                tick2.setBackgroundResource(R.drawable.round_gray);
                noreporting.setBackgroundResource(R.drawable.round_cyan);
                nofilter.setBackgroundResource(R.drawable.round_gray);
                child1.getChildAt(0).setVisibility(View.VISIBLE);
                child1.getChildAt(2).setVisibility(View.GONE);
                child1.getChildAt(1).setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
                child2.getChildAt(0).setVisibility(View.GONE);
                child2.getChildAt(1).setVisibility(View.VISIBLE);
                text3.setVisibility(View.VISIBLE);
                child3.setVisibility(View.VISIBLE);
                child4.getChildAt(0).setVisibility(View.VISIBLE);
                child4.getChildAt(2).setVisibility(View.GONE);
                child4.getChildAt(1).setVisibility(View.VISIBLE);
                text5.setVisibility(View.VISIBLE);
                child5.getChildAt(0).setVisibility(View.GONE);
                child5.getChildAt(1).setVisibility(View.VISIBLE);
                text6.setVisibility(View.VISIBLE);
                child6.setVisibility(View.VISIBLE);
            } else {
                if (v.getTag().equals("1")) {
                    tick1.setBackgroundResource(R.drawable.round_gray);
                    tick2.setBackgroundResource(R.drawable.round_gray);
                    noreporting.setBackgroundResource(R.drawable.round_gray);
                    nofilter.setBackgroundResource(R.drawable.round_gray);
                    child1.getChildAt(0).setVisibility(View.VISIBLE);
                    child1.getChildAt(2).setVisibility(View.VISIBLE);
                    child1.getChildAt(1).setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    child2.getChildAt(0).setVisibility(View.VISIBLE);
                    child2.getChildAt(1).setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                    child3.setVisibility(View.VISIBLE);
                    child4.getChildAt(0).setVisibility(View.VISIBLE);
                    child4.getChildAt(2).setVisibility(View.VISIBLE);
                    child4.getChildAt(1).setVisibility(View.VISIBLE);
                    text5.setVisibility(View.VISIBLE);
                    child5.getChildAt(0).setVisibility(View.VISIBLE);
                    child5.getChildAt(1).setVisibility(View.VISIBLE);
                    text6.setVisibility(View.VISIBLE);
                    child6.setVisibility(View.VISIBLE);
                    v.setTag("0");
                } else {
                    tick1.setBackgroundResource(R.drawable.round_gray);
                    tick2.setBackgroundResource(R.drawable.round_gray);
                    noreporting.setBackgroundResource(R.drawable.round_gray);
                    nofilter.setBackgroundResource(R.drawable.round_cyan);
                    child1.getChildAt(0).setVisibility(View.VISIBLE);
                    child1.getChildAt(2).setVisibility(View.GONE);
                    child1.getChildAt(1).setVisibility(View.GONE);
                    text2.setVisibility(View.VISIBLE);
                    child2.getChildAt(0).setVisibility(View.GONE);
                    child2.getChildAt(1).setVisibility(View.VISIBLE);
                    text3.setVisibility(View.GONE);
                    child3.setVisibility(View.GONE);
                    child4.getChildAt(0).setVisibility(View.VISIBLE);
                    child4.getChildAt(2).setVisibility(View.GONE);
                    child4.getChildAt(1).setVisibility(View.GONE);
                    text5.setVisibility(View.VISIBLE);
                    child5.getChildAt(0).setVisibility(View.GONE);
                    child5.getChildAt(1).setVisibility(View.VISIBLE);
                    text6.setVisibility(View.GONE);
                    child6.setVisibility(View.GONE);
                    v.setTag("1");
                }
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                // Intent intent = new Intent(this, DetailingLandingPage.class);
                // navigateUpTo(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
