package com.company;

import java.util.Random;

public class Sogutucu implements IKontrol
{
    private boolean durum = false;
    String CalismaMod = "Orta"; // ileride program geliştirilmek istendiğinde soğutucunun hızını ayarlamak için
    public float sicaklik_loc=0;
    private float sicaklik=0;
    public String marka;
    public String model;
    public int hiz_seviye;
    public String mod;

    private  Sogutucu( Builder builder) /** Builder desenleri için oluşturuldu **/
        {
            this.marka=builder.marka;
            this.model=builder.model;
            this.hiz_seviye=builder.hiz_seviye;
            this.mod= builder.mod;
        }

    public void ac()
    {
        System.out.println("SOgutucu Açılıyor");
    }
    public void kapat()
    {
        System.out.println("SOgutucu Kapatılıyorr");
    }
    public void SogutucuAc(float sicaklik,int secim,int kontrol)
    {
        if (kontrol ==0)
        {
            if ( secim >= sicaklik )
            {
                System.out.println("Lütfen Uygun Sıcaklık Değeri Seçiniz");
            }
            else
            {
                System.out.println("Soğutma İşlemi Başlıyor ...");
                do {
                    sicaklik--;
                    System.out.println("Sıcaklık : " + sicaklik+ "°C");
                    try {
                        Thread.sleep(1000);                 //1 saniye bekletir
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }while(sicaklik != secim);
                sicaklik_loc = sicaklik;
                System.out.println("Soğutma İşlemi Başarıyla Gerçekleşmiştir ...");
            }
        }
        else
        {
            System.out.println("Lütfen Önce SOğutucuyu Kapatınız ... ");
        }

    }
    public void SogutucuKapat(int kontrol)
    {
        if (kontrol == 0)
        {
            System.out.println("Soğutucunun Açık Olduğu Algılanamadı . Lütfen önce Açık olduğundan Emin olunuz !");
        }
        else
        {
            try {
                System.out.println("Soğutucu Kapatılıyor ...\n");
                Thread.sleep(2000);                 //1 saniye bekletir
                System.out.println("Soğutucu Kapatıldı !\n");
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }

    }

    public static class Builder {

        private String marka;
        private String model;
        private int hiz_seviye;
        private String mod;
        /*ISubject publisher;*/

        public Builder( String mod)
        {
            this.mod = mod;
        }

        public Builder marka(String marka) {
            this.marka = marka;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder hiz_seviye(int hiz) {
            this.hiz_seviye = hiz;
            return this;
        }

        /*public Builder publisher(ISubject publisher){
            this.publisher = publisher;
            return this;
        }*/

        public Sogutucu build(){
            return new Sogutucu(this);
        }
    }


}
