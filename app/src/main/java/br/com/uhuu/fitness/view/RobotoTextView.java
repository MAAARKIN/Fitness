package br.com.uhuu.fitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import br.com.uhuu.fitness.R;

/**
 * Created by Marquinhos on 08/02/15.
 */
public class RobotoTextView extends TextView {

    private String customTTF;

    public RobotoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        if (isInEditMode()) {

            return;

        }

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
        setTypeface(tf);
    }
}
