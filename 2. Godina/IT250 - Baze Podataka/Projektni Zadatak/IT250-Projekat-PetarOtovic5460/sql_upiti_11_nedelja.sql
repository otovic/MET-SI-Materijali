-- Upiti za 11. nedelju --------------------------------------------

-- Prikazati sve korisnike koji su gledali neku predstavu (npr. Anu Karenjinu)
SELECT DISTINCT(pp.jedinstveni_broj_pretplatnika), pp.ime, pp.prezime, pp.adresa, pp.telefon FROM pretplatnik AS pp
INNER JOIN rezervacija AS rz ON pp.jedinstveni_broj_pretplatnika = rz.jedinstveni_broj_pretplatnika
INNER JOIN predstava AS pr ON rz.predstava_id = pr.predstava_id
WHERE pr.ime_predstave = 'Ana Karenjina'

--Prikazati sve predstave koje su na repertoaru 20.01.2021.
SELECT pr.ime_predstave, pr.datum_odrzavanja FROM predstava AS pr
WHERE pr.datum_odrzavanja = '2019-10-14'

--Prikazati ukupan broj predstava za koje više nisu dostupna mesta
SELECT COUNT(*) AS rasprodate_predstave FROM 
(
    SELECT  SUM(rz.mesta_rezervisano) AS ukupno_mesta_rezervisano, pr.max_mesta FROM rezervacija AS rz
	LEFT JOIN predstava AS pr ON rz.predstava_id = pr.predstava_id
	GROUP BY rz.predstava_id
) AS broj_mesta
WHERE ukupno_mesta_rezervisano = max_mesta

-- Prikazati sve rezervacije koje je kreirao korisnik Petar Petrović tokom 2020 godine.
SELECT pp.jedinstveni_broj_pretplatnika, pp.ime, pp.prezime FROM rezervacija AS rz
LEFT JOIN pretplatnik AS pp ON rz.jedinstveni_broj_pretplatnika = pp.jedinstveni_broj_pretplatnika
WHERE pp.ime = 'Petar' AND pp.prezime = 'Petrovic' AND YEAR(rz.datum_rezervacije) = 2019

--Prikazati broj rezervacija za svaku predstavu, ukoliko je taj broj veći od 5. Rezultate sortirati opadajuće
--(Stavio sam od 3, jer nema predstava sa vise od 5 rezervacija)
SELECT pr.ime_predstave, COUNT(rz.jedinstveni_broj_rezervacije) AS broj_rezervacija
FROM rezervacija AS rz
INNER JOIN predstava AS pr ON rz.predstava_id = pr.predstava_id
GROUP BY pr.ime_predstave
HAVING broj_rezervacija > 3
ORDER BY broj_rezervacija DESC

--Prikazati informacije o predstavi koja je napravila maksimalnu zaradu, ukoliko ima više
--poredstava koje su napravile maksimalnu zaradu prikazati ih sve.
SELECT pr.ime_predstave, SUM(rz.iznos_za_placanje) AS ukupna_zarada 
FROM rezervacija AS rz
LEFT JOIN predstava AS pr ON rz.predstava_id = pr.predstava_id
GROUP BY rz.predstava_id
HAVING ukupna_zarada = (SELECT MAX(ukupno) 
                          FROM (
                          	SELECT SUM(rz.iznos_za_placanje) AS ukupno FROM rezervacija AS rz
                            GROUP BY rz.predstava_id
                          ) AS sub)