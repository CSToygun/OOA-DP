package com.company;

public class Subscriber1 implements IObserver /** SIcaklığın Soğutucu Bİrimine GÖnderilmesi için tasarlandı */
{
    @Override
    public void update(float sicaklik)
    {
        System.out.println(" sicaklik :" + sicaklik + "-->" + "Soğutucu Birime  İletildi");
    }
}
