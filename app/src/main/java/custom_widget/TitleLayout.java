package custom_widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.go_map.R;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attr)
    {
        super(context,attr);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button back=(Button)findViewById(R.id.title_back);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
}
