package com.cirrius.invitees;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;
import com.index.table.to.Book;

import java.util.Vector;

public class UserListAdapter extends BaseAdapter {

	private static final String TAG = UserListAdapter.class.getName();
	private Activity activity;
	private Vector<Book> items;
	private Dialog dialog_box;
	private LinearLayout right;
	static int post=0;

	LinearLayout linear = null;

	Integer[] imageDoctor = { R.drawable.doct_11, R.drawable.doc1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
			R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
			R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
			R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
			R.drawable.doct_3, R.drawable.doct_4 };

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

	public UserListAdapter(Activity activity, Vector<Book> items,
			Context context) {
		Log.i(TAG, TAG);
		this.activity = activity;
		this.items = items;
		this.context = context;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {

			LayoutInflater inflater = activity.getLayoutInflater();
			convertView = inflater.inflate(R.layout.eventlistview, null);
			holder = new ViewHolder();

			holder.name = (TextView) convertView.findViewById(R.id.drnameTV);
			holder.CLassTV = (TextView) convertView.findViewById(R.id.classTV);
			holder.spcTV = (TextView) convertView.findViewById(R.id.spclTV);

			holder.menudot = (ImageView) convertView.findViewById(R.id.menudot);

			holder.drimageview = (ImageView) convertView
					.findViewById(R.id.childImage);
			linear = (LinearLayout) convertView
					.findViewById(R.id.listitem_test);

			holder.headingLL = (LinearLayout) convertView
					.findViewById(R.id.headingLL);
			holder.headingTV = (TextView) convertView
					.findViewById(R.id.headingTV);
			holder.nameLL = (LinearLayout) convertView
					.findViewById(R.id.nameLL);

//			holder.menudot.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					linear.setBackgroundColor(Color.parseColor("#e0e0e0"));
//					MenuforThreedot menuforThreedot = new MenuforThreedot(
//							context);
//					dialog_box = menuforThreedot.menudialog();
//
//					Window window = dialog_box.getWindow();
//					WindowManager.LayoutParams wmlp = dialog_box.getWindow()
//							.getAttributes();
//					int[] viewLocation = new int[2];
//					v.getLocationOnScreen(viewLocation);
//					wmlp.gravity = Gravity.TOP | Gravity.LEFT;
//					wmlp.x = viewLocation[0];
//					wmlp.y = viewLocation[1];
//					window.setBackgroundDrawable(new ColorDrawable(
//							Color.TRANSPARENT));
//					dialog_box.getWindow().setLayout(450, 570);
//					dialog_box.show();
//					dialog_box.setOnDismissListener(new OnDismissListener() {
//
//						@Override
//						public void onDismiss(DialogInterface dialog) {
//							linear.setBackgroundResource(R.drawable.normalbg);
//
//						}
//					});
//
//				}
//			});

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		
		if (position < items.size()) {

			final Book book = items.get(position);
			if (book != null && (book.getTitle().length() == 1)) {
				holder.nameLL.setVisibility(View.GONE);
				holder.headingLL.setVisibility(View.VISIBLE);
				holder.headingTV.setText(book.getTitle());
				holder.headingLL.setBackgroundColor(Color.TRANSPARENT);
			} else {
				holder.nameLL.setVisibility(View.VISIBLE);
				holder.headingLL.setVisibility(View.GONE);
				holder.name.setText(book.getTitle());
				holder.CLassTV.setText(book.getYear());
				holder.spcTV.setText(book.getAuthor());

				holder.drimageview.setImageResource(imageDoctor[position]);

				View ll = (LinearLayout) holder.name.getParent();
				ll.setFocusable(true);
				ll.setSelected(true);
//				linear.setOnClickListener(new OnClickListener() {
//					@Override
//					public void onClick(View v) {
//
//						Intent intent = new Intent(activity, Physicians.class);
//						activity.startActivity(intent);
//					}
//				});
			}
		}
             
		return convertView;
	}

	private static class ViewHolder {
		TextView name, headingTV, spcTV, CLassTV;
		ImageView drimageview,menudot;
		LinearLayout nameLL, headingLL;
		
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}