package com.cirrius.iclmcipla;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;

import com.idunnololz.widgets.ColorPickerDialog;
import com.idunnololz.widgets.ColorPickerDialog.OnColorSelectedListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


@SuppressLint("SetJavaScriptEnabled")
public class DetailingPageV2 extends Activity implements OnClickListener {

    // ------------------------------------------
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10;
    TextView textv;
    ImageView upbutton;
    ImageView downbutton;

    int alo = 0;
    @SuppressWarnings("deprecation")
    // topslideview;
            String url = "";
    Button open = null;
    SeekBar seek;
    ImageView colorw;
    int backCount = 0;
    LinearLayout linearLayout;
    EditText focusedView;
    CustomAdapter adapter, adapter2;
    ListView lv, lv2;
    List<String[]> dataList, dataList2;
    ImageView button;
    Dialog dialog;
    EditText edit1, edit2;

    // ---

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

    int count = 1;
    // -------------------------------------------

    String[] relatedinformation = {"Intence Bacetricidal Action",
            "Cefixime power", "Indications",
            "Lorem  ipusm dolor sit amet dolor ipsum",
            "Geography distrubution",
            "Lorem  ipusm dolor sit amet dolor ipsum",
            "Dolor sit and dolor ipsum", "ipsum dolor amet sir dolor",
            "ipsum dolor amet sir dolor", "Dolor sit and dolor ipsum"};

    String[] toptopicrealted = {"Intence Bacetricidal Action",
            "Cefixime power", "Indications",
            "Lorem  ipusm dolor sit amet dolor ipsum",
            "Geography distrubution",
            "Lorem  ipusm dolor sit amet dolor ipsum",
            "Dolor sit and dolor ipsum", "ipsum dolor amet sir dolor",
            "ipsum dolor amet sir dolor", "Dolor sit and dolor ipsum"};

    String[] topfaqs = {"Intence Bacetricidal Action", "Cefixime power",
            "Indications", "Lorem  ipusm dolor sit amet dolor ipsum",
            "Geography distrubution",
            "Lorem  ipusm dolor sit amet dolor ipsum",
            "Dolor sit and dolor ipsum", "ipsum dolor amet sir dolor",
            "ipsum dolor amet sir dolor", "Dolor sit and dolor ipsum"};

    // -----------------------------------------------------------------------------

    int aqqq = 0;
    int PDF_REQ_CODE = 10000;
    int PDF_QUICK_DET_CODE = 10001;
    int indexType;
    ReadWriteData rw = new ReadWriteData(this, "MPOWERDB", null, 1);
    String[][] brandData;
    String[][] pageData;
    String[][] pdfData;
    String[][] swfData;
    String[][] vidData;
    String[][] htmData;
    String[][] allData;
    ArrayList<String[]> playTimes;
    long startTime;
    long endTime;
    String contentCode;
    String brandCode;
    // String date;

    public static boolean flag = false;

    WebView webView;
    VideoView vidView;
    public static String swfUrl;
    boolean isFocussedBrands = true;
    boolean isReferenceContent = true;
    ImageView pages, previousBrand, nextBrand;
    ;
    int index = 0, pageindex = 0;
    Bundle bundle;
    boolean firstTime = true;
    boolean emailflg = false;
    String like = "";
    String menutext = "";
    String tempContentCode = "";
    Button nextCnt, prevCnt, btnPP, btnOrder, btnInput, btnFeedback, btnLike,
            btnDislike;

    String index1 = "1";

    EditText brandpage;

    String col_like = "";

    String[][] brandPages = null;
    String brndCode = "";
    int pIndex = 0;
    int page = 0;

    TextView brand;

    static int screenwidth = 0;
    static int screenheight = 0;

    int width = 0;
    static int height = 0;

    int rcpawidth = 0;

    HorizontalScrollView scr;

    int flaglike = 0;

    int a = 0, b = 0;
    GestureOverlayView gesturesView, gesturesView2;
    LinearLayout focussedBarpages;

    String tblename = "";
    // -----------------------------------------------------------

    // ListView list1, list2, list3;

    // ------------------------------------------------------------

    private LinearLayout linearbuttonlayout;
    // private TextView ButtonSearch;
    // private TextView ButtonProduct;
    // private ExpandableListView expandablelist;

    // -----------------------------------------

    // private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private View viewsearch;
    private View viewproduct;
    private ImageView Reporting;
    private ImageView refrence;
    private Button note11;
    private Button like11;
    String cross;
    ImageView onkarkabtton;
    ImageView notes1, email1, play, like1, dislike1, sample1, search, annot2,
            feedback, order;
    HorizontalScrollView myscroll2;
    LinearLayout mylinear;
    Typeface font = null;
    private TextView textv2;
    private ImageView img11, img21, img31, img41;
    private ImageView lpsp;
    private TextView name;
    private ImageView next;
    private String drname;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        getActionBar().hide();
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        setContentView(R.layout.old_detailingv3);
        Reporting = (ImageView) findViewById(R.id.Reporting);
        refrence = (ImageView) findViewById(R.id.refrence);
        refrence.setOnClickListener(this);

        myscroll2 = (HorizontalScrollView) findViewById(R.id.myscroll2);
        mylinear = (LinearLayout) findViewById(R.id.mainid);

        onkarkabtton = (ImageView) findViewById(R.id.onkarkabtton);
        onkarkabtton.setOnClickListener(this);

        try {

            Bundle extras = getIntent().getExtras();
            index1 = extras.getString("KT");
            cross = extras.getString("getclose");
            drname = extras.getString("name");

            if (cross.equals("1")) {
                // Reporting.setVisibility(View.GONE);
            }

        } catch (Exception e) {
            cross = "";
            e.printStackTrace();
        }
        name = (TextView) findViewById(R.id.name);
        if (drname != null)
            name.setText("Dr. " + drname);
        next = (ImageView) findViewById(R.id.next);
        next.setOnClickListener(nextListener);
        previousBrand = (ImageView) findViewById(R.id.previousbrand);
        nextBrand = (ImageView) findViewById(R.id.nextbrand);
        previousBrand.setVisibility(View.INVISIBLE);
        // nextBrand.setVisibility(View.INVISIBLE);
        previousBrand.setOnClickListener(nextNPrevListener);
        nextBrand.setOnClickListener(nextNPrevListener);
        notes1 = (ImageView) findViewById(R.id.anot);
        notes1.setOnClickListener(this);
        feedback = (ImageView) findViewById(R.id.feedback);
        feedback.setOnClickListener(this);
        feedback.setTag("1");
        email1 = (ImageView) findViewById(R.id.email1);
        email1.setOnClickListener(this);
        email1.setTag("1");
        play = (ImageView) findViewById(R.id.play);
        play.setOnClickListener(this);
        play.setTag("1");
        annot2 = (ImageView) findViewById(R.id.annot2);
        annot2.setOnClickListener(this);
        like1 = (ImageView) findViewById(R.id.like1);
        like1.setOnClickListener(this);
        like1.setTag("1");
        dislike1 = (ImageView) findViewById(R.id.dislike11);
        dislike1.setOnClickListener(this);
        dislike1.setTag("1");
        sample1 = (ImageView) findViewById(R.id.sampl1);
        sample1.setOnClickListener(this);
        order = (ImageView) findViewById(R.id.order);
        order.setOnClickListener(this);
        search = (ImageView) findViewById(R.id.searchicon);
        search.setOnClickListener(this);

        // -------------------------------------------

        gesturesView = (GestureOverlayView) findViewById(R.id.gestures);
        gesturesView.addOnGesturePerformedListener(listener);
        // gesturesView.setGestureStrokeWidth(gestureStrokeWidth)

        gesturesView2 = (GestureOverlayView) findViewById(R.id.gestures2);
        gesturesView2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (gesturesView2.getVisibility() == View.VISIBLE) {
                    gesturesView2.setVisibility(View.GONE);
                    // webView.setClickable(true);
                    Animation animation = AnimationUtils.loadAnimation(
                            DetailingPageV2.this, R.anim.top_to_bottom);
                    animation.setAnimationListener(new AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // TODO Auto-generated method stub
                            mylinear.setVisibility(View.GONE);
                            myscroll2.setVisibility(View.GONE);
                        }
                    });
                    mylinear.startAnimation(animation);
                }
            }
        });

        getActionBar().setTitle("");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("indexType")) {
                indexType = extras.getInt("indexType");
            }
        }

        webView = (WebView) findViewById(R.id.webView1);
        webView.addJavascriptInterface(this, "javaObj");
        webView.addJavascriptInterface(this, "cpjs");
        webView.setWebViewClient(new WebViewClient());

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
        screenheight = height;
        screenwidth = width;
        rcpawidth = width / 2;
        lpsp = (ImageView) findViewById(R.id.playsplp);
        lpsp.setTag("1");
        lpsp.setOnClickListener(this);
        open = (Button) findViewById(R.id.handle);
        open.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // if (gesturesView.getVisibility() == View.GONE) {
                //
                // webView.setEnabled(false);
                //
                // gesturesView.setVisibility(View.GONE);
                //
                // } else {
                // webView.setEnabled(true);
                // // colorPickerDialog.show();
                // // dialog.show();
                // // gesturesView.setVisibility(View.VISIBLE);
                // gesturesView.setAnimation(null);
                //
                // }
                if (mylinear.getVisibility() == View.GONE) {
                    gesturesView2.setVisibility(View.VISIBLE);
                    open.setVisibility(View.INVISIBLE);
                    // webView.setClickable(false);
                    mylinear.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(
                            DetailingPageV2.this, R.anim.bottom_to_top);
                    animation.setAnimationListener(new AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // TODO Auto-generated method stub
                            open.setBackgroundResource(R.drawable.navigated);
                            open.setVisibility(View.VISIBLE);
                        }
                    });
                    mylinear.startAnimation(animation);
                    annot2.setVisibility(View.GONE);
                } else {
                    gesturesView2.setVisibility(View.GONE);
                    open.setVisibility(View.INVISIBLE);
                    // webView.setClickable(true);
                    Animation animation = AnimationUtils.loadAnimation(
                            DetailingPageV2.this, R.anim.top_to_bottom);
                    animation.setAnimationListener(new AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // TODO Auto-generated method stub
                            open.setBackgroundResource(R.drawable.navigateu);
                            open.setVisibility(View.VISIBLE);
                            mylinear.setVisibility(View.GONE);
                            myscroll2.setVisibility(View.GONE);
                        }
                    });
                    mylinear.startAnimation(animation);

                }
            }
        });

        Reporting.setOnClickListener(this);
        displayFocussedBrands(0);
        View thumbview1 = (View) findViewById(R.id.thumbviewbottom1);
        img1 = (ImageView) thumbview1.findViewById(R.id.cficx1);
        textv = (TextView) thumbview1.findViewById(R.id.threedot);
        View thumbview2 = (View) findViewById(R.id.thumbviewbottom2);
        img2 = (ImageView) thumbview2.findViewById(R.id.cficx1);
        textv2 = (TextView) thumbview2.findViewById(R.id.threedot);

        View thumbview3 = (View) findViewById(R.id.thumbviewbottom3);
        img3 = (ImageView) thumbview3.findViewById(R.id.cficx1);

        View thumbview4 = (View) findViewById(R.id.thumbviewbottom4);
        img4 = (ImageView) thumbview4.findViewById(R.id.cficx1);
        View thumbview5 = (View) findViewById(R.id.thumbviewbottom5);
        img5 = (ImageView) thumbview5.findViewById(R.id.cficx1);
        View thumbview6 = (View) findViewById(R.id.thumbviewbottom6);
        img6 = (ImageView) thumbview6.findViewById(R.id.cficx1);
        View thumbview7 = (View) findViewById(R.id.thumbviewbottom7);
        img7 = (ImageView) thumbview7.findViewById(R.id.cficx1);
        View thumbview8 = (View) findViewById(R.id.thumbviewbottom8);
        img8 = (ImageView) thumbview8.findViewById(R.id.cficx1);
        View thumbview9 = (View) findViewById(R.id.thumbviewbottom9);
        img9 = (ImageView) thumbview9.findViewById(R.id.cficx1);
        View thumbview10 = (View) findViewById(R.id.thumbviewbottom10);
        img10 = (ImageView) thumbview10.findViewById(R.id.cficx1);
        img1.setOnClickListener(clickListener);
        img2.setOnClickListener(clickListener);
        img3.setOnClickListener(clickListener);
        img4.setOnClickListener(clickListener);
        img5.setOnClickListener(clickListener);
        img6.setOnClickListener(clickListener);
        img7.setOnClickListener(clickListener);
        img8.setOnClickListener(clickListener);
        img9.setOnClickListener(clickListener);
        img10.setOnClickListener(clickListener);

        View thumbview11 = (View) findViewById(R.id.thumbviewbottom11);
        img11 = (ImageView) thumbview11.findViewById(R.id.cficx1);
        View thumbview21 = (View) findViewById(R.id.thumbviewbottom21);
        img21 = (ImageView) thumbview21.findViewById(R.id.cficx1);
        View thumbview31 = (View) findViewById(R.id.thumbviewbottom31);
        img31 = (ImageView) thumbview31.findViewById(R.id.cficx1);
        View thumbview41 = (View) findViewById(R.id.thumbviewbottom41);
        img41 = (ImageView) thumbview41.findViewById(R.id.cficx1);

        img11.setOnClickListener(newListener);
        img21.setOnClickListener(newListener);
        img31.setOnClickListener(newListener);
        img41.setOnClickListener(newListener);
        seek = (SeekBar) findViewById(R.id.seek);
        colorw = (ImageView) findViewById(R.id.colorw);
        colorw.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog(
                        DetailingPageV2.this, Color.parseColor("#00ff09"),
                        new OnColorSelectedListener() {

                            @Override
                            public void onColorSelected(int color) {
                                gesturesView.setGestureColor(color);
                            }

                        });
                colorPickerDialog.show();
            }
        });
        seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                gesturesView.setGestureStrokeWidth(progress);
            }
        });

    }

    OnClickListener newListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            loadTropin();
        }
    };

    OnClickListener clickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            if (v == img2) {
                textv2.setText(DetailingPageV2.this.getResources().getString(
                        R.string.icon_tick));
                textv2.setTypeface(font);
                textv2.setTextSize(24);
                textv2.setVisibility(View.VISIBLE);
                textv2.setBackgroundColor(Color.parseColor("#67E0ED"));
                textv.setVisibility(View.GONE);
                textv2.setVisibility(View.VISIBLE);
                myscroll2.setVisibility(View.VISIBLE);
                myscroll2.startAnimation(AnimationUtils.loadAnimation(
                        DetailingPageV2.this, R.anim.bottom_to_top));

            } else {
                // view.setBackgroundResource(R.drawable.border_bg2);
                textv.setVisibility(View.VISIBLE);
                textv2.setVisibility(View.GONE);
                textv.setText(DetailingPageV2.this.getResources().getString(
                        R.string.icon_tick));
                textv.setTypeface(font);
                textv.setTextSize(24);
                textv.setVisibility(View.VISIBLE);
                textv.setBackgroundColor(Color.parseColor("#67E0ED"));

                myscroll2.setVisibility(View.VISIBLE);
                myscroll2.startAnimation(AnimationUtils.loadAnimation(
                        DetailingPageV2.this, R.anim.bottom_to_top));
            }

        }
    };

    public void displayFocussedBrands(int id) {
        if (id < 19) {
            String fd = "";
            pageData = rw.getTableData("DVC", 9, " WHERE COL8 = 'F' ",
                    "Order by CAST(COL9 as integer)");
            fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
            webView.getSettings().setPluginState(PluginState.ON);
            webView.getSettings().setJavaScriptEnabled(true);

            webView.getSettings().setAllowFileAccess(true);
            webView.setWebViewClient(new WebViewClient());

            url = "file:///android_asset/" + fd + "/" + pageData[id][1];

            // startTime = System.currentTimeMillis();
            webView = (WebView) findViewById(R.id.webView1);
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(url);
                }
            });
            // contentCode = pageData[index][0];
            // brandCode = pageData[index][6];
            // tempContentCode = contentCode;
        } else {
            webView = (WebView) findViewById(R.id.webView1);


            alo = 33;
            webView.post(new Runnable() {
                @Override
                public void run() {

                    url = "file:///android_asset/" + "THANK" + "/"
                            + "thank.htm";
                    webView.loadUrl(url);

                }
            });
        }
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        if (flag == true) {
            finish();
        }

        super.onResume();
    }

    private File copyFileToExternal(String fileName) {
        File file = null;
        String newPath = getExternalFilesDir(null).getAbsolutePath()
                + "cwep000temp/";
        try {
            File f = new File(newPath);
            f.mkdirs();
            FileInputStream fin = openFileInput(fileName);
            // File outputFile = new File(file, selectedVideo);
            FileOutputStream fos = new FileOutputStream(newPath + fileName);
            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = fin.read(buffer)) != -1) {
                fos.write(buffer, 0, len1);
            }
            fin.close();
            fos.close();
            file = new File(newPath + fileName);
            if (file.exists())
                return file;
        } catch (Exception e) {

        }
        return null;
    }

    private void deletePdfFiles(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deletePdfFiles(child);
        fileOrDirectory.delete();
    }

    private void checkIfContentsAvailable() {
    }

    @android.webkit.JavascriptInterface
    public void playNextFocussedBrand() {
        index++;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                displayFocussedBrands(0);
            }
        });
    }

    int id = 0;
    private int gestureclick = 2;
    private Window window2;
    private static Dialog d;

    @Override
    public void onClick(View v) {

        int id = v.getId();
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
                    focusedView
                            .setText(focusedView
                                    .getText()
                                    .toString()
                                    .substring(
                                            0,
                                            focusedView.getText().toString()
                                                    .length() - 1));
                }
            }
        }

        switch (id) {

            case R.id.feedback:
                if (feedback.getTag().equals("2")) {
                    feedback.setImageResource(R.drawable.feedback);
                    feedback.setTag("1");
                } else {
                    feedback.setImageResource(R.drawable.feedbackglow);
                    feedback.setTag("2");
                    final Dialog dialog_box = new Dialog(DetailingPageV2.this);
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.feed_dialog);
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    dialog_box.getWindow().setLayout(400, 500);
                    dialog_box.getWindow().clearFlags(
                            WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                    dialog_box.show();
                    TextView close = (TextView) dialog_box.findViewById(R.id.cross);
                    close.setTypeface(font);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });
                    Button done = (Button) dialog_box.findViewById(R.id.save);
                    done.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });

                }

                break;

            case R.id.anot:

                if (gestureclick == 1) {
                    notes1.setImageResource(R.drawable.annoticon);
                    if (gesturesView.getVisibility() == View.VISIBLE) {
                        gesturesView.cancelClearAnimation();
                        gesturesView.clear(true);
                        gesturesView.setVisibility(View.GONE);
                    }
                    annot2.setVisibility(View.GONE);
                    seek.setVisibility(View.GONE);
                    colorw.setVisibility(View.GONE);
                    gestureclick = 0;
                } else {
                    gesturesView.setGestureColor(Color.parseColor("#00ff09"));
                    notes1.setImageResource(R.drawable.annotateicon1glow);
                    annot2.setVisibility(View.VISIBLE);
                    gesturesView.setVisibility(View.VISIBLE);
                    colorw.setVisibility(View.VISIBLE);
                    seek.setVisibility(View.VISIBLE);
                    gestureclick = 1;

                }
                break;
            case R.id.play:
                if (play.getTag().equals("2")) {
                    play.setImageResource(R.drawable.backtoplaylist);
                    play.setTag("1");
                } else {
                    play.setImageResource(R.drawable.backtoplaylistglow);
                    play.setTag("2");
                }
                break;

            case R.id.email1:
                if (email1.getTag().equals("2")) {
                    email1.setImageResource(R.drawable.emailicon);
                    email1.setTag("1");
                } else {
                    email1.setImageResource(R.drawable.emailiconglow);
                    email1.setTag("2");
                }
                break;
            case R.id.annot2:
                takeScreenshot();
                notes1.setImageResource(R.drawable.annoticon);
                if (gesturesView.getVisibility() == View.VISIBLE) {
                    gesturesView.cancelClearAnimation();
                    gesturesView.clear(true);
                    gesturesView.setVisibility(View.GONE);
                    seek.setVisibility(View.GONE);
                    colorw.setVisibility(View.GONE);
                }
                annot2.setVisibility(View.GONE);
                gestureclick = 0;
                break;

            case R.id.playsplp:
                if (lpsp.getTag().equals("1")) {
                    lpsp.setImageResource(R.drawable.sp);
                    lpsp.setTag("2");
                } else {
                    lpsp.setImageResource(R.drawable.lp);
                    lpsp.setTag("1");
                }
                break;
            case R.id.searchicon:
                Intent intent1 = new Intent(this, ContentLIb.class);
                startActivity(intent1);
                break;

            case R.id.like1:
                if (like1.getTag().equals("2")) {
                    like1.setImageResource(R.drawable.likeicon);
                    like1.setTag("1");
                } else {
                    like1.setImageResource(R.drawable.likeiconglow);
                    dislike1.setImageResource(R.drawable.dislikeicon);
                    dislike1.setTag("1");
                    like1.setTag("2");
                }
                break;

            case R.id.dislike11:
                if (dislike1.getTag().equals("2")) {
                    dislike1.setImageResource(R.drawable.dislikeicon);
                    dislike1.setTag("1");
                } else {
                    dislike1.setImageResource(R.drawable.dislikeiconglow);
                    like1.setImageResource(R.drawable.likeicon);
                    like1.setTag("1");
                    dislike1.setTag("2");
                }
                break;

            case R.id.order:
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.orderdialog);
                View view1 = dialog.findViewById(R.id.keyboard);
                findViews(view1);
                linearLayout = (LinearLayout) dialog.findViewById(R.id.linearone);
                Button done1 = (Button) dialog.findViewById(R.id.save);
                TextView cross1 = (TextView) dialog.findViewById(R.id.cross);
                cross1.setTypeface(font);
                cross1.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                });
                done1.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                });

                Window window1 = dialog.getWindow();
                window1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                addbrandsData("C-FIX 50 DT", 1);
                addbrandsData("C-FIX 100 DT", 2);
                addbrandsData("C-FIX 200 DT", 3);
                addbrandsData("C-FIX DRY SYRUP", 4);
                addbrandsData("C-FIX 50 DT", 2);
                addbrandsData("C-FIX 100 DT", 2);
                addbrandsData("C-FIX 200 DT", 3);
                addbrandsData("C-FIX DRY SYRUP", 4);
                dialog.getWindow().setLayout(1150, 600);
                dialog.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                dialog.show();
                break;

            case R.id.sampl1:

                final Dialog dialogfed1 = new Dialog(this);
                dialogfed1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogfed1.setContentView(R.layout.samplingfordialog);
                View view = dialogfed1.findViewById(R.id.keyboard);
                findViews(view);
                linearLayout = (LinearLayout) dialogfed1
                        .findViewById(R.id.linearone);
                Button done = (Button) dialogfed1.findViewById(R.id.save);
                TextView cross = (TextView) dialogfed1.findViewById(R.id.cross);
                cross.setTypeface(font);
                cross.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialogfed1.dismiss();
                    }
                });
                done.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialogfed1.dismiss();
                    }
                });

                Window window = dialogfed1.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                addbrandsData("C-FIX 50 DT", 1);
                addbrandsData("C-FIX 100 DT", 2);
                addbrandsData("C-FIX 200 DT", 3);
                addbrandsData("C-FIX DRY SYRUP", 4);
                addbrandsData("C-FIX 50 DT", 2);
                addbrandsData("C-FIX 100 DT", 2);
                addbrandsData("C-FIX 200 DT", 3);
                addbrandsData("C-FIX DRY SYRUP", 4);
                dialogfed1.getWindow().setLayout(1150, 600);
                dialogfed1.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialogfed1.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                dialogfed1.show();

                break;

            default:
                break;
        }

        if (v instanceof ImageView) {
            if (v == upbutton) {
                // Toast.makeText(DetailingPageV2.this, "upperbutton called",
                // Toast.LENGTH_SHORT).show();

            } else if (v == downbutton) {
                //
                // Toast.makeText(DetailingPageV2.this, "downbutton called",
                // Toast.LENGTH_SHORT).show();

            } else if (v == refrence) {
                d = new Dialog(this);
                int[] imageId1 = {R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher};

                d.requestWindowFeature(Window.FEATURE_NO_TITLE);

                d.setContentView(R.layout.listnil);

                d.setTitle("Notification");
                ListView lv = (ListView) d.findViewById(R.id.listView);
                Custom_grid adaptor = new Custom_grid(DetailingPageV2.this,
                        imageId1);

                lv.setAdapter(adaptor);
                lv.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        // TODO Auto-generated method stub
                        if (position == 3) {
                            CopyReadAssets();

                        } else if (position == 4) {
                            CopyReadAssetsVid();
                            Intent intent = new Intent(DetailingPageV2.this,
                                    VideoPlay.class);
                            intent.putExtra("fileName", "Liopril.mp4");
                            startActivityForResult(intent, 6004);

                        } else {
                            loadTropin();
                        }
                        d.dismiss();
                    }
                });

                Window window = d.getWindow();

                WindowManager.LayoutParams wmlp = d.getWindow().getAttributes();

                wmlp.gravity = Gravity.TOP | Gravity.RIGHT;
                wmlp.x = 60; // x position
                wmlp.y = 20;
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                d.getWindow().setLayout(210, 450);
                d.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                d.show();

            } else if (v == Reporting) {
                if (index1.equals("2")) {
                    Intent intReporting = new Intent(DetailingPageV2.this,
                            DetailingLandingPage.class);
                    intReporting.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intReporting);

                } else {
                    dialog = new Dialog(DetailingPageV2.this);
                    dialog.getWindow();
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.add_doc);
                    dialog.getWindow().setBackgroundDrawable(
                            new ColorDrawable(
                                    android.graphics.Color.TRANSPARENT));
                    Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                            .getDefaultDisplay();
                    // dialog.setCancelable(false);
                    int width = display.getWidth();
                    int height = display.getHeight();
                    dialog.getWindow().setLayout((29 * width) / 30,
                            (height * 9) / 10);
                    LinearLayout first = (LinearLayout) dialog
                            .findViewById(R.id.first);
                    first.addView(getView());
                    LinearLayout second = (LinearLayout) dialog
                            .findViewById(R.id.second);
                    second.addView(getView2());
                    TextView close = (TextView) dialog
                            .findViewById(R.id.crossvb);
                    close.setTypeface(font);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog.dismiss();

                            backCount++;
                            mylinear.setVisibility(View.GONE);
                            myscroll2.setVisibility(View.GONE);
                            if (gesturesView2.getVisibility() == View.VISIBLE)
                                gesturesView2.setVisibility(View.GONE);
                            webView.getSettings()
                                    .setPluginState(PluginState.ON);
                            webView.getSettings().setJavaScriptEnabled(true);
                            // webView.getSettings().setPluginsEnabled(true);
                            webView.getSettings().setAllowFileAccess(true);

                            url = "file:///android_asset/" + "THANK" + "/"
                                    + "thank.htm";
                            name.setVisibility(View.VISIBLE);
                            refrence.setVisibility(View.GONE);
                            open.setVisibility(View.GONE);
                            name.setPadding(0, 120, 0, 0);
                            webView.post(new Runnable() {
                                @Override
                                public void run() {
                                    webView.loadUrl(url);

                                }
                            });

                        }
                    });
                    TextView add_unlisted = (TextView) dialog
                            .findViewById(R.id.add_unlisted);
                    final TextView v1 = (TextView) dialog.findViewById(R.id.v1);
                    final LinearLayout v2 = (LinearLayout) dialog
                            .findViewById(R.id.v2);
                    final TextView v3 = (TextView) dialog.findViewById(R.id.v3);
                    final LinearLayout v4 = (LinearLayout) dialog
                            .findViewById(R.id.v4);
                    final View v5 = (View) dialog.findViewById(R.id.v5);
                    add_unlisted.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            v1.setVisibility(View.VISIBLE);
                            v2.setVisibility(View.VISIBLE);
                            v3.setVisibility(View.VISIBLE);
                            v4.setVisibility(View.VISIBLE);
                            v5.setVisibility(View.VISIBLE);

                        }
                    });
                    edit1 = (EditText) dialog.findViewById(R.id.edit1);
                    edit2 = (EditText) dialog.findViewById(R.id.edit1);

                    ImageView move1 = (ImageView) dialog
                            .findViewById(R.id.move1);
                    ImageView move2 = (ImageView) dialog
                            .findViewById(R.id.move2);
                    move1.setTag("1");
                    move2.setTag("2");
                    move1.setOnClickListener(listen);
                    move2.setOnClickListener(listen);

                    dialog.show();
                }
            }

        } else if (v instanceof EditText) {
        } else if (v instanceof Button) {
            if (v == nextCnt) {

                displayNextPage(0);

            } else if (v == prevCnt) {

                displayPreviousPage();

            } else if (v == note11) {
                // Toast.makeText(DetailingPageV2.this, "Clikkeddddd",
                // Toast.LENGTH_SHORT).show();
                //
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog(
                        this, Color.WHITE, new OnColorSelectedListener() {

                    @Override
                    public void onColorSelected(int color) {
                        // do action

                        gesturesView.setGestureColor(Color.WHITE);
                    }

                });
                if (gesturesView.getVisibility() == View.VISIBLE) {

                    gesturesView.cancelClearAnimation();
                    gesturesView.clear(true);

                    gesturesView.setVisibility(View.GONE);

                } else {

                    // colorPickerDialog.show();
                    // dialog.show();
                    gesturesView.setVisibility(View.VISIBLE);

                }

            } else if (v == like11) {

                // Toast.makeText(DetailingPageV2.this, "caledddddddd",
                // Toast.LENGTH_SHORT).show();
                //
                // Intent intmap = new Intent(DetailingPageV2.this,
                // UserRouteActivity.class);
                // startActivity(intmap);
            }

        } else if (v instanceof TextView) {

            // if (v == ButtonSearch) {
            //
            // // Toast.makeText(DetailingPageV2.this, "search called...",
            // // Toast.LENGTH_SHORT).show();
            //
            // viewsearch.setVisibility(View.VISIBLE);
            // viewproduct.setVisibility(View.GONE);
            //
            // }
            //
            // else if (v == ButtonProduct) {
            // // Toast.makeText(DetailingPageV2.this, "Product called...",
            // // Toast.LENGTH_SHORT).show();
            //
            // viewproduct.setVisibility(View.VISIBLE);
            // viewsearch.setVisibility(View.GONE);
            //
            // }

        }
        Animation animation = AnimationUtils.loadAnimation(
                DetailingPageV2.this, R.anim.top_to_bottom);
        open.setVisibility(View.INVISIBLE);
        animation.setStartOffset(500);
        animation.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                open.setBackgroundResource(R.drawable.navigateu);
                open.setVisibility(View.VISIBLE);
                mylinear.setVisibility(View.GONE);
                myscroll2.setVisibility(View.GONE);
                if (gesturesView2.getVisibility() == View.VISIBLE)
                    gesturesView2.setVisibility(View.GONE);
            }
        });
        mylinear.startAnimation(animation);

    }

    OnClickListener nextListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            name.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            open.setVisibility(View.VISIBLE);
            refrence.setVisibility(View.VISIBLE);
            displayFocussedBrands(1);
            // LoadThankYouPage();
        }
    };
    OnClickListener nextNPrevListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            int id = v.getId();
            count++;
            displayFocussedBrands(count);

        }
    };

    private void addbrandsData(String text, int index) {
        // TODO Auto-generated method stub
        final LinearLayout linear = new LinearLayout(DetailingPageV2.this);
        if (index == 1)
            linear.setBackgroundResource(R.drawable.roundforsampling);
        linear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    View view = linearLayout.getChildAt(i);
                    if (view == v) {
                        linearLayout.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforsampling);
                        linear.getChildAt(1).requestFocus();
                    } else {
                        linearLayout.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforlayout);
                    }
                }
            }
        });

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        param.setMargins(0, 10, 0, 10);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setLayoutParams(param);

        TextView tv = new TextView(DetailingPageV2.this);
        tv.setText(text);
        tv.setBackgroundResource(R.drawable.round_white3);
        tv.setTextSize(18);
        tv.setPadding(0, 5, 0, 0);

        LinearLayout.LayoutParams textparam = new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 5);
        tv.setLayoutParams(textparam);
        textparam.rightMargin = 5;
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        // ---------------------------------------------------------------------------------------
        LinearLayout.LayoutParams paramedit = new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 2);

        EditText ed1 = new EditText(DetailingPageV2.this);
        ed1.setBackgroundResource(R.drawable.round_white3);
        ed1.setEms(3);
        ed1.setPadding(0, 5, 0, 0);
        ed1.setTextSize(18);
        ed1.setHint("0");
        ed1.setLayoutParams(paramedit);
        InputFilter[] filter = new InputFilter[1];
        filter[0] = new InputFilter.LengthFilter(2);
        ed1.setFilters(filter);
        ed1.setGravity(Gravity.CENTER_HORIZONTAL);
        ed1.setInputType(InputType.TYPE_NULL);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            ed1.setRawInputType(InputType.TYPE_CLASS_NUMBER);
            ed1.setTextIsSelectable(true);
        }
        ed1.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (hasFocus) {
                    focusedView = (EditText) v;
                } else {
                    focusedView = null;
                }
                View parentView = (View) v.getParent();
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    View view = linearLayout.getChildAt(i);
                    if (view == parentView) {
                        linearLayout.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforsampling);
                    } else {
                        linearLayout.getChildAt(i).setBackgroundResource(
                                R.drawable.roundforlayout);
                    }
                }

            }
        });

        linear.addView(tv);
        linear.addView(ed1);
        linearLayout.addView(linear);
    }

    private void displayNextPage(int page) {

        // TODO Auto-generated method stub
        if (page != 1) {
            if (id + 1 == pageData.length) {
            } else {
                id++;
            }
        }
        String fd = "";

        webView.cancelLongPress();

        webView.setVisibility(View.VISIBLE);
        try {
            if (page == 1) {
                fd = menutext.toUpperCase();
            } else {
                fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
            }
            if (page == 1) {
                url = "file:///android_asset/" + fd + "/" + menutext + ".htm";
            } else {
                url = "file:///android_asset/" + fd + "/" + pageData[id][1];
            }
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(url);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void displayPreviousPage() {
        // TODO Auto-generated method stub

        File file = null;
        String fd = "";

        if (id <= 0) {

        } else {
            id--;
        }

        webView = (WebView) findViewById(R.id.webView1);
        webView.cancelLongPress();

        webView.setVisibility(View.VISIBLE);
        try {

            fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
            // file = new File(this.getFilesDir().getAbsolutePath() + "/" + fd
            // + "/" + pageData[id][1]);
            // }
            // if (file.exists()) {
            webView.getSettings().setPluginState(PluginState.ON);
            webView.getSettings().setJavaScriptEnabled(true);
            // webView.getSettings().setPluginsEnabled(true);
            webView.getSettings().setAllowFileAccess(true);

            url = "file:///android_asset/" + fd + "/" + pageData[id][1];

            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(url);

                }
            });

            // id--;
            // }

        } catch (Exception e) {
            e.printStackTrace();
            // Utility.displayToast(this, "error is playing file");
        }

    }

    private void CopyReadAssets() {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "abc.pdf");
        try {
            in = assetManager.open("abc.pdf");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/abc.pdf"),
                "application/pdf");

        startActivity(intent);
    }

    private void CopyReadAssetsVid() {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "Liopril.mp4");
        try {
            in = assetManager.open("Liopril.mp4");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @android.webkit.JavascriptInterface
    public void sendToAndroid(String text) {
        // this is called from JS with passed value
        // Utility.displayToast(DetailingPageV2.this, text);
        // scr.setVisibility(View.GONE);

        menutext = text;

        for (int i = 0; i < pageData.length; i++) {
            if (pageData[i][1].equalsIgnoreCase(menutext + ".htm")) {
                id = i;
                break;
            }
        }
        displayNextPage(1);

    }

    OnGesturePerformedListener listener = new OnGesturePerformedListener() {
        @Override
        public void onGesturePerformed(GestureOverlayView overlay,
                                       Gesture gesture) {

        }

    };

    @Override
    public void onBackPressed() {

        if (alo != 33) {


            if (backCount == 0 && webView.getVisibility() == View.VISIBLE) {
                backCount++;
                mylinear.setVisibility(View.GONE);
                myscroll2.setVisibility(View.GONE);
                if (gesturesView2.getVisibility() == View.VISIBLE)
                    gesturesView2.setVisibility(View.GONE);
                webView.getSettings().setPluginState(PluginState.ON);
                webView.getSettings().setJavaScriptEnabled(true);
                // webView.getSettings().setPluginsEnabled(true);
                webView.getSettings().setAllowFileAccess(true);

                url = "file:///android_asset/" + "THANK" + "/" + "thank.htm";
                name.setVisibility(View.VISIBLE);
                refrence.setVisibility(View.GONE);
                open.setVisibility(View.GONE);
                name.setPadding(0, 120, 0, 0);
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadUrl(url);

                    }
                });
            } else {
                backCount++;
            }
            if (backCount == 5) {
                super.onBackPressed();
                finish();
            }

        } else if (alo == 33) {

            dialog = new Dialog(DetailingPageV2.this);
            dialog.getWindow();
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.add_doc);
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(
                            android.graphics.Color.TRANSPARENT));
            Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                    .getDefaultDisplay();
            // dialog.setCancelable(false);
            int width = display.getWidth();
            int height = display.getHeight();
            dialog.getWindow().setLayout((29 * width) / 30,
                    (height * 9) / 10);
            LinearLayout first = (LinearLayout) dialog
                    .findViewById(R.id.first);
            first.addView(getView());
            LinearLayout second = (LinearLayout) dialog
                    .findViewById(R.id.second);
            second.addView(getView2());
            TextView close = (TextView) dialog
                    .findViewById(R.id.crossvb);
            close.setTypeface(font);
            close.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();

                    backCount++;
                    mylinear.setVisibility(View.GONE);
                    myscroll2.setVisibility(View.GONE);
                    if (gesturesView2.getVisibility() == View.VISIBLE)
                        gesturesView2.setVisibility(View.GONE);
                    webView.getSettings()
                            .setPluginState(PluginState.ON);
                    webView.getSettings().setJavaScriptEnabled(true);
                    // webView.getSettings().setPluginsEnabled(true);
                    webView.getSettings().setAllowFileAccess(true);

                    url = "file:///android_asset/" + "THANK" + "/"
                            + "thank.htm";
                    name.setVisibility(View.VISIBLE);
                    refrence.setVisibility(View.GONE);
                    open.setVisibility(View.GONE);
                    name.setPadding(0, 120, 0, 0);
                    webView.post(new Runnable() {
                        @Override
                        public void run() {
                            webView.loadUrl(url);

                        }
                    });

                }
            });
            TextView add_unlisted = (TextView) dialog
                    .findViewById(R.id.add_unlisted);
            final TextView v1 = (TextView) dialog.findViewById(R.id.v1);
            final LinearLayout v2 = (LinearLayout) dialog
                    .findViewById(R.id.v2);
            final TextView v3 = (TextView) dialog.findViewById(R.id.v3);
            final LinearLayout v4 = (LinearLayout) dialog
                    .findViewById(R.id.v4);
            final View v5 = (View) dialog.findViewById(R.id.v5);
            add_unlisted.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    v1.setVisibility(View.VISIBLE);
                    v2.setVisibility(View.VISIBLE);
                    v3.setVisibility(View.VISIBLE);
                    v4.setVisibility(View.VISIBLE);
                    v5.setVisibility(View.VISIBLE);

                }
            });
            edit1 = (EditText) dialog.findViewById(R.id.edit1);
            edit2 = (EditText) dialog.findViewById(R.id.edit1);

            ImageView move1 = (ImageView) dialog
                    .findViewById(R.id.move1);
            ImageView move2 = (ImageView) dialog
                    .findViewById(R.id.move2);
            move1.setTag("1");
            move2.setTag("2");
            move1.setOnClickListener(listen);
            move2.setOnClickListener(listen);
            alo = 94;
            dialog.show();
        } else if (alo == 94) {
            finish();
        }
    }

    // /vbvhn

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"C-FIX", "Hairgain", "Envir",
                "Haprin Sodium Injection", "Rozart Tablet", "Oxygen Tab",
                "Avessa", "Genotropin"};

        String country_names[] = {"Intence Bacetricidal Action",
                "Cefixime power", "Indications", "Geography distrubution",
                "Loren ipsum dolor sit amet dolor ipsum",
                "Avessa Safrty guidelines",
                "Avessa Varient briefing and assessing need",
                "New Varient introduction", "Geography distrubution",
                "Geography distrubution", "Avessa Safrty guidelines",
                "Loren ipsum dolor sit amet dolor ipsum",
                "Avessa Safrty guidelines", "New Varient introduction",
                "Avessa Safrty guidelines", "Geography distrubution",
                "Geography distrubution", "New Varient introduction",
                "New Varient introduction", "Avessa Safrty guidelines",
                "Geography distrubution", "Nigeria", "Bosnia and Herzegovina",
                "Avessa Safrty guidelines", "Geography distrubution",
                "Geography distrubution", "New Varient introduction",
                "Geography distrubution", "Avessa Safrty guidelines",
                "Geography distrubution", "Geography distrubution",
                "New Varient introduction"};

        int Images[] = {R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher};

        String number[] = {"1.1", "1.2", "1.3", "1.4", "2.1", "2.2", "2.3",
                "2.4", "3.1", "3.2", "3.3", "3.4", "4.1", "4.2", "4.3", "4.4",
                "5.1", "5.2", "5.3", "5.4", "6.1", "6.2", "6.3", "6.4", "7.1",
                "7.2", "7.3", "7.4", "8.1", "8.2", "8.3", "8.4"};

        String group_names12[] = {"1.0", "2.0", "3.0", "4.0", "5.0", "6.0",
                "7.0", "8.0"};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 4;
        int j = 0;

        for (int i = 0; i < group_names.length; i++)

        {
            Group gru = new Group();
            gru.setName(group_names[i]);
            gru.setName1(group_names12[i]);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch.setImage(Images[j]);
                ch.setName1(number[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 4;
        }

        return list;
    }

    public static void disMiss() {
        d.dismiss();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // TODO Auto-generated method stub
        return super.dispatchKeyEvent(event);
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2015-09-10 20:58:30 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
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

        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);

        zero.setOnClickListener(this);
        ente.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2015-09-10 20:58:30 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    // @Override
    // public void onClick(View v) {

    // }
    void loadTropin() {
        nextBrand.setVisibility(View.GONE);
        mylinear.setVisibility(View.GONE);
        myscroll2.setVisibility(View.GONE);
        if (gesturesView2.getVisibility() == View.VISIBLE)
            gesturesView2.setVisibility(View.GONE);
        webView.getSettings().setPluginState(PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        // webView.getSettings().setPluginsEnabled(true);
        webView.getSettings().setAllowFileAccess(true);

        url = "file:///android_asset/" + "TROPIN" + "/" + "tropin.htm";

        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(url);

            }
        });
    }

    public LinearLayout getView() {
        dataList = new ArrayList<String[]>();

        String[] Specialty = {"Nuclear cardiology",
                "Cardiac electrophysiology", "Urologic oncology",
                "Urologic oncology", "Neuromuscular Medicine",
                "Nuclear cardiology", "Cardiac electrophysiology",
                "Urologic oncology", "Urologic oncology",
                "Neuromuscular Medicine", "Nuclear cardiology",
                "Cardiac electrophysiology", "Urologic oncology",
                "Urologic oncology", "Neuromuscular Medicine"};
        String[] Class = {"Class B", "Class A", "Class C", "Class C",
                "Class B", "Class B", "Class A", "Class C", "Class C",
                "Class B", "Class B", "Class A", "Class C", "Class C",
                "Class B"};

        String[] Drname = {"Mason Lopes", "Michael Jeremy", "Mike Gomez",
                "Michelle Cardoza", "Mabel D'costa", "Macaria D'souza",
                "Macra Dmello", "Macrina Colaco", "Madeleine Miles",
                "Madonna Pears", "Magda Mclachlan", "Magdalene Donavan",
                "Margaret Ricardo", "Maria Gonsalvez", "Macance Piers"};
        LinearLayout parent = new LinearLayout(DetailingPageV2.this);
        parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        parent.setPadding(10, 0, 10, 0);

        parent.setOrientation(LinearLayout.VERTICAL);
        EditText editText = new EditText(DetailingPageV2.this);
        editText.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                R.drawable.ic_action_search, 0);
        editText.setBackgroundResource(R.drawable.bg_roundedgray);
        editText.setHint("Physician Name/Patch");
        editText.addTextChangedListener(new TextWatcher() {

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
        });

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);
        editText.setPadding(20, 4, 0, 4);
        editText.setLayoutParams(params);

        for (int i = 0; i < Drname.length; i++) {
            String[] str = {Drname[i], Specialty[i], Class[i]};
            dataList.add(str);
        }

        lv = new ListView(DetailingPageV2.this);
        lv.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
        int[] colors = {0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF};
        lv.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
        lv.setDividerHeight(1);
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                lv.setEnabled(false);
                LinearLayout grandpa = (LinearLayout) lv.getChildAt(position);
                LinearLayout parentpa = (LinearLayout) grandpa.getChildAt(0);
                TextView child = (TextView) parentpa.getChildAt(2);
                child.setTextColor(Color.WHITE);
                dataList2.add(dataList.get(position));
                dataList.remove(position);

                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                adapter = new CustomAdapter(
                                        DetailingPageV2.this, dataList, 1);
                                lv.setAdapter(adapter);
                                adapter.notifyDataSetChanged();

                                adapter2 = new CustomAdapter(
                                        DetailingPageV2.this, dataList2, 2);
                                lv2.setAdapter(adapter2);
                                adapter2.notifyDataSetChanged();
                                button.setVisibility(View.VISIBLE);
                                lv.setEnabled(true);
                            }
                        });
                    }
                });

            }
        });
        adapter = new CustomAdapter(DetailingPageV2.this, dataList, 1);
        lv.setAdapter(adapter);
        parent.addView(editText);
        View view = new View(DetailingPageV2.this);
        view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 1));
        view.setBackgroundColor(Color.WHITE);
        parent.addView(view);
        parent.addView(lv);
        return parent;
    }

    public LinearLayout getView2() {
        dataList2 = new ArrayList<String[]>();

        LinearLayout parent = new LinearLayout(DetailingPageV2.this);
        parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        parent.setPadding(10, 0, 10, 0);

        parent.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);

        lv2 = new ListView(DetailingPageV2.this);
        lv2.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT, 500));
        int[] colors = {0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF};
        lv2.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
        lv2.setDividerHeight(1);
        lv2.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                lv2.setEnabled(false);
                dataList2.remove(position);
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                adapter2 = new CustomAdapter(
                                        DetailingPageV2.this, dataList2, 2);
                                lv2.setAdapter(adapter2);
                                adapter2.notifyDataSetChanged();
                                lv2.setEnabled(true);
                            }
                        });
                    }
                });
            }
        });
        adapter2 = new CustomAdapter(DetailingPageV2.this, dataList2, 2);
        lv2.setAdapter(adapter2);
        // lv2.setBackgroundColor(Color.GRAY);
        View view = new View(DetailingPageV2.this);
        view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 1));
        view.setBackgroundColor(Color.WHITE);
        parent.addView(view);
        parent.addView(lv2);

        button = new ImageView(this);
        button.setImageResource(R.drawable.done);
        button.setVisibility(View.INVISIBLE);
        LinearLayout.LayoutParams param = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        param.gravity = Gravity.END;
        button.setLayoutParams(param);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                backCount++;
                mylinear.setVisibility(View.GONE);
                myscroll2.setVisibility(View.GONE);
                if (gesturesView2.getVisibility() == View.VISIBLE)
                    gesturesView2.setVisibility(View.GONE);
                webView.getSettings().setPluginState(PluginState.ON);
                webView.getSettings().setJavaScriptEnabled(true);
                // webView.getSettings().setPluginsEnabled(true);
                webView.getSettings().setAllowFileAccess(true);

                url = "file:///android_asset/" + "THANK" + "/" + "thank.htm";
                name.setVisibility(View.VISIBLE);
                refrence.setVisibility(View.GONE);
                open.setVisibility(View.GONE);
                name.setPadding(0, 120, 0, 0);
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadUrl(url);

                    }
                });
            }
        });
        parent.addView(button);
        return parent;
    }

    OnClickListener listen = new OnClickListener() {

        @Override
        public void onClick(final View v) {
            // TODO Auto-generated method stub
            v.setEnabled(false);
            String str = "";
            if (v.getTag().equals("1")) {
                str = edit1.getText().toString();
                edit1.setText("");
            } else if (v.getTag().equals("2")) {
                str = edit2.getText().toString();
                edit2.setText("");
            }
            if (!str.equals("")) {
                String[] strData = {str, "Bronx", "Class A"};
                dataList2.add(strData);
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                adapter2 = new CustomAdapter(
                                        DetailingPageV2.this, dataList2, 2);
                                lv2.setAdapter(adapter2);
                                adapter2.notifyDataSetChanged();
                                v.setEnabled(true);
                            }
                        });
                    }
                });
            }
        }
    };

    private void takeScreenshot() {
        // Date now = new Date();
        // android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
        String now = "screenshot";
        try {
            // image naming and path to include sd card appending name you
            // choose for file
            String mPath = Environment.getExternalStorageDirectory().toString()
                    + "/" + now + ".png";

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.PNG, quality, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
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
