package com.cirrius.iclmcipla;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.idunnololz.widgets.AnimatedExpandableListView;
import com.idunnololz.widgets.AnimatedExpandableListView.AnimatedExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListComponentForCal {

    private AnimatedExpandableListView listView;
    private ExampleAdapter adapter;

    Context context;

    private RelativeLayout relativeLayout;
    private String[] headerText;
    String[] secondHeaderTitle;
    String[] secondHeaderVisibilty;

    String[][] drdatewise;
    String[][] spec;

    /**
     * Variable to be use for headers
     */

    public TextView secondHeader;

    public ListComponentForCal(Context context, String headerText[],
                               String[] secondHeaderTitle, String[] secondHeaderVisibilty,
                               String[][] drdatewise, String[][] spec) {
        this.context = context;
        this.headerText = headerText;
        this.secondHeaderTitle = secondHeaderTitle;
        this.secondHeaderVisibilty = secondHeaderVisibilty;
        secondHeader = new TextView(context);
        this.drdatewise = drdatewise;
        this.spec = spec;

    }

    public View getcompoentView() {
        List<GroupItem> items = new ArrayList<GroupItem>();

        // Populate our list with groups and it's children
        for (int i = 0; i < headerText.length; i++) {
            GroupItem item = new GroupItem();

            item.title = headerText[i];
            item.days = "" + secondHeaderVisibilty[i];

            for (int j = 0; j < drdatewise[i].length; j++) {
                ChildItem child = new ChildItem();
                child.title1String = drdatewise[i][j];
                child.title2String = spec[i][j];
                child.title3String = "Class A";
                child.title4String = "Mumbai";
                item.items.add(child);
            }

            items.add(item);
        }

        adapter = new ExampleAdapter(context);
        adapter.setData(items);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        relativeLayout = (RelativeLayout) inflater.inflate(
                R.layout.activity_main_gbforsepc, null);
        listView = (AnimatedExpandableListView) relativeLayout
                .findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // In order to show animations, we need to use a custom click handler
        // for our ExpandableListView.
        listView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (listView.isGroupExpanded(groupPosition)) {

                    listView.collapseGroupWithAnimation(groupPosition);
                } else {

                    listView.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });

        listView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(context, "Ho gaya", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return relativeLayout;

    }

    /**
     * Adapter for our list of {@link GroupItem}s.
     */
    private class ExampleAdapter extends AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        public ExampleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void setData(List<GroupItem> items) {
            this.items = items;
        }

        @Override
        public ChildItem getChild(int groupPosition, int childPosition) {
            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder holder;
            ChildItem item = getChild(groupPosition, childPosition);
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = inflater.inflate(R.layout.child_view_calfor,
                        parent, false);
                holder.title1 = (TextView) convertView
                        .findViewById(R.id.childtextview1);
                holder.title2 = (TextView) convertView
                        .findViewById(R.id.childtextview2);
                holder.title3 = (TextView) convertView
                        .findViewById(R.id.childtextview3);
                holder.title4 = (TextView) convertView
                        .findViewById(R.id.childtextview4);
                convertView.setTag(holder);

            } else {
                holder = (ChildHolder) convertView.getTag();
            }

            holder.title1.setText(item.title1String);
            holder.title2.setText(item.title2String);
            holder.title3.setText(item.title3String);
            holder.title4.setText(item.title4String);

            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailingPageV2.class);
                    intent.putExtra("getclose", "1");
                    context.startActivity(intent);

                }
            });

            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return items.get(groupPosition).items.size();
        }

        @Override
        public GroupItem getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            GroupHolder holder;
            GroupItem item = getGroup(groupPosition);
            if (convertView == null) {
                holder = new GroupHolder();
                convertView = inflater.inflate(R.layout.parent_view, parent,
                        false);
                holder.title = (TextView) convertView
                        .findViewById(R.id.headertextview);
                holder.patches = (TextView) convertView
                        .findViewById(R.id.headertextview2223);
                holder.count = (TextView) convertView
                        .findViewById(R.id.headertextview223);

                holder.days = (TextView) convertView
                        .findViewById(R.id.headertextview2);

                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            holder.days.setText(item.days);
            int countD = getChildrenCount(groupPosition);
            holder.count.setText("" + countD);
            holder.patches.setText("1");
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }

    }

    private static class GroupItem {
        String title;
        String days;
        String secondHeaderTitle;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title1String;
        String title2String;
        String title3String;
        String title4String;
    }

    private static class ChildHolder {
        TextView title1;
        TextView title2;
        TextView title3;
        TextView title4;
    }

    private static class GroupHolder {
        TextView title;
        TextView patches;
        TextView count;
        TextView days;
    }

    public void secondHeaderClick() {

    }
}
