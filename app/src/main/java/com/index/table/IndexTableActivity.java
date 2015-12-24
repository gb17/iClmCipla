package com.index.table;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cirrius.graph.Graphs;
import com.cirrius.iclmcipla.CustomAdapterForPhysiiSearch;
import com.cirrius.iclmcipla.NewCustomAdapter;
import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.Utility;
import com.index.table.service.UserService;
import com.index.table.to.Book;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

public class IndexTableActivity extends CustomListIndex implements
        OnClickListener {
    private ListView booksLV;

    private UserListAdapter userListAdapter;

    private View viewinclude;

    private Typeface font;

    private TextView textView;
    EditText edittextDuedate;
    // EditText editText;
    List<String[]> dataList = new ArrayList<String[]>();
    ListView lv;
    CustomAdapterForPhysiiSearch adapter;

    /**
     * Values For Info Icon
     **/

    private ListView listview3;
    ArrayList<String> items = new ArrayList<String>();
    private int count;
    private boolean[] thumbnailsselection;

    private LinearLayout relativvebottom;
    ArrayList<String> name;

    private RelativeLayout relativemiddle;

    private RelativeLayout advanceview;

    private View physicanlauoutwithgraph;

    private TextView advancetext;
    Calendar myCalendar = Calendar.getInstance();
    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4};

    private String[] Drname = {"Alan Spiegel", "Alexander Fleming",
            "Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk",
            "Alan Spiegel", "Alexander Fleming", "Alexander M. Kirschenbaum",
            "Alexis E. Te", "Alice Rusk"};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A", "10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine",
            "Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Class B", "Class A", "Class C", "Class C", "Class B",
            "Class B", "Class A", "Class C", "Class C", "Class B"};
    String[] ast14 = {"Drs. Required", "Drs. in MSL", "Drs. Met"};

    /**
     * Called when the activity is first created.
     */
    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physiciant);

        viewinclude = findViewById(R.id.viewlist);
        font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Utility.setactoinbart(getActionBar(), this, font, "Customers");
        findViews();
        //
        // textView = (TextView) findViewById(R.id.contentlib);
        // textView.setTypeface(font);

        booksLV = (ListView) viewinclude.findViewById(R.id.booksLV);
        selectedIndex = (TextView) viewinclude.findViewById(R.id.selectedIndex);
        userVector = UserService.getUserList(this);

        Vector<Book> subsidiesList = getIndexedBooks(userVector);
        totalListSize = subsidiesList.size();

        userListAdapter = new UserListAdapter(this, subsidiesList, this);
        booksLV.setAdapter(userListAdapter);

        LinearLayout sideIndex = (LinearLayout) findViewById(R.id.sideIndex);
        sideIndex.setOnClickListener(onClicked);
        sideIndexHeight = sideIndex.getHeight();
        mGestureDetector = new GestureDetector(this,
                new ListIndexGestureListener());

        advanceview = (RelativeLayout) findViewById(R.id.advanceview);

        physicanlauoutwithgraph = findViewById(R.id.includegraph);

        RelativeLayout webView11 = (RelativeLayout) physicanlauoutwithgraph
                .findViewById(R.id.webview11);
        RelativeLayout webView12 = (RelativeLayout) physicanlauoutwithgraph
                .findViewById(R.id.webview12);
        RelativeLayout webView13 = (RelativeLayout) physicanlauoutwithgraph
                .findViewById(R.id.webview13);

        Graphs graphs = new Graphs(this);
        String[] ast = {"Dr. Required", "Drs. in MSL", "Drs.met"};

        webView11.addView(graphs.drawNbarchart(3, ast, 0, 3), new LayoutParams(
                320, 200));

        webView12.addView(graphs.piechartM(6), new LayoutParams(320, 210));

        webView13.addView(graphs.drawNbarchart(3, ast, 18, 3),
                new LayoutParams(320, 200));

        relativemiddle = (RelativeLayout) findViewById(R.id.relativemiddle);

        advancetext = (TextView) findViewById(R.id.advancetext);

        advancetext.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (advanceview.getVisibility() == View.VISIBLE) {
                    advanceview.setVisibility(View.GONE);
                    physicanlauoutwithgraph.setVisibility(View.VISIBLE);

                } else {
                    advanceview.setVisibility(View.VISIBLE);
                    physicanlauoutwithgraph.setVisibility(View.GONE);
                }

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        getDisplayListOnChange();
    }

    private void findViews() {

        relativemiddle = (RelativeLayout) findViewById(R.id.relativemiddle);

        for (int i = 1; i < relativemiddle.getChildCount(); i++) {

            relativemiddle.getChildAt(i).setOnClickListener(this);
            relativemiddle.getChildAt(i).setTag(i);

        }
        TextView tv1 = (TextView) findViewById(R.id.text11);
        tv1.setTypeface(font);
        TextView tv2 = (TextView) findViewById(R.id.text22);
        tv2.setTypeface(font);
        // TextView tv3 = (TextView) findViewById(R.id.text33);
        // tv3.setTypeface(font);
        // tv3.setOnClickListener(new OnClickListener() {
        //
        // @Override
        // public void onClick(View v) {
        // // TODO Auto-generated method stub
        //
        // }
        // });
        // TextView tv4 = (TextView) findViewById(R.id.text44);
        // tv4.setTypeface(font);
        // tv4.setOnClickListener(new OnClickListener() {
        //
        // @Override
        // public void onClick(View v) {
        // // TODO Auto-generated method stub
        //
        // }
        // });

    }

    @Override
    public void onClick(View v) {
        int id = (int) v.getTag();
        // TODO Auto-generated method stub
        if (id == 1 || id == 8 || id == 14 || id == 21)
            openDialog1(1);
        else if (id == 13 || id == 20)
            openDialog1(2);
        else {
            relativvebottom = (LinearLayout) findViewById(R.id.relativvebottom);

            TextView tvdata = (TextView) v;
            String s = tvdata.getText().toString();

            final LinearLayout linear = new LinearLayout(
                    IndexTableActivity.this);
            linear.setBackgroundResource(R.drawable.round);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            param.setMargins(20, 10, 0, 0);
            linear.setOrientation(LinearLayout.HORIZONTAL);
            linear.setLayoutParams(param);

            TextView tv = new TextView(IndexTableActivity.this);
            tv.setText(s);
            tv.setGravity(Gravity.CENTER);

            LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                    30, 30);

            Button bv = new Button(IndexTableActivity.this);
            parambutton.setMargins(5, 5, 0, 0);
            bv.setBackgroundResource(R.drawable.cross108);
            bv.setLayoutParams(parambutton);
            bv.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                    relativvebottom.removeView(linear);
                }
            });

            linear.addView(tv);
            linear.addView(bv);
            linear.setBackgroundResource(R.drawable.roundcyan);
            relativvebottom.addView(linear);
        }
    }

    public void openDialog1(int index) {
        final Dialog dialog = new Dialog(IndexTableActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.physicianm);
        Button b1 = (Button) dialog.findViewById(R.id.button1);

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                final ArrayList<Integer> posSel = new ArrayList<Integer>();
                name = new ArrayList<String>();
                posSel.clear();
                boolean noSelect = false;
                for (int i = 0; i < thumbnailsselection.length; i++) {
                    if (thumbnailsselection[i] == true) {
                        noSelect = true;
                        Log.e("sel pos thu-->", "" + i);
                        posSel.add(i);
                        name.add(items.get(i));

                        // break;
                    }
                }

                for (int j = 0; j < name.size(); j++) {

                    relativvebottom = (LinearLayout) findViewById(R.id.relativvebottom);

                    TextView tvdata = (TextView) v;
                    String s = tvdata.getText().toString();

                    final LinearLayout linear = new LinearLayout(
                            IndexTableActivity.this);
                    linear.setBackgroundResource(R.drawable.round);

                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                            LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);
                    param.setMargins(20, 10, 0, 0);
                    linear.setOrientation(LinearLayout.HORIZONTAL);
                    linear.setLayoutParams(param);

                    TextView tv = new TextView(IndexTableActivity.this);
                    tv.setText(name.get(j));
                    tv.setGravity(Gravity.CENTER);

                    LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                            30, 30);

                    Button bv = new Button(IndexTableActivity.this);
                    parambutton.setMargins(5, 5, 0, 0);
                    bv.setBackgroundResource(R.drawable.cross108);
                    bv.setLayoutParams(parambutton);
                    bv.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub

                            relativvebottom.removeView(linear);
                        }
                    });

                    linear.addView(tv);
                    linear.addView(bv);
                    relativvebottom.addView(linear);
                    linear.setBackgroundResource(R.drawable.roundcyan);
                    dialog.dismiss();

                }
            }
        });

        Display display = ((WindowManager) IndexTableActivity.this
                .getSystemService(this.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        dialog.getWindow().setLayout((width) / 2, (height) / 2);
        dialog.getWindow().setBackgroundDrawableResource(
                R.drawable.circularcornerlist);
        fillarray(index);
        count = items.size();
        thumbnailsselection = new boolean[count];
        listview3 = (ListView) dialog.findViewById(R.id.mainListView);
        listview3.setAdapter(new ImageAdapter(IndexTableActivity.this));

        dialog.show();

    }

    private void fillarray(int index) {
        // TODO Auto-generated method stub
        if (index == 1) {
            items.clear();
            items.add("Patch1");
            items.add("Patch2");
            items.add("Patch3");
            items.add("Patch4");
            items.add("Patch5");
            items.add("Patch6");
            items.add("Patch7");
            items.add("Patch8");
            items.add("Patch9");
            items.add("Patch10");
            items.add("Patch11");
            items.add("Patch12");
            items.add("Patch13");
            items.add("Patch14");
            items.add("Patch15");
            items.add("Patch16");
        } else {
            items.clear();
            items.add("Segment1");
            items.add("Segment2");
            items.add("Segment3");
            items.add("Segment4");
            items.add("Segment5");
            items.add("Segment6");
            items.add("Segment7");
            items.add("Segment8");
            items.add("Segment9");
            items.add("Segment10");
        }

    }

    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.row_photo, null);
                holder.textview = (TextView) convertView
                        .findViewById(R.id.thumbImage);
                holder.textview.setTextColor(Color.WHITE);
                holder.checkbox = (CheckBox) convertView
                        .findViewById(R.id.itemCheckBox);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.checkbox.setId(position);
            holder.textview.setId(position);
            holder.checkbox.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    CheckBox cb = (CheckBox) v;
                    int id = cb.getId();
                    if (thumbnailsselection[id]) {
                        cb.setChecked(false);
                        thumbnailsselection[id] = false;
                    } else {
                        cb.setChecked(true);
                        thumbnailsselection[id] = true;

                        System.out.println("cmncm" + items.get(id));

                    }
                }
            });
            holder.textview.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int id = v.getId();
                }
            });
            holder.textview.setText(items.get(position));
            holder.checkbox.setChecked(thumbnailsselection[position]);
            holder.id = position;
            return convertView;
        }
    }

    class ViewHolder {
        TextView textview;
        CheckBox checkbox;
        int id;
    }

    private Vector<Book> getIndexedBooks(Vector<Book> booksVector) {

        // Retrieve it from DB in shorting order

        Vector<Book> v = new Vector<Book>();
        // Add default item

        String idx1 = null;
        String idx2 = null;
        for (int i = 0; i < booksVector.size(); i++) {
            Book temp = booksVector.elementAt(i);
            // Insert the alphabets
            idx1 = (temp.getTitle().substring(0, 1)).toLowerCase();
            if (!idx1.equalsIgnoreCase(idx2)) {
                v.add(new Book(idx1.toUpperCase(), "", "", "", ""));
                idx2 = idx1;
                dealList.add(i);
            }
            v.add(temp);
        }

        return v;
    }

    /**
     * ListIndexGestureListener method gets the list on scroll.
     */
    private class ListIndexGestureListener extends
            GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {

            /**
             * we know already coordinates of first touch we know as well a
             * scroll distance
             */
            sideIndexX = sideIndexX - distanceX;
            sideIndexY = sideIndexY - distanceY;

            /**
             * when the user scrolls within our side index, we can show for
             * every position in it a proper item in the list
             */
            if (sideIndexX >= 0 && sideIndexY >= 0) {
                displayListItem();
            }

            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }

    public class MyAdapterforspinner extends ArrayAdapter<String> {

        public MyAdapterforspinner(Context ctx, int txtViewResourceId,
                                   String[] objects) {
            super(ctx, txtViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) IndexTableActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exrow_third, null);

            TextView mItemName = (TextView) convertView
                    .findViewById(R.id.eventsListEventRowText);

            TextView mItemTime = (TextView) convertView.findViewById(R.id.time);

            ImageView drImageView = (ImageView) convertView
                    .findViewById(R.id.dr_image);
            TextView mItemPrice = (TextView) convertView
                    .findViewById(R.id.textViewItemPrice);

            TextView childtextview3 = (TextView) convertView
                    .findViewById(R.id.childtextview3);

            TextView menufordr = (TextView) convertView
                    .findViewById(R.id.menufordr);
            menufordr.setVisibility(View.GONE);

            drImageView.setImageResource(imageDoctor[position]);
            mItemTime.setText(strTime[position]);
            mItemName.setText(Drname[position]);
            mItemPrice.setText(Specialty[position]);
            childtextview3.setText(Class[position]);

            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add(Menu.NONE, R.drawable.plus, 2, "").setIcon(R.drawable.plus)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(Menu.NONE, R.drawable.cancel12, 3, "").setIcon(R.drawable.cancel12)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(Menu.NONE, R.drawable.ic_action_search, 1, "")
                .setIcon(R.drawable.ic_action_search)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.drawable.ic_action_search:
                Dialog dialog_box = new Dialog(IndexTableActivity.this);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_box.setContentView(getView());
                Window window = dialog_box.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog_box.getWindow().setLayout(650, 650);
                dialog_box.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog_box.show();
                return true;
            case R.drawable.plus:
                final Dialog d = new Dialog(IndexTableActivity.this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.add_physician);
                d.getWindow().setLayout(750, 630);
                TextView textpro31 = (TextView) d.findViewById(R.id.textpro31);
                textpro31.setTypeface(font);
                TextView cam1 = (TextView) d.findViewById(R.id.cam1);
                cam1.setTypeface(font);
                TextView cam2 = (TextView) d.findViewById(R.id.cam2);
                cam2.setTypeface(font);
                TextView cam3 = (TextView) d.findViewById(R.id.cam3);
                cam3.setTypeface(font);
                Button button = (Button) d.findViewById(R.id.save);
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                textpro31.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                d.show();
                return true;
            case R.drawable.cancel12:
                final Dialog dialog = new Dialog(IndexTableActivity.this);
                dialog.getWindow();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.adddoctor);
                ((TextView) dialog.findViewById(R.id.title)).setText("Delete Doctor");
                (dialog.findViewById(R.id.ButtonSet)).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.graphics.Color.TRANSPARENT));
                ListView listView = (ListView) dialog.findViewById(R.id.list);
                NewCustomAdapter newCustomAdapter = new NewCustomAdapter(IndexTableActivity.this);
                listView.setAdapter(newCustomAdapter);
                dialog.getWindow().setLayout(600, 600);
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public LinearLayout getView() {
        LinearLayout parent = new LinearLayout(IndexTableActivity.this);
        parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        parent.setPadding(10, 0, 10, 0);
        parent.setBackgroundResource(R.drawable.bg_roundedgray);
        parent.setOrientation(LinearLayout.VERTICAL);
        // editText = new EditText(IndexTableActivity.this);
        // editText.setCompoundDrawablesWithIntrinsicBounds(0, 0,
        // R.drawable.ic_action_search, 0);
        // editText.setHint("Physician Name/Patch");
        // editText.addTextChangedListener(watcher);
        // editText.setLayoutParams(new android.view.ViewGroup.LayoutParams(
        // android.view.ViewGroup.LayoutParams.MATCH_PARENT,
        // android.view.ViewGroup.LayoutParams.WRAP_CONTENT));

        View v = getLayoutInflater().inflate(R.layout.edit_with_search, null);
        v.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
        final EditText editText = (EditText) v.findViewById(R.id.search);
        editText.addTextChangedListener(watcher);
        ImageView search_close = (ImageView) v.findViewById(R.id.search_close);
        search_close.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                editText.setText("");
            }
        });

        for (int i = 0; i < Drname.length; i++) {
            String[] str = {Drname[i], Specialty[i], Class[i]};
            dataList.add(str);
        }

        lv = new ListView(IndexTableActivity.this);
        lv.setVisibility(View.INVISIBLE);
        lv.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
        adapter = new CustomAdapterForPhysiiSearch(IndexTableActivity.this,
                dataList);
        lv.setAdapter(adapter);
        lv.setPadding(5, 0, 5, 5);
        parent.addView(v);
        parent.addView(lv);
        return parent;
    }

    TextWatcher watcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            // TODO Auto-generated method stub
            if (s.toString().equals(""))
                lv.setVisibility(View.INVISIBLE);
            else {
                lv.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(s.toString());
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

        }
    };
}