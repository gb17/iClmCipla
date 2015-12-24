package com.cirrius.expand;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cirrius.expand.DataForMultilevelExpandableListView.SubCategory;
import com.cirrius.expand.DataForMultilevelExpandableListView.SubCategory.ItemList;
import com.cirrius.iclmcipla.CalendarClass;
import com.cirrius.iclmcipla.CalendarView;
import com.cirrius.iclmcipla.DatePickerFragment;
import com.cirrius.iclmcipla.DetailingPageV2;
import com.cirrius.iclmcipla.Physicians;
import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.ReportingTabs;
import com.cirrius.iclmcipla.TimePickerFragment;

import com.iclm.util.MenuforThreedot;
import com.iclm.util.Viewgp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Expandablelistviewfordoc {

    public static LinearLayout pannelLinearLayout;
    public static final int SECOND_LEVEL_COUNT = 2;
    public static final int THIRD_LEVEL_COUNT = 5;
    private ExpandableListView expandableListView;
    List<Map<String, String>> maingroupData = new ArrayList<Map<String, String>>();
    List<List<Map<String, String>>> maingroupchildData = new ArrayList<List<Map<String, String>>>();
    private ArrayList<SubCategory> pSubItemArrayList;
    int indexField = 0;

    private ArrayList<DataForMultilevelExpandableListView> pProductArrayList;

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Class B", "Class A", "Class C", "Class C", "Class B"};
    String[] TimeArr = {"10:30 am - 01:30 pm", "02:00 pm - 04:00 pm",
            "Class C", "Class C", "Class B", "Class B", "Class B", "Class A",
            "Class B", "Class C", "Class A"};

    String[] dateofmonth = {"17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30"};

    String[] todocount = {"5", "2", "3", "4", "6", "2", "7", "3", "4", "5",
            "2", "1", "2", "3"};

    String[] dayofmonth = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "MON",
            "TUE", "WED", "THU", "FRI", "SAT", "MON", "TUE"};

    String[] month = {"JULY", "JULY", "JULY", "JULY", "JULY", "JULY", "JULY",
            "JULY", "JULY", "JULY", "JULY", "JULY", "JULY", "JULY"};

    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_12, R.drawable.doct_3, R.drawable.doct_4};

    private String[] Drname = {"Alan Spiegel", "Alexander Fleming",
            "John Cussack", "Alexis E. Te", "Alice Rusk"};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};
    private ParentLevel adapter;
    private Context context;
    private int index = 0;
    private RelativeLayout relativeforexapandable;
    Typeface font;
    int indexforchk;


    Dialog dialog_box1;

    String[] maindata = {"Add Unplanned", "Add Unlisted Physician", "Add Pharmacy"
    };

    public Expandablelistviewfordoc(Context context) {

        this.context = context;

    }

    public Expandablelistviewfordoc(Context context, int indexforchk, int mode) {
        this.context = context;
        this.index = mode;
        this.indexforchk = indexforchk;

    }

    public Expandablelistviewfordoc(Context context, int index) {

        this.context = context;
        this.index = index;
    }

    public View multilevleexpandalelistview(int indexField) {
        this.indexField = indexField;
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        relativeforexapandable = (RelativeLayout) inflater.inflate(
                R.layout.expandablistview, null);

        expandableListView = (ExpandableListView) relativeforexapandable
                .findViewById(R.id.mainList);

        ArrayList<ItemList> mItemListArray = new ArrayList<ItemList>();

        String[] Drname = {"Alan Spiegel", "Alexander Fleming",
                "Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk"};

        for (int i = 0; i < Drname.length; i++) {
            mItemListArray.add(new ItemList(Drname[i], Specialty[i], Class[i],
                    strTime[i]));
        }

        String strTime2[] = {"02:00 pm", "02:30 pm", "03:00 pm", "03:30 pm",
                "03:45 pm", "Class B", "Class B", "Class A", "Class B",
                "Class C", "Class A"};

        ArrayList<ItemList> mItemListArray2 = new ArrayList<ItemList>();
        for (int i = 0; i < Drname.length; i++) {
            mItemListArray2.add(new ItemList(Drname[i], Specialty[i], Class[i],
                    strTime2[i]));
        }

        /**
         *
         */
        pSubItemArrayList = new ArrayList<SubCategory>();

        pSubItemArrayList.add(new SubCategory("Bronx", TimeArr[0],
                mItemListArray));

        pSubItemArrayList.add(new SubCategory("New York", TimeArr[1],
                mItemListArray));

        /**
         *
         */

        pProductArrayList = new ArrayList<DataForMultilevelExpandableListView>();

        for (int i = 0; i < dateofmonth.length; i++) {
            pProductArrayList
                    .add(new DataForMultilevelExpandableListView(
                            dateofmonth[i], month[i], dayofmonth[i],
                            pSubItemArrayList));
        }
        adapter = new ParentLevel(context);
        expandableListView.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++)
            expandableListView.expandGroup(i);

        return relativeforexapandable;

    }


    public class ParentLevel extends BaseExpandableListAdapter {

        private Context context;
        private TextView chkcount;

        public ParentLevel(Context context) {
            this.context = context;
        }

        @Override
        public Object getChild(int arg0, int arg1) {
            return arg1;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            SecondLevelExpandableListView secondLevelELV = new SecondLevelExpandableListView(
                    context);

            SecondLevelAdapter adapter = new SecondLevelAdapter(context);

            secondLevelELV.setDivider(context.getResources().getDrawable(
                    R.color.divder));
            secondLevelELV.setChildDivider(context.getResources().getDrawable(
                    R.color.divder));
            secondLevelELV.setDividerHeight(1);
            secondLevelELV.setAdapter(adapter);

            secondLevelELV.setClickable(false);

            for (int i = 0; i < adapter.getGroupCount(); i++)
                secondLevelELV.expandGroup(i);
            secondLevelELV.setGroupIndicator(null);

            secondLevelELV.setOnGroupClickListener(new OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {

                    if (parent.isGroupExpanded(groupPosition)) {
                        SecondLevelExpandableListView expandableListView = new SecondLevelExpandableListView(
                                context);
                        expandableListView.measure(0, MeasureSpec.EXACTLY);
                    }

                    return true; // This way the expander cannot be collapsed
                }
            });

            return secondLevelELV;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return pProductArrayList.get(groupPosition).getmSubCategoryList()
                    .size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupPosition;
        }

        @Override
        public int getGroupCount() {
            return pProductArrayList.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {

            ViewHolderItem viewHolder;

            if (convertView == null) {

                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.exrow_first, null);

                viewHolder = new ViewHolderItem();

                if (indexforchk == 22) {
                    TextView headertextview2223 = (TextView) convertView
                            .findViewById(R.id.headertextview2223);
                    headertextview2223.setVisibility(View.VISIBLE);

                    headertextview2223.setTypeface(font);

                    TextView headertextview223 = (TextView) convertView
                            .findViewById(R.id.headertextview223);
                    headertextview223.setVisibility(View.VISIBLE);
                    chkcount = (TextView) convertView
                            .findViewById(R.id.todocount);

                    chkcount.setVisibility(View.VISIBLE);

                    headertextview223.setTypeface(font);
                }
                if (indexforchk == 96) {
                    TextView headertextview223 = (TextView) convertView
                            .findViewById(R.id.headertextview223);

                    headertextview223.setText(context.getResources().getString(R.string.icon_plus));
                    headertextview223.setTypeface(font);
                    headertextview223.setVisibility(View.VISIBLE);


                    headertextview223.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            calldialogugemenu(v);
                        }
                    });


                }


                viewHolder.textViewItem = (TextView) convertView
                        .findViewById(R.id.eventsListEventRowText);

                viewHolder.textViewday = (TextView) convertView
                        .findViewById(R.id.headertextview2);

                viewHolder.textViewmonth = (TextView) convertView
                        .findViewById(R.id.headertextviewformonth);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolderItem) convertView.getTag();
            }
            final String name = pProductArrayList.get(groupPosition).getpName();
            viewHolder.textViewItem.setText(name);

            final String month = pProductArrayList.get(groupPosition)
                    .getMonthName();
            viewHolder.textViewmonth.setText(month);

            final String day = pProductArrayList.get(groupPosition)
                    .getDayName();
            viewHolder.textViewday.setText(day);
            if (indexforchk == 22)
                chkcount.setText(todocount[groupPosition]);

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    public class SecondLevelExpandableListView extends ExpandableListView {

        public SecondLevelExpandableListView(Context context) {
            super(context);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            // 999999 is a size in pixels. ExpandableListView requires a maximum
            // height in order to do measurement calculations.
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(470,
                    MeasureSpec.EXACTLY);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public class SecondLevelAdapter extends BaseExpandableListAdapter {

        private Context context;
        private TextView pathcNameTextView;
        private TextView textviewtime;

        public SecondLevelAdapter(Context context) {
            this.context = context;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupPosition;
        }

        @Override
        public int getGroupCount() {
            return 1;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.exrow_second, null);
                pathcNameTextView = (TextView) convertView
                        .findViewById(R.id.eventsListEventRowText);

                textviewtime = (TextView) convertView
                        .findViewById(R.id.textViewtime);

            }

            final String catName = pProductArrayList.get(groupPosition)
                    .getmSubCategoryList().get(groupPosition).getpSubCatName();
            final String catTime = pProductArrayList.get(groupPosition)
                    .getmSubCategoryList().get(groupPosition).getpSubCatTime();
            pathcNameTextView.setText(catName);
            textviewtime.setText(catTime);
            return convertView;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(final int groupPosition,
                                 final int childPosition, boolean isLastChild, View convertView,
                                 ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.exrow_third, null);

                TextView mItemName = (TextView) convertView
                        .findViewById(R.id.eventsListEventRowText);

                TextView mItemTime = (TextView) convertView
                        .findViewById(R.id.time);

                ImageView drImageView = (ImageView) convertView
                        .findViewById(R.id.dr_image);
                TextView mItemPrice = (TextView) convertView
                        .findViewById(R.id.textViewItemPrice);

                TextView childtextview3 = (TextView) convertView
                        .findViewById(R.id.childtextview3);

                TextView menufordr = (TextView) convertView
                        .findViewById(R.id.menufordr);
                // menufordr.setTypeface(font);

                final LinearLayout layout = (LinearLayout) convertView
                        .findViewById(R.id.childiewoflist);
                final RelativeLayout mask = (RelativeLayout) convertView
                        .findViewById(R.id.masklay);
                TextView download = (TextView) convertView
                        .findViewById(R.id.download);
                final LinearLayout ll = (LinearLayout) convertView
                        .findViewById(R.id.retry);

                final ProgressBar pb = (ProgressBar) convertView
                        .findViewById(R.id.progressBar1);
                ll.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        ll.setVisibility(View.INVISIBLE);
                        pb.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                pb.setVisibility(View.GONE);
                                mask.setVisibility(View.GONE);
                            }
                        }, 3000);
                    }
                });
                download.setTypeface(font);

                if (indexforchk == 22 || indexforchk == 29) {
                } else {
                    if ((groupPosition == 0 && childPosition == 1)
                            || (groupPosition == 1 && childPosition == 4)
                            || (groupPosition == 2 && childPosition == 1)) {
                        mask.setVisibility(View.VISIBLE);
                    }

                }
                if (index == 1) {
                    TextView tick1 = (TextView) convertView
                            .findViewById(R.id.tick1);
                    tick1.setTypeface(font);
                    TextView tick2 = (TextView) convertView
                            .findViewById(R.id.tick2);
                    tick2.setTypeface(font);
                    if (childPosition == 0) {
                        tick1.setVisibility(View.VISIBLE);
                        tick1.setText(R.string.icon_tick);
                        tick1.setTextSize(20);
                        tick1.setTextColor(Color.YELLOW);
                        tick2.setVisibility(View.VISIBLE);
                        tick2.setText(R.string.icon_tick);
                        tick2.setTextSize(20);
                        tick2.setTextColor(Color.CYAN);
                    } else if (childPosition == 1 || childPosition == 2) {
                        tick1.setVisibility(View.VISIBLE);
                        tick1.setText(R.string.icon_tick);
                        tick1.setTextSize(20);
                        tick1.setTextColor(Color.YELLOW);
                    } else {
                        tick2.setVisibility(View.VISIBLE);
                        tick2.setText(R.string.icon_exclaim);
                        tick2.setTextSize(20);
                        tick2.setTextColor(Color.RED);
                    }

                }

                layout.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (index == 1) {
                            Intent intent = new Intent(context,
                                    ReportingTabs.class);
                            if (childPosition == 1)
                                intent.putExtra("index", 2);
                            context.startActivity(intent);
                        } else {
                            if ((groupPosition == 0 && childPosition == 1)
                                    || (groupPosition == 1 && childPosition == 4)
                                    || (groupPosition == 2 && childPosition == 1)) {

                                Toast.makeText(context, "Please download Data",
                                        Toast.LENGTH_SHORT).show();

                            } else {
                                if (indexField == 1) {
                                    Intent intent = new Intent(context,
                                            Physicians.class);
                                    context.startActivity(intent);
                                } else {
                                    Intent intent = new Intent(context,
                                            DetailingPageV2.class);
                                    intent.putExtra("KT", "1");
                                    intent.putExtra("name",
                                            Drname[childPosition]);
                                    context.startActivity(intent);
                                }
                            }
                        }

                    }
                });
                layout.setOnDragListener(new MyDragListener());
                layout.setOnLongClickListener(new OnLongClickListener() {

                    @Override
                    public boolean onLongClick(View v) {
                        ClipData data = ClipData.newPlainText("", "");
                        DragShadowBuilder shadowBuilder = new DragShadowBuilder(
                                v);
                        v.startDrag(data, shadowBuilder, v, 0);
                        return true;
                    }
                });

                menufordr.setOnClickListener(new OnClickListener() {

                    private Dialog dialog_box;

                    @Override
                    public void onClick(View v) {
                        layout.setBackgroundColor(Color.parseColor("#e0e0e0"));
                        MenuforThreedot menuforThreedot = new MenuforThreedot(
                                context);
                        dialog_box = menuforThreedot.menudialog();

                        Window window = dialog_box.getWindow();
                        WindowManager.LayoutParams wmlp = dialog_box
                                .getWindow().getAttributes();
                        int[] viewLocation = new int[2];
                        v.getLocationOnScreen(viewLocation);
                        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                        wmlp.x = viewLocation[0];
                        wmlp.y = viewLocation[1];
                        window.setBackgroundDrawable(new ColorDrawable(
                                Color.TRANSPARENT));
                        dialog_box.getWindow().setLayout(450, 570);
                        dialog_box.show();
                        dialog_box
                                .setOnDismissListener(new OnDismissListener() {

                                    @Override
                                    public void onDismiss(DialogInterface dialog) {
                                        layout.setBackgroundResource(R.drawable.normalbg);

                                    }
                                });
                    }
                });

                // TextView menufordr = (TextView) convertView
                // .findViewById(R.id.menufordr);font
                // menufordr.setTypeface(font);
                // TextView playicon = (TextView) convertView
                // .findViewById(R.id.playicon);
                // playicon.setTypeface(font);
                //
                // final String itemName = pProductArrayList.get(groupPosition)
                // .getmSubCategoryList().get(j).getmItemListArray()
                // .get(k).getItemName();
                // final String itemPrice = pProductArrayList.get(groupPosition)
                // .getmSubCategoryList().get(j).getmItemListArray()
                // .get(k).getItemPrice();
                //
                // final String itemClass = pProductArrayList.get(groupPosition)
                // .getmSubCategoryList().get(j).getmItemListArray()
                // .get(k).getItemClass();
                // final String itemTime = pProductArrayList.get(groupPosition)
                // .getmSubCategoryList().get(j).getmItemListArray()
                // .get(k).getItemTime();

                drImageView.setImageResource(imageDoctor[childPosition]);
                mItemTime.setText(strTime[childPosition]);
                mItemName.setText(Drname[childPosition]);
                mItemPrice.setText(Specialty[childPosition]);
                childtextview3.setText(Class[childPosition]);

                // mItemName.setText(itemName);
                // mItemTime.setText(itemTime);
                // mItemPrice.setText(itemPrice);
                // childtextview3.setText(itemClass);
            }

            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return THIRD_LEVEL_COUNT;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    static class ViewHolderItem {
        TextView textViewItem;
        TextView textViewday;
        TextView textViewmonth;
    }

    class MyDragListener implements OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:

                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    // v.animate().scaleX(1.5f);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    // v.setBackgroundDrawable(normalShape);

                    break;
                case DragEvent.ACTION_DROP:
                    ViewGroup parent = Viewgp.getParent(v);

                    // parent of parent

                    int chance = parent.indexOfChild(v);
                    int parcount = parent.getChildCount();
                    View view = (View) event.getLocalState();
                    ViewGroup parent2 = Viewgp.getParent(view);

                    int chance2 = parent2.indexOfChild(view);
                    int parcount1 = parent2.getChildCount();

                    View[] vpn = new View[parcount];
                    for (int i = 0; i < vpn.length; i++) {
                        vpn[i] = parent.getChildAt(i);
                    }

                    View[] vpn1 = new View[parcount1];
                    for (int i = 0; i < vpn1.length; i++) {
                        vpn1[i] = parent2.getChildAt(i);
                    }

                    // if (listclick == 1) {
                    // try {
                    // Viewgp.replacegrouppartforlisvie(TourPlanActivity.this,
                    // vpn[chance], vpn1[chance2]);
                    // listclick = 0;
                    //
                    // adapter = new GridCellAdapter(getApplicationContext(),
                    // R.id.calendar_day_gridcell, month, year, null);
                    // adapter.notifyDataSetChanged();
                    // calendarView.setAdapter(adapter);
                    //
                    // removeelement(apntime112, postionforlisttoremove);
                    //
                    // // Customlistadapter adapter1 = new Customlistadapter(
                    // // MyCalendarActivity.this, imageDoctor112, array,
                    // // drname3112, immagfe112);
                    // // ListView.setAdapter(adapter1);
                    //
                    // } catch (Exception e) {
                    // e.printStackTrace();
                    // }
                    //
                    // } else {

                    Viewgp.replacegrouppartforlisvie(context, vpn[chance],
                            vpn1[chance2]);
                    // Viewgp.replacegrouppartNew(vpn[chance], vpn1[chance2],
                    // chance2,
                    // chance);
                    // }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    // v.animate().scaleX(1.0f);

                    break;

                default:
                    break;
            }
            return true;
        }
    }

    void calldialogugemenu(View v) {


        dialog_box1 = new Dialog(context);
        dialog_box1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_box1.setContentView(R.layout.calenderlistdialog);
        LinearLayout left = (LinearLayout)

                dialog_box1.findViewById(R.id.linlist);

        for (int i = 0; i < maindata.length; i++) {
            TextView textView = new TextView(context);
            View v1 = new View(context);
            LinearLayout.LayoutParams param = new

                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,

                    LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams param1 = new

                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,

                    1);
            textView.setLayoutParams(param);
            v1.setLayoutParams(param1);
            v1.setBackgroundColor(Color.WHITE);

            textView.setTextColor(Color.WHITE);
            textView.setPadding(15, 5, 5, 5);
            textView.setTextSize(20);
            textView.setText(maindata[i]);
            textView.setTag("" + i);
            textView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt((String) v.getTag());
                    dialog_box1.dismiss();
                    if (count == 4) {
                    } else if (count == 5) {

                    } else if (count == 1) {

                        final Dialog d = new Dialog(context);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.add_unlisted);

                        TextView close = (TextView) d.findViewById(R.id.close);
                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);
                        // /date
                        final EditText edittextDuedate = (EditText) d
                                .findViewById(R.id.edittextDuedate);

                        edittextDuedate
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        // Time

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);

                        edittime.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });

                        d.show();

                    } else if (count == 3 || count == 2) {

                        final Dialog d = new Dialog(context);
                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.add_unlisted);

                        TextView close = (TextView) d.findViewById(R.id.close);

                        TextView TextViewActionPoint = (TextView) d
                                .findViewById(R.id.TextViewActionPoint);

                        TextViewActionPoint.setText("Add Details");

                        TextView phyname = (TextView) d
                                .findViewById(R.id.phyname);

                        phyname.setText("Name");

                        // /date
                        final EditText edittextDuedate = (EditText) d
                                .findViewById(R.id.edittextDuedate);

                        edittextDuedate
                                .setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        DialogFragment newFragment = new DatePickerFragment();
                                        CalendarClass.editTextForDate = edittextDuedate;
                                        newFragment.show(((Activity) context)
                                                        .getFragmentManager(),
                                                "datePicker");
                                    }
                                });

                        // Time

                        final EditText edittime = (EditText) d
                                .findViewById(R.id.edittime);

                        edittime.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // show the time picker dialog
                                TimePickerFragment newFragment = new TimePickerFragment();
                                CalendarClass.editTextForDate = edittime;
                                newFragment.show(((Activity) context)
                                        .getFragmentManager(), "timepicker");

                            }
                        });

                        TextView psc = (TextView) d.findViewById(R.id.spec);
                        psc.setVisibility(View.INVISIBLE);

                        Spinner spphy = (Spinner) d
                                .findViewById(R.id.typeofphy1);

                        spphy.setVisibility(View.INVISIBLE);

                        EditText ButtonSet = (EditText) d
                                .findViewById(R.id.ButtonSet);

                        ButtonSet.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });
                        close.setTypeface(font);
                        close.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                d.dismiss();
                            }
                        });
                        d.show();
                    } else if (count == 0) {
                        CalendarView calendarView = new CalendarView(context);
                        calendarView.callscheducledailog(1);
                    } else if (count == 7) {

                    }

                }
            });

            if (i != maindata.length - 1) {

                left.addView(textView);
                left.addView(v1);
            } else {
                left.addView(textView);
            }
        }

        Window window = dialog_box1.getWindow();
        WindowManager.LayoutParams wmlp = dialog_box1.getWindow()
                .getAttributes();
        int[] viewLocation = new int[2];
        v.getLocationOnScreen(viewLocation);
        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp.x = viewLocation[0];
        wmlp.y = viewLocation[1];
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_box1.getWindow().setLayout(300, 570);
        dialog_box1.show();

    }


}
