package com.company;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici,IKontrol
{
    boolean durum = false;
   private float sicaklik = 0;

    public void ac()
    {
        System.out.println("Sıcaklik Algılayıcı Açılıyor");
    }
    public void kapat()
    {
        System.out.println("Sıcaklık Algılayıcı Kapatılıyorr");
    }

    ISubject publisher;

    public SicaklikAlgilayici(ISubject publisher)
    {
        this.publisher = publisher;
    }


    public float Sicakli_Olc()
    {
        Random rastgele=new Random();
        sicaklik=rastgele.nextInt(51);
        return this.sicaklik;
    }
    public void setSicaklik(float sicaklik) {
        this.sicaklik = sicaklik;
        publisher.notify(sicaklik);
    }
}