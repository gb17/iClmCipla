package com.cirrius.iclmcipla;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cirrius.expand.DataForMultilevelExpandableListView;
import com.cirrius.expand.DataForMultilevelExpandableListView.SubCategory;

import java.util.ArrayList;

public class PhysicianList implements ListView.OnScrollListener {
    private ArrayList<DataForMultilevelExpandableListView> pProductArrayList;

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Cardiologist|Vf-3|Class B",
            "General Practitioner|VF-1|Class A",
            "Chest Physician|VF-1|Class C", "Neurologist|VF-3|Class C",
            "General Practitioner|VF-1|Class B"};
    String[] TimeArr = {"10:30 am - 01:30 pm", "02:00 pm - 04:00 pm",
            "Class C", "Class C", "Class B", "Class B", "Class B", "Class A",
            "Class B", "Class C", "Class A"};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};

    String[] dateofmonth = {"17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30"};

    String[] dayofmonth = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "MON",
            "TUE", "WED", "THU", "FRI", "SAT", "MON", "TUE"};
    int seter;

    TextView t1, t2;
    TextView mItemName, mItemTime, mItemPrice, childtextview3, download;
    ImageView drImageView;
    ArrayList<String> docterN = new ArrayList<String>();
    String[] aplpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"};
    public final String[] Drname = {"Abbaye de Belloc",
            "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",

            "Baylough", "Beaufort", "Beauvoorde", "Beenleigh Blue",
            "Beer Cheese", "Bel Paese",

            "Canadian Cheddar", "Canestrato", "Cantal", "Caprice des Dieux",
            "Capricorn Goat",

            "Daralagjazsky", "Dauphin", "Delice des Fiouves",
            "Denhany Dorset Drum", "Derby",

            "Emental Grand Cru", "Emlett", "Emmental", "Epoisses de Bourgogne",
            "Esbareich",

            "Finlandia Swiss", "Finn", "Fiore Sardo", "Fleur du Maquis",
            "Flor de Guia",

            "Galloway Goat's Milk Gems", "Gammelost", "Gaperon a l'Ail",
            "Garrotxa", "Gastanberra",

            "Halloumy (Australian)", "Haloumi-Style Cheese", "Harbourne Blue",
            "Havarti",

            "Idiazabal", "Il Boschetto al Tartufo", "Ile d'Yeu",
            "Isle of Mull", "Jarlsberg", "Jermi Tortes", "Jibneh Arabieh",
            "Jindi Brie", "Jubilee Blue", "Juustoleipa", "Kadchgall", "Kaseri",
            "Kashta", "Kefalotyri", "Kenafa", "Kernhem", "Kervella Affine",

            "La Vache Qui Rit", "Laguiole", "Lairobell", "Lajta",
            "Lanark Blue", "Lancashire",

            "Macconais", "Mahoe Aged Gouda", "Mahon", "Malvern", "Mamirolle",
            "Manchego",

            "Neufchatel (Australian)", "Niolo", "Nokkelost", "Northumberland",
            "Oaxaca", "Olde York", "Olivet au Foin", "Olivet Bleu",
            "Olivet Cendre",

            "Pannerone", "Pant ys Gawn", "Parmesan (Parmigiano)",
            "Parmigiano Reggiano",

            "Quark (Australian)", "Quartirolo Lombardo", "Quatre-Vents",
            "Quercy Petit",

            "Reblochon", "Red Leicester", "Regal de la Dombes", "Reggianito",
            "Remedou",

            "Saanenkaese", "Saga", "Sage Derby", "Sainte Maure",
            "Saint-Marcellin",

            "Tasmania Highland Chevre Log", "Taupiniere", "Teifi", "Telemea",
            "Testouri", "Ulloa", "Vacherin-Fribourgeois", "Valencay",
            "Vasterbottenost", "Venaco", "Vendomois",

            "Washed Rind Cheese (Australian)", "Waterloo", "Weichkaese",
            "Wellington",

            "Xanadu", "Xynotyro", "Yarg Cornish", "Yarra Valley Pyramid",
            "Yorkshire Blue", "Zamorano", "Zanetti Grana Padano",
            "Zanetti Parmigiano Reggiano"};

    String[] month = {"JULY", "JULY", "JULY", "JULY", "JULY", "JULY", "JULY",
            "JULY", "JULY", "JULY", "JULY", "JULY", "JULY", "JULY"};

    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4};
    Typeface font;
    Context context;

    private RelativeLayout relativeforlist;
    private ListView listView, listview1;

    private ArrayList<SubCategory> pSubItemArrayList;

    public Listloader adapter;

    public PhysicianList(Context context) {

        this.context = context;

    }

    public class Listloader extends BaseAdapter {

        private Context context;

        public Listloader(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return Drname.length;// pProductArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolderItemL viewHolder;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.exrow_third, null);
                viewHolder = new ViewHolderItemL();
                viewHolder.mItemName = (TextView) convertView
                        .findViewById(R.id.eventsListEventRowText);

                viewHolder.mItemTime = (TextView) convertView
                        .findViewById(R.id.time);

                viewHolder.drImageView = (ImageView) convertView
                        .findViewById(R.id.dr_image);
                viewHolder.mItemPrice = (TextView) convertView
                        .findViewById(R.id.textViewItemPrice);

                viewHolder.childtextview3 = (TextView) convertView
                        .findViewById(R.id.childtextview3);

                TextView menufordr = (TextView) convertView
                        .findViewById(R.id.menufordr);
                // menufordr.setTypeface(font);

                final LinearLayout layout = (LinearLayout) convertView
                        .findViewById(R.id.childiewoflist);
                final RelativeLayout mask = (RelativeLayout) convertView
                        .findViewById(R.id.masklay);
                viewHolder.download = (TextView) convertView
                        .findViewById(R.id.download);
                final LinearLayout ll = (LinearLayout) convertView
                        .findViewById(R.id.retry);

                final ProgressBar pb = (ProgressBar) convertView
                        .findViewById(R.id.progressBar1);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolderItemL) convertView.getTag();
            }

            viewHolder.download.setTypeface(font);

            int a = (int) position % 5;

            System.out.println(position);
            viewHolder.drImageView.setImageResource(imageDoctor[a]);
            viewHolder.mItemTime.setText(strTime[a]);
            viewHolder.mItemName.setText(docterN.get(position));
            viewHolder.mItemPrice.setText(Specialty[a]);
            viewHolder.childtextview3.setText(Class[a]);

            // mItemName.setText(itemName);
            // mItemTime.setText(itemTime);
            // mItemPrice.setText(itemPrice);
            // childtextview3.setText(itemClass);

            return convertView;

        }
    }

    public static class ViewHolderItemL {
        TextView mItemTime;
        TextView mItemPrice;

        TextView childtextview3;
        TextView mItemName;
        TextView download;
        ImageView drImageView;
    }

    public View loadlistview() {
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        relativeforlist = (RelativeLayout) inflater.inflate(
                R.layout.physicianlistview, null);

        t1 = (TextView) relativeforlist.findViewById(R.id.txt34);
        for (int i = 0; i < Drname.length; i++) {
            docterN.add(Drname[i]);
        }
        t1.setText("/ " + docterN.size());
        t2 = (TextView) relativeforlist.findViewById(R.id.txt35);

        t2.setText("" + 0);
        t2.setTextColor(Color.GREEN);
        listView = (ListView) relativeforlist.findViewById(R.id.mainList);
        listView.setOnScrollListener(this);
        listview1 = (ListView) relativeforlist.findViewById(R.id.alphaList);

        listview1.setAdapter(new ArrayAdapter<String>(context,
                R.layout.listviewtext, R.id.customtextview, aplpha));
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(context, Physicians.class);
                context.startActivity(intent);
            }
        });

        listview1.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    final int arg2, long arg3) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub

                        listView.post(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub

                                String selected = listview1.getItemAtPosition(
                                        arg2).toString();

                                for (int i = 0; i < docterN.size(); i++) {
                                    if (docterN.get(i).toUpperCase()
                                            .startsWith(selected)) {

                                        listView.setSelection(i);
                                        break;
                                    }
                                }
                            }
                        });
                    }
                }).start();

            }
        });

        adapter = new Listloader(context);
        listView.setAdapter(adapter);

        return relativeforlist;

    }

    @Override
    public void onScroll(AbsListView view, final int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // TODO Auto-generated method stub
        // t2.setText(""+firstVisibleItem);

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                if (firstVisibleItem != 0) {
                    final String firstLetter = docterN.get(firstVisibleItem);

                    listView.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            for (int i = 0; i < aplpha.length; i++) {
                                if (firstLetter.toUpperCase().startsWith(
                                        aplpha[i])) {
                                    listview1.setSelection(i);
                                    break;
                                }
                            }
                        }
                    });
                    // TODO Auto-generated method stub

                }
            }
        }).start();

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO Auto-generated method stub

    }

}
