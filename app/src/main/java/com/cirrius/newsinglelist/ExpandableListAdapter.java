package com.cirrius.newsinglelist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    Integer[] images = {R.drawable.classroom, R.drawable.digital, R.drawable.fieldwork};

    String[] arrayfordialog = {"Trainee Name", "Rohit Sksena", "Duration", "3 hr", "Start Date", "21 Dec",
            "End Date", "21 Dec", "Topic", "Soft Skills ,Personality Development,Effective Interaction", "Training sub type", "Beginner"};

    String[] arrayfordialog1 = {"Program Name", "Selleing Skills Developement", "Duration", "35 Min", "Start Date", "22 Dec",
            "End Date", "24 Dec", "Topic", "Rapport Building on the Call,Strategic Prospecting Skills,Time Management,Objection Handling,Gaining Comment,Post-Sale Relationship Management", ""};

    String[] arrayfordialog2 = {"Program Name",
            "Manager development program",
            "Duration",
            "1 Day",
            "Start date",
            "24-Dec",
            "End date",
            "24-Dec",
            "Topic",
            "Techniques of mangerial skills",
            "Training Sub type",
            " Intermediate", "", "", "", ""
    };





    String[] arrayfordialog4 = {"Program Name",
            "Field work training",
            "Duration",
            "1 Day",
            "Start date",
            "24-Dec",
            "End date",
            "24-Dec",
            "Field work with Manager",
            " Yusuf Khan",
            "Patch",
            " J B Nagar ,Andheri -E",
            "Topic",
            "Product knowledge,Buyer-seller agreement,Active listening,Communication,Qualification,Questioning,Objection Prevention", "", "", "", ""};

    String[] arrayfordialog5 = {
            " Program Name",
            "Selling skills development",
            "Duration",
            " 35 Min",
            "Start date",
            "22-Dec",
            "End date",
            "22-Dec",
            "Topic",
            "Report building on call.,stratergic prospecting skills,Time management,objection handling,gaining commitment,post sale relationship management"
            , "", "", "", ""

    };


    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;
    private TextView text7;
    private TextView text8;
    private TextView text9;
    private TextView text10;
    private TextView text11;
    private TextView text12;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2015-12-17 12:41:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */


    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.childitem_pre, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.eventsListEventRowText);

        txtListChild.setText(childText);
        if((groupPosition == 0 && childPosition == 0) ||(groupPosition == 0 && childPosition == 2 )){
            txtListChild.setBackgroundColor(Color.parseColor("#00FFFF"));
        }else if(groupPosition == 1 || groupPosition == 2){
            txtListChild.setBackgroundColor(Color.parseColor("#00FFFF"));
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.groupitem_pre, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.headertextviewformonth);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
