package com.cirrius.events;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;

import java.util.ArrayList;
import java.util.List;

public class EventsAdapter extends BaseAdapter {
	List<String[]> originalData = null;
	List<String[]> filteredData = null;

	Context context;
	private ItemFilter mFilter = new ItemFilter();
	private Typeface font;
	String filterStr = "";

	public EventsAdapter(Context context, List<String[]> dataList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.filteredData = dataList;
		this.originalData = dataList;
		font = Typeface.createFromAsset(context.getAssets(),
				"fontawesome-webfont.ttf");
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return filteredData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.events_list, null);

			holder = new ViewHolder();
			holder.txt1 = (TextView) convertView.findViewById(R.id.txt1);
			holder.txt2 = (TextView) convertView.findViewById(R.id.txt2);
			holder.txt3 = (TextView) convertView.findViewById(R.id.txt3);
			holder.sign1 = (TextView) convertView.findViewById(R.id.sign1);
			holder.sign2 = (TextView) convertView.findViewById(R.id.sign2);
			LinearLayout childiewoflist = (LinearLayout) convertView
					.findViewById(R.id.linear);
			childiewoflist.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(context, EventTabs.class);
					context.startActivity(intent);
				}
			});
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		String[] str = filteredData.get(position);

		boolean flag = false;
		if (!filterStr.equals("")) {
			String name = str[0];
			if (name.toLowerCase().contains(filterStr)) {
				int start = name.toLowerCase().indexOf(filterStr);
				int last = filterStr.length();
				String first = name.substring(0, start);
				String second = "<font color='#EEEE00'>"
						+ name.substring(start, start + last) + "</font>";
				String third = "";
				if (name.length() > (start + last - 1))
					third = name.substring(start + last, name.length());

				holder.txt1.setText(Html.fromHtml(first + second + third));
				flag = true;
			}
		}
		if (flag == false)
			holder.txt1.setText(str[0]);

		holder.txt2.setText(str[1]);
		holder.txt3.setText(str[2]);

		holder.sign1.setTypeface(font);
		holder.sign2.setTypeface(font);

		if (position == 0) {
			holder.sign1.setVisibility(View.VISIBLE);
			holder.sign1.setText(R.string.icon_tick);
			holder.sign1.setTextSize(20);
			holder.sign1.setTextColor(Color.YELLOW);
			holder.sign2.setVisibility(View.VISIBLE);
			holder.sign2.setText(R.string.icon_tick);
			holder.sign2.setTextSize(20);
			holder.sign2.setTextColor(Color.CYAN);
		} else if (position == 1 || position == 4) {
			holder.sign1.setVisibility(View.INVISIBLE);
			holder.sign1.setText(R.string.icon_tick);
			holder.sign1.setTextSize(20);
			holder.sign1.setTextColor(Color.YELLOW);
			holder.sign2.setVisibility(View.VISIBLE);
			holder.sign2.setText(R.string.icon_exclaim);
			holder.sign2.setTextSize(20);
			holder.sign2.setTextColor(Color.RED);
		} else if (position == 2 || position == 3) {
			holder.sign1.setVisibility(View.VISIBLE);
			holder.sign1.setText("85");
			holder.sign1.setTextSize(14);
			holder.sign1.setTextColor(Color.WHITE);
			holder.sign2.setVisibility(View.VISIBLE);
			holder.sign2.setText(R.string.icon_user);
			holder.sign2.setTextSize(20);
			holder.sign2.setTextColor(Color.GREEN);
		} else {
			holder.sign1.setVisibility(View.INVISIBLE);
			holder.sign1.setText("85");
			holder.sign1.setTextSize(20);
			holder.sign1.setTextColor(Color.WHITE);
			holder.sign2.setVisibility(View.INVISIBLE);
			holder.sign2.setText(R.string.icon_user);
			holder.sign2.setTextSize(20);
			holder.sign2.setTextColor(Color.GREEN);
		}

		return convertView;

	}

	static class ViewHolder {
		public TextView txt1;
		public TextView txt2;
		public TextView txt3;
		public TextView sign1;
		public TextView sign2;

	}

	public Filter getFilter() {
		return mFilter;
	}

	private class ItemFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {

			String filterString = constraint.toString().toLowerCase();

			FilterResults results = new FilterResults();
			List<String> strData = new ArrayList<String>();

			for (int i = 0; i < originalData.size(); i++) {
				String str[] = originalData.get(i);
				strData.add(str[0] + " " + str[1] + " " + str[2]);
			}

			final List<String> list = strData;

			int count = list.size();
			final ArrayList<String> nlist = new ArrayList<String>(count);

			String filterableString;

			for (int i = 0; i < count; i++) {
				filterableString = list.get(i);
				if (filterableString.toLowerCase().contains(filterString)) {
					nlist.add(filterableString);
				}
			}
			filterStr = filterString;
			results.values = nlist;
			results.count = nlist.size();

			return results;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			ArrayList<String> fdata = (ArrayList<String>) results.values;
			filteredData = new ArrayList<String[]>();

			for (int i = 0; i < fdata.size(); i++) {
				for (int j = 0; j < originalData.size(); j++) {
					String str[] = originalData.get(j);
					String newStr = str[0] + " " + str[1] + " " + str[2];
					if (newStr.equalsIgnoreCase(fdata.get(i)))
						filteredData.add(originalData.get(j));
				}

			}
			notifyDataSetChanged();
		}

	}
}
