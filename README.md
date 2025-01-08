# Personal Data Validator


### Treść Zadania
  Zadaniem jest stworzenie aplikacji, która waliduje dane tekstowe (np. e-maile i numery telefonów) wprowadzane ręcznie z klawiatury lub z pliku  JSON   Wzorzec Łańcuch Odpowiedzialności będzie używany do etapowej walidacji danych, a wzorzec Fabryka będzie odpowiedzialny za dynamiczne  tworzenie   walidatorów danych. Aplikacja powinna obsługiwać wyjątki oraz wykorzystywać kolekcje generyczne do zarządzania różnymi typami danych.


<details>
  <summary> Szczegóły </summary>

  **Wzorce projektowe:**
  - Łańcuch Odpowiedzialności: Walidacja danych krok po kroku (np. najpierw e-mail, potem numer telefonu).
  - Fabryka: Dynamiczne tworzenie walidatorów danych (np. dla e-maila lub numeru telefonu).

  **Wejście:**
  - Dane tekstowe (np. e-mail, numer telefonu) wprowadzane ręcznie z klawiatury lub { "email": "user@example.com", "phone": "+1234567890" }
  - Klawiatura: Wprowadzanie danych ręcznie.

  **Wyjście:**
  - Komunikat o poprawnej walidacji lub błędach walidacyjnych (np. niepoprawny format e-maila).

  **Zakres danych:**
  - Dane tekstowe: e-mail, numer telefonu.
  - Walidacja: poprawność formatu e-maila i numeru telefonu.

  **Oczekiwane działanie:**
  - Aplikacja powinna dynamicznie tworzyć walidatory i przeprowadzać walidację danych za pomocą Łańcucha Odpowiedzialności.
  - Obsługa wyjątków powinna zwracać komunikaty o błędach w przypadku niepoprawnych danych.

  **Techniki Java:**
  - Mechanizm wyjątków: Obsługa błędów walidacyjnych.
  - Kolekcje generyczne: Zarządzanie różnymi typami danych (e-mail, numer telefonu).

  **Zadania rozszerzające:**
  - Rozbudowa walidacji: Dodanie walidacji dodatkowych danych, takich jak adresy pocztowe.
  - Obsługa JSON w różnych formatach: Dodanie obsługi walidacji danych z JSON o różnych strukturach.

</details>