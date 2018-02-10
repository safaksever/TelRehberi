package com.example.safak.telrehberi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends Activity {

    EditText editName1,editTel1,editMail1;
    TextView textView;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editName1 = (EditText) findViewById(R.id.editName1);
        editTel1 = (EditText) findViewById(R.id.editTel1);
        editMail1 = (EditText) findViewById(R.id.editMail1);
        textView = (TextView) findViewById(R.id.textView);
        dbHelper = new DbHelper(this);

        Intent i = getIntent();
        int id = i.getIntExtra("idd",0);
        String isim = i.getStringExtra("ism");
        String tel = i.getStringExtra("tele");
        String mail = i.getStringExtra("email");
        textView.setText(String.valueOf(id));
        editName1.setText(isim);
        editTel1.setText(tel);
        editMail1.setText(mail);
    }

    public void reverse(View v){
        Intent i = new Intent(EditActivity.this,MainActivity.class);
        startActivity(i);
    }

    public void duzelt(View v){
        int id = Integer.parseInt(textView.getText().toString());
        String isim = editName1.getText().toString();
        String tel = editTel1.getText().toString();
        String mail = editMail1.getText().toString();
        dbHelper.kisiDuzelt(id,isim,tel,mail);
        Toast.makeText(getApplicationContext(),"DÜZELTİLDİ",Toast.LENGTH_LONG).show();
    }

    public void sil(View v){
        int id = Integer.parseInt(textView.getText().toString());
        editName1.setText("");
        editTel1.setText("");
        editMail1.setText("");
        Kontak k = new Kontak(id);
        dbHelper.kisiSil(k.getId());
        Toast.makeText(getApplicationContext(),"SİLİNDİ",Toast.LENGTH_LONG).show();
    }
}