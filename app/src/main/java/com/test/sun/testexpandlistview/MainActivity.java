package com.test.sun.testexpandlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.test.sun.testexpandlistview.expandlistview.Main2Activity;
import com.test.sun.testexpandlistview.myexpandlistview.Main3Activity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout rootview = new LinearLayout(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootview.setOrientation(LinearLayout.VERTICAL);
        rootview.setLayoutParams(params);
        setContentView(rootview);

        Button bt1 = ButtonBuilder(rootview, "原生控件", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentX = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intentX);
            }
        });

        Button bt2 = ButtonBuilder(rootview, "自定义控件", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public Button ButtonBuilder(ViewGroup rootview, String name, View.OnClickListener listener) {
        Button button = new Button(this);
        button.setText(name);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
        button.setLayoutParams(params);
        rootview.addView(button);
        button.setOnClickListener(listener);
        return button;
    }

}
