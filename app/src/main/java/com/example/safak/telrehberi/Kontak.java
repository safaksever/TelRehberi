package com.example.safak.telrehberi;


public class Kontak {

    int id;
    String isim;
    String tel;
    String mail;

    public Kontak(String isim,String tel,String mail){
        this.isim = isim;
        this.tel = tel;
        this.mail = mail;
    }

    public Kontak(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String toString(){return isim+" ";}
}