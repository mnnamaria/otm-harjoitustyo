# TicTacToe

Harjoitustyö kurssille Ohjelmistotekniikan menetelmät

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentointi/alustavamaarittely.md)

[Työaikakirjanpito](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

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
