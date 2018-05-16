package cn.edu.sicnu.arcmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.edu.sicnu.arcmenu.view.ArcMenu;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArcMenu mArcMenu;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDatas));
        initEvent();
    }

    private void initEvent() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (mArcMenu.isOpen())
                    mArcMenu.toggleMenu(600);
            }
        });
        mArcMenu.setOnMenuItemClickListener(new ArcMenu.OnMenuItemClickListener() {
            @Override
            public void onClick(View view, int pos) {
                Toast.makeText(MainActivity.this, pos + ":" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mListView = findViewById(R.id.id_listView);
        mArcMenu = findViewById(R.id.id_arc_menu);
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add((char) i + "");
        }
    }
}
