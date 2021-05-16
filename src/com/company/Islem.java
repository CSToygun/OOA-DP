package com.company;

import java.util.Scanner;

public class Islem {
    SicaklikAlgilayici sicaklikalgila = new SicaklikAlgilayici(null);
    private float sicaklik = 0;
    private int sog_kontrol = 0;
    private int sic_kontrol = 0;
    Sogutucu sogutucu = new Sogutucu.Builder("Auto") /** Builder deseni için oluşturuldu **/
            .marka("Tsohiba")
            .model("Aıro")
            .hiz_seviye(1)
            .build();  /** En Son Sogutucu Nesnesi oluşturulur **/
    Erorr hata = new Erorr();

    public float Sicaklik_Gonder()
    {
        Subscriber1 s1 = new Subscriber1();
        Subscriber2 s2 = new Subscriber2(); /** Observer Tasarım Deseni için kullanıldı **/
        Publisher p = new Publisher();

        p.attach(s1);
        p.attach(s2);

        IKontrol cihaz=new SicaklikAlgilayici(p);  /**** The Dependency Inversion Principle (DIP) ilkesi için hazırlandı  ****/
        KOntrol buton=new KOntrol(cihaz);

        SicaklikAlgilayici sicaklikalgila2 = new SicaklikAlgilayici(p);

        if (sic_kontrol == 0)
        {
            buton.ac();
            this.sicaklik = sicaklikalgila.Sicakli_Olc();

            System.out.println("Sicaklik olculuyor, lutfen bekleyin");
            if (sicaklik > 15) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hata.Sicaklik_Hata(1);
                System.out.println(sicaklik + "°C");
            } else
                hata.Sicaklik_Hata(0);
            sic_kontrol++;
            sicaklikalgila2.setSicaklik(this.sicaklik);//observer için yazıldı
            buton.kapat();
            return this.sicaklik;

        }
        else
        {
            buton.ac();
            System.out.println("Sicaklik olculuyor, lutfen bekleyin");
            if (sicaklik > 15) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hata.Sicaklik_Hata(1);
                System.out.println(sicaklik + "°C");
            } else
                hata.Sicaklik_Hata(0);
            sicaklikalgila2.setSicaklik(this.sicaklik); //observer için yazıldı
            buton.kapat();
            return this.sicaklik;
        }
    }

    public void Acma_iStek_Gonder()
    {
        if(this.sicaklik != 0)
        {
            System.out.println("Mevcut Sıcaklık :"+sicaklik+ "°C");
            System.out.println("Düşürmek istediğiniz Sıcaklık Değerini Ayarlayınız :");
            Scanner secimm = new Scanner(System.in);
            sogutucu.SogutucuAc(sicaklik,secimm.nextInt(),sog_kontrol);
            if (sog_kontrol == 0)
            {
                this.sicaklik = sogutucu.sicaklik_loc ;
                this.sog_kontrol++;
            }
        }
        else
            hata.Sicaklik_Hata(sic_kontrol);
    }
    public void Kapatmaistek_Gonder()
    {
        System.out.println("Mevcut Sıcaklık :"+sicaklik+ "°C");
        sogutucu.SogutucuKapat(sog_kontrol);
        if (sog_kontrol != 0)
        {
            sog_kontrol--;
        }
    }

}
