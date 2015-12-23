package com.cirrius.iclmcipla;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SearchView;
import android.widget.TextView;

import com.cirrius.expand.Expandablelistviewfordoc;
import com.cirrius.iclmcipla.R;

public class DetailingLandingPage extends Activity implements OnClickListener {
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
    private View thumbview8;

    private RelativeLayout relativeforpage;
    private TextView tv;
    private TextView threedot1, threedot2, threedot3, threedot4, threedot5,
            threedot6, threedot7, threedot8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Utility.setactoinbart(getActionBar(), this, font, "Detailing");
        setContentView(R.layout.detaling_landing_page);

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
        Expandablelistviewfordoc list = new Expandablelistviewfordoc(
                DetailingLandingPage.this);
        View v = list.multilevleexpandalelistview(2);
        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);

        rl1.addView(v);
        LinearLayout scroll2 = (LinearLayout) findViewById(R.id.scroll2);
        int[] imgArr1 = {R.drawable.mezom1, R.drawable.sols1,
                R.drawable.fade1, R.drawable.zepi1};
        int[] imgArr2 = {R.drawable.solsuna, R.drawable.zepine,
                R.drawable.dempi, R.drawable.stelpep};
        int[] imgArr3 = {R.drawable.stel1, R.drawable.demp1, R.drawable.sols1,
                R.drawable.ratio1};
        int[] imgArr4 = {R.drawable.solsuna2, R.drawable.tendew,
                R.drawable.dempi, R.drawable.acenomorol};

        scroll2.addView(getThumbnailLayout(0, this, "PEDIATRICS", "11",
                "Pediatrics is concerned with the health of infants.", imgArr1));
        scroll2.addView(getThumbnailLayout(1, this, "DENISTRY", "09",
                "Denistry is Study of oral disorder of a oral cavity", imgArr2));
        scroll2.addView(getThumbnailLayout(
                0,
                this,
                "CHEMOTHERAPY",
                "07",
                "is a category of cancer treatment that uses chemical substances",
                imgArr3));
        scroll2.addView(getThumbnailLayout(
                1,
                this,
                "IMMUNOTHERAPY",
                "04",
                "treatment of disease by inducing, enhancing, or suppressing an immune response",
                imgArr4));

        final RelativeLayout mask = (RelativeLayout) findViewById(R.id.mask1);
        TextView download = (TextView) findViewById(R.id.download);
        final LinearLayout ll = (LinearLayout) findViewById(R.id.retry);
        final ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar2);

        ll.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ll.setVisibility(View.INVISIBLE);
                pb.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.GONE);
                        mask.setVisibility(View.GONE);
                    }
                }, 3000);
            }
        });
        download.setTypeface(font);
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
                Intent intent1 = new Intent(DetailingLandingPage.this,
                        ContentLIb.class);

                intent1.putExtra("type", "seg");

                startActivity(intent1);

                break;

            case 133:

                Dialog dialog_box;
                dialog_box = new Dialog(DetailingLandingPage.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.menupopup);

                RelativeLayout layout = (RelativeLayout) dialog_box
                        .findViewById(R.id.relogout);
                layout.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DetailingLandingPage.this,
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
                        DetailingLandingPage.this, imageId, data, datanext,
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

        thumbview1.setOnClickListener(this);

        threedot1 = (TextView) thumbview1.findViewById(R.id.threedot);
        threedot1.setTypeface(font);

        threedot2 = (TextView) thumbview2.findViewById(R.id.threedot);
        threedot2.setTypeface(font);

        threedot3 = (TextView) thumbview3.findViewById(R.id.threedot);
        threedot3.setTypeface(font);

        threedot4 = (TextView) thumbview4.findViewById(R.id.threedot);
        threedot4.setTypeface(font);

        threedot5 = (TextView) thumbview5.findViewById(R.id.threedot);
        threedot5.setTypeface(font);

        threedot6 = (TextView) thumbview6.findViewById(R.id.threedot);
        threedot6.setTypeface(font);

        threedot7 = (TextView) thumbview7.findViewById(R.id.threedot);
        threedot7.setTypeface(font);

        threedot8 = (TextView) thumbview8.findViewById(R.id.threedot);
        threedot8.setTypeface(font);

        relativeforpage = (RelativeLayout) thumbview1
                .findViewById(R.id.relativeforpage);

        relativeforpage.setOnClickListener(listenMe);

        TextView infofromtumbnail1 = (TextView) thumbview1
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail1.setTypeface(font);

        TextView infofromtumbnail2 = (TextView) thumbview2
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail2.setTypeface(font);

        TextView infofromtumbnail3 = (TextView) thumbview3
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail3.setTypeface(font);

        TextView infofromtumbnail4 = (TextView) thumbview4
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail4.setTypeface(font);

        TextView infofromtumbnail5 = (TextView) thumbview5
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail5.setTypeface(font);

        TextView infofromtumbnail6 = (TextView) thumbview6
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail6.setTypeface(font);

        TextView infofromtumbnail7 = (TextView) thumbview7
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail7.setTypeface(font);

        TextView infofromtumbnail8 = (TextView) thumbview8
                .findViewById(R.id.infofromtumbnail);
        infofromtumbnail8.setTypeface(font);

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

    android.view.View.OnClickListener listenMe = new OnClickListener() {

        private Dialog dialog_box;

        @Override
        public void onClick(View v) {

            dialog_box = new Dialog(DetailingLandingPage.this);
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

    android.view.View.OnClickListener listenMeforplay = new OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(DetailingLandingPage.this,
                    DetailingPageV2.class);
            startActivity(intent);

        }
    };

    public LinearLayout getThumbnailLayout(int index, Context context,
                                           String text1, String text2, String text3, int[] imgarr) {
        LinearLayout parent = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.leftMargin = 2;
        params.topMargin = 2;
        parent.setLayoutParams(params);
        if (index == 0)
            parent.setBackgroundColor(Color.parseColor("#E8E8E8"));
        else
            parent.setBackgroundColor(Color.parseColor("#C3C3C3"));

        RelativeLayout child1 = new RelativeLayout(context);
        child1.setLayoutParams(new RelativeLayout.LayoutParams(350,
                LayoutParams.MATCH_PARENT));
        child1.setPadding(0, 15, 0, 0);

        RelativeLayout child2 = new RelativeLayout(context);
        RelativeLayout.LayoutParams cparam = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        child2.setLayoutParams(cparam);
        child2.setPadding(13, 20, 0, 20);

        TextView tv1 = new TextView(context);

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tv1.setLayoutParams(textparam1);
        tv1.setPadding(10, 0, 0, 0);
        tv1.setText(text1);
        tv1.setTextSize(24);
        tv1.setTextColor(Color.parseColor("#1e1e1e"));

        TextView tv3 = new TextView(context);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                41, 26);
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        tv3.setLayoutParams(textparam2);
        tv3.setGravity(Gravity.CENTER);
        tv3.setPadding(5, 5, 5, 5);
        tv3.setText(text2);
        tv3.setId(1112);
        tv3.setTextSize(14);
        tv3.setTextColor(Color.parseColor("#FFFFFF"));
        tv3.setBackgroundColor(Color.parseColor("#80000000"));

        TextView tv2 = new TextView(context);
        RelativeLayout.LayoutParams textparam3 = new RelativeLayout.LayoutParams(
                300, LayoutParams.WRAP_CONTENT);
        textparam3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textparam3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textparam3.addRule(RelativeLayout.ABOVE, 1112);
        textparam3.bottomMargin = 37;
        tv2.setLayoutParams(textparam3);
        tv2.setPadding(10, 0, 0, 0);
        tv2.setText(text3);
        tv2.setTextSize(14);
        tv2.setTextColor(Color.parseColor("#1e1e1e"));

        ImageView badaplay = new ImageView(context);
        RelativeLayout.LayoutParams iparam = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        iparam.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        iparam.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        iparam.bottomMargin = 30;
        badaplay.setLayoutParams(iparam);
        badaplay.setImageResource(R.drawable.playlist_icon);
        badaplay.setOnClickListener(listenMeforplay);

        child1.addView(tv1);
        child1.addView(tv2);
        child1.addView(tv3);
        child1.addView(badaplay);

        ImageView cfix1 = new ImageView(context);
        cfix1.setLayoutParams(new LayoutParams(178, 111));
        cfix1.setPadding(2, 0, 0, 0);
        cfix1.setId(1113);
        cfix1.setImageResource(imgarr[0]);

        ImageView cfix2 = new ImageView(context);
        RelativeLayout.LayoutParams cfixparam = new RelativeLayout.LayoutParams(
                178, 111);
        cfixparam.addRule(RelativeLayout.ALIGN_BOTTOM, 1113);
        cfixparam.leftMargin = 80;
        cfix2.setLayoutParams(cfixparam);
        cfix2.setPadding(4, 0, 0, 0);
        cfix2.setId(1114);
        cfix2.setBackgroundResource(R.drawable.card_back);
        cfix2.setImageResource(imgarr[1]);

        ImageView cfix3 = new ImageView(context);
        RelativeLayout.LayoutParams cfixparam2 = new RelativeLayout.LayoutParams(
                178, 111);
        cfixparam2.addRule(RelativeLayout.ALIGN_BOTTOM, 1114);
        cfixparam2.leftMargin = 160;
        cfix3.setLayoutParams(cfixparam2);
        cfix3.setPadding(4, 0, 0, 0);
        cfix3.setId(1115);
        cfix3.setBackgroundResource(R.drawable.card_back);
        cfix3.setImageResource(imgarr[2]);

        ImageView cfix4 = new ImageView(context);
        RelativeLayout.LayoutParams cfixparam3 = new RelativeLayout.LayoutParams(
                178, 111);
        cfixparam3.addRule(RelativeLayout.ALIGN_BOTTOM, 1115);
        cfixparam3.leftMargin = 240;
        cfix4.setLayoutParams(cfixparam3);
        cfix4.setPadding(4, 0, 0, 0);
        cfix4.setBackgroundResource(R.drawable.card_back);
        cfix4.setImageResource(imgarr[3]);

        TextView threedot = new TextView(context);
        RelativeLayout.LayoutParams textparam4 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        textparam4.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textparam4.rightMargin = 20;
        threedot.setLayoutParams(textparam4);
        threedot.setGravity(Gravity.RIGHT);
        threedot.setText(context.getResources().getString(
                R.string.icon_three_dot));
        threedot.setTextColor(Color.parseColor("#000000"));
        threedot.setTextSize(25);
        threedot.setTypeface(font);
        threedot.setOnClickListener(listenMe);

        child2.addView(cfix1);
        child2.addView(cfix2);
        child2.addView(cfix3);
        child2.addView(cfix4);
        child2.addView(threedot);

        parent.addView(child1);
        parent.addView(child2);

        return parent;
    }

}
