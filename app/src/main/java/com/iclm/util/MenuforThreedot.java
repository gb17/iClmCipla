package com.iclm.util;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.ReportingTabs;

public class MenuforThreedot {

	String[] maindata = { "Profile", "Geo-Tag", "Events/Campaign",
			"Action points", "Detailing", "Preparation", "Schedule",
			"Reporting" };

	String[] profile = { "Profile", "View Profile", "Update Profile",
			"Delete Request" };
	String[] geotag = { "Geo-Tag", "First Time", "Update", "Locate" };
	String[] EventsnCampaign = { "Events & Campaign", "View Tagged Events",
			"View Tagged Campaign", "Tag Event/Update", "Tag Campaign/Update" };

	String[] Actionpoints = { "Action points", "View", "Add View" };
	String[] Detailing = { "Detailing", "Start Meeting[LP]",
			"Start Meeting[SP]", "Segement play..." };
	String[] Preparation = { "Preparation", "PCP", "View Playlist", "Customize" };
	String[] Schedule = { "Schedule", "View", "Reschedule", "Cancel Meeting" };

	String[][] mainter = {
			{ "Profile", "View Profile", "Update Profile", "Delete Request" },
			{ "Geo-Tag", "First Time", "Update", "Locate" },
			{ "Events & Campaign", "View Tagged Events",
					"View Tagged Campaign", "Tag Event/Update",
					"Tag Campaign/Update" },
			{ "Action points", "View", "Add View" },
			{ "Detailing", "Start Meeting[LP]", "Start Meeting[SP]",
					"Segement play..." },
			{ "Preparation", "PCP", "View Playlist", "Customize" },
			{ "Schedule", "View", "Reschedule", "Cancel Meeting" } };
	Context context;
	Dialog dialog_box;
	private LinearLayout right;

	View vtemp;

	public MenuforThreedot(Context context) {
		this.context = context;
		vtemp = new View(context);

	}

	public Dialog menudialog() {

		dialog_box = new Dialog(context);
		dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog_box.setContentView(R.layout.physi_list_dialog);
		LinearLayout left = (LinearLayout)

		dialog_box.findViewById(R.id.left);
		right = (LinearLayout) dialog_box.findViewById(R.id.right);
		for (int i = 0; i < maindata.length; i++) {
			TextView textView = new TextView(context);
			View v1 = new View(context);
			LinearLayout.LayoutParams param = new

			LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,

			LinearLayout.LayoutParams.WRAP_CONTENT);
			LinearLayout.LayoutParams param1 = new

			LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,

			1);
			textView.setLayoutParams(param);
			v1.setLayoutParams(param1);
			v1.setBackgroundColor(Color.WHITE);
			MyTouchListener touchListener = new MyTouchListener();
			textView.setTextColor(Color.WHITE);

			textView.setOnTouchListener(touchListener);
			textView.setPadding(15, 5, 5, 5);
			textView.setTextSize(17);
			textView.setGravity(Gravity.CENTER_VERTICAL);
			textView.setText(maindata[i]);
			textView.setTag("" + i);

			if (i != maindata.length - 1) {
				textView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
						R.drawable.ic_chevron_right_white_24dp, 0);
				left.addView(textView);
				left.addView(v1);
			} else {
				textView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
						R.drawable.ic_chevron_right_white_24dp, 0);
				// textView.setVisibility(View.INVISIBLE);
				left.addView(textView);
				v1.setBackgroundColor(Color.parseColor("#484848"));
				v1.setVisibility(View.INVISIBLE);
				left.addView(v1);
			}
		}

		Window window = dialog_box.getWindow();
		WindowManager.LayoutParams wmlp = dialog_box.getWindow()
				.getAttributes();

		return dialog_box;

	}

	class MyTouchListener implements OnTouchListener {

		@Override
		public boolean onTouch(View v, MotionEvent event) {

			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				int count = Integer.parseInt((String) v.getTag());
				right.removeAllViews();
				if (count != 7) {
					vtemp.setBackgroundColor(Color.parseColor("#484848"));
					v.setBackgroundColor(Color.parseColor("#9e9e9e"));
					vtemp = v;

					for (int i = 0; i < mainter[count].length; i++) {
						TextView textView = new TextView(context);
						View v1 = new View(context);
						LinearLayout.LayoutParams param = new

						LinearLayout.LayoutParams(
								LinearLayout.LayoutParams.MATCH_PARENT,

								LinearLayout.LayoutParams.WRAP_CONTENT);
						LinearLayout.LayoutParams param1 = new

						LinearLayout.LayoutParams(
								LinearLayout.LayoutParams.WRAP_CONTENT,

								1);
						if (i == 0)
							param.topMargin = v.getTop();
						textView.setLayoutParams(param);
						v1.setLayoutParams(param1);
						v1.setBackgroundColor(Color.WHITE);

						textView.setTextColor(Color.WHITE);
						textView.setPadding(15, 10, 5, 12);
						textView.setTextSize(17);
						textView.setText(mainter[count][i]);
						textView.setTag("" + i);
						textView.setBackgroundColor(Color.parseColor("#484848"));
						right.addView(textView);
						if (i != mainter[count].length - 1)
							right.addView(v1);

					}

					int xt = v.getLeft();
					int yt = v.getTop();
					int suby = v.getWidth();

					// dialog_box.getWindow().getAttributes().y = yt ; //
					// -50;//(int)
					// // (height/2);
					// dialog_box.getWindow().getAttributes().x = xt+ suby;//
					// 200;
					// //
					// dialog_box.getWindow().setLayout(450, 450);
					dialog_box.show();
				}

				if (count == 7) {
					Intent intent = new Intent(context, ReportingTabs.class);
					context.startActivity(intent);

				}

				return true;

			}
			return true;

		}
	}
}