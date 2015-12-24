package com.cirrius.iclmcipla;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.iclm.util.MenuforThreedot;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Physicians extends Activity {
    Typeface font;
    TextView tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8, tab9, tab10, tab12;
    View tab11, tab22, tab33, tab44, tab55, tab66, tab77, tab88, tab99, tab100, tab120;

    CustomScrollView physiScroll;
    public static HorizontalScrollView scroll;
    LinearLayout mainLinear;
    public static RelativeLayout relative;
    public static LinearLayout linselction;
    public static TextView textview;
    public static int showHide = 0;

    Calendar myCalendar = Calendar.getInstance();
    EditText edittextDuedate;
    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4};

    final String[] Drname = {"Alan Spiegel", "Alexander Fleming",
            "Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk"};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Class B", "Class A", "Class C", "Class C", "Class B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Utility.setactoinbart(getActionBar(), this, font, "Customers");
        setContentView(R.layout.physi);
        TextView threedot = (TextView) findViewById(R.id.threedot);
        threedot.setTypeface(font);
        threedot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                MenuforThreedot menuforThreedot = new MenuforThreedot(
                        Physicians.this);
                Dialog dialog_box = menuforThreedot.menudialog();

                Window window = dialog_box.getWindow();
                WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                        .getAttributes();
                int[] viewLocation = new int[2];
                v.getLocationOnScreen(viewLocation);
                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                wmlp.x = viewLocation[0];
                wmlp.y = viewLocation[1];
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(450, 570);
                dialog_box.show();
            }
        });
        TextView next = (TextView) findViewById(R.id.next);
        next.setTypeface(font);
        TextView map = (TextView) findViewById(R.id.map);
        map.setTypeface(font);

        Bundle bundle = new Bundle();
        bundle.putString("index", "1");
        Fragment fragment = new PlaylistFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment.setArguments(bundle);
        ft.add(R.id.mainfrag, fragment);
        ft.commit();

        textview = (TextView) findViewById(R.id.textview);

        linselction = (LinearLayout) findViewById(R.id.linselction);

        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tab3 = (TextView) findViewById(R.id.tab3);
        tab4 = (TextView) findViewById(R.id.tab4);
        tab5 = (TextView) findViewById(R.id.tab5);
        tab6 = (TextView) findViewById(R.id.tab6);
        tab7 = (TextView) findViewById(R.id.tab7);
        tab8 = (TextView) findViewById(R.id.tab8);
        tab9 = (TextView) findViewById(R.id.tab9);
        tab10 = (TextView) findViewById(R.id.tab10);
        tab12 = (TextView) findViewById(R.id.tab12);

        tab11 = (View) findViewById(R.id.tab11);
        tab22 = (View) findViewById(R.id.tab22);
        tab33 = (View) findViewById(R.id.tab33);
        tab44 = (View) findViewById(R.id.tab44);
        tab55 = (View) findViewById(R.id.tab55);
        tab66 = (View) findViewById(R.id.tab66);
        tab77 = (View) findViewById(R.id.tab77);
        tab88 = (View) findViewById(R.id.tab88);
        tab99 = (View) findViewById(R.id.tab99);
        tab100 = (View) findViewById(R.id.tab100);
        tab120 = (View) findViewById(R.id.tab120);

        tab1.setOnClickListener(olc);
        tab2.setOnClickListener(olc);
        tab3.setOnClickListener(olc);
        tab4.setOnClickListener(olc);
        tab5.setOnClickListener(olc);
        tab6.setOnClickListener(olc);
        tab7.setOnClickListener(olc);
        tab8.setOnClickListener(olc);
        tab9.setOnClickListener(olc);
        tab10.setOnClickListener(olc);
        tab12.setOnClickListener(olc);

        physiScroll = (CustomScrollView) findViewById(R.id.physiscroll);
        scroll = (HorizontalScrollView) findViewById(R.id.scroll);
        mainLinear = (LinearLayout) findViewById(R.id.mainfrag);
        relative = (RelativeLayout) findViewById(R.id.relative);
        physiScroll.scrollTo(0, 0);
    }

    OnClickListener olc = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            View view;
            int x;
            int y;
            LinearLayout linear = (LinearLayout) mainLinear.getChildAt(0);
            switch (v.getId()) {
                case R.id.tab1:
                    tab1.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab12.setTextColor(Color.parseColor("#808080"));

                    tab1.setTypeface(null, Typeface.BOLD);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab12.setTypeface(null, Typeface.NORMAL);

                    tab11.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);
                    tab100.setVisibility(View.INVISIBLE);
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("PLAYLIST");
                    view = linear.getChildAt(0);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y);
                    break;
                case R.id.tab2:
                    tab2.setTextColor(Color.parseColor("#000000"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.BOLD);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab22.setVisibility(View.VISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("HISTORY");
                    view = linear.getChildAt(1);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 74);

                    break;

                case R.id.tab3:
                    tab3.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.BOLD);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab33.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("ACTION POINTS");
                    view = linear.getChildAt(2);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 74);
                    break;

                case R.id.tab4:
                    tab4.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.BOLD);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab44.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    break;

                case R.id.tab5:
                    tab5.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.BOLD);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab55.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    break;

                case R.id.tab6:
                    tab6.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.BOLD);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab66.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("CAMPAIGN");
                    view = linear.getChildAt(3);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 74);
                    break;

                case R.id.tab7:
                    tab7.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.BOLD);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab77.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("PROFILE");
                    view = linear.getChildAt(4);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 64);
                    break;

                case R.id.tab8:
                    tab8.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.BOLD);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab88.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab99.setVisibility(View.INVISIBLE);
                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);

                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("CONNECT");
                    view = linear.getChildAt(5);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 74);
                    break;

                case R.id.tab9:
                    tab9.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.BOLD);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab99.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#808080"));
                    tab100.setVisibility(View.INVISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("FOCUS BRANDS");
                    view = linear.getChildAt(6);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 74);
                    break;
                case R.id.tab10:
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.BOLD);
                    tab99.setVisibility(View.INVISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);

                    tab10.setTextColor(Color.parseColor("#000000"));
                    tab100.setVisibility(View.VISIBLE);
                    tab12.setTextColor(Color.parseColor("#808080"));
                    tab120.setVisibility(View.INVISIBLE);

                    textview.setText("PRESCRIPTION");
                    view = linear.getChildAt(7);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 74);
                    break;
                case R.id.tab12:
                    tab9.setTextColor(Color.parseColor("#808080"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab5.setTextColor(Color.parseColor("#808080"));
                    tab6.setTextColor(Color.parseColor("#808080"));
                    tab7.setTextColor(Color.parseColor("#808080"));
                    tab8.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab10.setTextColor(Color.parseColor("#808080"));

                    tab1.setTypeface(null, Typeface.NORMAL);
                    tab2.setTypeface(null, Typeface.NORMAL);
                    tab3.setTypeface(null, Typeface.NORMAL);
                    tab4.setTypeface(null, Typeface.NORMAL);
                    tab5.setTypeface(null, Typeface.NORMAL);
                    tab6.setTypeface(null, Typeface.NORMAL);
                    tab7.setTypeface(null, Typeface.NORMAL);
                    tab8.setTypeface(null, Typeface.NORMAL);
                    tab9.setTypeface(null, Typeface.NORMAL);
                    tab10.setTypeface(null, Typeface.NORMAL);
                    tab12.setTypeface(null, Typeface.BOLD);

                    tab99.setVisibility(View.INVISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    tab55.setVisibility(View.INVISIBLE);
                    tab66.setVisibility(View.INVISIBLE);
                    tab77.setVisibility(View.INVISIBLE);
                    tab88.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab100.setVisibility(View.INVISIBLE);

                    tab12.setTextColor(Color.parseColor("#000000"));
                    tab120.setVisibility(View.VISIBLE);

                    textview.setText("OTHER BU VISITS");
                    view = linear.getChildAt(8);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 74);
                    break;
                default:
                    break;
            }
        }
    };

    public void set(int show) {
        showHide = show;
        if (showHide == 0) {
            if (relative != null) {
                // relative.setVisibility(View.VISIBLE);

                LayoutParams lp = (LayoutParams) relative.getLayoutParams();
                if (lp.topMargin == -70) {
                    LayoutParams param = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT, 65);
                    param.bottomMargin = 10;
                    param.topMargin = 10;
                    param.leftMargin = 10;
                    param.rightMargin = 10;
                    relative.setLayoutParams(param);
                }
            }

        } else if (showHide == 1) {
            if (relative != null) {
                // relative.setVisibility(View.GONE);
                // LayoutParams param = new RelativeLayout.LayoutParams(0, 0);
                // relative.setLayoutParams(param);
                LayoutParams lp = (LayoutParams) relative.getLayoutParams();
                if (lp.topMargin == 10) {
                    LayoutParams param = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT, 65);
                    param.bottomMargin = 10;
                    param.topMargin = -70;
                    param.leftMargin = 10;
                    param.rightMargin = 10;

                    relative.setLayoutParams(param);
                }
            }
        }

    }

    public void changeHeader(int index) {
        if (index > 2)
            index = index + 2;
        RelativeLayout rl = (RelativeLayout) linselction.getChildAt(index);
        String header = ((TextView) rl.getChildAt(0)).getText().toString();

        // if (header.equalsIgnoreCase("ACTION POINTS")) {
        // plus.setVisibility(View.VISIBLE);
        // history.setVisibility(View.VISIBLE);
        // } else {
        // plus.setVisibility(View.INVISIBLE);
        // history.setVisibility(View.INVISIBLE);
        // }
        if (header.equalsIgnoreCase("PLAYLIST")) {
            int x = rl.getLeft();
            int y = rl.getTop();
            scroll.scrollTo(x, y);

        }
        if (header.equalsIgnoreCase("PRESCRIPTION")) {
            int x = rl.getRight();
            int y = rl.getTop();
            scroll.scrollTo(x, y);
        }

        textview.setText(header);
        for (int i = 0; i < linselction.getChildCount(); i++) {
            RelativeLayout relative = (RelativeLayout) linselction
                    .getChildAt(i);
            if (index == i) {
                ((TextView) relative.getChildAt(0)).setTypeface(null,
                        Typeface.BOLD);
                ((TextView) relative.getChildAt(0)).setTextColor(Color
                        .parseColor("#000000"));
                relative.getChildAt(2).setVisibility(View.VISIBLE);
            } else {
                ((TextView) relative.getChildAt(0)).setTypeface(null,
                        Typeface.NORMAL);
                ((TextView) relative.getChildAt(0)).setTextColor(Color
                        .parseColor("#808080"));
                relative.getChildAt(2).setVisibility(View.INVISIBLE);
            }
        }
    }

    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

        private void updateLabel() {
            // TODO Auto-generated method stub
            String myFormat = "MM/dd/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            edittextDuedate.setText(sdf.format(myCalendar.getTime()));
        }

    };

    public class MyAdapterforspinner extends ArrayAdapter<String> {

        Context context;

        public MyAdapterforspinner(Context ctx, int txtViewResourceId,
                                   String[] objects) {
            super(ctx, txtViewResourceId, objects);
            this.context = ctx;
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exrow_third, null);

            TextView mItemName = (TextView) convertView
                    .findViewById(R.id.eventsListEventRowText);

            TextView mItemTime = (TextView) convertView.findViewById(R.id.time);

            ImageView drImageView = (ImageView) convertView
                    .findViewById(R.id.dr_image);
            TextView mItemPrice = (TextView) convertView
                    .findViewById(R.id.textViewItemPrice);

            TextView childtextview3 = (TextView) convertView
                    .findViewById(R.id.childtextview3);

            TextView menufordr = (TextView) convertView
                    .findViewById(R.id.menufordr);
            menufordr.setVisibility(View.GONE);

            drImageView.setImageResource(imageDoctor[position]);
            mItemTime.setText(strTime[position]);
            mItemName.setText(Drname[position]);
            mItemPrice.setText(Specialty[position]);
            childtextview3.setText(Class[position]);

            return convertView;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
