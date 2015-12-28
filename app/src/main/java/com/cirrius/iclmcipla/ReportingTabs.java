package com.cirrius.iclmcipla;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cirrius.expand.Expandablelistviewfordoc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ReportingTabs extends Activity implements DateInterface {
    Typeface font;
    TextView tab1, tab2, tab3, tab4;
    View tab11, tab22, tab33, tab44;
    public static TextView textview;
    Dialog dialog_box, dialog;
    int count = 0;
    private LinearLayout mainLinear;
    private CustomScrollViewReporting physiScroll;
    public static LinearLayout linselctionforreporting;

    Calendar myCalendar = Calendar.getInstance();
    TextView dateView;
    TextView clickedTextView;
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
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Reporting");
        setContentView(R.layout.reporting_tabs);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            index = bundle.getInt("index");

//        Expandablelistviewfordoc list = new Expandablelistviewfordoc(
//                ReportingTabs.this, 29, 1);
        Expandablelistviewfordoc list = new Expandablelistviewfordoc(
                ReportingTabs.this, 96, 1);
        View v = list.multilevleexpandalelistview(2);
        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
        rl1.addView(v);


        Fragment fragment = new ReportingFragment();
        FragmentManager fm = getFragmentManager();
        Bundle bundleNew = new Bundle();
        bundleNew.putInt("index", index);
        fragment.setArguments(bundleNew);
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.mainfragforreporting, fragment);
        ft.commit();
        TextView prev = (TextView) findViewById(R.id.prev);
        TextView next = (TextView) findViewById(R.id.next);
        prev.setTypeface(font);
        next.setTypeface(font);
        TextView done1 = (TextView) findViewById(R.id.done);
        done1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box = new Dialog(ReportingTabs.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.secondwala);
                TextView close = (TextView) dialog_box
                        .findViewById(R.id.close);
                close.setTypeface(font);
                close.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dialog_box.dismiss();
                    }
                });
                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(400, 300);
                dialog_box.show();
                TextView yes = (TextView) dialog_box.findViewById(R.id.yes);
                yes.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(ReportingTabs.this,
                                Reporting.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                TextView cancel = (TextView) dialog_box
                        .findViewById(R.id.cancel);
                cancel.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog_box.dismiss();
                    }
                });

            }
        });
//        TextView cancel = (TextView) findViewById(R.id.cancel);
//        cancel.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                dialog_box = new Dialog(ReportingTabs.this);
//                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog_box.setContentView(R.layout.secondwala);
//                TextView close = (TextView) dialog_box
//                        .findViewById(R.id.close);
//                TextView d1 = (TextView) dialog_box
//                        .findViewById(R.id.d1);
//                d1.setVisibility(View.GONE);
//
//                TextView d2 = (TextView) dialog_box
//                        .findViewById(R.id.d2);
//                d2.setText("Are You Sure You Want To Cancel ?");
//                close.setTypeface(font);
//                close.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        dialog_box.dismiss();
//                    }
//                });
//                Window window = dialog_box.getWindow();
//                window.setBackgroundDrawable(new ColorDrawable(
//                        Color.TRANSPARENT));
//                dialog_box.getWindow().setLayout(400, 300);
//                dialog_box.show();
//                TextView yes = (TextView) dialog_box.findViewById(R.id.yes);
//                yes.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        // TODO Auto-generated method stub
//                        Intent intent = new Intent(ReportingTabs.this,
//                                Reporting.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
//                    }
//                });
//                TextView cancel = (TextView) dialog_box
//                        .findViewById(R.id.cancel);
//                cancel.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        // TODO Auto-generated method stub
//                        dialog_box.dismiss();
//                    }
//                });
//
//            }
//        });
        TextView sne = (TextView) findViewById(R.id.sne);
        sne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportingTabs.this, Reporting.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        textview = (TextView) findViewById(R.id.textview);

        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tab3 = (TextView) findViewById(R.id.tab3);
        tab4 = (TextView) findViewById(R.id.tab4);

        if (index == 2) {
            tab2.setText("INPUTS");
            tab4.setText("PRESCRIPTION");
        }

        tab11 = (View) findViewById(R.id.tab11);
        tab22 = (View) findViewById(R.id.tab22);
        tab33 = (View) findViewById(R.id.tab33);
        tab44 = (View) findViewById(R.id.tab44);

        tab1.setOnClickListener(olc);
        tab2.setOnClickListener(olc);
        tab3.setOnClickListener(olc);
        tab4.setOnClickListener(olc);

        physiScroll = (CustomScrollViewReporting) findViewById(R.id.reportingscroll);
        mainLinear = (LinearLayout) findViewById(R.id.mainfragforreporting);
        linselctionforreporting = (LinearLayout) findViewById(R.id.baapofallthetab);

        textview.setText("VISIT DETAILS");
        tab22.setVisibility(View.INVISIBLE);
        tab2.setTypeface(null, Typeface.NORMAL);
        tab2.setTextColor(Color.parseColor("#808080"));

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
                    tab11.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    textview.setText("VISIT DETAILS");
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
                    tab22.setVisibility(View.VISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    if (index == 2)
                        textview.setText("INPUTS");
                    else
                        textview.setText("SAMPLING");
                    view = linear.getChildAt(1);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 60);
                    break;

                case R.id.tab3:
                    tab3.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab4.setTextColor(Color.parseColor("#808080"));
                    tab33.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    tab44.setVisibility(View.INVISIBLE);
                    textview.setText("DETAILING");
                    view = linear.getChildAt(2);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 50);
                    break;

                case R.id.tab4:
                    tab4.setTextColor(Color.parseColor("#000000"));
                    tab2.setTextColor(Color.parseColor("#808080"));
                    tab3.setTextColor(Color.parseColor("#808080"));
                    tab1.setTextColor(Color.parseColor("#808080"));
                    tab44.setVisibility(View.VISIBLE);
                    tab22.setVisibility(View.INVISIBLE);
                    tab33.setVisibility(View.INVISIBLE);
                    tab11.setVisibility(View.INVISIBLE);
                    if (index == 2)
                        textview.setText("PRESCRIPTION");
                    else
                        textview.setText("ACTION POINTS");
                    view = linear.getChildAt(3);
                    x = view.getLeft();
                    y = view.getTop();
                    physiScroll.scrollTo(x, y + 50);
                    break;

                default:
                    break;
            }
        }
    };

    public void changeHeader(int index) {

        RelativeLayout rl = (RelativeLayout) linselctionforreporting.getChildAt(index);
        String header = ((TextView) rl.getChildAt(0)).getText().toString();
        textview.setText(header);
        for (int i = 0; i < linselctionforreporting.getChildCount(); i++) {
            RelativeLayout relative = (RelativeLayout) linselctionforreporting
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
            String myFormat = "dd/MM/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            dateView.setText(sdf.format(myCalendar.getTime()));
        }

    };

    @Override
    public void setDateToView(Calendar c) {

    }

    @Override
    public void setTimeToView(Calendar c) {
        clickedTextView.setText(DateFormat.format("h:mm a", c));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, R.drawable.cancel12, 1, "").setIcon(R.drawable.cancel12)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.drawable.cancel12:
                dialog_box = new Dialog(ReportingTabs.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.secondwala);
                TextView close = (TextView) dialog_box
                        .findViewById(R.id.close);
                TextView d1 = (TextView) dialog_box
                        .findViewById(R.id.d1);
                d1.setVisibility(View.GONE);

                TextView d2 = (TextView) dialog_box
                        .findViewById(R.id.d2);
                d2.setText("Are You Sure You Want To Cancel ?");
                close.setTypeface(font);
                close.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dialog_box.dismiss();
                    }
                });
                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(400, 300);
                dialog_box.show();
                TextView yes = (TextView) dialog_box.findViewById(R.id.yes);
                yes.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(ReportingTabs.this,
                                Reporting.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                TextView cancel = (TextView) dialog_box
                        .findViewById(R.id.cancel);
                cancel.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog_box.dismiss();
                    }
                });
                return true;
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