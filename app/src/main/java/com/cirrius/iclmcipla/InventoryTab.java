package com.cirrius.iclmcipla;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.cirrius.iclmcipla.R;
import com.github.mikephil.charting.charts.BarChart;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class InventoryTab extends Activity implements OnClickListener {
    android.widget.TableRow.LayoutParams llp;
    LinearLayout lin;
    TableLayout tbl;
    EditText[] edittext;
    // TableRow tr;
    RelativeLayout rl1, rl2, rl3, rl4, rl5;
    LinearLayout tr;
    LinearLayout main;
    public static TextView textview;
    public static LinearLayout linselction;

    TextView tv;

    Handler updateBarHandler;

    Typeface font;
    ArrayList<String> items = new ArrayList<String>();
    private int count;
    ArrayList<String> name;
    private boolean[] thumbnailsselection;
    private ListView listview;
    // private LinearLayout linearone;
    String url = "";
    String menutext = "";
    String[][] pageData;
    Dialog dialog_box;
    ImageView iv;
    ScrollView fullscroll, fullscrollEdit;
    TextView pen1;
    ImageView done;
    WebView webView;
    int id = 0;
    View vForAP;
    EditText focusedView;
    EditText edittextDuedate;
    Calendar myCalendar = Calendar.getInstance();
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button zero;
    private Button ente;

    private Button btnSeven1;
    private Button btnEight1;
    private Button btnNine1;
    private Button btnFour1;
    private Button btnFive1;
    private Button btnSix1;
    private Button btnOne1;
    private Button btnTwo1;
    private Button btnThree1;
    private Button zero1;
    private Button ente1;

    TextView txt1, txt2, txt3, txt4;
    int countMe = 0;
    int countMeL = 0;
    ImageView rehearse_icon;
    TextView plus;
    ImageView historyIcon;

    boolean flag1 = false;
    boolean flag2 = false;

    String[] ast2 = {"Reported", "Call by Call"};
    String parameters[] = {"Price", "Digitally Inclined", "Side Effects",
            "Availability"};

    protected BarChart mChart;
    protected String[] mMonths = new String[]{"Content", "Abstract", "Query",
            "Fourm", "Detailing", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov",
            "Dec"};
    TextView vForindciator;

    TextView globaltextchk;

    int iconint[] = {0, 1, 2, 2, 1};

    int iconcolor[] = {1, 1, 2, 2, 1};
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

    RelativeLayout invent;
    TextView inventV, reciptV, distrbV, adjustmentV;
    View recipt, distrb, adjustment, inventrt;

    TableLayout tabrec;

    LinearLayout child1;
    RelativeLayout child2;
    private LinearLayout mainlayout, mainlayoutdialog;

    Expandablerecieptlist listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader, listDataHeader1;
    HashMap<String, List<String>> listDataChild;
    static int groupclick = 7;
    CustomScrollViewInventory scroll;
    View distribution, sampling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventorymain);

        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Inventory");

        // -------------------------------------------------------

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        invent = (RelativeLayout) findViewById(R.id.playlisrel);
        inventV = (TextView) findViewById(R.id.tab1);
        inventV.setOnClickListener(olc);
        inventrt = findViewById(R.id.tab11);
        recipt = (View) findViewById(R.id.tab22);
        reciptV = (TextView) findViewById(R.id.tab2);
        reciptV.setOnClickListener(olc);

        distrb = (View) findViewById(R.id.tab33);
        distrbV = (TextView) findViewById(R.id.tab3);
        distrbV.setOnClickListener(olc);

        adjustment = (View) findViewById(R.id.tab44);
        adjustmentV = (TextView) findViewById(R.id.tab4);
        adjustmentV.setOnClickListener(olc);

        child1 = (LinearLayout) findViewById(R.id.first);
        child2 = (RelativeLayout) findViewById(R.id.second);

        textview = (TextView) findViewById(R.id.textview);

        scroll = (CustomScrollViewInventory) findViewById(R.id.scrollinvent);

        tabrec = (TableLayout) findViewById(R.id.lin4);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();

        listAdapter = new Expandablerecieptlist(this, listDataHeader,
                listDataHeader1, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setGroupIndicator(null);
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                for (int i = 0; i < parent.getChildCount(); i++)

                    if (groupclick == groupPosition) {
                        expListView.collapseGroup(i);
                        groupclick = 0;
                    } else if (i == groupPosition) {
                        expListView.expandGroup(i);
                    } else
                        expListView.collapseGroup(i);
                groupclick = groupPosition;
                return true;
            }
        });
        // expListView.setOnChildClickListener(new OnChildClickListener() {
        //
        // @Override
        // public boolean onChildClick(ExpandableListView parent, View v, int
        // groupPosition, int childPosition, long id) {
        //
        // for(int i=0; i < parent.getChildCount(); i++)
        // if(i==groupPosition)
        // expListView.expandGroup(i);
        // else
        // expListView.collapseGroup(i);
        //
        // // TODO Auto-generated method stub
        // return true;
        // }
        // });
        addRecipt();

        // ------------------------------------------------------

        tv = (TextView) findViewById(R.id.textview1);

        tr = (LinearLayout) findViewById(R.id.lin1);
        main = new LinearLayout(this);
        LinearLayout.LayoutParams tableRowLayoutParams3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        tableRowLayoutParams3.setMargins(0, 0, 0, 10);
        main.setLayoutParams(tableRowLayoutParams3);
        rl1 = Utility.getThumnailForInvent(this, R.drawable.newcfix1, "", 0, 0,
                0, "10", "BALANCE");
        rl1.setPadding(0, 0, 3, 0);
        rl1.setOnClickListener(this);
        rl1.setTag("" + 1);

        rl2 = Utility.getThumnailForInvent(this, R.drawable.newace, "", 0, 0,
                0, "50", "BALANCE");
        rl2.setPadding(0, 0, 3, 0);
        rl2.setOnClickListener(this);
        rl2.setTag("" + 2);

        rl3 = Utility.getThumnailForInvent(this, R.drawable.newjade, "", 0, 0,
                0, "20", "BALANCE");
        rl3.setPadding(0, 0, 3, 0);
        rl3.setOnClickListener(this);
        rl3.setTag("" + 3);

        rl4 = Utility.getThumnailForInvent(this, R.drawable.newmezzo, "", 0, 0,
                0, "40", "BALANCE");
        rl4.setPadding(0, 0, 3, 0);
        rl4.setOnClickListener(this);
        rl4.setTag("" + 4);

        rl5 = Utility.getThumnailForInvent(this, R.drawable.solsuna, "", 0, 0,
                0, "75", "BALANCE");
        rl5.setPadding(0, 0, 3, 0);
        rl5.setOnClickListener(this);
        rl5.setTag("" + 5);
        main.addView(rl1);
        main.addView(rl2);
        main.addView(rl3);
        main.addView(rl4);
        main.addView(rl5);
        tr.addView(main);

        tv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                View vop = tr.getChildAt(0);
                if (tv.getText().toString().equals("Complete Statement")) {
                    tv.setText("Back");
                    rl1.setVisibility(View.VISIBLE);
                    rl2.setVisibility(View.GONE);
                    rl3.setVisibility(View.GONE);
                    rl4.setVisibility(View.GONE);
                    rl5.setVisibility(View.GONE);
                    fullview();
                } else if (tv.getText().toString().equals("Back")) {
                    tv.setText("Complete Statement");
                    tr.removeAllViews();
                    rl1.setVisibility(View.VISIBLE);
                    rl2.setVisibility(View.VISIBLE);
                    rl3.setVisibility(View.VISIBLE);
                    rl4.setVisibility(View.VISIBLE);
                    rl5.setVisibility(View.VISIBLE);
                    tr.addView(vop);
                }

            }
        });
        distribution = (View) findViewById(R.id.lin13);
        View view = distribution.findViewById(R.id.keyboard);
        findViews(view);
        TextView cfix = (TextView) distribution.findViewById(R.id.textcfix);
        TextView dfix = (TextView) distribution.findViewById(R.id.textdfix);
        TextView mezzo = (TextView) distribution
                .findViewById(R.id.textmezzodrop);
        TextView efix = (TextView) distribution.findViewById(R.id.textefix);
        TextView dewpill = (TextView) distribution
                .findViewById(R.id.text10dewpill);
        cfix.setTag("1");
        dfix.setTag("1");
        efix.setTag("1");
        mezzo.setTag("2");
        dewpill.setTag("2");
        LinearLayout linear1 = (LinearLayout) distribution
                .findViewById(R.id.linearone);

        setOnClick(cfix, linear1);
        setOnClick(dfix, linear1);
        setOnClick(efix, linear1);
        setOnClick(mezzo, linear1);
        setOnClick(dewpill, linear1);

        addDataToSampling(linear1, "Mezzo Drop");
        addDataToSampling(linear1, "C-FIX");
        AutoCompleteTextView autoTv1 = (AutoCompleteTextView) distribution
                .findViewById(R.id.search_physi);
        Utility.hideKeyboard(autoTv1);
        autoTv1.setAdapter(new MyAdapterforspinner(InventoryTab.this,
                R.layout.exrow_second, Drname));
        autoTv1.setThreshold(1);

        sampling = (View) findViewById(R.id.lin12);

        View view1 = sampling.findViewById(R.id.keyboard);
        findViews1(view1);
        TextView cfix1 = (TextView) sampling.findViewById(R.id.textcfix);
        TextView dfix1 = (TextView) sampling.findViewById(R.id.textdfix);
        TextView mezzo1 = (TextView) sampling.findViewById(R.id.textmezzodrop);
        TextView efix1 = (TextView) sampling.findViewById(R.id.textefix);
        TextView dewpill1 = (TextView) sampling
                .findViewById(R.id.text10dewpill);
        cfix1.setTag("1");
        dfix1.setTag("1");
        efix1.setTag("1");
        mezzo1.setTag("2");
        dewpill1.setTag("2");

        LinearLayout linear2 = (LinearLayout) sampling
                .findViewById(R.id.linearone);

        setOnClick(cfix1, linear2);
        setOnClick(dfix1, linear2);
        setOnClick(efix1, linear2);
        setOnClick(mezzo1, linear2);
        setOnClick(dewpill1, linear2);

        addDataToSampling(linear2, "Mezzo Drop");
        addDataToSampling(linear2, "C-FIX");
        linselction = (LinearLayout) findViewById(R.id.linselction);
    }

    public void LayoutCreator(LinearLayout main, String[] header,
                              String[][] griddata, String headername, String needspace) {

        // main = (LinearLayout) findViewById(R.id.mainelinear);

        TableRow row = new TableRow(InventoryTab.this);
        TableRow row1 = new TableRow(InventoryTab.this);

        LayoutParams param = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(param);
        row1.setLayoutParams(param);
        row1.setBackgroundColor(Color.CYAN);

        if (headername != null) {

            LayoutParams paramsheader = new TableRow.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            TextView tv = new TextView(InventoryTab.this);
            tv.setText(headername);
            tv.setGravity(Gravity.CENTER_HORIZONTAL);

            tv.setTextSize(23);
            tv.setTextColor(Color.WHITE);
            // tv.setBackgroundColor(Color.CYAN);
            tv.setPadding(5, 5, 5, 5);

            // tv.setPadding(0, 20, 5, 5);

            tv.setLayoutParams(paramsheader);
            row1.addView(tv);
            main.addView(row1);
        }

        LayoutParams params = new TableRow.LayoutParams(0, 80, 1f);

        if (header != null) {
            for (int i = 0; i < header.length; i++) {

                TextView tv = new TextView(InventoryTab.this);

                tv.setText(header[i]);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);
                tv.setBackgroundResource(R.drawable.bg_broderforedittext2);
                tv.setTextSize(20);
                tv.setPadding(5, 5, 5, 5);
                tv.setTypeface(null, Typeface.BOLD);
                // tv.setPadding(0, 20, 5, 5);

                tv.setLayoutParams(params);
                row.addView(tv);
            }
            main.addView(row);
        }

        for (int i = 0; i < griddata.length; i++) {

            TableRow rowsecond = new TableRow(InventoryTab.this);

            LayoutParams paramsecond = new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            rowsecond.setLayoutParams(paramsecond);
            LayoutParams paramssecondd = new TableRow.LayoutParams(0,
                    LayoutParams.WRAP_CONTENT, 1f);
            for (int j = 0; j < griddata[0].length; j++) {

                if (j == 0 || j == 1 || j == 5) {
                    TextView tvsecond = new TextView(InventoryTab.this);

                    tvsecond.setText(griddata[i][j]);
                    tvsecond.setTextSize(20);
                    tvsecond.setGravity(Gravity.CENTER_HORIZONTAL);
                    tvsecond.setBackgroundResource(R.drawable.bg_broderforedittext2);
                    tvsecond.setPadding(5, 5, 5, 5);
                    tvsecond.setLayoutParams(paramssecondd);
                    rowsecond.addView(tvsecond);
                    if (i == griddata.length - 1 || i == 0) {
                        tvsecond.setTypeface(null, Typeface.BOLD);
                    }
                } else {
                    TableRow tv3second = new TableRow(InventoryTab.this);
                    String[] asertemp = griddata[i][j].split("\\^");

                    tv3second.setLayoutParams(paramssecondd);

                    TextView tvv11 = new TextView(InventoryTab.this);
                    // tvv11.setText("Lot No");

                    tvv11.setGravity(Gravity.CENTER_HORIZONTAL);
                    tvv11.setBackgroundResource(R.drawable.bg_broderforedittext2);
                    tvv11.setTextSize(20);
                    tvv11.setLayoutParams(paramssecondd);
                    tvv11.setPadding(5, 5, 5, 5);
                    TextView tvv22 = new TextView(InventoryTab.this);
                    // tvv22.setText("Qty");

                    tvv22.setGravity(Gravity.CENTER_HORIZONTAL);
                    tvv22.setBackgroundResource(R.drawable.bg_broderforedittext2);
                    tvv22.setTextSize(20);
                    tvv22.setPadding(5, 5, 5, 5);

                    tvv22.setLayoutParams(paramssecondd);
                    if (asertemp.length > 1) {
                        // if(asertemp[0].length()>5)
                        // tvv11.setGravity(Gravity.NO_GRAVITY);
                        tvv11.setText(asertemp[0]);
                        tvv22.setText(asertemp[1]);
                    }
                    if (i == griddata.length - 1 || i == 0) {
                        tvv11.setTypeface(null, Typeface.BOLD);
                        tvv22.setTypeface(null, Typeface.BOLD);
                    }

                    tv3second.addView(tvv11);
                    tv3second.addView(tvv22);
                    rowsecond.addView(tv3second);
                }

                // ----------------------------------------------------------------------------------

            }
            main.addView(rowsecond);

        }
        if (needspace != null) {
            View vtimpass = new View(this);
            // vtimpass.setBackgroundColor(Color.parseColor("#E6E6E6"));
            TableRow.LayoutParams llsmalle = new TableRow.LayoutParams(
                    LayoutParams.MATCH_PARENT, 25);
            vtimpass.setLayoutParams(llsmalle);
            main.addView(vtimpass);
        }
    }

    OnClickListener olc = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            inventV.setTextColor(Color.parseColor("#808080"));
            inventV.setTypeface(null, Typeface.NORMAL);
            reciptV.setTextColor(Color.parseColor("#808080"));
            reciptV.setTypeface(null, Typeface.NORMAL);
            distrbV.setTextColor(Color.parseColor("#808080"));
            distrbV.setTypeface(null, Typeface.NORMAL);
            adjustmentV.setTextColor(Color.parseColor("#808080"));
            adjustmentV.setTypeface(null, Typeface.NORMAL);
            switch (v.getId()) {

                case R.id.tab1:
                    textview.setText("INVENTORY");
                    inventV.setTextColor(Color.parseColor("#000000"));
                    inventV.setTypeface(null, Typeface.BOLD);
                    scroll.scrollTo(child1.getLeft(), child1.getTop());
                    inventrt.setVisibility(View.VISIBLE);
                    recipt.setVisibility(View.GONE);
                    distrb.setVisibility(View.GONE);
                    adjustment.setVisibility(View.GONE);

                    break;
                case R.id.tab2:
                    textview.setText("RECEIPT");
                    reciptV.setTextColor(Color.parseColor("#000000"));
                    reciptV.setTypeface(null, Typeface.BOLD);
                    scroll.scrollTo(child2.getLeft(), child2.getTop());
                    inventrt.setVisibility(View.GONE);
                    recipt.setVisibility(View.VISIBLE);
                    distrb.setVisibility(View.GONE);
                    adjustment.setVisibility(View.GONE);

                    break;

                case R.id.tab3:
                    textview.setText("DISTRIBUTION");
                    distrbV.setTextColor(Color.parseColor("#000000"));
                    distrbV.setTypeface(null, Typeface.BOLD);
                    scroll.scrollTo(distribution.getLeft(), distribution.getTop());
                    inventrt.setVisibility(View.GONE);
                    recipt.setVisibility(View.GONE);
                    distrb.setVisibility(View.VISIBLE);
                    adjustment.setVisibility(View.GONE);

                    break;

                case R.id.tab4:
                    textview.setText("ADJUSTMENT");
                    adjustmentV.setTextColor(Color.parseColor("#000000"));
                    adjustmentV.setTypeface(null, Typeface.BOLD);
                    scroll.scrollTo(sampling.getLeft(), sampling.getTop());
                    inventrt.setVisibility(View.GONE);
                    recipt.setVisibility(View.GONE);
                    distrb.setVisibility(View.GONE);
                    adjustment.setVisibility(View.VISIBLE);

                    break;

                default:
                    break;
            }

            // scroller.scrollTo(webView11.getLeft(), webView11.getTop());
        }
    };

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataHeader1 = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Lot No 1000");
        listDataHeader.add("Lot No 999");
        listDataHeader.add("Lot No 998");
        listDataHeader.add("Lot No 997");
        listDataHeader.add("Lot No 996");

        listDataHeader1.add("Last ACK Date: 1 June");
        listDataHeader1.add("Last ACK Date: 15 May");
        listDataHeader1.add("Last ACK Date: 1 May");
        listDataHeader1.add("Last ACK Date: 15 April");
        listDataHeader1.add("Last ACK Date: 1 April");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), nowShowing);
        listDataChild.put(listDataHeader.get(4), comingSoon);
    }

    private void addRecipt() {

        RelativeLayout.LayoutParams llpty = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        llp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        llp.setMargins(10, 0, 0, 0);

        RelativeLayout.LayoutParams llp2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        llp2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        llp2.setMargins(0, 0, 10, 0);

        TextView tv = new TextView(this);

        tv.setText("Last Ack Date: 21 Aug");
        tv.setTextSize(15f);
        tv.setPadding(10, 10, 10, 10);
        tv.setLayoutParams(llp2);

        TextView tv1 = new TextView(this);

        tv1.setText("Lot No. 1002");
        tv1.setPadding(10, 10, 10, 10);
        tv1.setTypeface(null, Typeface.BOLD);
        tv1.setTextColor(Color.WHITE);
        tv1.setTextSize(15f);
        tv1.setBackgroundResource(R.drawable.gry_bar);
        tv1.setLayoutParams(llp);

        RelativeLayout rt = new RelativeLayout(this);
        rt.addView(tv1);
        rt.addView(tv);

        tabrec.addView(rt);
        createGrid(tabrec, productdetails, 4, header);
        createGrid(tabrec, productdetails1, 4, header1);
        RelativeLayout rt1 = new RelativeLayout(this);

        TextView tv2 = new TextView(this);

        tv2.setTextSize(15f);
        tv2.setPadding(10, 10, 10, 10);
        tv2.setLayoutParams(llp2);

        TextView tv3 = new TextView(this);

        tv3.setPadding(10, 10, 10, 10);
        tv3.setTypeface(null, Typeface.BOLD);
        tv3.setTextColor(Color.WHITE);
        tv3.setTextSize(15f);
        tv3.setBackgroundResource(R.drawable.gry_bar);
        tv3.setLayoutParams(llp);
        tv3.setText("Lot No. 1001");
        tv2.setText("Last Ack Date: 20 July");
        rt1.addView(tv3);
        rt1.addView(tv2);

        View vtimpass = new View(this);
        vtimpass.setBackgroundColor(Color.parseColor("#E6E6E6"));
        TableRow.LayoutParams llsmalle = new TableRow.LayoutParams(
                LayoutParams.MATCH_PARENT, 25);
        vtimpass.setLayoutParams(llsmalle);
        tabrec.addView(vtimpass);
        View vtimpass1 = new View(this);

        TableRow.LayoutParams llsmalle1 = new TableRow.LayoutParams(
                LayoutParams.MATCH_PARENT, 2);
        llsmalle1.setMargins(60, 0, 0, 0);
        vtimpass1.setPadding(50, 10, 30, 10);
        vtimpass1.setBackgroundColor(Color.BLACK);
        vtimpass1.setLayoutParams(llsmalle1);
        tabrec.addView(vtimpass1);
        tabrec.addView(rt1);
        createGrid(tabrec, productdetails, 4, header);
        createGrid(tabrec, productdetails1, 4, header1);

    }

    String[] header = {"Date", "Time", "Activity", "Deatils"};

    String[][] productdetails = {
            {"Brand SKU's", "Allocated", "ACK QTY", "Recieved Qty"},

            {"C-FIX", "", "", ""}, {"C-FIX 40mg", "10", "10", "0"},

            {"C-FIX 50mg", "10", "10", "0"},

            {"C-FIX 40mg", "10", "10", "0"},};
    String[] header1 = {"Date", "Time", "Activity", "Deatils"};

    String[][] productdetails1 = {
            {"111", "Allocated", "ACK QTY", "Recieved Qty"},

            {"Fade Pill", "", "", ""}, {"Fade Pill 80mg", "10", "10", "0"},

            {"Fade Pill 80mg", "10", "10", "0"},

            {"Fade Pill 80mg", "10", "10", "0"},};

    void createGrid(TableLayout d, String[][] productdetails, int numberofed,
                    String[] header) {
        tbl = (TableLayout) findViewById(R.id.lin4);
        edittext = new EditText[numberofed];

        llp = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
        // llp.setMargins(1, 1, 0, 0);
        // tbl.removeAllViews();
        TableRow.LayoutParams llp = new TableRow.LayoutParams(0,
                LayoutParams.WRAP_CONTENT, 1f);
        llp.setMargins(0, 10, 0, 10);
        TableRow.LayoutParams llpr = new TableRow.LayoutParams(0,
                LayoutParams.WRAP_CONTENT, 1f);
        llpr.setMargins(0, 10, 0, 10);
        TableRow.LayoutParams llprr = new TableRow.LayoutParams(0,
                LayoutParams.WRAP_CONTENT, 1f);
        llprr.setMargins(0, 10, 0, 10);
        TableRow.LayoutParams editlay = new TableRow.LayoutParams(0,
                LayoutParams.WRAP_CONTENT, 1f);
        editlay.setMargins(0, 10, 0, 10);
        TableRow.LayoutParams llsmall = new TableRow.LayoutParams(
                LayoutParams.MATCH_PARENT, 1);
        // llsmall.setMargins(10, 15, 10, 15);
        // llprr.setMargins(1, 1, 1, 1);

        if (productdetails != null) {
            for (int j = 0; j < productdetails.length; j++) {
                tr = new TableRow(InventoryTab.this);

                for (int i = 0; i < numberofed; i++) {

                    edittext[i] = new EditText(InventoryTab.this);

                    if (j == 0 || j == 1) {

                        if (productdetails[j][i].equals("111")) {

                            View vsmall = new View(this);
                            vsmall.setBackgroundColor(Color.BLACK);
                            TableRow.LayoutParams llsmalle = new TableRow.LayoutParams(
                                    LayoutParams.MATCH_PARENT, 2);
                            vsmall.setPadding(30, 0, 30, 0);
                            vsmall.setLayoutParams(llsmalle);
                            d.addView(vsmall);

                            break;
                        } else {

                            edittext[i].setBackgroundColor(Color
                                    .parseColor("#E6E6E6"));
                            edittext[i].setTextColor(Color.BLACK);
                            edittext[i].setTypeface(null, Typeface.BOLD);
                            edittext[i].setEnabled(false);
                            edittext[i].setFocusable(false);
                            edittext[i].setKeyListener(null);

                            edittext[i].setText(productdetails[j][i]);

                            if (j == 1) {

                                edittext[i].setPadding(20, 5, 10, 5);
                            } else {
                                edittext[i].setPadding(20, 5, 10, 15);
                            }

                            if (i == 0)
                                edittext[i].setLayoutParams(llprr);
                            else
                                edittext[i].setLayoutParams(llp);
                        }
                    } else {

                        if (i == numberofed - 1) {
                            edittext[i]
                                    .setBackgroundResource(R.drawable.bg_broderforedittext);
                            edittext[i].setTextSize(15);
                            edittext[i].setSingleLine();
                            edittext[i].setEnabled(true);
                            edittext[i].setFocusable(true);
                            edittext[i].setPadding(20, 5, 10, 5);
                            edittext[i].setEms(3);
                            edittext[i].setGravity(Gravity.LEFT);
                            InputFilter[] filterArray = new InputFilter[1];
                            filterArray[0] = new InputFilter.LengthFilter(3);
                            edittext[i].setFilters(filterArray);

                            edittext[i].setText(productdetails[j][i]);

                            edittext[i].setTextColor(Color.BLACK);

                            edittext[i].setLayoutParams(editlay);

                        } else {
                            edittext[i].setBackgroundColor(Color.TRANSPARENT);
                            edittext[i].setTextSize(15);
                            edittext[i].setSingleLine();
                            edittext[i].setEnabled(false);
                            edittext[i].setFocusable(false);
                            edittext[i].setKeyListener(null);
                            edittext[i].setPadding(20, 5, 10, 15);
                            edittext[i].setText(productdetails[j][i]);

                            edittext[i].setTextColor(Color.BLACK);
                            if (i == 0)
                                edittext[i].setLayoutParams(llprr);
                            else
                                edittext[i].setLayoutParams(llp);
                        }
                    }

                    if (i == 3) {
                        if (j != 0)
                            edittext[i].setLayoutParams(editlay);
                        else
                            edittext[i].setLayoutParams(llpr);

                    }

                    tr.addView(edittext[i]);

                }
                d.addView(tr);

                if (j != productdetails.length - 1 && j != 0 && j != 1) {
                    View vsmall = new View(this);
                    vsmall.setBackgroundColor(Color.BLACK);

                    vsmall.setPadding(20, 10, 20, 10);
                    vsmall.setLayoutParams(llsmall);
                    d.addView(vsmall);
                }

            }
        }

    }

    class Expandablerecieptlist extends BaseExpandableListAdapter {

        private Context _context;
        private List<String> _listDataHeader;
        private List<String> _listDataHeader1;// header titles
        // child data in format of header title, child title
        private HashMap<String, List<String>> _listDataChild;
        ViewHolderItem viewHolder;

        ViewHolderItemChild ViewHoldsechild;

        public Expandablerecieptlist(Context context,
                                     List<String> listDataHeader, List<String> listDataHeader1,
                                     HashMap<String, List<String>> listChildData) {
            this._context = context;
            this._listDataHeader = listDataHeader;
            this._listDataHeader1 = listDataHeader1;
            this._listDataChild = listChildData;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return this._listDataChild.get(
                    this._listDataHeader.get(groupPosition))
                    .get(childPosititon);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition,
                                 boolean isLastChild, View convertView1, ViewGroup parent) {

            // final String childText = (String) getChild(groupPosition,
            // childPosition);
            ViewHoldsechild = new ViewHolderItemChild();
            if (convertView1 == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView1 = infalInflater.inflate(R.layout.list_item, null);
                ViewHoldsechild.table = (TableLayout) convertView1
                        .findViewById(R.id.expandchild);
                createGrid(ViewHoldsechild.table, productdetails, 4, header);
                createGrid(ViewHoldsechild.table, productdetails1, 4, header1);
                convertView1.setTag(ViewHoldsechild);
            } else {
                ViewHoldsechild = (ViewHolderItemChild) convertView1.getTag();
            }

            // TextView txtListChild = (TextView) convertView
            // .findViewById(R.id.lblListItem);
            //
            // txtListChild.setText(childText);
            return convertView1;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this._listDataHeader.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this._listDataHeader.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            String headerTitle = (String) getGroup(groupPosition);
            viewHolder = new ViewHolderItem();
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_group, null);
                viewHolder.headerplus = (TextView) convertView
                        .findViewById(R.id.lblListHeader);
                viewHolder.headerplus.setTypeface(font);
                viewHolder.header1 = (TextView) convertView
                        .findViewById(R.id.lblListHeader);
                viewHolder.header1.setTypeface(null, Typeface.BOLD);
                viewHolder.header2 = (TextView) convertView
                        .findViewById(R.id.lblListHeader1);
                viewHolder.header2.setTypeface(null, Typeface.BOLD);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolderItem) convertView.getTag();
            }

            viewHolder.header1.setText(headerTitle);

            viewHolder.header2.setText(_listDataHeader1.get(groupPosition));

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    public class ViewHolderItem {

        TextView header1;
        TextView header2;
        TextView headerplus;

    }

    public class ViewHolderItemChild {

        TableLayout table;

    }

    void addDataToSampling(final LinearLayout linearone, String s) {

        final LinearLayout linear = new LinearLayout(InventoryTab.this);
        linear.setBackgroundResource(R.drawable.roundforlayout);
        linear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                for (int i = 0; i < linearone.getChildCount(); i++) {
                    View view = linearone.getChildAt(i);
                    if (view == v) {
                        linearone.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforsampling);
                        linear.getChildAt(1).requestFocus();
                    } else {
                        linearone.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforlayout);
                    }
                }
            }
        });

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(480,
                LayoutParams.WRAP_CONTENT);
        param.setMargins(0, 5, 0, 5);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setLayoutParams(param);

        TextView tv = new TextView(InventoryTab.this);
        tv.setText(s);
        tv.setBackgroundResource(R.drawable.round_white);
        tv.setTextSize(18);
        LinearLayout.LayoutParams textparam = new LinearLayout.LayoutParams(
                210, LinearLayout.LayoutParams.WRAP_CONTENT);
        textparam.setMargins(0, 0, 4, 0);
        tv.setLayoutParams(textparam);

        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        // ---------------------------------------------------------------------------------------
        LinearLayout.LayoutParams paramedit = new LinearLayout.LayoutParams(
                110, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramedit.setMargins(0, 0, 4, 0);
        EditText ed1 = new EditText(InventoryTab.this);
        ed1.setBackgroundResource(R.drawable.round_white);
        ed1.setEms(3);
        ed1.setTextSize(18);
        ed1.setLayoutParams(paramedit);
        ed1.setText("1");
        InputFilter[] filter = new InputFilter[1];
        filter[0] = new InputFilter.LengthFilter(2);
        ed1.setFilters(filter);
        ed1.setGravity(Gravity.CENTER_HORIZONTAL);

        LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                25, 25);
        // parambutton.setMargins(2, 0, 0, 2);
        TextView bv = new TextView(InventoryTab.this);
        bv.setGravity(Gravity.CENTER_VERTICAL);
        bv.setBackgroundResource(R.drawable.closenew);
        bv.setLayoutParams(parambutton);
        bv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                linearone.removeView(linear);
            }
        });
        ed1.setInputType(InputType.TYPE_NULL);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            ed1.setRawInputType(InputType.TYPE_CLASS_NUMBER);
            ed1.setTextIsSelectable(true);
        }

        EditText ed2 = new EditText(InventoryTab.this);
        ed2.setBackgroundResource(R.drawable.round_white);
        ed2.setEms(3);
        ed2.setTextSize(18);
        ed2.setLayoutParams(paramedit);
        ed2.setText("1");
        ed2.setFilters(filter);
        ed2.setGravity(Gravity.CENTER_HORIZONTAL);

        ed2.setInputType(InputType.TYPE_NULL);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            ed2.setRawInputType(InputType.TYPE_CLASS_NUMBER);
            ed2.setTextIsSelectable(true);
        }
        setOnFocus(ed1, linearone);
        setOnFocus(ed2, linearone);
        linear.addView(tv);
        linear.addView(ed1);
        linear.addView(ed2);
        linear.addView(bv);

        if (linearone.getChildCount() > 0) {
            boolean flag = false;
            for (int i = 0; i < linearone.getChildCount(); i++) {
                LinearLayout ll = (LinearLayout) linearone.getChildAt(i);
                TextView text = (TextView) ll.getChildAt(0);
                if (text.getText().toString().equals(s)) {
                    EditText edit = (EditText) ll.getChildAt(1);
                    int count = Integer.parseInt(edit.getText().toString());
                    count = count + 1;
                    edit.setText("" + count);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                linearone.addView(linear);
            }
        } else {
            linearone.addView(linear);
        }

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getTag().equals("1")) {
            rl1.setVisibility(View.VISIBLE);
            rl2.setVisibility(View.GONE);
            rl3.setVisibility(View.GONE);
            rl4.setVisibility(View.GONE);
            rl5.setVisibility(View.GONE);

        } else if (v.getTag().equals("2")) {
            rl2.setVisibility(View.VISIBLE);
            rl3.setVisibility(View.GONE);
            rl4.setVisibility(View.GONE);
            rl5.setVisibility(View.GONE);
            rl1.setVisibility(View.GONE);
        } else if (v.getTag().equals("3")) {
            rl1.setVisibility(View.GONE);
            rl2.setVisibility(View.GONE);
            rl3.setVisibility(View.VISIBLE);
            rl4.setVisibility(View.GONE);
            rl5.setVisibility(View.GONE);

        } else if (v.getTag().equals("4")) {
            rl1.setVisibility(View.GONE);
            rl2.setVisibility(View.GONE);
            rl3.setVisibility(View.GONE);
            rl4.setVisibility(View.VISIBLE);
            rl5.setVisibility(View.GONE);

        } else {
            rl1.setVisibility(View.GONE);
            rl2.setVisibility(View.GONE);
            rl3.setVisibility(View.GONE);
            rl4.setVisibility(View.GONE);
            rl5.setVisibility(View.VISIBLE);

        }

        tv.setText("Back");

        addInventory();
        // LayoutInflater mInflater = (LayoutInflater) this
        // .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //
        // LinearLayout.LayoutParams tableRowLayoutParams3 = new
        // LinearLayout.LayoutParams(
        // LinearLayout.LayoutParams.MATCH_PARENT,
        // LinearLayout.LayoutParams.WRAP_CONTENT);
        // tableRowLayoutParams3.setMargins(0, 0, 0, 10);
        //
        // LinearLayout view = (LinearLayout) mInflater.inflate(
        // R.layout.grid_inventory, null);
        // view.setLayoutParams(tableRowLayoutParams3);
        // LinearLayout view1 = (LinearLayout) mInflater.inflate(
        // R.layout.grid_inventory, null);
        // view1.setLayoutParams(tableRowLayoutParams3);
        // LinearLayout view2 = (LinearLayout) mInflater.inflate(
        // R.layout.grid_inventory, null);
        // view2.setLayoutParams(tableRowLayoutParams3);
        //
        // tr.addView(view);
        // tr.addView(view1);
        // tr.addView(view2);

    }

    private void addInventory() {
        // TODO Auto-generated method stub

        String header[] = {"Date", "Openning \n Balance", "Receipt",
                "Distribution", "Adjustment", "Closing \n Balance"};

        String[][] griddata = {
                {"", "", "Lot No^Qty", "Dr Cnt^Qty", "(-)Adj^(+)Adj", ""},
                {"1-Aug-2015", "100", "^", "^", "^", ""},
                {"2-Aug-2015", "", "1^10", "5^20", "^", "90"},
                {"5-Aug-2015", "", "^", "10^50", "^", "40"},
                {"12-Aug-2015", "", "2^15", "^", "^", "55"},
                {"15-Aug-2015", "", "^", "^", "^5", "50"},
                {"", "100", "^25", "^70", "5^", "50"}};
        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

    }

    void fullview() {

        tv.setText("Back");

        String header[] = {"Date", "Openning \n Balance", "Receipt",
                "Distribution", "Adjustment", "Closing \n Balance"};

        String[][] griddata = {
                {"", "", "Lot No^Qty", "Dr Cnt^Qty", "(-)Adj^(+)Adj", ""},
                {"1-Aug-2015", "100", "^", "^", "^", ""},
                {"2-Aug-2015", "", "1^10", "5^20", "^", "90"},
                {"5-Aug-2015", "", "^", "10^50", "^", "40"},
                {"12-Aug-2015", "", "2^15", "^", "^", "55"},
                {"15-Aug-2015", "", "^", "^", "^5", "50"},
                {"", "100", "^25", "^70", "5^", "50"}};

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

        LinearLayout.LayoutParams tableRowLayoutParams3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tableRowLayoutParams3.setMargins(0, 0, 0, 10);

        RelativeLayout rl96 = Utility.getThumnailForInvent(this,
                R.drawable.c_fix, "", 0, 0, 0, "20", "BALANCE");
        rl96.setLayoutParams(tableRowLayoutParams3);
        tr.addView(rl96);

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

        LayoutCreator(tr, header, griddata, "C-FIX 40mg", "yes");

    }

    // void fullview() {
    //
    // tv.setText("Back");
    // LayoutInflater mInflater = (LayoutInflater) this
    // .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //
    // LinearLayout.LayoutParams tableRowLayoutParams3 = new
    // LinearLayout.LayoutParams(
    // LinearLayout.LayoutParams.MATCH_PARENT,
    // LinearLayout.LayoutParams.WRAP_CONTENT);
    // tableRowLayoutParams3.setMargins(0, 0, 0, 10);
    //
    // LinearLayout view = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view1 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view1.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view2 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view2.setLayoutParams(tableRowLayoutParams3);
    //
    // tr.addView(view);
    // tr.addView(view1);
    // tr.addView(view2);
    //
    // RelativeLayout rl96 = Utility.getThumnailForInvent(this,
    // R.drawable.c_fix, "", 0, 0, 0, "20", "BALANCE");
    // rl96.setLayoutParams(tableRowLayoutParams3);
    // tr.addView(rl96);
    //
    // LinearLayout view11 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view11.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view12 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view12.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view21 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view21.setLayoutParams(tableRowLayoutParams3);
    // tr.addView(view11);
    // tr.addView(view12);
    // tr.addView(view21);
    //
    // RelativeLayout rl961 = Utility.getThumnailForInvent(this,
    // R.drawable.newace, "", 0, 0, 0, "20", "BALANCE");
    //
    // tr.addView(rl961);
    //
    // LinearLayout view111 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view111.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view121 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view121.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view211 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view211.setLayoutParams(tableRowLayoutParams3);
    // tr.addView(view111);
    // tr.addView(view121);
    // tr.addView(view211);
    //
    // RelativeLayout rl962 = Utility.getThumnailForInvent(this,
    // R.drawable.newjade, "", 0, 0, 0, "20", "BALANCE");
    //
    // tr.addView(rl962);
    //
    // LinearLayout view112 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view112.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view122 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view122.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view212 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view212.setLayoutParams(tableRowLayoutParams3);
    // tr.addView(view112);
    // tr.addView(view122);
    // tr.addView(view212);
    //
    // RelativeLayout rl963 = Utility.getThumnailForInvent(this,
    // R.drawable.newmezzo, "", 0, 0, 0, "20", "BALANCE");
    //
    // tr.addView(rl963);
    //
    // LinearLayout view113 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view113.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view123 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view123.setLayoutParams(tableRowLayoutParams3);
    // LinearLayout view213 = (LinearLayout) mInflater.inflate(
    // R.layout.grid_inventory, null);
    // view213.setLayoutParams(tableRowLayoutParams3);
    // tr.addView(view113);
    // tr.addView(view123);
    // tr.addView(view213);
    //
    // }

    public void launchBarDialog() {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(
                InventoryTab.this, "Please wait ...", "Loading inventory ...",
                true);

        ringProgressDialog.setCancelable(true);
        // ringProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(15000);
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

    private void findViews(View v) {
        btnSeven = (Button) v.findViewById(R.id.btnSeven);
        btnEight = (Button) v.findViewById(R.id.btnEight);
        btnNine = (Button) v.findViewById(R.id.btnNine);
        btnFour = (Button) v.findViewById(R.id.btnFour);
        btnFive = (Button) v.findViewById(R.id.btnFive);
        btnSix = (Button) v.findViewById(R.id.btnSix);
        btnOne = (Button) v.findViewById(R.id.btnOne);
        btnTwo = (Button) v.findViewById(R.id.btnTwo);
        btnThree = (Button) v.findViewById(R.id.btnThree);

        zero = (Button) v.findViewById(R.id.zero);
        ente = (Button) v.findViewById(R.id.ente);

        btnSeven.setOnClickListener(keyListener);
        btnEight.setOnClickListener(keyListener);
        btnNine.setOnClickListener(keyListener);
        btnFour.setOnClickListener(keyListener);
        btnFive.setOnClickListener(keyListener);
        btnSix.setOnClickListener(keyListener);
        btnOne.setOnClickListener(keyListener);
        btnTwo.setOnClickListener(keyListener);
        btnThree.setOnClickListener(keyListener);

        zero.setOnClickListener(keyListener);
        ente.setOnClickListener(keyListener);
    }

    private void findViews1(View v) {
        btnSeven1 = (Button) v.findViewById(R.id.btnSeven);
        btnEight1 = (Button) v.findViewById(R.id.btnEight);
        btnNine1 = (Button) v.findViewById(R.id.btnNine);
        btnFour1 = (Button) v.findViewById(R.id.btnFour);
        btnFive1 = (Button) v.findViewById(R.id.btnFive);
        btnSix1 = (Button) v.findViewById(R.id.btnSix);
        btnOne1 = (Button) v.findViewById(R.id.btnOne);
        btnTwo1 = (Button) v.findViewById(R.id.btnTwo);
        btnThree1 = (Button) v.findViewById(R.id.btnThree);

        zero1 = (Button) v.findViewById(R.id.zero);
        ente1 = (Button) v.findViewById(R.id.ente);

        btnSeven1.setOnClickListener(keyListener1);
        btnEight1.setOnClickListener(keyListener1);
        btnNine1.setOnClickListener(keyListener1);
        btnFour1.setOnClickListener(keyListener1);
        btnFive1.setOnClickListener(keyListener1);
        btnSix1.setOnClickListener(keyListener1);
        btnOne1.setOnClickListener(keyListener1);
        btnTwo1.setOnClickListener(keyListener1);
        btnThree1.setOnClickListener(keyListener1);

        zero1.setOnClickListener(keyListener1);
        ente1.setOnClickListener(keyListener1);
    }

    OnClickListener keyListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v == btnSeven || v == btnEight || v == btnNine || v == btnFour
                    || v == btnSix || v == zero || v == btnFive || v == btnOne
                    || v == btnTwo || v == btnThree) {
                if (focusedView != null) {
                    Button edit = (Button) v;
                    String str = edit.getText().toString();
                    if (!focusedView.getText().toString().equals(""))
                        str = focusedView.getText().toString() + str;
                    focusedView.setText(str);
                }
            } else if (v == ente) {
                if (focusedView != null) {
                    if (!focusedView.getText().toString().equals("")) {
                        focusedView.setText(focusedView
                                .getText()
                                .toString()
                                .substring(
                                        0,
                                        focusedView.getText().toString()
                                                .length() - 1));
                    }
                }
            }
        }
    };
    OnClickListener keyListener1 = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v == btnSeven1 || v == btnEight1 || v == btnNine1
                    || v == btnFour1 || v == btnSix1 || v == zero1
                    || v == btnFive1 || v == btnOne1 || v == btnTwo1
                    || v == btnThree1) {
                if (focusedView != null) {
                    Button edit = (Button) v;
                    String str = edit.getText().toString();
                    if (!focusedView.getText().toString().equals(""))
                        str = focusedView.getText().toString() + str;
                    focusedView.setText(str);
                }
            } else if (v == ente1) {
                if (focusedView != null) {
                    if (!focusedView.getText().toString().equals("")) {
                        focusedView.setText(focusedView
                                .getText()
                                .toString()
                                .substring(
                                        0,
                                        focusedView.getText().toString()
                                                .length() - 1));
                    }
                }
            }
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
            LayoutInflater inflater = (LayoutInflater) InventoryTab.this
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

    private void setOnClick(final TextView tv, final LinearLayout linearone) {

        tv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View viewme) {
                // TODO Auto-generated method stub
                if (viewme.getTag().equals("1"))
                    openDialog1(viewme, linearone);
                else {
                    TextView tvdata = (TextView) viewme;
                    String s = tvdata.getText().toString();
                    addDataToSampling(linearone, s);
                }
            }
        });
    }

    private void setOnFocus(final EditText editText,
                            final LinearLayout linearone) {
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (hasFocus) {
                    focusedView = (EditText) v;
                } else {
                    focusedView = null;
                }
                View parentView = (View) v.getParent();
                for (int i = 0; i < linearone.getChildCount(); i++) {
                    View view = linearone.getChildAt(i);
                    if (view == parentView) {
                        linearone.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforsampling);
                    } else {
                        linearone.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforlayout);
                    }
                }
            }
        });
    }

    void openDialog1(final View viewme, final LinearLayout linearone) {
        final TextView textView = (TextView) viewme;
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(InventoryTab.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.main);
        Button b1 = (Button) dialog.findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final ArrayList<Integer> posSel = new ArrayList<Integer>();
                name = new ArrayList<String>();
                posSel.clear();
                for (int i = 0; i < thumbnailsselection.length; i++) {
                    if (thumbnailsselection[i] == true) {
                        posSel.add(i);
                        name.add(items.get(i));
                    }
                }
                dialog.dismiss();
                String s = textView.getText().toString();
                for (int j = 0; j < name.size(); j++) {
                    addDataToSampling(linearone, s + " " + name.get(j));
                }
            }
        });

        dialog.getWindow().setLayout(300, 200);
        int[] viewLocation = new int[2];
        viewme.getLocationOnScreen(viewLocation);
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp.x = viewLocation[0];
        wmlp.y = viewLocation[1];
        dialog.getWindow().setBackgroundDrawableResource(
                R.drawable.circularcornerlist);
        fillarray();
        count = items.size();
        thumbnailsselection = new boolean[count];
        listview = (ListView) dialog.findViewById(R.id.mainListView);
        listview.setAdapter(new ImageAdapter(InventoryTab.this));

        dialog.show();

    }

    private void fillarray() {
        // TODO Auto-generated method stub
        items.clear();
        items.add("50 DT");
        items.add("100 DT");
        items.add("200 DT");
        items.add("250 DT");
        items.add("Dry syrup");
    }

    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.row_photo, null);
                holder.textview = (TextView) convertView
                        .findViewById(R.id.thumbImage);
                holder.textview.setTextColor(Color.WHITE);
                holder.checkbox = (CheckBox) convertView
                        .findViewById(R.id.itemCheckBox);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.checkbox.setId(position);
            holder.textview.setId(position);
            holder.checkbox.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    CheckBox cb = (CheckBox) v;
                    int id = cb.getId();
                    if (thumbnailsselection[id]) {
                        cb.setChecked(false);
                        thumbnailsselection[id] = false;
                    } else {
                        cb.setChecked(true);
                        thumbnailsselection[id] = true;

                        System.out.println("cmncm" + items.get(id));

                    }
                }
            });
            holder.textview.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int id = v.getId();
                }
            });
            holder.textview.setText(items.get(position));
            holder.checkbox.setChecked(thumbnailsselection[position]);
            holder.id = position;
            return convertView;
        }
    }

    public void changeHeader(int index) {

        RelativeLayout rl = (RelativeLayout) linselction.getChildAt(index);
        String header = ((TextView) rl.getChildAt(0)).getText().toString();
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

    class ViewHolder {
        TextView textview;
        CheckBox checkbox;
        int id;
    }
}
