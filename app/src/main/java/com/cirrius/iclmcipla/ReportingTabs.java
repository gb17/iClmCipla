package com.cirrius.iclmcipla;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
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
import android.text.format.DateFormat;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.iclm.util.MenuforThreedot;

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
    public static int showHide = 0;
    public static RelativeLayout relative;
    public static LinearLayout linselction;
    ImageView jointwork;
    TextView jointwork_name;
    TextView timeView, timeView2;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Reporting");
        setContentView(R.layout.reporting_tabs);
        TextView threedot = (TextView) findViewById(R.id.threedot);
        threedot.setTypeface(font);
        TextView tp11 = (TextView) findViewById(R.id.textcalender);
        TextView tp12 = (TextView) findViewById(R.id.textclock);
        TextView tp13 = (TextView) findViewById(R.id.textlocation);

        tp11.setTypeface(font);
        tp12.setTypeface(font);
        tp13.setTypeface(font);

        TextView textjcclinic = (TextView) findViewById(R.id.textjcclinic);
        textjcclinic.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog_box = new Dialog(ReportingTabs.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.thirdwala);
                TextView close = (TextView) dialog_box.findViewById(R.id.close);
                close.setTypeface(font);
                TextView location = (TextView) dialog_box
                        .findViewById(R.id.location);
                location.setTypeface(font);
                TextView clock = (TextView) dialog_box.findViewById(R.id.clock);
                clock.setTypeface(font);
                TextView calendar = (TextView) dialog_box
                        .findViewById(R.id.calendar);
                calendar.setTypeface(font);
                close.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog_box.dismiss();
                    }
                });
                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(580, 700);
                dialog_box.show();
                timeView = (TextView) dialog_box.findViewById(R.id.time);
                timeView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // show the time picker dialog
                        DialogFragment newFragment = new TimePickerFragment();
                        clickedTextView = timeView;
                        newFragment.show(getFragmentManager(), "timePicker");
                    }
                });
                timeView2 = (TextView) dialog_box.findViewById(R.id.time2);
                timeView2.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // show the time picker dialog
                        DialogFragment newFragment = new TimePickerFragment();
                        clickedTextView = timeView2;
                        newFragment.show(getFragmentManager(), "timePicker");
                    }
                });
                dateView = (TextView) dialog_box.findViewById(R.id.dateview);
                dateView.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub

                        new DatePickerDialog(ReportingTabs.this, date,
                                myCalendar.get(Calendar.YEAR), myCalendar
                                .get(Calendar.MONTH), myCalendar
                                .get(Calendar.DAY_OF_MONTH)).show();

                    }
                });
            }
        });

        TextView status = (TextView) findViewById(R.id.status);
        status.setTypeface(font);
        status.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog_box = new Dialog(ReportingTabs.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.fourthwala);
                TextView close = (TextView) dialog_box.findViewById(R.id.close);
                close.setTypeface(font);
                close.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog_box.dismiss();
                    }
                });
                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(580, 500);
                // dialog_box.getWindow().clearFlags(
                // WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog_box.show();
            }
        });

        threedot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MenuforThreedot menuforThreedot = new MenuforThreedot(
                        ReportingTabs.this);
                dialog_box = menuforThreedot.menudialog();

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

                // dialog_box = new Dialog(ReportingTabs.this);
                // dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                // dialog_box.setContentView(R.layout.addlist);
                //
                // RelativeLayout appointment = (RelativeLayout) dialog_box
                // .findViewById(R.id.appointment);
                // RelativeLayout leave = (RelativeLayout) dialog_box
                // .findViewById(R.id.leave);
                // RelativeLayout tot = (RelativeLayout) dialog_box
                // .findViewById(R.id.tot);
                // RelativeLayout todo = (RelativeLayout) dialog_box
                // .findViewById(R.id.todo);
                // TextView txt1 = (TextView)
                // dialog_box.findViewById(R.id.txt1);
                // TextView txt2 = (TextView)
                // dialog_box.findViewById(R.id.txt2);
                // TextView txt3 = (TextView)
                // dialog_box.findViewById(R.id.txt3);
                // TextView txt4 = (TextView)
                // dialog_box.findViewById(R.id.txt4);
                // txt1.setText("Edit Profile");
                // txt2.setText("Start Meeting");
                // txt3.setText("Locate");
                // txt4.setText("Geo Tag");
                //
                // // appointment.setOnClickListener(mylisten);
                // // leave.setOnClickListener(mylisten);
                // // tot.setOnClickListener(mylisten);
                // // todo.setOnClickListener(mylisten);
                //
                // Window window = dialog_box.getWindow();
                //
                // WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                // .getAttributes();
                //
                // wmlp.gravity = Gravity.TOP | Gravity.RIGHT;
                // wmlp.x = 40; // x position
                // wmlp.y = 80;
                // window.setBackgroundDrawable(new ColorDrawable(
                // Color.TRANSPARENT));
                // dialog_box.getWindow().setLayout(200, 250);
                // dialog_box.getWindow().clearFlags(
                // WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                // dialog_box.show();
            }
        });
        TextView next = (TextView) findViewById(R.id.next);
        next.setTypeface(font);
        TextView map = (TextView) findViewById(R.id.map);
        map.setTypeface(font);

        TextView jworking = (TextView) findViewById(R.id.jworking);
        jointwork_name = (TextView) findViewById(R.id.jointwork_name);
        jointwork = (ImageView) findViewById(R.id.jointwork);

        jworking.setOnClickListener(jointListener);
        jointwork_name.setOnClickListener(jointListener);
        jointwork_name.setVisibility(View.INVISIBLE);
        jointwork.setOnClickListener(jointListener);
        jointwork.setTag("1");

        Bundle bundle = new Bundle();
        bundle.putString("index", "2");
        Fragment fragment = new PlaylistFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment.setArguments(bundle);
        ft.add(R.id.mainfrag, fragment);
        ft.commit();

        textview = (TextView) findViewById(R.id.textview);

        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tab3 = (TextView) findViewById(R.id.tab3);
        tab4 = (TextView) findViewById(R.id.tab4);

        tab11 = (View) findViewById(R.id.tab11);
        tab22 = (View) findViewById(R.id.tab22);
        tab33 = (View) findViewById(R.id.tab33);
        tab44 = (View) findViewById(R.id.tab44);

        tab1.setOnClickListener(olc);
        tab2.setOnClickListener(olc);
        tab3.setOnClickListener(olc);
        tab4.setOnClickListener(olc);

        physiScroll = (CustomScrollViewReporting) findViewById(R.id.physiscroll);
        mainLinear = (LinearLayout) findViewById(R.id.mainfrag);
        relative = (RelativeLayout) findViewById(R.id.relative);
        linselction = (LinearLayout) findViewById(R.id.linselction);

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
                    textview.setText("DETAILING");
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
                    textview.setText("FEEDBACK");
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
    android.view.View.OnClickListener removeListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            LinearLayout ll = (LinearLayout) v.getParent();
            ll.setVisibility(View.GONE);
            count--;
        }
    };

    public void set(int show) {
        showHide = show;
        if (showHide == 0) {
            if (relative != null) {
                LayoutParams lp = (LayoutParams) relative.getLayoutParams();
                if (lp.topMargin == -155) {
                    LayoutParams param = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT, 152);
                    param.topMargin = 10;
                    param.leftMargin = 10;
                    param.rightMargin = 10;
                    relative.setLayoutParams(param);
                }
            }
        } else if (showHide == 1) {
            if (relative != null) {
                LayoutParams lp = (LayoutParams) relative.getLayoutParams();
                if (lp.topMargin == 10) {
                    LayoutParams param = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT, 152);
                    param.topMargin = -155;
                    param.leftMargin = 10;
                    param.rightMargin = 10;
                    relative.setLayoutParams(param);
                }
            }
        }

    }

    OnClickListener jointListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            dialog = new Dialog(ReportingTabs.this);
            dialog.getWindow();
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.joint_work);
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setCancelable(false);
            dialog.getWindow().setLayout(600, 370);
            dialog.show();
            final TextView doc1 = (TextView) dialog.findViewById(R.id.doc1);
            jointwork_name.setText("John Patrick[ASM] + 1");
            doc1.setTag("1");
            doc1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc1.getTag().equals("2")) {
                        doc1.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        jointwork_name.setText("John Patrick[ASM] + 1");
                        doc1.setTag("1");
                    } else {
                        doc1.setBackgroundResource(R.drawable.roundforlayout);
                        doc1.setTag("2");
                    }
                }
            });
            final TextView doc2 = (TextView) dialog.findViewById(R.id.doc2);
            doc2.setTag("2");
            doc2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc2.getTag().equals("1")) {
                        doc2.setBackgroundResource(R.drawable.roundforlayout);
                        doc2.setTag("2");
                    } else {
                        doc2.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        jointwork_name.setText("Alan Brown[RSM] + 1");
                        doc2.setTag("1");
                    }
                }
            });
            ImageView close = (ImageView) dialog.findViewById(R.id.close);
            ImageView donView = (ImageView) dialog.findViewById(R.id.done);
            EditText add = (EditText) dialog.findViewById(R.id.add);
            final LinearLayout ll1 = (LinearLayout) dialog
                    .findViewById(R.id.layout1);
            final LinearLayout ll2 = (LinearLayout) dialog
                    .findViewById(R.id.layout2);
            final LinearLayout ll3 = (LinearLayout) dialog
                    .findViewById(R.id.layout3);
            TextView text1 = (TextView) dialog.findViewById(R.id.closetxt1);
            TextView text2 = (TextView) dialog.findViewById(R.id.closetxt2);
            TextView text3 = (TextView) dialog.findViewById(R.id.closetxt3);
            text1.setOnClickListener(removeListener);
            text2.setOnClickListener(removeListener);
            text3.setOnClickListener(removeListener);

            add.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (count < 3)
                        count++;
                    if (count == 1) {
                        ll1.setVisibility(View.VISIBLE);
                    } else if (count == 2) {
                        ll2.setVisibility(View.VISIBLE);
                    } else if (count == 3) {
                        ll3.setVisibility(View.VISIBLE);
                    }
                }
            });

            close.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();
                }
            });
            donView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (doc1.getTag().equals("2") && doc2.getTag().equals("2")) {
                        jointwork.setImageResource(R.drawable.jointworking);
                        jointwork_name.setVisibility(View.INVISIBLE);
                    } else {
                        jointwork.setImageResource(R.drawable.jointworkingglow);
                        jointwork_name.setVisibility(View.VISIBLE);
                    }
                    dialog.dismiss();
                }
            });
        }
    };

    public void changeHeader(int index) {

        RelativeLayout rl = (RelativeLayout) linselction.getChildAt(index);
        String header = ((TextView) rl.getChildAt(0)).getText().toString();

        // if (header.equalsIgnoreCase("ACTION POINTS")) {
        // plus.setVisibility(View.VISIBLE);
        // history.setVisibility(View.VISIBLE);
        // } else {
        // plus.setVisibility(View.INVISIBLE);
        // history.setVisibility(View.INVISIBLE);
        // }
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
                // Intent intent = new Intent(this, DetailingLandingPage.class);
                // navigateUpTo(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
