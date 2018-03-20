package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
     @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
        
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(1010);
        assertEquals("saldo: 10.20", kortti.toString());
        
    }
    
    @Test
    public void saldoVaheneeJosRahaaTarpeeksi() {
        kortti.otaRahaa(9);
        assertEquals(1, kortti.saldo());
        
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(11);
        assertEquals("saldo: 0.10", kortti.toString());
        
    }
    
    @Test
    public void palauttaaTrueJosRahaaTarpeeksi() {
        assertTrue(kortti.otaRahaa(5));
        
    }
    
    @Test
    public void palauttaaFalseJosRahaaEiTarpeeksi() {
        assertFalse(kortti.otaRahaa(11));
        
    }
}
