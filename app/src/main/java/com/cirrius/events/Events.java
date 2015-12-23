package com.cirrius.events;

import java.util.ArrayList;
import java.util.List;

import com.cirrius.graph.Graphs;
import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.Utility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Events extends Activity {

	EventsAdapter adapter;

	private String[] first = { "ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference",
			"ENT SUMMIT 2015, Brooklyn | Conference" };
	private String[] second = { "Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1",
			"Brooklyn | C-Fix, Mezzo Drop +1" };
	private String[] third = { "ENT Related New Discoveries",
			"ENT Related New Discoveries", "ENT Related New Discoveries",
			"ENT Related New Discoveries", "ENT Related New Discoveries",
			"ENT Related New Discoveries", "ENT Related New Discoveries",
			"ENT Related New Discoveries", "ENT Related New Discoveries",
			"ENT Related New Discoveries" };

	private List<String[]> dataList;

	private Typeface font;

	private ListView lv;

	private RelativeLayout webView21;
	private RelativeLayout webView22;
	String[] ast5 = { "PLANNED", "ACTUAL" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
		Utility.setactoinbart(getActionBar(), this, font, "Events");
		setContentView(R.layout.events);
		dataList = new ArrayList<String[]>();
		RelativeLayout left = (RelativeLayout) findViewById(R.id.left);

		left.addView(getView());

		webView21 = (RelativeLayout) findViewById(R.id.webview21);
		webView22 = (RelativeLayout) findViewById(R.id.webview22);
		Graphs graphs = new Graphs(this);

		webView21.addView(graphs.drawNbarchart(2, ast5, 22, 2),
				new LayoutParams(360, 220));
		webView22.addView(graphs.drawNbarchart(2, ast5, 23, 2),
				new LayoutParams(360, 220));
	}

	public LinearLayout getView() {
		LinearLayout parent = new LinearLayout(this);
		parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		parent.setPadding(10, 10, 10, 0);
		parent.setOrientation(LinearLayout.VERTICAL);
		View v = getLayoutInflater().inflate(R.layout.edit_with_search, null);
		v.setLayoutParams(new android.view.ViewGroup.LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
		v.setBackgroundResource(R.drawable.bg_roundedwhite);
		v.setPadding(10, 0, 10, 0);
		final EditText editText = (EditText) v.findViewById(R.id.search);
		Utility.hideKeyboard(editText);
		editText.addTextChangedListener(watcher);
		ImageView search_close = (ImageView) v.findViewById(R.id.search_close);
		search_close.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editText.setText("");
			}
		});

		for (int i = 0; i < first.length; i++) {
			String[] str = { first[i], second[i], third[i] };
			dataList.add(str);
		}

		lv = new ListView(this);
		// lv.setVisibility(View.INVISIBLE);
		lv.setLayoutParams(new android.view.ViewGroup.LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
		adapter = new EventsAdapter(this, dataList);

		int[] colors = { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF };
		lv.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		lv.setDividerHeight(1);
		lv.setAdapter(adapter);
		lv.setPadding(0, 0, 0, 5);
		parent.addView(v);
		parent.addView(lv);
		return parent;
	}

	TextWatcher watcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			// if (s.toString().equals(""))
			// lv.setVisibility(View.INVISIBLE);
			// else {
			// lv.setVisibility(View.VISIBLE);
			adapter.getFilter().filter(s.toString());
		}

		// }

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		menu.add(Menu.NONE, R.drawable.plus, 1, "").setIcon(R.drawable.plus)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.drawable.plus:
			final Dialog d = new Dialog(this);
			d.requestWindowFeature(Window.FEATURE_NO_TITLE);
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.R.color.transparent));
			d.setContentView(R.layout.add_events);
			d.getWindow().setLayout(750, 630);
			TextView cross = (TextView) d.findViewById(R.id.crossvb);
			cross.setTypeface(font);

			// TextView cam1 = (TextView) d.findViewById(R.id.cam1);
			// cam1.setTypeface(font);
			// TextView cam2 = (TextView) d.findViewById(R.id.cam2);
			// cam2.setTypeface(font);
			// TextView cam3 = (TextView) d.findViewById(R.id.cam3);
			// cam3.setTypeface(font);
			TextView button = (TextView) d.findViewById(R.id.save);
			button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					d.dismiss();
				}
			});
			cross.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					d.dismiss();
				}
			});
			d.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
