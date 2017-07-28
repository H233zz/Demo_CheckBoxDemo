package com.example.administrator.checkboxdome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> list;
    private ListView listView;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();


    }

    private void initview() {
        listView=(ListView) findViewById(R.id.lidtview);
        list=new ArrayList<>();
        for (int i=1;i<50;i++){
            Bean bean=new Bean();
            bean.name="推荐"+i;
            bean.ischeck=false;
            list.add(bean);
        }

        adapter=new MyAdapter(list,this);
        listView.setAdapter(adapter);
    }
}
