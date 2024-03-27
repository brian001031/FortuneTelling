package com.example.user.fortunesticks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class HeavenAndEarth extends AppCompatActivity implements NumberPicker.Formatter,NumberPicker.OnValueChangeListener,View.OnClickListener {

    private Context mContext;
    private TextView mTextView;
    NumberPicker mPick_sky, mPick_land,mPick_person;
    private String[] myNumber  = {"1","2","3","4","5","6","7","8"};

    int[] pickitem ={R.id.Picker1,R.id.picker2,R.id.picker3};
    int pick_val1,pick_val2,pick_val3,total_pick = 0;
    String Reciver_Str ,conver_final_str="";
    private Button  btn_ori_main, btn_entry_csv;
    private TextView tvw_goto_liu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heaven_and_earth);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        mContext = getApplicationContext();

        btn_ori_main = (Button) findViewById(R.id.btn_return_main);
        tvw_goto_liu = (TextView) findViewById(R.id.tvw_teacher);
        btn_entry_csv = (Button) findViewById(R.id.btn_entry);

        btn_ori_main.setOnClickListener(this);
        tvw_goto_liu.setOnClickListener(this);
        btn_entry_csv.setOnClickListener(this);

        set_picknumber_all();

        Intent intent = getIntent();
        Reciver_Str = intent.getStringExtra("Select_Num");
        //   Toast.makeText(HeavenAndEarth.this, "DemoVer為-> "+Reciver_Str,Toast.LENGTH_LONG).show();

        //Toast.makeText(HeavenAndEarth.this, "選取為->"+String.valueOf(total_pick),Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("WrongViewCast")
    private void set_picknumber_all(){
        for(int t = 0; t < pickitem.length ; t++){
            if(t == 0 ){
                mPick_sky = (NumberPicker) findViewById(pickitem[t]);
                mPick_sky.setDisplayedValues(myNumber);//設定需要顯示的陣列
                mPick_sky.setMinValue(1);
                mPick_sky.setMaxValue(myNumber.length);//這兩行不能缺少,不然只能顯示第一個，關聯到format方法
                setPickerDividerColor(t);
                setNumberPickerTextColor(mPick_sky,Color.RED);
                pick_val1 = mPick_sky.getMinValue()*100;
                mPick_sky.setOnValueChangedListener(this);
            } else if(t == 1) {
                mPick_land = (NumberPicker) findViewById(pickitem[t]);
                mPick_land.setDisplayedValues(myNumber);//設定需要顯示的陣列
                mPick_land.setMinValue(1);
                mPick_land.setMaxValue(myNumber.length);//這兩行不能缺少,不然只能顯示第一個，關聯到format方法
                setPickerDividerColor(t);
                setNumberPickerTextColor(mPick_land, Color.RED);
                pick_val2= mPick_land.getMinValue()*10;
                mPick_land.setOnValueChangedListener(this);
            }else {
                mPick_person = (NumberPicker) findViewById(pickitem[t]);
                mPick_person.setDisplayedValues(myNumber);//設定需要顯示的陣列
                mPick_person.setMinValue(1);
                mPick_person.setMaxValue(myNumber.length);//這兩行不能缺少,不然只能顯示第一個，關聯到format方法
                setPickerDividerColor(t);
                setNumberPickerTextColor(mPick_person, Color.RED);
                pick_val3 = mPick_person.getMinValue();
                mPick_person.setOnValueChangedListener(this);
            }
        }
        total_pick = pick_val1 + pick_val2 + pick_val3;
        // Toast.makeText(HeavenAndEarth.this, "選取為->"+String.valueOf(total_pick),Toast.LENGTH_SHORT).show();
    }
    //這個方法是根據index 格式化的文字,需要先 implements NumberPicker.Formatter
    @Override
    public String format(int value) {
        return myNumber[value];
    }

    /**
     * 通過反射改變分割線顏色,
     */
    private void setPickerDividerColor(int num) {
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try{
                    if(num == 0)
                        pf.set(mPick_sky,new ColorDrawable(Color.BLUE));
                    else if(num == 1)
                        pf.set(mPick_land,new ColorDrawable(Color.BLUE));
                    else
                        pf.set(mPick_person,new ColorDrawable(Color.BLUE));
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                }catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color)
    {
        final int count = numberPicker.getChildCount();
        for(int i = 0; i < count; i++){
            View child = numberPicker.getChildAt(i);
            if(child instanceof EditText){
                try{
                    Field selectorWheelPaintField = numberPicker.getClass()
                            .getDeclaredField("mSelectorWheelPaint");
                    selectorWheelPaintField.setAccessible(true);
                    ((Paint)selectorWheelPaintField.get(numberPicker)).setColor(color);
                    ((EditText)child).setTextColor(color);
                    // ((EditText)child).setTextSize(23,0.2f);
                    numberPicker.invalidate();
                    return true;
                }
                catch(NoSuchFieldException e){
                    //  Log.w("setTextColor", e);
                }
                catch(IllegalAccessException e){
                    //   Log.w("setTextColor", e);
                }
                catch(IllegalArgumentException e){
                    // Log.w("setTextColor", e);
                }
            }
        }
        return false;
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        total_pick = 0;
        if(picker == mPick_sky)
            pick_val1 = (picker.getValue())*100;
        else if(picker == mPick_land)
            pick_val2 = (picker.getValue())*10;
        else if(picker == mPick_person)
            pick_val3= picker.getValue();
        total_pick = pick_val1 + pick_val2 + pick_val3;
        //   Toast.makeText(HeavenAndEarth.this, "選取為->"+String.valueOf(total_pick),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int i = (v.getId());
        if (i == R.id.btn_return_main) {
            Intent Intent;
            Intent = new Intent(HeavenAndEarth.this, MainActivity.class);
            HeavenAndEarth.this.startActivity(Intent);
        }else if ( i == R.id.tvw_teacher) {
            Intent Intent;
            Intent = new Intent(HeavenAndEarth.this, Mister_liu_picture.class);
            HeavenAndEarth.this.startActivity(Intent);
        }else if (i == R.id.btn_entry ) {
            String result;
            Intent csvIntent = new Intent(HeavenAndEarth.this, Display_Csv_Text.class);
            conver_final_str = String.valueOf(total_pick);
            //final send string -> result
            result = Reciver_Str + "," + conver_final_str;
            csvIntent.putExtra("final_string", result);
            HeavenAndEarth.this.startActivity(csvIntent);
        }
    }
}
