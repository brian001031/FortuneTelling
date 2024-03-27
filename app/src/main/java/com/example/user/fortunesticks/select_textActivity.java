package com.example.user.fortunesticks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class select_textActivity extends AppCompatActivity implements View.OnClickListener{

    private WindowManager manager;
    private LinearLayout touchLayout;
    WindowManager.LayoutParams params ;
    ArrayList<String> arr ;
    private TableLayout mTableLayout;
    ProgressDialog mProgressBar;
    private TextView t1v;
    ArrayList<TextView>  tv_list = new ArrayList<TextView>();
    TextView[] tvlist = new TextView[64];
    private TextView  random_text;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private AtomicInteger lastFldId = null;
    private String[]  letter ={"移居","壽年","求財","脫貨","收成","置產","陞遷","晴雨",
            "分家","行人","放賬","生意","夜夢","官運","六甲","運途",
            "身體","學藝","風水","文件","同居","工作","交易","求醫",
            "親病","失物","開店","收帳","出行","告狀","調解","取討",
            "買屋","走失","回鄉","修宅","桃花","買貨","婚姻","姻緣",
            "求職","合夥","買畜","飼養","求子","納吏","選舉","學業",
            "子病","護送","賭博","訴狀","口舌","徵人","娶妻","公職",
            "洽約","家宅","借財","見貴","住宿","音信","尋人","考運"
    };
    private int cellcount = 0,test = 0;
    int[]  tempid = new int[56];
    private AnimationDrawable anna;
    Button run_btn,vbt;
    int temp = 0,tvw_check  = 0;
    int final_select = 0;
    String Reciver_Str,conver_final_str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_text);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        touchLayout = (LinearLayout)findViewById(R.id.table_textletter);
        manager = (WindowManager)getSystemService(WINDOW_SERVICE);
        //manager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        //mView = LayoutInflater.from(this).inflate(R.layout.activity_screentable_display, null);

        params = new WindowManager.LayoutParams( 400, 150, WindowManager.LayoutParams.TYPE_PHONE,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE ,PixelFormat.RGBX_8888);
        params.x = 0;
        params.y = 0;
        params.gravity = Gravity.CENTER | Gravity.CENTER;
        mTableLayout = (TableLayout) findViewById(R.id.selectedlayout);
        mTableLayout.setStretchAllColumns(true);
        init();

        Intent intent = getIntent();
        Reciver_Str = intent.getStringExtra("DemoVer");
//      Toast.makeText(screentable_display.this, "DemoVer為-> "+Reciver_Str,Toast.LENGTH_LONG).show();
    }

    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.selectedlayout);
        TableRow.LayoutParams tvSepLay = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        tvSepLay.span = 8;
        // add separator row
        TableRow tbrow0 = new TableRow(this);
        tbrow0.setLayoutParams(tvSepLay);
        TextView tv0 = new TextView(this);
        tv0.setText(" 籤詩項目▼ ");
        tv0.setTextSize(23.5f);
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Pro ");
        tv1.setTextColor(Color.RED);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Unit ");
        tv2.setTextColor(Color.GREEN);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText("Remaining ");
        tv3.setTextColor(Color.RED);
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText(" Tool ");
        tv4.setTextColor(Color.rgb(212,55,120));
        tbrow0.addView(tv4);
        TextView tv5 = new TextView(this);
        tv5.setText(" USA ");
        tv5.setTextColor(Color.GREEN);
        tbrow0.addView(tv5);
        TextView tv6 = new TextView(this);
        tv6.setText(" POP ");
        tv6.setTextColor(Color.BLUE);
        tbrow0.addView(tv6);
        TextView tv7 = new TextView(this);
        tv7.setText("Check");
        tv7.setTextColor(Color.RED);
        tbrow0.addView(tv7);
        stk.addView(tbrow0);

        for (int i = 0; i < 8; i++) {
            TableRow tbrow = new TableRow(this);
            tbrow.setVerticalGravity(View.TEXT_ALIGNMENT_CENTER);
            tbrow.setHorizontalGravity(View.TEXT_ALIGNMENT_CENTER);
            TableRow.LayoutParams llp = new TableRow.LayoutParams(CoordinatorLayout.LayoutParams.WRAP_CONTENT,CoordinatorLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0, 0, 15, 10);//2px all-margin

            //New Cell
            LinearLayout cell = new LinearLayout(this);
            //cell.setBackgroundColor(Color.GREEN | Color.BLUE);
            cell.setBackgroundColor(Color.WHITE);
            cell.setHorizontalGravity(-10);
            cell.setVerticalGravity(-50);
            cell.setLayoutParams(llp);//2px border on the right for the cell
            cellcount++;
            for (int j = 0; j < 8; j++) {
                /*設定 TEXTVIEW NEW ID--start--*/
                int check = generateViewId3(cellcount+j);
                // set_textview_object( cellcount+j,check,cell);
                t1v = new TextView(getApplicationContext());
                t1v.setId(check);
                t1v.setText(letter[cellcount+j-1]);
                t1v.setTextSize(20.1f);
                if(j%3==0)
                    t1v.setTextColor(Color.rgb(48,213,200));
                else if(j%2==0)
                    t1v.setTextColor(Color.rgb(255,69,0));
                else
                    t1v.setTextColor(Color.rgb(34,195,46));
                t1v.setGravity(Gravity.CENTER);
                t1v.setPadding(3, 3, 3, 3);
                t1v.setClickable(true);
                t1v.setOnClickListener(select_textActivity.this);
                cell.addView(t1v);
//                String textId = "row_cell_"+Integer.toString(cellcount+j);
//                int id = getResources().getIdentifier(textId, "id", "com.example.user.marqee_test");
//                tvlist[cellcount+j-1] = (TextView) findViewById(id);
//                tvlist[cellcount+j-1] = t1v;
//                tvlist[cellcount+j-1].setOnClickListener(select_textActivity.this);
//                if(j%3==0)
//                    tvlist[cellcount+j-1].setTextColor(Color.rgb(48,213,200));
//                else if(j%2==0)
//                    tvlist[cellcount+j-1].setTextColor(Color.rgb(255,69,0));
//                else
//                    tvlist[cellcount+j-1].setTextColor(Color.rgb(34,195,46));
//                tvlist[cellcount+j-1].setGravity(Gravity.CENTER);
//                tvlist[cellcount+j-1].setPadding(5, 5, 5, 5);
//                //cell.addView(t1v);
//                cell.addView(tvlist[cellcount+j-1]);
            }
            tbrow.addView(cell);
            tbrow.setBackgroundColor(Color.YELLOW);
            tbrow.setWeightSum(80); //total row weight
            //tbrow.setPadding(0,0,10,10);
            stk.addView(tbrow);
            cellcount+=7;
        }

        for(int k = 0 ; k < 2 ; k++){
            //Button vbt = new Button(this);
            vbt = new Button(this);
            TableRow.LayoutParams lps = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            vbt.setLayoutParams(lps);
            vbt.setTextSize(25);
            vbt.setPadding(0,50,0,30);
            vbt.setMinHeight(50);
            if( k == 1){
                vbt.setId(R.id.check_btn);
                vbt.setText("使用測字神卦占卜▼");
                vbt.setClickable(true);
                vbt.setOnClickListener(this);
                //  vbt.setBackgroundColor(Color.WHITE);
                //   vbt.setBackground(getDrawable(R.drawable.animation_check_btn));
                // run_btn = vbt;
                //
                //vbt = (Button)findViewById(R.id.check_btn);
                vbt.setBackground(getDrawable(R.drawable.animation_check_btn));
                anna = (AnimationDrawable)vbt.getBackground();
                anna.setEnterFadeDuration(2500);
                anna.setExitFadeDuration(2300);
            }else{
                vbt.setBackgroundColor(Color.YELLOW);
            }
            stk.addView(vbt);
        }
        //tbrow0.setPadding(10,10,10,10);
        stk.setMinimumHeight(130);
        stk.setBackgroundColor(Color.BLACK);
    }

    public int generateViewId3(int num){
        lastFldId = null ;
        if(lastFldId == null) {
            int maxFld = 0;
            maxFld = num ;
            String fldName = "";
            Field[] flds = R.id.class.getDeclaredFields();

            //R.id inst = new R.id();

            for (int i = 0; i < flds.length; i++) {
                Field fld = flds[i];
                try {
                    //int value = fld.getInt(inst);
                    int value = fld.getInt(flds[i]);
                    String temp = fld.getName();
                    //if (value == maxFld)
                    //String select = "row_cell_"+Integer.toString(num);
                    String snum = String.valueOf(num);
                    String select = "row_cell_"+snum;
                    //  String select = "row_cell_8";
                    //row_cell_1
                    if(temp.equals(select) == true)
                    {
                        maxFld = value;
                        fldName = fld.getName();
                        break;
                    }
                } catch (IllegalAccessException e) {
                    //       Log.e(TAG(), "error getting value for \'"+ fld.getName() + "\' " + e.toString());
                }
            }
            // Log.d(TAG(), "maxId="+maxFld +"  name="+fldName);
            lastFldId = new AtomicInteger(maxFld);
        }
        return lastFldId.addAndGet(0);
    }

    public void find_book2_loacation_textview( TextView tvw ,int start,int end){
        //調整TextView型態
        //params.rightMargin = -(buttonWidth*100);
        //params.height = heightPixels;
        tvw.setTextColor(Color.rgb(255 ,255, 148));
        tvw.setBackgroundColor(Color.rgb(60,119, 119));
        tvw.setTextSize(55);
        //亂數選取範圍內有含(end)
        final_select = (int) (Math.random() * (end - start + 1) + start);
        //       Toast.makeText(select_textActivity.this, "亂數選取為->"+String.valueOf(select),Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(anna!=null && !anna.isRunning())
        {
            anna.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(anna!=null && anna.isRunning())
        {
            anna.stop();
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        int st = 0 , ed = 0;
        temp = (int)(Math.random()* 8 + 1);
        random_text = (TextView)findViewById(i);
        if (i == R.id.row_cell_1) {
//          Toast.makeText(select_textActivity.this, "cell_Name" + "id = " + String.valueOf(R.id.row_cell_1), Toast.LENGTH_LONG).show();
            st = 346; ed = 353;
        } else if (i == R.id.row_cell_2) {
            st = 442 ; ed = 448;
        } else if (i == R.id.row_cell_3) {
            st = 169 ; ed = 176;
        } else if (i == R.id.row_cell_4) {
            if(temp == 8 ){
                st = 354; ed = 354;
            }else{
                st = 356 ; ed = 362;
            }
        } else if (i == R.id.row_cell_5) {
            st = 113; ed = 120;
        }else if (i == R.id.row_cell_6) {
            st = 418; ed = 425;
        } else if (i == R.id.row_cell_7) {
            st = 322; ed = 329;
        } else if (i == R.id.row_cell_8) {
            st = 371; ed = 378;
        } else if (i == R.id.row_cell_9) {
            st = 41; ed = 48;
        }else if (i == R.id.row_cell_10) {
            st = 137; ed = 144;
        } else if (i == R.id.row_cell_11) {
            st = 238; ed = 245;
        } else if (i == R.id.row_cell_12) {
            st = 73; ed = 80;
        } else if (i == R.id.row_cell_13) {
            st = 222; ed = 229;
        }else if (i == R.id.row_cell_14) {
            st = 230; ed = 237;
        }else if (i == R.id.row_cell_15) {
            st = 33; ed = 40;
        }else if (i == R.id.row_cell_16) {
            st = 426; ed = 433;
        }else if (i == R.id.row_cell_17) {
            st = 209; ed = 216;
        }else if (i == R.id.row_cell_18) {
            st = 481; ed = 488;
        }else if (i == R.id.row_cell_19) {
            st = 270; ed = 277;
        }else if (i == R.id.row_cell_20) {
            st = 49; ed = 56;
        }else if (i == R.id.row_cell_21) {
            st = 97; ed = 104;
        }else if (i == R.id.row_cell_22) {
            st = 17; ed = 24;
        }else if (i == R.id.row_cell_23) {
            st = 81; ed = 88;
        }else if (i == R.id.row_cell_24) {
            if(temp == 8 ){
                st = 177; ed = 177;
            }else{
                st = 186; ed = 192;
            }
        }else if (i == R.id.row_cell_25) {
            st = 489; ed = 496;
        }else if (i == R.id.row_cell_26) {
            st = 65; ed = 72;
        }else if (i == R.id.row_cell_27) {
            st = 410; ed = 417;
        }else if (i == R.id.row_cell_28) {
            st = 121; ed = 128;
        }else if (i == R.id.row_cell_29) {
            st = 57; ed = 64;
        }else if (i == R.id.row_cell_30) {
            st = 153 ; ed = 160;
        }else if (i == R.id.row_cell_31) {
            st = 457 ; ed = 464;
        }else if (i == R.id.row_cell_32) {
            if(temp%2 == 0) {
                st = 217;ed = 220;
            }else{
                st = 310; ed = 313;
            }
        }else if (i == R.id.row_cell_33) {
            if(temp == 8 ){
                st = 355; ed = 355;
            }else{
                st = 387 ; ed = 393;
            }
        }else if (i == R.id.row_cell_34) {
            st = 201; ed = 208;
        }else if (i == R.id.row_cell_35) {
            st = 105; ed = 112;
        }else if (i == R.id.row_cell_36) {
            st = 278; ed = 285;
        }else if (i == R.id.row_cell_37) {
            st = 302; ed = 309;
        }else if (i == R.id.row_cell_38) {
            st = 402; ed = 409;
        }else if (i == R.id.row_cell_39) {
            st = 338; ed = 345;
        }else if (i == R.id.row_cell_40) {
            st = 246; ed = 253;
        }else if (i == R.id.row_cell_41) {
            st = 178; ed = 185;
        }else if (i == R.id.row_cell_42) {
            st =  89; ed = 96;
        }else if (i == R.id.row_cell_43) {
            st = 394; ed = 401;
        }else if (i == R.id.row_cell_44) {
            st = 434; ed = 441;
        }else if (i == R.id.row_cell_45) {
            st = 161; ed = 168;
        }else if (i == R.id.row_cell_46) {
            st = 314; ed = 321;
        }else if (i == R.id.row_cell_47) {
            st = 497; ed = 504;
        }else if (i == R.id.row_cell_48) {
            st = 473; ed = 480;
        }else if (i == R.id.row_cell_49) {
            st = 9; ed = 16;
        }else if (i == R.id.row_cell_50) {
            st = 505; ed = 512;
        }else if (i == R.id.row_cell_51) {
            st = 465; ed = 472;
        }else if (i == R.id.row_cell_52) {
            st = 379; ed = 386;
        }else if (i == R.id.row_cell_53) {
            st = 1; ed = 8;
        }else if (i == R.id.row_cell_54) {
            if(temp == 8 ){
                st = 221; ed = 221;
            }else{
                st = 450; ed = 456;
            }
        }else if (i == R.id.row_cell_55) {
            st = 330; ed = 337;
        }else if (i == R.id.row_cell_56) {
            st = 25; ed = 32;
        }else if (i == R.id.row_cell_57) {
            st = 254; ed = 261;
        }else if (i == R.id.row_cell_58) {
            st = 294; ed = 301;
        }else if (i == R.id.row_cell_59) {
            st = 286; ed = 293;
        }else if (i == R.id.row_cell_60) {
            st = 193; ed = 200;
        }else if (i == R.id.row_cell_61) {
            st = 145; ed = 152;
        }else if (i == R.id.row_cell_62) {
            st = 262; ed = 269;
        }else if (i == R.id.row_cell_63) {
            st = 363; ed = 370;
        }else if (i == R.id.row_cell_64) {
            st = 129; ed = 136;
        }

        if (i == R.id.check_btn) {
//            Toast.makeText(select_textActivity.this, "check_btn_" + "id = " + String.valueOf(R.id.check_btn), Toast.LENGTH_LONG).show();
            Intent heaearIntent = new Intent(select_textActivity.this, HeavenAndEarth.class);
            //final send strVer
            String  strnum = String.valueOf(3);
            heaearIntent.putExtra("Select_Num", strnum);
            select_textActivity.this.startActivity(heaearIntent);
        }else{
            find_book2_loacation_textview(random_text,st,ed);
            //change Display_Csv_Text activity from select_text
            String result;
            Intent textIntent = new Intent(select_textActivity.this, Display_Csv_Text.class);
            conver_final_str = String.valueOf(final_select);
            //final send string -> result
            result = Reciver_Str + "," + conver_final_str;
            textIntent.putExtra("final_string", result);
            select_textActivity.this.startActivity(textIntent);
        }
    }
}