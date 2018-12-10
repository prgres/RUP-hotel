# Specyfikacja wykorzystywanych procesów

## RUP Hotel

### Autor: Michał Starski

### Wersja: 001

### Data: 10.12.2018

### Kierownik Projektu: Michał Starski

----

## Spis treści

1. System kontroli wersji

2. Budowa projektu

3. Hosting

---



## System kontroli wersji

Cały projekt został postawiony na repozytorium git w celu utrzymania spójności danych. Repozytorium to z kolei zostało podłączone do platformy [GitHub](https://github.com), aby ułatwić współbieżność pracy i wdrożyć ściśle określone workflow pracy.



**Workflow pracy nad projektem**

1. Osoba chcąca wprowadzić zmiany forkuje repozytorium z githuba

2. Na danym forku wprowadzane są zmiany

3. Wysyłany jest pull request do głównego repozytorium

4. Zmiana przechodzi przez review

5. Jeżeli zmiana jest zaakceptowana, zmiany są scalane

6. Jeżeli zmiana jest nie zaakceptowana, powrót do punktu 2

[Repozytorium projektu na GitHubie](https://github.com/michalStarski/RUP-hotel)



## Budowa projektu



**Backend**

Architektura serwera została napisana w języku Java przy użyciu frameworka webowego Spring. Projekt został wygenerowany przez [Spring Initializr](https://start.spring.io/), a zależności zostały zainstalowane przy pomocy Maven.



**Frontend**

Klient aplikacji został w pełni napisany przy użyciu technologii webowych - HTML CSS i Javascript (przy użyciu biblioteki React.js). Szkielet tej części został wygenerowany z użyciem CLI ```create-react-app``` , aby pracować z dobrze skonfigurowanym projektem, który będzie spełniał wszystkie oczekiwania. 



**Połączenie pomiędzy klientem a serwerem**

Serwer serwuje pliki statyczne aplikacji React, która później komunikuje się z backendem za pomocą REST API.



## Hosting

Cała aplikacja będzie uruchomiona na platformie chmurowej [Heroku](https://www.heroku.com/), która udostępnia łatwy deploy i czytelny wgląd w logi serwera.




