package com.cirrius.iclmcipla;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utility {
    public static void showTempAlert(Context context, String message) {

        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
        alertbox.setCancelable(false);
        alertbox.setMessage(message).setPositiveButton("OK",
                new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertbox.create();
        alertbox.show();
    }

    public static String getDateString() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        cal.setTime(new Date(System.currentTimeMillis()));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        Calendar calt = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        calt.setTime(new Date());
        int hh = calt.get(Calendar.HOUR_OF_DAY);
        int mm = calt.get(Calendar.MINUTE);
        int ss = calt.get(Calendar.SECOND);
        String dt = (date < 10 ? "0" + date : "" + date) + "/"
                + (month < 10 ? "0" + month : "" + month) + "/" + year + " "
                + (hh < 10 ? "0" + hh : "" + hh) + ":"
                + (mm < 10 ? "0" + mm : "" + mm) + ":"
                + (ss < 10 ? "0" + ss : "" + ss);
        return dt;
    }

    public static final String getDate(Date date) {

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd ");
        //
        // Calendar calendar = new GregorianCalendar(2013,1,28);
        // System.out.println("#1. " + sdf.format(calendar.getTime()));
        //
        // //update a date
        // calendar.set(Calendar.YEAR, calendar.YEAR);
        // calendar.set(Calendar.MONTH, Calendar.MONTH);
        // calendar.set(Calendar.DATE, Calendar.DATE);
        //
        // System.out.println( sdf.format(calendar.getTime()));
        //

        DateFormat dateFormat = new SimpleDateFormat("  dd MMM yyyy");
        Date date11 = new Date();
        String uniqueid = dateFormat.format(date11);

        // Calendar cal =
        // Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        // cal.setTime(date);
        // int int_year = cal.get(Calendar.YEAR);
        // int int_month = cal.get(Calendar.MONTH) + 1;
        // int int_date = cal.get(Calendar.DATE);
        // Calendar calt =
        // Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        // calt.setTime(new Date());
        // int int_hh = calt.get(Calendar.HOUR_OF_DAY);
        // int int_mm = calt.get(Calendar.MINUTE);
        // String str_dt = (int_date < 10 ? "0" + int_date : "" + int_date) +
        // "/"
        // + (int_month < 10 ? "0" + int_month : "" + int_month) + "/"
        // + int_year ;
        return uniqueid;
    }

    public static String[] swapelement(String[] data, int dataa, int datab) {
        String[] fdata = data;

        String firststring = data[dataa];
        String secondstring = data[datab];
        fdata[dataa] = secondstring;
        fdata[datab] = firststring;

        return fdata;

    }

    public static Integer[] swapelementimage(Integer[] data, int dataa,
                                             int datab) {
        Integer[] fdata = data;

        Integer firststring = data[dataa];
        Integer secondstring = data[datab];
        fdata[dataa] = secondstring;
        fdata[datab] = firststring;

        return fdata;

    }

    public static String[] split(String strData, String strExp) {
        String str_arrTemp[] = null;
        int int_k = 0;
        int int_sInd = 0;
        int int_eInd = strData.indexOf(strExp);

        while (int_eInd != -1) {
            int_sInd = int_eInd + 1;
            int_eInd = strData.indexOf(strExp, int_sInd);
            int_k++;
        }
        if (!strExp.equals("$")) {
            int_k += 1;
        }
        int_sInd = 0;
        int_eInd = strData.indexOf(strExp);
        str_arrTemp = new String[int_k];

        int_k = 0;
        while (int_eInd != -1) {
            str_arrTemp[int_k++] = strData.substring(int_sInd, int_eInd);
            int_sInd = int_eInd + 1;
            int_eInd = strData.indexOf(strExp, int_sInd);
        }
        if (!strExp.equals("$")) {
            str_arrTemp[int_k] = strData.substring(int_sInd, strData.length());
        }

        return str_arrTemp;
    }

    public static void showTempAlertActivityFinish(final Context context,
                                                   String message) {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
        alertbox.setCancelable(false);
        alertbox.setMessage(message).setPositiveButton("OK",
                new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ((Activity) context).finish();
                    }
                });
        alertbox.create();
        alertbox.show();
    }

    public static ProgressDialog progressDialog1(Context context) {
        // setup dialog here
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        dialog.show();
        return dialog;
    }

    public static void hideKeyboard(EditText et) {
        et.setFocusable(false);
        et.setFocusableInTouchMode(false);
        et.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
    }

    public static RelativeLayout getThumnail(final Context context,
                                             int imageId, String mtext, String desc) {
        Typeface font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");

        RelativeLayout parent = new RelativeLayout(context);
        parent.setLayoutParams(new RelativeLayout.LayoutParams(213, 185));

        ImageView image = new ImageView(context);
        image.setLayoutParams(new RelativeLayout.LayoutParams(213, 130));
        image.setBackgroundResource(imageId);
        image.setId(1001);

        RelativeLayout.LayoutParams paramsplayicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsplayicon.leftMargin = 167;
        paramsplayicon.topMargin = 80;

        final ImageView playIcon = new ImageView(context);
        // TextView playIcon = new TextView(context);
        playIcon.setLayoutParams(paramsplayicon);
        // playIcon.setTextColor(Color.WHITE);
        // playIcon.setTextSize(34);
        // playIcon.setText(context.getResources().getString(R.string.icon_play));
        playIcon.setImageResource(R.drawable.playlist_icon);
        playIcon.setTag("1");
        playIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playIcon.getTag().equals("1")) {
                    playIcon.setTag("0");
                    playIcon.setImageResource(R.drawable.playlist_icon_green);
                } else {
                    playIcon.setTag("1");
                    playIcon.setImageResource(R.drawable.playlist_icon);
                }
            }
        });

        RelativeLayout child = new RelativeLayout(context);
        LayoutParams myparam = new RelativeLayout.LayoutParams(213, 55);
        child.setPadding(8, 6, 0, 8);
        myparam.addRule(RelativeLayout.BELOW, 1001);
        child.setLayoutParams(myparam);
        int color = Color.parseColor("#c3c3c3");
        child.setBackgroundColor(color);

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam2.rightMargin = 8;
        textparam2.addRule(RelativeLayout.CENTER_VERTICAL);
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        RelativeLayout.LayoutParams textparam3 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        if (desc.equals(""))
            textparam3.addRule(RelativeLayout.CENTER_VERTICAL);
        else
            textparam3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textparam3.addRule(RelativeLayout.BELOW, 1112);

        TextView descT = new TextView(context);
        if (desc.equals(""))
            descT.setVisibility(View.GONE);
        descT.setText(desc);
        descT.setTextColor(Color.parseColor("#333333"));
        descT.setId(1112);
        descT.setTypeface(null, Typeface.BOLD);
        descT.setTextSize(16);
        descT.setLayoutParams(textparam1);

        TextView name = new TextView(context);
        name.setText(mtext);
        name.setTextColor(Color.parseColor("#333333"));
        name.setTextSize(16);

        name.setLayoutParams(textparam3);

        TextView threedot = new TextView(context);
        threedot.setText(context.getResources().getString(
                R.string.icon_three_dot));
        threedot.setTextColor(Color.parseColor("#333333"));
        threedot.setTextSize(16);
        threedot.setLayoutParams(textparam2);
        threedot.setTypeface(font);

        child.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Dialog dialog_box;
                dialog_box = new Dialog(context);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.doctorprofiledialogforbarnd);

                // dialog_box

                Window window = dialog_box.getWindow();

                WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                        .getAttributes();

                int[] viewLocation = new int[2];
                v.getLocationOnScreen(viewLocation);

                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                wmlp.x = viewLocation[0];
                wmlp.y = viewLocation[1];

                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(400, 450);
                dialog_box.show();
            }
        });

        child.addView(name);
        child.addView(threedot);
        child.addView(descT);

        parent.addView(image);
        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailingPageV2.class);
                context.startActivity(intent);

            }
        });
        RelativeLayout.LayoutParams paramsnewicon = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsnewicon.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsnewicon.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        ImageView newicon = new ImageView(context);
        newicon.setLayoutParams(paramsnewicon);
        newicon.setId(1991);
        newicon.setImageResource(R.drawable.newtag);
        parent.addView(newicon);
        // parent.setBackgroundColor(colorForThumbnailBg);
        parent.addView(playIcon);
        parent.addView(child);


        RelativeLayout.LayoutParams paramsreficon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramsreficon.addRule(RelativeLayout.RIGHT_OF, 1991);
        paramsreficon.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        ImageView reficon = new ImageView(context);
        reficon.setLayoutParams(paramsreficon);
        reficon.setImageResource(R.drawable.reftag);
        parent.addView(reficon);

        return parent;
    }

    public static RelativeLayout getThumnailForPhysi(final Context context,
                                                     int imageId, String dtext, int newtag, int regtag, int startag,
                                                     String mtext) {
        Typeface font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");

        RelativeLayout parent = new RelativeLayout(context);
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                213, 190);
        parent.setId(2131);

        RelativeLayout.LayoutParams paramview = new RelativeLayout.LayoutParams(
                213, 190);
        final View view = new View(context);
        paramview.addRule(RelativeLayout.ABOVE);
        view.setLayoutParams(paramview);

        parent.setPadding(0, 0, -1, 0);
        parent.setLayoutParams(param);

        ImageView image = new ImageView(context);
        image.setLayoutParams(new RelativeLayout.LayoutParams(213, 130));
        image.setBackgroundResource(imageId);
        image.setId(1001);

        RelativeLayout.LayoutParams paramsplayicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsplayicon.leftMargin = 167;
        paramsplayicon.topMargin = 80;

        RelativeLayout.LayoutParams paramsdeleteicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsdeleteicon.leftMargin = 6;
        paramsdeleteicon.topMargin = 80;

        ImageView playIcon = new ImageView(context);
        playIcon.setLayoutParams(paramsplayicon);
        playIcon.setImageResource(R.drawable.playlist_icon);
        playIcon.setTag(imageId);

        ImageView deleteIcon = new ImageView(context);
        deleteIcon.setLayoutParams(paramsdeleteicon);
        deleteIcon.setVisibility(view.INVISIBLE);
        deleteIcon.setImageResource(R.drawable.delete_icon);

        RelativeLayout child = new RelativeLayout(context);
        LayoutParams myparam = new RelativeLayout.LayoutParams(213, 60);
        child.setPadding(8, 3, 3, 4);
        myparam.addRule(RelativeLayout.BELOW, 1001);
        child.setLayoutParams(myparam);
        int color = Color.parseColor("#c3c3c3");
        child.setBackgroundColor(color);

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam2.rightMargin = 8;
        textparam2.topMargin = 5;
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        TextView desc = new TextView(context);
        desc.setId(1230);
        desc.setText(dtext);
        if (dtext.equals(""))
            desc.setVisibility(View.GONE);
        desc.setTextColor(Color.parseColor("#333333"));
        desc.setTextSize(16);
        desc.setPadding(0, 4, 0, 0);
        desc.setTypeface(null, Typeface.BOLD);
        desc.setLayoutParams(textparam1);

        RelativeLayout.LayoutParams textparam3 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        if (dtext.equals(""))
            textparam3.addRule(RelativeLayout.CENTER_VERTICAL);
        textparam3.addRule(RelativeLayout.BELOW, 1230);
        TextView name = new TextView(context);
        name.setText(mtext);
        name.setTextColor(Color.parseColor("#333333"));
        name.setTextSize(16);

        name.setLayoutParams(textparam3);

        TextView threedot = new TextView(context);
        threedot.setText(context.getResources().getString(
                R.string.icon_three_dot));
        threedot.setTextColor(Color.parseColor("#333333"));
        threedot.setTextSize(20);

        threedot.setLayoutParams(textparam2);
        threedot.setTypeface(null, Typeface.BOLD);

        threedot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Dialog dialog_box;
                dialog_box = new Dialog(context);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.doctorprofiledialogforbarnd);

                // dialog_box

                Window window = dialog_box.getWindow();

                WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                        .getAttributes();

                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                wmlp.x = 80; // x position
                wmlp.y = 230;

                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(400, 450);
                dialog_box.show();
            }
        });

        // Changes as per pdf
        RelativeLayout.LayoutParams paramsnewicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramsnewicon.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsnewicon.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        // paramsnewicon.setMargins(0, 0, 10, 0);

        final ImageView newicon = new ImageView(context);
        newicon.setLayoutParams(paramsnewicon);
        newicon.setImageResource(R.drawable.newtag);
        // newicon.setTag(imageId);

        // --------------------------------------3
        RelativeLayout.LayoutParams paramsstaricon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramsstaricon.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsstaricon.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        if (newtag == 0 || regtag == 0) {

        } else {
            // paramsstaricon.setMargins(0, 0, 66, 0);
        }

        ImageView staricon = new ImageView(context);
        staricon.setLayoutParams(paramsstaricon);
        staricon.setImageResource(R.drawable.extratag);
        staricon.setTag(imageId);
        // --------------------2
        RelativeLayout.LayoutParams paramsreficon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramsreficon.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsreficon.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        if (newtag == 0 && startag == 0) {

        } else {
            // paramsreficon.setMargins(0, 0, 30, 0);
        }

        ImageView reficon = new ImageView(context);
        reficon.setLayoutParams(paramsreficon);
        reficon.setImageResource(R.drawable.reftag);
        reficon.setTag(imageId);

        child.addView(desc);
        child.addView(threedot);
        child.addView(name);

        RelativeLayout.LayoutParams paramcenter = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramcenter.addRule(RelativeLayout.CENTER_IN_PARENT);

        final ImageView bijli = new ImageView(context);
        bijli.setLayoutParams(paramcenter);
        bijli.setImageResource(R.drawable.activate);

        parent.addView(image);
        // parent.setBackgroundColor(colorForThumbnailBg);

        parent.addView(playIcon);
        parent.addView(deleteIcon);
        parent.addView(child);

        // Changes as per pdf
        if (newtag == 1) {
            parent.addView(newicon);

            view.setBackgroundColor(Color.parseColor("#99FFFFFF"));
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    view.setVisibility(View.GONE);
                    newicon.setVisibility(View.GONE);
                    bijli.setVisibility(View.GONE);

                }
            });
            parent.addView(view);
            parent.addView(bijli);

        }
        if (regtag == 1) {
            parent.addView(reficon);
        }
        if (startag == 1) {
            parent.addView(staricon);
        }

        return parent;
    }

    public static RelativeLayout getFocusBrandThumnail(final Context context,
                                                       int imageId, String mtext) {

        RelativeLayout parent = new RelativeLayout(context);
        parent.setLayoutParams(new RelativeLayout.LayoutParams(204, 208));

        ImageView image = new ImageView(context);
        image.setLayoutParams(new RelativeLayout.LayoutParams(204, 160));
        image.setBackgroundResource(imageId);
        image.setId(1001);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 127;
        params.topMargin = 70;

        RelativeLayout.LayoutParams paramsplayicon = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsplayicon.leftMargin = 140;
        paramsplayicon.topMargin = 110;

        RelativeLayout.LayoutParams paramsdelete = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsdelete.leftMargin = 15;
        paramsdelete.topMargin = 110;

        ImageView playIcon = new ImageView(context);
        // TextView playIcon = new TextView(context);
        playIcon.setLayoutParams(paramsplayicon);

        ImageView delete = new ImageView(context);
        delete.setLayoutParams(paramsdelete);
        // playIcon.setTextColor(Color.WHITE);
        // playIcon.setTextSize(34);
        // playIcon.setText(context.getResources().getString(R.string.icon_play));
        playIcon.setImageResource(R.drawable.circlewithplayoption);
        delete.setImageResource(R.drawable.delete);

        RelativeLayout child = new RelativeLayout(context);
        RelativeLayout.LayoutParams myparam = new RelativeLayout.LayoutParams(
                204, 48);
        child.setPadding(8, 6, 0, 8);
        myparam.addRule(RelativeLayout.BELOW, 1001);
        child.setLayoutParams(myparam);
        int color = Color.parseColor("#c3c3c3");
        child.setBackgroundColor(color);

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textparam2.rightMargin = 8;
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        TextView name = new TextView(context);
        name.setText(mtext);
        name.setTextColor(Color.parseColor("#333333"));
        name.setTextSize(16);
        name.setLayoutParams(textparam1);
        delete.setVisibility(View.INVISIBLE);

        child.addView(name);
        parent.addView(image);
        parent.addView(playIcon);
        parent.addView(delete);
        parent.addView(child);

        return parent;
    }

    public static RelativeLayout getFocusBrandThumnailsecond(
            final Context context, int imageId, String mtext) {

        RelativeLayout parent = new RelativeLayout(context);
        parent.setLayoutParams(new RelativeLayout.LayoutParams(204, 200));

        ImageView image = new ImageView(context);
        image.setLayoutParams(new RelativeLayout.LayoutParams(204, 160));
        image.setBackgroundResource(imageId);
        image.setId(1001);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 127;
        params.topMargin = 70;

        RelativeLayout.LayoutParams paramsplayicon = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsplayicon.leftMargin = 140;
        paramsplayicon.topMargin = 110;

        // RelativeLayout.LayoutParams paramsdelete = new
        // RelativeLayout.LayoutParams(
        // RelativeLayout.LayoutParams.WRAP_CONTENT,
        // RelativeLayout.LayoutParams.WRAP_CONTENT);
        // paramsdelete.leftMargin = 15;
        // paramsdelete.topMargin = 110;

        ImageView playIcon = new ImageView(context);
        // TextView playIcon = new TextView(context);
        playIcon.setLayoutParams(paramsplayicon);

        // ImageView delete = new ImageView(context);
        // delete.setLayoutParams(paramsdelete);
        // playIcon.setTextColor(Color.WHITE);
        // playIcon.setTextSize(34);
        // playIcon.setText(context.getResources().getString(R.string.icon_play));
        playIcon.setImageResource(R.drawable.circlewithplayoption);
        // delete.setImageResource(R.drawable.delete);

        RelativeLayout child = new RelativeLayout(context);
        RelativeLayout.LayoutParams myparam = new RelativeLayout.LayoutParams(
                204, 40);
        child.setPadding(8, 6, 0, 8);
        myparam.addRule(RelativeLayout.BELOW, 1001);
        child.setLayoutParams(myparam);
        int color = Color.parseColor("#c3c3c3");
        child.setBackgroundColor(color);

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textparam2.rightMargin = 8;
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        TextView name = new TextView(context);
        name.setText(mtext);
        name.setTextColor(Color.parseColor("#333333"));
        name.setTextSize(16);
        name.setLayoutParams(textparam1);

        child.addView(name);
        parent.addView(image);
        parent.addView(playIcon);
        // parent.addView(delete);
        parent.addView(child);

        return parent;
    }

    public static RelativeLayout getThumnailnik(final Context context,
                                                int imageId, String mtext, int clockcode, int thumbcode, int mailid) {
        Typeface font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");

        RelativeLayout parent = new RelativeLayout(context);
        parent.setLayoutParams(new RelativeLayout.LayoutParams(213, 190));
        parent.setPadding(1, 1, 0, 0);

        ImageView image = new ImageView(context);
        image.setLayoutParams(new RelativeLayout.LayoutParams(213, 130));

        image.setBackgroundResource(imageId);
        image.setId(1001);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftMargin = 127;
        params.topMargin = 70;

        RelativeLayout.LayoutParams paramsplayicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsplayicon.leftMargin = 120;
        paramsplayicon.topMargin = 65;

        ImageView playIcon = new ImageView(context);
        // TextView playIcon = new TextView(context);
        playIcon.setLayoutParams(paramsplayicon);
        // playIcon.setTextColor(Color.WHITE);
        // playIcon.setTextSize(34);
        // playIcon.setText(context.getResources().getString(R.string.icon_play));
        playIcon.setImageResource(R.drawable.playlist_icon);

        RelativeLayout child = new RelativeLayout(context);
        LayoutParams myparam = new RelativeLayout.LayoutParams(213, 60);
        child.setPadding(8, 3, 3, 4);
        child.setId(1002);
        myparam.addRule(RelativeLayout.BELOW, 1001);
        child.setLayoutParams(myparam);
        int color = Color.parseColor("#c3c3c3");
        child.setBackgroundColor(color);

        RelativeLayout Nikhilchild = new RelativeLayout(context);
        Nikhilchild.setPadding(8, 6, 0, 0);
        LayoutParams myparam2 = new RelativeLayout.LayoutParams(213, 30);
        myparam2.addRule(RelativeLayout.ABOVE, 1002);
        Nikhilchild.setLayoutParams(myparam2);
        Nikhilchild.setBackgroundColor(Color.parseColor("#4D000000"));
        // -----------------------------------------------------------------------------------------------------

        TextView clock = new TextView(context);
        TextView thumb = new TextView(context);
        TextView mail = new TextView(context);
        TextView time = new TextView(context);

        clock.setTypeface(font);
        clock.setText(clockcode);
        clock.setTextColor(Color.WHITE);
        clock.setTextSize(18);

        RelativeLayout.LayoutParams timedata = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        time.setTextColor(Color.WHITE);
        time.setTextSize(10);
        time.setPadding(20, 0, 0, 0);
        time.setText("40\nSec");

        RelativeLayout.LayoutParams thumbdata = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        thumbdata.addRule(RelativeLayout.CENTER_HORIZONTAL);

        thumb.setTypeface(font);
        if (thumbcode == 0) {

            thumb.setText("");
        } else {
            thumb.setText(thumbcode);
        }
        thumb.setLayoutParams(thumbdata);
        thumb.setTextColor(Color.WHITE);
        thumb.setTextSize(18);

        RelativeLayout.LayoutParams maildata = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        maildata.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        mail.setTypeface(font);
        if (mailid == 0) {
            mail.setText("");
        } else {
            mail.setText(mailid);
        }
        mail.setLayoutParams(maildata);
        mail.setTextColor(Color.WHITE);
        mail.setPadding(0, 0, 10, 0);
        mail.setTextSize(18);

        // -----------------------------------------------------------------------------------------------------

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam2.rightMargin = 8;
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        TextView name = new TextView(context);
        name.setText(mtext);
        name.setTextColor(Color.parseColor("#333333"));
        name.setTextSize(16);
        name.setLayoutParams(textparam1);

        TextView threedot = new TextView(context);

        threedot.setTextColor(Color.parseColor("#333333"));
        threedot.setTextSize(16);
        threedot.setLayoutParams(textparam2);
        // threedot.setTypeface(font);

        child.addView(name);
        child.addView(threedot);

        Nikhilchild.addView(clock);
        Nikhilchild.addView(thumb);
        Nikhilchild.addView(mail);
        Nikhilchild.addView(time);

        parent.addView(image);
        // parent.setBackgroundColor(colorForThumbnailBg);
        parent.addView(playIcon);
        parent.addView(child);
        parent.addView(Nikhilchild);

        return parent;
    }

    public static RelativeLayout getThumnailReporting(final Context context,
                                                      int imageId, String mtext, int clockcode, int thumbcode, int mailid) {
        Typeface font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");

        RelativeLayout parent = new RelativeLayout(context);
        parent.setLayoutParams(new RelativeLayout.LayoutParams(213, 193));
        parent.setPadding(3, 1, 2, 0);

        ImageView image = new ImageView(context);
        image.setLayoutParams(new RelativeLayout.LayoutParams(213, 140));

        image.setBackgroundResource(imageId);
        image.setId(1001);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftMargin = 127;
        params.topMargin = 70;

        RelativeLayout.LayoutParams paramsplayicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsplayicon.leftMargin = 10;
        paramsplayicon.topMargin = 70;

        ImageView deleteIcon = new ImageView(context);
        deleteIcon.setLayoutParams(paramsplayicon);
        deleteIcon.setImageResource(R.drawable.delete_icon);

        RelativeLayout child = new RelativeLayout(context);
        LayoutParams myparam = new RelativeLayout.LayoutParams(213, 53);
        child.setPadding(8, 6, 0, 8);
        child.setId(1002);
        myparam.addRule(RelativeLayout.BELOW, 1001);
        child.setLayoutParams(myparam);
        int color = Color.parseColor("#c3c3c3");
        child.setBackgroundColor(color);

        RelativeLayout Nikhilchild = new RelativeLayout(context);
        Nikhilchild.setPadding(8, 6, 0, 0);
        LayoutParams myparam2 = new RelativeLayout.LayoutParams(213, 30);
        myparam2.addRule(RelativeLayout.ABOVE, 1002);
        Nikhilchild.setLayoutParams(myparam2);
        Nikhilchild.setBackgroundColor(Color.parseColor("#4D000000"));
        // -----------------------------------------------------------------------------------------------------

        TextView clock = new TextView(context);
        TextView thumb = new TextView(context);
        TextView mail = new TextView(context);
        TextView time = new TextView(context);

        clock.setTypeface(font);
        clock.setText(clockcode);
        clock.setTextColor(Color.WHITE);
        clock.setTextSize(18);

        RelativeLayout.LayoutParams timedata = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        time.setTextColor(Color.WHITE);
        time.setTextSize(10);
        time.setPadding(20, 0, 0, 0);
        time.setText("40\nSec");

        RelativeLayout.LayoutParams thumbdata = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        thumbdata.addRule(RelativeLayout.CENTER_HORIZONTAL);

        thumb.setTypeface(font);
        if (thumbcode == 0) {

            thumb.setText("");
        } else {
            thumb.setText(thumbcode);
        }
        thumb.setLayoutParams(thumbdata);
        thumb.setTextColor(Color.WHITE);
        thumb.setTextSize(18);

        RelativeLayout.LayoutParams maildata = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        maildata.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        mail.setTypeface(font);
        if (mailid == 0) {
            mail.setText("");
        } else {
            mail.setText(mailid);
        }
        mail.setLayoutParams(maildata);
        mail.setTextColor(Color.WHITE);
        mail.setPadding(0, 0, 10, 0);
        mail.setTextSize(18);

        // -----------------------------------------------------------------------------------------------------

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam2.rightMargin = 8;
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        TextView name = new TextView(context);
        name.setText(mtext);
        name.setTextColor(Color.parseColor("#333333"));
        name.setTextSize(16);
        name.setLayoutParams(textparam1);

        TextView threedot = new TextView(context);

        threedot.setTextColor(Color.parseColor("#333333"));
        threedot.setTextSize(16);
        threedot.setLayoutParams(textparam2);
        // threedot.setTypeface(font);

        child.addView(name);
        child.addView(threedot);

        Nikhilchild.addView(clock);
        Nikhilchild.addView(thumb);
        Nikhilchild.addView(mail);
        Nikhilchild.addView(time);

        parent.addView(image);
        // parent.setBackgroundColor(colorForThumbnailBg);
        parent.addView(deleteIcon);
        parent.addView(child);
        parent.addView(Nikhilchild);

        return parent;
    }

    public static void setactoinbart(ActionBar actionBar, Context context,
                                     Typeface font, String titlename)

    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        View cView = inflater.inflate(R.layout.actionbarlayout, null);

        TextView title = (TextView) cView.findViewById(R.id.title);
        TextView icontri = (TextView) cView.findViewById(R.id.icontri);
        icontri.setTypeface(font);
        TextView activityname = (TextView) cView
                .findViewById(R.id.activityname);
        activityname.setText(titlename);
        activityname.setTypeface(font);
        actionBar.setCustomView(cView);

        actionBar.setBackgroundDrawable(context.getResources().getDrawable(
                R.drawable.actiopnbar));
        actionBar.setTitle("");

    }

    public static RelativeLayout getThumnailForInvent(final Context context,
                                                      int imageId, String dtext, int newtag, int regtag, int startag,
                                                      String mtext, String mtext1) {
        Typeface font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");

        RelativeLayout parent = new RelativeLayout(context);
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                213, 190);
        parent.setId(2131);

        RelativeLayout.LayoutParams paramview = new RelativeLayout.LayoutParams(
                213, 190);
        final View view = new View(context);
        paramview.addRule(RelativeLayout.ALIGN_TOP);
        view.setLayoutParams(paramview);

        parent.setPadding(0, 0, -1, 0);
        parent.setLayoutParams(param);

        TextView head = new TextView(context);
        head.setText(Html.fromHtml("<b>" + mtext + "</b> <br/>" + mtext1));
        head.setTextColor(Color.parseColor("#333333"));
        head.setTextSize(16);
        head.setLayoutParams(paramview);

        ImageView image = new ImageView(context);
        image.setLayoutParams(new RelativeLayout.LayoutParams(213, 130));
        image.setBackgroundResource(imageId);
        image.setId(1001);

        RelativeLayout.LayoutParams paramsplayicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsplayicon.leftMargin = 167;
        paramsplayicon.topMargin = 80;

        RelativeLayout.LayoutParams paramsdeleteicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        paramsdeleteicon.leftMargin = 6;
        paramsdeleteicon.topMargin = 80;

        ImageView playIcon = new ImageView(context);
        playIcon.setLayoutParams(paramsplayicon);
        playIcon.setImageResource(R.drawable.playlist_icon);
        playIcon.setTag(imageId);
        playIcon.setVisibility(View.GONE);

        ImageView deleteIcon = new ImageView(context);
        deleteIcon.setLayoutParams(paramsdeleteicon);
        deleteIcon.setVisibility(view.INVISIBLE);
        deleteIcon.setImageResource(R.drawable.delete_icon);

        RelativeLayout child = new RelativeLayout(context);
        LayoutParams myparam = new RelativeLayout.LayoutParams(213, 60);
        child.setPadding(8, 3, 3, 4);
        myparam.addRule(RelativeLayout.BELOW, 1001);
        child.setLayoutParams(myparam);
        int color = Color.parseColor("#c3c3c3");
        child.setBackgroundColor(color);

        RelativeLayout.LayoutParams textparam1 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam2 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam2.rightMargin = 8;
        textparam2.topMargin = 5;
        textparam2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        TextView desc = new TextView(context);
        desc.setId(1230);
        desc.setText(dtext);
        if (dtext.equals(""))
            desc.setVisibility(View.GONE);
        desc.setTextColor(Color.parseColor("#333333"));
        desc.setTextSize(20);
        desc.setPadding(0, 4, 0, 0);
        desc.setTypeface(null, Typeface.BOLD);
        desc.setLayoutParams(textparam1);

        RelativeLayout.LayoutParams textparam3 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams textparam4 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textparam4.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textparam4.addRule(RelativeLayout.ABOVE, 1001);
        if (dtext.equals(""))
            textparam3.addRule(RelativeLayout.CENTER_VERTICAL);
        textparam3.addRule(RelativeLayout.BELOW, 1230);
        TextView name = new TextView(context);
        name.setText(Html.fromHtml("<b>" + mtext + "</b> <br/>" + mtext1));
        name.setTextColor(Color.parseColor("#333333"));
        name.setTextSize(16);

        name.setLayoutParams(textparam3);

        TextView name1 = new TextView(context);
        name1.setText(Html.fromHtml("<b>" + mtext + "</b> <br/>" + mtext1));
        name1.setTextColor(Color.parseColor("#333333"));
        name1.setTextSize(16);

        name1.setLayoutParams(textparam4);

        // Changes as per pdf
        RelativeLayout.LayoutParams paramsnewicon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramsnewicon.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsnewicon.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        // paramsnewicon.setMargins(0, 0, 10, 0);

        final ImageView newicon = new ImageView(context);
        newicon.setLayoutParams(paramsnewicon);
        newicon.setImageResource(R.drawable.newtag);
        // newicon.setTag(imageId);

        // --------------------------------------3
        RelativeLayout.LayoutParams paramsstaricon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramsstaricon.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsstaricon.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        if (newtag == 0 || regtag == 0) {

        } else {
            // paramsstaricon.setMargins(0, 0, 66, 0);
        }

        ImageView staricon = new ImageView(context);
        staricon.setLayoutParams(paramsstaricon);
        staricon.setImageResource(R.drawable.extratag);
        staricon.setTag(imageId);
        // --------------------2
        RelativeLayout.LayoutParams paramsreficon = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramsreficon.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsreficon.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        if (newtag == 0 && startag == 0) {

        } else {
            // paramsreficon.setMargins(0, 0, 30, 0);
        }

        ImageView reficon = new ImageView(context);
        reficon.setLayoutParams(paramsreficon);
        reficon.setImageResource(R.drawable.reftag);
        reficon.setTag(imageId);

        child.addView(desc);
        // child.addView(threedot);
        child.addView(name);

        RelativeLayout.LayoutParams paramcenter = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        paramcenter.addRule(RelativeLayout.CENTER_IN_PARENT);

        final ImageView bijli = new ImageView(context);
        bijli.setLayoutParams(paramcenter);
        bijli.setImageResource(R.drawable.activate);
        parent.addView(head);
        parent.addView(name1);
        parent.addView(image);
        // parent.setBackgroundColor(colorForThumbnailBg);

        parent.addView(playIcon);
        parent.addView(deleteIcon);
        parent.addView(child);

        // Changes as per pdf
        if (newtag == 1) {
            parent.addView(newicon);

            view.setBackgroundColor(Color.parseColor("#99FFFFFF"));
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    view.setVisibility(View.GONE);
                    newicon.setVisibility(View.GONE);
                    bijli.setVisibility(View.GONE);

                }
            });
            parent.addView(view);
            parent.addView(bijli);

        }
        if (regtag == 1) {
            parent.addView(reficon);
        }
        if (startag == 1) {
            parent.addView(staricon);
        }

        return parent;
    }

}
