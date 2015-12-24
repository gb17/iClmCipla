package com.cirrius.iclmcipla;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;
import com.gb.siglelist.SingleListview;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EnhanceLandingPage extends Activity implements OnClickListener {
    CalendarView calendar;
    EditText datePicker = null;
    EditText timePicker = null;
    Typeface font;
    private ReadWriteData rw;

    private View thumbview1;
    private View thumbview2;
    private View thumbview3;
    private View thumbview4;
    private View thumbview5;
    private View thumbview6;
    private View thumbview7;
    private View thumbview8, thumbview9;

    private RelativeLayout relativeforpage;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Utility.setactoinbart(getActionBar(), this, font, "Detailing");
        setContentView(R.layout.enhance_landing_page);

        findViews();

        String date = Utility.getDateString();
        String[][] TBDED = {

                {date.substring(0, 10), "w", "", "B", "C", "D", "padmini", "576576"},
                {"", "q", "", "aa", "aa", "aa", "priya", "5765"},
                {"", "r", "", "aa", "aa", "aa", "priyanka", "576585"},

        };

        rw = new ReadWriteData(this, "MPOWERDB", null, 1);
        if (rw.TableExist("TBDED") == false) {
            rw.createTables();
            rw.insertGenericData2D("TBDED", TBDED);
        }
        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);

        SingleListview singleListview = new SingleListview(EnhanceLandingPage.this);

        rl1.addView(singleListview.getviewsSigleExpandalelistview(1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        tv = new TextView(this);

        tv.setOnClickListener(this);
        tv.setPadding(10, 5, 10, 5);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextSize(12);
        tv.setBackgroundResource(R.drawable.bg_circle);
        tv.setTextColor(Color.WHITE);
        tv.setText("Show all");
        tv.setId(1000);

        SearchView searchView = new SearchView(getActionBar()
                .getThemedContext());
        int searchIconId = searchView.getContext().getResources()
                .getIdentifier("android:id/search_button", null, null);
        ImageView searchIcon = (ImageView) searchView
                .findViewById(searchIconId);
        searchIcon.setImageResource(R.drawable.ic_action_search);
        searchView.setQueryHint("Enter Text");

        menu.add(Menu.NONE, 130, 1, "Search")
                .setIcon(R.drawable.ic_zoom_in_white_48dp)
                .setActionView(searchView)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add(Menu.NONE, 131, 1, "")
                .setIcon(R.drawable.ic_add_alert_white_24dp)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add(Menu.NONE, 132, 1, "").setIcon(R.drawable.lib)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 132:
                Intent intent1 = new Intent(EnhanceLandingPage.this,
                        ContentLIb.class);

                intent1.putExtra("type", "seg");

                startActivity(intent1);

                break;

            case 133:

                Dialog dialog_box;
                dialog_box = new Dialog(EnhanceLandingPage.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.menupopup);

                RelativeLayout layout = (RelativeLayout) dialog_box
                        .findViewById(R.id.relogout);
                layout.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EnhanceLandingPage.this,
                                Login.class);
                        startActivity(intent);

                    }
                });

                Window window = dialog_box.getWindow();

                WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                        .getAttributes();

                wmlp.gravity = Gravity.TOP | Gravity.RIGHT;

                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(400, 150);
                dialog_box.show();

                break;

            case 131:
                int[] imageId = {R.drawable.dr_image, R.drawable.graph_image,
                        R.drawable.dr_image2, R.drawable.dr_image3,
                        R.drawable.question_image, R.drawable.question_image,
                        R.drawable.question_image, R.drawable.question_image,
                        R.drawable.question_image};
                String[] data = {
                        "Dr.Katrin Florick",
                        "Your Dr Coverage is 98.57% as on 20th march",
                        "Dr.John carter viewed C_FIX LBL on 18th March 30sec",
                        "updated sale Report",
                        "Hairgain side  effect query have been answered by PMT on 19th March",
                        "CME is Planned for 26th March",
                        "Ramesh Kumar has not reported calls for the last 3 days",
                        "Assesments of team is pending since 2 weeks",
                        "Umesh Raje has applied for leave on 24th April "};

                String[] datanext = {"Tommorrow is her Birthday", "", "",
                        "From Kamal Raja ", "", "", "", "", ""};
                int[] imageId1 = {R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher};

                final Dialog d = new Dialog(this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);

                d.setContentView(R.layout.listnilfornoti);

                d.setTitle("Notification");
                ListView lv = (ListView) d.findViewById(R.id.listView);
                Custom_gridfornoti adapter = new Custom_gridfornoti(
                        EnhanceLandingPage.this, imageId, data, datanext,
                        imageId1);

                lv.setAdapter(adapter);
                Window window1 = d.getWindow();

                WindowManager.LayoutParams wmlp1 = d.getWindow().getAttributes();

                wmlp1.gravity = Gravity.TOP | Gravity.RIGHT;
                wmlp1.x = 40; // x position
                wmlp1.y = 40;

                window1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                d.getWindow().setLayout(370, 560);

                d.show();

                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void findViews() {

        thumbview1 = (View) findViewById(R.id.thumbview31);
        thumbview2 = (View) findViewById(R.id.thumbview32);
        thumbview3 = (View) findViewById(R.id.thumbview33);
        thumbview4 = (View) findViewById(R.id.thumbview34);
        thumbview5 = (View) findViewById(R.id.thumbview35);
        thumbview6 = (View) findViewById(R.id.thumbview36);
        thumbview7 = (View) findViewById(R.id.thumbview37);
        thumbview8 = (View) findViewById(R.id.thumbview38);
        thumbview9 = (View) findViewById(R.id.thumbview39);

        thumbview1.setOnClickListener(thumbviewClick);
        thumbview2.setOnClickListener(thumbviewClick);
        thumbview3.setOnClickListener(thumbviewClick);
        thumbview4.setOnClickListener(thumbviewClick);
        thumbview5.setOnClickListener(thumbviewClick);
        thumbview6.setOnClickListener(thumbviewClick);
        thumbview7.setOnClickListener(thumbviewClick);
        thumbview8.setOnClickListener(thumbviewClick);
        thumbview9.setOnClickListener(thumbviewClick);

    }

    OnClickListener thumbviewClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.thumbview31:
                    Intent intent1 = new Intent(EnhanceLandingPage.this, VideoPlay.class);
                    intent1.putExtra("fileName", "development");
                    startActivity(intent1);
                    break;
                case R.id.thumbview36:
                    Intent intent2 = new Intent(EnhanceLandingPage.this, VideoPlay.class);
                    intent2.putExtra("fileName", "inspire");
                    startActivity(intent2);
                    break;
                case R.id.thumbview38:
                    Intent intent3 = new Intent(EnhanceLandingPage.this, VideoPlay.class);
                    intent3.putExtra("fileName", "training");
                    startActivity(intent3);
                    break;
                case R.id.thumbview32:
                    CopyReadAssets("softskills.pptx", 1);
                    break;
                case R.id.thumbview33:
                    CopyReadAssets("skills.pdf", 0);
                    break;
                case R.id.thumbview34:
                    CopyReadAssets("info.pdf", 0);
                    break;
                case R.id.thumbview39:
                    CopyReadAssets("guidelines.ppt", 1);
                    break;
            }
        }
    };

    private void CopyReadAssets(String fileName, int index) {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), fileName);
        try {
            in = assetManager.open(fileName);
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
        if (index == 0)
            intent.setDataAndType(
                    Uri.parse("file://" + getFilesDir() + "/" + fileName),
                    "application/pdf");
        else
            intent.setDataAndType(
                    Uri.parse("file://" + getFilesDir() + "/" + fileName),
                    "application/vnd.ms-powerpoint");

        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 1000:
                Intent intent12 = new Intent(this, ContentLIb.class);
                intent12.putExtra("KT", "1");
                startActivity(intent12);
                break;

            default:
                Intent intent = new Intent(this, DetailingPageV2.class);
                intent.putExtra("KT", "1");
                startActivity(intent);
                break;
        }

    }

    OnClickListener listenMe = new OnClickListener() {

        private Dialog dialog_box;

        @Override
        public void onClick(View v) {

            dialog_box = new Dialog(EnhanceLandingPage.this);
            dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_box.setContentView(R.layout.doctorprofiledialogforbarnd);

            Window window = dialog_box.getWindow();

            WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                    .getAttributes();
            int[] viewLocation = new int[2];
            v.getLocationOnScreen(viewLocation);

            wmlp.gravity = Gravity.TOP | Gravity.LEFT;
            wmlp.x = viewLocation[0];
            wmlp.y = viewLocation[1];

            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog_box.getWindow().setLayout(400, 450);
            dialog_box.show();
        }
    };
}
