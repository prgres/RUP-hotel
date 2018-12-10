# Specyfikacja wymagań systemowych

## RUP-Hotel

### Autor: Katarzyna Makohon

### Korekta: Konrad Pierzyński

### Wersja: 003

### Data: 10.12.2018

### Kierownik projektu: Michał Starski

---

## Spis treści

1. **Źródła wymagań**

2. **Cele systemu**

3. **Otoczenie systemu**

4. **Przewidywane komponenty systemu**

5. **Wymagania funkcjonalne**

6. **Wymagania na dane**

7. **Sytuacje wyjątkowe**

8. **Kryteria akceptacyjne**

---

## Źródła wymagań

| INTP 001 | Zleceniodawca                                                        |
| -------- | -------------------------------------------------------------------- |
| Opis     | RUP-Hotel                                                            |
| Typ      | instytucjonalny                                                      |
| Adres    | RUP-Hotel<br/>Ulica Umultowska 86<br/>61-614 Poznań<br/>Wielkopolska |

| INTP 002 | Przedstawiciel zleceniodawcy                                               |
| -------- | -------------------------------------------------------------------------- |
| Opis     | Osoba oddelegowana przez zleceniodawcę do kontaktów z zespołem projektowym |
| Typ      | osobowy                                                                    |
| Kontakt  | Rafał Witkowski<br/>+48 404 404 404<br/>email: rmiw@amu.edu.pl             |

## Cele systemu

**Cele biznesowe**

| BSCE 001  | Otwarcie nowego kanału sprzedaży                                              |
| --------- | ----------------------------------------------------------------------------- |
| Opis      | Ułatwienie dostępu do oferty hotelu. Otwarcie się hotelu na nowe technologie. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                         |
| Priorytet | wysoki                                                                        |

| BSCE 002  | Umożliwienie jak najlepszego dostosowania zasobów hotelu do wymagań klienta                                                                            |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Opis      | W momencie, w którym możliwości hotelu nie są identyczne z wymaganiami klienta system proponuje rozwiązanie, które może usatysfakcjonować obie strony. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                                                                  |
| Priorytet | normalny                                                                                                                                               |

**Cele funkcjonalne**

| BSCE 003  | Umożliwienie rezerwacji pokoi przez Internet                                         |
| --------- | ------------------------------------------------------------------------------------ |
| Opis      | Umożliwienie rezerwacji pokoju o każdej porze. Ułatwienie procesu rezerwacji pokoju. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                |
| Priorytet | normalny                                                                             |

| BSCE 004  | Umożliwienie płatności za pokój przez Internet         |
| --------- | ------------------------------------------------------ |
| Opis      | Bezpieczny sposób realizowanie płatności internetowych |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                  |
| Priorytet | normalny                                               |

| BSCE 005  | Umożliwienie sprawdzenia dostępności pokoju przez Internet                           |
| --------- | ------------------------------------------------------------------------------------ |
| Opis      | Umożliwienie sprawdzenia dostępności, ilości oraz typu pokoi oferowanych przez hotel |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                |
| Priorytet | normalny                                                                             |

## Otoczenie systemu

**Użytkownicy**

| USER 001  | Klient                                                                                                                                                              |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Opis      | Użytkownikiem systemu jest każda osoba chcąc zarezerwować pokój, bądź sprawdzić dostępność pokoju o danym typie                                                     |
| Potrzeby  | Rezerwacja jednego lub więcej pokoi jednego lub więcej typów.<br/>Możliwość zapłaty przez Internet.<br/>Możliwość sprawdzenia dostępności pokoi w zadanym terminie. |
| Zadania   | Stworzyć prosty interfejs umożliwiający sprawdzenie dostępności pokoju, zarezerwowanie i zapłatę za niego przez Internet                                            |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                                                                               |
| Priorytet | normalny                                                                                                                                                            |

**Systemy wewnętrzne**

| ISYS 001  | Baza danych                                                                                               |
| --------- | --------------------------------------------------------------------------------------------------------- |
| Opis      | Baza danych przechowująca informacje o pokojach, ich typie, cenie oraz dostępności w konkretnym terminie. |
| Potrzeby  | Struktura umożliwiająca sprawdzanie, czy w danym terminie jest dostępny pokój danego typu.                |
| Zadania   | Znajdowanie wolnych pokoi zadanego typu w zadanym terminie.                                               |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                     |
| Priorytet | normalny

| ISYS 002  | **API** |
| --------- | ------- |
| Opis      | API komunikujące się pomiędzy stroną rejestracji a stroną płatności za pokój w hotelu. |
| Potrzeby  | Przekazywanie danych klienta pomiędzy stronami rejestracji i płatności. |
| Zadania   | Przekazać kwotę, jaką należy zapłacić za pokoje.<br/> Przekazanie unikalnego kodu weryfikującego płatność. W razie niepowodzenia lub powodzenia płatności przekierowanie na stronę rezerwacji z odpowiednim komunikatem. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy |
| Priorytet | Normalny |                                                                                                                      

## Przewidywane komponenty systemu

- Strona internetowa oferująca możliwość rezerwacji pokoju;

- Strona internetowa umożliwiająca dokonanie płatności za rezerwacje;

- Serwer hostujący stronę rezerwacji oraz stronę płatności;

- API komunikujące się między stroną rezerwacji pokoju, a stroną płatności;

- Relacyjna baza danych.

## Wymagania funkcjonalne

| FUNC 001   | **Rezerwacja pokoi**                                                                                  |
| ---------- | ----------------------------------------------------------------------------------------------------- |
| Opis       | Możliwość zarezerwowania jednego lub kilku pokoi jednego lub kilku typów dostępnych w ofercie hotelu. |
| Dotyczy    | USER 001 Klient                                                                                       |
| Powiązania |                                                                                                       |
| Źródło     | INTP 002 Przedstawiciel zleceniodawcy                                                                 |
| Priorytet  | normalny                                                                                              |

| FUNC 002   | **Płatność internetowa**                                                                  |
| ---------- | ----------------------------------------------------------------------------------------- |
| Opis       | Bezpieczne przekierowanie oraz obsłużenie płatności internetowej za zarezerwowane pokoje. |
| Dotyczy    | USER 001 Klient                                                                           |
| Powiązania | FUNC 001 Rezerwacja pokoi                                                                 |
| Źródło     | INTP 002 Przedstawiciel zleceniodawcy                                                     |
| Priorytet  | normalny                                                                                  |

| FUNC 003   | **Sprawdzenie dostępności danego pokoju w zadanym terminie.**                                         |
| ---------- | ----------------------------------------------------------------------------------------------------- |
| Opis       | Możliwość sprawdzenia czy w danym terminie hotel oferuje możliwość zarezerwowania pokoju danego typu. |
| Dotyczy    | USER 001 Klient                                                                                       |
| Powiązania | FUNC 001 Rezerwacja pokoi                                                                             |
| Źródło     | INTP 002 Przedstawiciel zleceniodawcy                                                                 |
| Priorytet  | normalny                                                                                              |

## Wymagania na dane

| TABLE 001 | **Client**                                                  |
| --------- | ----------------------------------------------------------- |
| Opis      | Klient posiada imię, nazwisko oraz numer dowodu osobistego. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                       |
| Priorytet | normalny                                                    |

| TABLE 002 | **Room**                                                                                                                                                   |
| --------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Opis      | Istnieją pokoje jedno- dwu- oraz trzyosobowe w z góry zadanej ilości. Pokoje mają różne ceny, w zależności od tego dla jakiej ilości osób są przeznaczone. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                                                                      |
| Priorytet | normalny                                                                                                                                                   |

| TABLE 003 | **Room Type**                                                                                                                                                                                                                                                         |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Opis      | Istnieją pokoje jednoosobowe. Pokoje dwuosobowe posiadające jedno podwójne łóżko. Pokoje dwuosobowe posiadające dwa oddzielne łóżka. Pokoje trzyosobowe posiadające jedno podwójne i jedno pojedyncze łóżko oraz pokoje trzyosobowe posiadające trzy oddzielne łóżka. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                                                                                                                                                                                 |
| Priorytet | normalny                                                                                                                                                                                                                                                              |

| TABLE 004 | **Reservation**                                                                                                                                   |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| Opis      | Rezerwacje posiadają identyfikator pokoju, identyfikator klienta oraz w jednoznaczny sposób określają okres czasu na jaki pokój jest wynajmowany. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                                                             |
| Priorytet | normalny                                                                                                                                          |

Szczegółowe wymagania dotyczące danych przetwarzanych w systemie znajdują się w dokumencie *Ogólny model informacyjny*

## Wymagania jakościowe

- Dostosowana, prosta intuicyjna strona internetowa;

- Niezawodny, stabilny i niezakłócony kontakt;

- Bezbłędny zapis informacji do bazy danych oraz ich odczyt i wyświetlenie przez aplikację.

## Sytuacje wyjątkowe

- Brak połączenia z bazą danych w momencie połączenia strony internetowej;

- Chęć użytkownika do zarezerwowania zerowej ilości pokoi;

- Chęć użytkownika do zarezerwowania większej ilości pokoi niż jest wolnych w danym terminie w zasobach hotelu;

- Nie podanie terminu rezerwacji;

- Nie podanie wszystkich danych osobowych niezbędnych do przejścia przez proces rezerwacji;

- Wybranie, przez klienta, późniejszego terminu zameldowania niż wymeldowania z pokoju przy rezerwacji

## Kryteria akceptacyjne

| ACPT 001  | **Testy akceptacyjne u klienta – Strona internetowa.**                                    |
| --------- | ----------------------------------------------------------------------------------------- |
| Opis      | Sprawdzenie poprawności przekierowań i akcji wszystkich przycisków na stronie rezerwacji. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                     |
| Priorytet | normalny                                                                                  |

| ACPT 002  | **Testy akceptacyjne u klienta – Niepoprawnie wykonana płatność.**                                           |
| --------- | ------------------------------------------------------------------------------------------------------------ |
| Opis      | Sprawdzenie, czy niepoprawna wykonana płatność przekierowuje do strony rezerwacji z odpowiednim komunikatem. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                        |
| Priorytet | normalny                                                                                                     |

| ACPT 003  | **Testy akceptacyjne u klienta – Poprawnie wykonana płatność.**                                           |
| --------- | --------------------------------------------------------------------------------------------------------- |
| Opis      | Sprawdzenie czy poprawnie wykonana płatność przekierowuje do strony rezerwacji z odpowiednim komunikatem. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                     |
| Priorytet | normalny                                                                                                  |

| ACPT 004  | **Testy akceptacyjne u klienta – Sprawdzanie dostępności pokoi w terminie.**                                     |
| --------- | ---------------------------------------------------------------------------------------------------------------- |
| Opis      | Sprawdzenie czy, baza danych zwraca prawdziwe dane w kontekście określania czy dany pokój jest zajęty czy wolny. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                            |
| Priorytet | normalny                                                                                                         |

| ACPT 005  | **Testy akceptacyjne u klienta – Podpowiedzi na stronie.**                                                                                                                            |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Opis      | Sprawdzenie czy w przypadku zajętych pokoi o zadanym typie strona proponuje klientowi rezerwację kilku pokoi o łącznej sumie mieszkańców równej lub wyższej od zadanej przez klienta. |
| Źródło    | INTP 002 Przedstawiciel zleceniodawcy                                                                                                                                                 |
| Priorytet | normalny                                                                                                                                                                              |

Szczegółowe wymagania dotyczące danych przetwarzanych w systemie znajdują się w dokumencie *Plan testów*
