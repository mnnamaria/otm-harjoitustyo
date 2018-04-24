# TicTacToe

Ristinollapeli harjoitustyönä kurssille Ohjelmistotekniikan menetelmät

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/alustavamaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

## Releaset
[Viikko 5](https://github.com/mnnamaria/otm-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot

### Testaus
Testit suoritetaan komennolla
```
mvn test
```
Testikattavuusraportti luodaan komennolla
```
mvn jacoco:report
```
Kattavuusraporttia voi tarkastella selaimella suorittamalla projektihakemistossa komento
```
chromium-browser target/site/jacoco/index.html
```
### Checkstyle

Tiedostossa [checkstyle.xml](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/checkstyle.xml) määritellyt tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät suorittamalla projektihakemistossa komento

```
chromium-browser target/site/checkstyle.html
```
### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _TicTacToe-1.0-SNAPSHOT.jar_
