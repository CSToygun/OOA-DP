package com.company;

public class Subscriber2 implements IObserver /** SIcaklığın Veritabanına  GÖnderilmesi için tasarlandı */
{
    @Override
    public void update(float sicaklik)
    {
        System.out.println(" sicaklik :" + sicaklik + "-->" + "Veritabanına İletildi");
    }
}