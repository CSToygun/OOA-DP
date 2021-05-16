package com.company;
import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostgreSQL implements IVeritabani
{


        private static PostgreSQL instance;
        private PrintWriter out;
        private String kullaniciAdi= null;
        private String kullaniciId=null;
        private String sifre=null;
        private static List kisiler = new ArrayList();
        private static List sifreler = new ArrayList();
        private static List idler = new ArrayList();

        public PostgreSQL()
        {
            try
            {
                Class.forName("org.postgresql.Driver");

                /***** Bağlantı kurulumu *****/
                Connection conn = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "Postgre123");


                String sql= "SELECT \"kullaniciAdi\", \"sifre\", \"kullaniciNo\"  FROM \"Internet_Kullanicisi\"";

                /***** Sorgu çalıştırma *****/
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                /***** Bağlantı sonlandırma *****/
                conn.close();



                while(rs.next())
                {
                    /***** Kayda ait alan değerlerini değişkene ata *****/
                    kullaniciAdi  = rs.getString("kullaniciAdi");
                    kullaniciId= rs.getString("kullaniciNo");
                    sifre = rs.getString("sifre");

                    kisiler.add(kullaniciAdi);
                    sifreler.add(sifre);
                    idler.add(kullaniciId);
                }

                /***** Kaynakları serbest bırak *****/
                rs.close();
                stmt.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //senkrizasyon sağlanıyor
        public static synchronized PostgreSQL getInstance(){

            if(instance==null)

                instance = new PostgreSQL();

            return instance;

        }

        public List KisiIdGonder()
        {
            return idler;
        }


        /*********Kullanici dogrulama sistemi*************/

        public boolean kullaniciDogrula(String kullaniciadi, String sifre) {

            PostgreSQL vtys= new PostgreSQL();
            System.out.println("Veritabani dogrulama sistemi kullanıcıyı doğruluyor...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i=0;i<kisiler.size();i++)

            {
                if(kullaniciadi.compareTo((String)(kisiler.get(i)))==0&&sifre.compareTo((String)(sifreler.get(i)))==0)
                {
                    System.out.println(kullaniciadi+ " "+ sifre+"   Kullanici dogrulandi");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return true;
                }

            }

            return false;

        }
}
