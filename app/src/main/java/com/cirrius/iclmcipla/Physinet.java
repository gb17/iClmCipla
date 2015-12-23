package com.cirrius.iclmcipla;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Physinet extends Activity {
    String headename[] = {"ACTIVE", "Overdues"};
    String count[] = {"05", "02"};

    String[] maindata1foractive = {"John Hemsworth (Brand Manager)",
            "",
            "Liam Neeson(Zonal Manager)",
            " ",
            "",
            "Self",
            "", "DR.Alan Rodrik"
    };


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
    TextView ty;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physinetmain);
        ty = (TextView) findViewById(R.id.txtrt34);
        b1 = (Button) findViewById(R.id.bt1athach);
        vForAP = new View(Physinet.this);
        vForindciator = new TextView(Physinet.this);
        try {

            Bundle extras = getIntent().getExtras();
            //	history = extras.getString("indextype");
            history = "2";


        } catch (Exception e) {
            history = "";
            e.printStackTrace();
        }
        font = Typeface.createFromAsset(this.getAssets(),
                "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "PHYZIINET");

        mListView = (ListView) findViewById(R.id.listview);


        for (int j = 0; j < maindata1foractive.length; j++) {
            mArrayListg.add(maindata1foractive[j]);
        }
        for (int j = 0; j < maindata1foraoverdue.length; j++) {
            mArrayListgover.add(maindata1foraoverdue[j]);
        }

        MyPAdapter myAdapter = new MyPAdapter(mArrayListg);
        //adapter.addSection(null, "0", myAdapter);

//		if (!history.equals("1")) {
//			MyAdapter myAdapter2 = new MyAdapter(mArrayListgover);
//			adapter.addSection(null, null, myAdapter2);
//		}

        mListView.setAdapter(myAdapter);
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(
                        Intent.ACTION_PICK);
                photoPickerIntent
                        .setType("image/*");
                startActivityForResult(
                        photoPickerIntent,
                        1);
            }
        });


    }

    public class MyPAdapter extends BaseAdapter {
        String[] activedata2 = {"Your request for samples has been approved",
                "CME event Scheduled for Tommorow",
                "Review Meeting on 27th September",
                "Today is Physician Charles Best's birthday",

                "Leave Approval pending since two weeks",
                "Content Revision -Acenomorol", " Doctor Call Average below standard norms",
                "Mezzodrop samples Needed"};


        Integer[] imagD = {R.drawable.manager1, R.drawable.calender21icon, R.drawable.manager2, R.drawable.cake31, R.drawable.alert21, R.drawable.ic_account_box_black_48dp, R.drawable.alert21, R.drawable.doc1};

        String[] activedata3 = {"",
                "Assigned to : Reasearch | Research Manager , C-Fix",
                "Assigned to : Finance | Finance Manager , C-Fix",
                "Assigned to : Reasearch | Research Manager , C-Fix",
                "Assigned to : Reasearch | Research Manager , C-Fix"};
        ArrayList<String> mArrayList = new ArrayList<String>();
        Context con;

        public MyPAdapter(ArrayList<String> mArrayList) {
            this.mArrayList = mArrayList;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            viewHolder = new ViewHolderItem();

            if (convertView == null) {

                LayoutInflater inflater = (LayoutInflater) Physinet.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.physinetsubitem, null);

                viewHolder.childiewoflist = (LinearLayout) convertView
                        .findViewById(R.id.childiewoflist);


                viewHolder.imageD = (ImageView) convertView
                        .findViewById(R.id.dr_image);

                viewHolder.indicator = (TextView) convertView
                        .findViewById(R.id.indicatyor);
                viewHolder.indicator.setTypeface(font);
                viewHolder.childiewoflist.setTag("" + position);


//		

                viewHolder.childiewoflist
                        .setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v1) {
                                if (v1.getTag().equals("0") || v1.getTag().equals("2")) {
                                    if (v1.getTag().equals("0")) {
                                        ty.setText("John Hemsworth");
                                    } else {
                                        ty.setText("Liam Neeson");
                                    }

                                    vForAP.setBackgroundColor(Color
                                            .parseColor("#e0e0e0"));
                                    v1.setBackgroundColor(Color
                                            .parseColor("#9e9e9e"));

                                    vForAP = v1;
                                    TextView tv = (TextView) ((RelativeLayout) ((LinearLayout) v1)
                                            .getParent()).getChildAt(1);

                                    vForindciator.setTextColor(Color.TRANSPARENT);
                                    tv.setTextColor(Color.parseColor("#9e9e9e"));

                                    vForindciator = tv;
                                }


//						

                            }
                        });

                viewHolder.indicator.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v1) {

                    }
                });

                viewHolder.textViewItem = (TextView) convertView
                        .findViewById(R.id.item);
                viewHolder.textdata2 = (TextView) convertView
                        .findViewById(R.id.textViewItemPrice);


//			viewHolder.textdata3 = (TextView) convertView
//					.findViewById(R.id.childtextview3);

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
            if (position == 1 || position == 3 || position == 6 || position == 4) {
                viewHolder.textViewItem.setVisibility(View.GONE);
            }


            viewHolder.textViewItem.setText(mArrayList.get(position));
            viewHolder.textdata2.setText(activedata2[position]);
            viewHolder.imageD.setImageResource(imagD[position]);
            //viewHolder.textdata3.setText(activedata3[position]);
            //viewHolder.time.setText(timeactive[position]);

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
        ImageView imageD;
        TextView indicator;

        LinearLayout childiewoflist;

        TextView time;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub


        return true;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.drawable.plus) {

            // TODO Auto-generated method stub
            final Dialog d = new Dialog(Physinet.this);
            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
            d.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.R.color.transparent));
            d.setContentView(R.layout.add_action_points);

            TextView close = (TextView) d.findViewById(R.id.close);
            EditText ButtonSet = (EditText) d.findViewById(R.id.ButtonSet);

            AutoCompleteTextView mySpinner = (AutoCompleteTextView) d
                    .findViewById(R.id.typeofphydr);
            mySpinner.setAdapter(new MyAdapterforspinner(Physinet.this,
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

                    new DatePickerDialog(Physinet.this, date, myCalendar
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
                    mTimePicker = new TimePickerDialog(Physinet.this,
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

            Intent intent = new Intent(Physinet.this, ActionPoint.class);
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
            LayoutInflater inflater = (LayoutInflater) Physinet.this
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
