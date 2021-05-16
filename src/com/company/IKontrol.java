package com.company;

/**** The Dependency Inversion Principle (DIP) ilkesi için hazırlandı  ****/
public interface IKontrol
{
    void ac();
    void kapat();
}

/**  Böyleci %100 bağlılık bağı azaltılmış noldu ve hehangi bir değişiklikte etkilenmenin önüne geçilmiş oluyor  **/
