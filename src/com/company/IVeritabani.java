package com.company;

import java.util.List;

/*****Birden fazla veritabanına uyarlanmak istenirse diye Interface kullanıldı****/
public interface IVeritabani
{
    public boolean kullaniciDogrula(String kullaniciadi, String sifre);
    public List KisiIdGonder();

}

