package com.example.safak.telrehberi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

    DbHelper dbHelper;
    EditText editName, editTel, editMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbHelper = new DbHelper(this);
        editName = (EditText) findViewById(R.id.editName);
        editTel = (EditText) findViewById(R.id.editTel);
        editMail = (EditText) findViewById(R.id.editMail);
    }

    public void kaydet(View v){
        String isim = editName.getText().toString();
        String tel = editTel.getText().toString();
        String mail = editMail.getText().toString();
        int id = dbHelper.kisiEkle(isim,tel,mail);
        Kontak k = new Kontak(isim,tel,mail);
        k.setId(id);
        Toast.makeText(this,"KAYDEDİLDİ",Toast.LENGTH_SHORT).show();
    }

    public void rvs(View v){
        Intent i = new Intent(AddActivity.this,MainActivity.class);
        startActivity(i);
    }
}