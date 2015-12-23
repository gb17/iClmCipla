package com.cirrius.animationlist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;

import java.util.ArrayList;

/**
 * This application creates a listview where the ordering of the data set can be
 * modified in response to user touch events.
 * 
 * An item in the listview is selected via a long press event and is then moved
 * around by tracking and following the movement of the user's finger. When the
 * item is released, it animates to its new position within the listview.
 */
public class ListViewDraggingAnimation {

	private RelativeLayout relativeforexapandable;
	Typeface font;

	Context context;
	private RelativeLayout relativeforexapandable1;

	public ListViewDraggingAnimation(Context context) {
		this.context = context;
	}

	public View multilevleexpandalelistview(int indexField) {

		font = Typeface.createFromAsset(context.getAssets(),
				"fontawesome-webfont.ttf");
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		relativeforexapandable = (RelativeLayout) inflater.inflate(
				R.layout.dd_activity_list_view, null);

		ArrayList<String> mCheeseList = new ArrayList<String>();
		for (int i = 0; i < ListItem.sCheeseStrings.length; ++i) {
			mCheeseList.add(ListItem.sCheeseStrings[i]);
		}
		LayoutInflater inflater1 = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		relativeforexapandable1 = (RelativeLayout) inflater1.inflate(
				R.layout.dd_exrow_third, null);

		TextView textView = (TextView) relativeforexapandable1
				.findViewById(R.id.eventsListEventRowText);

		StableArrayAdapter adapter = new StableArrayAdapter(context,
				R.id.eventsListEventRowText, mCheeseList);
		DynamicListView listView = (DynamicListView) relativeforexapandable
				.findViewById(R.id.listview);

		listView.setCheeseList(mCheeseList);
		listView.setAdapter(adapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		return relativeforexapandable;

	}

}
