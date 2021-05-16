package com.company;
import java.util.Scanner;
public class Calistir
{
    public static void main(String[] args) {
        PostgreSQL psql = new PostgreSQL();
        Scanner secimm = new Scanner(System.in);
        boolean durum=false;
        String kul_adi,pass;
        do {
            System.out.println("Kullanici Adi :");
            kul_adi = secimm.next();
            System.out.println("Password :");
            pass = secimm.next();
            durum = psql.kullaniciDogrula(kul_adi,pass);
            if (durum)
            {
                System.out.println(" Giriş Başarılı :)");
                Arayuz arayuz_yazdir = new Arayuz();
                arayuz_yazdir.Arayuz_Yazdir();
            }
            else
                System.out.println("Lütfen Tekrar Deneyiniz :( ");

        }while (true);
    }
}
