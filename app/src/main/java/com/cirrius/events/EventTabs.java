package com.cirrius.events;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cirrius.iclmcipla.PlaylistFragment;
import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.Utility;

public class EventTabs extends Activity {

	private Typeface font;
	TextView tab1, tab2, tab3, tab4, tab5, tab6, tab7;
	View tab11, tab22, tab33, tab44, tab55, tab66, tab77;
	public static TextView textview;
	public static LinearLayout linselction;
	private LinearLayout mainLinear;
	private ScrollView physiScroll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
		Utility.setactoinbart(getActionBar(), this, font, "Events");
		setContentView(R.layout.event_tabs);
		TextView next = (TextView) findViewById(R.id.next);
		next.setTypeface(font);
		TextView threedot = (TextView) findViewById(R.id.threedot);
		threedot.setTypeface(font);
		TextView tp11 = (TextView) findViewById(R.id.textcalender);
		TextView tp12 = (TextView) findViewById(R.id.textclock);
		TextView tp13 = (TextView) findViewById(R.id.textlocation);

		tp11.setTypeface(font);
		tp12.setTypeface(font);
		tp13.setTypeface(font);

		textview = (TextView) findViewById(R.id.textview);

		tab1 = (TextView) findViewById(R.id.tab1);
		tab2 = (TextView) findViewById(R.id.tab2);
		tab3 = (TextView) findViewById(R.id.tab3);
		tab4 = (TextView) findViewById(R.id.tab4);
		tab5 = (TextView) findViewById(R.id.tab5);
		tab6 = (TextView) findViewById(R.id.tab6);
		tab7 = (TextView) findViewById(R.id.tab7);

		tab11 = (View) findViewById(R.id.tab11);
		tab22 = (View) findViewById(R.id.tab22);
		tab33 = (View) findViewById(R.id.tab33);
		tab44 = (View) findViewById(R.id.tab44);
		tab55 = (View) findViewById(R.id.tab55);
		tab66 = (View) findViewById(R.id.tab66);
		tab77 = (View) findViewById(R.id.tab77);

		Bundle bundle = new Bundle();
		bundle.putString("index", "4");
		Fragment fragment = new PlaylistFragment();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		fragment.setArguments(bundle);
		ft.add(R.id.mainfrag, fragment);
		ft.commit();

		tab1.setOnClickListener(olc);
		tab2.setOnClickListener(olc);
		tab3.setOnClickListener(olc);
		tab4.setOnClickListener(olc);
		tab5.setOnClickListener(olc);
		tab6.setOnClickListener(olc);
		tab7.setOnClickListener(olc);

		linselction = (LinearLayout) findViewById(R.id.linselction);
		mainLinear = (LinearLayout) findViewById(R.id.mainfrag);
		physiScroll = (ScrollView) findViewById(R.id.physiscroll);
	}

	OnClickListener olc = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			View view;
			int x;
			int y;
			LinearLayout linear = (LinearLayout) mainLinear.getChildAt(0);
			
			switch (v.getId()) {
			case R.id.tab1:
				tab1.setTextColor(Color.parseColor("#000000"));
				tab2.setTextColor(Color.parseColor("#808080"));
				tab3.setTextColor(Color.parseColor("#808080"));
				tab4.setTextColor(Color.parseColor("#808080"));
				tab5.setTextColor(Color.parseColor("#808080"));
				tab6.setTextColor(Color.parseColor("#808080"));
				tab7.setTextColor(Color.parseColor("#808080"));
				tab11.setVisibility(View.VISIBLE);
				tab22.setVisibility(View.INVISIBLE);
				tab33.setVisibility(View.INVISIBLE);
				tab44.setVisibility(View.INVISIBLE);
				tab55.setVisibility(View.INVISIBLE);
				tab66.setVisibility(View.INVISIBLE);
				tab77.setVisibility(View.INVISIBLE);
				textview.setText("INFO");
				view = linear.getChildAt(0);
				x = view.getLeft();
				y = view.getTop();
				physiScroll.scrollTo(x, y);
				break;
			case R.id.tab2:
				tab2.setTextColor(Color.parseColor("#000000"));
				tab1.setTextColor(Color.parseColor("#808080"));
				tab3.setTextColor(Color.parseColor("#808080"));
				tab4.setTextColor(Color.parseColor("#808080"));
				tab5.setTextColor(Color.parseColor("#808080"));
				tab6.setTextColor(Color.parseColor("#808080"));
				tab7.setTextColor(Color.parseColor("#808080"));
				tab22.setVisibility(View.VISIBLE);
				tab11.setVisibility(View.INVISIBLE);
				tab33.setVisibility(View.INVISIBLE);
				tab44.setVisibility(View.INVISIBLE);
				tab55.setVisibility(View.INVISIBLE);
				tab66.setVisibility(View.INVISIBLE);
				tab77.setVisibility(View.INVISIBLE);
				textview.setText("BUSINESS");
				view = linear.getChildAt(1);
				x = view.getLeft();
				y = view.getTop();
				physiScroll.scrollTo(x, y);
				break;

			case R.id.tab3:
				tab3.setTextColor(Color.parseColor("#000000"));
				tab2.setTextColor(Color.parseColor("#808080"));
				tab1.setTextColor(Color.parseColor("#808080"));
				tab4.setTextColor(Color.parseColor("#808080"));
				tab5.setTextColor(Color.parseColor("#808080"));
				tab6.setTextColor(Color.parseColor("#808080"));
				tab7.setTextColor(Color.parseColor("#808080"));
				tab33.setVisibility(View.VISIBLE);
				tab22.setVisibility(View.INVISIBLE);
				tab11.setVisibility(View.INVISIBLE);
				tab44.setVisibility(View.INVISIBLE);
				tab55.setVisibility(View.INVISIBLE);
				tab66.setVisibility(View.INVISIBLE);
				tab77.setVisibility(View.INVISIBLE);
				textview.setText("INVITEES");
				view = linear.getChildAt(2);
				x = view.getLeft();
				y = view.getTop();
				physiScroll.scrollTo(x, y);
				break;

			case R.id.tab4:
				tab4.setTextColor(Color.parseColor("#000000"));
				tab2.setTextColor(Color.parseColor("#808080"));
				tab3.setTextColor(Color.parseColor("#808080"));
				tab1.setTextColor(Color.parseColor("#808080"));
				tab5.setTextColor(Color.parseColor("#808080"));
				tab6.setTextColor(Color.parseColor("#808080"));
				tab7.setTextColor(Color.parseColor("#808080"));
				tab44.setVisibility(View.VISIBLE);
				tab22.setVisibility(View.INVISIBLE);
				tab33.setVisibility(View.INVISIBLE);
				tab11.setVisibility(View.INVISIBLE);
				tab55.setVisibility(View.INVISIBLE);
				tab66.setVisibility(View.INVISIBLE);
				tab77.setVisibility(View.INVISIBLE);
				textview.setText("EXPENDITURE");
				view = linear.getChildAt(3);
				x = view.getLeft();
				y = view.getTop();
				physiScroll.scrollTo(x, y);
				break;
			case R.id.tab5:
				tab5.setTextColor(Color.parseColor("#000000"));
				tab2.setTextColor(Color.parseColor("#808080"));
				tab3.setTextColor(Color.parseColor("#808080"));
				tab1.setTextColor(Color.parseColor("#808080"));
				tab4.setTextColor(Color.parseColor("#808080"));
				tab6.setTextColor(Color.parseColor("#808080"));
				tab7.setTextColor(Color.parseColor("#808080"));
				tab55.setVisibility(View.VISIBLE);
				tab22.setVisibility(View.INVISIBLE);
				tab33.setVisibility(View.INVISIBLE);
				tab11.setVisibility(View.INVISIBLE);
				tab44.setVisibility(View.INVISIBLE);
				tab66.setVisibility(View.INVISIBLE);
				tab77.setVisibility(View.INVISIBLE);
				textview.setText("BRANDS");
				break;
			case R.id.tab6:
				tab6.setTextColor(Color.parseColor("#000000"));
				tab2.setTextColor(Color.parseColor("#808080"));
				tab3.setTextColor(Color.parseColor("#808080"));
				tab1.setTextColor(Color.parseColor("#808080"));
				tab4.setTextColor(Color.parseColor("#808080"));
				tab5.setTextColor(Color.parseColor("#808080"));
				tab7.setTextColor(Color.parseColor("#808080"));
				tab66.setVisibility(View.VISIBLE);
				tab22.setVisibility(View.INVISIBLE);
				tab33.setVisibility(View.INVISIBLE);
				tab11.setVisibility(View.INVISIBLE);
				tab44.setVisibility(View.INVISIBLE);
				tab55.setVisibility(View.INVISIBLE);
				tab77.setVisibility(View.INVISIBLE);
				textview.setText("ACTIVITIES");
				break;
			case R.id.tab7:
				tab7.setTextColor(Color.parseColor("#000000"));
				tab2.setTextColor(Color.parseColor("#808080"));
				tab3.setTextColor(Color.parseColor("#808080"));
				tab1.setTextColor(Color.parseColor("#808080"));
				tab4.setTextColor(Color.parseColor("#808080"));
				tab6.setTextColor(Color.parseColor("#808080"));
				tab5.setTextColor(Color.parseColor("#808080"));
				tab77.setVisibility(View.VISIBLE);
				tab22.setVisibility(View.INVISIBLE);
				tab33.setVisibility(View.INVISIBLE);
				tab11.setVisibility(View.INVISIBLE);
				tab44.setVisibility(View.INVISIBLE);
				tab66.setVisibility(View.INVISIBLE);
				tab55.setVisibility(View.INVISIBLE);
				textview.setText("ACTION");
				view = linear.getChildAt(4);
				x = view.getLeft();
				y = view.getTop();
				physiScroll.scrollTo(x, y);
				break;

			default:
				break;
			}
		}
	};

}
