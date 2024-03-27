package com.example.user.fortunesticks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;

public class screentable_display extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener{

    private WindowManager manager;
    private LinearLayout touchLayout;
    WindowManager.LayoutParams params ;
    ArrayList<String> arr ;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16
            ,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30,btn31,btn32
            ,btn33,btn34,btn35,btn36,btn37,btn38,btn39,btn40,btn41,btn42,btn43,btn44,btn45,btn46,btn47,btn48
            ,btn49,btn50,btn51,btn52,btn53,btn54,btn55,btn56,btn57,btn58,btn59,btn60,btn61,btn62,btn63,btn64;

    private Button btn_Entry_show1;
    private TableLayout mTableLayout;
    ProgressDialog mProgressBar;
    private String[]  letter ={"移居","壽年","求財","脫貨","收成","置產","陞遷","晴雨"};
    int temp = 0;
    int final_select = 0;
    String Reciver_Str ,conver_final_str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screentable_display);

        //fetch window manager object
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
//        touchLayout = new LinearLayout(screentable_display.this);
//        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//        touchLayout.setBackgroundColor(Color.rgb(23,25,100));
//        touchLayout.setLayoutParams(ll);
        touchLayout = (LinearLayout)findViewById(R.id.parent_layout);

        manager = (WindowManager)getSystemService(WINDOW_SERVICE);
        //manager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        //mView = LayoutInflater.from(this).inflate(R.layout.activity_screentable_display, null);

        params = new WindowManager.LayoutParams( 400, 150, WindowManager.LayoutParams.TYPE_PHONE,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE ,PixelFormat.RGBX_8888);
//        params = new WindowManager.LayoutParams(.
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.TYPE_PHONE,
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                PixelFormat.TRANSLUCENT
//        );
        params.x = 0;
        params.y = 0;
        params.gravity = Gravity.CENTER | Gravity.CENTER;
        //  manager.addView(touchLayout, params);
        touchLayout.setOnTouchListener(this);

        mTableLayout = (TableLayout) findViewById(R.id.tablayout);
        mTableLayout.setStretchAllColumns(true);

        Declare_Button_attr_add_listen();
        load_table_button();

        Intent intent = getIntent();
        Reciver_Str = intent.getStringExtra("DemoVer");
//        Toast.makeText(screentable_display.this, "DemoVer為-> "+Reciver_Str,Toast.LENGTH_LONG).show();
    }

    public void  Declare_Button_attr_add_listen(){
        btn1  = (Button) findViewById(R.id.bw1);        btn2  = (Button) findViewById(R.id.bw2);
        btn3  = (Button) findViewById(R.id.bw3);        btn4  = (Button) findViewById(R.id.bw4);
        btn5  = (Button) findViewById(R.id.bw5);        btn6  = (Button) findViewById(R.id.bw6);
        btn7  = (Button) findViewById(R.id.bw7);        btn8  = (Button) findViewById(R.id.bw8);

        btn9  = (Button) findViewById(R.id.bw9);        btn10  = (Button) findViewById(R.id.bw10);
        btn11  = (Button) findViewById(R.id.bw11);      btn12  = (Button) findViewById(R.id.bw12);
        btn13  = (Button) findViewById(R.id.bw13);      btn14  = (Button) findViewById(R.id.bw14);
        btn15  = (Button) findViewById(R.id.bw15);      btn16  = (Button) findViewById(R.id.bw16);

        btn17  = (Button) findViewById(R.id.bw17);      btn18  = (Button) findViewById(R.id.bw18);
        btn19  = (Button) findViewById(R.id.bw19);      btn20  = (Button) findViewById(R.id.bw20);
        btn21  = (Button) findViewById(R.id.bw21);      btn22  = (Button) findViewById(R.id.bw22);
        btn23  = (Button) findViewById(R.id.bw23);      btn24  = (Button) findViewById(R.id.bw24);

        btn25  = (Button) findViewById(R.id.bw25);      btn26  = (Button) findViewById(R.id.bw26);
        btn27  = (Button) findViewById(R.id.bw27);      btn28  = (Button) findViewById(R.id.bw28);
        btn29  = (Button) findViewById(R.id.bw29);      btn30  = (Button) findViewById(R.id.bw30);
        btn31  = (Button) findViewById(R.id.bw31);      btn32  = (Button) findViewById(R.id.bw32);

        btn33  = (Button) findViewById(R.id.bw33);      btn34  = (Button) findViewById(R.id.bw34);
        btn35  = (Button) findViewById(R.id.bw35);      btn36  = (Button) findViewById(R.id.bw36);
        btn37  = (Button) findViewById(R.id.bw37);      btn38  = (Button) findViewById(R.id.bw38);
        btn39  = (Button) findViewById(R.id.bw39);      btn40  = (Button) findViewById(R.id.bw40);

        btn41  = (Button) findViewById(R.id.bw41);      btn42  = (Button) findViewById(R.id.bw42);
        btn43  = (Button) findViewById(R.id.bw43);      btn44  = (Button) findViewById(R.id.bw44);
        btn45  = (Button) findViewById(R.id.bw45);      btn46  = (Button) findViewById(R.id.bw46);
        btn47  = (Button) findViewById(R.id.bw47);      btn48  = (Button) findViewById(R.id.bw48);

        btn49  = (Button) findViewById(R.id.bw49);      btn50  = (Button) findViewById(R.id.bw50);
        btn51  = (Button) findViewById(R.id.bw51);      btn52  = (Button) findViewById(R.id.bw52);
        btn53  = (Button) findViewById(R.id.bw53);      btn54  = (Button) findViewById(R.id.bw54);
        btn55  = (Button) findViewById(R.id.bw55);      btn56  = (Button) findViewById(R.id.bw56);

        btn57  = (Button) findViewById(R.id.bw57);      btn58  = (Button) findViewById(R.id.bw58);
        btn59  = (Button) findViewById(R.id.bw59);      btn60  = (Button) findViewById(R.id.bw60);
        btn61  = (Button) findViewById(R.id.bw61);      btn62  = (Button) findViewById(R.id.bw62);
        btn63  = (Button) findViewById(R.id.bw63);      btn64  = (Button) findViewById(R.id.bw64);

        btn_Entry_show1 = (Button) findViewById(R.id.btn_screentable_entry);

        btn1.setOnClickListener(screentable_display.this);        btn2.setOnClickListener(screentable_display.this);
        btn3.setOnClickListener(screentable_display.this);        btn4.setOnClickListener(screentable_display.this);
        btn5.setOnClickListener(screentable_display.this);        btn6.setOnClickListener(screentable_display.this);
        btn7.setOnClickListener(screentable_display.this);        btn8.setOnClickListener(screentable_display.this);
        btn9.setOnClickListener(screentable_display.this);        btn10.setOnClickListener(screentable_display.this);
        btn11.setOnClickListener(screentable_display.this);       btn12.setOnClickListener(screentable_display.this);
        btn13.setOnClickListener(screentable_display.this);       btn14.setOnClickListener(screentable_display.this);
        btn15.setOnClickListener(screentable_display.this);       btn16.setOnClickListener(screentable_display.this);
        btn17.setOnClickListener(screentable_display.this);       btn18.setOnClickListener(screentable_display.this);
        btn19.setOnClickListener(screentable_display.this);       btn20.setOnClickListener(screentable_display.this);
        btn21.setOnClickListener(screentable_display.this);       btn22.setOnClickListener(screentable_display.this);
        btn23.setOnClickListener(screentable_display.this);       btn24.setOnClickListener(screentable_display.this);
        btn25.setOnClickListener(screentable_display.this);       btn26.setOnClickListener(screentable_display.this);
        btn27.setOnClickListener(screentable_display.this);       btn28.setOnClickListener(screentable_display.this);
        btn29.setOnClickListener(screentable_display.this);       btn30.setOnClickListener(screentable_display.this);
        btn31.setOnClickListener(screentable_display.this);       btn32.setOnClickListener(screentable_display.this);
        btn33.setOnClickListener(screentable_display.this);       btn34.setOnClickListener(screentable_display.this);
        btn35.setOnClickListener(screentable_display.this);       btn36.setOnClickListener(screentable_display.this);
        btn37.setOnClickListener(screentable_display.this);       btn38.setOnClickListener(screentable_display.this);
        btn39.setOnClickListener(screentable_display.this);       btn40.setOnClickListener(screentable_display.this);
        btn41.setOnClickListener(screentable_display.this);       btn42.setOnClickListener(screentable_display.this);
        btn43.setOnClickListener(screentable_display.this);       btn44.setOnClickListener(screentable_display.this);
        btn45.setOnClickListener(screentable_display.this);       btn46.setOnClickListener(screentable_display.this);
        btn47.setOnClickListener(screentable_display.this);       btn48.setOnClickListener(screentable_display.this);
        btn49.setOnClickListener(screentable_display.this);       btn50.setOnClickListener(screentable_display.this);
        btn51.setOnClickListener(screentable_display.this);       btn52.setOnClickListener(screentable_display.this);
        btn53.setOnClickListener(screentable_display.this);       btn54.setOnClickListener(screentable_display.this);
        btn55.setOnClickListener(screentable_display.this);       btn56.setOnClickListener(screentable_display.this);
        btn57.setOnClickListener(screentable_display.this);       btn58.setOnClickListener(screentable_display.this);
        btn59.setOnClickListener(screentable_display.this);       btn60.setOnClickListener(screentable_display.this);
        btn61.setOnClickListener(screentable_display.this);       btn62.setOnClickListener(screentable_display.this);
        btn63.setOnClickListener(screentable_display.this);       btn64.setOnClickListener(screentable_display.this);
        btn_Entry_show1.setOnClickListener(screentable_display.this);

//        btn_Entry_show1.setBackgroundColor( Color.rgb(120,190,14));
//        btn_Entry_show1.setTextColor(Color.rgb(0,0,204));
//        btn_Entry_show1.setText("★使用測字神卦占卜★");
    }

    public void find_book2_loacation( Button btton ,int start,int end,String str){
//      DisplayMetrics metrics = new DisplayMetrics();
//      getWindowManager().getDefaultDisplay().getMetrics(metrics);
//      int heightPixels = (int)(metrics.heightPixels/10.0);
//      int buttonWidth = (int)(metrics.widthPixels/3.5);
//      ViewGroup.LayoutParams params = btn1.getLayoutParams();
        //調整button型態
        int buttonWidth = (int) (getWindow().getDecorView().getWidth() / 3.0);
        TableRow.LayoutParams params = (TableRow.LayoutParams) btton.getLayoutParams();
        params.height = (int)(getWindow().getDecorView().getHeight()/10.0);
        //params.width = buttonWidth;
        if(str =="rt"){
            params.width = buttonWidth;
            params.rightMargin = buttonWidth/10;
        }else if(str =="lt"){
            params.width = (int)(buttonWidth);
            params.setMargins(-200,0,0,0);
        }
        //params.rightMargin = -(buttonWidth*100);
        //params.height = heightPixels;
        btton.setLayoutParams(params);
        btton.setTextColor(Color.WHITE);
        btton.setBackgroundColor(Color.rgb(	25 ,25, 112));
        btton.setTextSize(25);
        //亂數選取範圍內有含(end)
        final_select = (int) (Math.random() * (end - start + 1) + start);
//      Toast.makeText(screentable_display.this, "亂數選取為->"+String.valueOf(select),Toast.LENGTH_LONG).show();
    }

    public void load_table_button(){
        FrameLayout flt = new FrameLayout(this);
        flt.setLayoutParams(new ViewGroup.MarginLayoutParams(350,70));
        TableRow.LayoutParams pa = new TableRow.LayoutParams();
        pa.span = 8;//this spans the title row across 8 columns
        TableRow tr1 = new TableRow(this);

        for(int bt = 0 ; bt < 8 ; bt++){
            //  String ss = "bw"+bt;
            Button btview = new Button(this);
            if(bt == 0)
                btview.setGravity(Gravity.LEFT);
            btview.setLayoutParams(new ViewGroup.LayoutParams(40,55));
            btview.setLayoutParams(new ViewGroup.MarginLayoutParams(10,10));
            btview.setTypeface(null, Typeface.BOLD);
            btview.setBackgroundColor(Color.GREEN);
            btview.setText("測試");
            btview.setId(Integer.parseInt(String.valueOf(bt)));
            //tools:ignore="DuplicateIds,InvalidId"
            btview.setTextColor(Color.rgb(127,255,212));
            tr1.addView(btview,pa);
        }
        flt.addView(tr1);
        mTableLayout.addView(flt);
    }

    @Override
    public void onDestroy() {
        if(manager!= null) {
            if(params!= null)
                manager.removeView(touchLayout);
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        temp = (int)(Math.random()* 8 + 1);
        if (i == R.id.bw1) {
            find_book2_loacation(btn1, 346, 353, "rt");
        } else if (i == R.id.bw2) {
            find_book2_loacation(btn2, 442, 448, "rt");
        } else if (i == R.id.bw3) {
            find_book2_loacation(btn3, 169, 176, "rt");
        } else if (i == R.id.bw4) {
            if(temp == 8 ){
                find_book2_loacation(btn4, 354, 354, "rt");
            }else{
                find_book2_loacation(btn4, 356, 362, "rt");
            }
        } else if (i == R.id.bw5) {
            find_book2_loacation(btn5, 113, 120, "lt");
        } else if (i == R.id.bw6) {
            find_book2_loacation(btn6, 418, 425, "lt");
        } else if (i == R.id.bw7) {
            find_book2_loacation(btn7, 322, 329, "lt");
        } else if (i == R.id.bw8) {
            find_book2_loacation(btn8, 371, 378, "lt");
        } else if (i == R.id.bw9) {
            find_book2_loacation(btn9, 41 , 48 , "rt");
        } else if (i == R.id.bw10) {
            find_book2_loacation(btn10, 137 , 144 , "rt");
        } else if (i == R.id.bw11) {
            find_book2_loacation(btn11, 238 ,245  , "rt");
        } else if (i == R.id.bw12) {
            find_book2_loacation(btn12, 73 , 80 , "rt");
        } else if (i == R.id.bw13) {
            find_book2_loacation(btn13, 222 , 229 , "lt");
        } else if (i == R.id.bw14) {
            find_book2_loacation(btn14, 230 , 237 , "lt");
        } else if (i == R.id.bw15) {
            find_book2_loacation(btn15, 33 , 40 , "lt");
        } else if (i == R.id.bw16) {
            find_book2_loacation(btn16, 426 , 433 , "lt");
        } else if (i == R.id.bw17) {
            find_book2_loacation(btn17,  209 , 216  , "rt");
        } else if (i == R.id.bw18) {
            find_book2_loacation(btn18, 481  , 488  , "rt");
        }else if (i == R.id.bw19) {
            find_book2_loacation(btn19, 270  ,277   , "rt");
        }else if (i == R.id.bw20) {
            find_book2_loacation(btn20,  49 , 56  , "rt");
        }else if (i == R.id.bw21) {
            find_book2_loacation(btn21, 97  , 104  , "lt");
        }else if (i == R.id.bw22) {
            find_book2_loacation(btn22, 17  ,  24 , "lt");
        }else if (i == R.id.bw23) {
            find_book2_loacation(btn23, 81  , 88  , "lt");
        }else if (i == R.id.bw24) {
            if(temp == 8 ){
                find_book2_loacation(btn24, 177  , 177  , "lt");
            }else{
                find_book2_loacation(btn24, 186  , 192  , "lt");
            }
        }else if (i == R.id.bw25) {
            find_book2_loacation(btn25, 489  ,  496 , "rt");
        } else if (i == R.id.bw26) {
            find_book2_loacation(btn26,65   ,  72 , "rt");
        }else if (i == R.id.bw27) {
            find_book2_loacation(btn27, 410  , 417  , "rt");
        }else if (i == R.id.bw28) {
            find_book2_loacation(btn28, 121  , 128  , "rt");
        }else if (i == R.id.bw29) {
            find_book2_loacation(btn29,  57 , 64  , "lt");
        }else if (i == R.id.bw30) {
            find_book2_loacation(btn30, 153  , 160  , "lt");
        }else if (i == R.id.bw31) {
            find_book2_loacation(btn31, 457  , 464  , "lt");
        }else if (i == R.id.bw32) {
            if(temp%2 == 0)
                find_book2_loacation(btn32, 217  ,  220 , "lt");
            else
                find_book2_loacation(btn32, 310  , 313  , "lt");
        }else if (i == R.id.bw33) {
            if(temp == 8 ){
                find_book2_loacation(btn33,  355 , 355  , "rt");
            }else{
                find_book2_loacation(btn33,  387 , 393  , "rt");
            }
        } else if (i == R.id.bw34) {
            find_book2_loacation(btn34,  201 ,  208 , "rt");
        }else if (i == R.id.bw35) {
            find_book2_loacation(btn35,105   , 112  , "rt");
        }else if (i == R.id.bw36) {
            find_book2_loacation(btn36, 278  , 285  , "rt");
        }else if (i == R.id.bw37) {
            find_book2_loacation(btn37, 302  ,  309 , "lt");
        }else if (i == R.id.bw38) {
            find_book2_loacation(btn38,  402 , 409  , "lt");
        }else if (i == R.id.bw39) {
            find_book2_loacation(btn39, 338  , 345  , "lt");
        }else if (i == R.id.bw40) {
            find_book2_loacation(btn40,  246 , 253  , "lt");
        }else if (i == R.id.bw41) {
            find_book2_loacation(btn41,  178 ,  185 , "rt");
        } else if (i == R.id.bw42) {
            find_book2_loacation(btn42, 89  ,  96 , "rt");
        }else if (i == R.id.bw43) {
            find_book2_loacation(btn43, 394  ,  401 , "rt");
        }else if (i == R.id.bw44) {
            find_book2_loacation(btn44, 434  , 441  , "rt");
        }else if (i == R.id.bw45) {
            find_book2_loacation(btn45,  161 ,  168 , "lt");
        }else if (i == R.id.bw46) {
            find_book2_loacation(btn46, 314  ,  321 , "lt");
        }else if (i == R.id.bw47) {
            find_book2_loacation(btn47,  497 , 504  , "lt");
        }else if (i == R.id.bw48) {
            find_book2_loacation(btn48, 473  , 480  , "lt");
        }else if (i == R.id.bw49) {
            find_book2_loacation(btn49, 9  ,  16 , "rt");
        } else if (i == R.id.bw50) {
            find_book2_loacation(btn50, 505  ,  512 , "rt");
        }else if (i == R.id.bw51) {
            find_book2_loacation(btn51,  465 , 472  , "rt");
        }else if (i == R.id.bw52) {
            find_book2_loacation(btn52, 379  ,386   , "rt");
        }else if (i == R.id.bw53) {
            find_book2_loacation(btn53,  1 ,  8 , "lt");
        }else if (i == R.id.bw54) {
            if(temp == 8 )
                find_book2_loacation(btn54, 221  ,  221 , "lt");
            else
                find_book2_loacation(btn54, 450  ,  456 , "lt");
        }else if (i == R.id.bw55) {
            find_book2_loacation(btn55, 330  , 337  , "lt");
        }else if (i == R.id.bw56) {
            find_book2_loacation(btn56, 25  ,  32 , "lt");
        }else if (i == R.id.bw57) {
            find_book2_loacation(btn57,  254 , 261  , "rt");
        }else if (i == R.id.bw58) {
            find_book2_loacation(btn58,  294 ,  301 , "rt");
        }else if (i == R.id.bw59) {
            find_book2_loacation(btn59,  286 , 293  , "rt");
        }else if (i == R.id.bw60) {
            find_book2_loacation(btn60, 193  , 200  , "rt");
        }else if (i == R.id.bw61) {
            find_book2_loacation(btn61, 145  ,  152 , "lt");
        }else if (i == R.id.bw62) {
            find_book2_loacation(btn62, 262  , 269  , "lt");
        }else if (i == R.id.bw63) {
            find_book2_loacation(btn63,  363 , 370  , "lt");
        }else if (i == R.id.bw64) {
            find_book2_loacation(btn64, 129  , 136  , "lt");
        }

        if(i == R.id.btn_screentable_entry){
            // Toast.makeText(screentable_display.this, "check_btn_" + "id = " + String.valueOf(R.id.btn_screentable_entry), Toast.LENGTH_LONG).show();
            Intent heaearIntent = new Intent(screentable_display.this, HeavenAndEarth.class);
            //final send strVer
            String  strnum = String.valueOf(3);
            heaearIntent.putExtra("Select_Num", strnum);
            btn_Entry_show1.setBackgroundColor( getResources().getColor(R.color.RedhotPixel));
            btn_Entry_show1.setTextColor(Color.WHITE);
            btn_Entry_show1.setText("進入中>>>");
            screentable_display.this.startActivity(heaearIntent);
        }else{
            //change Display_Csv_Text activity from screen
            String result;
            Intent screenIntent = new Intent(screentable_display.this, Display_Csv_Text.class);
            conver_final_str = String.valueOf(final_select);
            //final send string -> result
            result = Reciver_Str + "," + conver_final_str;
            screenIntent.putExtra("final_string", result);
            screentable_display.this.startActivity(screenIntent);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
