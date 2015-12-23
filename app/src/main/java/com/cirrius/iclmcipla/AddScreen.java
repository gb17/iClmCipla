package com.cirrius.iclmcipla;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.cirrius.expand.Expandablelistviewfordoc;

public class AddScreen extends Activity {
    private Dialog dialog_box;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addscreen);
        Expandablelistviewfordoc list = new Expandablelistviewfordoc(
                AddScreen.this);
        View v = list.multilevleexpandalelistview(2);
        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.listfordoc);
        rl1.addView(v);
        header = (TextView) findViewById(R.id.header);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        SearchView searchView = new SearchView(getActionBar()
                .getThemedContext());
        int searchIconId = searchView.getContext().getResources()
                .getIdentifier("android:id/search_button", null, null);
        ImageView searchIcon = (ImageView) searchView
                .findViewById(searchIconId);
        searchIcon.setImageResource(R.drawable.ic_action_search);
        searchView.setQueryHint("Enter Text");

        menu.add(Menu.NONE, 130, 0, "Search")
                .setIcon(R.drawable.ic_zoom_in_white_48dp)
                .setActionView(searchView)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(Menu.NONE, R.drawable.plus, 1, "").setIcon(R.drawable.plus)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.drawable.plus) {
            dialog_box = new Dialog(this);
            dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_box.setContentView(R.layout.addlist);

            RelativeLayout appointment = (RelativeLayout) dialog_box
                    .findViewById(R.id.appointment);
            RelativeLayout leave = (RelativeLayout) dialog_box
                    .findViewById(R.id.leave);
            RelativeLayout tot = (RelativeLayout) dialog_box
                    .findViewById(R.id.tot);
            RelativeLayout todo = (RelativeLayout) dialog_box
                    .findViewById(R.id.todo);

            appointment.setOnClickListener(mylisten);
            leave.setOnClickListener(mylisten);
            tot.setOnClickListener(mylisten);
            todo.setOnClickListener(mylisten);

            Window window = dialog_box.getWindow();

            WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                    .getAttributes();

            wmlp.gravity = Gravity.TOP | Gravity.RIGHT;
            wmlp.x = 35; // x position
            wmlp.y = 30;
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog_box.getWindow().setLayout(200, 250);
            dialog_box.getWindow().clearFlags(
                    WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialog_box.show();

        }
        return true;
    }

    OnClickListener mylisten = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            dialog_box.dismiss();

            Bundle bundle = new Bundle();
            if (v.getId() == R.id.appointment) {
                bundle.putString("index", "1");
                header.setText("Appointment");
            } else if (v.getId() == R.id.leave) {
                bundle.putString("index", "2");
                header.setText("Leave");
            } else if (v.getId() == R.id.tot) {
                bundle.putString("index", "3");
                header.setText("TOT");
            } else if (v.getId() == R.id.todo) {
                bundle.putString("index", "4");
                header.setText("TODO");
            }
            Fragment fragment = new RightFragment();
            fragment.setArguments(bundle);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment, fragment);
            ft.commit();
        }
    };

}
