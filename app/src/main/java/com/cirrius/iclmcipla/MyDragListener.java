package com.cirrius.iclmcipla;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnDragListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

@SuppressLint("NewApi")
class MyDragListener implements OnDragListener {
    Context context;
    ArrayList<RelativeLayout> arrList;
    int index = 0;

    public MyDragListener(Context context, ArrayList<RelativeLayout> arrList,
                          int index) {
        this.context = context;
        this.arrList = arrList;
        this.index = index;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        event.getAction();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            case DragEvent.ACTION_DRAG_ENTERED:

                break;
            case DragEvent.ACTION_DRAG_EXITED:

                // v.setBackgroundDrawable(normalShape);

                break;
            case DragEvent.ACTION_DROP:

                ViewGroup parent = (ViewGroup) v.getParent();
                if (parent instanceof GridView) {
                    int chance = parent.indexOfChild(v);
                    View view = (View) event.getLocalState();
                    int chance2 = parent.indexOfChild(view);
                    if (chance2 == -1) {
                        LinearLayout ll = (LinearLayout) view.getParent();
                        ll.removeView(view);
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        relativeLayout.setLayoutParams(new GridView.LayoutParams(
                                GridView.LayoutParams.WRAP_CONTENT,
                                GridView.LayoutParams.WRAP_CONTENT));
                        arrList.add(chance, relativeLayout);
                        GridView grid = (GridView) parent;
                        GridAdapter adapter = new GridAdapter(context, arrList,
                                index);
                        grid.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } else {
                        arrList.remove(chance2);
                        arrList.add(chance2, (RelativeLayout) v);
                        arrList.remove(chance);
                        arrList.add(chance, (RelativeLayout) view);

                        GridView grid = (GridView) parent;
                        GridAdapter adapter = new GridAdapter(context, arrList,
                                index);
                        grid.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                        RelativeLayout rl = (RelativeLayout) parent.getParent();
                        ImageView im = (ImageView) rl.getChildAt(4);
                        im.setVisibility(View.VISIBLE);
                    }
                }

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                break;
            default:
                break;
        }
        return true;
    }
}
