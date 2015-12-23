package com.gb.formultilist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cirrius.iclmcipla.DetailingPageV2;
import com.cirrius.iclmcipla.R;
import com.gb.formultilist.DataForMultilevelExpandableListView.SubCategory;
import com.gb.formultilist.DataForMultilevelExpandableListView.SubCategory.ItemList;

import java.util.ArrayList;

/**
 * 
 * @author manish
 * 
 */
public class MultiLevelExpandablelistView {

	private ArrayList<DataForMultilevelExpandableListView> pProductArrayList;
	private ArrayList<SubCategory> pSubItemArrayList;
	private ArrayList<SubCategory> pSubItemArrayList2;
	private LinearLayout mLinearListView;
	boolean isFirstViewClick = true;
	boolean isSecondViewClick = true;
	private Context context;
	private ScrollView scrollView;
	private String[] Drname = { "Alan Spiegel", "Alexander Fleming",
			"Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk" };

	Integer[] imageDoctor = { R.drawable.doc1, R.drawable.doct_1,
			R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4 };

	String[] Specialty = { "Nuclear cardiology", "Cardiac electrophysiology",
			"Urologic oncology", "Urologic oncology", "Neuromuscular Medicine" };
	String[] Class = { "Class B", "Class A", "Class C", "Class C", "Class B" };
	String[] TimeArr = { "10:30 am - 01:30 pm", "02:00 pm - 04:00 pm",
			"Class C", "Class C", "Class B", "Class B", "Class B", "Class A",
			"Class B", "Class C", "Class A" };
	private Typeface font;

	public MultiLevelExpandablelistView(Context context) {
		this.context = context;

		// TODO Auto-generated constructor stub
	}

	public View multilevleexpandalelistview() {

		font = Typeface.createFromAsset(context.getAssets(),
				"fontawesome-webfont.ttf");
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		scrollView = (ScrollView) inflater.inflate(
				R.layout.multilevel_activity_main, null);

		mLinearListView = (LinearLayout) scrollView
				.findViewById(R.id.linear_listview);

		ArrayList<ItemList> mItemListArray = new ArrayList<ItemList>();

		String strTime[] = { "10:30 am", "11:00 am", "12:00 am", "12:45 pm",
				"01:30 pm", "Class B", "Class B", "Class A", "Class B",
				"Class C", "Class A" };

		for (int i = 0; i < Drname.length; i++) {
			mItemListArray.add(new ItemList(Drname[i], Specialty[i], Class[i],
					strTime[i]));
		}

		String strTime2[] = { "02:00 pm", "02:30 pm", "03:00 pm", "03:30 pm",
				"03:45 pm", "Class B", "Class B", "Class A", "Class B",
				"Class C", "Class A" };

		ArrayList<ItemList> mItemListArray2 = new ArrayList<ItemList>();
		for (int i = 0; i < Drname.length; i++) {
			mItemListArray2.add(new ItemList(Drname[i], Specialty[i], Class[i],
					strTime2[i]));
		}

		/**
		 * 
		 */
		pSubItemArrayList = new ArrayList<SubCategory>();
		pSubItemArrayList2 = new ArrayList<SubCategory>();
		pSubItemArrayList.add(new SubCategory("Bronx", TimeArr[0],
				mItemListArray));
		pSubItemArrayList2.add(new SubCategory("Brooklyn", TimeArr[0],
				mItemListArray));
		pSubItemArrayList.add(new SubCategory("New York", TimeArr[1],
				mItemListArray2));
		pSubItemArrayList2.add(new SubCategory("Hicksville", TimeArr[1],
				mItemListArray2));
		/**
		 * 
		 */

		pProductArrayList = new ArrayList<DataForMultilevelExpandableListView>();
		pProductArrayList.add(new DataForMultilevelExpandableListView("17",
				pSubItemArrayList));
		pProductArrayList.add(new DataForMultilevelExpandableListView("18",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("19",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("20",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("21",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("22",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("23",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("24",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("25",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("26",
				pSubItemArrayList2));
		pProductArrayList.add(new DataForMultilevelExpandableListView("27",
				pSubItemArrayList2));

		/***
		 * adding item into listview
		 */
		for (int i = 0; i < pProductArrayList.size(); i++) {

			LayoutInflater inflater1 = null;
			inflater1 = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View mLinearView = inflater1.inflate(R.layout.multilevel_row_first,
					null);

			final TextView mProductName = (TextView) mLinearView
					.findViewById(R.id.textViewName);
			final LinearLayout mLinearFirstArrow = (LinearLayout) mLinearView
					.findViewById(R.id.linearFirst);
			final ImageView mImageArrowFirst = (ImageView) mLinearView
					.findViewById(R.id.imageFirstArrow);
			final LinearLayout mLinearScrollSecond = (LinearLayout) mLinearView
					.findViewById(R.id.linear_scroll);
			final TextView threedot = (TextView) mLinearView
					.findViewById(R.id.threedot);
			threedot.setTypeface(font);

			if (isFirstViewClick == false) {
				mLinearScrollSecond.setVisibility(View.GONE);
				mImageArrowFirst.setBackgroundResource(R.drawable.arw_lt);
			} else {
				mLinearScrollSecond.setVisibility(View.VISIBLE);
				mImageArrowFirst.setBackgroundResource(R.drawable.arw_down);
			}

			// mLinearFirstArrow.setOnTouchListener(new OnTouchListener() {
			//
			// @Override
			// public boolean onTouch(View v, MotionEvent event) {
			//
			// if (isFirstViewClick == false) {
			// isFirstViewClick = true;
			// mImageArrowFirst
			// .setBackgroundResource(R.drawable.arw_down);
			// mLinearScrollSecond.setVisibility(View.VISIBLE);
			//
			// } else {
			// isFirstViewClick = false;
			// mImageArrowFirst
			// .setBackgroundResource(R.drawable.arw_lt);
			// mLinearScrollSecond.setVisibility(View.GONE);
			// }
			// return false;
			// }
			// });

			mLinearFirstArrow.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (isFirstViewClick == false) {
						isFirstViewClick = true;
						mImageArrowFirst
								.setBackgroundResource(R.drawable.arw_down);
						mLinearScrollSecond.setVisibility(View.VISIBLE);

					} else {
						isFirstViewClick = false;
						mImageArrowFirst
								.setBackgroundResource(R.drawable.arw_lt);
						mLinearScrollSecond.setVisibility(View.GONE);
					}

				}
			});

			final String name = pProductArrayList.get(i).getpName();
			mProductName.setText(name);

			/**
			 * 
			 */
			for (int j = 0; j < pProductArrayList.get(i).getmSubCategoryList()
					.size(); j++) {

				LayoutInflater inflater2 = null;
				inflater2 = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View mLinearView2 = inflater2.inflate(
						R.layout.multilevel_row_second, null);

				TextView mSubItemName = (TextView) mLinearView2
						.findViewById(R.id.textViewTitle);
				final RelativeLayout mLinearSecondArrow = (RelativeLayout) mLinearView2
						.findViewById(R.id.linearSecond);
				final ImageView mImageArrowSecond = (ImageView) mLinearView2
						.findViewById(R.id.imageSecondArrow);
				final LinearLayout mLinearScrollThird = (LinearLayout) mLinearView2
						.findViewById(R.id.linear_scroll_third);

				TextView textviewtime = (TextView) mLinearView2
						.findViewById(R.id.textViewtime);

				if (isSecondViewClick == false) {
					mLinearScrollThird.setVisibility(View.GONE);
					mImageArrowSecond.setBackgroundResource(R.drawable.arw_lt);
				} else {
					mLinearScrollThird.setVisibility(View.VISIBLE);
					mImageArrowSecond
							.setBackgroundResource(R.drawable.arw_down);
				}

				mLinearSecondArrow.setOnTouchListener(new OnTouchListener() {

					@Override
					public boolean onTouch(View v, MotionEvent event) {

						if (isSecondViewClick == false) {
							isSecondViewClick = true;
							mImageArrowSecond
									.setBackgroundResource(R.drawable.arw_down);
							mLinearScrollThird.setVisibility(View.VISIBLE);

						} else {
							isSecondViewClick = false;
							mImageArrowSecond
									.setBackgroundResource(R.drawable.arw_lt);
							mLinearScrollThird.setVisibility(View.GONE);
						}
						return false;
					}
				});

				final String catName = pProductArrayList.get(i)
						.getmSubCategoryList().get(j).getpSubCatName();
				final String catTime = pProductArrayList.get(i)
						.getmSubCategoryList().get(j).getpSubCatTime();
				mSubItemName.setText(catName);
				textviewtime.setText(catTime);
				/**
				 * 
				 */
				for (int k = 0; k < pProductArrayList.get(i)
						.getmSubCategoryList().get(j).getmItemListArray()
						.size(); k++) {

					LayoutInflater inflater3 = null;
					inflater3 = (LayoutInflater) context
							.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					View mLinearView3 = inflater3.inflate(
							R.layout.multilevele_row_third, null);

					final LinearLayout layout = (LinearLayout) mLinearView3
							.findViewById(R.id.childiewoflist);
					layout.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							Intent intent = new Intent(context,
									DetailingPageV2.class);
							intent.putExtra("KT", "1");
							context.startActivity(intent);

						}
					});

					TextView mItemName = (TextView) mLinearView3
							.findViewById(R.id.textViewItemName);

					TextView mItemTime = (TextView) mLinearView3
							.findViewById(R.id.time);

					ImageView drImageView = (ImageView) mLinearView3
							.findViewById(R.id.dr_image);
					TextView mItemPrice = (TextView) mLinearView3
							.findViewById(R.id.textViewItemPrice);

					TextView childtextview3 = (TextView) mLinearView3
							.findViewById(R.id.childtextview3);

					TextView menufordr = (TextView) mLinearView3
							.findViewById(R.id.menufordr);
					menufordr.setTypeface(font);
					TextView playicon = (TextView) mLinearView3
							.findViewById(R.id.playicon);
					playicon.setTypeface(font);

					final String itemName = pProductArrayList.get(i)
							.getmSubCategoryList().get(j).getmItemListArray()
							.get(k).getItemName();
					final String itemPrice = pProductArrayList.get(i)
							.getmSubCategoryList().get(j).getmItemListArray()
							.get(k).getItemPrice();

					final String itemClass = pProductArrayList.get(i)
							.getmSubCategoryList().get(j).getmItemListArray()
							.get(k).getItemClass();
					final String itemTime = pProductArrayList.get(i)
							.getmSubCategoryList().get(j).getmItemListArray()
							.get(k).getItemTime();

					mItemName.setText(itemName);
					mItemTime.setText(itemTime);
					mItemPrice.setText(itemPrice);
					childtextview3.setText(itemClass);

					drImageView.setImageResource(imageDoctor[k]);
					menufordr.setOnClickListener(new OnClickListener() {

						private Dialog dialog_box;

						@Override
						public void onClick(View v) {

							layout.setBackgroundColor(Color
									.parseColor("#e0e0e0"));
							// Intent intent = new Intent(Landingpage.this,
							// Rough.class);
							// startActivity(intent);
							dialog_box = new Dialog(context);

							dialog_box
									.setOnDismissListener(new OnDismissListener() {

										@Override
										public void onDismiss(
												DialogInterface dialog) {
											layout.setBackgroundResource(R.drawable.normalbg);

										}
									});
							dialog_box
									.requestWindowFeature(Window.FEATURE_NO_TITLE);
							dialog_box
									.setContentView(R.layout.landinfpagepopup);

							// dialog_box

							Window window = dialog_box.getWindow();

							WindowManager.LayoutParams wmlp = dialog_box
									.getWindow().getAttributes();

							wmlp.gravity = Gravity.TOP | Gravity.LEFT;
							wmlp.x = 250; // x position
							wmlp.y = 120;

							window.setBackgroundDrawable(new ColorDrawable(
									Color.TRANSPARENT));
							dialog_box.getWindow().setLayout(400, 650);
							dialog_box.show();
						}
					});

					mLinearScrollThird.addView(mLinearView3);
				}

				mLinearScrollSecond.addView(mLinearView2);

			}

			mLinearListView.addView(mLinearView);
		}

		return scrollView;
	}
}
