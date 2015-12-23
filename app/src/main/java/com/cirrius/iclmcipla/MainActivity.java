package com.cirrius.iclmcipla;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.idunnololz.widgets.AnimatedExpandableListView;
import com.idunnololz.widgets.AnimatedExpandableListView.AnimatedExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {
    private TextView titlename;
    private TextView meter;
    private TextView search;
    private TextView plan;
    private TextView add;
    private TextView conatiner;
    private TextView menu;
    Typeface font;
    private AnimatedExpandableListView explvlist;
    private ExampleAdapter adapter;

    String patch1[] = {"4", "3", "1", "2", "3", "2", "2", "1", "4", "3"};
    String patch2[] = {"2", "2", "1", "4", "3", "4", "3", "1", "2", "3"};
    String patch3[] = {"4", "2", "2", "1", "4", "3", "3", "1", "2", "3"};

    String patch1name[] = {"Bronx", "New York", "Brooklyn", "Brooklyn",
            "Jersey City", "New Brunswick", "Hicksville", "Uniondale",
            "Hempstead", "Brooklyn", "Garden"};
    String patch2name[] = {"Brooklyn", "Brooklyn", "Jersey City",
            "New Brunswick", "Hicksville", "Uniondale", "Hempstead",
            "Brooklyn", "Garden", "Jamaica", "Edison", "Bronx", "New York",};
    String patch3name[] = {"Jamaica", "Edison", "Bronx", "New York",
            "Brooklyn", "Brooklyn", "Jersey City", "New Brunswick",
            "Hicksville", "Uniondale", "Hempstead", "Brooklyn", "Garden"};
    int iee = 0;

    String[][] groupwisepactch = {{"Bronx", "Brooklyn", "Jamaica"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"},
            {"New York", "Brooklyn", "Edison"}};

    // String patfordata=

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2015-08-05 13:37:05 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        findViews();

        List<GroupItem> items = new ArrayList<GroupItem>();

        // Populate our list with groups and it's children
        for (int i = 0; i < 9; i++) {
            GroupItem item = new GroupItem();

            item.title = "1 " + i;
            item.patch1 = patch1[i];
            item.patch2 = patch2[i];
            item.patch3 = patch3[i];

            item.patch1name = patch1name[i];
            item.patch2name = patch2name[i];
            item.patch3name = patch3name[i];

            for (int j = 0; j < 2; j++) {
                ChildItem child = new ChildItem();
                child.title = patch1name[j];
                child.hint = "Too awesome";

                item.items.add(child);
            }

            items.add(item);
        }

        adapter = new ExampleAdapter(this);
        adapter.setData(items);
        explvlist = (AnimatedExpandableListView) findViewById(R.id.listView);

        explvlist.setAdapter(adapter);
        explvlist.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (explvlist.isGroupExpanded(groupPosition)) {
                    explvlist.collapseGroupWithAnimation(groupPosition);
                } else {
                    explvlist.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });

        plan.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        MainForCalforcalenser.class);

                startActivity(intent);
            }
        });
    }

    private void findViews() {
        titlename = (TextView) findViewById(R.id.titlename);
        titlename.setTypeface(font);

        meter = (TextView) findViewById(R.id.meter);
        meter.setTypeface(font);

        search = (TextView) findViewById(R.id.search);
        search.setTypeface(font);

        plan = (TextView) findViewById(R.id.plan);
        plan.setTypeface(font);

        add = (TextView) findViewById(R.id.add);
        add.setTypeface(font);

        conatiner = (TextView) findViewById(R.id.conatiner);
        conatiner.setTypeface(font);

        menu = (TextView) findViewById(R.id.menu);
        menu.setTypeface(font);

        menu.setOnClickListener(this);
    }

    public class CustExpListview extends AnimatedExpandableListView {

        int intGroupPosition, intChildPosition, intGroupid;

        public CustExpListview(Context context) {

            super(context);

        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager manager = getWindowManager();
            // manager.getDefaultDisplay().getWidth();
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(manager
                            .getDefaultDisplay().getWidth(),

                    MeasureSpec.EXACTLY);

            heightMeasureSpec = MeasureSpec.makeMeasureSpec(manager
                            .getDefaultDisplay().getHeight(),

                    MeasureSpec.EXACTLY);

            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        }

    }

    private class ExampleAdapter extends AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        private CustExpListview SecondLevelexplv;

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

            List<GroupItem> items = new ArrayList<GroupItem>();
            LayoutInflater inflater = (LayoutInflater) MainActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.firstchild_view, null);

            // ExpandableListView
            // expandableListView=(ExpandableListView)convertView.findViewById(R.id.expand);
            // // Populate our list with groups and it's children
            for (int i = 0; i < 3; i++) {
                GroupItem item = new GroupItem();

                item.title = patch1name[i] + "abc";

                for (int j = 0; j < 4; j++) {
                    ChildItem child = new ChildItem();
                    child.title = "Awesome item " + j;
                    child.hint = "Too awesome";

                    item.items.add(child);
                }

                items.add(item);
            }

            SecondLevelexplv = new CustExpListview(MainActivity.this);
            ExampleAdapter2 adapter = new ExampleAdapter2(MainActivity.this);
            adapter.setData(items);
            SecondLevelexplv.setAdapter(adapter);

            SecondLevelexplv.setGroupIndicator(null);

            //

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
                convertView = inflater.inflate(R.layout.group_itemforsepc,
                        parent, false);

                View view = convertView.findViewById(R.id.dateview);

                View patclayout = convertView.findViewById(R.id.patchlayout);
                holder.title = (TextView) view.findViewById(R.id.date);
                holder.patch1 = (TextView) patclayout
                        .findViewById(R.id.patch1count);
                holder.patch2 = (TextView) patclayout
                        .findViewById(R.id.patch2count);
                holder.patch3 = (TextView) patclayout
                        .findViewById(R.id.patch3count);

                holder.patch1name = (TextView) patclayout
                        .findViewById(R.id.patch1name);
                holder.patch2name = (TextView) patclayout
                        .findViewById(R.id.patch2name);
                holder.patch3name = (TextView) patclayout
                        .findViewById(R.id.patch3name);

                holder.location = (TextView) convertView
                        .findViewById(R.id.location);
                holder.todoicon = (TextView) convertView
                        .findViewById(R.id.todoicon);

                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            holder.patch1.setText(item.patch1);
            holder.patch2.setText(item.patch2);
            holder.patch3.setText(item.patch3);

            holder.patch1name.setText(item.patch1name);
            holder.patch2name.setText(item.patch2name);
            holder.patch3name.setText(item.patch3name);

            holder.location.setTypeface(font);
            holder.todoicon.setTypeface(font);

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

    private class ExampleAdapter2 extends AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        public ExampleAdapter2(Context context) {
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
            // ChildHolder holder;
            // ChildItem item = getChild(groupPosition, childPosition);
            // if (convertView == null) {
            // holder = new ChildHolder();
            // convertView = inflater.inflate(R.layout.list_itemforsepc,
            // parent, false);
            // holder.title = (TextView) convertView
            // .findViewById(R.id.textTitle);
            // holder.hint = (TextView) convertView
            // .findViewById(R.id.textHint);
            // convertView.setTag(holder);
            // } else {
            // holder = (ChildHolder) convertView.getTag();
            // }
            //
            // holder.title.setText(item.title);
            // holder.hint.setText(item.hint);
            //
            // return convertView;

            LayoutInflater inflater = (LayoutInflater) MainActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.lastchildview, null);

            View view = convertView.findViewById(R.id.abcforheader);
            LinearLayout gbLinearLayout = (LinearLayout) view
                    .findViewById(R.id.todayheader);

            if (childPosition == 0) {
                gbLinearLayout.setVisibility(View.VISIBLE);
            } else {
                gbLinearLayout.setVisibility(View.GONE);
            }
            // View view =
            // convertView.findViewById(R.id.secondlevelparentheader1);
            // TextView tv = (TextView) view.findViewById(R.id.patcname);
            // TextView tv1 = (TextView) view.findViewById(R.id.patchtime);

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

            GroupItem item = getGroup(groupPosition);
            LayoutInflater inflater = (LayoutInflater) MainActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.firstchild_view, null);
            View view = convertView.findViewById(R.id.secondlevelparentheader1);
            TextView tv = (TextView) view.findViewById(R.id.patcname);
            TextView tv1 = (TextView) view.findViewById(R.id.patchtime);

            // // String patchnamee[] = { "Bron", "Brroklyn", "Jamica" };
            // if (iee >= 9)
            // iee = 0;
            // tv.setText(groupwisepactch[iee][groupPosition]);
            // if (groupPosition == 2)

            tv1.setText("8:30-11:30");

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
        String patch1;
        String patch2;
        String patch3;

        String patch1name;
        String patch2name;
        String patch3name;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title;
        String hint;
    }

    private static class ChildHolder {
        TextView title;
        TextView hint;
    }

    private static class GroupHolder {
        TextView title;
        TextView location;
        TextView todoicon;

        TextView patch1;
        TextView patch2;
        TextView patch3;

        TextView patch1name;
        TextView patch2name;
        TextView patch3name;
    }

    public class MyExpandableAdapter23 extends BaseExpandableListAdapter {

        private Activity activity;
        private ArrayList<Object> childtems;
        private LayoutInflater inflater;
        private ArrayList<String> parentItems, child;

        public MyExpandableAdapter23(ArrayList<String> parents,
                                     ArrayList<Object> childern) {
            this.parentItems = parents;
            this.childtems = childern;
        }

        public void setInflater(LayoutInflater inflater, Activity activity) {
            this.inflater = inflater;
            this.activity = activity;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            // child = (ArrayList<String>) childtems.get(groupPosition);

            TextView textView = null;

            ExpandableListView expandableListView = null;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.group, null);
            }

            textView = (TextView) convertView.findViewById(R.id.textView1);
            // expandableListView = (ExpandableListView) convertView
            // .findViewById(R.id.listviewforchild);
            //
            // expandableListView.setDividerHeight(2);
            // expandableListView.setGroupIndicator(null);
            // expandableListView.setClickable(true);
            //
            // setGroupParents();
            // setChildData();
            //
            // MyExpandableAdapter adapter = new
            // MyExpandableAdapter(parentItems,
            // childItems);
            //
            // adapter.setInflater(
            // (LayoutInflater)
            // getSystemService(Context.LAYOUT_INFLATER_SERVICE),
            // MainActivity.this);
            // expandableListView.setAdapter(adapter);
            textView.setText(child.get(childPosition));

            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    // Toast.makeText(activity, child.get(childPosition),
                    // Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.row, null);
            }

            ((CheckedTextView) convertView).setText(parentItems
                    .get(groupPosition));
            ((CheckedTextView) convertView).setChecked(isExpanded);

            return convertView;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return ((ArrayList<String>) childtems.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public int getGroupCount() {
            return parentItems.size();
        }

        @Override
        public void onGroupCollapsed(int groupPosition) {
            super.onGroupCollapsed(groupPosition);
        }

        @Override
        public void onGroupExpanded(int groupPosition) {
            super.onGroupExpanded(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu:

                Intent intent = new Intent(MainActivity.this, ContentLIb.class);
                startActivity(intent);

                break;

            default:
                break;
        }

    }
}
