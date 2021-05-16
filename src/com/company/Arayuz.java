package com.company;

import java.util.Scanner;

public class Arayuz
{
     public void Arayuz_Yazdir()  {
          Scanner secimm = new Scanner(System.in);
          Islem islem_gerceklestir = new Islem();

          /***** Kullanıcının seçim yapması için tasarlandı *****/

          int secim;

          do {
               try {
                    Thread.sleep(1000);
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }

               System.out.println("\n\n1. Sıcaklık Goster");
               System.out.println("2. Sogutucu Ac");
               System.out.println("3. Sogutucuyu kapat");
               System.out.println("4. Cıkıs");

               secim = secimm.nextInt();
               while (secim < 1 || secim > 4) {
                    System.out.println("Lutfen menuye uygun secenek seciniz");
                    secim = secimm.nextInt();
               }

               switch (secim) { //Menüden seçilen işleme göre işlemin gerçekleştirilmesi sağlanır
                    case 1:
                         islem_gerceklestir.Sicaklik_Gonder();
                         break;
                    case 2:
                          islem_gerceklestir.Acma_iStek_Gonder();
                         break;
                    case 3:
                         islem_gerceklestir.Kapatmaistek_Gonder();
                         break;

                    case 4:
                         System.out.println("Uygulamadan cıkılmıstır.");
               }

          } while (secim != 4);
     }
     public void  KullaniciAl()
     {
          PostgreSQL postgreSQL = new PostgreSQL();

     };
}
