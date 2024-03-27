package com.example.user.fortunesticks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Mister_liu_picture extends AppCompatActivity implements  View.OnClickListener {

    private ImageView img_barcode;
    private TextView tvw;
    private Button btn_return_major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mister_liu_picture);

        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        img_barcode = (ImageView)findViewById(R.id.img_barcodeLiu);
        tvw = (TextView)findViewById(R.id.tvw_teacher);
        btn_return_major = (Button)findViewById(R.id.btn_return_from_Liu);
        btn_return_major.setOnClickListener(this);

        img_barcode.setMaxHeight(250);
        img_barcode.setMaxWidth(250);
        img_barcode.layout(125,20,50,158);

        tvw.setText(this.getResources().getString(R.string.misterLiu));
        tvw.setTextSize(23.5f);
    }

    @Override
    public void onClick(View v) {
        int i = (v.getId());
        if (i == R.id.btn_return_from_Liu) {
            Intent Intent;
            Intent = new Intent(Mister_liu_picture.this, MainActivity.class);
            Mister_liu_picture.this.startActivity(Intent);
        }
    }
}
