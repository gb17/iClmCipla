package com.cirrius.animationlist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cirrius.iclmcipla.CalendarView;
import com.cirrius.iclmcipla.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<String> {

	final int INVALID_ID = -1;

	HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	Context context;

	Integer[] imageDoctor = { R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doct_9, R.drawable.doct_7, R.drawable.doct_6, };

	String[] Drname = { "Alan Spiegel", "Alexander F", "Alexander M.",
			"Alexis E. Te", "Alice Rusk", "John Cussack", "Paul Allen" };

	String strTime[] = { "10:30 am", "11:00 am", "12:00 am", "12:45 pm",
			"01:30 pm", "01:45 pm", "02:15 pm", "01:30 pm", "Class B",
			"Class C", "Class A" };

	String[] Specialty = { "Nuclear cardiology", "Cardiologist",
			"Urologic oncology", "Urologic oncology", "Neurologist",
			"Nuclear cardiology", "Cardiologist" };
	String[] Class = { "Class B", "Class A", "Class C", "Class C", "Class B",
			"Class A", "Class C" };

	ArrayList<String[]> arr = new ArrayList<>();

	private Typeface font;

	public StableArrayAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);

		for (int i = 0; i < objects.size(); ++i) {
			mIdMap.put(objects.get(i), i);
		}

		// for (int i = 0; i < Drname.length; i++) {
		// String[] srr = { Drname[i], strTime[i], Specialty[i], Class[i] };
		// arr.add(srr);
		// }

		this.context = context;
	}

	@Override
	public long getItemId(int position) {
		if (position < 0 || position >= mIdMap.size()) {
			return INVALID_ID;
		}
		String item = getItem(position);
		return mIdMap.get(item);
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		font = Typeface.createFromAsset(context.getAssets(),
				"fontawesome-webfont.ttf");
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.dd_exrow_third, null);

		TextView mItemName = (TextView) convertView
				.findViewById(R.id.eventsListEventRowText);

		TextView mItemTime = (TextView) convertView.findViewById(R.id.time);

		ImageView drImageView = (ImageView) convertView
				.findViewById(R.id.dr_image);
		TextView mItemPrice = (TextView) convertView
				.findViewById(R.id.textViewItemPrice);

		TextView childtextview3 = (TextView) convertView
				.findViewById(R.id.childtextview3);

		final LinearLayout childiewoflist = (LinearLayout) convertView
				.findViewById(R.id.childiewoflist);

		ImageView deleted = (ImageView) convertView.findViewById(R.id.deleted);

		deleted.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				childiewoflist.setVisibility(View.GONE);

				CalendarView.textundo.setVisibility(View.VISIBLE);
			}
		});

		ImageView drag = (ImageView) convertView.findViewById(R.id.drag);

		drag.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CalendarView.textundo.setVisibility(View.VISIBLE);

				CalendarView.vtime.setVisibility(View.VISIBLE);

			}
		});

		// TextView menufordr2 = (TextView) convertView
		// .findViewById(R.id.menufordr2);

		// menufordr2.setTypeface(font);

		drImageView.setImageResource(imageDoctor[position]);
		mItemTime.setText(strTime[position]);
		mItemName.setText(Drname[position]);
		mItemPrice.setText(Specialty[position]);
		childtextview3.setText(Class[position]);

		return convertView;
	}

	void deletedr(int pos) {

	}
}
