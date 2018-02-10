package com.example.safak.telrehberi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    ImageView iv;
    ListView listView;
    DbHelper dbHelper;
    List<Kontak> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
        iv.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
        dbHelper = new DbHelper(this);
        list = dbHelper.kisiOku();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Kontak k = (Kontak) adapter.getItem(i);
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("idd",k.getId());
                intent.putExtra("ism",k.getIsim());
                intent.putExtra("tele",k.getTel());
                intent.putExtra("email",k.getMail());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this,AddActivity.class);
        startActivity(i);
    }
}