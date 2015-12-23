package com.cirrius.iclmcipla;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.cirrius.graph.Graphs;
import com.cirrius.iclmcipla.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

public class Dashboard extends Activity {

    private RelativeLayout playlisrel;
    private TextView playlistnew;
    private View viewsamplednew;
    private TextView specialty;
    private View viewsampled;
    private TextView brands;
    private View viewsamplech;
    private TextView therapy;
    private View viewsamplest;

    private LinearLayout graph1;
    private LinearLayout graph2;
    private LinearLayout graph3;
    private LinearLayout graph4;
    private LinearLayout graph5;
    private LinearLayout graph6;
    private LinearLayout graph7;
    private LinearLayout graph8;
    private RelativeLayout webView11;
    private RelativeLayout webView12;
    private RelativeLayout webView13;
    private RelativeLayout webView14;

    private RelativeLayout webView21;
    private RelativeLayout webView22;
    private RelativeLayout webView23;
    public static int pagecount = 0;
    public static RelativeLayout relative;
    public static int showHide = 0;

    RelativeLayout webView31, webView32, webView33, webView41, webView42,
            webView43, webView51, webView52, webView53, webView61, webView62,
            webView63, webView71, webView72, webView73, webView81, webView82,
            webView83, webView54, webView64, webView74, webView84, webView19,
            webView24;
    private CustomScrollViewDash scroller;
    private Typeface font;
    private TextView grap1TextView, grap2TextView, grap6TextView,
            grap4TextView, grap5TextView;
    String[] ast = {"Standard", "Country Avg", "Me"};
    String[] ast1 = {"Country Avg", "Me"};
    String[] ast2 = {"Reported", "Call by Call"};
    String[] ast3 = {"Target", "Country Avg", "Me"};
    String[] ast4 = {"Total ", "Met ", "Converted"};
    String[] ast5 = {"%Drs Detailed", "%Drs not Detailed"};
    String[] ast6 = {"Own", "Competitor"};
    String[] ast7 = {"Aceno", "Mezzo", "Solsuna"};

    String[] ast8 = {"Likes", "Dis Likes", "Annotations"};
    String[] ast9 = {"Content", "Abstract", "Video"};
    String[] ast10 = {"Dr Cvg", "VF Cvg", "Missed"};
    String[] ast11 = {"Abstracts", "Video", "Feeds"};
    String[] ast12 = {"Active Users", "Non Active Users"};
    String[] ast13 = {"Aceno", "Mezzo", "Solsuna"};
    String[] ast14 = {"Likes", "Dislikes", "Email"};

    public static LinearLayout linselction;

    TextView title1, title2, title3, title4, title5, title7, title19;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15,
            t16, t17, t18, t19;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2015-09-04 16:31:06 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    ArrayList<HashMap<String, String[]>> piefilter = new ArrayList<HashMap<String, String[]>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Utility.setactoinbart(getActionBar(), this, font, "Dashboard");
        findViews();
        init();
        pagecount = 1;

    }

    private void init() {
        // addgraph();
        float[] data = {90f, 10f, 20f};
        String[] barlabels = {"Standard", "Country(AVG)", "User"};
        Graphs graphs = new Graphs(Dashboard.this);
        // graphs.piechart();

        // webView11.addView(graphs.lineChart(ast, 0,100,0), new
        // LayoutParams(500, 350));
        webView11.addView(graphs.drawNbarchart(3, ast, 0, 3), new LayoutParams(
                260, 200));

        grap1TextView = (TextView) findViewById(R.id.gtextview1);

        // grap1TextView.setTag("" + 1);
        // grap1TextView.setOnClickListener(graphlisten);

        grap2TextView = (TextView) findViewById(R.id.gtextview2);
        // grap2TextView.setTag("" + 2);
        // grap2TextView.setOnClickListener(graphlisten);
        // TextView grap3TextView = (TextView) findViewById(R.id.gtextview3);
        // grap3TextView.setOnClickListener(graphlisten);
        grap4TextView = (TextView) findViewById(R.id.gtextview4);
        // grap4TextView.setTag("" + 3);
        // grap4TextView.setOnClickListener(graphlisten);
        grap5TextView = (TextView) findViewById(R.id.gtextview5);
        // grap5TextView.setTag("" + 4);
        // grap5TextView.setOnClickListener(graphlisten);
        grap6TextView = (TextView) findViewById(R.id.gtextview7);
        // grap6TextView.setTag("" + 5);
        // grap6TextView.setOnClickListener(graphlisten);

        title1 = (TextView) findViewById(R.id.title1);
        title2 = (TextView) findViewById(R.id.title2);

        title3 = (TextView) findViewById(R.id.title3);

        title4 = (TextView) findViewById(R.id.title4);
        title5 = (TextView) findViewById(R.id.title5);

        float[] data1 = {90f, 70, 80};
        String[] barlabels1 = {"Standard", "Country(AVG)", "User"};
        // webView12.addView(graphs.drawNbarchart(3,ast,1,3), new
        // LayoutParams(550, 325));
        // webView12.addView(graphs.piechartM(7), new LayoutParams(100, 100));
        webView12.addView(graphs.piechartM(3), new LayoutParams(260, 210));
        float[] data2 = {0f, 10f, 5};
        String[] barlabels3 = {"Standard", "Country(AVG)", "User"};
        // webView13.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // ""),
        // new LayoutParams(350, 220));
        // webView13.addView(graphs.lineChart(ast2, 3, 30, 0), new
        // LayoutParams(260, 200));
        webView13.addView(graphs.piechartM(6), new LayoutParams(260, 210));
        // webView14.addView(graphs.lineChart(ast2, 3, 30, 0), new
        // LayoutParams(260, 200));
        webView14.addView(graphs.lineChart(ast2, 19, 100, 50),
                new LayoutParams(260, 200));
        // second Row

        float[] data22 = {100, 80, 60};
        String[] barlabels23 = {"Standard", "Country(AVG)", "User"};
        // webView21.addView(graphs.drawNbarchart(2, ast1, 2, 3), new
        // LayoutParams(250, 190));
        webView21.addView(graphs.lineChart(ast13, 22, 10, 0), new LayoutParams(
                260, 200));

        // webView21.addView(graphs.piechartM(5), new LayoutParams(260, 200));
        // webView21.addView(graphs.lineChart(ast1, 2, 35, 0), new
        // LayoutParams(550, 340));

        float[] data11 = {0f, 10f, 5};
        String[] barlabels11 = {"Standard", "Country(AVG)", "User"};
        // webView22.addView(graphs.getsinglebarchartP(1),
        // new LayoutParams(550, 340));

        // /webView22.addView(graphs.piechartM(3), new LayoutParams(250, 200));
        // webView22.addView(graphs.drawNbarchart(2, ast5, 8, 3), new
        // LayoutParams(260, 220));
        // webView22.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "", 1), new LayoutParams(260, 200));
        webView22.addView(graphs.drawNbarchart(2, ast5, 17, 3),
                new LayoutParams(260, 200));

        float[] data25 = {0f, 10f, 5};
        String[] barlabels35 = {"Standard", "Country(AVG)", "User"};
        // webView23.addView(graphs.getsinglebarchart(),
        // new LayoutParams(350, 250));
        // webView23.addView(graphs.drawNbarchart(3),
        // new LayoutParams(400, 250));
        // webView23.addView(graphs.lineChart(ast, 1, 10, 5), new
        // LayoutParams(260, 220));
        webView23.addView(graphs.drawNbarchart(3, ast7, 9, 3),
                new LayoutParams(260, 200));
        webView24
                .addView(graphs.StackedBarChart(2), new LayoutParams(260, 220));
        // 3rd Row

        float[] data88 = {250, 200, 150};
        String[] barlabels88 = {"Target", "Country(AVG)", "User"};
        // webView31.addView(graphs.drawNbarchart(2,ast2,3,3),
        // new LayoutParams(550, 340));

        // webView31.addView(graphs.lineChart(ast2, 3, 30, 0), new
        // LayoutParams(350, 220));
        // webView31.addView(graphs.lineChart(ast2, 3, 30, 0), new
        // LayoutParams(350, 220));

        // webView31.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "",3),
        // new LayoutParams(260, 220));
        // webView31.addView(graphs.getsinglebarchart(1), new LayoutParams(260,
        // 220));
        webView31.addView(graphs.piechartM(5), new LayoutParams(260, 210));

        float[] data99 = {500, 400, 300};
        String[] barlabels99 = {"Standard", "Country(AVG)", "User"};
        // webView32.addView(graphs.getsinglebarchart(),
        // new LayoutParams(400, 300));
        // webView31.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "",3),
        // new LayoutParams(350, 220));
        webView32.addView(graphs.drawNbarchart(2, ast5, 17, 3),
                new LayoutParams(260, 200));
        // webView32.addView(graphs.lineChart(ast5, 17, 100, 0), new
        // LayoutParams(260, 200));

        float[] data66 = {400, 300, 255};
        String[] barlabels66 = {"Standard", "Country(AVG)", "User"};
        // webView33
        // .addView(
        // addorggraph(data66, barlabels66, 5, "Kp1",
        // "Secondary Sales", 3), new LayoutParams(350,
        // 220));
        // webView33.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "",4),
        // new LayoutParams(350, 220));
        // webView33.addView(graphs.drawNbarchart(3, ast7, 9, 3), new
        // LayoutParams(260, 220));
        webView33.addView(graphs.lineChart(ast7, 18, 200, 50),
                new LayoutParams(260, 200));

        // 4rd Row

        float[] data488 = {10, 7, 5};
        String[] barlabels488 = {"Standard", "Country(AVG)", "User"};

        // webView41.addView(
        // addorggraph(data488, barlabels488, 2, "Kp1", "% Growth", 3),
        // new LayoutParams(350, 220));

        webView41.addView(graphs.getsingleHorizontalbarchart(1),
                new LayoutParams(260, 200));
        webView42.addView(graphs.drawNbarchart(3, ast7, 18, 3),
                new LayoutParams(260, 200));
        webView43.addView(graphs.drawNbarchart(3, ast14, 18, 3),
                new LayoutParams(260, 200));
        // webView42.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "", 1), new LayoutParams(260, 220));
        // webView43.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "", 2), new LayoutParams(260, 220));
        float[] data499 = {50, 30, 40};
        String[] barlabels499 = {"Standard", "Country(AVG)", "User"};
        // webView42.addView(
        // addorggraph(data499, barlabels499, 3, "Kp1", "Drs Prescribed",
        // 3), new LayoutParams(350, 220));

        float[] data466 = {10, 4, 5};
        String[] barlabels466 = {"Standard", "Country(AVG)", "User"};
        // webView43
        // .addView(
        // addorggraph(data466, barlabels466, 5, "Kp1",
        // "Drs Converted", 3), new LayoutParams(350, 220));

        // // 5TH Row

        float[] data588 = {90, 70, 100};
        String[] barlabels588 = {"Standard", "Country(AVG)", "User"};
        // webView51.addView(
        // addorggraph(data588, barlabels588, 2, "Kp1", "Plan Adherence",
        // 3), new LayoutParams(350, 220));

        // webView51.addView(graphs.lineChart(ast1, 7, 10, -5), new
        // LayoutParams(350, 220));
        webView51.addView(graphs.lineChart(ast2, 19, 100, 50),
                new LayoutParams(260, 200));

        float[] data599 = {100, 70, 90};
        String[] barlabels599 = {"Standard", "Country(AVG)", "User"};
        // webView52.addView(
        // addorggraph(data599, barlabels599, 3, "Kp1",
        // "Campaign Adherence", 3), new LayoutParams(350, 220));
        // webView52.addView(graphs.lineChart(ast3, 5, 1500, 500), new
        // LayoutParams(350, 220));

        webView52.addView(graphs.drawNbarchart(3, ast10, 20, 3),
                new LayoutParams(260, 200));
        float[] data566 = {90, 80, 80};
        String[] barlabels566 = {"Standard", "Country(AVG)", "User"};
        // webView53.addView(
        // addorggraph(data566, barlabels566, 5, "Kp1",
        // "Detailing Adherence", 3), new LayoutParams(350, 220));

        // webView53.addView(graphs.lineChart(ast4, 6, 150, 0), new
        // LayoutParams(350, 220));
        webView53.addView(graphs.drawNbarchart(3, ast, 0, 3), new LayoutParams(
                260, 200));
        webView54.addView(graphs.piechartM(8), new LayoutParams(260, 210));

        //
        // // 6TH Row

        float[] data688 = {100, 60, 90};
        String[] barlabels688 = {"Standard", "Country(AVG)", "User"};
        // webView61.addView(
        // addorggraph(data688, barlabels688, 2, "Kp1",
        // "Reporting Compliance", 3), new LayoutParams(350, 220));
        webView61.addView(graphs.lineChart(ast3, 5, 1500, 500),
                new LayoutParams(260, 200));

        webView64.addView(graphs.lineChart(ast4, 6, 150, 0), new LayoutParams(
                260, 200));
        // webView61.addView(graphs.lineChart(ast6, 9, 400, 50), new
        // LayoutParams(350, 220));

        // float[] data599 = { 100, 70, 90 };
        // String[] barlabels599 = { "Standard", "Country(AVG)", "User" };
        // webView62.addView(
        // addorggraph(data599, barlabels599, 3, "Kp1",
        // "Campaign Adherence", 3), new LayoutParams(350, 220));
        //
        // webView62.setVisibility(View.INVISIBLE);
        // float[] data566 = { 90, 80, 80 };
        // String[] barlabels566 = { "Standard", "Country(AVG)", "User" };
        // webView63.addView(
        // addorggraph(data566, barlabels566, 5, "Kp1",
        // "Detailing Adherence", 3), new LayoutParams(350, 220));
        // webView63.setVisibility(View.INVISIBLE);
        webView63.addView(graphs.piechartM(4), new LayoutParams(260, 210));
        // 7TH ROE

        float[] data788 = {9, 8.3f, 9.5f};
        String[] barlabels788 = {"Standard", "Country(AVG)", "User"};
        // webView71
        // .addView(
        // addorggraph(data788, barlabels788, 2, "Kp1",
        // "% Dr Call Avg", 3), new LayoutParams(350, 220));

        // webView71.addView(graphs.drawNbarchart(2, ast5, 8, 3), new
        // LayoutParams(350, 220));

        webView71.addView(graphs.piechartM(6), new LayoutParams(260, 200));
        // webView73.addView(graphs.multibarchart("JAN", "FEB", "MAR", "",
        // "Abstracts", "Video", "Feeds","", 6),
        // new LayoutParams(260, 220));

        webView73.addView(graphs.drawNbarchart(3, ast11, 21, 3),
                new LayoutParams(260, 200));

        float[] data799 = {9, 6, 8};
        String[] barlabels799 = {"Standard", "Country(AVG)", "User"};
        // webView72.addView(
        // addorggraph(data799, barlabels799, 3, "Kp1", "% Calls/Day", 3),
        // new LayoutParams(350, 220));
        // webView72.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "",1),
        // new LayoutParams(350, 220));

        float[] data766 = {100, 90, 90};
        String[] barlabels766 = {"Standard", "Country(AVG)", "User"};
        // webView73.addView(
        // addorggraph(data766, barlabels766, 5, "Kp1", "Coaching Status",
        // 3), new LayoutParams(350, 220));

        // 8TH ROE

        float[] data888 = {90, 100, 95};
        String[] barlabels888 = {"Standard", "Country(AVG)", "User"};
        // webView81.addView(
        // addorggraph(data888, barlabels888, 2, "Kp1", "% Days in Field",
        // 3), new LayoutParams(350, 220));
        webView82
                .addView(graphs.StackedBarChart(1), new LayoutParams(260, 220));
        webView84.addView(graphs.lineChart(ast12, 16, 70, 30),
                new LayoutParams(260, 220));

        float[] data899 = {2, 1, 2};
        String[] barlabels899 = {"Standard", "Country(AVG)", "User"};
        // webView82.addView(
        // addorggraph(data899, barlabels899, 3, "Kp1", "CMEs Conducted",
        // 3), new LayoutParams(350, 220));
        // webView82.addView(graphs.multibarchart("", "", "", "", "", "", "",
        // "",2),
        // new LayoutParams(350, 220));

        float[] data866 = {100, 90, 90};
        String[] barlabels866 = {"Standard", "Country(AVG)", "User"};
        // webView83.addView(
        // addorggraph(data866, barlabels866, 5, "Kp1", "Coaching Status",
        // 3), new LayoutParams(350, 220));
        // webView83.setVisibility(View.INVISIBLE);

    }

    private BarChart addorggraph(float[] bardata, String[] barlabels,
                                 int theme, String Legend, String Description, int animspeedinsec) {
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < bardata.length; i++) {
            entries.add(new BarEntry(bardata[i], i));
        }

        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < barlabels.length; i++) {
            labels.add(barlabels[i]);
        }

        BarDataSet dataset = new BarDataSet(entries, Legend);
        if (theme == 1) {
            dataset.setColors(ColorTemplate.VORDIPLOM_COLORS);
        } else if (theme == 5) {
            dataset.setColors(ColorTemplate.LIBERTY_COLORS);
        } else if (theme == 2) {
            dataset.setColors(ColorTemplate.JOYFUL_COLORS);
        } else if (theme == 3) {
            dataset.setColors(ColorTemplate.PASTEL_COLORS);
        } else if (theme == 4) {
            dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        }

        BarChart chart = new BarChart(this);
        BarData data = new BarData(labels, dataset);
        chart.setData(data);
        chart.setDescription(Description);
        chart.setTouchEnabled(false);
        chart.animateY(animspeedinsec * 1000);

        // chart.setLayoutParams(new LayoutParams(width, height));
        return chart;

    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2015-09-04 16:18:25 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {

        linselction = (LinearLayout) findViewById(R.id.linselction);
        playlisrel = (RelativeLayout) findViewById(R.id.playlisrel);
        playlistnew = (TextView) findViewById(R.id.playlistnew);
        playlistnew.setOnClickListener(olc);

        viewsamplednew = (View) findViewById(R.id.viewsamplednew);
        specialty = (TextView) findViewById(R.id.specialty);
        specialty.setOnClickListener(olc);

        viewsampled = (View) findViewById(R.id.viewsampled);
        brands = (TextView) findViewById(R.id.brands);
        brands.setOnClickListener(olc);

        viewsamplech = (View) findViewById(R.id.viewsamplech);
        therapy = (TextView) findViewById(R.id.therapy);
        therapy.setOnClickListener(olc);

        viewsamplest = (View) findViewById(R.id.viewsamplest);

        graph1 = (LinearLayout) findViewById(R.id.graph1);
        graph2 = (LinearLayout) findViewById(R.id.graph2);
        graph3 = (LinearLayout) findViewById(R.id.graph3);
        graph4 = (LinearLayout) findViewById(R.id.graph4);
        graph5 = (LinearLayout) findViewById(R.id.graph5);
        graph6 = (LinearLayout) findViewById(R.id.graph6);
        graph7 = (LinearLayout) findViewById(R.id.graph7);
        graph8 = (LinearLayout) findViewById(R.id.graph8);

        webView11 = (RelativeLayout) findViewById(R.id.webview11);
        webView12 = (RelativeLayout) findViewById(R.id.webview12);
        webView13 = (RelativeLayout) findViewById(R.id.webview13);
        webView14 = (RelativeLayout) findViewById(R.id.webview14);

        webView21 = (RelativeLayout) findViewById(R.id.webview21);
        webView22 = (RelativeLayout) findViewById(R.id.webview22);
        webView23 = (RelativeLayout) findViewById(R.id.webview23);
        webView24 = (RelativeLayout) findViewById(R.id.webview24);

        webView31 = (RelativeLayout) findViewById(R.id.webview31);
        webView32 = (RelativeLayout) findViewById(R.id.webview32);
        webView33 = (RelativeLayout) findViewById(R.id.webview33);

        webView41 = (RelativeLayout) findViewById(R.id.webview41);
        webView42 = (RelativeLayout) findViewById(R.id.webview42);
        webView43 = (RelativeLayout) findViewById(R.id.webview43);

        webView51 = (RelativeLayout) findViewById(R.id.webview51);
        webView52 = (RelativeLayout) findViewById(R.id.webview52);
        webView53 = (RelativeLayout) findViewById(R.id.webview53);
        webView54 = (RelativeLayout) findViewById(R.id.webview54);

        webView61 = (RelativeLayout) findViewById(R.id.webview61);
        webView62 = (RelativeLayout) findViewById(R.id.webview62);
        webView63 = (RelativeLayout) findViewById(R.id.webview63);
        webView64 = (RelativeLayout) findViewById(R.id.webview64);

        webView71 = (RelativeLayout) findViewById(R.id.webview71);
        webView72 = (RelativeLayout) findViewById(R.id.webview72);
        webView73 = (RelativeLayout) findViewById(R.id.webview73);
        webView74 = (RelativeLayout) findViewById(R.id.webview74);

        webView81 = (RelativeLayout) findViewById(R.id.webview81);
        webView82 = (RelativeLayout) findViewById(R.id.webview82);
        webView83 = (RelativeLayout) findViewById(R.id.webview83);
        webView84 = (RelativeLayout) findViewById(R.id.webview84);

        // title7 = (TextView) findViewById(R.id.title7);
        // title7.setText(Html.fromHtml("<b>" + "9" + "</b> " + "calls/day"));
        // title19=(TextView) findViewById(R.id.title19);
        // title19.setText(Html.fromHtml("<b>" + "9" + "</b> " + "calls/day"));

        t1 = (TextView) findViewById(R.id.gtextview1);
        t2 = (TextView) findViewById(R.id.gtextview2);
        t3 = (TextView) findViewById(R.id.gtextview3);
        t4 = (TextView) findViewById(R.id.gtextview4);
        t5 = (TextView) findViewById(R.id.gtextview5);
        t6 = (TextView) findViewById(R.id.gtextview6);
        t7 = (TextView) findViewById(R.id.gtextview7);
        t8 = (TextView) findViewById(R.id.gtextview8);
        // t9=(TextView) findViewById(R.id.gtextview9);
        // t10=(TextView) findViewById(R.id.gtextview10);
        t11 = (TextView) findViewById(R.id.gtextview11);
        t12 = (TextView) findViewById(R.id.gtextview12);
        t13 = (TextView) findViewById(R.id.gtextview13);
        t14 = (TextView) findViewById(R.id.gtextview14);
        t15 = (TextView) findViewById(R.id.gtextview15);
        t16 = (TextView) findViewById(R.id.gtextview16);
        t17 = (TextView) findViewById(R.id.gtextview17);
        // t18=(TextView) findViewById(R.id.gtextview18);
        t19 = (TextView) findViewById(R.id.gtextview19);

        t1.setTag("" + 1);
        t2.setTag("" + 2);
        t3.setTag("" + 3);
        t4.setTag("" + 4);
        t5.setTag("" + 5);

        t6.setTag("" + 6);
        t7.setTag("" + 7);
        t8.setTag("" + 8);
        // t9.setTag(""+9);
        // t10.setTag(""+10);
        t11.setTag("" + 11);
        t12.setTag("" + 12);
        t13.setTag("" + 13);

        t14.setTag("" + 14);
        t15.setTag("" + 15);
        t16.setTag("" + 16);
        t17.setTag("" + 17);
        // t18.setTag(""+18);
        t19.setTag("" + 19);

        t1.setOnClickListener(graphlisten);
        // t2.setOnClickListener(graphlisten);
        // t3.setOnClickListener(graphlisten);
        // t4.setOnClickListener(graphlisten);
        // t5.setOnClickListener(graphlisten);
        // t6.setOnClickListener(graphlisten);
        // t7.setOnClickListener(graphlisten);
        // t8.setOnClickListener(graphlisten);
        // // t9.setOnClickListener(graphlisten);
        // // t10.setOnClickListener(graphlisten);
        // t11.setOnClickListener(graphlisten);
        // t12.setOnClickListener(graphlisten);
        // t13.setOnClickListener(graphlisten);
        // t14.setOnClickListener(graphlisten);
        // t15.setOnClickListener(graphlisten);
        // t16.setOnClickListener(graphlisten);
        // t17.setOnClickListener(graphlisten);
        // // t18.setOnClickListener(graphlisten);
        // t19.setOnClickListener(graphlisten);

        scroller = (CustomScrollViewDash) findViewById(R.id.scroll);

    }

    OnClickListener olc = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            switch (v.getId()) {

                case R.id.playlistnew:
                    pagecount = 1;
                    scroller.scrollTo(graph1.getLeft(), graph1.getTop() - 20);
                    viewsamplednew.setVisibility(View.VISIBLE);
                    viewsampled.setVisibility(View.GONE);
                    viewsamplech.setVisibility(View.GONE);
                    viewsamplest.setVisibility(View.GONE);
                    // webView11.setVisibility(View.VISIBLE);
                    // webView12.setVisibility(View.VISIBLE);
                    // webView21.setVisibility(View.VISIBLE);
                    // Graphs graphs6 = new Graphs(Dashboard.this);
                    // webView22.setVisibility(View.VISIBLE);
                    // webView31.setVisibility(View.VISIBLE);
                    //
                    // TextView tqq11 = (TextView) webView11.getChildAt(0);
                    // TextView tqq21 = (TextView) webView12.getChildAt(0);
                    // TextView tqq31 = (TextView) webView21.getChildAt(0);
                    // TextView tqq41 = (TextView) webView22.getChildAt(0);
                    // TextView tqq51 = (TextView) webView31.getChildAt(0);
                    // TextView tqq11t = (TextView) webView11.getChildAt(1);
                    // TextView tqq21t = (TextView) webView12.getChildAt(1);
                    // TextView tqq31t = (TextView) webView21.getChildAt(1);
                    // TextView tqq41t = (TextView) webView22.getChildAt(1);
                    // TextView tqq51t = (TextView) webView31.getChildAt(1);
                    //
                    // webView11.removeAllViews();
                    // webView12.removeAllViews();
                    // webView21.removeAllViews();
                    // webView22.removeAllViews();
                    // webView31.removeAllViews();
                    // tqq11.setText("Dr Coverage");
                    // tqq21.setText("Dr Call Avg");
                    // tqq31.setText("Missed Doctor");
                    // tqq41.setText("Days in Field");
                    // tqq51.setText("Reporting compliance");
                    //
                    // webView11.addView(tqq11);
                    // webView12.addView(tqq21);
                    // webView21.addView(tqq31);
                    // webView22.addView(tqq41);
                    // webView31.addView(tqq51);
                    //
                    // webView11.addView(tqq11t);
                    // webView12.addView(tqq21t);
                    // webView21.addView(tqq31t);
                    // webView22.addView(tqq41t);
                    // webView31.addView(tqq51t);
                    //
                    // webView11.addView(graphs6.drawNbarchart(3, ast, 0, 3), new
                    // LayoutParams(500, 320));
                    // webView12.addView(graphs6.lineChart(ast, 1, 10, 0), new
                    // LayoutParams(550, 320));
                    // webView21.addView(graphs6.drawNbarchart(2, ast1, 2, 3), new
                    // LayoutParams(550, 320));
                    // webView22.addView(graphs6.piechartM(3), new LayoutParams(550,
                    // 340));
                    // webView31.addView(graphs6.lineChart(ast2, 3, 30, 0), new
                    // LayoutParams(550, 320));

                    break;
                case R.id.specialty:
                    pagecount = 2;
                    scroller.scrollTo(graph3.getLeft(), graph3.getTop() - 20);
                    viewsamplednew.setVisibility(View.GONE);
                    viewsampled.setVisibility(View.VISIBLE);
                    viewsamplech.setVisibility(View.GONE);
                    viewsamplest.setVisibility(View.GONE);

                    // Graphs graphs = new Graphs(Dashboard.this);
                    // TextView tq1 = (TextView) webView11.getChildAt(0);
                    // TextView tq2 = (TextView) webView12.getChildAt(0);
                    // TextView tq1t = (TextView) webView11.getChildAt(1);
                    // TextView tq2t = (TextView) webView12.getChildAt(1);
                    //
                    // webView11.removeAllViews();
                    // webView12.removeAllViews();
                    // tq1.setText("Plan Adherence");
                    // tq2.setText("Campaign Adherence");
                    // webView11.addView(tq1);
                    // webView12.addView(tq2);
                    //
                    // webView11.addView(tq1t);
                    // webView12.addView(tq2t);
                    //
                    // // webView11.addView(graphs.drawNbarchart(3,ast,4,3), new
                    // // LayoutParams(500, 350));
                    //
                    // webView11.addView(graphs.lineChart(ast, 4, 100, 50), new
                    // LayoutParams(550, 320));
                    //
                    // // webView12.addView(graphs.getsinglebarchartP(2), new
                    // // LayoutParams(550, 325));
                    // webView12.addView(graphs.piechartM(2), new LayoutParams(550,
                    // 320));
                    //
                    // webView21.setVisibility(View.GONE);
                    // webView22.setVisibility(View.GONE);
                    // webView31.setVisibility(View.GONE);
                    break;

                case R.id.brands:
                    pagecount = 3;
                    Graphs graphs1 = new Graphs(Dashboard.this);
                    scroller.scrollTo(graph5.getLeft(), graph5.getTop() - 20);
                    viewsamplednew.setVisibility(View.GONE);
                    viewsampled.setVisibility(View.GONE);
                    viewsamplech.setVisibility(View.VISIBLE);
                    viewsamplest.setVisibility(View.GONE);

                    // webView11.setVisibility(View.VISIBLE);
                    // webView12.setVisibility(View.VISIBLE);
                    // webView21.setVisibility(View.VISIBLE);
                    //
                    // TextView tq11 = (TextView) webView11.getChildAt(0);
                    // TextView tq21 = (TextView) webView12.getChildAt(0);
                    // TextView tq31 = (TextView) webView21.getChildAt(0);
                    //
                    // TextView tq11t = (TextView) webView11.getChildAt(1);
                    // TextView tq21t = (TextView) webView12.getChildAt(1);
                    // TextView tq31t = (TextView) webView21.getChildAt(1);
                    //
                    // webView11.removeAllViews();
                    // webView12.removeAllViews();
                    // webView21.removeAllViews();
                    // tq11.setText("Secondary Sales");
                    // tq21.setText("Drs Prescribed and converted");
                    // tq31.setText("Growth");
                    //
                    // webView11.addView(tq11);
                    // webView12.addView(tq21);
                    // webView21.addView(tq31);
                    //
                    // webView11.addView(tq11t);
                    // webView12.addView(tq21t);
                    // webView21.addView(tq31t);
                    //
                    // webView11.addView(graphs1.drawNbarchart(3, ast3, 5, 3), new
                    // LayoutParams(500, 320));
                    // webView12.addView(graphs1.drawNbarchart(3, ast4, 6, 3), new
                    // LayoutParams(550, 320));
                    // webView21.addView(graphs1.drawNbarchart(2, ast1, 7, 3), new
                    // LayoutParams(550, 320));
                    //
                    // //
                    // // webView11.addView(graphs1.lineChart(ast3, 5, 1500, 500),
                    // new
                    // // LayoutParams(550, 340));
                    // // webView12.addView(graphs1.lineChart(ast4, 6, 150, 0), new
                    // // LayoutParams(550, 340));
                    // // webView21.addView(graphs1.lineChart(ast1, 7, 10, -5), new
                    // // LayoutParams(550, 340));
                    //
                    // webView22.setVisibility(View.INVISIBLE);
                    // webView31.setVisibility(View.GONE);

                    break;

                case R.id.therapy:
                    pagecount = 4;
                    scroller.scrollTo(graph7.getLeft(), graph7.getTop() - 20);
                    viewsamplednew.setVisibility(View.GONE);
                    viewsampled.setVisibility(View.GONE);
                    viewsamplech.setVisibility(View.GONE);
                    viewsamplest.setVisibility(View.VISIBLE);

                    // webView11.setVisibility(View.VISIBLE);
                    // webView12.setVisibility(View.VISIBLE);
                    // Graphs graphs2 = new Graphs(Dashboard.this);
                    // // webView11.removeAllViews();
                    // // webView12.removeAllViews();
                    //
                    // TextView tq41 = (TextView) webView11.getChildAt(0);
                    // TextView tq32 = (TextView) webView12.getChildAt(0);
                    //
                    // TextView tq41t = (TextView) webView11.getChildAt(1);
                    // TextView tq32t = (TextView) webView12.getChildAt(1);
                    // webView11.removeAllViews();
                    // webView12.removeAllViews();
                    //
                    // tq41.setText("Detailing Adherence");
                    // tq32.setText("Speciality Wise Brand Detailed");
                    //
                    // webView11.addView(tq41);
                    // webView12.addView(tq32);
                    // webView11.addView(tq41t);
                    // webView12.addView(tq32t);
                    // // webView11.addView(graphs2.drawNbarchart(2,ast5,8,3), new
                    // // LayoutParams(500, 350));
                    // webView11.addView(graphs2.lineChart(ast2, 8, 100, 0), new
                    // LayoutParams(550, 300));
                    //
                    // webView12.addView(graphs2.multibarchart("", "", "", "", "",
                    // "", "", ""), new LayoutParams(550, 310));
                    // webView21.setVisibility(View.GONE);
                    // webView22.setVisibility(View.GONE);
                    // webView31.setVisibility(View.GONE);
                    break;

                default:
                    break;
            }

            // scroller.scrollTo(webView11.getLeft(), webView11.getTop());
        }
    };

    android.view.View.OnClickListener graphlisten = new OnClickListener() {

        private Dialog dialog_box;
        int piet = 0;
        int linet = 0;
        int bart = 0;

        @Override
        public void onClick(final View vp) {
            if (vp == t1) {
                dialog_box = new Dialog(Dashboard.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.dashboard_dialog);
                Graphs gp = new Graphs(Dashboard.this);
                webView19 = (RelativeLayout) dialog_box
                        .findViewById(R.id.webview12);
                webView19.addView(gp.drawNbarchart(3, ast, 0, 3),
                        new LayoutParams(260, 200));
                RelativeLayout thip = (RelativeLayout) vp.getParent();
                final TextView graphtitle = (TextView) dialog_box
                        .findViewById(R.id.titlegraph);

                final TextView barchart = (TextView) dialog_box
                        .findViewById(R.id.bar);
                final TextView line = (TextView) dialog_box
                        .findViewById(R.id.line);
                final TextView pie = (TextView) dialog_box
                        .findViewById(R.id.pie);
                TextView tv = (TextView) thip.getChildAt(0);
                pie.setVisibility(View.GONE);
                barchart.setVisibility(View.VISIBLE);
                line.setVisibility(View.VISIBLE);
                barchart.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        barchart.setTextColor(Color.parseColor("#29b6f6"));
                        line.setTextColor(Color.parseColor("#000000"));
                        pie.setTextColor(Color.parseColor("#000000"));
                        piet = 0;
                        linet = 0;
                        bart = 1;

                    }
                });
                barchart.setTypeface(font);

                line.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        barchart.setTextColor(Color.parseColor("#000000"));
                        line.setTextColor(Color.parseColor("#29b6f6"));
                        pie.setTextColor(Color.parseColor("#000000"));
                        piet = 0;
                        linet = 1;
                        bart = 0;

                    }
                });
                line.setTypeface(font);

                pie.setTypeface(font);
                pie.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        barchart.setTextColor(Color.parseColor("#000000"));
                        line.setTextColor(Color.parseColor("#000000"));
                        pie.setTextColor(Color.parseColor("#29b6f6"));
                        piet = 1;
                        linet = 0;
                        bart = 0;

                    }
                });
                Button button = (Button) dialog_box.findViewById(R.id.save23);

                button.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog_box.dismiss();

                        Graphs graphs = new Graphs(Dashboard.this);

                        RelativeLayout thirdP = (RelativeLayout) vp.getParent();
                        LinearLayout secondP = (LinearLayout) thirdP
                                .getParent();
                        LinearLayout firstP = (LinearLayout) secondP
                                .getParent();

                        int secondcount = firstP.indexOfChild(secondP);
                        int thirdcount = secondP.indexOfChild(thirdP);

                        if (piet == 1) {
                            TextView t1 = (TextView) thirdP.getChildAt(0);
                            TextView t2 = (TextView) thirdP.getChildAt(1);
                            thirdP.removeAllViews();
                            thirdP.addView(t1);
                            thirdP.addView(t2);

                            // webView11.addView(graphs.piechartM(3), new
                            // LayoutParams(350, 200));

                        } else if (linet == 1) {
                            TextView t1 = (TextView) thirdP.getChildAt(0);
                            TextView t2 = (TextView) thirdP.getChildAt(1);
                            thirdP.removeAllViews();
                            thirdP.addView(t1);
                            thirdP.addView(t2);

                            webView11.addView(graphs.lineChart(ast, 0, 100, 0),
                                    new LayoutParams(260, 200));

                        } else if (bart == 1) {
                            TextView t1 = (TextView) thirdP.getChildAt(0);
                            TextView t2 = (TextView) thirdP.getChildAt(1);
                            thirdP.removeAllViews();
                            thirdP.addView(t1);
                            thirdP.addView(t2);
                            webView11.addView(
                                    graphs.drawNbarchart(3, ast, 0, 3),
                                    new LayoutParams(260, 200));

                        }

                    }
                });

                graphtitle.setText(tv.getText());
                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                Display display = ((WindowManager) Dashboard.this
                        .getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();
                int width = display.getWidth();
                dialog_box.getWindow().setLayout(width / 2, 550);
                WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                        .getAttributes();
                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                wmlp.x = 4;
                wmlp.y = 131;
                // dialog_box.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog_box.show();
            } else {
                dialog_box = new Dialog(Dashboard.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.graphdialog);
                final TextView graphtitle = (TextView) dialog_box
                        .findViewById(R.id.titlegraph);
                RelativeLayout thip = (RelativeLayout) vp.getParent();

                TextView tv = (TextView) thip.getChildAt(0);

                graphtitle.setText(tv.getText());

                final TextView barchart = (TextView) dialog_box
                        .findViewById(R.id.bar);
                final TextView line = (TextView) dialog_box
                        .findViewById(R.id.line);
                final TextView pie = (TextView) dialog_box
                        .findViewById(R.id.pie);
                int count = Integer.parseInt((String) vp.getTag());
                if (count == 1 || count == 2 || count == 3 || count == 5
                        || count == 6 || count == 7 || count == 8 || count == 9
                        || count == 10 || count == 11 || count == 12
                        || count == 13 || count == 14 || count == 17
                        || count == 18 || count == 19) {
                    pie.setVisibility(View.GONE);
                    line.setVisibility(View.VISIBLE);
                    barchart.setVisibility(View.VISIBLE);
                } else if (count == 16 || count == 4) {
                    pie.setVisibility(View.VISIBLE);
                    line.setVisibility(View.GONE);
                    barchart.setVisibility(View.VISIBLE);
                } else {
                    pie.setVisibility(View.VISIBLE);
                    line.setVisibility(View.GONE);
                    barchart.setVisibility(View.GONE);
                }

                // if (pagecount == 2) {
                // if (vp.getTag().equals("1")) {
                // pie.setVisibility(View.GONE);
                // line.setVisibility(View.VISIBLE);
                // barchart.setVisibility(View.VISIBLE);
                // } else if (vp.getTag().equals("2")) {
                // pie.setVisibility(View.VISIBLE);
                // line.setVisibility(View.GONE);
                // barchart.setVisibility(View.VISIBLE);
                // }
                // } else if (pagecount == 3) {
                // pie.setVisibility(View.GONE);
                // line.setVisibility(View.VISIBLE);
                // barchart.setVisibility(View.VISIBLE);
                // } else if (pagecount == 4) {
                // if (vp.getTag().equals("2")) {
                // pie.setVisibility(View.GONE);
                // line.setVisibility(View.GONE);
                // barchart.setVisibility(View.VISIBLE);
                // } else {
                // pie.setVisibility(View.GONE);
                // line.setVisibility(View.VISIBLE);
                // barchart.setVisibility(View.VISIBLE);
                // }
                // } else {
                //
                // if (vp.getTag().equals("1") || vp.getTag().equals("2") ||
                // vp.getTag().equals("3")
                // || vp.getTag().equals("5")) {
                // pie.setVisibility(View.GONE);
                // line.setVisibility(View.VISIBLE);
                // barchart.setVisibility(View.VISIBLE);
                // } else if (vp.getTag().equals("4")) {
                // pie.setVisibility(View.VISIBLE);
                // line.setVisibility(View.GONE);
                // barchart.setVisibility(View.VISIBLE);
                // }
                //
                // }
                barchart.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        barchart.setTextColor(Color.parseColor("#29b6f6"));
                        line.setTextColor(Color.parseColor("#000000"));
                        pie.setTextColor(Color.parseColor("#000000"));
                        piet = 0;
                        linet = 0;
                        bart = 1;

                    }
                });
                barchart.setTypeface(font);

                line.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        barchart.setTextColor(Color.parseColor("#000000"));
                        line.setTextColor(Color.parseColor("#29b6f6"));
                        pie.setTextColor(Color.parseColor("#000000"));
                        piet = 0;
                        linet = 1;
                        bart = 0;

                    }
                });
                line.setTypeface(font);

                pie.setTypeface(font);
                pie.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        barchart.setTextColor(Color.parseColor("#000000"));
                        line.setTextColor(Color.parseColor("#000000"));
                        pie.setTextColor(Color.parseColor("#29b6f6"));
                        piet = 1;
                        linet = 0;
                        bart = 0;

                    }
                });

                Button button = (Button) dialog_box.findViewById(R.id.save23);

                button.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Graphs graphs = new Graphs(Dashboard.this);

                        RelativeLayout thirdP = (RelativeLayout) vp.getParent();
                        LinearLayout secondP = (LinearLayout) thirdP
                                .getParent();
                        LinearLayout firstP = (LinearLayout) secondP
                                .getParent();

                        int secondcount = firstP.indexOfChild(secondP);
                        int thirdcount = secondP.indexOfChild(thirdP);

                        if (piet == 1) {
                            TextView t1 = (TextView) thirdP.getChildAt(0);
                            TextView t2 = (TextView) thirdP.getChildAt(1);
                            thirdP.removeAllViews();
                            thirdP.addView(t1);
                            thirdP.addView(t2);

                            // RelativeLayout r =(RelativeLayout)
                            // vp.getParent();
                            // TextView t1 = (TextView) thirdP.getChildAt(0);
                            // TextView t2 = (TextView) thirdP.getChildAt(1);
                            // thirdP.removeAllViews();
                            // thirdP.addView(t1);
                            // thirdP.addView(t2);

                            if (secondcount == 1) {

                                webView22.addView(graphs.piechartM(3),
                                        new LayoutParams(350, 200));
                            } else if (secondcount == 5) {

                                webView63.addView(graphs.piechartM(4),
                                        new LayoutParams(350, 200));
                            } else {
                                webView71.addView(graphs.piechartM(5),
                                        new LayoutParams(350, 200));
                            }
                        } else if (linet == 1) {
                            TextView t1 = (TextView) thirdP.getChildAt(0);
                            TextView t2 = (TextView) thirdP.getChildAt(1);
                            thirdP.removeAllViews();
                            thirdP.addView(t1);
                            thirdP.addView(t2);

                            if (secondcount == 0) {

                                if (thirdcount == 2) {

                                    webView13.addView(
                                            graphs.lineChart(ast2, 3, 30, 0),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView11.addView(
                                            graphs.lineChart(ast, 0, 100, 0),
                                            new LayoutParams(350, 220));
                                }
                            } else if (secondcount == 1) {
                                if (thirdcount == 2) {

                                    webView23.addView(
                                            graphs.lineChart(ast, 1, 10, 0),
                                            new LayoutParams(550, 320));
                                } else {
                                    webView21.addView(
                                            graphs.lineChart(ast1, 2, 35, 0),
                                            new LayoutParams(350, 220));
                                }
                            } else if (secondcount == 2) {
                                if (thirdcount == 2) {

                                    webView33.addView(
                                            graphs.lineChart(ast, 14, 50, 0),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView31.addView(
                                            graphs.lineChart(ast9, 13, 10, 0),
                                            new LayoutParams(350, 220));
                                }
                            } else if (secondcount == 3) {
                                webView41.addView(
                                        graphs.lineChart(ast, 15, 100, 0),
                                        new LayoutParams(350, 220));
                            } else if (secondcount == 4) {
                                if (thirdcount == 2) {

                                    webView53.addView(
                                            graphs.lineChart(ast4, 6, 150, 0),
                                            new LayoutParams(350, 220));
                                } else if (thirdcount == 1) {

                                    webView52.addView(graphs.lineChart(ast3, 5,
                                            1500, 500), new LayoutParams(350,
                                            220));
                                } else {
                                    webView51.addView(
                                            graphs.lineChart(ast1, 7, 10, -5),
                                            new LayoutParams(350, 220));
                                }
                            } else if (secondcount == 5) {
                                webView61.addView(
                                        graphs.lineChart(ast6, 9, 400, 50),
                                        new LayoutParams(350, 220));
                            } else if (secondcount == 6) {
                                webView72.addView(
                                        graphs.lineChart(ast8, 10, 100, 0),
                                        new LayoutParams(350, 220));
                            } else {
                                if (thirdcount == 1) {

                                    webView82.addView(
                                            graphs.lineChart(ast8, 12, 200, 50),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView81.addView(
                                            graphs.lineChart(ast7, 11, 10, 0),
                                            new LayoutParams(350, 220));
                                }
                            }

                        } else if (bart == 1) {
                            TextView t1 = (TextView) thirdP.getChildAt(0);
                            TextView t2 = (TextView) thirdP.getChildAt(1);
                            thirdP.removeAllViews();
                            thirdP.addView(t1);
                            thirdP.addView(t2);

                            if (secondcount == 0) {
                                webView12.addView(
                                        graphs.drawNbarchart(2, ast2, 3, 3),
                                        new LayoutParams(260, 200));
                                // webView12.addView(graphs.drawNbarchart(3,
                                // ast, 0, 3), new LayoutParams(260, 200));

                                // if (thirdcount == 2) {
                                //
                                // webView13.addView(graphs.drawNbarchart(2,
                                // ast2, 3, 3), new LayoutParams(350, 220));
                                //
                                // } else {
                                // webView11.addView(graphs.drawNbarchart(3,
                                // ast, 0, 3), new LayoutParams(350, 220));
                                // }
                            } else if (secondcount == 1) {
                                if (thirdcount == 2) {

                                    webView23.addView(
                                            graphs.drawNbarchart(3, ast, 1, 3),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView21.addView(
                                            graphs.drawNbarchart(2, ast1, 2, 3),
                                            new LayoutParams(350, 220));
                                }
                            } else if (secondcount == 2) {
                                if (thirdcount == 2) {

                                    webView33.addView(
                                            graphs.lineChart(ast, 14, 50, 0),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView31.addView(graphs.multibarchart("",
                                                    "", "", "", "", "", "", "", 3),
                                            new LayoutParams(350, 220));
                                }
                            } else if (secondcount == 3) {
                                webView41.addView(graphs.multibarchart("", "",
                                                "", "", "", "", "", "", 5),
                                        new LayoutParams(350, 220));
                            } else if (secondcount == 4) {
                                if (thirdcount == 2) {

                                    webView53.addView(
                                            graphs.drawNbarchart(3, ast4, 6, 3),
                                            new LayoutParams(350, 220));
                                } else if (thirdcount == 1) {

                                    webView52.addView(
                                            graphs.drawNbarchart(3, ast3, 5, 3),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView51.addView(
                                            graphs.drawNbarchart(2, ast1, 7, 3),
                                            new LayoutParams(350, 220));
                                }
                            } else if (secondcount == 5) {

                                webView61.addView(
                                        graphs.drawNbarchart(2, ast6, 10, 3),
                                        new LayoutParams(350, 220));

                            } else if (secondcount == 6)

                            {

                                if (thirdcount == 1) {
                                    webView72.addView(graphs.multibarchart("",
                                                    "", "", "", "", "", "", "", 1),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView71.addView(
                                            graphs.getsinglebarchart(1),
                                            new LayoutParams(350, 220));
                                }
                            } else {

                                if (thirdcount == 1) {

                                    webView82.addView(graphs.multibarchart("",
                                                    "", "", "", "", "", "", "", 2),
                                            new LayoutParams(350, 220));
                                } else {
                                    webView81.addView(
                                            graphs.drawNbarchart(3, ast6, 9, 3),
                                            new LayoutParams(350, 220));
                                }
                            }

                            // TextView t1 = (TextView) thirdP.getChildAt(0);
                            // TextView t2 = (TextView) thirdP.getChildAt(1);
                            // thirdP.removeAllViews();
                            // thirdP.addView(t1);
                            // thirdP.addView(t2);

                            // if (pagecount == 1) {
                            // if (secondcount == 0) {
                            // if (thirdcount == 0) {
                            // webView11.addView(graphs.drawNbarchart(3, ast, 0,
                            // 3),
                            // new LayoutParams(500, 320));
                            // } else {
                            // webView12.addView(graphs.drawNbarchart(3, ast, 1,
                            // 3),
                            // new LayoutParams(550, 320));
                            // }
                            // } else if (secondcount == 1) {
                            // if (thirdcount == 0) {
                            // webView21.addView(graphs.drawNbarchart(2, ast1,
                            // 2,
                            // 3), new LayoutParams(550, 320));
                            //
                            // } else {
                            // webView22.addView(graphs.getsinglebarchartP(1),
                            // new
                            // LayoutParams(550, 320));
                            // }
                            // } else {
                            //
                            // webView31.addView(graphs.drawNbarchart(2, ast2,
                            // 3,
                            // 3), new LayoutParams(550, 320));
                            // }
                            //
                            // } else if (pagecount == 2) {
                            // if (thirdcount == 0) {
                            // webView11.addView(graphs.drawNbarchart(3, ast, 4,
                            // 3),
                            // new LayoutParams(500, 320));
                            // }
                            //
                            // else {
                            // webView12.addView(graphs.getsinglebarchartP(2),
                            // new
                            // LayoutParams(550, 320));
                            //
                            // }
                            //
                            // } else if (pagecount == 3) {
                            // if (secondcount == 0) {
                            // if (thirdcount == 0) {
                            // webView11.addView(graphs.drawNbarchart(3, ast3,
                            // 5,
                            // 3), new LayoutParams(500, 320));
                            // } else {
                            // webView12.addView(graphs.drawNbarchart(3, ast4,
                            // 6,
                            // 3), new LayoutParams(550, 320));
                            //
                            // }
                            //
                            // } else {
                            //
                            // webView21.addView(graphs.drawNbarchart(2, ast1,
                            // 7,
                            // 3), new LayoutParams(550, 320));
                            // }
                            // } else {
                            // if (thirdcount == 0) {
                            // webView11.addView(graphs.drawNbarchart(2, ast5,
                            // 8,
                            // 3), new LayoutParams(500, 320));
                            //
                            // } else {
                            // webView12.addView(graphs.multibarchart("", "",
                            // "",
                            // "", "", "", "", "",1),
                            // new LayoutParams(500, 310));
                            // }
                            //
                            // }

                            // RelativeLayout r =(RelativeLayout)
                            // vp.getParent();
                            // TextView t1=(TextView) thirdP.getChildAt(0);
                            // thirdP.removeAllViews();
                            // thirdP.addView(t1);
                            //
                            //
                            // thirdP.addView(graphs.drawNbarchart(3,ast,0,3),
                            // new LayoutParams(500, 350));

                        }

                        dialog_box.dismiss();

                    }
                });

                Window window = dialog_box.getWindow();

                WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                        .getAttributes();
                int[] viewLocation = new int[2];
                vp.getLocationOnScreen(viewLocation);

                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                // wmlp.x = viewLocation[0];
                // wmlp.y = viewLocation[1];

                View vfg = (View) vp.getParent();
                int x = vfg.getLeft();
                int y = vfg.getTop();

                wmlp.x = x + 7;
                wmlp.y = y + 135;
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(300, 480);
                dialog_box.show();

                // cefixime.htm
            }
        }
    };

    public void changeHeader(int index) {
        if (index == 0 || index == 1 || index == 8) {
            index = 0;
        } else if (index == 2 || index == 3) {
            index = 1;
        } else if (index == 4 || index == 5) {
            index = 2;
        } else if (index == 6 || index == 7) {
            index = 3;
        }
        // RelativeLayout rl = (RelativeLayout) linselction.getChildAt(index);
        // String header = ((TextView) rl.getChildAt(0)).getText().toString();

        for (int i = 0; i < linselction.getChildCount(); i++) {
            RelativeLayout relative = (RelativeLayout) linselction
                    .getChildAt(i);
            if (index == i) {
                ((TextView) relative.getChildAt(0)).setTypeface(null,
                        Typeface.BOLD);
                ((TextView) relative.getChildAt(0)).setTextColor(Color
                        .parseColor("#000000"));
                relative.getChildAt(1).setVisibility(View.VISIBLE);
            } else {
                ((TextView) relative.getChildAt(0)).setTypeface(null,
                        Typeface.NORMAL);
                ((TextView) relative.getChildAt(0)).setTextColor(Color
                        .parseColor("#808080"));
                relative.getChildAt(1).setVisibility(View.INVISIBLE);
            }
        }
    }

}