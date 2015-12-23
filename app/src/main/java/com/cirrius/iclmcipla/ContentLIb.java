package com.cirrius.iclmcipla;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TableRow;
import android.widget.TextView;

public class ContentLIb extends Activity {
    CalendarView calendar;
    EditText datePicker = null;
    EditText timePicker = null;
    TextView brandHeader, Servicesheader, playlistHeader = null;
    TextView therapy, brand, specialty = null;
    ScrollView scroller = null;
    String headerText[] = {"A", "C", "D", "G", "H", "J", "K", "M", "N", "P",
            "R", "S", "T", "V"};
    String secondHeaderTitle[] = {"", "", "", "", "", "", "", "", "", "", "",
            "", "", ""};
    String secondHeaderVisibilty[] = {"A", "C", "D", "G", "H", "J", "K", "M",
            "N", "P", "R", "S", "T", "V"};

    String[][] drName = {
            {"Ajay Choksi", "Amol khot", "Anand Joshi", "Arvind Singh"},
            {"Chetan Rathi"},
            {"DM Vadgaokar", "Dattatray Solanke", "Dhaval Gupta",
                    "Devendra Desai", "Dhiren Pipalia"},
            {"Gautam Ramakantan", "Geeta Billa"},
            {"HrishikeshGastro Kaleria"},
            {"Jayshree shah", "Jatin Patel", "JayantS Barve", "Jayant Doshi",
                    "Jayesh Soni"},
            {"K Shankaran", "Kaivan Shah", "Khanna Molina",
                    "Khurshid Vazifdar"},
            {"Malan Patil", "Meghraj Ingle", "Mehul Choksi"},
            {"NH Banka", "Nilesh Pandav", "Nirav Pipaliya", "Nutan Desai"},
            {"Pathik Parikh", "Phillip Abrahim", "Prabha Sawant",
                    "Pradeep Raisinghani Raisinghani"},
            {"Rajesh Dora"},
            {"Sandeep Patil", "Saifi Plumber", "SamirS Parikh",
                    "Sandeep Shah", "SandeepGastro Dawawala", "Sanjeev Khana",
                    "Saumel Shah", "Shankar Sawant", "Subhash Agal"},
            {"Tarun Gupta"},
            {"VarunGastro Khandale", "Vipul Roy Rathod", "Viral Patrawala"}};

    String[][] spec = {
            {"Gastroenterologist", "Gastroenterologist", "Gastroenterologist",
                    "Gastroenterologist"},
            {"Gastroenterologist"},
            {"Gastro Surgeon", "Gastroenterologist", "Gastroenterologist",
                    "Gastroenterologist", "Gastroenterologist"},
            {"Gastroenterologist", "Consulting Physician"},
            {"RMO-Resident Medical Officer"},
            {"Gastroenterologist", "Gastroenterologist",
                    "Consulting Physician", "Gastroenterologist",
                    "Gastroenterologist"},
            {"Gastroenterologist", "Gastroenterologist", "Gastroenterologist",
                    "Gastroenterologist"},
            {"Consulting Physician", "Gastroenterologist",
                    "Gastroenterologist"},
            {"Gastroenterologist", "Gastroenterologist", "Gastroenterologist",
                    "Gastroenterologist"},
            {"Gastroenterologist", "Gastroenterologist", "Gastroenterologist",
                    "Consulting Physician"},
            {"Gastroenterologist"},
            {"Consulting Physician", "Gastroenterologist",
                    "Gastroenterologist", "Gastroenterologist",
                    "RMO-Resident Medical Officer", "Consulting Physician",
                    "Gastroenterologist", "Gastroenterologist",
                    "Gastroenterologist"},
            {"Gastroenterologist"},
            {"RMO-Resident Medical Officer", "Gastroenterologist",
                    "Gastroenterologist"}};
    private View view1;
    private View view2;
    private View view3;
    private View view4;

    private LinearLayout brandlin;

    private RelativeLayout thumbview1, thumbview2, thumbview3, thumbview4,
            thumbview5, thumbview21, thumbview22, thumbview23, thumbview24,
            thumbview25, thumbview28, thumbview29, thumbview30, thumbview31,
            thumbview32, thumbviewbrand11, thumbviewbrand12, thumbviewbrand13,
            thumbviewbrand14, thumbviewbrand15, thumbviewbrand21,
            thumbviewbrand22, thumbviewbrand23, thumbviewbrand24,
            thumbviewbrand25, th11, th12, th13, th14, th15, th21, th22, th23,
            th24, th25, th31, th32, th33, th34, th35, th41, th42, th43, th44,
            th45, thumbnailsr11, thumbnailsr12, thumbnailsr13, thumbnailsr14,
            thumbnailsr15, thumbnailsr21, thumbnailsr22, thumbnailsr23,
            thumbnailsr24, thumbnailsr25;
    Typeface font;

    private TextView playlistnew;
    private View viewsamplednew;

    private RelativeLayout thumbview188, thumbview288, thumbview388,
            thumbview488, thumbview588;
    private RelativeLayout myrel6, myrel2, myrel3, myrel4;
    private View brand11view;
    private View brand12view;
    private TextView brand11;
    private TextView brand12;
    private String type;
    private RelativeLayout playlisrel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Library");
        setContentView(R.layout.whole_lib);
        try {
            Bundle bundle = getIntent().getExtras();
            type = bundle.getString("type");
        } catch (Exception e) {
            // TODO: handle exception
        }

        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        TableRow row1 = (TableRow) findViewById(R.id.row31);
        thumbview1 = Utility.getThumnail(this, R.drawable.newcfix2, "C Fix",
                "Introduction");
        thumbview2 = Utility.getThumnail(this, R.drawable.newcfix3, "C-Fix",
                "Types of CVD");
        thumbview3 = Utility.getThumnail(this, R.drawable.mezom1, "Mezzodrop",
                "Risk Factors");
        thumbview4 = Utility.getThumnail(this, R.drawable.ratio1, "RatioZep",
                "Antacid");
        thumbview5 = Utility.getThumnail(this, R.drawable.stel1, "StelPep",
                "Side Effects");

        TableRow.LayoutParams rlp = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        rlp.leftMargin = 2;
        row1.addView(thumbview1, rlp);
        row1.addView(thumbview2, rlp);
        row1.addView(thumbview3, rlp);
        row1.addView(thumbview4, rlp);
        row1.addView(thumbview5, rlp);

        TableRow row2 = (TableRow) findViewById(R.id.row32);
        thumbview188 = Utility.getThumnail(this, R.drawable.newcfix2, "C Fix",
                "Introduction");
        thumbview288 = Utility.getThumnail(this, R.drawable.newcfix3, "C-Fix",
                "Types of CVD");
        thumbview388 = Utility.getThumnail(this, R.drawable.mezom1,
                "Mezzodrop", "Risk Factors");
        thumbview488 = Utility.getThumnail(this, R.drawable.ratio1, "RatioZep",
                "Antacid");
        thumbview588 = Utility.getThumnail(this, R.drawable.stel1, "StelPep",
                "Side Effects");

        row2.addView(thumbview188, rlp);
        row2.addView(thumbview288, rlp);
        row2.addView(thumbview388, rlp);
        row2.addView(thumbview488, rlp);

        TableRow row3 = (TableRow) findViewById(R.id.rown2);
        thumbview21 = Utility.getThumnail(this, R.drawable.newjade,
                "10 Jade Dew", "Description");
        thumbview22 = Utility.getThumnail(this, R.drawable.newcfix2,
                "Fade Pill", "Treatments");
        thumbview23 = Utility.getThumnail(this, R.drawable.newcfix2, "C-fix",
                "Case Study");
        thumbview24 = Utility.getThumnail(this, R.drawable.newace,
                "Acenomorol", "Dosage Patterns");
        thumbview25 = Utility.getThumnail(this, R.drawable.mezom1,
                "Mezzo Drop", "Prevention Method");

        row3.addView(thumbview21, rlp);
        row3.addView(thumbview22, rlp);
        row3.addView(thumbview23, rlp);
        row3.addView(thumbview24, rlp);
        row3.addView(thumbview25, rlp);

        TableRow row4 = (TableRow) findViewById(R.id.rown22);
        thumbview28 = Utility.getThumnail(this, R.drawable.newjade,
                "10 Jade Dew", "Description");
        thumbview29 = Utility.getThumnail(this, R.drawable.newcfix2,
                "Fade Pill", "Treatments");
        thumbview30 = Utility.getThumnail(this, R.drawable.newcfix2, "C-fix",
                "Case Study");
        thumbview31 = Utility.getThumnail(this, R.drawable.newace,
                "Acenomorol", "Dosage Patterns");
        thumbview32 = Utility.getThumnail(this, R.drawable.mezom1,
                "Mezzo Drop", "Prevention Method");

        row4.addView(thumbview28, rlp);
        row4.addView(thumbview29, rlp);
        row4.addView(thumbview30, rlp);
        row4.addView(thumbview31, rlp);
        row4.addView(thumbview32, rlp);

        TableRow row5 = (TableRow) findViewById(R.id.brandrow1);
        thumbviewbrand11 = Utility.getThumnail(this, R.drawable.newcfix1,
                "C Fix", "");
        thumbviewbrand12 = Utility.getThumnail(this, R.drawable.newace,
                "Acenomorol", "");
        thumbviewbrand13 = Utility.getThumnail(this, R.drawable.newjade,
                "10 Jade dew", "");
        thumbviewbrand14 = Utility.getThumnail(this, R.drawable.newmezzo,
                "Mezzo drop", "");
        thumbviewbrand15 = Utility.getThumnail(this, R.drawable.newjade,
                "Still Sep", "");

        row5.addView(thumbviewbrand11, rlp);
        row5.addView(thumbviewbrand12, rlp);
        row5.addView(thumbviewbrand13, rlp);
        row5.addView(thumbviewbrand14, rlp);
        row5.addView(thumbviewbrand15, rlp);

        TableRow row6 = (TableRow) findViewById(R.id.brandrow2);
        thumbviewbrand21 = Utility.getThumnail(this, R.drawable.newcfix1,
                "C Fix", "");
        thumbviewbrand22 = Utility.getThumnail(this, R.drawable.newace,
                "Acenomorol", "");
        thumbviewbrand23 = Utility.getThumnail(this, R.drawable.newjade,
                "10 Jade dew", "");
        thumbviewbrand24 = Utility.getThumnail(this, R.drawable.newmezzo,
                "Mezzo drop", "");
        thumbviewbrand25 = Utility.getThumnail(this, R.drawable.newjade,
                "Still Sep", "");

        row6.addView(thumbviewbrand21, rlp);
        row6.addView(thumbviewbrand22, rlp);
        row6.addView(thumbviewbrand23, rlp);
        row6.addView(thumbviewbrand24, rlp);
        row6.addView(thumbviewbrand25, rlp);

        TableRow row7 = (TableRow) findViewById(R.id.rown3);
        th11 = Utility.getThumnail(this, R.drawable.chm1, "Symptoms", "");
        th12 = Utility.getThumnail(this, R.drawable.chm2, "Cure", "");
        th13 = Utility.getThumnail(this, R.drawable.chm3, "Dosage", "");
        th14 = Utility.getThumnail(this, R.drawable.chm4, "Cells", "");
        th15 = Utility.getThumnail(this, R.drawable.chm5, "Clinical Trial", "");

        row7.addView(th11, rlp);
        row7.addView(th12, rlp);
        row7.addView(th13, rlp);
        row7.addView(th14, rlp);
        row7.addView(th15, rlp);

        TableRow row8 = (TableRow) findViewById(R.id.rown33);
        th21 = Utility.getThumnail(this, R.drawable.chm6, "Treatment", "");
        th22 = Utility.getThumnail(this, R.drawable.chm7, "Side Effects", "");
        th23 = Utility
                .getThumnail(this, R.drawable.chm2, "Palliative Care", "");
        th24 = Utility.getThumnail(this, R.drawable.chm4, "Control", "");
        th25 = Utility.getThumnail(this, R.drawable.chm5, "Precaution", "");

        row8.addView(th21, rlp);
        row8.addView(th22, rlp);
        row8.addView(th23, rlp);
        row8.addView(th24, rlp);
        row8.addView(th25, rlp);

        TableRow row9 = (TableRow) findViewById(R.id.rown4);
        th31 = Utility.getThumnail(this, R.drawable.im1, "Clinical Trial", "");
        th32 = Utility.getThumnail(this, R.drawable.im2, "Precaution", "");
        th33 = Utility.getThumnail(this, R.drawable.im3, "Side Effects", "");
        th34 = Utility.getThumnail(this, R.drawable.im4, "Cure", "");
        th35 = Utility.getThumnail(this, R.drawable.im5, "Palliative Care", "");

        row9.addView(th31, rlp);
        row9.addView(th32, rlp);
        row9.addView(th33, rlp);
        row9.addView(th34, rlp);
        row9.addView(th35, rlp);

        TableRow row10 = (TableRow) findViewById(R.id.rown44);
        th41 = Utility.getThumnail(this, R.drawable.im6, "Dosage", "");
        th42 = Utility.getThumnail(this, R.drawable.im7, "Cells", "");
        th43 = Utility.getThumnail(this, R.drawable.im4, "Clinical Trial", "");
        th44 = Utility.getThumnail(this, R.drawable.im2, "Ignorance", "");
        th45 = Utility.getThumnail(this, R.drawable.im5, "FAQ", "");

        row10.addView(th41, rlp);
        row10.addView(th42, rlp);
        row10.addView(th43, rlp);
        row10.addView(th44, rlp);
        row10.addView(th45, rlp);

        TableRow row11 = (TableRow) findViewById(R.id.services1);
        thumbnailsr11 = Utility
                .getThumnail(this, R.drawable.ser1, "Pharma", "");
        thumbnailsr12 = Utility.getThumnail(this, R.drawable.ser3, "Mezzodrop",
                "");
        thumbnailsr13 = Utility.getThumnail(this, R.drawable.ser3, "Mezzodrop",
                "");
        thumbnailsr14 = Utility.getThumnail(this, R.drawable.mezom1,
                "Mezzodrop", "");
        thumbnailsr15 = Utility.getThumnail(this, R.drawable.mezom1,
                "Mezzodrop", "");

        row11.addView(thumbnailsr11, rlp);
        row11.addView(thumbnailsr12, rlp);
        row11.addView(thumbnailsr13, rlp);
        row11.addView(thumbnailsr14, rlp);
        row11.addView(thumbnailsr15, rlp);

        TableRow row12 = (TableRow) findViewById(R.id.services2);
        thumbnailsr21 = Utility.getThumnail(this, R.drawable.newcfix2,
                "Fade Pill", "Treatments");
        thumbnailsr22 = Utility.getThumnail(this, R.drawable.newcfix2,
                "Fade Pill", "Treatments");
        thumbnailsr23 = Utility.getThumnail(this, R.drawable.newcfix2,
                "Fade Pill", "Treatments");
        thumbnailsr24 = Utility.getThumnail(this, R.drawable.newcfix2,
                "Fade Pill", "Treatments");
        thumbnailsr25 = Utility.getThumnail(this, R.drawable.newcfix2,
                "Fade Pill", "Treatments");

        row12.addView(thumbnailsr21, rlp);
        row12.addView(thumbnailsr22, rlp);
        row12.addView(thumbnailsr23, rlp);
        row12.addView(thumbnailsr24, rlp);
        row12.addView(thumbnailsr25, rlp);

        specialty = (TextView) findViewById(R.id.specialty);
        brand = (TextView) findViewById(R.id.brands);
        therapy = (TextView) findViewById(R.id.therapy);
        Servicesheader = (TextView) findViewById(R.id.services);

        playlistnew = (TextView) findViewById(R.id.playlistnew);
        playlistnew.setOnClickListener(olc);

        playlistHeader = (TextView) findViewById(R.id.playlist1);
        brandHeader = (TextView) findViewById(R.id.brandName1);
        scroller = (ScrollView) findViewById(R.id.scroll);

        viewsamplednew = findViewById(R.id.viewsamplednew);
        view1 = findViewById(R.id.viewsampled);
        view2 = findViewById(R.id.viewsamplech);
        view3 = findViewById(R.id.viewsamplest);
        view4 = findViewById(R.id.viewsservices);
        brandlin = (LinearLayout) findViewById(R.id.linselctionbrand);

        specialty.setOnClickListener(olc);

        therapy.setOnClickListener(olc);

        brand.setOnClickListener(olc);
        Servicesheader.setOnClickListener(olc);

        // /scroller
        myrel2 = (RelativeLayout) findViewById(R.id.myrel2);
        myrel3 = (RelativeLayout) findViewById(R.id.myrel3);
        myrel4 = (RelativeLayout) findViewById(R.id.myrel4);
        myrel6 = (RelativeLayout) findViewById(R.id.myrel6);

        playlisrel = (RelativeLayout) findViewById(R.id.playlisrel);

        brand11view = findViewById(R.id.brand11view);
        brand12view = findViewById(R.id.brand12view);
        brand11 = (TextView) findViewById(R.id.brand11);
        brand12 = (TextView) findViewById(R.id.brand12);

        brand11.setOnClickListener(olc);
        brand12.setOnClickListener(olc);

        try {
            if (type.equals("seg")) {
                playlistnew.setVisibility(View.GONE);
                viewsamplednew.setVisibility(View.GONE);

                specialty.setText("SEGMENT");
                specialty.setTypeface(null, Typeface.BOLD);
                view1.setVisibility(View.VISIBLE);
                playlisrel.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SearchView searchView = new SearchView(getActionBar()
                .getThemedContext());
        int searchIconId = searchView.getContext().getResources()
                .getIdentifier("android:id/search_button", null, null);
        ImageView searchIcon = (ImageView) searchView
                .findViewById(searchIconId);
        searchIcon.setImageResource(R.drawable.ic_action_search);

        searchView.setQueryHint("Enter Text");
        searchView.setOnQueryTextListener(new OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub
                if (newText.startsWith("mez")) {
                    RelativeLayout rl = (RelativeLayout) thumbview1
                            .getChildAt(2);
                    TextView tv = (TextView) rl.getChildAt(0);
                    tv.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl1 = (RelativeLayout) thumbview2
                            .getChildAt(2);
                    TextView tv1 = (TextView) rl1.getChildAt(0);
                    tv1.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl2 = (RelativeLayout) thumbview188
                            .getChildAt(2);
                    TextView tv2 = (TextView) rl2.getChildAt(0);
                    tv2.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl3 = (RelativeLayout) thumbview288
                            .getChildAt(2);
                    TextView tv3 = (TextView) rl3.getChildAt(0);
                    tv3.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl4 = (RelativeLayout) thumbview388
                            .getChildAt(2);
                    TextView tv4 = (TextView) rl4.getChildAt(0);
                    tv4.setBackgroundColor(Color.YELLOW);
                    thumbview1.setVisibility(View.GONE);
                    thumbview2.setVisibility(View.GONE);
                    thumbview3.setVisibility(View.GONE);
                    thumbview4.setVisibility(View.GONE);
                    thumbview5.setVisibility(View.GONE);
                    thumbview388.setVisibility(View.VISIBLE);
                    thumbview188.setVisibility(View.GONE);
                    thumbview288.setVisibility(View.GONE);
                    thumbview488.setVisibility(View.GONE);
                    thumbview588.setVisibility(View.GONE);
                } else if (newText.contains("fix")) {
                    RelativeLayout rl = (RelativeLayout) thumbview1
                            .getChildAt(2);
                    TextView tv = (TextView) rl.getChildAt(0);
                    tv.setBackgroundColor(Color.YELLOW);
                    RelativeLayout rl1 = (RelativeLayout) thumbview2
                            .getChildAt(2);
                    TextView tv1 = (TextView) rl1.getChildAt(0);
                    tv1.setBackgroundColor(Color.YELLOW);
                    RelativeLayout rl2 = (RelativeLayout) thumbview188
                            .getChildAt(2);
                    TextView tv2 = (TextView) rl2.getChildAt(0);
                    tv2.setBackgroundColor(Color.YELLOW);
                    RelativeLayout rl3 = (RelativeLayout) thumbview288
                            .getChildAt(2);
                    TextView tv3 = (TextView) rl3.getChildAt(0);
                    tv3.setBackgroundColor(Color.YELLOW);
                    RelativeLayout rl4 = (RelativeLayout) thumbview388
                            .getChildAt(2);
                    TextView tv4 = (TextView) rl4.getChildAt(0);
                    tv4.setBackgroundColor(Color.TRANSPARENT);
                    thumbview1.setVisibility(View.VISIBLE);
                    thumbview2.setVisibility(View.VISIBLE);
                    thumbview3.setVisibility(View.GONE);
                    thumbview4.setVisibility(View.GONE);
                    thumbview5.setVisibility(View.GONE);
                    thumbview188.setVisibility(View.VISIBLE);
                    thumbview288.setVisibility(View.VISIBLE);
                    thumbview388.setVisibility(View.GONE);
                    thumbview488.setVisibility(View.GONE);
                    thumbview588.setVisibility(View.GONE);
                } else {
                    RelativeLayout rl = (RelativeLayout) thumbview1
                            .getChildAt(2);
                    TextView tv = (TextView) rl.getChildAt(0);
                    tv.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl1 = (RelativeLayout) thumbview2
                            .getChildAt(2);
                    TextView tv1 = (TextView) rl1.getChildAt(0);
                    tv1.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl2 = (RelativeLayout) thumbview188
                            .getChildAt(2);
                    TextView tv2 = (TextView) rl2.getChildAt(0);
                    tv2.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl3 = (RelativeLayout) thumbview288
                            .getChildAt(2);
                    TextView tv3 = (TextView) rl3.getChildAt(0);
                    tv3.setBackgroundColor(Color.TRANSPARENT);
                    RelativeLayout rl4 = (RelativeLayout) thumbview388
                            .getChildAt(2);
                    TextView tv4 = (TextView) rl4.getChildAt(0);
                    tv4.setBackgroundColor(Color.TRANSPARENT);
                    thumbview1.setVisibility(View.VISIBLE);
                    thumbview2.setVisibility(View.VISIBLE);
                    thumbview3.setVisibility(View.VISIBLE);
                    thumbview4.setVisibility(View.VISIBLE);
                    thumbview5.setVisibility(View.VISIBLE);
                    thumbview188.setVisibility(View.VISIBLE);
                    thumbview288.setVisibility(View.VISIBLE);
                    thumbview388.setVisibility(View.VISIBLE);
                    thumbview488.setVisibility(View.VISIBLE);
                    thumbview588.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        menu.add(Menu.NONE, R.drawable.ic_zoom_in_white_48dp, 1, "Search")
                .setIcon(R.drawable.ic_zoom_in_white_48dp)
                .setActionView(searchView)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);

        }
        return true;
    }

    OnClickListener olc = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {

                case R.id.playlistnew:
                    brandlin.setVisibility(View.GONE);
                    scroller.scrollTo(playlistHeader.getLeft(),
                            playlistHeader.getTop());
                    viewsamplednew.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);
                    view3.setVisibility(View.GONE);
                    view4.setVisibility(View.GONE);
                    playlistnew.setTypeface(null, Typeface.BOLD);
                    specialty.setTypeface(null, Typeface.NORMAL);
                    brand.setTypeface(null, Typeface.NORMAL);
                    therapy.setTypeface(null, Typeface.NORMAL);
                    Servicesheader.setTypeface(null, Typeface.NORMAL);
                    break;
                case R.id.specialty:
                    brandlin.setVisibility(View.GONE);
                    scroller.scrollTo(playlistHeader.getLeft(),
                            playlistHeader.getTop());

                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.GONE);
                    view3.setVisibility(View.GONE);
                    view4.setVisibility(View.GONE);
                    viewsamplednew.setVisibility(View.GONE);
                    playlistnew.setTypeface(null, Typeface.NORMAL);
                    specialty.setTypeface(null, Typeface.BOLD);
                    brand.setTypeface(null, Typeface.NORMAL);
                    therapy.setTypeface(null, Typeface.NORMAL);
                    Servicesheader.setTypeface(null, Typeface.NORMAL);
                    break;

                case R.id.brands:
                    brandlin.setVisibility(View.GONE);

                    brandlin.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.VISIBLE);
                    view3.setVisibility(View.GONE);
                    viewsamplednew.setVisibility(View.GONE);
                    view4.setVisibility(View.GONE);
                    scroller.scrollTo(myrel2.getLeft(), myrel2.getTop());
                    playlistnew.setTypeface(null, Typeface.NORMAL);
                    specialty.setTypeface(null, Typeface.NORMAL);
                    brand.setTypeface(null, Typeface.BOLD);
                    therapy.setTypeface(null, Typeface.NORMAL);
                    Servicesheader.setTypeface(null, Typeface.NORMAL);
                    break;

                case R.id.therapy:
                    brandlin.setVisibility(View.GONE);
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);
                    view3.setVisibility(View.VISIBLE);
                    view4.setVisibility(View.GONE);
                    viewsamplednew.setVisibility(View.GONE);
                    scroller.scrollTo(myrel4.getLeft(), myrel4.getTop());
                    playlistnew.setTypeface(null, Typeface.NORMAL);
                    specialty.setTypeface(null, Typeface.NORMAL);
                    brand.setTypeface(null, Typeface.NORMAL);
                    therapy.setTypeface(null, Typeface.BOLD);
                    Servicesheader.setTypeface(null, Typeface.NORMAL);
                    break;

                case R.id.services:
                    brandlin.setVisibility(View.GONE);
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);
                    view4.setVisibility(View.VISIBLE);
                    view3.setVisibility(View.GONE);
                    viewsamplednew.setVisibility(View.GONE);
                    scroller.scrollTo(myrel6.getLeft(), myrel6.getTop());
                    playlistnew.setTypeface(null, Typeface.NORMAL);
                    specialty.setTypeface(null, Typeface.NORMAL);
                    brand.setTypeface(null, Typeface.NORMAL);
                    therapy.setTypeface(null, Typeface.NORMAL);
                    Servicesheader.setTypeface(null, Typeface.BOLD);
                    break;

                case R.id.brand11:
                    brand11.setTypeface(null, Typeface.BOLD);
                    brand12.setTypeface(null, Typeface.NORMAL);
                    brand11view.setVisibility(View.VISIBLE);
                    brand12view.setVisibility(View.GONE);
                    scroller.scrollTo(myrel2.getLeft(), myrel2.getTop());
                    break;

                case R.id.brand12:
                    brand11.setTypeface(null, Typeface.NORMAL);
                    brand12.setTypeface(null, Typeface.BOLD);
                    brand11view.setVisibility(View.GONE);
                    brand12view.setVisibility(View.VISIBLE);

                    scroller.scrollTo(myrel3.getLeft(), myrel3.getTop());
                    break;

                default:
                    break;
            }
        }
    };
}
