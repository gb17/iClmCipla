package com.sync;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;

import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.Utility;

public class SyncActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Sync");
        ListView uploadlistview = (ListView) findViewById(R.id.listupload);


        ListView downloadlistview = (ListView) findViewById(R.id.listdownload);

        ListAdapterForsynclist listAdapterForsynclist = new ListAdapterForsynclist(SyncActivity.this, 1);
        ListAdapterForsynclist listAdapterForsynclist1 = new ListAdapterForsynclist(SyncActivity.this, 2);
        uploadlistview.setAdapter(listAdapterForsynclist);
        downloadlistview.setAdapter(listAdapterForsynclist1);


        findViewById(R.id.sync).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchBarDialog();
            }
        });


    }

    public void launchBarDialog() {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(SyncActivity.this,
                "Please wait ...", "Syncing ...", true);
        ringProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
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
                    e.printStackTrace();

                    ringProgressDialog.dismiss();

                }

            }
        }).start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                opend();
            }
        },5050);
    }


    void opend()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SyncActivity.this);
        alertDialogBuilder.setMessage("Data Sync Successfully.");

        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
