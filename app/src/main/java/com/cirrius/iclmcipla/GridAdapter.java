package com.cirrius.iclmcipla;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<RelativeLayout> arrList;
    String[][] pageData;
    WebView webView;
    String menutext = "";
    int id = 2;
    String url = "";
    int index = 0;

    public GridAdapter(Context context, ArrayList<RelativeLayout> arrList,
                       int index) {
        this.context = context;
        this.arrList = arrList;
        this.index = index;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrList.size();
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

        if (convertView == null) {
            convertView = arrList.get(position);
        }
        if (index != 5) {
            arrList.get(position).setOnLongClickListener(new mylongclick());
            arrList.get(position).setOnDragListener(
                    new MyDragListener(context, arrList, index));
            arrList.get(0).setOnLongClickListener(new mylongclick());
            arrList.get(0).setOnDragListener(
                    new MyDragListener(context, arrList, index));
        }
        convertView.setLayoutParams(new GridView.LayoutParams(213,
                GridView.LayoutParams.WRAP_CONTENT));

        final GridView grid = (GridView) parent;

        RelativeLayout view = (RelativeLayout) convertView;
        ImageView delete = (ImageView) view.getChildAt(2);
        delete.setId(position);
        delete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int pos = v.getId();
                arrList.remove(pos);
                GridAdapter adapter;
                if (index == 0) {
                    adapter = new GridAdapter(context, arrList, 0);
                } else
                    adapter = new GridAdapter(context, arrList, 1);
                grid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        ImageView play = (ImageView) view.getChildAt(1);
        final RelativeLayout rl = (RelativeLayout) grid.getParent();
        play.setOnClickListener(new OnClickListener() {

            @SuppressLint("JavascriptInterface")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (index == 0) {
                    LinearLayout ll = (LinearLayout) rl.getParent();
                    RelativeLayout rl1 = (RelativeLayout) ll.getChildAt(2);
                    int imageId = (int) v.getTag();
                    if (rl1.getVisibility() == View.VISIBLE) {
                        ImageView im = (ImageView) rl1.getChildAt(0);
                        im.setImageResource(imageId);
                    } else {
                        final Dialog dialog = new Dialog(context);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        Display display = ((WindowManager) context
                                .getSystemService(context.WINDOW_SERVICE))
                                .getDefaultDisplay();
                        int width = display.getWidth();
                        int height = display.getHeight();
                        // ImageView imageView = new ImageView(context);
                        // imageView.setLayoutParams(new
                        // LinearLayout.LayoutParams(
                        // LinearLayout.LayoutParams.MATCH_PARENT,
                        // LinearLayout.LayoutParams.MATCH_PARENT));
                        // imageView.setImageResource(imageId);
                        dialog.setContentView(R.layout.container_dialog);
                        TextView cross = (TextView) dialog
                                .findViewById(R.id.cross);
                        Typeface font = Typeface.createFromAsset(
                                context.getAssets(), "fontawesome-webfont.ttf");
                        cross.setTypeface(font);
                        cross.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                dialog.dismiss();
                            }
                        });
                        webView = (WebView) dialog.findViewById(R.id.webview);
                        ImageView next = (ImageView) dialog
                                .findViewById(R.id.next);
                        next.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                displayNextPage(id);
                            }
                        });
                        webView.addJavascriptInterface(this, "javaObj");
                        webView.addJavascriptInterface(this, "cpjs");
                        displayFocussedBrands(1);

                        dialog.getWindow().setLayout(width - 80, height - 50);
                        dialog.getWindow().setBackgroundDrawable(
                                new ColorDrawable(
                                        android.graphics.Color.TRANSPARENT));
                        dialog.show();
                    }
                } else {
                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Display display = ((WindowManager) context
                            .getSystemService(context.WINDOW_SERVICE))
                            .getDefaultDisplay();
                    int width = display.getWidth();
                    int height = display.getHeight();
                    dialog.setContentView(R.layout.container_dialog);
                    TextView cross = (TextView) dialog.findViewById(R.id.cross);
                    Typeface font = Typeface.createFromAsset(
                            context.getAssets(), "fontawesome-webfont.ttf");
                    cross.setTypeface(font);
                    cross.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog.dismiss();
                        }
                    });
                    webView = (WebView) dialog.findViewById(R.id.webview);
                    ImageView next = (ImageView) dialog.findViewById(R.id.next);
                    next.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            displayNextPage(id);
                        }
                    });
                    webView.addJavascriptInterface(this, "javaObj");
                    webView.addJavascriptInterface(this, "cpjs");
                    displayFocussedBrands(1);

                    dialog.getWindow().setLayout(width - 80, height - 50);
                    dialog.getWindow().setBackgroundDrawable(
                            new ColorDrawable(
                                    android.graphics.Color.TRANSPARENT));
                    dialog.show();
                }
            }
        });
        if (index != 5) {
            ImageView im = (ImageView) rl.getChildAt(3);
            if (im.getVisibility() == View.VISIBLE) {
                delete.setVisibility(View.VISIBLE);
            } else
                delete.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    public final class mylongclick implements OnLongClickListener

    {

        @SuppressLint("NewApi")
        @Override
        public boolean onLongClick(View v) {

            // TODO Auto-generated method stub

            GridView gv = (GridView) v.getParent();
            RelativeLayout rl = (RelativeLayout) gv.getParent();
            ImageView im = (ImageView) rl.getChildAt(3);
            if (im.getVisibility() == View.VISIBLE) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
            }
            // } else {
            // ClipData data = ClipData.newPlainText("", "");
            // DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            // v.startDrag(data, shadowBuilder, v, 0);
            // }
            return true;

        }
    }

    public void displayFocussedBrands(int id) {
        String fd = "";
        ReadWriteData rw = new ReadWriteData(context, "MPOWERDB", null, 1);
        pageData = rw.getTableData("DVC", 9, " WHERE COL8 = 'F' ",
                "Order by CAST(COL9 as integer)");
        fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
        webView.getSettings().setPluginState(PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setAllowFileAccess(true);
        webView.setWebViewClient(new WebViewClient());

        final String url = "file:///android_asset/" + fd + "/"
                + pageData[id][1];
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(url);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void sendToAndroid(String text) {
        String menutext = text;
        for (int i = 0; i < pageData.length; i++) {
            if (pageData[i][1].equalsIgnoreCase(menutext + ".htm")) {
                id = i;
                break;
            }
        }
        displayNextPage(1);

    }

    private void displayNextPage(int page) {
        // TODO Auto-generated method stub
        if (page != 1) {
            if (id + 1 == pageData.length) {
            } else {
                id++;
            }
        }
        String fd = "";

        webView.cancelLongPress();

        webView.setVisibility(View.VISIBLE);
        try {
            if (page == 1) {
                fd = menutext.toUpperCase();
            } else {
                fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
            }
            if (page == 1) {
                url = "file:///android_asset/" + fd + "/" + menutext + ".htm";
            } else {
                url = "file:///android_asset/" + fd + "/" + pageData[id][1];
            }
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(url);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            // Utility.displayToast(this, "error is playing file");
        }

    }

}
