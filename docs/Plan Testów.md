# Plan testów

## RUP Hotel

### Autor: Mateusz Lesiecki

### Korekta: Katarzyna Makohon

### Wersja: 002

### Data: 10.12.2018

### Kierownik Projektu: Michał Starski

---

## Spis treści:

1. Wstęp

2. Testowane obiekty

3. Funkcjonalność do przetestowania

4. Funkcjonalność nietestowana

5. Zespół

6. Strategia testowania

7. Testy automatyczne

8. Środowisko testowe

9. Standardy/Bibliografia

10. Odnośniki

---

## Wstęp:

#### Wprowadzenie

„System rezerwacji pokoi hotelowych dla RUP Hotel” jest to aplikacja internetowa pozwalajaca zarezerwować pokoje w hotelu X na określony czas pobytu oraz dokonać natychmiastowej zapłaty za pobyt w hotelu w niezależnym systemie płatnosci (nazwa) znajdujący się pod adresem (adres). W Systemie bedą dostępne 1, 2 i 3 osobowe pokoje z różną konfiguracją łóżek. Projekt jest tworzony w metodyce RUP.

#### Cel

Faza testowania w projekcie „System rezerwacji pokoi hotelowych dla RUP Hotel”, ma na celu znalezienie oraz usunięcie błędów powstałych podczas tworzenie Systemu, ma on rownież za zadanie zapewnienie jak najwyższej jakości produktu. Testy powinny zostać wykonywane od początku tworzenia Systemu w celu wczesnego wykrycia nieporządanych zachowań, ma to znaczenie na końcowy efekt całego projektu. Celem tego dokumentu jest ułatwienie pracy ludziom odpowiedzialnym za przeprowadzenie testów oraz całego procesu testowania.

---

## Opis testów

#### Obiekt: Aplikacja internetowa - Wyszukiwarka

Jest to pierwsza część aplikacja internetowa znajduja sie pod adresem (adres), składa sie ona z dwóch głównych sekcji, pierwsza z nich to sekcja wyboru daty pobytu w hotelu a druga to sekcja umożliwiająca nam wybór liczby przyjezdnych gości oraz wybrać pokoje z listy dostępnych pokoi. W skład tej cześci wchodzą:

1. Data pobytu:

   1.1. Data przyjazdu - pole typu kalendarz

   1.2. Data wyjazdu - pole typu kalendarz

2. Wybór pokoi:

   2.1. Liczba gości - lista rozwijana

   2.2. Lista składajaca się z dostepnych pokoi - custom client

   2.3. Łączna kwota - pole typu Label

   2.4. Przejdź dalej - button

#### Obiekt: Aplikacja internetowa - Formularz rezerwacji

Jest to druga część aplikacji internetowej znajdującej się pod adresem (adres), jej celem jest umożliwienie klientowi hotelu X wprowadzenia danych niezbędnych do ukończenia rezerwacji pokoju hotelowego oraz generuje kod niezbędny do potwierdzenia płatnośći tym samym całego procesu rezerwacji. W skład tej części wchodzi jedna głowna sekcja, której elementami są:

1. Formularz składajacy sie z 3 pól tekstowych (Imie, Nazwisko, Numer dowodu)
2. Generuj kod płatności – button
3. Twoje dane zostaly/niezostaly zaakceptowane – pole typu Label
4. Przejdź do płatnosci – button

Po naciśnieciu przycisku przejdź do płatności, zostajemy przekierowni do niezależnego systemu płatności (nazwa), gdzie finalizujemy naszą rezerwacje wpisując wygenerowany na stronie kod. Po zatwierdzeniu serwis (nazwa) przekierowuje nas na stronę początkową wraz z komunikatem o rezultacie rezerwacji.

_____

## Funkcjonalność do przetestowania

System rezerwacji pokoi hotelowych dla hotelu X ma umożliwić użytkownikowi zarezerwowanie w wybranym przez niego terminie dowolnej ilośći pokoi w każdym z możliwych typów, na bieżąco aktualizowana jest kwota należna do zapłaty oraz generowany jest unikalny kod niezbędny do potwierdzenia płatności.

#### Pierwsza część aplikacji

3.1.1 Funkcjonalność wyszukiwarki

#### Druga część aplikacji

3.2.1 Pola tekstowe z formularza
3.2.2 Poprawność wyświetlania statusu wypełnionych danych
3.2.3 Poprawność generowania kodu do płatności
3.2.4 Funkcjonalność przycisku przejdz do płatności

#### Dodatkowo

- Poprawne załadowanie strony w przeglądarce
- Poprawność dodania rezerwacji do bazy danych
- Niedodanie rezerwacji do bazy w przypadku niepowodzenia płatności
- Generowanie poprawnego kodu płatnośći (zgodnego z wymaganiami)
- Przekierowanie na strone systemu płatności
- Sprawdzenie czy wejscie na (adres) doda do bazy rezerwacje
- Przekierowanie na storne poczatkową po udanej rezerwacji
- Przekierowanie na strone początkowo po nieudanej rezerwacji wraz z odpowiednim komunikatem
- Zgodność wyglądu strony razem z projektem GUI

_____

## Funkcjonalność nietestowana

4.1 Wszystkie pola typu napisy tekstowe (Label)

_____

## Zespół

#### Podział obowiązków

5.1.1 Michał Starski – Kierownik projektu, Programista
5.1.2 Maciej Więcek – Programista
5.1.3 Katarzyna Makohon – Analityk Systemowy
5.1.4 Mateusz Lesiecki – Menadżer testów
5.1.5 Bartłomiej Włodarczyk – Przegląd projektu
5.1.6 Jędrzej Nowak – Analityk Systemowy
5.1.7 Krystian Kabat – Integrator
5.1.8 Dominika Augustyniak – Inżynier procesu
5.1.9 Ada Andrzejczak – Projektant GUI
5.1.10 Adam Ćwikliński – Administrator Systemu
5.1.11 Patrycja Łaźna – Architekt Systemu
5.1.12 Konrad Pierzyński – Programista

#### Harmonogram

| Nazwa testów | Data rozpoczęcia | Data zakończenia | Wykonał |
| ------------ | ---------------- | ---------------- | ------- |
| Jednostkowe  |                  |                  |         |
| Integracyjne |                  |                  |         |

_____

## Testy

#### Testy jednostkowe
