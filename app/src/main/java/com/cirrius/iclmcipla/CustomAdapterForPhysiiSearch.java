package com.cirrius.iclmcipla;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iclm.util.MenuforThreedot;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterForPhysiiSearch extends BaseAdapter {
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
    String filterStr = "";

    public CustomAdapterForPhysiiSearch(Context context, List<String[]> dataList) {
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
            convertView = inflater.inflate(R.layout.physii_custom_list, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.speciality = (TextView) convertView
                    .findViewById(R.id.speciality);
            holder.drclass = (TextView) convertView.findViewById(R.id.dr_class);

            holder.drimage = (ImageView) convertView
                    .findViewById(R.id.dr_image);
            TextView menufordr = (TextView) convertView
                    .findViewById(R.id.menufordr);
            holder.newTxt1 = (TextView) convertView.findViewById(R.id.newtxt1);
            menufordr.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    MenuforThreedot menuforThreedot = new MenuforThreedot(
                            context);
                    Dialog dialog_box = menuforThreedot.menudialog();

                    Window window = dialog_box.getWindow();
                    WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                            .getAttributes();
                    int[] viewLocation = new int[2];
                    v.getLocationOnScreen(viewLocation);
                    wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                    wmlp.x = viewLocation[0];
                    wmlp.y = viewLocation[1];
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    dialog_box.getWindow().setLayout(450, 570);
                    dialog_box.show();
                }
            });
            LinearLayout childiewoflist = (LinearLayout) convertView
                    .findViewById(R.id.childiewoflist);
            childiewoflist.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(context, Physicians.class);
                    context.startActivity(intent);
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.drimage.setImageResource(imageDoctor[position]);
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

                holder.name.setText(Html.fromHtml(first + second + third));
                flag = true;
            }
        }
        if (flag == false)
            holder.name.setText(str[0]);

        boolean flag2 = false;
        if (!filterStr.equals("")) {
            String newTx = "Speciality > Cardiology";
            if (newTx.toLowerCase().contains(filterStr)) {
                int start = newTx.toLowerCase().indexOf(filterStr);
                int last = filterStr.length();
                String first = newTx.substring(0, start);
                String second = "<font color='#EEEE00'>"
                        + newTx.substring(start, start + last) + "</font>";
                String third = "";
                if (newTx.length() > (start + last - 1))
                    third = newTx.substring(start + last, newTx.length());

                holder.newTxt1.setText(Html.fromHtml(first + second + third));
                flag2 = true;
            }
        }
        if (flag2 == false)
            holder.newTxt1.setText("Speciality > Cardiology");

        holder.speciality.setText(str[1]);
        holder.drclass.setText(str[2]);
        return convertView;

    }

    static class ViewHolder {

        public TextView name;
        public TextView speciality;
        public TextView drclass;
        public ImageView drimage;
        public TextView newTxt1;

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
