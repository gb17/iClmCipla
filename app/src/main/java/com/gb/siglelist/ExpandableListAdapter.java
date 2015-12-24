package com.gb.siglelist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cirrius.iclmcipla.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

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
            "Report building on call.stratergic prospecting skills,Time management,objection handling,gaining commitment,post sale relationship management"
            , "", "", "", ""

    };


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
    int _index;

    Integer[] images = {R.drawable.classroom, R.drawable.digital, R.drawable.fieldwork};

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData, int index) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this._index = index;
    }

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
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.childitem, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.eventsListEventRowText);

        ImageView imageView = (ImageView) convertView
                .findViewById(R.id.dr_image);

        if (_index == 1) {
            imageView.setImageResource(R.drawable.expleave);
        } else {
            if (groupPosition == 0 && childPosition == 0)
                imageView.setImageResource(R.drawable.expcal);
            else if (groupPosition == 1 && childPosition == 0)
                imageView.setImageResource(R.drawable.exptot);
            else if (groupPosition == 2 && childPosition == 0)
                imageView.setImageResource(R.drawable.expchk);
            else if (groupPosition == 2 && childPosition == 1)
                imageView.setImageResource(R.drawable.exptot);
            else {
                imageView.setImageResource(R.drawable.exptot);
            }
        }
     /*   )*/


        txtListChild.setText(childText);
       /* TextView drmenu = (TextView) convertView
                .findViewById(R.id.menufordr);
        drmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog_box = new Dialog(_context);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(R.layout.infodilaog);

                text1 = (TextView) dialog_box.findViewById(R.id.text1);
                text2 = (TextView) dialog_box.findViewById(R.id.text2);
                text3 = (TextView) dialog_box.findViewById(R.id.text3);
                text4 = (TextView) dialog_box.findViewById(R.id.text4);
                text5 = (TextView) dialog_box.findViewById(R.id.text5);
                text6 = (TextView) dialog_box.findViewById(R.id.text6);
                text7 = (TextView) dialog_box.findViewById(R.id.text7);
                text8 = (TextView) dialog_box.findViewById(R.id.text8);
                text9 = (TextView) dialog_box.findViewById(R.id.text9);
                text10 = (TextView) dialog_box.findViewById(R.id.text10);
                text11 = (TextView) dialog_box.findViewById(R.id.text11);
                text12 = (TextView) dialog_box.findViewById(R.id.text12);

                if (groupPosition == 2 && childPosition == 0) {
                    text1.setText(arrayfordialog4[0]);
                    text2.setText(arrayfordialog4[1]);
                    text3.setText(arrayfordialog4[2]);
                    text4.setText(arrayfordialog4[3]);
                    text5.setText(arrayfordialog4[4]);
                    text6.setText(arrayfordialog4[5]);
                    text7.setText(arrayfordialog4[6]);
                    text8.setText(arrayfordialog4[7]);
                    text9.setText(arrayfordialog4[8]);
                    text10.setText(arrayfordialog4[9]);
                    text11.setText(arrayfordialog4[10]);
                    text12.setText(arrayfordialog4[11]);
                } else if (groupPosition == 3) {
                    text1.setText(arrayfordialog2[0]);
                    text2.setText(arrayfordialog2[1]);
                    text3.setText(arrayfordialog2[2]);
                    text4.setText(arrayfordialog2[3]);
                    text5.setText(arrayfordialog2[4]);
                    text6.setText(arrayfordialog2[5]);
                    text7.setText(arrayfordialog2[6]);
                    text8.setText(arrayfordialog2[7]);
                    text9.setText(arrayfordialog2[8]);
                    text10.setText(arrayfordialog2[9]);
                    text11.setText(arrayfordialog2[10]);
                    text12.setText(arrayfordialog2[11]);
                } else if (childPosition == 1) {
                    text1.setText(arrayfordialog5[0]);
                    text2.setText(arrayfordialog5[1]);
                    text3.setText(arrayfordialog5[2]);
                    text4.setText(arrayfordialog5[3]);
                    text5.setText(arrayfordialog5[4]);
                    text6.setText(arrayfordialog5[5]);
                    text7.setText(arrayfordialog5[6]);
                    text8.setText(arrayfordialog5[7]);
                    text9.setText(arrayfordialog5[8]);
                    text10.setText(arrayfordialog5[9]);
                    text11.setText(arrayfordialog5[10]);
                    text12.setText(arrayfordialog5[11]);
                } else {
                    text1.setText(arrayfordialog[0]);
                    text2.setText(arrayfordialog[1]);
                    text3.setText(arrayfordialog[2]);
                    text4.setText(arrayfordialog[3]);
                    text5.setText(arrayfordialog[4]);
                    text6.setText(arrayfordialog[5]);
                    text7.setText(arrayfordialog[6]);
                    text8.setText(arrayfordialog[7]);
                    text9.setText(arrayfordialog[8]);
                    text10.setText(arrayfordialog[9]);
                    text11.setText(arrayfordialog[10]);
                    text12.setText(arrayfordialog[11]);
                }*/
//                    imageView.setImageResource(R.drawable.fieldwork);
//                else if (groupPosition == 3)
//                    imageView.setImageResource(R.drawable.digital);
//                else if (childPosition == 1)
//                    imageView.setImageResource(R.drawable.digital);
//                else if (childPosition == 0)
//                    imageView.setImageResource(R.drawable.classroom);

/*
                Window window = dialog_box.getWindow();

                WindowManager.LayoutParams wmlp = dialog_box.getWindow()
                        .getAttributes();
                int[] viewLocation = new int[2];
                v.getLocationOnScreen(viewLocation);

                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                wmlp.x = viewLocation[0];
                wmlp.y = viewLocation[1];

                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(400, 450);
                dialog_box.show();
            }
        });*/

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
            convertView = infalInflater.inflate(R.layout.groupitem, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.headertextviewformonth);
        TextView DAYNUM = (TextView) convertView
                .findViewById(R.id.eventsListEventRowText);

        TextView DAY = (TextView) convertView
                .findViewById(R.id.headertextview2);
        String[] data = headerTitle.split("-");
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(data[1]);
        DAYNUM.setText(data[0]);
        DAY.setText(data[2]);

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