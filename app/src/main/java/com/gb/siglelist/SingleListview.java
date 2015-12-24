package com.gb.siglelist;

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

    public View getviewsSigleExpandalelistview(int mode) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RelativeLayout relativeforexapandable = (RelativeLayout) inflater.inflate(
                R.layout.singleexplist, null);

        expListView = (ExpandableListView) relativeforexapandable
                .findViewById(R.id.lvExp);
        prepareListData(mode);

        listAdapter = new ExpandableListAdapter(context, listDataHeader, listDataChild,mode);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        for (int i = 0; i < listAdapter.getGroupCount(); i++)
            expListView.expandGroup(i);

        expListView.setGroupIndicator(null);

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


        Integer[] totd = {R.drawable.expchk, R.drawable.expcal,
                R.drawable.expleave, R.drawable.exptot, R.drawable.expchk};

        String[] totarr1 = {"Alan Spiegel", "ENT SUMMIT 2015", "Leave",
                "Cyclic Meeting", ""};
        String[] totarr2 = {"BROOKLYN Blvd", "Description about Heart Failure",
                "Casual Leave", "BROOKLYN Blvd", ""};
        String[] totarr3 = {"BIRTHDAY", "Brooklyn", "", "", ""};

        // Adding child data
        listDataHeader.add("21-DEC-MON");
        listDataHeader.add("24-DEC-TUE");
        listDataHeader.add("27-DEC-WED");
        listDataHeader.add("31-DEC-THU");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        if (mode == 1)
            top250.add("Leave \nSick Leave");
        else {
            top250.add("Cyclic Meeting ");
        }


        List<String> nowShowing = new ArrayList<String>();
        if (mode == 1)
            nowShowing.add("Leave \nCasual Leave");
        else {
            nowShowing.add("Selling skills development");
        }
        //   nowShowing.add("Selling Skills Program \nDigital\n ");


        List<String> comingSoon = new ArrayList<String>();
        if (mode == 1)
            comingSoon.add("Leave \nSick Leave");
        else {


            comingSoon.add("Cyclic Meeting ");
            comingSoon.add("ENT SUMMIT 2015");


        }


        List<String> newwww = new ArrayList<String>();
        if (mode == 1)
            newwww.add("Leave \nCasual Leave");
        else {
            newwww.add("Sales Program");
        }


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), newwww);

    }
}