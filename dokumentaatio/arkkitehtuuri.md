# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kaksitasoista kerrosarkkitehtuuria, ja pakkausrakenne selviää allaolevasta kaaviosta:

<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/pakkauskaavio.jpeg" width="750">

## Käyttöliittymä

Käyttöliittymä sisältää kaksi (seuravassa versiossa kolme) erillistä näkymää, jotka molemmat on toteutettu omana Scene-olionaan. Näkymistä se, joka on vuorollaan sijoitettuna sovelluksen stageen, on käyttäjälle näkyvänä. Käyttöliittymä on rakennettu ohjelmallisesti luokassa tictactoe.ui.TicTacToeUi.

Ensimmäisessä käyttäjä valitsee, haluaako pelata tietokonetta vai toista ihmistä vastaan. Toisessa näkymässä aukeaa peli tietokonetta vastaan. Kolmannessa aukeaisi peli toista ihmistä vastaan (siis käytännössä yksi käyttäjä asettaisi laudalle vuorotellen X:n tai O:n).

## Sovelluslogiikka

Sovelluslogiikan muodostavat pelilauta [Board](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Board.java), siihen kuuluvat [Square-ruudut](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Square.java) (joita kuvassa on 9, uusimmassa versiossa ruutuja on kuitenkin 16), pelaaja [Player](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Player.java) (siis sovelluksen käyttäjä) ja tekoälypelaaja [RandomArtificialIntelligence](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/RandomArtificialIntelligence.java).

Pelilogiikka tapahtuu suurimmissa määrin luokassa Board. Sillä on esimerkiksi metodi threeInARow(String token), joka tarkistaa, onko tarvittava määrä samoja merkkejä jollakin pysty- tai vaakarivillä tai diagonaalilla. Metodi gameOver() edelleen tarkistaa, onko peli päättynyt ja asettaa tarvittaessa aiheesta kertovan viestin. Se myös pitää listaa pelilaudan tyhjistä ruuduista. Käyttöliittymän rakentava luokka TicTacToeUi vain kutsuu vaikkapa voitontarkistusmetodia.

Ohjelman luokkarakenne on seuraava:
<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/luokkakaavio.jpeg" width="750">



## Päätoiminnallisuudet

<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/AlustavaSekvenssikaavio.jpg" width="750">

