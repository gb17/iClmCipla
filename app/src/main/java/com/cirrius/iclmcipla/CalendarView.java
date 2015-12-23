package com.cirrius.iclmcipla;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.cirrius.animationlist.ListViewDraggingAnimation;
import com.cirrius.calender.listview.ExpandablelistviewfordocNEW;
import com.cirrius.iclmcipla.R;
import com.iclm.util.MyDragListnerforcalender;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CalendarView extends LinearLayout {
    // how many days to show, defaults to six weeks, 42 days
    private static final int DAYS_COUNT = 42;

    // default date format
    private static final String DATE_FORMAT = "MMM yyyy";

    // date format
    private String dateFormat;

    // current displayed month
    private Calendar currentDate = Calendar.getInstance();

    public static TextView textundo;
    // // event handling
    // private EventHandler eventHandler = null;

    private String[] Drname = {"Alan Spiegel", "Alexander Fleming",
            "Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk"};
    EditText edittextDuedate;
    private LinearLayout header;
    private ImageView btnPrev;
    private ImageView btnNext;
    private TextView txtDate;
    private GridView grid;
    Calendar myCalendar = Calendar.getInstance();
    // seasons' rainbow
    int[] rainbow = new int[]{R.color.tabbg, R.color.tabbg, R.color.tabbg,
            R.color.tabbg};

    // month-season association (northern hemisphere, sorry australia :)
    int[] monthSeason = new int[]{2, 2, 3, 3, 3, 0, 0, 0, 1, 1, 1, 2};

    HashSet<Date> events = null;

    private Typeface font;

    int[] greendot = {5, 14, 25, 21, 9, 17, 29};

    int[] reddot = {21, 22, 17, 11, 2, 28, 7};

    String[][] totarr = {{"TR", "15"}, {"M", "24"}, {"HO", "1"},
            {"CY", "3"}};

    String[][] leave = {{"L", "22"}, {"H", "11"}};

    int patchone[] = {14, 21, 29, 30, 16, 4, 2, 25, 10, 18, 28};
    int patchtwo[] = {10, 21, 29, 8, 7, 16, 23, 2, 9, 17, 14, 18, 28, 30};
    int morepatcharr[] = {2, 21, 16, 29, 18, 28, 30, 14};

    String[] maindata = {"Add Unlisted Physician", "Add Pharmacy",
            "Add Distributor", "Add Action point", "Add TOT", "Add Leave",
            "Make Plan from STP", "Manual"};

    Context context;

    private Dialog dialog_box2;
    private Dialog dialog_box1;

    private LinearLayout lin1;

    private TextView sicklv;
    private TextView anl;
    private TextView sicklv1;
    private TextView sicklv2;
    private TextView sicklv3;
    private TextView sicklv4;
    private TextView sicklv5;
    private TextView sicklv6;
    private TextView sicklv7;
    private TextView sicklv8;

    public static ImageView undo, cancel, done;

    private TextView textView;

    public static View vtime;

    int selectmont = 1;

    ProgressDialog barProgressDialog;
    Handler updateBarHandler;

    int indexforplan = 1;

    private RelativeLayout relfouracxtionpoint;

    public CalendarView(Context context) {
        super(context);
        this.context = context;
    }

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        this.context = context;
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initControl(context, attrs);
    }

    /**
     * Load control xml layout
     */
    private void initControl(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View V = inflater.inflate(R.layout.control_calendar, this);
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        ImageView threedottxt = (ImageView) V.findViewById(R.id.threedottxt);
        threedottxt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                threedotdialog(v);
            }
        });
        TextView plus = (TextView) V.findViewById(R.id.plus);
        plus.setTypeface(font);
        plus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                calldialogugemenu(v);
            }
        });

        undo = (ImageView) V.findViewById(R.id.undo);
        undo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                undo.setVisibility(View.INVISIBLE);
            }
        });
        cancel = (ImageView) V.findViewById(R.id.cancel);

        cancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                cancel.setVisibility(View.INVISIBLE);
                undo.setVisibility(View.INVISIBLE);
                done.setVisibility(View.INVISIBLE);
            }
        });

        done = (ImageView) V.findViewById(R.id.done);
        done.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                cancel.setVisibility(View.INVISIBLE);
                undo.setVisibility(View.INVISIBLE);
                done.setVisibility(View.INVISIBLE);

            }
        });
        loadDateFormat(attrs);
        assignUiElements();
        assignClickHandlers();

        updateCalendar();
    }

    public void setVisibility() {
        undo.setVisibility(View.VISIBLE);
        // cancel.setVisibility(View.VISIBLE);
        // done.setVisibility(View.VISIBLE);
    }

    private void loadDateFormat(AttributeSet attrs) {
        dateFormat = DATE_FORMAT;
    }

    private void assignUiElements() {
        // layout is inflated, assign local variables to components
        header = (LinearLayout) findViewById(R.id.calendar_header);
        btnPrev = (ImageView) findViewById(R.id.calendar_prev_button);
        btnNext = (ImageView) findViewById(R.id.calendar_next_button);
        txtDate = (TextView) findViewById(R.id.calendar_date_display);

        relfouracxtionpoint = (RelativeLayout) findViewById(R.id.relfouracxtionpoint);

        relfouracxtionpoint.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                actionpointdailog();

            }
        });

        textView = (TextView) findViewById(R.id.chkboxcal);
        textView.setTypeface(font);
        grid = (GridView) findViewById(R.id.calendar_grid);
    }

    private void assignClickHandlers() {
        // add one month and refresh UI
        btnNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        // subtract one month and refresh UI
        btnPrev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.MONTH, -1);

            }
        });

        // long-pressing a day
        // grid.setOnItemLongClickListener(new
        // AdapterView.OnItemLongClickListener() {
        //
        // @Override
        // public boolean onItemLongClick(final AdapterView<?> view,
        // View cell, int position, long id) {
        // final int pos = (int) id;
        // // handle long-press
        // DateFormat df = SimpleDateFormat.getDateInstance();
        // Toast.makeText(getContext(),
        // df.format((Date) view.getItemAtPosition(position)),
        // Toast.LENGTH_SHORT).show();
        //
        // AlertDialog.Builder alert = new AlertDialog.Builder(
        // getContext());
        //
        // final EditText edittext = new EditText(getContext());
        // alert.setMessage("Enter Your Message");
        // alert.setTitle("Schedule");
        //
        // alert.setView(edittext);
        //
        // alert.setPositiveButton("Yes",
        // new DialogInterface.OnClickListener() {
        // public void onClick(DialogInterface dialog,
        // int whichButton) {
        // // What ever you want to do with the value
        //
        // String eventData = edittext.getText()
        // .toString();
        // int count = view.getChildCount();
        // RelativeLayout rl = (RelativeLayout) viewcalendar
        // .getChildAt(pos);
        // TextView data = (TextView) rl.getChildAt(0);
        // data.setText(eventData);
        // rl.getChildAt(3).setVisibility(View.VISIBLE);
        // ((TextView) rl.getChildAt(1)).setTypeface(null,
        // Typeface.BOLD);
        // ((TextView) rl.getChildAt(1))
        // .setTextColor(getResources().getColor(
        // R.color.birthday));
        // }
        // });
        //
        // alert.setNegativeButton("No",
        // new DialogInterface.OnClickListener() {
        // public void onClick(DialogInterface dialog,
        // int whichButton) {
        // // what ever you want to do with No option.
        // }
        // });
        //
        // alert.show();
        //
        // return true;
        // }
        // });
    }

    /**
     * Display dates correctly in grid
     */
    public void updateCalendar() {
        updateCalendar(this.events);
    }

    /**
     * Display dates correctly in grid
     */
    public void updateCalendar(HashSet<Date> events) {
        this.events = events;
        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();

        // determine the cell for current month's beginning
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        // move calendar backwards to the beginning of the week
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        // fill cells
        while (cells.size() < DAYS_COUNT) {
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // update grid
        grid.setAdapter(new CalendarAdapter(getContext(), cells, this.events));

        // update title
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        txtDate.setText(sdf.format(currentDate.getTime()));

        // set header color according to current season
        int month = currentDate.get(Calendar.MONTH);
        int season = monthSeason[month];
        int color = rainbow[season];

        header.setBackgroundColor(getResources().getColor(color));
    }

    private class CalendarAdapter extends ArrayAdapter<Date> {
        // days with events
        private HashSet<Date> eventDays;
        private Context context;

        // for view inflation
        private LayoutInflater inflater;

        public CalendarAdapter(Context context, ArrayList<Date> days,
                               HashSet<Date> eventDays) {
            super(context, R.layout.control_calendar_day, days);
            this.eventDays = eventDays;
            inflater = LayoutInflater.from(context);
            this.context = context;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            Date date = getItem(position);
            int day = date.getDate();
            int month = date.getMonth();
            int year = date.getYear();

            // today
            final Date today = new Date();

            // inflate item if it does not exist yet
            if (view == null)
                view = inflater.inflate(R.layout.control_calendar_day, parent,
                        false);

            view.setOnDragListener(new MyDragListnerforcalender(context));
            // view.setOnLongClickListener(new OnLongClickListener() {
            //
            // @Override
            // public boolean onLongClick(View v) {
            // ClipData data = ClipData.newPlainText("", "");
            // DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
            // v);
            // v.startDrag(data, shadowBuilder, v, 0);
            // return true;
            // }
            // });

            final ImageView iv = (ImageView) view.findViewById(R.id.remin);
            final TextView todayindicator = (TextView) view
                    .findViewById(R.id.todayindicator);

            final TextView dot1 = (TextView) view.findViewById(R.id.dot1);
            dot1.setTypeface(font);

            final TextView dot2 = (TextView) view.findViewById(R.id.dot2);
            dot2.setTypeface(font);

            final TextView morepatch = (TextView) view
                    .findViewById(R.id.threepatch);

            final TextView tot = (TextView) view.findViewById(R.id.tot);

            final TextView data = (TextView) view.findViewById(R.id.data);
            // clear styling
            final TextView tv = (TextView) view.findViewById(R.id.top);
            tv.setTypeface(null, Typeface.NORMAL);
            tv.setTextColor(Color.BLACK);

            final TextView head1 = (TextView) view.findViewById(R.id.head1);
            final TextView head1count = (TextView) view
                    .findViewById(R.id.head1count);
            final TextView head2 = (TextView) view.findViewById(R.id.head2);
            final TextView head2count = (TextView) view
                    .findViewById(R.id.head2count);

            // view.setOnLongClickListener(new OnLongClickListener() {
            //
            // @Override
            // public boolean onLongClick(View v) {
            // // TODO Auto-generated method stub
            // DateFormat df = SimpleDateFormat.getDateInstance();
            // Toast.makeText(getContext(),
            // df.format((Date) grid.getItemAtPosition(position)),
            // Toast.LENGTH_SHORT).show();
            //
            // AlertDialog.Builder alert = new AlertDialog.Builder(
            // getContext());
            //
            // final EditText edittext = new EditText(getContext());
            // alert.setMessage("Enter Your Message");
            // alert.setTitle("Schedule");
            //
            // alert.setView(edittext);
            //
            // alert.setPositiveButton("Yes",
            // new DialogInterface.OnClickListener() {
            // public void onClick(DialogInterface dialog,
            // int whichButton) {
            // // What ever you want to do with the value
            //
            // String eventData = edittext.getText()
            // .toString();
            // data.setText(eventData);
            // iv.setVisibility(View.VISIBLE);
            // tv.setTypeface(null, Typeface.BOLD);
            // tv.setTextColor(getResources().getColor(
            // R.color.birthday));
            // }
            // });
            //
            // alert.setNegativeButton("No",
            // new DialogInterface.OnClickListener() {
            // public void onClick(DialogInterface dialog,
            // int whichButton) {
            // // what ever you want to do with No option.
            // }
            // });
            //
            // alert.show();
            //
            // return true;
            //
            // }
            // });

            view.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    String str = tv.getText().toString();
                    System.out.println(str);
                    if (!data.getText().toString().equals("")) {
                        AlertDialog.Builder alertbox = new AlertDialog.Builder(
                                context);
                        alertbox.setMessage(data.getText().toString())
                                .setPositiveButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                dialog.cancel();
                                            }
                                        });
                        alertbox.create();
                        alertbox.show();
                    }
                }
            });

            if (selectmont == 1) {
                for (int i = 0; i < greendot.length; i++) {

                    if (day == greendot[i]) {
                        dot1.setVisibility(View.VISIBLE);
                    }

                }

                for (int i = 0; i < reddot.length; i++) {

                    if (day == reddot[i]) {
                        dot2.setVisibility(View.VISIBLE);
                    }

                }
                for (int i = 0; i < morepatcharr.length; i++) {

                    if (day == morepatcharr[i]) {
                        morepatch.setVisibility(View.VISIBLE);
                    }

                }

                for (int i = 0; i < totarr.length; i++) {

                    if (day == Integer.parseInt(totarr[i][1])) {
                        tot.setVisibility(View.VISIBLE);
                        tot.setText(totarr[i][0]);
                        view.setBackgroundResource(R.drawable.totborder);
                    }

                }

                for (int i = 0; i < leave.length; i++) {

                    if (day == Integer.parseInt(leave[i][1])) {
                        tot.setBackgroundResource(R.drawable.green_rounded);
                        tot.setVisibility(View.VISIBLE);
                        tot.setText(leave[i][0]);
                        view.setBackgroundResource(R.drawable.holiborder);
                    }

                }

                for (int i = 0; i < patchone.length; i++) {

                    if (day == patchone[i]) {

                        head1.setVisibility(View.VISIBLE);
                        head1count.setVisibility(View.VISIBLE);
                    }

                }

                for (int i = 0; i < patchtwo.length; i++) {

                    if (day == patchtwo[i]) {
                        head2.setVisibility(View.VISIBLE);
                        head2count.setVisibility(View.VISIBLE);
                    }

                }

                // if this day has an event, specify event image
                if (position == 0 || position == 7 || position == 14
                        || position == 21 || position == 27 || position == 28
                        || position == 13 || position == 21 || position == 34
                        || position == 6 || position == 13 || position == 20
                        || position == 27 || position == 35 || position == 41)
                    view.setBackgroundResource(R.drawable.holiborder);
                // else
                // view.setBackgroundResource(R.drawable.border);

                if (position == 21 || position == 22 || position == 23
                        || position == 24) {

                }
            }

            if (eventDays != null) {
                for (final Date eventDate : eventDays) {
                    if (eventDate.getDate() == day
                            && eventDate.getMonth() == month
                            && eventDate.getYear() == year) {
                        iv.setVisibility(View.VISIBLE);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextColor(getResources().getColor(
                                R.color.birthday));
                        view.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                AlertDialog.Builder alertbox = new AlertDialog.Builder(
                                        context);
                                int month = eventDate.getMonth() + 1;
                                alertbox.setMessage(
                                        "Your Birthday is on "
                                                + eventDate.getDate() + "/"
                                                + month + "/"
                                                + eventDate.getYear())
                                        .setPositiveButton(
                                                "OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(
                                                            DialogInterface dialog,
                                                            int which) {
                                                        dialog.cancel();
                                                    }
                                                });
                                alertbox.create();
                                alertbox.show();
                            }
                        });
                        break;
                    }
                }
            }

            if (month != today.getMonth() || year != today.getYear()) {
                // if this day is outside current month, grey it out
                tv.setTextColor(getResources().getColor(R.color.greyed_out));
            } else if (day == today.getDate()) {
                tv.setTypeface(null, Typeface.BOLD);
                todayindicator.setVisibility(View.VISIBLE);
                tv.setTextColor(getResources().getColor(R.color.today));
                // view.setOnClickListener(new OnClickListener() {
                //
                // @Override
                // public void onClick(View v) {
                // // TODO Auto-generated method stub
                // AlertDialog.Builder alertbox = new AlertDialog.Builder(
                // context);
                // int month = today.getMonth() + 1;
                // alertbox.setMessage(
                // "today's date is " + today.getDate() + "/"
                // + month + "/" + today.getYear())
                // .setPositiveButton("OK",
                // new DialogInterface.OnClickListener() {
                // public void onClick(
                // DialogInterface dialog,
                // int which) {
                // dialog.cancel();
                // }
                // });
                // alertbox.create();
                // alertbox.show();
                // }
                // });

            }

            // if (day == 21) {
            // // tot.setTextColor(Color.parseColor("#76ff03"));
            // tot.setBackgroundResource(R.drawable.green_rounded);
            // tot.setVisibility(View.VISIBLE);
            // }

            else {

                view.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        callscheducledailog();
                    }
                });

            }

            // set text
            tv.setText(String.valueOf(date.getDate()));

            return view;
        }
    }

    public class MyAdapterforspinner extends ArrayAdapter<String> {

        Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
                R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4};

        private String[] Drname = {"Alan Spiegel", "Alexander Fleming",
                "Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk"};

        String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
                "01:30 pm", "Class B", "Class B", "Class A", "Class B",
                "Class C", "Class A"};

        String[] Specialty = {"Nuclear cardiology",
                "Cardiac electrophysiology", "Urologic oncology",
                "Urologic oncology", "Neuromuscular Medicine"};
        String[] Class = {"Class B", "Class A", "Class C", "Class C",
                "Class B"};

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

    public void callscheducledailog() {
        final LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        dialog_box2 = new Dialog(context);
        dialog_box2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_box2.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.R.color.transparent));
        dialog_box2.setContentView(R.layout.calenderd1);

        TextView tv = (TextView) dialog_box2.findViewById(R.id.txtu1);
        TextView tv1 = (TextView) dialog_box2.findViewById(R.id.txtu2);
        textundo = (TextView) dialog_box2.findViewById(R.id.textundo);
        textundo.setTypeface(font);

        //

        tv.setTypeface(font);
        tv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog_box2.dismiss();
            }
        });
        tv1.setTypeface(font);

        // -------------------------------------------------------

        inflater.inflate(R.layout.calenderlistdialog, null);

        lin1 = (LinearLayout) dialog_box2.findViewById(R.id.lin1);

        // RelativeLayout.LayoutParams tableRowLayoutParams1 = new
        // RelativeLayout.LayoutParams(
        // 400, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // RelativeLayout.LayoutParams tableRowLayoutParams2 = new
        // RelativeLayout.LayoutParams(
        // RelativeLayout.LayoutParams.WRAP_CONTENT,
        // RelativeLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams tableRowLayoutParams1 = new LinearLayout.LayoutParams(
                0, RelativeLayout.LayoutParams.WRAP_CONTENT, 1.5f);

        tableRowLayoutParams1.setMargins(0, 0, 15, 0);
        LinearLayout.LayoutParams tableRowLayoutParams2 = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        // tableRowLayoutParams2.setMargins(40, 0, 0, 0);

        // RelativeLayout r1 = (RelativeLayout)
        // dialog_box.findViewById(R.id.rel1);
        //
        // RelativeLayout r2 = (RelativeLayout)
        // dialog_box.findViewById(R.id.rel2);

        ListViewDraggingAnimation animation = new ListViewDraggingAnimation(
                context);
        View v1 = animation.multilevleexpandalelistview(1);
        v1.setLayoutParams(tableRowLayoutParams1);

        vtime = inflater.inflate(R.layout.meeting, null);
        vtime.setVisibility(View.GONE);
        // vtime.setPadding(40, 0, 0, 0);
        vtime.setLayoutParams(tableRowLayoutParams2);
        new View(context);

        EditText ed = (EditText) vtime.findViewById(R.id.ButtonSet);
        ed.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box2.dismiss();

            }
        });
        EditText ed1 = (EditText) vtime.findViewById(R.id.ButtonSet1);
        ed1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box2.dismiss();

            }
        });

        // dialog_box.setContentView(v1);
        lin1.addView(v1);
        lin1.addView(vtime);

        dialog_box2.getWindow().setLayout(700, 700);
        dialog_box2.show();

        // --------------------------------------------------------------------------
        tv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog_box1 = new Dialog(context);
                dialog_box1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box1.setContentView(R.layout.calenderlistdialog);
                LinearLayout left = (LinearLayout)

                        dialog_box1.findViewById(R.id.linlist);

                for (int i = 0; i < maindata.length; i++) {
                    TextView textView = new TextView(context);
                    View v1 = new View(context);
                    LinearLayout.LayoutParams param = new

                            LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,

                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    LinearLayout.LayoutParams param1 = new

                            LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,

                            1);
                    textView.setLayoutParams(param);
                    v1.setLayoutParams(param1);
                    v1.setBackgroundColor(Color.WHITE);

                    textView.setTextColor(Color.WHITE);
                    textView.setPadding(15, 5, 5, 5);
                    textView.setTextSize(18);
                    textView.setText(maindata[i]);
                    textView.setTag("" + i);
                    textView.setOnClickListener(new OnClickListener() {

                        private EditText ButtonSet;

                        @Override
                        public void onClick(View v) {

                            dialog_box2.getWindow().setLayout(1200, 700);
                            int count = Integer.parseInt((String) v.getTag());

                            if (count == 5) {
                                View vf = lin1.getChildAt(0);
                                lin1.removeAllViews();
                                lin1.addView(vf);
                                LinearLayout.LayoutParams tableRowLayoutParams3 = new LinearLayout.LayoutParams(
                                        0,
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        2.5f);

                                View vleave = inflater.inflate(
                                        R.layout.addleavedialog, null);
                                vleave.setBackgroundColor(Color.TRANSPARENT);
                                vleave.setLayoutParams(tableRowLayoutParams3);

                                sicklv = (TextView) vleave
                                        .findViewById(R.id.sicklv);
                                anl = (TextView) vleave.findViewById(R.id.allv);
                                anl.setOnClickListener(rounclick);

                                Spinner spinner = (Spinner) vleave
                                        .findViewById(R.id.leavespin);
                                spinner.setVisibility(View.VISIBLE);

                                sicklv1 = (TextView) vleave
                                        .findViewById(R.id.sicklv1);

                                sicklv2 = (TextView) vleave
                                        .findViewById(R.id.sicklv2);

                                sicklv3 = (TextView) vleave
                                        .findViewById(R.id.sicklv3);

                                sicklv4 = (TextView) vleave
                                        .findViewById(R.id.sicklv4);

                                sicklv5 = (TextView) vleave
                                        .findViewById(R.id.sicklv5);
                                sicklv6 = (TextView) vleave
                                        .findViewById(R.id.sicklv6);
                                sicklv7 = (TextView) vleave
                                        .findViewById(R.id.sicklv7);
                                ButtonSet = (EditText) vleave
                                        .findViewById(R.id.ButtonSet);

                                ButtonSet.setOnClickListener(rounclick);

                                sicklv.setOnClickListener(rounclick);
                                sicklv1.setOnClickListener(rounclick);
                                sicklv2.setOnClickListener(rounclick);
                                sicklv3.setOnClickListener(rounclick);
                                sicklv4.setOnClickListener(rounclick);
                                sicklv5.setOnClickListener(rounclick);
                                sicklv6.setOnClickListener(rounclick);
                                sicklv7.setOnClickListener(rounclick);
                                anl.setOnClickListener(rounclick);

                                TextView close = (TextView) vleave
                                        .findViewById(R.id.close);
                                EditText ButtonSet = (EditText) vleave
                                        .findViewById(R.id.ButtonSet);

                                ButtonSet
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View v) {

                                                dialog_box1.dismiss();
                                            }
                                        });
                                close.setTypeface(font);
                                close.setVisibility(View.GONE);
                                close.setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {

                                        dialog_box1.dismiss();
                                    }
                                });
                                EditText description = (EditText) vleave
                                        .findViewById(R.id.EdittextDescription);
                                Utility.hideKeyboard(description);

                                final EditText edittime = (EditText) vleave
                                        .findViewById(R.id.edittime);
                                edittime.setOnClickListener(new OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // show the time picker dialog
                                        TimePickerFragment newFragment = new TimePickerFragment();
                                        CalendarClass.editTextForDate = edittime;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "timepicker");

                                    }
                                });

                                final EditText edittime89 = (EditText) vleave
                                        .findViewById(R.id.edittime1);
                                edittime89
                                        .setOnClickListener(new OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                // show the time picker dialog
                                                TimePickerFragment newFragment = new TimePickerFragment();
                                                CalendarClass.editTextForDate = edittime89;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "timepicker");

                                            }
                                        });

                                final EditText edittextDuedate1 = (EditText) vleave
                                        .findViewById(R.id.edittextDuedate1);

                                edittextDuedate1
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View arg0) {
                                                DialogFragment newFragment = new DatePickerFragment();
                                                CalendarClass.editTextForDate = edittextDuedate1;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "datePicker");
                                            }
                                        });

                                final EditText edittextDuedate = (EditText) vleave
                                        .findViewById(R.id.edittextDuedate);

                                edittextDuedate
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View arg0) {
                                                DialogFragment newFragment = new DatePickerFragment();
                                                CalendarClass.editTextForDate = edittextDuedate;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "datePicker");
                                            }
                                        });

                                lin1.addView(vleave);
                            }
                            if (count == 4) {

                                View vf = lin1.getChildAt(0);
                                lin1.removeAllViews();
                                lin1.addView(vf);
                                LinearLayout.LayoutParams tableRowLayoutParams5 = new LinearLayout.LayoutParams(
                                        0,
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        2.5f);

                                View vtot = inflater.inflate(
                                        R.layout.addleavedialog, null);

                                vtot.setBackgroundColor(Color.TRANSPARENT);
                                TextView tvv = (TextView) vtot
                                        .findViewById(R.id.sicklv);
                                TextView tvv1 = (TextView) vtot
                                        .findViewById(R.id.TextViewActionPoint);

                                Spinner spinner = (Spinner) vtot
                                        .findViewById(R.id.totspin);
                                spinner.setVisibility(View.VISIBLE);

                                tvv.setText("Transit");
                                tvv1.setText("Add ToT");

                                sicklv = (TextView) vtot
                                        .findViewById(R.id.sicklv);
                                sicklv.setText("Transit");
                                anl = (TextView) vtot.findViewById(R.id.allv);
                                anl.setOnClickListener(rounclick);

                                anl.setText("Cycle Meeting");

                                sicklv1 = (TextView) vtot
                                        .findViewById(R.id.sicklv1);
                                sicklv1.setText("Auditing");

                                sicklv2 = (TextView) vtot
                                        .findViewById(R.id.sicklv2);
                                sicklv2.setText("Office Duty");

                                sicklv3 = (TextView) vtot
                                        .findViewById(R.id.sicklv3);

                                sicklv3.setText("Administrative work");

                                sicklv4 = (TextView) vtot
                                        .findViewById(R.id.sicklv4);
                                sicklv4.setText("Training");

                                sicklv5 = (TextView) vtot
                                        .findViewById(R.id.sicklv5);
                                sicklv5.setText("Annual Meeting");

                                sicklv8 = (TextView) vtot
                                        .findViewById(R.id.sicklv8);
                                sicklv8.setVisibility(View.VISIBLE);
                                sicklv8.setText("Team Review Meeting");

                                sicklv6 = (TextView) vtot
                                        .findViewById(R.id.sicklv6);

                                sicklv7 = (TextView) vtot
                                        .findViewById(R.id.sicklv7);

                                ButtonSet = (EditText) vtot
                                        .findViewById(R.id.ButtonSet);

                                ButtonSet.setOnClickListener(rounclick);

                                sicklv.setOnClickListener(rounclick);
                                sicklv1.setOnClickListener(rounclick);
                                sicklv2.setOnClickListener(rounclick);
                                sicklv3.setOnClickListener(rounclick);
                                sicklv4.setOnClickListener(rounclick);
                                sicklv5.setOnClickListener(rounclick);
                                sicklv6.setOnClickListener(rounclick);
                                sicklv7.setOnClickListener(rounclick);
                                sicklv8.setOnClickListener(rounclick);
                                anl.setOnClickListener(rounclick);

                                TextView close = (TextView) vtot
                                        .findViewById(R.id.close);

                                close.setVisibility(View.GONE);
                                EditText ButtonSet = (EditText) vtot
                                        .findViewById(R.id.ButtonSet);

                                ButtonSet
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View v) {

                                                dialog_box1.dismiss();
                                            }
                                        });
                                close.setTypeface(font);

                                close.setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {

                                        dialog_box1.dismiss();
                                    }
                                });
                                EditText description = (EditText) vtot
                                        .findViewById(R.id.EdittextDescription);
                                Utility.hideKeyboard(description);

                                final EditText edittime = (EditText) vtot
                                        .findViewById(R.id.edittime);
                                edittime.setOnClickListener(new OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // show the time picker dialog
                                        TimePickerFragment newFragment = new TimePickerFragment();
                                        CalendarClass.editTextForDate = edittime;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "timepicker");

                                    }
                                });

                                final EditText edittime89 = (EditText) vtot
                                        .findViewById(R.id.edittime1);
                                edittime89
                                        .setOnClickListener(new OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                // show the time picker dialog
                                                TimePickerFragment newFragment = new TimePickerFragment();
                                                CalendarClass.editTextForDate = edittime89;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "timepicker");

                                            }
                                        });

                                final EditText edittextDuedate1 = (EditText) vtot
                                        .findViewById(R.id.edittextDuedate1);

                                edittextDuedate1
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View arg0) {
                                                DialogFragment newFragment = new DatePickerFragment();
                                                CalendarClass.editTextForDate = edittextDuedate1;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "datePicker");
                                            }
                                        });

                                final EditText edittextDuedate = (EditText) vtot
                                        .findViewById(R.id.edittextDuedate);

                                edittextDuedate
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View arg0) {
                                                DialogFragment newFragment = new DatePickerFragment();
                                                CalendarClass.editTextForDate = edittextDuedate;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "datePicker");
                                            }
                                        });

                                vtot.setLayoutParams(tableRowLayoutParams5);
                                lin1.addView(vtot);
                            } else if (count == 0) {
                                View vf = lin1.getChildAt(0);
                                lin1.removeAllViews();
                                lin1.addView(vf);
                                LinearLayout.LayoutParams tableRowLayoutParams4 = new LinearLayout.LayoutParams(
                                        0,
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        2.5f);

                                View vunlisted = inflater.inflate(
                                        R.layout.add_unlisted, null);
                                vunlisted.setBackgroundColor(Color.TRANSPARENT);
                                vunlisted
                                        .setLayoutParams(tableRowLayoutParams4);

                                // /date
                                final EditText edittextDuedate = (EditText) vunlisted
                                        .findViewById(R.id.edittextDuedate);

                                edittextDuedate
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View v) {
                                                DialogFragment newFragment = new DatePickerFragment();
                                                CalendarClass.editTextForDate = edittextDuedate;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "datePicker");
                                            }
                                        });

                                // Time

                                final EditText edittime = (EditText) vunlisted
                                        .findViewById(R.id.edittime);

                                edittime.setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        // show the time picker dialog
                                        TimePickerFragment newFragment = new TimePickerFragment();
                                        CalendarClass.editTextForDate = edittime;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "timepicker");

                                    }
                                });

                                EditText ButtonSet = (EditText) vunlisted
                                        .findViewById(R.id.ButtonSet);

                                ButtonSet
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View v) {

                                                dialog_box1.dismiss();
                                            }
                                        });

                                TextView close = (TextView) vunlisted
                                        .findViewById(R.id.close);
                                close.setTypeface(font);
                                close.setVisibility(View.VISIBLE);
                                close.setVisibility(View.GONE);

                                lin1.addView(vunlisted);
                            } else if (count == 2 || count == 1) {
                                View vf = lin1.getChildAt(0);
                                lin1.removeAllViews();
                                lin1.addView(vf);
                                LinearLayout.LayoutParams tableRowLayoutParams4 = new LinearLayout.LayoutParams(
                                        0,
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        2.5f);

                                View vunlisted = inflater.inflate(
                                        R.layout.add_unlisted, null);
                                vunlisted.setBackgroundColor(Color.TRANSPARENT);
                                TextView TextViewActionPoint = (TextView) vunlisted
                                        .findViewById(R.id.TextViewActionPoint);

                                TextViewActionPoint.setText("Add Details");

                                TextView phyname = (TextView) vunlisted
                                        .findViewById(R.id.phyname);

                                TextView psc = (TextView) vunlisted
                                        .findViewById(R.id.spec);
                                psc.setVisibility(View.INVISIBLE);

                                Spinner spphy = (Spinner) vunlisted
                                        .findViewById(R.id.typeofphy1);
                                spphy.setVisibility(View.INVISIBLE);
                                phyname.setText("Name");

                                vunlisted
                                        .setLayoutParams(tableRowLayoutParams4);

                                // /date
                                final EditText edittextDuedate = (EditText) vunlisted
                                        .findViewById(R.id.edittextDuedate);

                                edittextDuedate
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View v) {
                                                DialogFragment newFragment = new DatePickerFragment();
                                                CalendarClass.editTextForDate = edittextDuedate;
                                                newFragment.show(
                                                        ((Activity) context)
                                                                .getFragmentManager(),
                                                        "datePicker");
                                            }
                                        });

                                // Time

                                final EditText edittime = (EditText) vunlisted
                                        .findViewById(R.id.edittime);

                                edittime.setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        // show the time picker dialog
                                        TimePickerFragment newFragment = new TimePickerFragment();
                                        CalendarClass.editTextForDate = edittime;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "timepicker");

                                    }
                                });

                                EditText ButtonSet = (EditText) vunlisted
                                        .findViewById(R.id.ButtonSet);

                                ButtonSet
                                        .setOnClickListener(new OnClickListener() {

                                            @Override
                                            public void onClick(View v) {

                                                dialog_box1.dismiss();
                                            }
                                        });

                                TextView close = (TextView) vunlisted
                                        .findViewById(R.id.close);

                                close.setVisibility(View.GONE);

                                lin1.addView(vunlisted);
                            } else if (count == 3) {
                                View vf = lin1.getChildAt(0);
                                lin1.removeAllViews();
                                lin1.addView(vf);
                                LinearLayout.LayoutParams tableRowLayoutParams4 = new LinearLayout.LayoutParams(
                                        0,
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        2.5f);

                                View vunlisted = inflater.inflate(
                                        R.layout.add_action_points, null);
                                vunlisted.setBackgroundColor(Color.TRANSPARENT);
                                vunlisted
                                        .setLayoutParams(tableRowLayoutParams4);

                                AutoCompleteTextView mySpinner = (AutoCompleteTextView) vunlisted
                                        .findViewById(R.id.typeofphydr);

                                mySpinner
                                        .setAdapter(new MyAdapterforspinner(
                                                context, R.layout.exrow_second,
                                                Drname));

                                mySpinner.setThreshold(1);

                                lin1.addView(vunlisted);
                            }

                            dialog_box1.cancel();

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
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box1.getWindow().setLayout(300, 570);
                dialog_box1.show();

            }
        });

    }

    OnClickListener rounclick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

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
                // anl.setBackgroundResource(R.drawable.round);
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
            } else if (v.getId() == R.id.ButtonSet) {
                dialog_box2.dismiss();

            } else if (v.getId() == R.id.tot) {

            } else if (v.getId() == R.id.todo) {

            }

        }
    };

    void calldialogugemenu(View v) {

        dialog_box1 = new Dialog(context);
        dialog_box1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_box1.setContentView(R.layout.calenderlistdialog);
        LinearLayout left = (LinearLayout)

                dialog_box1.findViewById(R.id.linlist);

        for (int i = 0; i < maindata.length; i++) {
            TextView textView = new TextView(context);
            View v1 = new View(context);
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

                        final Dialog d = new Dialog(context);
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

                        Spinner spinner = (Spinner) d
                                .findViewById(R.id.totspin);
                        spinner.setVisibility(View.VISIBLE);

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
                        d.getWindow().setLayout(470, 670);
                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

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
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

                        final EditText edittime89 = (EditText) d
                                .findViewById(R.id.edittime1);
                        edittime89.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime89;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

                        final EditText edittextDuedate1 = (EditText) d
                                .findViewById(R.id.edittextDuedate1);

                        edittextDuedate1
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View arg0) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate1;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        final EditText edittextDuedate = (EditText) d
                                .findViewById(R.id.edittextDuedate);

                        edittextDuedate
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View arg0) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        d.show();

                    } else if (count == 5) {

                        final Dialog d = new Dialog(context);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.addleavedialog);

                        sicklv = (TextView) d.findViewById(R.id.sicklv);
                        anl = (TextView) d.findViewById(R.id.allv);

                        Spinner spinner = (Spinner) d
                                .findViewById(R.id.leavespin);
                        spinner.setVisibility(View.VISIBLE);

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

                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

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
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

                        final EditText edittime89 = (EditText) d
                                .findViewById(R.id.edittime1);
                        edittime89.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime89;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

                        final EditText edittextDuedate1 = (EditText) d
                                .findViewById(R.id.edittextDuedate1);

                        edittextDuedate1
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View arg0) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate1;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        final EditText edittextDuedate = (EditText) d
                                .findViewById(R.id.edittextDuedate);

                        edittextDuedate
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View arg0) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });
                        d.getWindow().setLayout(470, 670);
                        d.show();

                    } else if (count == 0) {

                        final Dialog d = new Dialog(context);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.add_unlisted);

                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);
                        // /date
                        final EditText edittextDuedate = (EditText) d
                                .findViewById(R.id.edittextDuedate);

                        edittextDuedate
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        // Time

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);

                        edittime.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });

                        d.show();

                    } else if (count == 1 || count == 2) {

                        final Dialog d = new Dialog(context);
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

                        // /date
                        final EditText edittextDuedate = (EditText) d
                                .findViewById(R.id.edittextDuedate);

                        edittextDuedate
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        // Time

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);

                        edittime.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

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

                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });

                        d.show();

                    } else if (count == 3) {

                        final Dialog d = new Dialog(context);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.add_action_points);

                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        AutoCompleteTextView mySpinner = (AutoCompleteTextView) d
                                .findViewById(R.id.typeofphydr);
                        mySpinner.setAdapter(new MyAdapterforspinner(context,
                                R.layout.exrow_second, Drname));

                        mySpinner.setThreshold(1);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

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

                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);
                        edittime.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) { // show the time
                                // picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");
                            }
                        });
                        AutoCompleteTextView mySpinner1 = (AutoCompleteTextView) d
                                .findViewById(R.id.typeofphydr);

                        mySpinner1.setAdapter(new MyAdapterforspinner(context,
                                R.layout.exrow_second, Drname));

                        mySpinner.setThreshold(1);
                        d.show();

                    } else if (count == 6) {

                        dialog_box1.dismiss();
                        updateBarHandler = new Handler();
                        launchBarDialog();
                        selectmont = 1;

                        CalendarClass.srchflag = 1;
                        updateCalendar();

                        undo.setVisibility(View.VISIBLE);
                        // cancel.setVisibility(View.VISIBLE);
                        // done.setVisibility(View.VISIBLE);

                        ExpandablelistviewfordocNEW list = new ExpandablelistviewfordocNEW(
                                context, "", 2);
                        CalendarClass.rl1.removeAllViews();
                        View v1 = list.multilevleexpandalelistview();
                        CalendarClass.rl1.addView(v1);

                    } else if (count == 7) {

                        // RelativeLayout layout = (RelativeLayout) dialog_box1
                        // .findViewById(R.id.relogout1);
                        //
                        // final TextView backfotviewplan = (TextView)
                        // dialog_box1
                        // .findViewById(R.id.backfotviewplan);

                        if (indexforplan == 1) {
                            maindata[7] = "View Plan";

                        } else {

                            maindata[7] = "Manual";
                            // backfotviewplan.setText("");
                        }

                        if (indexforplan == 1) {
                            indexforplan = 0;
                            ExpandablelistviewfordocNEW list = new ExpandablelistviewfordocNEW(
                                    context, "", 1);
                            CalendarClass.rl1.removeAllViews();
                            View v1 = list.multilevleexpandalelistview();
                            CalendarClass.rl1.addView(v1);
                            selectmont = 0;
                            CalendarClass.srchflag = 1;
                            updateCalendar();

                        } else {
                            ExpandablelistviewfordocNEW list = new ExpandablelistviewfordocNEW(
                                    context, "", 2);
                            CalendarClass.rl1.removeAllViews();
                            View v1 = list.multilevleexpandalelistview();
                            CalendarClass.rl1.addView(v1);
                            selectmont = 1;
                            CalendarClass.srchflag = 0;
                            indexforplan = 1;
                            updateCalendar();
                        }

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

        dialog_box1 = new Dialog(context);
        dialog_box1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_box1.setContentView(R.layout.makeplandilaog);

        RelativeLayout layout = (RelativeLayout) dialog_box1
                .findViewById(R.id.relogout1);

        final TextView backfotviewplan = (TextView) dialog_box1
                .findViewById(R.id.backfotviewplan);

        if (indexforplan == 1) {

        } else {

            backfotviewplan.setText("View Plan");
        }

        layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (indexforplan == 1) {
                    indexforplan = 0;
                    ExpandablelistviewfordocNEW list = new ExpandablelistviewfordocNEW(
                            context, "", 1);
                    CalendarClass.rl1.removeAllViews();
                    View v1 = list.multilevleexpandalelistview();
                    CalendarClass.rl1.addView(v1);
                    selectmont = 0;
                    CalendarClass.srchflag = 1;
                    updateCalendar();

                } else {
                    ExpandablelistviewfordocNEW list = new ExpandablelistviewfordocNEW(
                            context, "", 2);
                    CalendarClass.rl1.removeAllViews();
                    View v1 = list.multilevleexpandalelistview();
                    CalendarClass.rl1.addView(v1);
                    selectmont = 1;
                    CalendarClass.srchflag = 0;
                    indexforplan = 1;
                    updateCalendar();
                }

                dialog_box1.dismiss();

            }
        });

        RelativeLayout ATP = (RelativeLayout) dialog_box1
                .findViewById(R.id.relogout);

        ATP.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog_box1.dismiss();
                updateBarHandler = new Handler();
                launchBarDialog();
                selectmont = 1;

                CalendarClass.srchflag = 1;
                updateCalendar();

                undo.setVisibility(View.VISIBLE);
                // cancel.setVisibility(View.VISIBLE);
                // done.setVisibility(View.VISIBLE);

                ExpandablelistviewfordocNEW list = new ExpandablelistviewfordocNEW(
                        context, "", 2);
                CalendarClass.rl1.removeAllViews();
                View v1 = list.multilevleexpandalelistview();
                CalendarClass.rl1.addView(v1);

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
        dialog_box1.getWindow().setLayout(280, 170);
        dialog_box1.show();

    }

    void alert(View v) {

        dialog_box1 = new Dialog(context);
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
        // WindowManager.LayoutParams wmlp = dialog_box1.getWindow()
        // .getAttributes();
        // int[] viewLocation = new int[2];
        // v.getLocationOnScreen(viewLocation);
        // wmlp.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;
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

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

        private void updateLabel() {

            String myFormat = "dd/MM/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            edittextDuedate.setText(sdf.format(myCalendar.getTime()));
        }

    };

    public void launchBarDialog() {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(context,
                "Please wait ...", "Preparing ...", true);
        ringProgressDialog.setCancelable(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Here you should write your time consuming task...
                    // Let the progress ring for 10 seconds...
                    Thread.sleep(5000);
                } catch (Exception e) {

                }

                try {

                    ringProgressDialog.dismiss();
                } catch (Exception e) {
                    ringProgressDialog.dismiss();

                }

            }
        }).start();
    }

    public void actionpointdailog() {

        // TODO Auto-generated method stub
        final Dialog dialog_box = new Dialog(context);
        PlaylistFragment fragment = new PlaylistFragment();
        View view = fragment.actionPointView(context, "92");
        LinearLayout parent = new LinearLayout(context);
        parent.setOrientation(LinearLayout.VERTICAL);
        dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        param2.topMargin = 5;
        param2.rightMargin = 10;
        param2.leftMargin = 10;
        param2.bottomMargin = -2;

        TextView cross = new TextView(context);
        cross.setText(context.getResources().getString(R.string.icon_cross));
        cross.setTextSize(28);
        cross.setGravity(Gravity.RIGHT);
        cross.setLayoutParams(param2);
        cross.setTypeface(font);
        cross.setTextColor(Color.BLACK);

        parent.addView(cross);
        parent.addView(view);

        cross.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog_box.dismiss();
            }
        });
        dialog_box.setContentView(parent);
        dialog_box.getWindow().setBackgroundDrawableResource(
                R.drawable.bg_roundedwhite);

        dialog_box.getWindow().setLayout(650, 600);
        dialog_box.show();

    }
}