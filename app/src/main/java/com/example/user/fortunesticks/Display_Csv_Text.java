package com.example.user.fortunesticks;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Display_Csv_Text extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout relativeLayout;
    TextView t_first,t_second,t_third,t_fourth, t_fifth;
    Animation anim;
    ValueAnimator valueanim;
    int itry = 0;
    Thread thStart1,thStart2,thStart3;
    private Handler mHandler = new Handler();
    private  Runnable r;
    Context Displayctx = Display_Csv_Text.this;
    List<String[]> Csvlist;
    String[] sContentFinal;
    private ImageView img;
    int iPng = 0;
    private Button btn_back_main;

    //use Csv Class
    private Csv_Read csvRead;
    int checkTextColor = 0;
    int[] ImgArray = {R.drawable.ninehome999,R.drawable.iopphrt123,R.drawable.riverbrige123};
    String Reciver_result;
    int g_Ver , g_SelectNumber;
    String  Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__csv__text);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        relativeLayout =(RelativeLayout)findViewById(R.id.CsvLayout);
        img =(ImageView)findViewById(R.id.imageGodMan);
        t_first = (TextView)findViewById(R.id.firsttext);
        t_second = (TextView)findViewById(R.id.Secondtext );
        t_third = (TextView)findViewById(R.id.Thirdtext);
        t_fourth = (TextView)findViewById(R.id.Fourthtext);
        t_fifth =  (TextView)findViewById(R.id.Fifthtext);
        btn_back_main = (Button) findViewById(R.id.bt_back_main);

        btn_back_main.setOnClickListener(this);

        anim = AnimationUtils.loadAnimation(Display_Csv_Text.this,R.anim.fadein);

        Intent intent = getIntent();
        Reciver_result = intent.getStringExtra("final_string");
        // first is Ver , second is selectNumber;
        String[] tokens = Reciver_result.split(",");
        g_Ver = Integer.parseInt(tokens[0]);
        g_SelectNumber = Integer.parseInt(tokens[1]);

        //prepare provide csv all content in here
        csvRead = new Csv_Read( g_Ver, g_SelectNumber,Displayctx);
        Csvlist = csvRead.ReadCSVData();

        iPng = g_SelectNumber;
        //如果大於3就取3得餘數作選取圖片
        if(iPng >= 3 )
            iPng = iPng %3;

        BackgroundImg(iPng);
        Title = CsvTitleText();
        TitleSetAndDisplayText(iPng,Title);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                while (itry < 4)
                {
                    try {
                        Thread.sleep(78);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    RunTextAnimation(itry);
                    itry++;
                }
            }
        },1000);

        Animation am = new TranslateAnimation(125,15,220,55);
        am.setDuration(780);
        am.setRepeatCount(1); //重複次數 -1->無限次
        //  am.setRepeatMode(Animation.REVERSE);
        img.setAnimation(am);
        am.startNow();
//Toast.makeText(Display_Csv_Text.this, "DisplayCsv 收到總字串為 -> "+Reciver_result,Toast.LENGTH_LONG).show();
    }

    private void BackgroundImg(int SelectNum) {
        switch (SelectNum)
        {
            case 0:
                relativeLayout.setBackgroundResource(ImgArray[0]);
                img.setImageResource(R.drawable.sta777r);
                checkTextColor = 0;
                break;
            case 1:
                relativeLayout.setBackgroundResource(ImgArray[1]);
                img.setImageResource(R.drawable.ricgod111);
                checkTextColor = 1;
                break;
            case 2:
                relativeLayout.setBackgroundResource(ImgArray[2]);
                img.setImageResource(R.drawable.tksgod);
                checkTextColor = 2;
                break;
            default:
                break;
        }
    }

    public String CsvTitleText()
    {
        //Serial && Title
        return Csvlist.get(0)[1].toString()+"-"+ Csvlist.get(0)[5].toString();
    }

    @SuppressLint("ResourceAsColor")
    private void TitleSetAndDisplayText(int COLOR_Num , String Title)
    {
        String sDisplayText="",sCONTENTSelect="";
        int Add = 0;

        //1. 設置Display 標題文字
        t_first.setText(Title);
        t_first.setTextSize(34);
        t_first.setTextColor( getResources().getColor(R.color.colorAccent3));

        //2. 設置Display 內容文字
        sCONTENTSelect = Csvlist.get(0)[6].toString();
        String[] sConfirm = sCONTENTSelect.split("，");
        sContentFinal = new String[4];
        for(int k = 0 ; k < sConfirm.length;k++)
        {
            sDisplayText += sConfirm[k]+",";
            if( (k+1)%2==0)
            {
                sDisplayText = sDisplayText.substring(0,sDisplayText.length()-1);
                sContentFinal[Add] = sDisplayText;
                sDisplayText ="";
                Add++;
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    public void RunTextAnimation(final int ack){
        if(ack == 0){
            t_second.setVisibility(View.VISIBLE);
            t_second.setText(sContentFinal[ack]);
            t_second.setTextColor(getResources().getColor(R.color.warmgreen));

//            if(checkTextColor == 0)
//                t_second.setTextColor(getResources().getColor(R.color.colorYellowdark));
//            else if(checkTextColor == 1)
//                t_second.setTextColor(getResources().getColor(R.color.RedhotPixel));
//            else if(checkTextColor == 2)
//                t_second.setTextColor(getResources().getColor(R.color.diverBlue));

            t_second.setAnimation(anim);

        } else if(ack == 1){
            t_third.setVisibility(View.VISIBLE);
            t_third.setText(sContentFinal[ack]);
            t_third.setTextColor(getResources().getColor(R.color.warmgreen));
            t_third.setAnimation(anim);
        } else if(ack == 2){
            t_fourth.setVisibility(View.VISIBLE);
            t_fourth.setText(sContentFinal[ack]);
            t_fourth.setTextColor(getResources().getColor(R.color.warmgreen));
            t_fourth.setAnimation(anim);
        } else if(ack == 3){
            t_fifth.setText(sContentFinal[ack]);
            t_fifth.setText(sContentFinal[ack]);
            t_fifth.setTextColor(getResources().getColor(R.color.warmgreen));
            t_fifth.setAnimation(anim);
        }
        //anim.startNow();
    }

    @Override
    public void onClick(View v) {
        int i = (v.getId());
        if (i == R.id.bt_back_main) {
            Intent Intent;
            Intent = new Intent(Display_Csv_Text.this, MainActivity.class);
            Display_Csv_Text.this.startActivity(Intent);
        }
    }
}
