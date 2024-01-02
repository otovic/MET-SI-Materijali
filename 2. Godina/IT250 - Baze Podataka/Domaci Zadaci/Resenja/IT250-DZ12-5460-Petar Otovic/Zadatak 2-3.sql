SELECT COUNT(overa.ocena) as broj_ocena, overa.predmet_id FROM predmet
INNER JOIN overa ON predmet.predmet_id = overa.predmet_id
WHERE overa.ocena = 5
GROUP BY overa.predmet_id
ORDER BY broj_ocena DESC