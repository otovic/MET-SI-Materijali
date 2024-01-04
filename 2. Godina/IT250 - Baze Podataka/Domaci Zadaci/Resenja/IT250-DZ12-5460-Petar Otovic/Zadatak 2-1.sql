SELECT student.indeks, student.ime, student.prezime, predmet.naziv, overa.ocena FROM student 
INNER JOIN overa ON student.indeks = overa.indeks
INNER JOIN predmet ON overa.predmet_id = predmet.predmet_id
WHERE overa.ocena > 5 AND overa.predmet_id = 'CS101'