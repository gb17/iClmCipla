package com.cirrius.iclmcipla;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<String[]> originalData = null;
    List<String[]> filteredData = null;
    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
            R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
            R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
            R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
            R.drawable.doct_4, R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4,
            R.drawable.doc1, R.drawable.doct_1, R.drawable.doct_2,
            R.drawable.doct_3, R.drawable.doct_4, R.drawable.doc1,
            R.drawable.doct_1, R.drawable.doct_2, R.drawable.doct_3,
            R.drawable.doct_4};
    Context context;
    private ItemFilter mFilter = new ItemFilter();
    private Typeface font;
    int index = 0;

    public CustomAdapter(Context context, List<String[]> dataList, int index) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.filteredData = dataList;
        this.originalData = dataList;
        this.index = index;
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
            convertView = inflater.inflate(R.layout.custom_list, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.speciality = (TextView) convertView
                    .findViewById(R.id.speciality);
            holder.drclass = (TextView) convertView.findViewById(R.id.dr_class);

            holder.drimage = (ImageView) convertView
                    .findViewById(R.id.dr_image);
            TextView tick = (TextView) convertView.findViewById(R.id.tick);

            if (index == 1) {
                tick.setVisibility(View.VISIBLE);
            } else if (index == 2) {
                tick.setVisibility(View.VISIBLE);
                tick.setText(context.getResources().getString(
                        R.string.icon_dustbin));
            }
            tick.setTypeface(font);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.drimage.setImageResource(imageDoctor[position]);
        String[] str = filteredData.get(position);
        holder.name.setText(str[0]);
        holder.speciality.setText(str[1]);
        holder.drclass.setText(str[2]);
        if (index == 2) {
            holder.name.setTextColor(Color.BLACK);
            holder.speciality.setTextColor(Color.BLACK);
            holder.drclass.setTextColor(Color.BLACK);
        }
        return convertView;

    }

    static class ViewHolder {

        public TextView name;
        public TextView speciality;
        public TextView drclass;
        public ImageView drimage;

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
                strData.add(str[0]);
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
                    if (str[0].equalsIgnoreCase(fdata.get(i)))
                        filteredData.add(originalData.get(j));
                }

            }
            notifyDataSetChanged();
        }

    }

}
