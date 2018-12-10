# Specyfikacja architektury systemu

## RUP-Hotel

### Autor: Patrycja Łaźna

### Korekta: Michał Starski

### Wersja: 001

### Data: 10.12.2018

### Kierownik projektu: Michał Starski

---

## Spis Treści

1. __Wprowadzenie__

2. __Wymagania__ __i__ __ograniczenia__

3. **Specyfikacja architektury**

4. **Motywacja wyboru**

5. **Jakość i wydajność systemu**

6. **Plan wdrożenia architektury**

----

## Wprowadzenie

W niniejszym dokumencie przedstawiona została wybrana przez Zespół Projektowy architektura wdrożeniowa dla działającej wersji projektowanego systemu. Wyjaśniona jest także motywacja kierująca Zespołem Projektowym do wyboru takiej, a nie innej architektury systemu.  

W dalszej części dokumentu omówiony został plan wdrożenia systemu u Klienta.

Produkcyjna wersja systemu będzie oparta na takiej samej architekturze wdrożonej po stronie Klienta.



## Wymagania i ograniczenia

**Wymagania**

- elastyczność – aplikacja musi działać na dowolnym systemie operacyjnym, na urządzeniach stacjonarnych i mobilnych

- skalowalność – aplikacja powinna wydajnie funkcjonować, nawet przy sporym obciążeniu

- odporność na awarie – po awarii aplikacja powinna odzyskać sprawność i kontynuować działanie, aby nie doprowadzić  

  do utraty danych

- kompatybilność - aplikacja musi w odpowiedni sposób komunikować się z API systemu płatniczego (na zasadzie czarnej skrzynki)

- przenaszalność – łatwość eksportu danych i zmiany środowiska w razie potrzeby

- niezawodność – każda część aplikacji powinna sprawnie funkcjonować

- łatwość użycia – użytkownik intuicyjnie powinien korzystać z aplikacji

- bezpieczeństwo – aplikacja powinna chronić wrażliwe dane

- aplikacja musi być wdrożona nie później niż do końca bieżącego roku (2018)

**Ograniczenia**

Na etapie projektowania systemu nie wykryto ani nie wyszczególniono żadnych ograniczeń dotyczących wyboru architektury systemu.  

Nie istnieją żadne ograniczenia dotyczące wybranej przez Zespół Projektowy architektury systemu.



## Specyfikacja architektury

_Zespół Projektowy ustalił następujące składniki i parametry architektury wdrażanego systemu:_

**Warstwa usługowa**

| ID  | Składnik | Opis                                                    |
|:--- | -------- | ------------------------------------------------------- |
| H01 | Heroku   | Platforma Chmurowa na której będzie hostowana aplikacje |

**Warstwa oprogramowania**

| ID  | Rodzaj          | Składnik                           | Opis/parametry                                               |
| --- | --------------- | ---------------------------------- | ------------------------------------------------------------ |
| S01 | Baza Danych     | PostgreSQL                         | Przechowywanie potrzebnych danych na serwerze                |
| S02 | Warstwa Klienta | HTML + CSS + Javascript (React.js) | Przedstawienie odbiorcy danych w sposób intuicyjny i wygodny |
| S03 | Warstwa Serwera | Java (Spring Boot)                 | Logika serwera                                               |

## Motywacja wyboru

- technologie odpowiadają umiejętnościom zespołu

- łatwość testowania

- możliwość skalowalności

- potrzeba korzystania z urządzeń mobilnych i stacjonarnych

- łatwy podział na komponenty

- szybkość wdrożenia

- stosunkowo niski koszt

## Jakość i wydajność systemu

**Wady i zalety wybranej architekutry**

**Zalety**:

- podział na komponenty, pozwalający na autonomiczne rozwijanie modułów przez wyznaczone do tego osoby

- łatwe wprowadzanie poprawek i utrzymanie architektury

- stosunkowo niski koszt

- możliwość zmiany środowiska pracy, np. przy przenoszeniu oprogramowania na inne platformy sprzętowe

- współdziałanie z systemem zewnętrznym (API systemu płatniczego)

- czytelny podział na klienta i serwer

**Wady**:

- Może wystąpić problem z wydajnością serwera (przy dużym obciążeniu)
- Integracja z zewnętrznym systemem płatności może powodować problemy niezależne od nas



**Wydajność systemu**

Przy projektowaniu architektury systemu Zespół Projektowy zwrócił uwagę przede wszystkim na szybki rozwój oprogramowania przy zachowaniu maksymalnej wydajności. Poprzez ciągłą analizę potencjalnego ryzyka związanego z bezpieczeństwem i obciążeniem serwera, eliminowane są stopniowo możliwe problemy.



**Wpływ architektury na jakość systemu**

Zespół Projektowy rozważył różne możliwości systemu. Architektura systemu została opracowana w oparciu o potrzeby Klienta. Podział aplikacji na samodzielne komponenty pozwala na utrzymanie kodu, prostą analizę i szybką konserwację oprogramowania w przyszłości.



## Plan wdrożenia architektury

**Obowiązki**

Klient zobowiązany jest umożliwić prace wdrożeniowe i dostęp do wymaganych składników posiadanych systemów komputerowych po jego stronie w celu ułatwienia integracji systemu z istniejącymi członkami Zespołu Projektowego zgodnie z wcześniejszymi ustaleniami.  

Za wdrożenie systemu u klienta odpowiedzialni są następujący członkowie Zespołu Projektowego:

| **Imię i nazwisko**                              | **Rola**              | **Opis roli**                                                                                                     |
| ------------------------------------------------ | --------------------- | ----------------------------------------------------------------------------------------------------------------- |
| Michał Starski                                   | Kierownik projektu    | Zarządzanie terminami i budżetem                                                                                  |
| Katarzyna Makohon, Jędrzej Nowak                 | Analityk systemowy    | Przygotowanie dokumentacji, instrukcja dla klienta                                                                |
| Krystian Kabat                                   | Integrator            | Przegląd kodu, zarządzanie podziałem na moduły                                                                    |
| Patrycja Łaźna                                   | Architekt systemu     | Przygotowanie infrastruktury technicznej                                                                          |
| Adam Ćwikliński                                  | Administrator systemu | Dostarczenie niezbędnych narzędzi do wdrożenia aplikacji, serwer, itp., utrzymanie systemu, zarządzanie serwerami |
| Mateusz Lesiecki                                 | Menadżer testów       | Testowanie systemu                                                                                                |
| Ada Andrzejczak                                  | Projektant GUI        | Stworzenie user-friendly interfejsu graficznego                                                                   |
| Konrad Pierzyński, Maciej Więcek, Michał Starski | Programista           | Implementacja kodu.                                                                                               |
| Dominika Augustyniak                             | Inżynier procesu      | Zarządzanie odpowiedzialnościami w zespole                                                                        |
| Bartłomiej Włodarczak                            | Przegląd projektu     | Zarządzanie dokumentacją                                                                                          |

**Terminarz**

Faza I - **14.11.2018** - **23.11.2018**

Faza II - **23.11.2018 - 10.12.2018**

Faza III - **10.12.2018 - 12.12.2018**

Faza IV - **12.12.2018** - **19.12.2018**
