# Ogólny model informacyjny

## RUP Hotel

### Autor: Katarzyna Makohon, Jędrzej Nowak, Michał Starski

### Korekta: Katarzyna Makohon

### Wersja: 007

### Data: 10.12.2018

### Kierownik Projektu: Michał Starski

---

## Spis treści:

1. Przedmiot dokumentu. 

2. Przypadki użycia.

3. Prototyp interfejsu graficznego.

---

## Przedmiot dokumentu:

Przedmiotem dokumentu jest omówienie prototypu aplikacji. Określenie modelu danych przechowywanych w aplikacji rezerwacji pokoi w hotelu. Opisanie przypadków użycia oraz zaprezentowanie klientowi wstępnego modelu interfejsu graficznego aplikacji.

---

## Przypadki użycia:

#### Use Case 1

Aktor podstawowy (Primary Actor): Klient

**Główni odbiorcy i oczekiwania wzgledem systemu:**

 Klient: Chce zapoznać się z ofertą hotelu w zadanym terminie.

**Warunki Wstępne**

Klient jest podłączony do sieci Internet. Klient jest w stanie zrozumieć treść wyświetlanych komunikatów.

**Warunki Końcowe**

Klient otrzymuje informację o możliwych do zarezerwowania w podanym terminie pokojach. Ich cenie oraz ilości miejsc.

**Scenariusz główny (ścieżka podstawowa)**

1. Klient wchodzi na strone w celu przejrzenia oferty hotelu. 

2. Klient wybiera datę dla której chce sprawdzić ofertę.

3. Klient wybiera liczbę osób dla których chce wyszukać pokoje. 

4. Klient klika przycisk "Szukaj".

5. System wyszukuje pokoje spełniające wymagania klienta.

6. Klient zamyka stronę hotelu.

**Rozszerzenia (ścieżki alternatywne)**

Brak.

**Wymagania technologiczne oraz ograniczenia na dane**

Brak.

**Wymagania specjalne**

Niezbedne jest posiadanie stałego łącza internetowego przez klienta. 

#### Use Case 2: Obsługa rezerwacji pokoju w hotelu.

Aktor podstawowy (Primary Actor): Klient

Aktor podstawowy (Secondary Actor): System obsługi płatności

**Główni odbiorcy i oczekiwania względem systemu:**

- Przedsiębiorstwo: Chce dostarczyć swoją usługę jak największej ilości potencjalnych klientów. Chce elementarnej tolerancji na błędy, aby umożliwić pracę nawet jeżeli składniki całego systemu sprzedaży nie działają (np. systemy autoryzacji płatności).

- Klient: Chce zarezerwować pokój w hotelu w prosty i intuicyjny sposób. Oczekuje możliwości zapłacenia za pokój prosto ze strony hotelu (strona hotelu powinna przekierowywać bezpośrednio do strony płatności).

- System obsługi płatności: Oczekuje danych umożliwiających mu przeprowadzenie płatności.

**Warunki Wstepne**

Klient jest podłączony do sieci Internet. Klient posiada dowód osobisty. Klient jest w stanie zrozumieć treść wyświetlanych komunikatów.
System obsługi płatności jest w stanie odbierać dane od systemu obsługi rezerwacji. System obsługi płatności jest w stanie odesłać Klienta na stronę rezerwacji.

**Warunki Końcowe**

Klient jest przekierowywany na stronę płatności. Dane potrzebne do sfinalizowania transakcji są przesyłane stronie płatności. Baza danych jest zaktualizowana. Oczekiwanie systemu na ostateczne sfinalizowanie transakcji aby wycofać zmiany wprowadzone do bary danych, w razie niepowodzenia transakcji.

**Scenariusz główny (ścieżka podstawowa)**

1. Klient wchodzi na stronę z chęcią rezerwacji pokoju.
2. Klient wybiera datę swojego pobytu.
3. Klient wybiera liczbę osób dla których chce zarezerwować pokój.
4. Klient klika przycisk „Szukaj”.
5. System szuka pokoju spełniającego wymagania klienta.
6. System znalazł pokój, którego szukał klient w wyznaczonym terminie.
7. Klient wybiera konfiguracje pokoi i otrzymuje informacje o ich cenie.
8. Klient przechodzi do następnej strony po kliknięciu przycisku „Przejdź dalej”.
9. Klient jest proszony o swoje dane.
10. Klient, wprowadza swoje dane.
11. Po kliknięciu przycisku „Generuj Kod Płatności” system sprawdza dane i klient otrzymuje kod.
12. Po kliknięciu przycisku „Przejdź do płatności”, klient jest przekierowany na stronę płatności.

**Rozszerzenia (ścieżki alternatywne)**

5a. System nie znalazł pokoju, którego szukał klient w wyznaczonym terminie.

1. Klient dostaje alternatywną propozycję wyboru innego pokoju.

   11a. Klient podał złe typy w miejscach na swoje dane.
2. System podaje informacje, że należy zmienić dane.

   11b. Klient nie podał wszystkich potrzebnych danych.
3. System podaje informację, że należy zmienić dane.

**Wymagania specjalne**

* Niezbedne jest posiadanie stałego łącza internetowego.

**Wymagania technologiczne oraz ograniczenia na wprowadzane dane**

9a. Klient jest proszony o imię, nazwisko i nr dowodu osobistego. Imię i nazwisko składają się z wielkich i małych liter (do 30), natomiast nr dowodu osobistego składa się z 3 liter oraz 6 cyfr.
11a. Kod do płatności składa się z 16 dowolnych znaków.

**Kwestie otwarte**

* Co jeżeli system nie znajdzie alternatywnego pokoju w konkretnym terminie?

* Czy po błędnym wprowadzeniu kodu na stronie płatności i przekierowaniu na stronę rezerwacji kod ma być generowany ponownie?

#### Use Case 3: Strona płatności.

Aktor podstawowy (Primary Actor): Klient.
Aktor podstawowy (Secondary Actor): System obsługi rezerwacji.

**Główni odbiorcy i oczekiwania względem systemu**

* Klient chcący w sposób szybki i bezpieczny zapłacić za zarezerwowane pokoje.

* Strona rezerwacji oczekująca poprawnego wykonania płatności i odesłania informacji o powodzeniu, lub niepowodzeniu, transakcji.

**Warunki wstepne**

Klient został przekierowany ze strony hotelu. Klient poprawnie wypełnił znajdujący się na stronie rezerwacji formularz, a dane tego formularza potrzebne do płatności zostały przekazane stronie płatności. Klient posiada unikalny kod wygenerowany pod koniec procesu dokonywania rezerwacji. Klient jest podłączony do sieci Internet. Klient posiada konto bankowe.

**Warunki końcowe**

Klient poprawnie wykonał płatność. Zostaje przekierowany do strony rezerwacji. Strona płatności wysyła informację o poprawnie przeprowadzonej transakcji.

**Scenariusz główny (scieżka podstawowa)**

1. Klient zostaje przekierowany na stronę płatności.
2. Klient upewnia się, że kwota widniejąca na stronie płatności jest kwotą, którą powinien zapłacić za wybrane wcześniej pokoje.
3. Klient przepisuje swój unikalny kod w polu „Podaj swój kod płatności”.
4. Klient klika „ZATWIERDŹ” alby sfinalizować transakcję.
5. Klient zostaje przekierowany ponownie do strony rezerwacji.

**Rozszerzenia (ścieżki alternatywne)**

3a. Klient podaje zły kod przy płatności.

1. Klient otrzymuje informacje o błędnym wpisaniu kodu i jest przekierowany na stronę z wygenerowanym kodem.

**Kwestie otwarte**

- Co jeżeli kwota do zapłaty będzie różna od kwoty jaką klient powinien zapłacić z pokój?
- Co jeżeli klient zamknie przeglądarkę podczas procesu dokonywanie płatności?
- Co jeżeli klient ze strony płatności cofnie się do strony rezerwacji. Czy kod ma być generowany ponownie? Czy jego dane powinny być nadal wpisane? Czy powinno się cofnąć wszystkie zmiany w bazie danych? Czy musi wybrać ponownie pokoje?

## Prototyp interfejsu graficznego:

Prototyp strony rezerwacji.

![5c0e7ec7090e1](https://i.loli.net/2018/12/10/5c0e7ec7090e1.png)<img src="RUP1.png/>

![5c0e81a0bfc7a](https://i.loli.net/2018/12/10/5c0e81a0bfc7a.png)
