/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author minnahir
 */
public class KassapaateTest {
    Kassapaate kassapaate;
    
    public KassapaateTest() {
    }
    
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }
  
    @Test
    public void luotuKassapaateOlemassa() {
        assertTrue(kassapaate!=null);      
    }
    
    @Test
    public void luodunKassapaatteenRahamaaraOikein() {
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void luotuKassapaateMyytyjaLounaitaNolla() {
        int myyty = kassapaate.maukkaitaLounaitaMyyty() + kassapaate.edullisiaLounaitaMyyty();
        assertEquals(0, myyty);      
    }
    
    @Test
    public void kateisostoEdullinenMaksuRiittavaKassanRahaMaaraKasvaa() {
        kassapaate.syoEdullisesti(250);
        assertEquals(100240, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void kateisostoMaukasMaksuRiittavaKassanRahaMaaraKasvaa() {
        kassapaate.syoMaukkaasti(410);
        assertEquals(100400, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void kateisostoEdullinenMaksuRiittavaVaihtorahaOikein() {
        assertEquals(10, kassapaate.syoEdullisesti(250));      
    }
    
    @Test
    public void kateisostoMaukasMaksuRiittavaVaihtorahaOikein() {
        assertEquals(10, kassapaate.syoMaukkaasti(410));      
    }
    
    @Test
    public void kateisostoEdullinenMaksuRiittavaMyytyjenMaaraKasvaa() {
        kassapaate.syoEdullisesti(250);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void kateisostoMaukasMaksuRiittavaMyytyjenMaaraKasvaa() {
        kassapaate.syoMaukkaasti(410);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());      
    }
    
    @Test
    public void kateisostoEdullinenMaksuEiRiittavaKassanRahaMaaraEiKasva() {
        kassapaate.syoEdullisesti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void kateisostoMaukasMaksuEiRiittavaKassanRahaMaaraEiKasva() {
        kassapaate.syoMaukkaasti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void kateisostoEdullinenMaksuEiRiittavaVaihtorahaOikein() {
        assertEquals(200, kassapaate.syoEdullisesti(200));      
    }
    
    @Test
    public void kateisostoMaukasMaksuEiRiittavaVaihtorahaOikein() {
        assertEquals(200, kassapaate.syoMaukkaasti(200));      
    }
    
    @Test
    public void kateisostoEdullinenMaksuEiRiittavaMyytyjenMaaraEiKasva() {
        kassapaate.syoEdullisesti(200);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void kateisostoMaukasMaksuEiRiittavaMyytyjenMaaraEiKasva() {
        kassapaate.syoMaukkaasti(200);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());      
    }
    
    @Test
    public void korttisostoEdullinenMaksuRiittavaKassanRahaMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(250);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void korttisostoMaukasMaksuRiittavaKassanRahaMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(410);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void korttisostoEdullinenMaksuRiittavaSummaVeloitetaan() {
        Maksukortti kortti = new Maksukortti(250);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(10, kortti.saldo());      
    }
    
    @Test
    public void korttisostoMaukasMaksuRiittavaSummaVeloitetaan() {
        Maksukortti kortti = new Maksukortti(410);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(10, kortti.saldo());      
    }
    
    @Test
    public void korttisostoEdullinenMaksuRiittavaPalautetaanTrue() {
        Maksukortti kortti = new Maksukortti(250);
        assertTrue(kassapaate.syoEdullisesti(kortti));      
    }
    
    @Test
    public void korttisostoMaukasMaksuRiittavaPalautetaanTrue() {
        Maksukortti kortti = new Maksukortti(410);
        assertTrue(kassapaate.syoMaukkaasti(kortti));      
    }
    
    @Test
    public void korttisostoEdullinenMaksuRiittavaMyytyjenMaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(250);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void korttisostoMaukasMaksuRiittavaMyytyjenMaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(410);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());      
    }
    
    @Test
    public void korttisostoEdullinenMaksuEiRiittavaKassanRahaMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(10);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void korttisostoMaukasMaksuEiRiittavaKassanRahaMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(10);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void korttisostoEdullinenMaksuEiRiittavaKortinRahamaaraEiMuutu() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());      
    }
    
    @Test
    public void korttisostoMaukasMaksuEiRiittavaKortinRahamaaraEiMuutu() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());      
    }
    
       @Test
    public void korttisostoEdullinenMaksuEiRiittavaPalautetaanFalse() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(kassapaate.syoEdullisesti(kortti));      
    }
    
    @Test
    public void korttisostoMaukasMaksuEiRiittavaPalautetaanFalse() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(kassapaate.syoMaukkaasti(kortti));      
    }
    
      @Test
    public void korttisostoEdullinenMaksuEiRiittavaMyytyjenMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void korttisostoMaukasMaksuEiRiittavaMyytyjenMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());      
    }
    
    @Test
    public void lataaRahaaKortilleEpanegatiivinenKassanRahamaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.lataaRahaaKortille(kortti,200);
        assertEquals(100200, kassapaate.kassassaRahaa());      
    }
    
    @Test
    public void lataaRahaaKortilleEpanegatiivinenKortinSaldoKasvaa() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.lataaRahaaKortille(kortti,200);
        assertEquals(400, kortti.saldo());      
    }
    
    @Test
    public void lataaRahaaKortilleNegatiivinenKassanRahamaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.lataaRahaaKortille(kortti,-100);
        assertEquals(100000, kassapaate.kassassaRahaa());      
    }
    
      @Test
    public void lataaRahaaKortilleNegatiivinenKortinSaldoEiKasva() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.lataaRahaaKortille(kortti,-100);
        assertEquals(200, kortti.saldo());      
    }
}
