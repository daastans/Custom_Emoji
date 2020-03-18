package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int bodyIndex;
    private int headIndex;
    private int legIndex;

    public String BODY_INDEX;
    public  String HEAD_INDEX;
    public String LEG_INDEX;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onImageSelected(int position){
        switch (position/12){
            case 0:headIndex=position;
            case 1:bodyIndex=position-12;
            case 3:legIndex=position-24;
        }

        Bundle information=new Bundle();

        information.putInt(BODY_INDEX,bodyIndex);
        information.putInt(LEG_INDEX,legIndex);
        information.putInt(HEAD_INDEX,headIndex);

        Button next=(Button) findViewById(R.id.next_button);

        final Intent intent=new Intent(this,AndroidMeActivity.class);
        intent.putExtras(information);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


    }
}
