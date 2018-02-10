package com.example.safak.telrehberi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "rehberdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE kisi(id INTEGER PRIMARY KEY, isim TEXT, tel TEXT, mail TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS";
        db.execSQL(sql);
    }

    public int kisiEkle(String isim,String tel,String mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("isim",isim);
        val.put("tel",tel);
        val.put("mail",mail);
        return (int) db.insert("kisi",null,val);
    }

    public List<Kontak> kisiOku(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Kontak> list = new ArrayList<>();
        String[] kolon = {"id","isim","tel","mail"};
        Cursor c = db.query("kisi",kolon,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int id = c.getInt(0);
            String isim = c.getString(1);
            String tel = c.getString(2);
            String mail = c.getString(3);
            Kontak k = new Kontak(isim,tel,mail);
            k.setId(id);
            list.add(k);
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }

    public void kisiSil(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Kontak k = new Kontak(id);
        db.delete("kisi","id= "+k.getId(),null);
    }

    public void kisiDuzelt(int id,String isim,String tel,String mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("id",id);
        val.put("isim",isim);
        val.put("tel",tel);
        val.put("mail",mail);
        Kontak k = new Kontak(id);
        db.update("kisi", val, "id = "+ k.getId(),null);
    }
}