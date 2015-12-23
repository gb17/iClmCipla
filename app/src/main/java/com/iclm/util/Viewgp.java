package com.iclm.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cirrius.iclmcipla.CalendarClass;
import com.cirrius.iclmcipla.CalendarView;
import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.TimePickerFragment;

public class Viewgp {

	static Typeface font = null;

	private static Dialog dialog_box;

	private static TextView sicklv6;
	private static TextView sicklv8;

	private static TextView edittime;

	private static TextView sicklv7;

	public static ViewGroup getParent(View v) {
		return (ViewGroup) v.getParent();
	}

	public static void removegroup(View v2) {
		ViewGroup vv = getParent(v2);
		if (vv != null) {
			vv.removeView(v2);
		}
	}

	public static void replacegroup(View o, View n) {

		ViewGroup vv = getParent(o);
		if (vv == null) {
			return;
		}

		final int index = vv.indexOfChild(o);
		final int index1 = vv.indexOfChild(n);

		System.out.println("indesss" + index + index1);
		if (index1 < index) {
			removegroup(n);
			removegroup(o);
			vv.addView(o, index1);
			vv.addView(n, index);

		} else {
			removegroup(o);
			removegroup(n);
			vv.addView(n, index);
			vv.addView(o, index1);

		}

	}

	public static void replacegrouppartNew(View o, View n, int min, int max) {

		ViewGroup vv = getParent(o);
		ViewGroup vv1 = getParent(n);

		// Button bt = (Button) vv.getChildAt(0);
		// Button bt2 = (Button) vv1.getChildAt(0);

		if (vv.equals(vv1)) {

			int parcount = vv.getChildCount();

			View[] vpn = new View[parcount];
			for (int i = 0; i < vpn.length; i++) {
				vpn[i] = vv.getChildAt(i);
			}
			final int index = vv.indexOfChild(o);
			final int index1 = vv.indexOfChild(n);
			if (index1 < index) {
				removegroup(n);
				removegroup(o);

				vv.addView(o, index1);
				vv.addView(n, index);

			} else if (index1 > index) {
				removegroup(o);
				removegroup(n);

				vv.addView(n, index);
				vv.addView(o, index1);

			}

			else {
				int min1 = min;
				int min2 = max;
				for (int i = 0; i < parcount; i++) {

					if (min1 <= min2) {
						System.out.println("count" + min1);

						if (min1 != max) {
							View v = vpn[min1 + 1];
							removegroup(v);
							vv.addView(vpn[min1 + 1], min1);
						}

						min1++;
					}
				}

			}
		}

		else {

			int parcount = vv.getChildCount();
			int parcount1 = vv1.getChildCount();

			View[] vpn = new View[parcount];
			View[] vpn1 = new View[parcount1];

			for (int i = 0; i < vpn.length; i++) {
				vpn[i] = vv.getChildAt(i);
			}

			for (int j = 0; j < vpn.length; j++) {
				vpn1[j] = vv1.getChildAt(j);
			}

			final int index = vv.indexOfChild(o);
			final int index1 = vv1.indexOfChild(n);

			// final int index12 = vv1.indexOfChild(o);
			// final int index112 = vv1.indexOfChild(n);

			if (index1 < index) {
				removegroup(n);
				removegroup(o);
				vv.addView(n, index);
				vv1.addView(o, index1);

			} else if (index1 > index) {
				removegroup(n);
				removegroup(o);
				vv.addView(n, index);
				vv1.addView(o, index1);

			} else if (index1 == index) {
				removegroup(n);
				removegroup(o);
				vv.addView(n, index);
				vv1.addView(o, index1);

			}

			else {
				int min1 = min;
				int min2 = max;
				for (int i = 0; i < parcount; i++) {

					if (min1 <= min2) {
						System.out.println("count" + min1);

						if (min1 != max) {
							View v = vpn[min1 + 1];
							removegroup(v);
							vv.addView(vpn[min1 + 1], min1);
						}

						min1++;
					}
				}

			}

		}

	}

	public static void replacegrouppartforlisvie(final Context context,
			final View o, View list) {
		try {
			LinearLayout lin = ((LinearLayout) list);

			LinearLayout exrow = (LinearLayout) lin.getChildAt(0);

			LinearLayout imagling = (LinearLayout) exrow.getChildAt(0);

			ImageView img = (ImageView) imagling.getChildAt(0);

			Drawable src = img.getDrawable();

			LinearLayout textlin = (LinearLayout) exrow.getChildAt(1);

			TextView textView = (TextView) textlin.getChildAt(0);
			String name = textView.getText().toString();

			TextView textView1 = (TextView) textlin.getChildAt(1);
			String name1 = textView1.getText().toString();

			TextView textView2 = (TextView) textlin.getChildAt(2);
			String name2 = textView2.getText().toString();

			String month = Utility.getDate(new java.util.Date());

			RelativeLayout layout = ((RelativeLayout) o);

			TextView day = (TextView) layout.getChildAt(0);

			System.out.println("cal------------->" + (exrow.getChildCount())
					+ "------" + month + "--------------" + name);

			System.out.println("cal------------->"
					+ ((LinearLayout) list).getChildCount());

			dialog_box = new Dialog(context);
			dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);

			dialog_box.setContentView(R.layout.reschduledialog);
			font = Typeface.createFromAsset(context.getAssets(),
					"fontawesome-webfont.ttf");

			EditText edittextDuedate = (EditText) dialog_box
					.findViewById(R.id.edittextDuedate);

			TextView mItemName = (TextView) dialog_box
					.findViewById(R.id.eventsListEventRowText);

			mItemName.setText(name);

			TextView mItemTime = (TextView) dialog_box.findViewById(R.id.time);

			ImageView drImageView = (ImageView) dialog_box
					.findViewById(R.id.dr_image);

			drImageView.setImageDrawable(src);

			TextView mItemPrice = (TextView) dialog_box
					.findViewById(R.id.textViewItemPrice);
			mItemPrice.setText(name1);

			TextView childtextview3 = (TextView) dialog_box
					.findViewById(R.id.childtextview3);

			childtextview3.setText(name2);

			LinearLayout upperlayout = (LinearLayout) dialog_box
					.findViewById(R.id.upperlayout);

			try {
				// upperlayout.removeAllViews();
				// upperlayout.addView(exrow);

			} catch (Exception e) {
				e.printStackTrace();
			}

			edittextDuedate.setText(month);
			TextView close = (TextView) dialog_box.findViewById(R.id.close);

			sicklv6 = (TextView) dialog_box.findViewById(R.id.sicklv6);
			sicklv7 = (TextView) dialog_box.findViewById(R.id.sicklv7);
			sicklv8 = (TextView) dialog_box.findViewById(R.id.sicklv8);

			sicklv6.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					v.setBackgroundResource(R.drawable.copyroundforlayoutcyan);
					sicklv8.setBackgroundResource(R.drawable.round);

				}
			});

			sicklv8.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					v.setBackgroundResource(R.drawable.copyroundforlayoutcyan);
					sicklv6.setBackgroundResource(R.drawable.round);

				}
			});

			edittime = (TextView) dialog_box.findViewById(R.id.edittime);

			edittime.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// show the time picker dialog
					TimePickerFragment newFragment = new TimePickerFragment();
                    CalendarClass.editTextForDate = edittime;
					newFragment.show(((Activity) context).getFragmentManager(),
							"timepicker");

					sicklv7.setBackgroundResource(R.drawable.round);

				}
			});

			sicklv7.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					edittime.setText("--:-- XX");
					v.setBackgroundResource(R.drawable.copyroundforlayoutcyan);

				}
			});

			final EditText ButtonSet = (EditText) dialog_box
					.findViewById(R.id.ButtonSet);

			ButtonSet.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// show the time picker dialog
					dialog_box.dismiss();
					CalendarView cv = new CalendarView(context);
					cv.setVisibility();

				}
			});
			close.setTypeface(font);
			close.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// show the time picker dialog
					dialog_box.dismiss();

				}
			});

			Window window = dialog_box.getWindow();
			window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			dialog_box.getWindow().setLayout(550, 450);

			dialog_box.show();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void replacegrouppart(View o, View n, int min, int max) {

		ViewGroup vv = getParent(o);

		int parcount = vv.getChildCount();
		View[] vpn = new View[parcount];
		for (int i = 0; i < vpn.length; i++) {
			vpn[i] = vv.getChildAt(i);
		}
		final int index = vv.indexOfChild(o);
		final int index1 = vv.indexOfChild(n);
		if (index1 < index) {
			removegroup(n);
			removegroup(o);
			vv.addView(o, index1);
			vv.addView(n, index);

		} else {
			int min1 = min;
			int min2 = max;
			for (int i = 0; i < parcount; i++) {

				if (min1 <= min2) {
					System.out.println("count" + min1);

					// if(min1== max)
					// {
					// // View v=vpn[min1];
					// // removegroup(v);
					// // vv.addView(vpn[min], min1);
					// }
					if (min1 != max) {
						View v = vpn[min1 + 1];
						removegroup(v);
						vv.addView(vpn[min1 + 1], min1);
					}

					min1++;
				}
			}

		}
	}

	public static void swtichlayoutingroup(View o, View n, int min, int max) {

		ViewGroup vv = getParent(o);
		ViewGroup vv1 = getParent(n);

		if (vv.equals(vv1)) {

			int parcount = vv.getChildCount();

			View[] vpn = new View[parcount];
			for (int i = 0; i < vpn.length; i++) {
				vpn[i] = vv.getChildAt(i);
			}
			final int index = vv.indexOfChild(o);
			final int index1 = vv.indexOfChild(n);
			if (index1 < index) {
				removegroup(n);
				removegroup(o);

				vv.addView(o, index1);
				vv.addView(n, index);

			} else if (index1 > index) {
				removegroup(o);
				removegroup(n);

				vv.addView(n, index);
				vv.addView(o, index1);

			}

			else {
				int min1 = min;
				int min2 = max;
				for (int i = 0; i < parcount; i++) {

					if (min1 <= min2) {
						System.out.println("count" + min1);

						if (min1 != max) {
							View v = vpn[min1 + 1];
							removegroup(v);
							vv.addView(vpn[min1 + 1], min1);
						}

						min1++;
					}
				}

			}
		}

		else {

			int parcount = vv.getChildCount();
			int parcount1 = vv1.getChildCount();

			View[] vpn = new View[parcount];
			View[] vpn1 = new View[parcount1];

			for (int i = 0; i < vpn.length; i++) {
				vpn[i] = vv.getChildAt(i);
			}

			for (int j = 0; j < vpn.length; j++) {
				vpn1[j] = vv1.getChildAt(j);
			}

			final int index = vv.indexOfChild(o);
			final int index1 = vv1.indexOfChild(n);

			// final int index12 = vv1.indexOfChild(o);
			// final int index112 = vv1.indexOfChild(n);

			if (index1 < index) {
				removegroup(n);
				removegroup(o);
				vv.addView(n, index);
				vv1.addView(o, index1);

			} else if (index1 > index) {
				removegroup(n);
				removegroup(o);
				vv.addView(n, index);
				vv1.addView(o, index1);

			} else if (index1 == index) {
				removegroup(n);
				removegroup(o);
				vv.addView(n, index);
				vv1.addView(o, index1);

			}

			else {
				int min1 = min;
				int min2 = max;
				for (int i = 0; i < parcount; i++) {

					if (min1 <= min2) {
						System.out.println("count" + min1);

						if (min1 != max) {
							View v = vpn[min1 + 1];
							removegroup(v);
							vv.addView(vpn[min1 + 1], min1);
						}

						min1++;
					}
				}

			}

		}

	}

}