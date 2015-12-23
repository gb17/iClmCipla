package com.cirrius.iclmcipla;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class CustomScrollViewDash extends ScrollView {
    int count = 0;
    Dashboard dash = new Dashboard();


    public CustomScrollViewDash(Context context) {
        super(context);
    }

    public CustomScrollViewDash(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public CustomScrollViewDash(Context context, AttributeSet attrs,
                                int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        LinearLayout innerView = (LinearLayout) getChildAt(0);
        for (int i = 0; i < innerView.getChildCount(); i++) {
            if (t >= innerView.getChildAt(i).getTop()
                    && t <= innerView.getChildAt(i).getBottom()) {
                dash.changeHeader(i);
                break;
            }
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
