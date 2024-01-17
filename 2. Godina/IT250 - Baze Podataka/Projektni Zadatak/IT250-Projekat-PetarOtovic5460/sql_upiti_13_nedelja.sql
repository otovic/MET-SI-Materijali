-- Upiti za 13. nedelju --------------------------------------------

-- 1.	Upit u kom morate koristiti GROUP BY, HAVING i ORDER BY.
SELECT predstava_id, SUM(mesta_rezervisano) AS ukupno_mesta_zauzeto FROM `rezervacija`
GROUP BY predstava_id
HAVING ukupno_mesta_zauzeto > 100
ORDER BY ukupno_mesta_zauzeto ASC

-- 2.	Upit u kom morate koristiti CASE.
SELECT kk.broj_kreditne_kartice, kk.datum_isteka, 
CASE
	WHEN kk.datum_isteka < CURRENT_DATE() THEN 'Aktivna'
    ELSE 'Istekla'
END AS vazi
FROM kreditna_kartica AS kk

-- 3.	Upit u kom ćete kreirati pogled (VIEW) i koristiti LEFT ili RIGHT JOIN.
CREATE VIEW producenti_predstave AS
SELECT
    pr.predstava_id,
    pr.ime_trupe,
    pr.ime_pozorisnog_komada,
    prod.ime_producenta
FROM
    predstava AS pr
LEFT JOIN
    producent AS prod ON pr.producent_id = prod.producent_id

-- 4.	Upit u kom morate koristiti BETWEEN, ORDER BY i LIMIT.
SELECT pr.predstava_id, pr.cena_ulaznice, pr.max_mesta FROM predstava AS pr
WHERE pr.cena_ulaznice BETWEEN 1000 AND 2000
ORDER BY pr.cena_ulaznice DESC
LIMIT 3

-- 5.	Upit u kom morate koristiti WHERE i (NOT) LIKE i WILDCARDS.
SELECT pr.jedinstveni_broj_pretplatnika, pr.adresa FROM pretplatnik AS pr
WHERE pr.telefon LIKE '061%' AND pr.adresa NOT LIKE 'Car%'

-- 6.	Upit u kom morate koristiti (NOT) EXISTS. 
SELECT * FROM trupa
WHERE NOT EXISTS (
	SELECT * FROM predstava
    WHERE trupa.ime_trupe = predstava.ime_trupe
)

-- 7.	Upit u kom morate koristiti minimum DVE AGREGATNE funkcije I GROUP BY.
SELECT 
    rz.predstava_id, MAX(rz.mesta_rezervisano) AS najvise_mesta_rezervisano_pojedinacno, 
    SUM(rz.iznos_za_placanje) AS ukupna_zarada 
FROM rezervacija AS rz
GROUP BY rz.predstava_id

-- 8.	UPDATE upit.
UPDATE pretplatnik 
SET adresa = 'Cara Nemanje 22' 
WHERE pretplatnik.jedinstveni_broj_pretplatnika = 5

-- 9.	Upit u kom morate koristiti JEDNU od sledećih funkcija: DAY, DAYNAME, MONTH, MONTHNAME, YEAR.
SELECT * FROM rezervacija
WHERE MONTH(rezervacija.datum_rezervacije) = 3

-- 10.	Upit u kom morate koristiti AND ili OR. 
SELECT * FROM rezervacija
WHERE rezervacija.mesta_rezervisano > 100 AND rezervacija.iznos_za_placanje > 10000