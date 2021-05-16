package com.company;

public class Erorr
{
    int hatakodu = 0;
    public boolean Sogutucu_Hata(int signal)
    {
        if ( signal == 0)
        {
            System.out.println("Soğutma Sırasında Hata Meydana Geldi ");
            return false;
        }
        else
            return true;

    }
    public boolean Sicaklik_Hata(int signal)
    {
        if ( signal == 0)
        {
            System.out.println("Sıcaklık Ölçümü Sırasında Hata Meydana Geldi ");
            return false;
        }
        else
        {
            System.out.println("Sıcaklık Başarı İLe Ölçüldü");
            return true;
        }
    }
}
