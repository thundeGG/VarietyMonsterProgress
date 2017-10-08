package com.thunder.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thunder.varietymonsterprogress.VarietyMonsterProgress;

public class MainActivity extends AppCompatActivity {

    private VarietyMonsterProgress mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress = (VarietyMonsterProgress) findViewById(R.id.progress);
        mProgress.setCount(6);
        mProgress.setSelected(2);
        mProgress.setRadius(50);
        mProgress.setSelectedColor(getResources().getColor(R.color.c_00A5FE));
        mProgress.setNormalColor(getResources().getColor(R.color.c_bdbdbd));
        mProgress.setSpacing(20);
    }
}
