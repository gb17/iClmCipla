package com.cirrius.iclmcipla;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainForCalforcalenser extends Activity {
    CalendarView calendar;
    private TextView titlename;
    private TextView meter;
    private TextView search;
    private TextView plan;
    private TextView add;
    private TextView conatiner;
    private TextView menu;
    Typeface font;

    String headerText[] = {"A", "C", "D", "G", "H", "J", "K", "M", "N", "P",
            "R", "S", "T", "V"};
    String secondHeaderTitle[] = {"", "", "", "", "", "", "", "", "", "", "",
            "", "", ""};
    String secondHeaderVisibilty[] = {"A", "C", "D", "G", "H", "J", "K", "M", "N", "P",
            "R", "S", "T", "V"};

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_calfor);

        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        findViews();
        ListComponentForCal list = new ListComponentForCal(MainForCalforcalenser.this,
                headerText, secondHeaderTitle, secondHeaderVisibilty, drName,
                spec);
        View v = list.getcompoentView();
        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
        rl1.addView(v);
        initializeCalendar();
    }

    private void findViews() {
        titlename = (TextView) findViewById(R.id.titlename);
        titlename.setTypeface(font);

        meter = (TextView) findViewById(R.id.meter);
        meter.setTypeface(font);

        search = (TextView) findViewById(R.id.search);
        search.setTypeface(font);

        plan = (TextView) findViewById(R.id.plan);
        plan.setTypeface(font);

        add = (TextView) findViewById(R.id.add);
        add.setTypeface(font);

        conatiner = (TextView) findViewById(R.id.conatiner);
        conatiner.setTypeface(font);

        menu = (TextView) findViewById(R.id.menu);
        menu.setTypeface(font);
    }

    public void initializeCalendar() {

        calendar = (CalendarView) findViewById(R.id.calendar);

        // sets whether to show the week number.

        calendar.setShowWeekNumber(false);

        // sets the first day of week according to Calendar.
        // here we set Monday as the first day of the Calendar

        calendar.setFirstDayOfWeek(2);

        // The background color for the selected week.

        calendar.setSelectedWeekBackgroundColor(getResources().getColor(
                R.color.pink));

        // sets the color for the dates of an unfocused month.

        calendar.setUnfocusedMonthDateColor(getResources().getColor(
                R.color.transparent));

        // sets the color for the separator line between weeks.

        calendar.setWeekSeparatorLineColor(getResources().getColor(
                R.color.black));

        // sets the color for the vertical bar shown at the beginning and at the
        // end of the selected date.

        calendar.setSelectedDateVerticalBar(R.color.black);

        // sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new OnDateChangeListener() {

            // show the selected date as a toast

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int day) {

                Toast.makeText(getApplicationContext(),
                        day + "/" + month + "/" + year, Toast.LENGTH_LONG)
                        .show();

            }

        });

    }

}
