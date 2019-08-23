package support.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class ItalicTextView extends AppCompatTextView {


    public ItalicTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ItalicTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItalicTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/avenirnext-italic.ttf");
            setTypeface(tf);
        }
    }

}