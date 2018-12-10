# Dokumentacja REST API

## RUP Hotel

### Autor: Konrad Pierzyński

### Wersja: 001

### Data: 10.12.2018

### Kierownik Projektu: Michał Starski

---

## Spis treści:

1. Endpoint'y API

---

## Endpoint'y API

**POST /rooms**

Zwraca listę wolnych pokoi w oparciu o podane kryteria.

```
{
    from: Date,
    to: Date,
    personCount: int
}
```

Odpowiedź

```
{
    rooms: [
        {
            roomID: int,
            type: int,
            price: float
        }
        {
            ...
        }
    ]
}
```

----

**POST /generate-token**

Zwraca JSON web token w opaciu o dane użytkownika

```
{
    name: String,
    surname: String,
    identity: String,
    rooms: Array<int>
}
```

Odpowiedź:

```
{
    token: String
}
```
