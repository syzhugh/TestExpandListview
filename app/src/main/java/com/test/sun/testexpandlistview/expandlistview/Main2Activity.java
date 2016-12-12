package com.test.sun.testexpandlistview.expandlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;

import com.test.sun.testexpandlistview.R;
import com.test.sun.testexpandlistview.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public static final String TAG = "TestVar";

    private ExpandableListView listView;
    private Madapter madapter;
    private List<List<TestBean>> list;
    private List<TestBean> grouplist;
    private List<TestBean> childlist;


    private int lastposition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        madapter.notifyDataSetChanged();
    }

    private void init() {
        list = new ArrayList<>();
        grouplist = new ArrayList<>();
        childlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            grouplist.add(new TestBean());
        }
        for (int i = 0; i < 20; i++) {
            childlist.add(new TestBean());
        }
        list.add(grouplist);
        list.add(childlist);


        madapter = new Madapter(getApplicationContext(), list);
        listView = (ExpandableListView) findViewById(R.id.native_view_expandlist);
        listView.setGroupIndicator(null);
        listView.setAdapter(madapter);

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = listView.getExpandableListAdapter().getGroupCount();
                for (int j = 0; j < count; j++) {
                    if (j != groupPosition) {
                        listView.collapseGroup(j);
                    }
                }
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.i(TAG, "Main2Activity:onScrollStateChanged----------------");
                Log.i(TAG, ":" + scrollState);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i(TAG, "Main2Activity:onScroll----------------");
                Log.i(TAG, "firstVisibleItem:" + firstVisibleItem);
                Log.i(TAG, "visibleItemCount:" + visibleItemCount);
                Log.i(TAG, "totalItemCount:" + totalItemCount);
            }
        });


    }


}
