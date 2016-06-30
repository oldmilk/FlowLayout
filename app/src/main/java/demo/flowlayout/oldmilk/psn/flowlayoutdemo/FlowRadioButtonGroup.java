package demo.flowlayout.oldmilk.psn.flowlayoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import psn.oldmilk.flowlayout.FlowLayout;

/**
 * Created by CarlChia on 27/6/16.
 */
public class FlowRadioButtonGroup extends FlowLayout implements View.OnClickListener {

    private static final String TAG = FlowRadioButtonGroup.class.getSimpleName();
    private RadioButton activeRadioButton;

    /**
     * @param context
     */
    public FlowRadioButtonGroup(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     */
    public FlowRadioButtonGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onClick(View v) {
        final RadioButton rb = (RadioButton) v;
        if ( activeRadioButton != null ) {
            activeRadioButton.setChecked(false);
        }
        rb.setChecked(true);
        activeRadioButton = rb;
    }

    /* (non-Javadoc)
     * @see android.widget.TableLayout#addView(android.view.View, int, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        setChildrenOnClickListener(child);
    }


    /* (non-Javadoc)
     * @see android.widget.TableLayout#addView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        setChildrenOnClickListener(child);
    }

    private void setChildrenOnClickListener(View v) {

        if(v instanceof FlowLayout) {
            final int c = ((FlowLayout)v).getChildCount();
            for (int i=0; i < c; i++) {
                final View childView = ((FlowLayout)v).getChildAt(i);
                if ( childView instanceof RadioButton) {
                    childView.setOnClickListener(this);
                }
            }
        } else if(v instanceof RadioButton) {
            v.setOnClickListener(this);
        }


    }

    public int getCheckedRadioButtonId() {
        if ( activeRadioButton != null ) {
            return activeRadioButton.getId();
        }

        return -1;
    }
}
