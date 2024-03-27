package com.example.user.fortunesticks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.provider.CalendarContract;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.fortunesticks.MarqueeTextView;
import com.example.user.fortunesticks.R;

import static android.view.View.OVER_SCROLL_IF_CONTENT_SCROLLS;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private TextView mTextView;

    private Context mContext;
    private Activity mActivity;

    private CoordinatorLayout mCLayout;
    private WindowManager mWindowManager;
    private View mView;
    int[] point = new int[2];
    int xAsis ,yAxis; //get Location position(ALL SCREEN)
    private int select = 2; //1: button-mode 2: text-mode
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        MarqueeTextView MarqueeTV = new MarqueeTextView(this);
        MarqueeTV.setWidth(577);
        MarqueeTV.setHeight(205);
        MarqueeTV.setBackgroundColor(Color.rgb(186 ,85 ,211));
        MarqueeTV.setText("~心   誠   則   靈  -   有  問  必  答  ~ ");
        MarqueeTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 34);
        MarqueeTV.setTextColor(Color.rgb(255,20,147));

        LinearLayout baseRL = (LinearLayout) findViewById(R.id.coordinator_layout);

        baseRL.addView(MarqueeTV, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        MarqueeTV.scrollText(5);
//        mTextView = (TextView) findViewById(R.id.tv);
//        mTextView.setFocusable(true);
//
//        // Programmatically set text view ellipsize marquee
//        mTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
////        // Set marquee repeat limit (unlimited)
//        mTextView.setMarqueeRepeatLimit(-1);
////        // Make it a single line text view;
//        mTextView.setHorizontallyScrolling(true);
//
//        // Make the text view focusable in touch mode
//       mTextView.setFocusable(true);
//       mTextView.setFocusableInTouchMode(true);
//       mTextView.setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);

        mView = (LinearLayout)findViewById(R.id.coordinator_layout);
        mView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int i = v.getId();
        if (i == R.id.coordinator_layout) {
            switch_Hexagram_display(event); //切換至籤詩表單頁
           // getXY(event);
        }

        return false;
    }

    private void switch_Hexagram_display(MotionEvent e){
        int x = (int)e.getX();
        int y = (int)e.getY();
        Intent mainIntent;
        String temp ;
        if( x > 425 && x< 786 && y > 2039 && y< 2087){
            mainIntent = new Intent(MainActivity.this,  Mister_liu_picture.class);
            MainActivity.this.startActivity(mainIntent);
        }else {
            if (select == 1) {
                mainIntent = new Intent(MainActivity.this, screentable_display.class);
                temp = String.valueOf(select);
                mainIntent.putExtra("DemoVer", temp);
                MainActivity.this.startActivity(mainIntent);
            }
            else if (select == 2) {
                mainIntent = new Intent(MainActivity.this, select_textActivity.class);
                temp = String.valueOf(select);
                mainIntent.putExtra("DemoVer", temp);
                MainActivity.this.startActivity(mainIntent);
            } else if (select == 3) {
                mainIntent = new Intent(MainActivity.this, HeavenAndEarth.class);
                MainActivity.this.startActivity(mainIntent);
            }
        }
        MainActivity.this.finish();
    }

    protected void getXY(MotionEvent  e){
        //mView.getLocationOnScreen(point); // or getLocationInWindow(point)
        mView.getLocationInWindow(point); // or getLocationInWindow(point)
        Rect globeRect = new Rect();
        mView.getLocalVisibleRect(globeRect);
        int x = (int)e.getX();
        int y = (int)e.getY();

        xAsis = point[0];
        yAxis = point[1];

        //Toast.makeText(MainActivity.this,"X axis is "+ xAsis +"and Y axis is "+yAxis,Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this,"test = "+globeRect.toString(),Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this,"X axis is "+ x +"and Y axis is "+y,Toast.LENGTH_LONG).show();
    }
}
