package com.company;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici
{
    boolean durum = false;
   private float sicaklik = 0;

    public float Sicakli_Olc()
    {
        Random rastgele=new Random();
        sicaklik=rastgele.nextInt(51);
        return this.sicaklik;
    }
}