package com.cirrius.newsinglelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;

import com.cirrius.iclmcipla.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ${GB} on 12/16/15.
 */
public class SingleListview {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    Context context;

    public SingleListview(Context context) {
        this.context = context;

    }

    public View getviewsSigleExpandalelistview(int index) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RelativeLayout relativeforexapandable = (RelativeLayout) inflater.inflate(
                R.layout.singleexplist, null);

        expListView = (ExpandableListView) relativeforexapandable
                .findViewById(R.id.lvExp);


        prepareListData(index);

        expListView.setGroupIndicator(null);

        listAdapter = new ExpandableListAdapter(context, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        for (int i = 0; i < listAdapter.getGroupCount(); i++)
            expListView.expandGroup(i);


        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
                return false;
            }
        });

        return relativeforexapandable;

    }


    private void prepareListData(int mode) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("C-FIX");
        listDataHeader.add("MezzoDrop");
        listDataHeader.add("Acenomoral");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("C-FIX 100mg");
        top250.add("10dew Pill 100mg");

        top250.add("C-FIX 150DT");
        top250.add("10dew Pill 150DT");

        if (mode==22)
            top250.add("Solsuna 150DT");




        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("MezzoDrop 10mg");
        nowShowing.add("MezzoDrop 20mg");
        nowShowing.add("MezzoDrop 30mg");
        nowShowing.add("MezzoDrop 40mg");


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Acenomoral 40GT");
        comingSoon.add("Acenomoral 50GT");
        comingSoon.add("Acenomoral 60GT");
        comingSoon.add("Acenomoral 70GT");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
