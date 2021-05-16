package com.company;

/**** The Dependency Inversion Principle (DIP) ilkesi için hazırlandı  ****/
public class KOntrol
{
        private IKontrol cihaz;

        public KOntrol(IKontrol cihaz) {
            this.cihaz = cihaz;
        }

        public void ac(){
            cihaz.ac();
        }
        public void kapat(){
            cihaz.kapat();
        }
}

/**  Böyleci %100 bağlılık bağı azaltılmış noldu ve hehangi bir değişiklikte etkilenmenin önüne geçilmiş oluyor  **/