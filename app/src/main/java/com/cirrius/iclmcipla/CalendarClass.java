package com.cirrius.iclmcipla;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.cirrius.animationlist.ListViewDraggingAnimation;
import com.cirrius.calender.listview.ExpandablelistviewfordocNEW;
import com.cirrius.iclmcipla.R;
import com.iclm.util.Viewgp;

public class CalendarClass extends Activity implements DateInterface {

    private Typeface font;
    private Dialog dialog_box;
    ListView lv;
    EditText editText;
    List<String[]> dataList = new ArrayList<String[]>();

    public static int srchflag = 0;

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine",
            "Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine",
            "Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Class B", "Class A", "Class C", "Class C", "Class B",
            "Class B", "Class A", "Class C", "Class C", "Class B", "Class B",
            "Class A", "Class C", "Class C", "Class B"};

    private String[] Drname = {"Mason Lopes", "Michael Jeremy", "Mike Gomez",
            "Michelle Cardoza", "Mabel D'costa", "Macaria D'souza",
            "Macra Dmello", "Macrina Colaco", "Madeleine Miles",
            "Madonna Pears", "Magda Mclachlan", "Magdalene Donavan",
            "Margaret Ricardo", "Maria Gonsalvez", "Macance Piers"};

    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};
    private EditText edittextDuedate;
    CustomAdapter adapter;

    Calendar myCalendar = Calendar.getInstance();

    private TextView sicklv;
    private TextView anl;
    private TextView sicklv1;
    private TextView sicklv2;
    private TextView sicklv3;
    private TextView sicklv4;
    private TextView sicklv5;
    private TextView sicklv6;
    private TextView sicklv7;
    private TextView addappointmentplus;
    private TextView menu;
    private TextView selall;
    private EditText serch;
    private ExpandablelistviewfordocNEW list;
    public static RelativeLayout rl1;
    public static View editTextForDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Calendar");
        setContentView(R.layout.calendar);
        // Expandablelistviewfordoc list = new Expandablelistviewfordoc(
        // CalendarClass.this, 22, 1);
        list = new ExpandablelistviewfordocNEW(CalendarClass.this, "", 2);
        View v = list.multilevleexpandalelistview();
        rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
        rl1.addView(v);

        addappointmentplus = (TextView) findViewById(R.id.addappointmentplus);
        addappointmentplus.setTypeface(font);

        selall = (TextView) findViewById(R.id.selall);
        selall.setTypeface(font);

        serch = (EditText) findViewById(R.id.serch);
        Utility.hideKeyboard(serch);

        serch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {

                rl1.removeAllViews();
                try {
                    if (srchflag == 0) {
                        if (!s.toString().trim().equals("")) {

                            list = new ExpandablelistviewfordocNEW(
                                    CalendarClass.this, s.toString(), 2);
                            View v = list.multilevleexpandalelistview();
                            rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
                            rl1.addView(v);
                        } else {
                            list = new ExpandablelistviewfordocNEW(
                                    CalendarClass.this, "", 2);
                            View v = list.multilevleexpandalelistview();
                            rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
                            rl1.addView(v);
                        }

                    } else if (srchflag == 1) {

                        if (!s.toString().trim().equals("")) {

                            list = new ExpandablelistviewfordocNEW(
                                    CalendarClass.this, s.toString(), 1);
                            View v = list.multilevleexpandalelistview();
                            rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
                            rl1.addView(v);
                        } else {
                            list = new ExpandablelistviewfordocNEW(
                                    CalendarClass.this, "", 1);
                            View v = list.multilevleexpandalelistview();
                            rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
                            rl1.addView(v);
                        }

                    }

                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });

        addappointmentplus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                calldialogugemenu(v);

            }
        });

        menu = (TextView) findViewById(R.id.menu);

        menu.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                threedotdialog(v);

            }
        });
        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.AUGUST, 19); // Year, month and day of month
        Date date = cal.getTime();
        HashSet<Date> events = new HashSet<>();
        events.add(date);

        CalendarView cv = ((CalendarView) findViewById(R.id.calendar_view));
        cv.updateCalendar(events);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        SearchView searchView = new SearchView(getActionBar()
                .getThemedContext());
        int searchIconId = searchView.getContext().getResources()
                .getIdentifier("android:id/search_button", null, null);
        ImageView searchIcon = (ImageView) searchView
                .findViewById(searchIconId);
        searchIcon.setImageResource(R.drawable.ic_action_search);
        searchView.setQueryHint("Enter Text");

        // menu.add(Menu.NONE, 130, 0, "Search")
        // .setIcon(R.drawable.ic_zoom_in_white_48dp)
        // .setActionView(searchView)
        // .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        // menu.add(Menu.NONE, R.drawable.plus, 1, "").setIcon(R.drawable.plus)
        // .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        //
        // menu.add(Menu.NONE, R.drawable.plus, 1, "").setIcon(R.drawable.plus)
        // .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.drawable.plus) {

            dialog_box = new Dialog(this);
            dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_box.setContentView(R.layout.addlist);

            RelativeLayout appointment = (RelativeLayout) dialog_box
                    .findViewById(R.id.appointment);
            RelativeLayout leave = (RelativeLayout) dialog_box
                    .findViewById(R.id.leave);
            RelativeLayout tot = (RelativeLayout) dialog_box
                    .findViewById(R.id.tot);
            RelativeLayout todo = (RelativeLayout) dialog_box
                    .findViewById(R.id.todo);

            appointment.setOnClickListener(mylisten);
            leave.setOnClickListener(mylisten);
            tot.setOnClickListener(mylisten);
            todo.setOnClickListener(mylisten);

            Window window = dialog_box.getWindow();

            WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                    .getAttributes();

            wmlp.gravity = Gravity.TOP | Gravity.RIGHT;
            wmlp.x = 35; // x position
            wmlp.y = 30;
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog_box.getWindow().setLayout(200, 250);
            dialog_box.getWindow().clearFlags(
                    WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialog_box.show();
        } else if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return true;
    }

    OnClickListener mylisten = new View.OnClickListener() {

        private TextView sicklv8;

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            dialog_box.dismiss();
            if (v.getId() == R.id.appointment) {
                Dialog dialog_box = new Dialog(CalendarClass.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.addscreen);
                TextView header = (TextView) dialog_box
                        .findViewById(R.id.header);
                header.setText("Appointment");
                LinearLayout fragmentMe = (LinearLayout) dialog_box
                        .findViewById(R.id.fragment);
                fragmentMe.addView(getView());

                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(650, 650);
                dialog_box.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog_box.show();
            } else if (v.getId() == R.id.leave) {

                // TODO Auto-generated method stub
                final Dialog d = new Dialog(CalendarClass.this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.addleavedialog);

                sicklv = (TextView) d.findViewById(R.id.sicklv);
                anl = (TextView) d.findViewById(R.id.allv);

                sicklv1 = (TextView) d.findViewById(R.id.sicklv1);

                sicklv2 = (TextView) d.findViewById(R.id.sicklv2);

                sicklv3 = (TextView) d.findViewById(R.id.sicklv3);

                sicklv4 = (TextView) d.findViewById(R.id.sicklv4);

                sicklv5 = (TextView) d.findViewById(R.id.sicklv5);
                sicklv6 = (TextView) d.findViewById(R.id.sicklv6);
                sicklv7 = (TextView) d.findViewById(R.id.sicklv7);

                sicklv.setOnClickListener(rounclick);
                sicklv1.setOnClickListener(rounclick);
                sicklv2.setOnClickListener(rounclick);
                sicklv3.setOnClickListener(rounclick);
                sicklv4.setOnClickListener(rounclick);
                sicklv5.setOnClickListener(rounclick);
                sicklv6.setOnClickListener(rounclick);
                sicklv7.setOnClickListener(rounclick);
                anl.setOnClickListener(rounclick);

                TextView close = (TextView) d.findViewById(R.id.close);
                EditText ButtonSet = (EditText) d.findViewById(R.id.ButtonSet);

                ButtonSet.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                close.setTypeface(font);
                close.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                EditText description = (EditText) d
                        .findViewById(R.id.EdittextDescription);
                Utility.hideKeyboard(description);

                final EditText edittime = (EditText) d
                        .findViewById(R.id.edittime);
                edittime.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(CalendarClass.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(
                                            TimePicker timePicker,
                                            int selectedHour, int selectedMinute) {
                                        edittime.setText(selectedHour + ":"
                                                + selectedMinute);
                                    }
                                }, hour, minute, true);// Yes 24 hour
                        // time
                        mTimePicker.setTitle("Select Time");

                        mTimePicker.show();

                    }
                });

                final EditText edittime1 = (EditText) d
                        .findViewById(R.id.edittime1);
                edittime1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(CalendarClass.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(
                                            TimePicker timePicker,
                                            int selectedHour, int selectedMinute) {
                                        edittime1.setText(selectedHour + ":"
                                                + selectedMinute);
                                    }
                                }, hour, minute, true);// Yes 24 hour
                        // time
                        mTimePicker.setTitle("Select Time");

                        mTimePicker.show();

                    }
                });

                d.show();

            } else if (v.getId() == R.id.tot) {

                String[] Drname = {"Alan Spiegel", "Alexander Fleming",
                        "Alexander M. Kirschenbaum", "Alexis E. Te",
                        "Alice Rusk"};
                // TODO Auto-generated method stub
                final Dialog d = new Dialog(CalendarClass.this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.addleavedialog);

                TextView TextViewActionPoint = (TextView) d
                        .findViewById(R.id.TextViewActionPoint);
                TextViewActionPoint.setText("Add TOT");

                sicklv = (TextView) d.findViewById(R.id.sicklv);
                sicklv.setText("Transit");
                anl = (TextView) d.findViewById(R.id.allv);

                anl.setText("Cycle Meeting");

                sicklv1 = (TextView) d.findViewById(R.id.sicklv1);
                sicklv1.setText("Auditing");

                sicklv2 = (TextView) d.findViewById(R.id.sicklv2);
                sicklv2.setText("Office Duty");

                sicklv3 = (TextView) d.findViewById(R.id.sicklv3);

                sicklv3.setText("Administrative work");

                sicklv4 = (TextView) d.findViewById(R.id.sicklv4);
                sicklv4.setText("Training");

                sicklv5 = (TextView) d.findViewById(R.id.sicklv5);
                sicklv5.setText("Annual Meeting");

                sicklv8 = (TextView) d.findViewById(R.id.sicklv8);
                sicklv8.setVisibility(View.VISIBLE);
                sicklv8.setText("Team Review Meeting");

                sicklv6 = (TextView) d.findViewById(R.id.sicklv6);

                sicklv7 = (TextView) d.findViewById(R.id.sicklv7);

                sicklv.setOnClickListener(rounclick);
                sicklv1.setOnClickListener(rounclick);
                sicklv2.setOnClickListener(rounclick);
                sicklv3.setOnClickListener(rounclick);
                sicklv4.setOnClickListener(rounclick);
                sicklv5.setOnClickListener(rounclick);
                sicklv6.setOnClickListener(rounclick);
                sicklv7.setOnClickListener(rounclick);
                anl.setOnClickListener(rounclick);

                TextView close = (TextView) d.findViewById(R.id.close);
                EditText ButtonSet = (EditText) d.findViewById(R.id.ButtonSet);

                ButtonSet.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                close.setTypeface(font);
                close.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                EditText description = (EditText) d
                        .findViewById(R.id.EdittextDescription);
                Utility.hideKeyboard(description);

                final EditText edittime = (EditText) d
                        .findViewById(R.id.edittime);
                edittime.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(CalendarClass.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(
                                            TimePicker timePicker,
                                            int selectedHour, int selectedMinute) {
                                        edittime.setText(selectedHour + ":"
                                                + selectedMinute);
                                    }
                                }, hour, minute, true);// Yes 24 hour
                        // time
                        mTimePicker.setTitle("Select Time");

                        mTimePicker.show();

                    }
                });

                d.show();

            } else if (v.getId() == R.id.todo) {

                dialog_box = new Dialog(CalendarClass.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);

                ListViewDraggingAnimation animation = new ListViewDraggingAnimation(
                        CalendarClass.this);
                View v1 = animation.multilevleexpandalelistview(1);
                dialog_box.setContentView(R.layout.reschduledialog);
                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(550, 450);

                dialog_box.show();

            }

        }
    };

    OnClickListener rounclick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            // dialog_box.dismiss();
            if (v.getId() == R.id.sicklv) {

                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                anl.setBackgroundResource(R.drawable.round);
                sicklv1.setBackgroundResource(R.drawable.round);
                sicklv2.setBackgroundResource(R.drawable.round);
                sicklv3.setBackgroundResource(R.drawable.round);
                sicklv4.setBackgroundResource(R.drawable.round);
                sicklv5.setBackgroundResource(R.drawable.round);

            } else if (v.getId() == R.id.allv) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv1.setBackgroundResource(R.drawable.round);
                sicklv2.setBackgroundResource(R.drawable.round);
                sicklv.setBackgroundResource(R.drawable.round);
                sicklv3.setBackgroundResource(R.drawable.round);
                sicklv4.setBackgroundResource(R.drawable.round);
                sicklv5.setBackgroundResource(R.drawable.round);

            } else if (v.getId() == R.id.sicklv1) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv2.setBackgroundResource(R.drawable.round);
                sicklv3.setBackgroundResource(R.drawable.round);
                sicklv4.setBackgroundResource(R.drawable.round);
                anl.setBackgroundResource(R.drawable.round);
                sicklv.setBackgroundResource(R.drawable.round);
                sicklv.setBackgroundResource(R.drawable.round);
                sicklv5.setBackgroundResource(R.drawable.round);

            } else if (v.getId() == R.id.sicklv2) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv1.setBackgroundResource(R.drawable.round);
                sicklv3.setBackgroundResource(R.drawable.round);
                sicklv4.setBackgroundResource(R.drawable.round);
                sicklv.setBackgroundResource(R.drawable.round);
                anl.setBackgroundResource(R.drawable.round);
                sicklv5.setBackgroundResource(R.drawable.round);

            } else if (v.getId() == R.id.sicklv3) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv1.setBackgroundResource(R.drawable.round);
                sicklv2.setBackgroundResource(R.drawable.round);
                sicklv.setBackgroundResource(R.drawable.round);
                anl.setBackgroundResource(R.drawable.round);
                sicklv4.setBackgroundResource(R.drawable.round);
                sicklv5.setBackgroundResource(R.drawable.round);

            } else if (v.getId() == R.id.sicklv4) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv1.setBackgroundResource(R.drawable.round);
                anl.setBackgroundResource(R.drawable.round);
                sicklv.setBackgroundResource(R.drawable.round);
                sicklv2.setBackgroundResource(R.drawable.round);
                sicklv3.setBackgroundResource(R.drawable.round);
                sicklv5.setBackgroundResource(R.drawable.round);

            } else if (v.getId() == R.id.sicklv5) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv1.setBackgroundResource(R.drawable.round);
                sicklv.setBackgroundResource(R.drawable.round);
                sicklv2.setBackgroundResource(R.drawable.round);
                anl.setBackgroundResource(R.drawable.round);
                sicklv3.setBackgroundResource(R.drawable.round);
                sicklv4.setBackgroundResource(R.drawable.round);

            } else if (v.getId() == R.id.sicklv6) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv7.setBackgroundResource(R.drawable.round);
            } else if (v.getId() == R.id.sicklv7) {
                v.setBackgroundResource(R.drawable.roundforlayoutcyan);
                sicklv6.setBackgroundResource(R.drawable.round);
            } else if (v.getId() == R.id.tot) {

            } else if (v.getId() == R.id.tot) {

            } else if (v.getId() == R.id.todo) {

            }

        }
    };

    public LinearLayout getView() {
        LinearLayout parent = new LinearLayout(CalendarClass.this);
        parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        parent.setPadding(10, 0, 10, 0);
        parent.setBackgroundResource(R.drawable.bg_roundedgray);
        parent.setOrientation(LinearLayout.VERTICAL);
        editText = new EditText(CalendarClass.this);
        editText.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                R.drawable.ic_action_search, 0);
        editText.setHint("Physician Name/Patch");
        editText.addTextChangedListener(watcher);
        editText.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT));

        for (int i = 0; i < Drname.length; i++) {
            String[] str = {Drname[i], Specialty[i], Class[i]};
            dataList.add(str);
        }

        lv = new ListView(CalendarClass.this);
        lv.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
        adapter = new CustomAdapter(CalendarClass.this, dataList, 0);
        lv.setAdapter(adapter);
        parent.addView(editText);
        parent.addView(lv);
        return parent;
    }

    TextWatcher watcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            // TODO Auto-generated method stub
            adapter.getFilter().filter(s.toString());
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

        }
    };

    public class MyAdapterforspinner extends ArrayAdapter<String> {

        public MyAdapterforspinner(Context ctx, int txtViewResourceId,
                                   String[] objects) {
            super(ctx, txtViewResourceId, objects);
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
            LayoutInflater inflater = (LayoutInflater) CalendarClass.this
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

    class MyDragListener implements OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:

                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    // v.animate().scaleX(1.5f);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    // v.setBackgroundDrawable(normalShape);

                    break;
                case DragEvent.ACTION_DROP:
                    ViewGroup parent = Viewgp.getParent(v);

                    // parent of parent

                    int chance = parent.indexOfChild(v);
                    int parcount = parent.getChildCount();
                    View view = (View) event.getLocalState();
                    ViewGroup parent2 = Viewgp.getParent(view);

                    int chance2 = parent2.indexOfChild(view);
                    int parcount1 = parent2.getChildCount();

                    View[] vpn = new View[parcount];
                    for (int i = 0; i < vpn.length; i++) {
                        vpn[i] = parent.getChildAt(i);
                    }

                    View[] vpn1 = new View[parcount1];
                    for (int i = 0; i < vpn1.length; i++) {
                        vpn1[i] = parent2.getChildAt(i);
                    }

                    Viewgp.replacegrouppartNew(vpn[chance], vpn1[chance2], chance2,
                            chance);

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    // v.animate().scaleX(1.0f);

                    break;

                default:
                    break;
            }
            return true;
        }
    }

    private String[] maindata = {"Add Unlisted Physician", "Add Pharmacy",
            "Add Distributor", " Add Action point", "Add TOT", "Add Leave"};
    private Dialog dialog_box1;

    void calldialogugemenu(View v) {
        // TODO Auto-generated method stub

        dialog_box1 = new Dialog(CalendarClass.this);
        dialog_box1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_box1.setContentView(R.layout.calenderlistdialog);
        LinearLayout left = (LinearLayout)

                dialog_box1.findViewById(R.id.linlist);

        for (int i = 0; i < maindata.length; i++) {
            TextView textView = new TextView(CalendarClass.this);
            View v1 = new View(CalendarClass.this);
            LinearLayout.LayoutParams param = new

                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,

                    LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams param1 = new

                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,

                    1);
            textView.setLayoutParams(param);
            v1.setLayoutParams(param1);
            v1.setBackgroundColor(Color.WHITE);

            textView.setTextColor(Color.WHITE);
            textView.setPadding(15, 5, 5, 5);
            textView.setTextSize(20);
            textView.setText(maindata[i]);
            textView.setTag("" + i);
            textView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt((String) v.getTag());
                    dialog_box1.dismiss();
                    if (count == 4) {

                        String[] Drname = {"Alan Spiegel",
                                "Alexander Fleming",
                                "Alexander M. Kirschenbaum", "Alexis E. Te",
                                "Alice Rusk"};
                        // TODO Auto-generated method stub
                        final Dialog d = new Dialog(CalendarClass.this);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.addleavedialog);

                        TextView TextViewActionPoint = (TextView) d
                                .findViewById(R.id.TextViewActionPoint);
                        TextViewActionPoint.setText("Add TOT");

                        sicklv = (TextView) d.findViewById(R.id.sicklv);
                        sicklv.setText("Transit");
                        anl = (TextView) d.findViewById(R.id.allv);

                        anl.setText("Cycle Meeting");

                        sicklv1 = (TextView) d.findViewById(R.id.sicklv1);
                        sicklv1.setText("Auditing");

                        sicklv2 = (TextView) d.findViewById(R.id.sicklv2);
                        sicklv2.setText("Office Duty");

                        sicklv3 = (TextView) d.findViewById(R.id.sicklv3);

                        sicklv3.setText("Administrative work");

                        sicklv4 = (TextView) d.findViewById(R.id.sicklv4);
                        sicklv4.setText("Training");

                        sicklv5 = (TextView) d.findViewById(R.id.sicklv5);
                        sicklv5.setText("Annual Meeting");

                        sicklv6 = (TextView) d.findViewById(R.id.sicklv6);

                        sicklv7 = (TextView) d.findViewById(R.id.sicklv7);

                        sicklv.setOnClickListener(rounclick);
                        sicklv1.setOnClickListener(rounclick);
                        sicklv2.setOnClickListener(rounclick);
                        sicklv3.setOnClickListener(rounclick);
                        sicklv4.setOnClickListener(rounclick);
                        sicklv5.setOnClickListener(rounclick);
                        sicklv6.setOnClickListener(rounclick);
                        sicklv7.setOnClickListener(rounclick);
                        anl.setOnClickListener(rounclick);

                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        EditText description = (EditText) d
                                .findViewById(R.id.EdittextDescription);
                        Utility.hideKeyboard(description);

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);
                        edittime.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub

                                Calendar mcurrentTime = Calendar.getInstance();
                                int hour = mcurrentTime
                                        .get(Calendar.HOUR_OF_DAY);
                                int minute = mcurrentTime.get(Calendar.MINUTE);
                                TimePickerDialog mTimePicker;
                                mTimePicker = new TimePickerDialog(
                                        CalendarClass.this,
                                        new TimePickerDialog.OnTimeSetListener() {
                                            @Override
                                            public void onTimeSet(
                                                    TimePicker timePicker,
                                                    int selectedHour,
                                                    int selectedMinute) {
                                                edittime.setText(selectedHour
                                                        + ":" + selectedMinute);
                                            }
                                        }, hour, minute, true);// Yes 24 hour
                                // time
                                mTimePicker.setTitle("Select Time");

                                mTimePicker.show();

                            }
                        });

                        d.show();

                    } else if (count == 5) {

                        // TODO Auto-generated method stub
                        final Dialog d = new Dialog(CalendarClass.this);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.addleavedialog);

                        sicklv = (TextView) d.findViewById(R.id.sicklv);
                        anl = (TextView) d.findViewById(R.id.allv);

                        sicklv1 = (TextView) d.findViewById(R.id.sicklv1);

                        sicklv2 = (TextView) d.findViewById(R.id.sicklv2);

                        sicklv3 = (TextView) d.findViewById(R.id.sicklv3);

                        sicklv4 = (TextView) d.findViewById(R.id.sicklv4);

                        sicklv5 = (TextView) d.findViewById(R.id.sicklv5);
                        sicklv6 = (TextView) d.findViewById(R.id.sicklv6);
                        sicklv7 = (TextView) d.findViewById(R.id.sicklv7);

                        sicklv.setOnClickListener(rounclick);
                        sicklv1.setOnClickListener(rounclick);
                        sicklv2.setOnClickListener(rounclick);
                        sicklv3.setOnClickListener(rounclick);
                        sicklv4.setOnClickListener(rounclick);
                        sicklv5.setOnClickListener(rounclick);
                        sicklv6.setOnClickListener(rounclick);
                        sicklv7.setOnClickListener(rounclick);
                        anl.setOnClickListener(rounclick);

                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        EditText description = (EditText) d
                                .findViewById(R.id.EdittextDescription);
                        Utility.hideKeyboard(description);

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);
                        edittime.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub

                                Calendar mcurrentTime = Calendar.getInstance();
                                int hour = mcurrentTime
                                        .get(Calendar.HOUR_OF_DAY);
                                int minute = mcurrentTime.get(Calendar.MINUTE);
                                TimePickerDialog mTimePicker;
                                mTimePicker = new TimePickerDialog(
                                        CalendarClass.this,
                                        new TimePickerDialog.OnTimeSetListener() {
                                            @Override
                                            public void onTimeSet(
                                                    TimePicker timePicker,
                                                    int selectedHour,
                                                    int selectedMinute) {
                                                edittime.setText(selectedHour
                                                        + ":" + selectedMinute);
                                            }
                                        }, hour, minute, true);// Yes 24 hour
                                // time
                                mTimePicker.setTitle("Select Time");

                                mTimePicker.show();

                            }
                        });

                        d.show();

                    } else if (count == 0) {

                        // TODO Auto-generated method stub
                        final Dialog d = new Dialog(CalendarClass.this);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.add_unlisted);

                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });

                        d.show();

                    } else if (count == 1 || count == 2) {

                        // TODO Auto-generated method stub
                        final Dialog d = new Dialog(CalendarClass.this);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.add_unlisted);

                        TextView close = (TextView) d.findViewById(R.id.close);

                        TextView TextViewActionPoint = (TextView) d
                                .findViewById(R.id.TextViewActionPoint);

                        TextViewActionPoint.setText("Add Details");

                        TextView phyname = (TextView) d
                                .findViewById(R.id.phyname);

                        phyname.setText("Name");

                        TextView psc = (TextView) d.findViewById(R.id.spec);
                        psc.setVisibility(View.INVISIBLE);

                        Spinner spphy = (Spinner) d
                                .findViewById(R.id.typeofphy1);

                        spphy.setVisibility(View.INVISIBLE);

                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });

                        d.show();

                    } else if (count == 3) {

                        // TODO Auto-generated method stub
                        final Dialog d = new Dialog(CalendarClass.this);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.add_action_points);

                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        AutoCompleteTextView mySpinner = (AutoCompleteTextView) d
                                .findViewById(R.id.typeofphydr);
                        mySpinner.setAdapter(new MyAdapterforspinner(
                                CalendarClass.this, R.layout.exrow_second,
                                Drname));

                        mySpinner.setThreshold(1);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                d.dismiss();
                            }
                        });
                        EditText description = (EditText) d
                                .findViewById(R.id.EdittextDescription);
                        Utility.hideKeyboard(description);
                        edittextDuedate = (EditText) d
                                .findViewById(R.id.edittextDuedate);
                        edittextDuedate
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View arg0) {
                                        // TODO Auto-generated method stub

                                        new DatePickerDialog(
                                                CalendarClass.this,
                                                date,
                                                myCalendar.get(Calendar.YEAR),
                                                myCalendar.get(Calendar.MONTH),
                                                myCalendar
                                                        .get(Calendar.DAY_OF_MONTH))
                                                .show();

                                    }
                                });

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);
                        edittime.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub

                                Calendar mcurrentTime = Calendar.getInstance();
                                int hour = mcurrentTime
                                        .get(Calendar.HOUR_OF_DAY);
                                int minute = mcurrentTime.get(Calendar.MINUTE);
                                TimePickerDialog mTimePicker;
                                mTimePicker = new TimePickerDialog(
                                        CalendarClass.this,
                                        new TimePickerDialog.OnTimeSetListener() {
                                            @Override
                                            public void onTimeSet(
                                                    TimePicker timePicker,
                                                    int selectedHour,
                                                    int selectedMinute) {
                                                edittime.setText(selectedHour
                                                        + ":" + selectedMinute);
                                            }
                                        }, hour, minute, true);// Yes 24 hour
                                // time
                                mTimePicker.setTitle("Select Time");

                                mTimePicker.show();

                            }
                        });

                        d.show();

                    }

                }
            });

            if (i != maindata.length - 1) {

                left.addView(textView);
                left.addView(v1);
            } else {
                left.addView(textView);
            }
        }

        Window window = dialog_box1.getWindow();
        WindowManager.LayoutParams wmlp = dialog_box1.getWindow()
                .getAttributes();
        int[] viewLocation = new int[2];
        v.getLocationOnScreen(viewLocation);
        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp.x = viewLocation[0];
        wmlp.y = viewLocation[1];
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_box1.getWindow().setLayout(300, 570);
        dialog_box1.show();

    }

    void threedotdialog(View v) {

        dialog_box1 = new Dialog(CalendarClass.this);
        dialog_box1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_box1.setContentView(R.layout.makeplandilaog);

        RelativeLayout layout = (RelativeLayout) dialog_box1
                .findViewById(R.id.relogout1);

        layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box1.dismiss();
                list = new ExpandablelistviewfordocNEW(CalendarClass.this, "",
                        1);
                View v1 = list.multilevleexpandalelistview();
                rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
                rl1.addView(v1);
            }
        });

        Window window = dialog_box1.getWindow();
        WindowManager.LayoutParams wmlp = dialog_box1.getWindow()
                .getAttributes();
        int[] viewLocation = new int[2];
        v.getLocationOnScreen(viewLocation);
        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp.x = viewLocation[0];
        wmlp.y = viewLocation[1];
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_box1.getWindow().setLayout(300, 150);
        dialog_box1.show();

    }

    void alert(View v) {

        dialog_box1 = new Dialog(CalendarClass.this);
        dialog_box1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_box1.setContentView(R.layout.alertdailogplan);

        TextView cloView = (TextView) dialog_box1.findViewById(R.id.close);
        cloView.setTypeface(font);
        TextView cloView1 = (TextView) dialog_box1.findViewById(R.id.yes);

        TextView cloView2 = (TextView) dialog_box1.findViewById(R.id.cancel);

        cloView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box1.dismiss();

            }
        });

        cloView1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box1.dismiss();

            }
        });

        cloView2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box1.dismiss();

            }
        });

        Window window = dialog_box1.getWindow();
        WindowManager.LayoutParams wmlp = dialog_box1.getWindow()
                .getAttributes();
        int[] viewLocation = new int[2];
        v.getLocationOnScreen(viewLocation);
        wmlp.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;
        // wmlp.x = viewLocation[0];
        // wmlp.y = viewLocation[1];
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_box1.getWindow().setLayout(600, 250);
        dialog_box1.show();

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

            edittextDuedate.setText(sdf.format(myCalendar.getTime()));
        }

    };

    @Override
    public void setDateToView(Calendar c) {
        if (editTextForDate instanceof EditText)
            ((EditText) editTextForDate).setText(DateFormat.format("dd/MM/yyyy", c));
        else
            ((TextView) editTextForDate).setText(DateFormat.format("dd/MM/yyyy", c));
    }

    @Override
    public void setTimeToView(Calendar c) {
        if (editTextForDate instanceof EditText)
            ((EditText) editTextForDate).setText(DateFormat.format("h:mm a", c));
        else
            ((TextView) editTextForDate).setText(DateFormat.format("h:mm a", c));
    }


}