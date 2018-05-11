# Testausdokumentti
Ohjelmaa on testattu JUnitilla sekä manuaalisesti pelaamalla peliä. 

## Yksikkö- ja integraatiotestaus

Tärkeimmän osan testausta muodostaa luokka [BoardTest](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/test/java/BoardTest.java), joka testaa pelilaudan toiminnallisuuksia esimerkkisyötteiden avulla.

## Testauskattavuus
Testien ulkopuolelle jätettyä käyttöliittymäluokkaa lukuun ottamatta testauksen rivikattavuus on 96 % ja haarautumiskattavuus 100 %.

<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/testit.jpg" width="800">

Testaamatta jäi RandomArtificialIntelligence-luokan metodin generateMove(). Sen satunnaisuuden pitäisi kuitenkin olla kunnossa, sillä se käyttää Javan valmista Random-luokkaa. Lisäksi peliä käytännössä pelattaessa generoidut siirrot ovat aina osuneet tyhjiin ruutuihin eivätkä esimerkiksi päätyneet pelilaudan ulkopuolelle aiheuttaen sovelluksen kaatumisen.

<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/testikattavuus.jpg" width="800">

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on tehty manuaalisesti. Sovellus on ladattu ja sen toimintaa on kokeiltu [käyttöohjeen](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md) kuvaamalla tavalla.

## Toiminnnallisuudet 
[Määrittelydokumentin](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/alustavamaarittely.md) listaamat toiminnallisuudet on testattu pelaamalla peliä lukuisia kertoja. Käytännössä virheellistä syötettä ei voida antaa, sillä kun ruutuun on asetettu pelimerkki, ruutua edustava nappi menee pois päältä eikä käyttäjä siten voi yrittää asettaa pelimerkkiä ruutuun, jossa on jo jotain. Kaikissa testitapauksissa sovellus on ilmoittanut pelin lopputuloksen oikein.

