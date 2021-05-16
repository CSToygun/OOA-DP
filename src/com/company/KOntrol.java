package com.company;

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
