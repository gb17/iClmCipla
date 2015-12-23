package com.cirrius.iclmcipla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cirrius.calender.listview.DBHandler;

import java.io.IOException;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.login);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        ImageView click = (ImageView) findViewById(R.id.loginclick);
        click.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String date = Utility.getDateString();
                String[][] TBDED = {

                        {date.substring(0, 10), "w", "", "B", "C", "D",
                                "padmini", "576576"},
                        {"", "q", "", "aa", "aa", "aa", "priya", "5765"},
                        {"", "r", "", "aa", "aa", "aa", "priyanka", "576585"},

                };

                ReadWriteData rw = new ReadWriteData(Login.this, "MPOWERDB",
                        null, 1);
                if (rw.TableExist("TBDED") == false) {
                    rw.createTables();
                    rw.insertGenericData2D("TBDED", TBDED);

                }
                try {

                    DBHandler dbHandler = DBHandler.getInstance(Login.this);
                    dbHandler.createDataBase();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Intent intent = new Intent(Login.this, LandingPage.class);
                startActivity(intent);
            }
        });
    }
}
