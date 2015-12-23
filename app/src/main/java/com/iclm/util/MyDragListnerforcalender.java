package com.iclm.util;

import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnDragListener;

public class MyDragListnerforcalender implements OnDragListener {
	Context context;

	public MyDragListnerforcalender(Context context) {
		this.context = context;
	}

	@Override
	public boolean onDrag(View v, DragEvent event) {
		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:

			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			// v.animate().scaleX(1.5f);
			break;
		case DragEvent.ACTION_DRAG_EXITED:
			// v.setBackgroundDrawable(normalShape);

			break;
		case DragEvent.ACTION_DROP:
			ViewGroup parent = Viewgp.getParent(v);

			// parent of parent

			int chance = parent.indexOfChild(v);
			int parcount = parent.getChildCount();
			View view = (View) event.getLocalState();
			ViewGroup parent2 = Viewgp.getParent(view);

			int chance2 = parent2.indexOfChild(view);
			int parcount1 = parent2.getChildCount();

			View[] vpn = new View[parcount];
			for (int i = 0; i < vpn.length; i++) {
				vpn[i] = parent.getChildAt(i);
			}

			View[] vpn1 = new View[parcount1];
			for (int i = 0; i < vpn1.length; i++) {
				vpn1[i] = parent2.getChildAt(i);
			}

			// if (listclick == 1) {
			// try {
			// Viewgp.replacegrouppartforlisvie(TourPlanActivity.this,
			// vpn[chance], vpn1[chance2]);
			// listclick = 0;
			//
			// adapter = new GridCellAdapter(getApplicationContext(),
			// R.id.calendar_day_gridcell, month, year, null);
			// adapter.notifyDataSetChanged();
			// calendarView.setAdapter(adapter);
			//
			// removeelement(apntime112, postionforlisttoremove);
			//
			// // Customlistadapter adapter1 = new Customlistadapter(
			// // MyCalendarActivity.this, imageDoctor112, array,
			// // drname3112, immagfe112);
			// // ListView.setAdapter(adapter1);
			//
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			//
			// } else {
			try {
				Viewgp.replacegrouppartforlisvie(context, vpn[chance],
						vpn1[chance2]);

			} catch (Exception e) {
				// TODO: handle exception
			}

			// Viewgp.replacegrouppartNew(vpn[chance], vpn1[chance2],
			// chance2,
			// chance);
			// }

			break;
		case DragEvent.ACTION_DRAG_ENDED:

			// v.animate().scaleX(1.0f);

			break;

		default:
			break;
		}
		return true;
	}
}