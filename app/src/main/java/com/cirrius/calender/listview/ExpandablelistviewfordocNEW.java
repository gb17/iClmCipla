package com.cirrius.calender.listview;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cirrius.calender.listview.DataForMultilevelExpandableListView.SubCategory;
import com.cirrius.iclmcipla.Physicians;
import com.cirrius.iclmcipla.R;
import com.cirrius.map.UserRouteActivity;
import com.iclm.util.MenuforThreedot;
import com.iclm.util.MyDragListnerforcalender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpandablelistviewfordocNEW {
	// public static final int SECOND_LEVEL_COUNT = 2;
	// public static final int THIRD_LEVEL_COUNT = 5;
	private ExpandableListView expandableListView;
	List<Map<String, String>> maingroupData = new ArrayList<Map<String, String>>();
	List<List<Map<String, String>>> maingroupchildData = new ArrayList<List<Map<String, String>>>();
	private ArrayList<SubCategory> pSubItemArrayList;

	private ArrayList<DataForMultilevelExpandableListView> pProductArrayList;

	String[] dateofmonth = null;
	String plandata[] = null;

	String[] dayofmonth = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "MON",
			"TUE", "WED", "THU", "FRI", "SAT", "MON", "TUE" };

	String[] month = { "JULY", "JULY", "JULY", "JULY", "JULY", "JULY", "JULY",
			"JULY", "JULY", "JULY", "JULY", "JULY", "JULY", "JULY" };

	Integer[] totd = { R.drawable.expchk, R.drawable.expcal,
			R.drawable.expleave, R.drawable.exptot, R.drawable.expchk };

	String[] totarr1 = { "Alan Spiegel", "ENT SUMMIT 2015", "Leave",
			"Cyclic Meeting", "" };
	String[] totarr2 = { "BROOKLYN Blvd", "Description about Heart Failure",
			"Casual Leave", "BROOKLYN Blvd", "" };
	String[] totarr3 = { "BIRTHDAY", "Brooklyn", "", "", "" };

	private ParentLevel adapter;
	private Context context;
	private RelativeLayout relativeforexapandable;

	String tablename = "TB3";// TBMTP092015

	DBHandler dbHandler;
	int indexforchk = 22;

	int imagecount = 0;

	// /New CODE FOR EXPANF---------------------------

	private ArrayList<Patch> Patchlist = null;
	private String[] plandatawhere;
	String searchtext;
	Typeface font;
	int count = 1;

	int postionrot = 1;

	String[] todocount = { "3", "2", "1", "4", "2", "2", "1", "3", "1", "2",
			"2", "1", "2", "1" };
	int mode;

	Integer integersof[][] = {
			{ R.drawable.doct_5, R.drawable.doct_1, R.drawable.doct_14,
					R.drawable.doct_10, R.drawable.doct_15 },
			{ R.drawable.doct_7, R.drawable.ulicon, R.drawable.doct_3,
					R.drawable.doct_5, R.drawable.doct_4 },
			{ R.drawable.doct_16, R.drawable.doct_6, R.drawable.doct_5,
					R.drawable.doct_2, R.drawable.doct_11 },
			{ R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
					R.drawable.doct_3, R.drawable.doct_4 },
			{ R.drawable.doct_7, R.drawable.doct_12, R.drawable.doct_3,
					R.drawable.doct_5, R.drawable.doct_4 },

	};

	// /---------------------------------

	public ExpandablelistviewfordocNEW(Context context, String searchtext,
			int mode) {

		this.context = context;
		this.searchtext = searchtext;
		this.mode = mode;

		if (mode == 2) {
			tablename = "TBMTP092015";
			postionrot = 2;
		} else {
			tablename = "TB3";
			postionrot = 1;
		}
		font = Typeface.createFromAsset(context.getAssets(),
				"fontawesome-webfont.ttf");
		dbHandler = DBHandler.getInstance(context);
		String data[][] = dbHandler.genericSelect(
				"select  Distinct COL4,COL5,COl6  from  " + tablename
						+ "  where COL14 like '%" + searchtext
						+ "%' order by cast (COL4 as integer)", 3);

		try {
			dateofmonth = new String[data.length];
			month = new String[data.length];
			dayofmonth = new String[data.length];
			plandata = new String[data.length];
			plandatawhere = new String[data.length];

			for (int i = 0; i < data.length; i++) {
				if (mode == 1) {
					plandatawhere[i] = data[i][0];
					dateofmonth[i] = "";
					month[i] = "";
					dayofmonth[i] = "";
				} else {

					plandatawhere[i] = data[i][0];
					dateofmonth[i] = data[i][0];
					month[i] = data[i][1].toUpperCase();
					dayofmonth[i] = data[i][2].toUpperCase().substring(0, 3);

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public View multilevleexpandalelistview() {
		try {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			relativeforexapandable = (RelativeLayout) inflater.inflate(
					R.layout.expandablistview, null);

			expandableListView = (ExpandableListView) relativeforexapandable
					.findViewById(R.id.mainList);
			expandableListView.setScrollingCacheEnabled(false);
			expandableListView.setAnimationCacheEnabled(false);
			expandableListView.smoothScrollToPosition(0);

			/**
* 
*/
			pSubItemArrayList = new ArrayList<SubCategory>();
			pProductArrayList = new ArrayList<DataForMultilevelExpandableListView>();

			for (int i = 0; i < dateofmonth.length; i++) {
				pProductArrayList.add(new DataForMultilevelExpandableListView(
						dateofmonth[i], month[i], dayofmonth[i],
						pSubItemArrayList));
			}
			adapter = new ParentLevel(context);
			expandableListView.setAdapter(adapter);
			for (int i = 0; i < adapter.getGroupCount(); i++)
				expandableListView.expandGroup(i);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return relativeforexapandable;

	}

	public class ParentLevel extends BaseExpandableListAdapter {

		private Context context;
		private TextView chkcount;

		public ParentLevel(Context context) {
			this.context = context;
		}

		@Override
		public Object getChild(int arg0, int arg1) {
			return arg1;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			SecondLevelExpandableListView secondLevelELV = new SecondLevelExpandableListView(
					context);
			loadSomeData(groupPosition, plandatawhere[groupPosition]);
			SecondLevelAdapter adapter = new SecondLevelAdapter(context);

			secondLevelELV.setDivider(context.getResources().getDrawable(
					R.color.divder));
			secondLevelELV.setChildDivider(context.getResources().getDrawable(
					R.color.divder));
			secondLevelELV.setScrollingCacheEnabled(false);
			secondLevelELV.setAnimationCacheEnabled(false);
			secondLevelELV.setDividerHeight(1);
			secondLevelELV.setAdapter(adapter);

			for (int i = 0; i < adapter.getGroupCount(); i++)
				secondLevelELV.expandGroup(i);
			secondLevelELV.setGroupIndicator(null);
			return secondLevelELV;
		}

		@Override
		public int getChildrenCount(int groupPosition) {

			return postionrot;
		}

		@Override
		public Object getGroup(int groupPosition) {
			return groupPosition;
		}

		@Override
		public int getGroupCount() {
			return pProductArrayList.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {

			ViewHolderItem viewHolder;

			if (convertView == null) {

				LayoutInflater inflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.exrow_first, null);

				viewHolder = new ViewHolderItem();

				if (indexforchk == 22) {
					TextView headertextview2223 = (TextView) convertView
							.findViewById(R.id.headertextview2223);
					headertextview2223.setVisibility(View.VISIBLE);

					headertextview2223.setTypeface(font);

					TextView headertextview223 = (TextView) convertView
							.findViewById(R.id.headertextview223);
					headertextview223.setVisibility(View.VISIBLE);
					chkcount = (TextView) convertView
							.findViewById(R.id.todocount);

					chkcount.setVisibility(View.VISIBLE);

					headertextview223.setTypeface(font);
					headertextview223.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							Intent intent = new Intent(context,
									UserRouteActivity.class);
							context.startActivity(intent);

						}
					});
				}
				viewHolder.textViewItem = (TextView) convertView
						.findViewById(R.id.eventsListEventRowText);

				viewHolder.textViewday = (TextView) convertView
						.findViewById(R.id.headertextview2);

				viewHolder.textViewmonth = (TextView) convertView
						.findViewById(R.id.headertextviewformonth);

				convertView.setTag(viewHolder);

			} else {
				viewHolder = (ViewHolderItem) convertView.getTag();
			}
			final String name = pProductArrayList.get(groupPosition).getpName();
			viewHolder.textViewItem.setText(name);

			final String month = pProductArrayList.get(groupPosition)
					.getMonthName();
			viewHolder.textViewmonth.setText(month);
			ViewHolderItem.grouppostinforTOT = groupPosition;
			final String day = pProductArrayList.get(groupPosition)
					.getDayName();
			viewHolder.textViewday.setText(day);
			if (mode == 1) {
				convertView.setVisibility(View.GONE);
			}

			if (indexforchk == 22)
				chkcount.setText(todocount[groupPosition]);

			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}

	public class SecondLevelExpandableListView extends ExpandableListView {

		public SecondLevelExpandableListView(Context context) {
			super(context);
		}

		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			// 999999 is a size in pixels. ExpandableListView requires a maximum
			// height in order to do measurement calculations.
			heightMeasureSpec = MeasureSpec.makeMeasureSpec(999999999,
					MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
	}

	public class SecondLevelAdapter extends BaseExpandableListAdapter {

		private Context context;

		public SecondLevelAdapter(Context context) {
			this.context = context;
		}

		@Override
		public Object getGroup(int groupPosition) {
			return Patchlist.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return Patchlist.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			ViewHolderForPatch viewHolder;
			Patch continent = (Patch) getGroup(groupPosition);

			if (convertView == null) {
				viewHolder = new ViewHolderForPatch();
				LayoutInflater inflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.exrow_second, null);
				viewHolder.patchname = (TextView) convertView
						.findViewById(R.id.eventsListEventRowText);

				viewHolder.patchtime = (TextView) convertView
						.findViewById(R.id.textViewtime);

				convertView.setTag(viewHolder);

			} else {

				viewHolder = (ViewHolderForPatch) convertView.getTag();

			}
			try {
				String a = continent.getName().trim();
				viewHolder.patchname.setText(a);
				a = continent.getPatchtime().trim();
				viewHolder.patchtime.setText(a);
			} catch (Exception e) {
				// TODO: handle exception
			}

			return convertView;
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			ArrayList<DoctorList> countryList = Patchlist.get(groupPosition)
					.getCountryList();
			return countryList.get(childPosition);
			// return childPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, final int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {

			DoctorList country = (DoctorList) getChild(groupPosition,
					childPosition);
			ViewHolderForDoc viewHolder = null;

			if (convertView == null) {
				viewHolder = new ViewHolderForDoc();
				LayoutInflater inflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.exrow_third, null);

				viewHolder.drname = (TextView) convertView
						.findViewById(R.id.eventsListEventRowText);

				viewHolder.drtime = (TextView) convertView
						.findViewById(R.id.time);

				viewHolder.drtime.setBackgroundColor(Color.TRANSPARENT);

				viewHolder.drImageView = (ImageView) convertView
						.findViewById(R.id.dr_image);
				viewHolder.specality = (TextView) convertView
						.findViewById(R.id.textViewItemPrice);

				viewHolder.drclass = (TextView) convertView
						.findViewById(R.id.childtextview3);

				viewHolder.cakeTextView = (TextView) convertView
						.findViewById(R.id.cake);
				viewHolder.cakeTextView.setTypeface(font);

				TextView menufordr = (TextView) convertView
						.findViewById(R.id.menufordr);

				final LinearLayout layout = (LinearLayout) convertView
						.findViewById(R.id.childiewoflist);
				// menufordr.setTypeface(font);

				layout.setOnDragListener(new MyDragListnerforcalender(context));
				layout.setOnLongClickListener(new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						ClipData data = ClipData.newPlainText("", "");
						DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
								v);
						v.startDrag(data, shadowBuilder, v, 0);
						return true;
					}
				});

				layout.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(context, Physicians.class);
						context.startActivity(intent);

					}
				});

				menufordr.setOnClickListener(new OnClickListener() {

					private Dialog dialog_box;

					@Override
					public void onClick(View v) {
						layout.setBackgroundColor(Color.parseColor("#e0e0e0"));
						MenuforThreedot menuforThreedot = new MenuforThreedot(
								context);
						dialog_box = menuforThreedot.menudialog();

						Window window = dialog_box.getWindow();
						WindowManager.LayoutParams wmlp = dialog_box
								.getWindow().getAttributes();
						int[] viewLocation = new int[2];
						v.getLocationOnScreen(viewLocation);
						wmlp.gravity = Gravity.TOP | Gravity.LEFT;
						wmlp.x = viewLocation[0];
						wmlp.y = viewLocation[1];
						window.setBackgroundDrawable(new ColorDrawable(
								Color.TRANSPARENT));
						dialog_box.getWindow().setLayout(450, 570);
						dialog_box.show();
						dialog_box
								.setOnDismissListener(new OnDismissListener() {

									@Override
									public void onDismiss(DialogInterface dialog) {
										layout.setBackgroundResource(R.drawable.normalbg);

									}
								});
					}
				});

				if (ViewHolderItem.grouppostinforTOT == 3) {
					viewHolder.drImageView
							.setImageResource(totd[childPosition]);
					if (count == 1) {
						viewHolder.cakeTextView.setVisibility(View.VISIBLE);
						count++;
					}

				} else {

					viewHolder.drImageView
							.setImageResource(integersof[groupPosition][childPosition]);

				}

				convertView.setTag(viewHolder);

			} else {
				viewHolder = (ViewHolderForDoc) convertView.getTag();

			}
			try {
				if (ViewHolderItem.grouppostinforTOT == 2) {

					String a = country.getDrtime().trim();
					if (a.equals("N")) {
						viewHolder.drtime.setText("N");
						viewHolder.drtime.setBackgroundColor(Color
								.parseColor("#ff9800"));
						viewHolder.drtime.setPadding(2, 0, 2, 0);

					} else {
						viewHolder.drtime.setBackgroundColor(Color.TRANSPARENT);
					}
					a = totarr1[childPosition];
					viewHolder.drname.setText(a);
					a = totarr2[childPosition];
					viewHolder.specality.setText(a);
					a = totarr3[childPosition];
					viewHolder.drclass.setText(a);

				} else {
					String a = "";
					if (mode == 1) {
						viewHolder.drtime.setText("");
					} else {
						a = country.getDrtime().trim();
						viewHolder.drtime.setText(a);
					}

					a = country.getName().trim();
					viewHolder.drname.setText(a);
					a = country.getCode().trim();
					viewHolder.specality.setText(a);
					a = country.getDrclass().trim();
					viewHolder.drclass.setText(a);
					a = country.getDrtime().trim();
					if (country.getDrtime().trim().equals("N")) {
						viewHolder.drtime.setText("N");
						viewHolder.drtime.setBackgroundColor(Color
								.parseColor("#ff9800"));
						viewHolder.drtime.setPadding(2, 0, 2, 0);

					} else {
						viewHolder.drtime.setBackgroundColor(Color.TRANSPARENT);
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return convertView;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			ArrayList<DoctorList> countryList = Patchlist.get(groupPosition)
					.getCountryList();
			return countryList.size();

		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}

	static class ViewHolderItem {
		TextView textViewItem;
		TextView textViewday;
		TextView textViewmonth;

		static int grouppostinforTOT;
	}

	static class ViewHolderForPatch {
		TextView patchtime;
		TextView patchname;

	}

	static class ViewHolderForDoc {
		TextView drname;
		TextView specality;
		TextView drclass;
		TextView drtime;
		ImageView drImageView;

		TextView cakeTextView;

	}

	private void loadSomeData(int group, String Where) {
		try {

			// 2nd Row data
			// UI 3aug

			// Where = "3-Aug-15";

			String patchname[] = null;
			String[] patchtime = null;

			String[] Drname2 = null;
			String[] Specialty = null;
			String[] Class = null;
			String strTime2[] = null;

			// String[] patchtime = { "10:00 am - 01:00 pm",
			// "02:00 pm - 04:00 pm" };

			String stringdat[][] = dbHandler.genericSelect(
					"SELECT col10 ,Col16 FROM " + tablename + " where col4='"
							+ Where + "'  AND COL14 like '%" + searchtext
							+ "%'  group by col10 limit 2", 2);
			patchname = new String[stringdat.length];
			patchtime = new String[stringdat.length];
			for (int i = 0; i < stringdat.length; i++) {
				patchname[i] = stringdat[i][0];
				if (stringdat[i][1] == null) {
					if (mode == 1) {

					} else
						patchtime[i] = "10:00 AM-05:40 PM";
				} else {
					if (mode == 1) {
						patchtime[i] = "";
					} else
						patchtime[i] = stringdat[i][1];
				}
			}

			// --------------------------------------------------------------

			Patchlist = new ArrayList<Patch>();
			ArrayList<DoctorList> countryList = new ArrayList<DoctorList>();
			ArrayList<ArrayList<DoctorList>> patchgroup = new ArrayList<ArrayList<DoctorList>>(
					4);

			ArrayList<ArrayList<DoctorList>> Doctorgroup = new ArrayList<ArrayList<DoctorList>>(
					4);
			DoctorList country = null;

			for (int i = 0; i < patchtime.length; i++) {

				String stringdatdr[][] = dbHandler.genericSelect(
						"Select * from " + tablename + " where col4='" + Where
								+ "'  AND COL10='" + patchname[i]
								+ "' AND COL14 like '%" + searchtext
								+ "%'   limit 4 ", 17);

				Drname2 = new String[stringdatdr.length];
				Specialty = new String[stringdatdr.length];
				Class = new String[stringdatdr.length];
				strTime2 = new String[stringdatdr.length];

				for (int k = 0; k < stringdatdr.length; k++) {
					Drname2[k] = stringdatdr[k][13];
					Specialty[k] = stringdatdr[k][10];
					Class[k] = stringdatdr[k][7];
					strTime2[k] = stringdatdr[k][11];

				}
				countryList = new ArrayList<DoctorList>();
				for (int j = 0; j < Drname2.length; j++) {

					country = new DoctorList(Specialty[j], Drname2[j],
							10000000, Class[j], strTime2[j]);
					countryList.add(country);
				}

				Doctorgroup.add(i, countryList);
			}

			for (int i = 0; i < patchname.length; i++) {
				patchgroup.add(Doctorgroup.get(i));
			}

			for (int i = 0; i < patchname.length; i++) {
				Patch continent = new Patch(patchname[i], patchtime[i],
						patchgroup.get(i));
				Patchlist.add(continent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
