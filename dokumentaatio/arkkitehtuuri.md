# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kaksitasoista kerrosarkkitehtuuria, ja pakkausrakenne selviää allaolevasta kaaviosta:

<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/pakkauskaavioFinal.JPG" width="300">

## Käyttöliittymä

Käyttöliittymä sisältää kolme erillistä näkymää, jotka kaikki on toteutettu omana Scene-olionaan. Näkymistä se, joka on vuorollaan sijoitettuna sovelluksen stageen, on käyttäjälle näkyvänä. Käyttöliittymä on rakennettu ohjelmallisesti luokassa tictactoe.ui.TicTacToeUi.

Ensimmäisessä käyttäjä valitsee, haluaako pelata tietokonetta vai toista ihmistä vastaan. Toisessa näkymässä aukeaa peli tietokonetta vastaan. Kolmannessa aukeaa peli toista ihmistä vastaan (siis käytännössä yksi käyttäjä asettaisi laudalle vuorotellen X:n tai O:n).

## Sovelluslogiikka

Sovelluslogiikan muodostavat pelilauta [Board](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Board.java), siihen kuuluvat 16 [Square-ruutua](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Square.java), pelaaja [Player](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Player.java) ja tekoälypelaaja [RandomArtificialIntelligence](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/RandomArtificialIntelligence.java).

Pelilogiikka tapahtuu suurimmissa määrin luokassa Board. Sillä on esimerkiksi metodi fourInARow(String token), joka tarkistaa, onko tarvittava määrä samoja merkkejä jollakin pysty- tai vaakarivillä tai diagonaalilla. Metodi gameOver() edelleen tarkistaa, onko peli päättynyt ja asettaa tarvittaessa aiheesta kertovan viestin. Se myös pitää listaa pelilaudan tyhjistä ruuduista. Käyttöliittymän rakentava luokka TicTacToeUi vain kutsuu vaikkapa voitontarkistusmetodia.

Ohjelman luokkarakenne on seuraava:

<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/luokkakaavioFinal.jpg" width="300">



## Päätoiminnallisuudet

Ohjelman tärkein toiminnallisuus, pelimerkin asettaminen laudalle, on kuvattu allaolevassa sekvenssikaaviossa. Sekvenssikaavioon on valittu yksinpeli, sillä siinä "tapahtuu enemmän" sovelluslogiikan mielessä kuin kaksinpelissä.

<img src="https://github.com/mnnamaria/otm-harjoitustyo/blob/master/dokumentaatio/Kuvat/SekvenssikaavioFinal.jpg" width="750">

[Tapahtumankäsittelijä](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/ui/TicTacToeUi.java#L113) kutsuu pelilaudan metodia [setToBoard](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Board.java#L173) parametreinaan ihmispelaajan pelimerkki _X_ sekä käyttäjän klikkaaman ruudun koordinaatit. Merkki asetetaan laudalle ja pelilaudan [gameOver()](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Board.java#L54) metodi tarkistaa, onko peli ohi. Tässä tapauksessa se palauttaa _false_, jolloin kutsutaan tekoälypelaajan metodia generateMove(). Se luo uuden _Random_-olion ja tarvitsee lisäksi pelilaudan metodia [emptySpots()](https://github.com/mnnamaria/otm-harjoitustyo/blob/master/TicTacToe/src/main/java/tictactoe/domain/Board.java#L182). EmptySpots().size palauttaa vielä tyhjillään olevien ruutujen lukumäärän. Tekoälypelaaja arpoo kokonaisluvun väliltä [0, tyhjien ruutujen lukumäärä -1]. Sen jälkeen tyhien paikkojen listalta haetaan merkkijono tällä indeksillä: palautettava siirto on muotoa "rivi,sarake". Nyt käyttöliittymä kutsuu tekoälypelaajan getteriä getToken(), joka palauttaa pelimerkin _O_. Seuraavaksi kutsutaan jälleen pelilaudan metodia setToBoard(), jonka parametreinä ovat tällä kertaa tekoälypelaajan pelimerkki sekä juuri arvotut rivi ja sarake.

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymäkoodi sisältää toisteisuutta eri Scenejen luomisen osalta. Yksin- ja kaksinpelissä ainoa ero on ruudun ylälaidassa näytettävässä tekstissä sekä siinä, mitä tapahtuu tapahtumankäsittelijän sisällä. Niinpä vaikkapa ruudukon luominen on koodissa turhaan kahdesti.
