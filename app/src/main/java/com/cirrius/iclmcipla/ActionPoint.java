package com.cirrius.iclmcipla;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ActionPoint extends Activity {
    String headename[] = {"ACTIVE", "Overdues"};
    String count[] = {"05", "02"};

    String[] maindata1foractive = {"Samples | C-Fix",
            "Samples | C-Fix ,Mezzo drop,Solsuna +2",
            "Samples | Mezzo drop,Solsuna +2", "C-Fix", "Mezzo drops"};

    String[] timeactive = {"23 July 15", "25 July 15", "26 July 15",
            "28 July 15", "29 July 15"};

    String[] timeoverdue = {"23 July 15", "25 July 15"};
    String[] maindata1foraoverdue = {"Solsuna", "Mezo Drop"};
    ArrayList<String> mArrayListg = new ArrayList<String>();
    ArrayList<String> mArrayListgover = new ArrayList<String>();
    Calendar myCalendar = Calendar.getInstance();
    private Typeface font;
    EditText edittextDuedate;
    TextView globaltextchk;

    int iconint[] = {0, 1, 2, 2, 1};

    int iconcolor[] = {1, 1, 2, 2, 1};

    private ListView mListView;

    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4};

    private String[] Drname = {"Alan Spiegel", "Alexander Fleming",
            "Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk"};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Class B", "Class A", "Class C", "Class C", "Class B"};

    private TextView editpencil;

    String history = "";
    View vForAP;

    TextView vForindciator;

    ViewHolderItem viewHolder = null;
    private MyAdapter myAdapter;

    View convertView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secactivity_main);
        TextView plus = (TextView) findViewById(R.id.plus);
        plus.setVisibility(View.INVISIBLE);
        ImageView historyIcon = (ImageView) findViewById(R.id.history);
        historyIcon.setVisibility(View.INVISIBLE);
        vForAP = new View(ActionPoint.this);
        vForindciator = new TextView(ActionPoint.this);
        try {

            Bundle extras = getIntent().getExtras();
            history = extras.getString("indextype");

            if (history.equals("1")) {

            }

        } catch (Exception e) {
            history = "";
            e.printStackTrace();
        }
        font = Typeface.createFromAsset(this.getAssets(),
                "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Action Points");

        mListView = (ListView) findViewById(R.id.listview);

        TextView attach = (TextView) findViewById(R.id.attach);
        attach.setTypeface(font);

        editpencil = (TextView) findViewById(R.id.editpencil);
        editpencil.setTypeface(font);
        TextView addfrnd18 = (TextView) findViewById(R.id.addfrnd18);
        addfrnd18.setTypeface(font);

        TextView addfrnd = (TextView) findViewById(R.id.addfrnd);
        addfrnd.setTypeface(font);

        RelativeLayout fwdmsg = (RelativeLayout) findViewById(R.id.fwdmsg);

        fwdmsg.setOnLongClickListener(new OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                // Dialog 1
                final Dialog d = new Dialog(ActionPoint.this);

                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.ap_fedmsg);

                TextView chk = (TextView) d.findViewById(R.id.close);
                chk.setTypeface(font);

                TextView attach = (TextView) d.findViewById(R.id.attach);
                attach.setTypeface(font);

                TextView addfrnd = (TextView) d.findViewById(R.id.addfrnd);
                addfrnd.setTypeface(font);

                TextView doneap = (TextView) d.findViewById(R.id.doneap);

                doneap.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss(); // TODO Auto-generated
                        // method stub

                    }
                });

                chk.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss(); // TODO Auto-generated
                        // method stub

                    }
                });

                doneap.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss(); // TODO Auto-generated
                        // method stub

                    }
                });

                Window window = d.getWindow();

                WindowManager.LayoutParams wmlp = d.getWindow().getAttributes();

                int[] viewLocation = new int[2];
                v.getLocationOnScreen(viewLocation);
                d.getWindow().setLayout(500, 600);

                // wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                // wmlp.x = viewLocation[0];
                // wmlp.y = viewLocation[1];
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                if (!history.equals("1")) {
                    d.show();
                }

                return true;
            }
        });

        SectionedAdapter adapter = new SectionedAdapter() {
            @Override
            protected View getHeaderView(String caption, String count,
                                         int index, View convertView, ViewGroup parent) {

                convertView = ActionPoint.this.getLayoutInflater().inflate(
                        R.layout.section_header, null);
                TextView header = (TextView) convertView
                        .findViewById(R.id.header);

                TextView redo = (TextView) convertView
                        .findViewById(R.id.textViewtime);
                redo.setText(count);
                header.setText(caption);
                return convertView;
            }
        };

        if (history.equals("1")) {
            headename[0] = "History";
        }

        for (int j = 0; j < maindata1foractive.length; j++) {
            mArrayListg.add(maindata1foractive[j]);
        }
        for (int j = 0; j < maindata1foraoverdue.length; j++) {
            mArrayListgover.add(maindata1foraoverdue[j]);
        }

        myAdapter = new MyAdapter(mArrayListg);
        adapter.addSection(headename[0], count[0], myAdapter);

        if (!history.equals("1")) {
            MyAdapter myAdapter2 = new MyAdapter(mArrayListgover);
            adapter.addSection(headename[1], count[1], myAdapter2);
        }
        if (history.equals("1")) {
            editpencil.setVisibility(View.GONE);
        }
        mListView.setAdapter(adapter);

        editpencil.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                final Dialog d = new Dialog(ActionPoint.this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.add_action_points);

                TextView close = (TextView) d.findViewById(R.id.close);
                EditText ButtonSet = (EditText) d.findViewById(R.id.ButtonSet);

                TextView title = (TextView) d
                        .findViewById(R.id.TextViewActionPoint);
                title.setText("EDIT ACTION POINT");

                Spinner typSpinner = (Spinner) d.findViewById(R.id.typeofphy);
                typSpinner.setSelection(1);
                typSpinner.setEnabled(false);

                AutoCompleteTextView mySpinner = (AutoCompleteTextView) d
                        .findViewById(R.id.typeofphydr);

                mySpinner.setAdapter(new MyAdapterforspinner(ActionPoint.this,
                        R.layout.exrow_second, Drname));

                mySpinner.setText("Dr Alan Spiegel");
                mySpinner.setEnabled(false);

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
                edittextDuedate.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub

                        new DatePickerDialog(ActionPoint.this, date, myCalendar
                                .get(Calendar.YEAR), myCalendar
                                .get(Calendar.MONTH), myCalendar
                                .get(Calendar.DAY_OF_MONTH)).show();

                    }
                });

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
                        mTimePicker = new TimePickerDialog(ActionPoint.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(
                                            TimePicker timePicker,
                                            int selectedHour, int selectedMinute) {
                                        edittime.setText(selectedHour + ":"
                                                + selectedMinute);
                                    }
                                }, hour, minute, true);// Yes 24 hour time
                        mTimePicker.setTitle("Select Time");

                        mTimePicker.show();

                    }
                });

                d.show();

            }
        });
    }

    public class MyAdapter extends BaseAdapter {
        String[] activedata2 = {"Need more samples", "Need more samples",
                "Need more samples",
                "Need more clinical trails over competitor ones",
                "Need more clinical trails over competitor ones"};

        String[] activedata3 = {"",
                "Assigned to : Reasearch | Research Manager , C-Fix",
                "Assigned to : Finance | Finance Manager , C-Fix",
                "Assigned to : Reasearch | Research Manager , C-Fix",
                "Assigned to : Reasearch | Research Manager , C-Fix"};
        ArrayList<String> mArrayList = new ArrayList<String>();

        public MyAdapter(ArrayList<String> mArrayList) {
            this.mArrayList = mArrayList;
        }

        public int getCount() {
            return mArrayList.size();
        }

        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView,
                            ViewGroup parent) {

            viewHolder = new ViewHolderItem();

            if (convertView == null) {

                LayoutInflater inflater = (LayoutInflater) ActionPoint.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.section_item, null);

                viewHolder.childiewoflist = (LinearLayout) convertView
                        .findViewById(R.id.childiewoflist);

                viewHolder.chkbox = (TextView) convertView
                        .findViewById(R.id.chkbox);
                viewHolder.chkbox.setTypeface(font);

                viewHolder.threedot = (TextView) convertView
                        .findViewById(R.id.drmenu);
                viewHolder.time = (TextView) convertView
                        .findViewById(R.id.time);

                viewHolder.attach = (TextView) convertView
                        .findViewById(R.id.attach);
                viewHolder.attach.setTypeface(font);

                viewHolder.comment = (TextView) convertView
                        .findViewById(R.id.comment);
                viewHolder.comment.setTypeface(font);

                viewHolder.addfrnd = (TextView) convertView
                        .findViewById(R.id.addfrnd);
                viewHolder.addfrnd.setTypeface(font);

                viewHolder.indicator = (TextView) convertView
                        .findViewById(R.id.indicatyor);
                viewHolder.indicator.setTypeface(font);

                final LinearLayout childiewoflist = (LinearLayout) convertView
                        .findViewById(R.id.childiewoflist);

                final TextView chkbox = (TextView) convertView
                        .findViewById(R.id.chkbox);

                final TextView indicatyor = (TextView) convertView
                        .findViewById(R.id.indicatyor);
                if (iconint[position] == 0) {
                    viewHolder.attach.setVisibility(View.INVISIBLE);
                    viewHolder.comment.setVisibility(View.INVISIBLE);
                    viewHolder.addfrnd.setVisibility(View.INVISIBLE);

                } else if (iconint[position] == 2) {
                    // viewHolder.addfrnd.setVisibility(View.GONE);
                } else if (iconint[position] == 1) {
                    viewHolder.comment.setVisibility(View.INVISIBLE);
                    // viewHolder.addfrnd.setVisibility(View.GONE);

                }

                viewHolder.chkbox.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (((TextView) v).getCurrentTextColor() == Color
                                .parseColor("#333333")) {
                            ((TextView) v).setTextColor(Color
                                    .parseColor("#9e9e9e"));

                            globaltextchk = ((TextView) v);

                        } else {
                            ((TextView) v).setTextColor(Color
                                    .parseColor("#333333"));
                            // Dialog 1

                            globaltextchk = ((TextView) v);
                            final Dialog d = new Dialog(ActionPoint.this);

                            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            d.getWindow().setBackgroundDrawable(
                                    new ColorDrawable(
                                            android.R.color.transparent));
                            d.setContentView(R.layout.traingel);

                            TextView chk = (TextView) d.findViewById(R.id.tri);
                            chk.setTypeface(font);

                            Window window = d.getWindow();

                            WindowManager.LayoutParams wmlp = d.getWindow()
                                    .getAttributes();

                            int[] viewLocation = new int[2];
                            v.getLocationOnScreen(viewLocation);

                            wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                            wmlp.x = viewLocation[0] + 13;
                            wmlp.y = viewLocation[1] - 32;
                            window.setBackgroundDrawable(new ColorDrawable(
                                    Color.TRANSPARENT));
                            // Dialog two
                            final Dialog d1 = new Dialog(ActionPoint.this);

                            d1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            d1.getWindow().setBackgroundDrawable(
                                    new ColorDrawable(
                                            android.R.color.transparent));
                            d1.setContentView(R.layout.actionpoint_colouser_ap);

                            TextView chk1 = (TextView) d1
                                    .findViewById(R.id.chkboxd);
                            chk1.setTypeface(font);

                            Window window1 = d1.getWindow();

                            WindowManager.LayoutParams wmlp1 = d1.getWindow()
                                    .getAttributes();

                            int[] viewLocation1 = new int[2];
                            v.getLocationOnScreen(viewLocation1);

                            wmlp1.gravity = Gravity.TOP | Gravity.LEFT;
                            wmlp1.x = viewLocation1[0] + 26;
                            wmlp1.y = viewLocation1[1] - 64;
                            window1.setBackgroundDrawable(new ColorDrawable(
                                    Color.TRANSPARENT));
                            d1.getWindow().setLayout(350, 300);

                            d.show();
                            d1.show();

                            TextView doneap = (TextView) d1
                                    .findViewById(R.id.doneap);
                            doneap.setOnClickListener(new OnClickListener() {

                                @Override
                                public void onClick(View v) {

                                    chkbox.setVisibility(View.GONE);
                                    indicatyor.setVisibility(View.GONE);
                                    childiewoflist.setVisibility(View.GONE);
                                    d1.dismiss(); // TODO Auto-generated
                                    // method stub

                                    d1.dismiss();
                                    d1.dismiss();
                                }
                            });

                            d1.setOnDismissListener(new OnDismissListener() {

                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    globaltextchk.setTextColor(Color
                                            .parseColor("#9e9e9e"));
                                    d.dismiss();

                                }
                            });
                        }

                    }
                });

                viewHolder.childiewoflist
                        .setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v1) {

                                vForAP.setBackgroundColor(Color
                                        .parseColor("#e0e0e0"));
                                v1.setBackgroundColor(Color
                                        .parseColor("#9e9e9e"));

                                vForAP = v1;

                                TextView tv = (TextView) ((RelativeLayout) ((LinearLayout) v1)
                                        .getParent()).getChildAt(2);

                                vForindciator.setTextColor(Color.TRANSPARENT);
                                tv.setTextColor(Color.parseColor("#9e9e9e"));

                                vForindciator = tv;

                            }
                        });

                viewHolder.textViewItem = (TextView) convertView
                        .findViewById(R.id.item);
                viewHolder.textdata2 = (TextView) convertView
                        .findViewById(R.id.textViewItemPrice);

                viewHolder.textdata3 = (TextView) convertView
                        .findViewById(R.id.childtextview3);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolderItem) convertView.getTag();
            }

            if (position == 2) {
                viewHolder.childiewoflist.setBackgroundColor(Color
                        .parseColor("#9e9e9e"));
                viewHolder.indicator.setTextColor(Color.parseColor("#9e9e9e"));

                vForAP = viewHolder.childiewoflist;
                vForindciator = viewHolder.indicator;

            }

            if (history.equals("1")) {
                viewHolder.chkbox.setVisibility(View.GONE);
            }

            viewHolder.textViewItem.setText(mArrayList.get(position));
            viewHolder.textdata2.setText(activedata2[position]);
            viewHolder.textdata3.setText(activedata3[position]);
            viewHolder.time.setText(timeactive[position]);

            final LinearLayout childiewoflist = (LinearLayout) convertView
                    .findViewById(R.id.childiewoflist);

            final TextView chkbox = (TextView) convertView
                    .findViewById(R.id.chkbox);

            final TextView indicatyor = (TextView) convertView
                    .findViewById(R.id.indicatyor);

            viewHolder.threedot.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (!history.equals("1")) {

                        final Dialog d = new Dialog(ActionPoint.this);

                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.deletedialog);

                        TextView bin = (TextView) d.findViewById(R.id.bin);
                        bin.setTypeface(font);

                        Window window = d.getWindow();

                        WindowManager.LayoutParams wmlp = d.getWindow()
                                .getAttributes();

                        int[] viewLocation = new int[2];
                        v.getLocationOnScreen(viewLocation);

                        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                        wmlp.x = viewLocation[0] + 13;
                        wmlp.y = viewLocation[1] + 4;
                        window.setBackgroundDrawable(new ColorDrawable(
                                Color.TRANSPARENT));
                        d.show();

                        bin.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                d.dismiss();
                                final Dialog d1 = new Dialog(ActionPoint.this);
                                d1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                d1.getWindow().setBackgroundDrawable(
                                        new ColorDrawable(
                                                android.R.color.transparent));
                                d1.setContentView(R.layout.actionpoint_delete_ap);

                                TextView bin = (TextView) d1
                                        .findViewById(R.id.deleted);
                                bin.setTypeface(font);

                                TextView doneap = (TextView) d1
                                        .findViewById(R.id.doneap);
                                doneap.setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        chkbox.setVisibility(View.GONE);
                                        indicatyor.setVisibility(View.GONE);
                                        childiewoflist.setVisibility(View.GONE);
                                        d1.dismiss(); // TODO Auto-generated
                                        // method stub

                                    }
                                });

                                Window window = d1.getWindow();

                                WindowManager.LayoutParams wmlp = d1
                                        .getWindow().getAttributes();

                                int[] viewLocation = new int[2];
                                v.getLocationOnScreen(viewLocation);

                                // wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                                // wmlp.x = viewLocation[0];
                                // wmlp.y = viewLocation[1];
                                // window.setBackgroundDrawable(new
                                // ColorDrawable(
                                // Color.TRANSPARENT));
                                d1.getWindow().setLayout(350, 300);

                                d1.show();

                            }
                        });

                    }
                }
            });

            return convertView;
        }
    }

    public class ViewHolderItem {

        TextView textViewItem;
        TextView textdata2;
        TextView textdata3;
        TextView attach;
        TextView addfrnd;
        TextView comment;
        TextView chkbox;
        TextView threedot;

        TextView indicator;

        LinearLayout childiewoflist;

        TextView time;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        if (!history.equals("1")) {

            menu.add(Menu.NONE, R.drawable.plus, 2, "")
                    .setIcon(R.drawable.plus)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            menu.add(Menu.NONE, R.drawable.history_icon_white, 1, "")
                    .setIcon(R.drawable.history_icon_white)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        }
        return true;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.drawable.plus) {

            // TODO Auto-generated method stub
            final Dialog d = new Dialog(ActionPoint.this);
            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
            d.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.R.color.transparent));
            d.setContentView(R.layout.add_action_points);

            TextView close = (TextView) d.findViewById(R.id.close);
            EditText ButtonSet = (EditText) d.findViewById(R.id.ButtonSet);

            AutoCompleteTextView mySpinner = (AutoCompleteTextView) d
                    .findViewById(R.id.typeofphydr);
            mySpinner.setAdapter(new MyAdapterforspinner(ActionPoint.this,
                    R.layout.exrow_second, Drname));

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
            edittextDuedate = (EditText) d.findViewById(R.id.edittextDuedate);
            edittextDuedate.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                    new DatePickerDialog(ActionPoint.this, date, myCalendar
                            .get(Calendar.YEAR),
                            myCalendar.get(Calendar.MONTH), myCalendar
                            .get(Calendar.DAY_OF_MONTH)).show();

                }
            });

            final EditText edittime = (EditText) d.findViewById(R.id.edittime);
            edittime.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(ActionPoint.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker,
                                                      int selectedHour, int selectedMinute) {
                                    edittime.setText(selectedHour + ":"
                                            + selectedMinute);
                                }
                            }, hour, minute, true);// Yes 24 hour time
                    mTimePicker.setTitle("Select Time");

                    mTimePicker.show();

                }
            });

            d.show();

        } else if (item.getItemId() == R.drawable.history_icon_white) {

            Intent intent = new Intent(ActionPoint.this, ActionPoint.class);
            intent.putExtra("indextype", "1");
            startActivity(intent);

        } else if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return true;
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
            LayoutInflater inflater = (LayoutInflater) ActionPoint.this
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

}