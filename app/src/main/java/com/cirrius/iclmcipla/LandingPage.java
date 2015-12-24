package com.cirrius.iclmcipla;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;

import com.cirrius.expand.Expandablelistviewfordoc;

public class LandingPage extends Activity {

    private TextView callavg;

    private TextView callavg3;

    private TextView comment;

    private TextView profile;

    private RelativeLayout layout;

    private LinearLayout linlayout;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.landing);
        GridView gridView = (GridView) findViewById(R.id.grid);

//        Expandablelistviewfordoc list = new Expandablelistviewfordoc(
//                LandingPage.this, 29, 1);
        Expandablelistviewfordoc list = new Expandablelistviewfordoc(
                LandingPage.this, 96, 1);

        View v = list.multilevleexpandalelistview(2);

        layout = (RelativeLayout) findViewById(R.id.content);

        linlayout = (LinearLayout) findViewById(R.id.linlayout);

        final SlidingDrawer slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);

        slidingDrawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {

            @Override
            public void onDrawerOpened() {
                linlayout.setBackgroundResource(R.drawable.bg_bottomedgedark);
                layout.setBackgroundColor(Color.parseColor("#D9212121"));

                if (slidingDrawer.isOpened()) {

                } else {
                    layout.setBackgroundColor(Color.parseColor("#4D000000"));
                    linlayout.setBackgroundResource(R.drawable.bg_bottomedge);
                }
            }
        });

        slidingDrawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {

            @Override
            public void onDrawerClosed() {
                layout.setBackgroundColor(Color.parseColor("#4D000000"));
                linlayout.setBackgroundResource(R.drawable.bg_bottomedge);

            }
        });

        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);

        rl1.addView(v);
        gridView.setAdapter(new ImageAdapter(this));

        TextView textview = (TextView) findViewById(R.id.textview);
        Typeface font = Typeface.createFromAsset(getAssets(),
                "fontawesome-webfont.ttf");
        textview.setTypeface(font);

        callavg = (TextView) findViewById(R.id.callavg);
        callavg.setTypeface(font);

        comment = (TextView) findViewById(R.id.comment);
        comment.setTypeface(font);

        profile = (TextView) findViewById(R.id.profile);
        profile.setTypeface(font);

        callavg3 = (TextView) findViewById(R.id.textview92);
        callavg3.setTypeface(font);

        TextView tv1 = (TextView) findViewById(R.id.count1);
        TextView tv2 = (TextView) findViewById(R.id.count2);
        String steps = "7.5";
        String title = "/10";

        SpannableString ss1 = new SpannableString(steps);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), 0);
        tv1.append(ss1);
        tv1.append(title);

        steps = "47";
        title = "/100";

        ss1 = new SpannableString(steps);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), 0);
        tv2.append(ss1);
        tv2.append(title);

    }
}