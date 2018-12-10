# Model Bazy Danych

## RUP Hotel

### Autor: Patrycja Łaźna

### Wersja: 001

### Data: 24.11.2018

### Kierownik Projektu: Michał Starski

---

## Spis treści:

1. Diagram Bazy Danych
2. Model Danych

---



## Diagram Bazy Danych

![5c0ebb14ebb47](https://i.loli.net/2018/12/11/5c0ebb14ebb47.jpg)

## Model Danych

Aplikacja przechowuje kilka typów danych, które można podzielić na 4 grupy.

- Dane użytkownika skojarzone z tabelą __„Client”__ w bazie danych.

  Są to: imię (name), nazwisko (surname), numer dowodu osobistego (id_number) oraz wewnętrzne id (client_id) nadawane automatycznie, dane są niezbędne przy składaniu rezerwacji oraz przy sprawdzeniu historii danego klienta
- Dane rezerwacji, skojarzone z tabelą __„Reservation”__. 

  Przechowywane dane to: wewnętrzne id (reservationID) nadawane automatycznie, identyfikator klienta rezerwującego pokój (client_id), numer pokoju, który zarezerwował (room_number), data zameldowania (arrival) oraz data wymeldowania (departure).
- Dane pokoju, skojarzone z tabelą __„Room”__.

  Są to: wewnętrzny numer identyfikujący pokój (room_number), skrócona informacja o typie pokoju (room_type) oraz cena danego pokoju (price).
- Dane typów pokoi, skojarzone z tabelą __„Room Type”__. 

  Przyporządkowujące skróconym informacjom o typach pokoju (roomtypeID) opisy wyjaśniające (room_type).

Dodatkowo:

- Jeden użytkownik może zarezerwować wiele pokoi.
- Jeden pokój może być wynajmowany w danym czasie tylko przez jednego klienta. 
- Pokój musi mieć zmieniony status na okres, w którym jest zarezerwowany.
- Klient jest identyfikowany na podstawie imienia, nazwiska oraz numeru dowodu.
- Wszystkie pola identyfikujące klienta muszą zostać wypełnione.
- Klient nie może wybrać zajętego pokoju.
- Nie może istnieć pokój bez typu.
- Data zameldowania musi być wcześniejsza niż data wymeldowania.
- Typ pokoju musi posiadać opis.
- Korzystając z historii rezerwacji możemy uzyskać informacje na temat pobytu klienta w dowolnym czasie.
- Dane historycznych rezerwacji powinny być zachowywane w bazie danych.
- Rezerwacja jest dodana do bazy danych tylko po sfinalizowaniu płatności.
- Numer dowodu ma określoną formę – 9 znaków.
