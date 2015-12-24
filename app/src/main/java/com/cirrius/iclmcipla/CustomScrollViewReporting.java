package com.cirrius.iclmcipla;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class CustomScrollViewReporting extends ScrollView {
    int count = 0;
    ReportingTabs physicians = new ReportingTabs();

    public CustomScrollViewReporting(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public CustomScrollViewReporting(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public CustomScrollViewReporting(Context context, AttributeSet attrs,
                                     int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    // @Override
    // protected void onScrollChanged(int l, int t, int oldl, int oldt) {
    // // TODO Auto-generated method stub
    // super.onScrollChanged(l, t, oldl, oldt);
    // if (count > 1) {
    // if (oldt < t) {
    // // hide
    // physicians.set(1);
    // } else if (oldt > t) {
    // // show
    // physicians.set(0);
    // }
    // } else
    // count++;
    // }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        // View view = (View) getChildAt(0);
        // LinearLayout ll = (LinearLayout) view;
        // View newView = ll.getChildAt(0);
        // Rect scrollBounds = new Rect();
        // getHitRect(scrollBounds);
        // if (newView.getLocalVisibleRect(scrollBounds)) {
        // System.out.println("Me----->Visible");
        // } else {
        // System.out.println("Me----->INVisible");
        // // NONE of the imageView is within the visible window
        // }
        // View view = (View) getChildAt(0);
        // if (t <= 200) {
        // physicians.set(0);
        // } else {
        // physicians.set(1);
        // }

        LinearLayout ll = (LinearLayout) getChildAt(0);
//
//        View view = (View) ll.getChildAt(getChildCount() - 1);
//        int pos = getTop();

//        if (t <= pos - 70) {
//            // reaches the top end
//            physicians.set(0);// show
//        } else {
//            int diff = (view.getBottom() - (getHeight() + getScrollY() + view
//                    .getTop()));//
//            if (diff <= 0) {
//                // physicians.set(0);// show
//            } else {
//                physicians.set(1);// hide
//            }
//        }
        LinearLayout innerView = (LinearLayout) ll.getChildAt(0);
        for (int i = 0; i < innerView.getChildCount(); i++) {
            if (t >= innerView.getChildAt(i).getTop() + 50
                    && t <= innerView.getChildAt(i).getBottom() + 50) {
                physicians.changeHeader(i);
                break;
            }
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
